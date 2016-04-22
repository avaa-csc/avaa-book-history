/**
 * 
 */
package fi.csc.avaa.khl.tabs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.chart.YearDistributionChartWrapper;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.map.MapWrapper;
import fi.csc.avaa.khl.results.AuthorSelectionWindow;
import fi.csc.avaa.khl.results.PlaceOfPrintingSelectionWindow;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.NumberTools;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.HorizontalKeyComponentValue;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class FrontPage extends CustomComponent {

	private static final long serialVersionUID = 1L;
	private LiferayIPC ipc;
	private Translator translator;
	private ResultStats allStats;
	private YearDistributionChartWrapper chartWrapper;
	private SearchTools search;
	private boolean mapExpanded;
	private GridLayout baseLayout;
	private MapWrapper map;
	private HorizontalLayout totalStats;
	private VerticalLayout yearSearch;
	private Panel authorSearch;
	private HorizontalLayout categorySearch;
	private Button mapResizeButton;
	private Panel placeOfPrintingSearch;

	/**
	 * 
	 */
	public FrontPage(LiferayIPC ipc, Translator translator, ResultStats allStats, SearchTools search) {
		this.ipc = ipc;
		this.translator = translator;
		this.allStats = allStats;
		chartWrapper = new YearDistributionChartWrapper(translator);
		this.search = search;
		
		map = new MapWrapper();
		mapResizeButton = VaadinTools.createLinkButton(translator.localize("Application.Map.Button.Expand"), FontAwesome.ANGLE_DOUBLE_LEFT,  null, null);
		mapResizeButton.addClickListener(e -> {
			toggleLayout();
		});
		map.addComponent(mapResizeButton);
		map.setStyleName("map-wrapper");
		map.setNewMapIframe(MapWrapper.TabType.FRONT, allStats, this.translator, null);
		
		baseLayout = new GridLayout(9, 5);
		baseLayout.setMargin(true);
		baseLayout.setSpacing(true);
		baseLayout.setSizeFull();
		baseLayout.setResponsive(true);
		totalStats = getTotalStats();
		yearSearch = getYearSearch();
		authorSearch = getAuthorSearch();
		placeOfPrintingSearch = getPlaceOfPrintingSearch();
		categorySearch = getCategorySearch();
		mapExpanded = false;
		doLayout(mapExpanded);
		setCompositionRoot(baseLayout);
	}

	private void toggleLayout() {
		baseLayout.removeAllComponents();
		if (mapExpanded) {
			mapResizeButton.setIcon(FontAwesome.ANGLE_DOUBLE_LEFT);
			mapResizeButton.setCaption(translator.localize("Application.Map.Button.Expand"));
			mapExpanded = false;
		}
		else {
			mapResizeButton.setIcon(FontAwesome.ANGLE_DOUBLE_RIGHT);
			mapResizeButton.setCaption(translator.localize("Application.Map.Button.Narrow"));
			mapExpanded = true;
		}
		doLayout(mapExpanded);
	}

	private void doLayout(boolean expand) {
		if (expand) {
			baseLayout.addComponent(totalStats, 0, 0, 3, 0);
			baseLayout.addComponent(yearSearch, 0, 1, 3, 1);
			baseLayout.addComponent(authorSearch, 0, 2, 3, 2);
			baseLayout.addComponent(placeOfPrintingSearch, 0, 3, 3, 3);
			baseLayout.addComponent(categorySearch, 0, 4, 3, 4);
			baseLayout.addComponent(map, 4, 0, 8, 4);
		} else {
			baseLayout.addComponent(totalStats, 0, 0, 5, 0);
			baseLayout.addComponent(yearSearch, 0, 1, 5, 1);
			baseLayout.addComponent(authorSearch, 0, 2, 5, 2);
			baseLayout.addComponent(placeOfPrintingSearch, 0, 3, 5, 3);
			baseLayout.addComponent(categorySearch, 0, 4, 5, 4);
			baseLayout.addComponent(map, 6, 0, 8, 4);

		}
	}
	
	private HorizontalLayout getTotalStats() {
		HorizontalLayout totStatsRow = new HorizontalLayout();
		totStatsRow.setMargin(true);
		totStatsRow.setSizeFull();
		Label titleTotalAmt = new Label(translator.localize("Amount.Title") + ": <b>" + allStats.getTotalResultAmount() + "</b>", ContentMode.HTML);
		Button searchAllBtn = VaadinTools.createButton(translator.localize("Application.SearchAll"), FontAwesome.BOOK, null, null);
		searchAllBtn.addClickListener(e -> {
			QueryBean bean = new QueryBean(true);
			search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
			ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, bean.getFieldsAsString());
		});
		Label authorTotalAmt = new Label(translator.localize("Amount.Author") + ": <b>" + allStats.getTotalAuthorAmount() + "</b>", ContentMode.HTML);
		totStatsRow.addComponents(titleTotalAmt, authorTotalAmt, searchAllBtn);
		return totStatsRow;
	}

	private HorizontalLayout getCategorySearch() {
		HorizontalLayout catSearchRow = new HorizontalLayout();
		catSearchRow.setSpacing(true);
		catSearchRow.setMargin(false);
		catSearchRow.setSizeFull();
		catSearchRow.setResponsive(true);
		Panel langSearchContainer = new Panel(translator.localize(Const.languageKey));
		Panel publicationTypeSearchContainer = new Panel(translator.localize(Const.publicationTypeKey));
		Panel mappingTargetSearchContainer = new Panel(translator.localize(Const.mappingTargetKey));
		catSearchRow.addComponents(langSearchContainer, publicationTypeSearchContainer, mappingTargetSearchContainer);
		
		Comparator<Entry<String, Integer>> cmp = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		};
		
		List<Entry<String, Integer>> allLangEntries = new LinkedList<>(allStats.getLanguageAmounts().entrySet());
		List<Entry<String, Integer>> allPubTypeEntries = new LinkedList<>(allStats.getPublicationTypeAmounts().entrySet());
		List<Entry<String, Integer>> allMapTgtEntries = new LinkedList<>(allStats.getMappingTargetAmounts().entrySet());
		
		Collections.sort(allLangEntries, cmp);
		Collections.sort(allPubTypeEntries, cmp);
		Collections.sort(allMapTgtEntries, cmp);
		
		Map<String, Integer> sortedLangEntries = new LinkedHashMap<>();
		Map<String, Integer> sortedPubTypeEntries = new LinkedHashMap<>();
		Map<String, Integer> sortedMapTgtEntries = new LinkedHashMap<>();
		
		Iterator<Entry<String, Integer>> langIt = allLangEntries.iterator();
		while(langIt.hasNext()) {
			Entry<String, Integer> entry = langIt.next();
			sortedLangEntries.put(entry.getKey(), entry.getValue());
		}
		Iterator<Entry<String, Integer>> pubIt = allPubTypeEntries.iterator();
		while(pubIt.hasNext()) {
			Entry<String, Integer> entry = pubIt.next();
			sortedPubTypeEntries.put(entry.getKey(), entry.getValue());
		}
		Iterator<Entry<String, Integer>> mapIt = allMapTgtEntries.iterator();
		while(mapIt.hasNext()) {
			Entry<String, Integer> entry = mapIt.next();
			sortedMapTgtEntries.put(entry.getKey(), entry.getValue());
		}
		
		VerticalLayout langLayout = getCategoryLayout(sortedLangEntries, Const.PREFIX_LANGUAGE, "multiline language-link");
		VerticalLayout pubTypeLayout = getCategoryLayout(sortedPubTypeEntries, Const.PREFIX_PUBLICATIONTYPE, "multiline publication-link");
		VerticalLayout mapTargetLayout = getCategoryLayout(sortedMapTgtEntries, Const.PREFIX_MAPPINGTARGET, "multiline mapping-link");
		
		langSearchContainer.setContent(langLayout);
		publicationTypeSearchContainer.setContent(pubTypeLayout);
		mappingTargetSearchContainer.setContent(mapTargetLayout);
		
		return catSearchRow;
	}
	
	private VerticalLayout getCategoryLayout(Map<String, Integer> categoryMap, String localizationPrefix, String linkStyle) {
		VerticalLayout catLayout = new VerticalLayout();
		catLayout.setMargin(true);
		for(Map.Entry<String, Integer> catEntry : categoryMap.entrySet()) {
			String translationKey = catEntry.getKey();
			String linkText = translator.localize(localizationPrefix + translationKey);
			NativeButton catLink = VaadinTools.createLinkNativeButton(linkText, null, null, linkStyle);
			catLink.addClickListener(e -> {
				QueryBean bean = new QueryBean(true);
				if(Const.PREFIX_LANGUAGE.equals(localizationPrefix)) {
					if(Const.UNKNOWN_KEY.equals(translationKey)) {
						bean.setLanguage(Const.STRING_EMPTY);
					} else {
						bean.setLanguage(translationKey);
					}
				} else if(Const.PREFIX_MAPPINGTARGET.equals(localizationPrefix)) {
					if(Const.UNKNOWN_KEY.equals(translationKey)) {
						bean.setMappingTarget(Const.STRING_EMPTY);
					} else {
						bean.setMappingTarget(translationKey);
					}
				} else if(Const.PREFIX_PUBLICATIONTYPE.equals(localizationPrefix)) {
					if(Const.UNKNOWN_KEY.equals(translationKey)) {
						bean.setPublicationType(Const.STRING_EMPTY);
					} else {
						bean.setPublicationType(translationKey);
					}
				}
				search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
				ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED , bean.getFieldsAsString());
			});
			HorizontalKeyComponentValue row = new HorizontalKeyComponentValue(catLink, 3.0f, String.valueOf(catEntry.getValue()), 1.0f, true, linkStyle, "", null);
			catLayout.addComponent(row);
		}
		return catLayout;
	}

	private Panel getAuthorSearch() {
		Panel authorSearchContainer = new Panel(translator.localize("Search.Authors"));
		authorSearchContainer.setResponsive(true);
		authorSearchContainer.setImmediate(true);
		HorizontalLayout authorRow = new HorizontalLayout();
		authorRow.setMargin(true);
		authorRow.setSizeFull();
		for (char authorInitial : Const.ALPHABETS) {
			if (allStats.getAuthorBookAmountsByLetter().get(authorInitial) != null && allStats.getAuthorBookAmountsByLetter().get(authorInitial).size() > 0) {
				NativeButton authorLink = VaadinTools.createLinkNativeButton(String.valueOf(authorInitial), null, getTooltipAuthorList(authorInitial, 20), "author-link");
				authorLink.addClickListener(e -> {
					UI.getCurrent().addWindow(new AuthorSelectionWindow(String.valueOf(authorInitial), ipc, translator, allStats, search));
				});
				authorRow.addComponent(authorLink);
				authorRow.setExpandRatio(authorLink, 1.0f);
			}
		}
		NativeButton noAuthorLink = VaadinTools.createLinkNativeButton(translator.localize("Search.NoAuthor"), null, String.valueOf(allStats.getAuthorBookAmountsByLetter().get(Const.EMPTY_STAT_CHAR).get(Const.UNKNOWN_KEY)), "author-link");
		noAuthorLink.addClickListener(e -> {
			QueryBean bean = new QueryBean(true);
			bean.setSearchStr1(Const.STRING_EMPTY);
			bean.setSearchStr1WildcardFilter(Const.wordKey);
			bean.setSearchStr1FieldFilter(Const.authorKey);
			search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
			ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, bean.getFieldsAsString());
		});
		authorRow.addComponent(noAuthorLink);
		authorRow.setExpandRatio(noAuthorLink, 4.0f);
		authorSearchContainer.setContent(authorRow);
		return authorSearchContainer;
	}
	
	private Panel getPlaceOfPrintingSearch() {
		Panel placeOfPrintingSearchContainer = new Panel(translator.localize("Search.PlacesOfPrinting"));
		placeOfPrintingSearchContainer.setResponsive(true);
		placeOfPrintingSearchContainer.setImmediate(true);
		HorizontalLayout placeOfPrintingRow = new HorizontalLayout();
		placeOfPrintingRow.setMargin(true);
		placeOfPrintingRow.setSizeFull();
		for (char placeOfPrintingInitial : Const.ALPHABETS) {
			if (allStats.getPlaceOfPrintingBookAmountsByLetter().get(placeOfPrintingInitial) != null && allStats.getPlaceOfPrintingBookAmountsByLetter().get(placeOfPrintingInitial).size() > 0) {
				NativeButton placeOfPrintingLink = VaadinTools.createLinkNativeButton(String.valueOf(placeOfPrintingInitial), null, getTooltipPlaceOfPrintingList(placeOfPrintingInitial, 20), "author-link");
				placeOfPrintingLink.addClickListener(e -> {
					UI.getCurrent().addWindow(new PlaceOfPrintingSelectionWindow(String.valueOf(placeOfPrintingInitial), ipc, translator, allStats, search));
				});
				placeOfPrintingRow.addComponent(placeOfPrintingLink);
				placeOfPrintingRow.setExpandRatio(placeOfPrintingLink, 1.0f);
			}
		}
		NativeButton noPlaceOfPrintingLink = VaadinTools.createLinkNativeButton(translator.localize("Search.NoPlaceOfPrinting"), null, String.valueOf(allStats.getPlaceOfPrintingBookAmountsByLetter().get(Const.EMPTY_STAT_CHAR).get(Const.UNKNOWN_KEY)), "author-link");
		noPlaceOfPrintingLink.addClickListener(e -> {
			QueryBean bean = new QueryBean(true);
			bean.setSearchStr1(Const.STRING_EMPTY);
			bean.setSearchStr1WildcardFilter(Const.wordKey);
			bean.setSearchStr1FieldFilter(Const.placeOfPrintingKey);
			search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
			ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, bean.getFieldsAsString());
		});
		placeOfPrintingRow.addComponent(noPlaceOfPrintingLink);
		placeOfPrintingRow.setExpandRatio(noPlaceOfPrintingLink, 4.0f);
		placeOfPrintingSearchContainer.setContent(placeOfPrintingRow);
		return placeOfPrintingSearchContainer;
	}
	
	private String getTooltipAuthorList(char authorInitial, int maxListSize) {
		StringBuffer tooltip = new StringBuffer("<table cellspacing='0' cellpadding='0' style='border: none;'>");
		int i=0;
		Set<Entry<String, Integer>> entries = allStats.getAuthorBookAmountsByLetter().get(authorInitial).entrySet();
		for(Map.Entry<String, Integer> authorAmtEntry : entries) {
			i++;
			String author = authorAmtEntry.getKey();
			int amt = authorAmtEntry.getValue();
			tooltip.append("<tr><td colspan='2'>" + author + "</td><td style='padding-left:10px'>" + amt + "</td></tr>");
			if(i >= maxListSize) {
				break;
			}
		}
		if(i < entries.size()) {
			tooltip.append("<tr><td colspan='3'>....</td></tr>");
		}
		tooltip.append("</table>");
		return tooltip.toString();
	}

	private String getTooltipPlaceOfPrintingList(char placeOfPrintingInitial, int maxListSize) {
		StringBuffer tooltip = new StringBuffer("<table cellspacing='0' cellpadding='0' style='border: none;'>");
		int i = 0;
		Map<String, Integer> map = allStats.getPlaceOfPrintingBookAmountsByLetter().get(placeOfPrintingInitial);
		if (map != null) {
			Set<Entry<String, Integer>> entries = map.entrySet();
			for (Map.Entry<String, Integer> placeOfPrintingAmtEntry : entries) {
				i++;
				String author = placeOfPrintingAmtEntry.getKey();
				int amt = placeOfPrintingAmtEntry.getValue();
				tooltip.append("<tr><td colspan='2'>" + author + "</td><td style='padding-left:10px'>" + amt + "</td></tr>");
				if (i >= maxListSize) {
					break;
				}
			}
			if (i < entries.size()) {
				tooltip.append("<tr><td colspan='3'>....</td></tr>");
			}
			tooltip.append("</table>");
			return tooltip.toString();
		}
		else {
			return null;
		}
	}

	private VerticalLayout getYearSearch() {
		VerticalLayout baseLayout = new VerticalLayout();
		baseLayout.setSpacing(true);
		baseLayout.setMargin(true);
		baseLayout.setSizeFull();
		baseLayout.setStyleName("year-search-layout");
		
		HorizontalLayout searchRow = new HorizontalLayout();
		searchRow.setSizeFull();
		
		Label searchLabel = new Label("<p><span style='font-size: 18px'>" + translator.localize("YearSearch.FrontPage.Label.Header") + "</span><br>" + translator.localize("YearSearch.FrontPage.Label.Text"), ContentMode.HTML);
		
		HorizontalLayout yearSearchFields = new HorizontalLayout();
		yearSearchFields.setSizeUndefined();
		yearSearchFields.setSpacing(true);
		yearSearchFields.setResponsive(true);
		TextField fromYearField = VaadinTools.createTextField(50, translator.localize("YearSearch.From"), 4, false, null);
		TextField toYearField = VaadinTools.createTextField(50, translator.localize("YearSearch.To"), 4, false, null);
		Button searchBtn = VaadinTools.createButton(translator.localize("YearSearch.Search"), FontAwesome.SEARCH, null, null);
		searchBtn.addClickListener(e -> {
			if (!StringTools.isEmptyOrNull(toYearField.getValue()) || !StringTools.isEmptyOrNull(fromYearField.getValue())) {
				if (NumberTools.isInteger(fromYearField.getValue()) || NumberTools.isInteger(toYearField.getValue())) {
					int fromYear = NumberTools.isInteger(fromYearField.getValue()) ? Integer.parseInt(fromYearField.getValue()) : Const.YEAR_NOT_SET;
					int toYear = NumberTools.isInteger(toYearField.getValue()) ? Integer.parseInt(toYearField.getValue()) : Const.YEAR_NOT_SET;

					QueryBean bean = new QueryBean(true);
					boolean isOK = false;
					if (fromYear >= 0 && toYear >= 0) {
						if (fromYear <= toYear) {
							isOK = true;
							bean.setFromYear(fromYear);
							bean.setToYear(toYear);
						}
					} else if (fromYear > 0) {
						isOK = true;
						bean.setFromYear(fromYear);
					} else if (toYear > 0) {
						isOK = true;
						bean.setToYear(toYear);
					}
					if (isOK) {
						search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
						ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, bean.getFieldsAsString());
					} else {
						VaadinTools.showWarning(translator.localize("YearSearch.Error.Range"), null);
					}
				} else {
					VaadinTools.showWarning(translator.localize("YearSearch.Error.Format"), null);
				}
			} else {
				VaadinTools.showWarning(translator.localize("YearSearch.Error.Empty"), null);
			}
		});
		
		yearSearchFields.addComponents(fromYearField, new Label("-"), toYearField, searchBtn);
		
		searchRow.addComponent(searchLabel);
		searchRow.addComponent(yearSearchFields);
		searchRow.setComponentAlignment(yearSearchFields, Alignment.MIDDLE_RIGHT);
		
		baseLayout.addComponent(searchRow);
		chartWrapper.setNewChart(allStats);
		baseLayout.addComponent(chartWrapper.getCurrentChart());
		return baseLayout;
	}
}

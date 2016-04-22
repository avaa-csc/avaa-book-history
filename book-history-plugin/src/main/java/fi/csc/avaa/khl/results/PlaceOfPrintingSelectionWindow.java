package fi.csc.avaa.khl.results;

import java.util.ArrayList;
import java.util.Map;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.vaadin.customcomponent.HorizontalKeyComponentValue;
import fi.csc.avaa.tools.vaadin.customcomponent.ItemDetailsWindow;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

public class PlaceOfPrintingSelectionWindow extends ItemDetailsWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LiferayIPC ipc;
	private String firstCharacter;
	private ResultStats allStats;
	private SearchTools searchTools;

	public PlaceOfPrintingSelectionWindow(String firstCharacter, LiferayIPC ipc, Translator translator, ResultStats allStats, SearchTools search) {
		super(translator, 700, 500, true, true, true);
		this.ipc = ipc;
		this.firstCharacter = firstCharacter;
		this.allStats = allStats;
		this.searchTools = search;
		setCaption(translator.localize("Search.Authors.Initial.Letter") + " " + this.firstCharacter);
		baseLayout.setSpacing(true);
		init();
	}

	@Override
	protected void init() {
		Label c = new Label(translator.localize("Search.PlaceOfPrinting.Initial.Letter") + " " + this.firstCharacter);
		baseLayout.addComponent(c);
		int totalAmount = 0;
		ArrayList<HorizontalKeyComponentValue> list = new ArrayList<HorizontalKeyComponentValue>();
		Map<String, Integer> map = allStats.getPlaceOfPrintingBookAmountsByLetter().get(firstCharacter.charAt(0));
		if (map != null) {
			for (Map.Entry<String, Integer> placeOfPrintingAmtEntry : map.entrySet()) {
				String placeOfPrinting = placeOfPrintingAmtEntry.getKey();
				int amt = placeOfPrintingAmtEntry.getValue();
				totalAmount += amt;
				NativeButton catLink = VaadinTools.createLinkNativeButton(placeOfPrinting, null, null, "publication-link");
				catLink.addClickListener(new PlaceOfPrintingClickListener(placeOfPrinting, Const.wordKey));
				list.add(new HorizontalKeyComponentValue(catLink, 3.0f, String.valueOf(amt), 1.0f, true, "publication-link", "", null));
			}
		}
		list.add(0, getAllPlaceOfPrintingsRow(totalAmount));
		for (HorizontalKeyComponentValue row : list) {
			baseLayout.addComponent(row);
		}
	}

	private HorizontalKeyComponentValue getAllPlaceOfPrintingsRow(int totalAmount) {
		NativeButton firstLink = VaadinTools.createLinkNativeButton(firstCharacter + "*", null, null, "publication-link");
		firstLink.addClickListener(new PlaceOfPrintingClickListener(firstCharacter, Const.wordAstKey));
		return new HorizontalKeyComponentValue(firstLink, 3.0f, String.valueOf(totalAmount), 1.0f, true, "publication-link", "", null);
	}

	private class PlaceOfPrintingClickListener implements ClickListener {
		private static final long serialVersionUID = 1L;
		private String placeOfPrinting;
		private String filter;

		public PlaceOfPrintingClickListener(String placeOfPrinting, String filter) {
			this.placeOfPrinting = placeOfPrinting;
			this.filter = filter;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			QueryBean bean = new QueryBean(true);
			bean.setSearchStr1(placeOfPrinting);
			bean.setSearchStr1WildcardFilter(filter);
			bean.setSearchStr1FieldFilter(Const.placeOfPrintingKey);
			searchTools.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), bean, false);
			ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, bean.getFieldsAsString());
			close();
		}
	}
}

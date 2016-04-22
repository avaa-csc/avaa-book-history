/**
 * 
 */
package fi.csc.avaa.khl.tabs;

import java.util.Collection;
import java.util.Properties;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.chart.YearDistributionChartWrapper;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.csv.VanhatkirjatCSVFieldsWindow;
import fi.csc.avaa.khl.map.MapWrapper;
import fi.csc.avaa.khl.results.GridBean;
import fi.csc.avaa.khl.results.KirjakartoitusPublicGrid;
import fi.csc.avaa.khl.results.KirjakartoitusResultControlRow;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.khl.search.SearchFormWrapper;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.search.result.ResultGridWrapper;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class SearchPage extends CustomComponent implements Reconstructible {

	private static final long serialVersionUID = 1L;

	private ResultGridWrapper<GridBean, CompleteVanhatkirjat> resultGridWrapper;
	private MapWrapper mapWrapper;
	private YearDistributionChartWrapper chartWrapper;
	private Translator translator;
	private LiferayIPC ipc;
	private SearchTools search;
	private Collection<CompleteVanhatkirjat> searchResults;
	private QueryBean queryBean;
	private SearchFormWrapper searchFormWrapper;
	private KirjakartoitusResultControlRow resultControlRow;

	private GridLayout baseLayout;

	private boolean mapExpanded;

	private Button mapResizeButton;

	public SearchPage(LiferayIPC ipc, Translator translator, ResultStats allStats, SearchTools search) {
		mapExpanded = false;
		this.ipc = ipc;
		this.translator = translator;
		this.search = search;
		mapWrapper = new MapWrapper();
		mapResizeButton = VaadinTools.createLinkButton(translator.localize("Application.Map.Button.Expand"), FontAwesome.ANGLE_DOUBLE_LEFT, null, null);
		mapResizeButton.addClickListener(e -> {
			toggleLayout();
		});
		mapResizeButton.setVisible(false);
		mapWrapper.addComponent(mapResizeButton);
		chartWrapper = new YearDistributionChartWrapper(this.translator);
		searchFormWrapper = new SearchFormWrapper(translator, allStats, this.ipc, this.search, CompleteVanhatkirjatCache.getPublicBooksCacheValues(), Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, this, false);
		searchFormWrapper.setMargin(new MarginInfo(true, false, false, false));
		resultControlRow = new KirjakartoitusResultControlRow(translator);

		baseLayout = new GridLayout(3, 10);
		baseLayout.setMargin(true);
		baseLayout.setSpacing(true);
		baseLayout.setSizeFull();
		baseLayout.setResponsive(true);
		doLayout(false);

		setIPCListeners();
		setCompositionRoot(baseLayout);
	}

	public void processSearchResults(Collection<CompleteVanhatkirjat> results, ResultStats resultStats, QueryBean queryBean) {
		searchResults = results;
		this.queryBean = queryBean;
		if (queryBean.populateSearchFields()) {
			searchFormWrapper.populateFields(queryBean);
		}
		KirjakartoitusPublicGrid grid = new KirjakartoitusPublicGrid(translator);
		resultGridWrapper = new ResultGridWrapper<>(grid, resultControlRow);
		resultGridWrapper.getCurrentGrid().populateGrid(searchResults);
		resultGridWrapper.getCurrentControlRow().setCsvFieldsWindow(new VanhatkirjatCSVFieldsWindow(translator, searchResults));
		resultGridWrapper.getCurrentControlRow().createNewContents(searchResults, queryBean);
		if (searchResults != null && searchResults.size() > 0) {
			mapWrapper.removeComponent(mapResizeButton);
			mapWrapper.addComponent(mapResizeButton, 0);
			mapResizeButton.setVisible(true);
			mapWrapper.setNewMapIframe(MapWrapper.TabType.SEARCH, resultStats, this.translator, queryBean);
			chartWrapper.setNewChart(resultStats);
		} else {
			mapWrapper.removeAllComponents();
			chartWrapper.removeAllComponents();
		}
		setLayoutMapNarrowed();
	}

	@Override
	public void clean() {
		if (resultGridWrapper != null) {
			baseLayout.removeComponent(resultGridWrapper);
			chartWrapper.removeAllComponents();
			mapWrapper.removeAllComponents();
		}
	}

	@Override
	public void init() {
	}

	@Override
	public boolean hasPendingModifications() {
		return false;
	}

	@Override
	public void refresh() {
	}

	private void toggleLayout() {
		if (mapExpanded) {
			setLayoutMapNarrowed();
		} else {
			setLayoutMapExpanded();
		}
	}

	private void setLayoutMapExpanded() {
		mapResizeButton.setIcon(FontAwesome.ANGLE_DOUBLE_RIGHT);
		mapResizeButton.setCaption(translator.localize("Application.Map.Button.Narrow"));
		mapExpanded = true;
		doLayout(true);
	}

	private void setLayoutMapNarrowed() {
		mapResizeButton.setIcon(FontAwesome.ANGLE_DOUBLE_LEFT);
		mapResizeButton.setCaption(translator.localize("Application.Map.Button.Expand"));
		mapExpanded = false;
		doLayout(false);
	}

	private void doLayout(boolean expandMap) {
		baseLayout.removeAllComponents();
		if (expandMap) {
			baseLayout.addComponent(mapWrapper, 0, 0, 2, 9); // exploit the whole grid
		} else {
			baseLayout.addComponent(searchFormWrapper, 0, 0, 1, 0);
			baseLayout.addComponent(mapWrapper, 2, 0, 2, 7);
			baseLayout.addComponent(chartWrapper, 2, 9, 2, 9);
			if (resultGridWrapper != null) {
				baseLayout.addComponent(resultGridWrapper, 0, 1, 1, 9);
			}
		}
	}

	private void setIPCListeners() {
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_FILTER_MUNICIPALITY, e -> {
			if (e.getData() != null) {
				Properties ipcData = StringTools.getStringAsProperties(e.getData(), ",", ":");
				QueryBean queryBean = new QueryBean(false);
				queryBean.setMunicipality(ipcData.getProperty(Const.IPC_DATA_MUNICIPALITY));
				search.queryData(searchResults, queryBean, Boolean.parseBoolean(ipcData.getProperty(Const.IPC_DATA_USE_NEW_MUNICIPALITY)));
				resultGridWrapper.populateGridWithItems(search.getSearchResults());
				resultGridWrapper.getCurrentControlRow().createNewContents(search.getSearchResults(), queryBean);
				ResultStats stats = new ResultStats(search.getSearchResults());
				stats.populateStats(false, false, true, true, false, true, false);
				chartWrapper.setNewChart(stats);
				if(mapExpanded) {
					toggleLayout();
				}
			}
		});

		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_FILTER_MUNICIPALITY_MAPPING_TARGETS, e -> {
			if (e.getData() != null) {
				Properties ipcData = StringTools.getStringAsProperties(e.getData(), ",", ":");
				QueryBean queryBean = new QueryBean(false);
				queryBean.setMunicipality(ipcData.getProperty(Const.IPC_DATA_MUNICIPALITY));
				queryBean.setMappingTarget(ipcData.getProperty(Const.IPC_DATA_MAPPING_TARGET).equals(Const.UNKNOWN_KEY) ? Const.STRING_EMPTY : ipcData.getProperty(Const.IPC_DATA_MAPPING_TARGET));
				search.queryData(searchResults, queryBean, false);
				resultGridWrapper.populateGridWithItems(search.getSearchResults());
				resultGridWrapper.getCurrentControlRow().createNewContents(search.getSearchResults(), queryBean);
				ResultStats stats = new ResultStats(search.getSearchResults());
				stats.populateStats(false, false, true, true, false, true, false);
				chartWrapper.setNewChart(stats);
				if(mapExpanded) {
					toggleLayout();
				}
			}
		});

		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_RESET_MAP_FILTER, e -> {
			resultGridWrapper.populateGridWithItems(searchResults);
			resultGridWrapper.getCurrentControlRow().createNewContents(searchResults, queryBean);
			ResultStats stats = new ResultStats(searchResults);
			stats.populateStats(false, false, true, true, false, true, false);
			chartWrapper.setNewChart(stats);
		});
	}

}

/**
 * 
 */
package fi.csc.avaa.khl.admin.tabs;

import java.util.List;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.csv.VanhatkirjatCSVFieldsWindow;
import fi.csc.avaa.khl.results.GridBean;
import fi.csc.avaa.khl.results.KirjakartoitusAdminModifyGrid;
import fi.csc.avaa.khl.results.KirjakartoitusResultControlRow;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.khl.search.SearchFormWrapper;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.search.result.ResultGridWrapper;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class ModifyItemsPage extends CustomComponent implements Reconstructible {

	private static final long serialVersionUID = 1L;
	private VerticalLayout baseLayout;
	private Translator translator;
	private SearchFormWrapper searchFormWrapper;
	private ResultGridWrapper<GridBean, CompleteVanhatkirjat> modifyGridWrapper;
	private KirjakartoitusResultControlRow resultControlRow;
	private LiferayIPC ipc;
	private ResultStats allStats;
	private SearchTools search;
	private VerticalLayout gridLayout;
	
	public ModifyItemsPage(LiferayIPC ipc, Translator translator, ResultStats allStats, SearchTools search) {
		this.ipc = ipc;
		this.translator = translator;
		this.allStats = allStats;
		this.search = search;
		this.resultControlRow = new KirjakartoitusResultControlRow(translator);
		init();
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_ADMIN_MODIFY_SEARCH_COMPLETED, e -> {
			gridLayout.removeAllComponents();
			List<CompleteVanhatkirjat> searchResults = search.getSearchResults();
			KirjakartoitusAdminModifyGrid modifyGrid = new KirjakartoitusAdminModifyGrid(translator, this);
			modifyGridWrapper = new ResultGridWrapper<>(modifyGrid, resultControlRow);
			modifyGridWrapper.setMargin(true);
			modifyGridWrapper.getCurrentGrid().populateGrid(searchResults);
			modifyGridWrapper.getCurrentControlRow().setCsvFieldsWindow(new VanhatkirjatCSVFieldsWindow(translator, searchResults));
			modifyGridWrapper.getCurrentControlRow().createNewContents(modifyGrid.getCVKsInGrid(), new QueryBean(e.getData()));
			gridLayout.addComponent(modifyGridWrapper);
		});
	}

	@Override
	public void clean() {
		gridLayout.removeAllComponents();
	}

	public void init() {
		searchFormWrapper = new SearchFormWrapper(this.translator, this.allStats, this.ipc, this.search, CompleteVanhatkirjatCache.getAdminBooksCacheValues(), Const.IPC_EVENT_ADMIN_MODIFY_SEARCH_COMPLETED, this, true);
		searchFormWrapper.setMargin(true);

		gridLayout = new VerticalLayout();
		gridLayout.setSpacing(true);
		gridLayout.setSizeFull();

		baseLayout = new VerticalLayout();
		baseLayout.setSpacing(true);
		baseLayout.setSizeFull();
		baseLayout.addComponents(searchFormWrapper, gridLayout);

		setCompositionRoot(baseLayout);
	}

	@Override
	public boolean hasPendingModifications() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		searchFormWrapper.searchRefresh();
	}
}

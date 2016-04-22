/**
 * 
 */
package fi.csc.avaa.khl.admin;

import java.util.Collection;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.BatchUpdatePage;
import fi.csc.avaa.khl.admin.tabs.CSVPage;
import fi.csc.avaa.khl.admin.tabs.ModifyItemsPage;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.admin.tabs.ReviewPage;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class EditContent extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private HorizontalLayout progLayout = new HorizontalLayout();
	private ProgressBar pBar;
	
	public static CompleteVanhatkirjatCache cache;
	public Translator translator;
	private ResultStats allStats;
	private TabSheet tabs;
	private ReviewPage reviewPage;
	private ModifyItemsPage modifyItemsPage;
	private BatchUpdatePage batchUpdatePage;
	private CSVPage csvPage;

	private LiferayIPC ipc;

	private SearchTools search;

	private Reconstructible currentTab;

	private boolean ignoreTabChangeEvent;
	
	public EditContent(VaadinRequest request, LiferayIPC ipc, Translator translator) {
		this.ipc = ipc;
		this.translator = translator;
		this.search = new SearchTools(true);
		progLayout.setSpacing(true);
		pBar = new ProgressBar();
		pBar.setIndeterminate(true);
		pBar.setEnabled(false);
		Label status = new Label(this.translator.localize("Application.Loading"));
		status.setWidth(100, Unit.PERCENTAGE);
		progLayout.addComponent(status);
		progLayout.addComponent(pBar);
		
		addComponent(progLayout);
		setWidth(100, Unit.PERCENTAGE);
		setSpacing(true);
		
		UI.getCurrent().setPollInterval(100);
		Worker worker = new Worker();
		worker.start();
	}
	
	private TabSheet getTabSheet(String caption) {
		TabSheet tabSheet = new TabSheet();
		if (caption != null) {
			tabSheet.setCaption(caption);
			tabSheet.setCaptionAsHtml(true);
		}
		tabSheet.setImmediate(true);
		tabSheet.setTabCaptionsAsHtml(false);
		tabSheet.setStyleName("tab-navigation");
		tabSheet.setResponsive(true);
		tabSheet.addSelectedTabChangeListener(event -> {
			if (ignoreTabChangeEvent) {
				ignoreTabChangeEvent = false;
			} else {
				Reconstructible reconstructibleTab = (Reconstructible) tabSheet.getSelectedTab();
				if (currentTab != null && currentTab.hasPendingModifications()) {
					ConfirmDialog.show(UI.getCurrent(), translator.localize("Modify.Exit.Confirm.Header"), translator.localize("Modify.Exit.Confirm"), translator.localize("Modify.Exit.Confirm.Yes"), translator.localize("Modify.Exit.Confirm.No"), new ConfirmDialog.Listener() {
						private static final long serialVersionUID = 1L;

						public void onClose(ConfirmDialog dialog) {
							if (dialog.isConfirmed()) {
								ignoreTabChangeEvent = true; // ignore event raised by the next select
								tabSheet.setSelectedTab((Component) currentTab);
							} else {
								currentTab = reconstructibleTab;
								currentTab.init();
							}
						}
					});
				} else {
					currentTab = reconstructibleTab;
					currentTab.init();
				}
			}
		});

		return tabSheet;
	}
	
	public void createMainContent() {
    	tabs = getTabSheet(translator.localize("Application.Name"));
    	
    	reviewPage = new ReviewPage(translator);
    	tabs.addTab(reviewPage, translator.localize("Tab.Caption.ReviewPage"));
    	
    	modifyItemsPage = new ModifyItemsPage(ipc, translator, allStats, search);
    	tabs.addTab(modifyItemsPage, translator.localize("Tab.Caption.ModifyItemsPage"));
    	
    	batchUpdatePage = new BatchUpdatePage(ipc, translator, search);
    	tabs.addTab(batchUpdatePage, translator.localize("Tab.Caption.BatchUpdatePage"));
    	
    	csvPage = new CSVPage(translator);
    	tabs.addTab(csvPage, translator.localize("Tab.Caption.CsvPage"));
    	
    	addComponents(tabs);
    }
	
	private class Worker extends Thread {
		
		@Override
		public void run() {
			UI.getCurrent().getSession().getLockInstance().lock();
			try {
				CompleteVanhatkirjatCache.initCache();
				Collection<CompleteVanhatkirjat> allBooks = CompleteVanhatkirjatCache.getAdminBooksCacheValues();
				if(allBooks != null && allBooks.size() > 0) {
					allStats = new ResultStats(allBooks);
					allStats.populateStats(false, false, false, true, false, false, false);
					removeComponent(progLayout);
					createMainContent();
				} else {
					showError();
				}
			} catch (Exception e) {
				e.printStackTrace();
				showError();
			}
			
			UI.getCurrent().setPollInterval(-1);
			UI.getCurrent().getSession().getLockInstance().unlock();
		}
		
		private void showError() {
			removeComponent(progLayout);
			VaadinTools.showError("Error occurred", "Please contact AVAA administrators");
		}
	}
}

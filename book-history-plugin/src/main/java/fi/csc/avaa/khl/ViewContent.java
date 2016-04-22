/**
 * 
 */
package fi.csc.avaa.khl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.map.MapWrapper;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.khl.tabs.AddPage;
import fi.csc.avaa.khl.tabs.FeedbackPage;
import fi.csc.avaa.khl.tabs.FrontPage;
import fi.csc.avaa.khl.tabs.InfoPage;
import fi.csc.avaa.khl.tabs.InstructionsPage;
import fi.csc.avaa.khl.tabs.SearchPage;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.LanguageDropdown;
import fi.csc.avaa.tools.vaadin.javascript.JavaScriptTools;
import fi.csc.avaa.tools.vaadin.language.LanguageChangeEvent;
import fi.csc.avaa.tools.vaadin.language.LanguageChangeListener;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class ViewContent extends VerticalLayout implements LanguageChangeListener {

	private static final long serialVersionUID = 1L;

	private HorizontalLayout progLayout = new HorizontalLayout();
	private ProgressBar pBar;
	
	public static CompleteVanhatkirjatCache cache;
	private Translator translator;
	private LiferayIPC ipc;
	public static String cxtPath;
	private ResultStats allStats;
	private SearchTools search;
	private TabSheet tabs;
	private FrontPage frontPage;
	private SearchPage searchPage;
	private AddPage addPage;
	private InfoPage infoPage;
	private FeedbackPage fbPage;
	private InstructionsPage instructionsPage;
	
	public ViewContent(VaadinRequest request, LiferayIPC ipc, Translator translator) {
		this.translator = translator;
		JavaScript.eval("window.locale = '" + Translator.getLocaleStr(this.translator.getDefaultLocale()) + "';");
		cxtPath = request.getContextPath();
		this.ipc = ipc;
		
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
		if(caption != null) {
			tabSheet.setCaption(caption);
			tabSheet.setCaptionAsHtml(true);
		}
		tabSheet.setImmediate(true);
		tabSheet.setTabCaptionsAsHtml(false);
		tabSheet.setStyleName("tab-navigation");
		tabSheet.setResponsive(true);
		
		tabSheet.addSelectedTabChangeListener(e -> {
			 if(fbPage == e.getTabSheet().getSelectedTab()) {
				 tabSheet.addStyleName("hide-borders");
				 JavaScript.getCurrent().execute("document.getElementsByClassName('web-form-portlet')[0].style.display='block'");
			} else {
				tabSheet.removeStyleName("hide-borders");
				JavaScript.getCurrent().execute("document.getElementsByClassName('web-form-portlet')[0].style.display='none'");
				if(frontPage == e.getTabSheet().getSelectedTab()) {
					JavaScriptTools.sendTabSelectionJavaScript(MapWrapper.TabType.FRONT.getValue());
				} else if(searchPage == e.getTabSheet().getSelectedTab()) {
					JavaScriptTools.sendTabSelectionJavaScript(MapWrapper.TabType.SEARCH.getValue());
				
				}
			}
		});
		return tabSheet;
	}
	
	public void createMainContent() {
		this.search = new SearchTools(false);
		LanguageDropdown langSelect = new LanguageDropdown(Arrays.asList(LanguageConst.LOCALE_FI, LanguageConst.LOCALE_SE, LanguageConst.LOCALE_EN), this.translator, false, true, false);
    	langSelect.addLanguageChangeListener(this);
    	langSelect.setWidth(70, Unit.PIXELS);
    	tabs = getTabSheet(translator.localize("Application.Name"));
    	
    	frontPage = new FrontPage(ipc, translator, allStats, search);
    	tabs.addTab(frontPage, translator.localize("Tab.Caption.FrontPage"));
    	
    	searchPage = new SearchPage(ipc, translator, allStats, search);
    	tabs.addTab(searchPage, translator.localize("Tab.Caption.SearchPage"));
    	
    	addPage = new AddPage(translator);
    	tabs.addTab(addPage, translator.localize("Tab.Caption.AddPage"));
    	
    	infoPage = new InfoPage(translator);
    	tabs.addTab(infoPage, translator.localize("Tab.Caption.InfoPage"));
    	
    	instructionsPage = new InstructionsPage(translator);
    	tabs.addTab(instructionsPage, translator.localize("Tab.Caption.InstructionsPage"));
    	
    	fbPage = new FeedbackPage(translator);
    	tabs.addTab(fbPage, translator.localize("Tab.Caption.FeedbackPage"));
    	
    	addComponents(langSelect, tabs);
    	setComponentAlignment(langSelect, Alignment.BOTTOM_RIGHT);
    	setIPCListeners();
    }
	
	private void setIPCListeners() {
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED, e -> {
			QueryBean queryBean = null;
			if(e.getData() != null) {
				queryBean = new QueryBean(e.getData());
			}
			List<CompleteVanhatkirjat> searchResults = search.getSearchResults();
			ResultStats resultStats = new ResultStats(searchResults);
			resultStats.populateStats(false, false, true, true, false, true, false);
			tabs.setSelectedTab(searchPage);
			searchPage.processSearchResults(searchResults, resultStats, queryBean);
		});
		
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_SEARCH_MUNICIPALITY_MAPPING_TARGETS, e -> {
			if(e.getData() != null) {
				Properties ipcData = StringTools.getStringAsProperties(e.getData(), ",", ":");
				QueryBean queryBean = new QueryBean(true);
				queryBean.setMunicipality(ipcData.getProperty(Const.IPC_DATA_MUNICIPALITY));
				queryBean.setMappingTarget(ipcData.getProperty(Const.IPC_DATA_MAPPING_TARGET).equals(Const.UNKNOWN_KEY )?  Const.STRING_EMPTY : ipcData.getProperty(Const.IPC_DATA_MAPPING_TARGET));
				search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), queryBean, false);
				ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED , queryBean.getFieldsAsString());
			}
		});
		
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_SEARCH_MUNICIPALITY, e -> {
			if(e.getData() != null) {
				Properties ipcData = StringTools.getStringAsProperties(e.getData(), ",", ":");
				QueryBean queryBean = new QueryBean(true);
				queryBean.setMunicipality(ipcData.getProperty(Const.IPC_DATA_MUNICIPALITY));
				search.queryData(CompleteVanhatkirjatCache.getPublicBooksCacheValues(), queryBean, Boolean.parseBoolean(ipcData.getProperty(Const.IPC_DATA_USE_NEW_MUNICIPALITY)));
				ipc.sendEvent(Const.IPC_EVENT_PUBLIC_SEARCH_COMPLETED , queryBean.getFieldsAsString());
			}
		});
	}
	
	private class Worker extends Thread {
		
		@Override
		public void run() {
			UI.getCurrent().getSession().getLockInstance().lock();
			CompleteVanhatkirjatCache.initCache();
			Collection<CompleteVanhatkirjat> visibleBooks = CompleteVanhatkirjatCache.getPublicBooksCacheValues();
			if(visibleBooks != null && visibleBooks.size() > 0) {
				allStats = new ResultStats(visibleBooks);
				allStats.populateStats(true, true, true, true, true, true, true);
				removeComponent(progLayout);
				createMainContent();
			} else {
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
	
	@Override
	public void changeComponentLanguage(LanguageChangeEvent e) {
		VaadinSession.getCurrent().setLocale(e.getLocale());
		JavaScript.eval("window.location.reload();");
	}
}

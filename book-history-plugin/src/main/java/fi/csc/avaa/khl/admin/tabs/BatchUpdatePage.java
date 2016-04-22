/**
 * 
 */
package fi.csc.avaa.khl.admin.tabs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.results.GridBean;
import fi.csc.avaa.khl.results.KirjakartoitusAdminBatchUpdateGrid;
import fi.csc.avaa.khl.results.KirjakartoitusResultControlRow;
import fi.csc.avaa.khl.search.BatchUpdateWrapper;
import fi.csc.avaa.khl.search.SearchTools;
import fi.csc.avaa.tools.search.result.ResultGridWrapper;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;
/**
 * @author jmlehtin
 *
 */
public class BatchUpdatePage extends CustomComponent implements Reconstructible {

	private static final long serialVersionUID = 1L;
	private Translator translator;
	private SearchTools search;
	private LiferayIPC ipc;
	private BatchUpdateWrapper batchUpdateWrapper;
	private VerticalLayout baseLayout;
	private VerticalLayout resultLayout;
	private KirjakartoitusAdminBatchUpdateGrid updateGrid;
	private String fieldNameId;
	private String newValue;
	private NativeButton saveButton;

	public BatchUpdatePage(LiferayIPC ipc, Translator translator, SearchTools search) {
		this.ipc = ipc;
		this.translator = translator;
		this.search = search;
		resultLayout = new VerticalLayout();
		init();
		ipc.addLiferayIPCEventListener(Const.IPC_EVENT_ADMIN_BATCH_UPDATE_SEARCH_COMPLETED, e -> {
			processSearchResults(e.getData());
		});
	}

	private void processSearchResults(String fieldNameAndNewValue) {
		resultLayout.removeAllComponents();
		HorizontalLayout hitCountLayout = new HorizontalLayout();
		hitCountLayout.setMargin(new MarginInfo(true, false, false, false));
		Label hitCountText = new Label(translator.localize("Search.FoundAmount") + search.getSearchResults().size());
		hitCountLayout.addComponent(hitCountText);
		resultLayout.addComponent(hitCountLayout);
		if (search.getSearchResults().size() > 0) {
			String[] args = fieldNameAndNewValue.split(",,,");
			fieldNameId = args[0];
			newValue = args[1];

			HorizontalLayout modifiedFieldLayout = new HorizontalLayout();
			Label modifiedFieldNameLabel = new Label();
			modifiedFieldNameLabel.setContentMode(ContentMode.HTML);
			modifiedFieldNameLabel.setValue(translator.localize("BatchUpdate.ModifiableField.Name") + ": <b>" + translator.localize(fieldNameId) + "</b>");
			modifiedFieldLayout.addComponent(modifiedFieldNameLabel);
			modifiedFieldLayout.setMargin(new MarginInfo(true, false, true, false));
			
			updateGrid = null;
			updateGrid = new KirjakartoitusAdminBatchUpdateGrid(translator, fieldNameId, newValue);
			((MultiSelectionModel)updateGrid.getSelectionModel()).setSelectionLimit(5000);
			updateGrid.addSelectionListener(e -> {
				if (updateGrid.getSelectedRows().size() > 0) {
					saveButton.setEnabled(true);
				}
				else {
					saveButton.setEnabled(false);
				}
			});
			
			VerticalLayout gridLayout = new VerticalLayout();
			gridLayout.setMargin(new MarginInfo(true, false, true, false));
			gridLayout.setSpacing(true);
			gridLayout.setSizeFull();
			
			KirjakartoitusResultControlRow resultControlRow = new KirjakartoitusResultControlRow(translator);
			ResultGridWrapper<GridBean, CompleteVanhatkirjat> batchUpdateGridWrapper = new ResultGridWrapper<>(updateGrid, resultControlRow);
			gridLayout.addComponent(batchUpdateGridWrapper);

			HorizontalLayout gridButtonLayout = new HorizontalLayout();
			gridButtonLayout.setSizeUndefined();
			gridButtonLayout.setSpacing(true);
			gridButtonLayout.setResponsive(true);
			
			saveButton = getSaveButton();
			saveButton.setEnabled(false);
			gridButtonLayout.addComponents(getSelectAllButton(updateGrid), getDeselectAllButton(updateGrid), saveButton);
			resultLayout.addComponents(modifiedFieldLayout, gridButtonLayout, gridLayout);
			resultLayout.setExpandRatio(gridButtonLayout, 2.0f);

			updateGrid.populateGrid(search.getSearchResults());
		}
		baseLayout.addComponent(resultLayout);
	}

	@Override
	public void init() {
		batchUpdateWrapper = new BatchUpdateWrapper(ipc, this.translator, this.search, this);
		baseLayout = new VerticalLayout();
		baseLayout.setSpacing(true);
		baseLayout.setMargin(true);
		baseLayout.setSizeFull();
		baseLayout.setResponsive(true);
		baseLayout.addComponent(batchUpdateWrapper);
		setCompositionRoot(baseLayout);
	}

	@Override
	public boolean hasPendingModifications() {
		return (updateGrid == null) ? false : updateGrid.getSelectionModel().getSelectedRows().size() > 0 ? true: false;
	}

	private NativeButton getSelectAllButton(KirjakartoitusAdminBatchUpdateGrid updateGrid) {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Select.All"), FontAwesome.CHECK, null, null);
		btn.addClickListener(e -> {
			MultiSelectionModel model = (MultiSelectionModel) updateGrid.getSelectionModel();
			model.selectAll();
		});
		return btn;
	}

	private NativeButton getDeselectAllButton(KirjakartoitusAdminBatchUpdateGrid updateGrid) {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("Deselect.All"), FontAwesome.ERASER, null, null);
		btn.addClickListener(e -> {
			MultiSelectionModel model = (MultiSelectionModel) updateGrid.getSelectionModel();
			model.deselectAll();
		});
		return btn;
	}

	private NativeButton getSaveButton() {
		NativeButton btn = VaadinTools.createNativeButton(translator.localize("BatchUpdate.Save.Selected"), FontAwesome.SAVE, null, null);
		btn.addClickListener(e -> {
			ArrayList<CompleteVanhatkirjat> cvkList = getSelectedCVKs(getSelectedVKIds(updateGrid.getSelectedRows()));
			if (((MultiSelectionModel)updateGrid.getSelectionModel()).getSelectedRows().size() > 0) {
				if (DBTools.modifyFieldsOfAllVanhatkirjat(cvkList.stream().map(cvk -> cvk.getVanhatkirjat()).collect(Collectors.toList()), fieldNameId, newValue)) {
					VaadinTools.showNotification(translator.localize("BatchUpdate.UpdateSuccess"), null);
					batchUpdateWrapper.runSearch();
				} else {
					VaadinTools.showError(translator.localize("BatchUpdate.Error.SaveFailed"), translator.localize("Application.Error.ContactAvaa"));
				}
			}
			((MultiSelectionModel)updateGrid.getSelectionModel()).deselectAll();
		});
		return btn;
	}

	private ArrayList<Integer> getSelectedVKIds(Collection<Object> selectedRows) {
		ArrayList<Integer> vkIdList = new ArrayList<Integer>();
		for (Object object : selectedRows) {
			vkIdList.add(((GridBean) object).getVkid());
		}
		return vkIdList;
	}
	
	private ArrayList<CompleteVanhatkirjat> getSelectedCVKs(ArrayList<Integer> vkIdList) {
		ArrayList<CompleteVanhatkirjat> cvkList = new ArrayList<CompleteVanhatkirjat>();
		for (CompleteVanhatkirjat cvk : search.getSearchResults()) {
			if (vkIdList.contains(cvk.getVanhatkirjat().getVkid())) {
				cvkList.add(cvk);
			}
		}
		return cvkList;
	}

	@Override
	public void clean() {
		baseLayout.removeComponent(resultLayout);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
	}
}

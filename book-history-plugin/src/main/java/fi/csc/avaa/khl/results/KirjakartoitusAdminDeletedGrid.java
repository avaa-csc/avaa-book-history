package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_DELETE_COMPLETELY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_UNDELETE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MUNICIPALITY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.PUBLICATION_YEAR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.TITLE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.VKID;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.ButtonRenderer;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.results.GridBean.AdminDeletedGridColumnName;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class KirjakartoitusAdminDeletedGrid extends KirjakartoitusBaseGrid {

	private static final long serialVersionUID = 1L;
	private Reconstructible reconstructibleContainer;
	
	public KirjakartoitusAdminDeletedGrid(Translator translator,  Reconstructible reconstructibleContainer) {
		super(translator);
		this.reconstructibleContainer = reconstructibleContainer;
		init();
		setColumnOrder(DELETE_DATE.getValue(), MUNICIPALITY.getValue(), AUTHOR.getValue(), PUBLICATION_YEAR.getValue(), TITLE.getValue(), GENERATED_COLUMN_UNDELETE.getValue(), GENERATED_COLUMN_DELETE_COMPLETELY.getValue());
		setVisible(false);
	}

	@Override
	protected void setGeneratedColumns() {
		wrapperContainer.addGeneratedProperty(GENERATED_COLUMN_UNDELETE.getValue(), new PropertyValueGenerator<String>() {
			private static final long serialVersionUID = 1L;

			@Override
		    public String getValue(Item item, Object itemId,
		                           Object propertyId) {
		        return translator.localize("Review.Undelete.Undelete"); // The caption
		    }

		    @Override
		    public Class<String> getType() {
		        return String.class;
		    }
		});
		
		wrapperContainer.addGeneratedProperty(GENERATED_COLUMN_DELETE_COMPLETELY.getValue(),
			new PropertyValueGenerator<String>() {
				private static final long serialVersionUID = 1L;

				@Override
			    public String getValue(Item item, Object itemId,
			                           Object propertyId) {
			        return translator.localize("Review.Delete.Button"); // The caption
			    }

			    @Override
			    public Class<String> getType() {
			        return String.class;
			    }
			}
		);
		
		getColumn(GENERATED_COLUMN_UNDELETE.getValue()).setRenderer(new ButtonRenderer(e -> {
			ConfirmDialog.show(UI.getCurrent(), translator.localize("Review.Undelete.Confirm.Header"), translator.localize("Review.Undelete.Confirm"), translator.localize("Review.Undelete.Confirm.Yes"), translator.localize("Review.Undelete.Confirm.No"), new ConfirmDialog.Listener() {
				private static final long serialVersionUID = 1L;

					public void onClose(ConfirmDialog dialog) {
		                if (dialog.isConfirmed()) {
		                	Object clickedItemId = e.getItemId();
		                	BeanItem<GridBean> item = container.getItem(clickedItemId);
		                	Vanhatkirjat vk = CompleteVanhatkirjatCache.getAdminBooksCache().get(item.getBean().getVkid()).getVanhatkirjat();
		                	int currentStatus = vk == null ? -1 : vk.getStatus();
		                	if(DBTools.updateVanhatkirjatToDatabaseWithStatus(vk, CompleteVanhatkirjat.getNewUndeletedStatus(currentStatus, vk.getMuokattu()), false, false)) {
		                		VaadinTools.showNotification(translator.localize("Review.Undelete.Success"), null);
		                		CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vk.getVkid(), false, false);
		        				reconstructibleContainer.init(); // Rebuild the grid
		                	} else {
		                		VaadinTools.showError(translator.localize("Review.Undelete.Fail"), translator.localize("Application.Error.ContactAvaa"));
		                	}
		                }
		            }
		        });
		}));
		
		getColumn(GENERATED_COLUMN_DELETE_COMPLETELY.getValue()).setRenderer(new ButtonRenderer(e -> {
			ConfirmDialog.show(UI.getCurrent(), translator.localize("Review.Delete.Confirm.Header"), translator.localize("Review.Delete.Confirm"), translator.localize("Review.Delete.Confirm.Yes"), translator.localize("Review.Delete.Confirm.No"), new ConfirmDialog.Listener() {
				private static final long serialVersionUID = 1L;

					public void onClose(ConfirmDialog dialog) {
		                if (dialog.isConfirmed()) {
		                	Object clickedItemId = e.getItemId();
		                	BeanItem<GridBean> item = container.getItem(clickedItemId);
		                	int vkid = item.getBean().getVkid();
		                	if(DBTools.deleteVanhatkirjatFromDatabase(vkid)) {
		                		VaadinTools.showNotification(translator.localize("Review.Delete.Success"), null);
		                		CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vkid, true, true);
		                		reconstructibleContainer.init();
		                	} else {
		                		VaadinTools.showError(translator.localize("Review.Delete.Fail"), translator.localize("Application.Error.ContactAvaa"));
		                	}
		                }
		            }
		        });
		}));
	}
	
	@Override
	protected void addListeners() {
		addSelectionListener(e -> {
		    // Get the item of the selected row
			Object selectedItemId = getSelectedRow();
			if(selectedItemId != null) {
		    	UI.getCurrent().addWindow(new VanhatkirjatDetailsWindow(translator, CompleteVanhatkirjatCache.getAdminBooksCache().get(container.getItem(selectedItemId).getBean().getVkid()), true));
			}
		});
		
	}

	@Override
	protected void setColumns() {
		setGridColumn(DELETE_DATE);
		setGridColumn(MUNICIPALITY);
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		setGridColumn(GENERATED_COLUMN_UNDELETE);
		setGridColumn(GENERATED_COLUMN_DELETE_COMPLETELY);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(CREATE_DATE.getValue());
		wrapperContainer.removeContainerProperty(MODIFY_DATE.getValue());
	}

	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		AdminDeletedGridColumnName column = AdminDeletedGridColumnName.getValuefromName(field.name());
		gridCol.setHeaderCaption(translator.localize(column.getValue()));
		gridCol.setEditable(false);
		switch (column) {
		case AUTHOR:
			gridCol.setExpandRatio(0);
			break;
		case MUNICIPALITY:
			gridCol.setWidth(130);
			break;
		case PUBLICATION_YEAR:
			gridCol.setWidth(80);
			break;
		case TITLE:
			gridCol.setExpandRatio(0);
			break;
		case DELETE_DATE:
			gridCol.setExpandRatio(1);
			break;
		case GENERATED_COLUMN_DELETE_COMPLETELY:
			gridCol.setExpandRatio(1);
			break;
		case GENERATED_COLUMN_UNDELETE:
			gridCol.setExpandRatio(1);
			break;
		default:
			break;
		}
	}

	@Override
	protected boolean setModelsToContainer() {
		wrapperContainer.removeAllItems();
		for(CompleteVanhatkirjat book : models) {
			int status = book.getVanhatkirjat().getStatus();
			if(status == Const.STATUS_NOT_WWW_AND_DELETED || status == Const.STATUS_WWW_AND_DELETED) {
				GridBean gridItem = convertToGridBean(book);
				container.addBean(gridItem);
			}
		}
		if(wrapperContainer.size() > 0) {
			setGridHeightInRows(30);
			setVisible(true);
			return true;
		}
		setVisible(false);
		return false;
	}
}

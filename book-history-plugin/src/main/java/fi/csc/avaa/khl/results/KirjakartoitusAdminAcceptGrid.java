/**
 * 
 */
package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_ACCEPT;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_DELETE_COMPLETELY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
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
import fi.csc.avaa.khl.results.GridBean.AdminAcceptGridColumnName;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class KirjakartoitusAdminAcceptGrid extends KirjakartoitusBaseGrid {

	private static final long serialVersionUID = 1L;
	private Reconstructible reconstructible;
	
	public KirjakartoitusAdminAcceptGrid(Translator translator, Reconstructible reconstructible) {
		super(translator);
		this.reconstructible = reconstructible;
		init();
		setColumnOrder(CREATE_DATE.getValue(), MUNICIPALITY.getValue(), AUTHOR.getValue(), PUBLICATION_YEAR.getValue(), TITLE.getValue(), GENERATED_COLUMN_ACCEPT.getValue(), GENERATED_COLUMN_DELETE_COMPLETELY.getValue());
		setVisible(false);
	}

	@Override
	protected void addListeners() {
		addSelectionListener(e -> {
		    // Get the item of the selected row
			Object selectedItemId = getSelectedRow();
			if(selectedItemId != null) {
		    	UI.getCurrent().addWindow(new VanhatkirjatDetailsEditWindow(translator, CompleteVanhatkirjatCache.getAdminBooksCache().get(container.getItem(selectedItemId).getBean().getVkid()), translator.localize("Review.Accept.Modify"), Const.STATUS_WWW_AND_UNPUBLISHED, reconstructible));
			}
		});
		
	}
	
	@Override
	protected void setGeneratedColumns() {
		wrapperContainer.addGeneratedProperty(GENERATED_COLUMN_ACCEPT.getValue(), new PropertyValueGenerator<String>() {
			private static final long serialVersionUID = 1L;

			@Override
		    public String getValue(Item item, Object itemId,
		                           Object propertyId) {
		        return translator.localize("Review.Accept.Accept"); // The caption
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
			        return translator.localize("Review.Accept.Delete"); // The caption
			    }

			    @Override
			    public Class<String> getType() {
			        return String.class;
			    }
			}
		);
		
		getColumn(GENERATED_COLUMN_ACCEPT.getValue()).setRenderer(new ButtonRenderer(e -> {
			Object clickedItemId = e.getItemId();
			BeanItem<GridBean> item = container.getItem(clickedItemId);
        	Vanhatkirjat vk = CompleteVanhatkirjatCache.getAdminBooksCache().get(item.getBean().getVkid()).getVanhatkirjat();
        	if(DBTools.updateVanhatkirjatToDatabaseWithStatus(vk, CompleteVanhatkirjat.getNewPublishedStatus(vk.getStatus()), false, false)) {
        		VaadinTools.showNotification(translator.localize("Review.Accept.Success"), null);
        		CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vk.getVkid(), false, false);
        		reconstructible.init();
        	} else {
        		VaadinTools.showError(translator.localize("Review.Accept.Fail"), translator.localize("Application.Error.ContactAvaa"));
        	}
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
		                		getContainerDataSource().removeItem(clickedItemId);
		                		setGridHeightInRows(30);
		                	} else {
		                		VaadinTools.showError(translator.localize("Review.Delete.Fail"), translator.localize("Application.Error.ContactAvaa"));
		                	}
		                }
		            }
		        });
		}));
	}

	@Override
	protected void setColumns() {
		setGridColumn(CREATE_DATE);
		setGridColumn(MUNICIPALITY);
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		setGridColumn(GENERATED_COLUMN_ACCEPT);
		setGridColumn(GENERATED_COLUMN_DELETE_COMPLETELY);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(MODIFY_DATE.getValue());
		wrapperContainer.removeContainerProperty(DELETE_DATE.getValue());
	}
	
	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		AdminAcceptGridColumnName column = AdminAcceptGridColumnName.getValuefromName(field.name());
		gridCol.setHeaderCaption(translator.localize(column.getValue()));
		gridCol.setEditable(false);
		switch (column) {
		case AUTHOR:
			gridCol.setExpandRatio(0);
			break;
		case CREATE_DATE:
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
		case GENERATED_COLUMN_ACCEPT:
			gridCol.setExpandRatio(1);
			break;
		case GENERATED_COLUMN_DELETE_COMPLETELY:
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
			if(status == Const.STATUS_WWW_AND_UNPUBLISHED) {
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

package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_SET_DELETED;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MUNICIPALITY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.PUBLICATION_YEAR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.TITLE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.VKID;

import java.util.ArrayList;
import java.util.List;

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
import fi.csc.avaa.khl.results.GridBean.AdminModifyGridColumnName;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

public class KirjakartoitusAdminModifyGrid extends KirjakartoitusBaseGrid {
	private static final long serialVersionUID = 1L;
	private Reconstructible reconstructibleContainer;
	private List<CompleteVanhatkirjat> cvksInGrid;

	public KirjakartoitusAdminModifyGrid(Translator translator, Reconstructible reconstructibleContainer) {
		super(translator);
		this.reconstructibleContainer = reconstructibleContainer;
		cvksInGrid = new ArrayList<CompleteVanhatkirjat>();
		try {
			init();
			setColumnOrder(MUNICIPALITY.getValue(), AUTHOR.getValue(), PUBLICATION_YEAR.getValue(), TITLE.getValue(), GENERATED_COLUMN_SET_DELETED.getValue());
			setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CompleteVanhatkirjat> getCVKsInGrid() {
		return this.cvksInGrid;
	}

	@Override
	protected void addListeners() {
		addSelectionListener(e -> {
		    // Get the item of the selected row
			Object selectedItemId = getSelectedRow();
			if(selectedItemId != null) {
		    	CompleteVanhatkirjat cvk = CompleteVanhatkirjatCache.getAdminBooksCache().get(container.getItem(selectedItemId).getBean().getVkid());
				UI.getCurrent().addWindow(new VanhatkirjatDetailsEditWindow(translator, cvk, translator.localize("Modify.Modify.Window"), CompleteVanhatkirjat.getNewModifiedStatus(cvk.getVanhatkirjat().getStatus()), reconstructibleContainer));
			}
		});
	}

	@Override
	protected void setColumns() {
		setGridColumn(MUNICIPALITY);
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		setGridColumn(GENERATED_COLUMN_SET_DELETED);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(CREATE_DATE.getValue());
		wrapperContainer.removeContainerProperty(MODIFY_DATE.getValue());
		wrapperContainer.removeContainerProperty(DELETE_DATE.getValue());
	}

	@Override
	protected void setGeneratedColumns() {
		wrapperContainer.addGeneratedProperty(GENERATED_COLUMN_SET_DELETED.getValue(), new PropertyValueGenerator<String>() {
			private static final long serialVersionUID = 1L;

			@Override
		    public String getValue(Item item, Object itemId,
		                           Object propertyId) {
		        return translator.localize("Modify.Delete.Button"); // The caption
		    }

		    @Override
		    public Class<String> getType() {
		        return String.class;
		    }
		});
		getColumn(GENERATED_COLUMN_SET_DELETED.getValue()).setRenderer(new ButtonRenderer(e -> {
			Object clickedItemId = e.getItemId();
			BeanItem<GridBean> item = container.getItem(clickedItemId);
        	Vanhatkirjat vk = CompleteVanhatkirjatCache.getAdminBooksCache().get(item.getBean().getVkid()).getVanhatkirjat();
        	if(DBTools.updateVanhatkirjatToDatabaseWithStatus(vk, CompleteVanhatkirjat.getNewDeletedStatus(vk.getStatus()), false, true)) {
        		VaadinTools.showNotification(translator.localize("Modify.Accept.Delete.Success"), null);
        		CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vk.getVkid(), true, false);
        		reconstructibleContainer.refresh();
        	} else {
        		VaadinTools.showError(translator.localize("Modify.Accept.Delete.Fail"), translator.localize("Application.Error.ContactAvaa"));
        	}
		}));
	}

	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		AdminModifyGridColumnName column = AdminModifyGridColumnName.getValuefromName(field.name());
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
		case GENERATED_COLUMN_SET_DELETED:
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
			if(status == Const.STATUS_NOT_WWW_AND_MODIFIED || status == Const.STATUS_NOT_WWW_AND_PUBLISHED || status == Const.STATUS_WWW_AND_MODIFIED || status == Const.STATUS_WWW_AND_PUBLISHED) {
				GridBean gridItem = convertToGridBean(book);
				container.addBean(gridItem);
				cvksInGrid.add(book);
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

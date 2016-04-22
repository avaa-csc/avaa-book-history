/**
 * 
 */
package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MUNICIPALITY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.PUBLICATION_YEAR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.TITLE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.VKID;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.results.GridBean.AdminAddedModifiedGridColumnName;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class KirjakartoitusAdminAddedModifiedGrid extends KirjakartoitusBaseGrid {

	private static final long serialVersionUID = 1L;

	public KirjakartoitusAdminAddedModifiedGrid(Translator translator) {
		super(translator);
		init();
		setColumnOrder(CREATE_DATE.getValue(), MODIFY_DATE.getValue(), MUNICIPALITY.getValue(), AUTHOR.getValue(), PUBLICATION_YEAR.getValue(), TITLE.getValue());
		setVisible(false);
	}

	@Override
	protected void addListeners() {
		addSelectionListener(e -> {
		    // Get the item of the selected row
			Object selectedItemId = getSelectedRow();
			if(selectedItemId != null) {
				BeanItem<GridBean> item = container.getItem(selectedItemId);
		    	UI.getCurrent().addWindow(new VanhatkirjatDetailsWindow(translator, CompleteVanhatkirjatCache.getAdminBooksCache().get(item.getBean().getVkid()), true));
			}
		});
		
	}

	@Override
	protected void setColumns() {
		setGridColumn(CREATE_DATE);
		setGridColumn(MODIFY_DATE);
		setGridColumn(MUNICIPALITY);
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(DELETE_DATE.getValue());
	}
	
	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		AdminAddedModifiedGridColumnName column = AdminAddedModifiedGridColumnName.getValuefromName(field.name());
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
		case CREATE_DATE:
			gridCol.setExpandRatio(1);
			break;
		case MODIFY_DATE:
			gridCol.setExpandRatio(1);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void setGeneratedColumns() {
	}

	@Override
	protected boolean setModelsToContainer() {
		wrapperContainer.removeAllItems();
		for(CompleteVanhatkirjat book : models) {
			int status = book.getVanhatkirjat().getStatus();
			if(status == Const.STATUS_WWW_AND_PUBLISHED || status == Const.STATUS_WWW_AND_MODIFIED) {
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

/**
 * 
 */
package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MUNICIPALITY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.PUBLICATION_YEAR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.TITLE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.VKID;

import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.khl.results.GridBean.PublicGridColumnName;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class KirjakartoitusPublicGrid extends KirjakartoitusBaseGrid {

	private static final long serialVersionUID = 1L;

	public KirjakartoitusPublicGrid(Translator translator) {
		super(translator);
		init();
		setColumnOrder(MUNICIPALITY.getValue(), AUTHOR.getValue(), PUBLICATION_YEAR.getValue(), TITLE.getValue());
		setVisible(false);
	}

	@Override
	protected void addListeners() {
		addSelectionListener(e -> {
		    // Get the item of the selected row
			Object selectedItemId = getSelectedRow();
			if(selectedItemId != null) {
		    	UI.getCurrent().addWindow(new VanhatkirjatDetailsWindow(translator, CompleteVanhatkirjatCache.getPublicBooksCache().get(container.getItem(selectedItemId).getBean().getVkid()), false));
			}
		});
		
	}

	@Override
	protected void setColumns() {
		setGridColumn(MUNICIPALITY);
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(CREATE_DATE.getValue());
		wrapperContainer.removeContainerProperty(MODIFY_DATE.getValue());
		wrapperContainer.removeContainerProperty(DELETE_DATE.getValue());
	}
	
	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		PublicGridColumnName column = PublicGridColumnName.getValuefromName(field.name());
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
			gridCol.setExpandRatio(1);
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
		if(models != null && models.size() > 0) {
			for(CompleteVanhatkirjat book : models) {
				int status = book.getVanhatkirjat().getStatus();
				if(status == Const.STATUS_NOT_WWW_AND_MODIFIED || status == Const.STATUS_NOT_WWW_AND_PUBLISHED || status == Const.STATUS_WWW_AND_MODIFIED || status == Const.STATUS_WWW_AND_PUBLISHED) {
					GridBean gridItem = convertToGridBean(book);
					container.addBean(gridItem);
				}
			}
			setSelectionMode(SelectionMode.SINGLE);
			setGridHeightInRows(30);
			setVisible(true);
			return true;
		}
		setSelectionMode(SelectionMode.SINGLE);
		setVisible(false);
		return false;
	}
}

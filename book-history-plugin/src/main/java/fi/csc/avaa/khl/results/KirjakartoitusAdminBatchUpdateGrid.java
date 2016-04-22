package fi.csc.avaa.khl.results;

import static fi.csc.avaa.khl.results.GridBean.FieldName.AUTHOR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.CREATE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.DELETE_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_FIELD_CURRENT_VALUE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.GENERATED_COLUMN_FIELD_NEW_VALUE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MODIFY_DATE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.MUNICIPALITY;
import static fi.csc.avaa.khl.results.GridBean.FieldName.PUBLICATION_YEAR;
import static fi.csc.avaa.khl.results.GridBean.FieldName.TITLE;
import static fi.csc.avaa.khl.results.GridBean.FieldName.VKID;

import com.vaadin.data.Item;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.results.GridBean.AdminBatchUpdateGridColumnName;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.vaadin.language.Translator;

public class KirjakartoitusAdminBatchUpdateGrid extends KirjakartoitusBaseGrid {
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String newValue;

	public KirjakartoitusAdminBatchUpdateGrid(Translator translator, String fieldName, String newValue) {
		super(translator);
		this.fieldName = fieldName;
		this.newValue = newValue;
		init();
		setColumnOrder(GridBean.FieldName.AUTHOR.getValue(), GridBean.FieldName.PUBLICATION_YEAR.getValue(), GridBean.FieldName.TITLE.getValue());
		setSelectionMode(SelectionMode.MULTI);
		setVisible(false);
	}

	@Override
	protected void addListeners() {

	}

	@Override
	protected void setColumns() {
		setGridColumn(AUTHOR);
		setGridColumn(TITLE);
		setGridColumn(PUBLICATION_YEAR);
		setGridColumn(GENERATED_COLUMN_FIELD_CURRENT_VALUE);
		setGridColumn(GENERATED_COLUMN_FIELD_NEW_VALUE);
		wrapperContainer.removeContainerProperty(VKID.getValue());
		wrapperContainer.removeContainerProperty(MUNICIPALITY.getValue());
		wrapperContainer.removeContainerProperty(CREATE_DATE.getValue());
		wrapperContainer.removeContainerProperty(MODIFY_DATE.getValue());
		wrapperContainer.removeContainerProperty(DELETE_DATE.getValue());
	}

	@Override
	protected void setGeneratedColumns() {
		wrapperContainer.addGeneratedProperty(GridBean.FieldName.GENERATED_COLUMN_FIELD_CURRENT_VALUE.getValue(), new PropertyValueGenerator<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getValue(Item item, Object itemId, Object propertyId) {
				GridBean gridBean = (GridBean) itemId;
				CompleteVanhatkirjat cvk = CompleteVanhatkirjatCache.getAdminBooksCache().get(gridBean.getVkid());
				Object fieldCurrentValue = null;
				switch (fieldName) {
				case Const.authorKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getTekija();
					break;
				case Const.titleKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getTeoknimi();
					break;
				case Const.publicationYearKey:
					fieldCurrentValue = String.valueOf(cvk.getVanhatkirjat().getPainovuosi());
					break;
				case Const.placeOfPrintingKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getPainopaikka();
					break;
				case Const.printingOfficeKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getKirjapaino();
					break;
				case Const.additionalInfoKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getLisatieto();
					break;
				case Const.emailKey:
					fieldCurrentValue = cvk.getVanhatkirjat().getLahemail();
					break;

				}
				return (String) fieldCurrentValue;
			}

			@Override
			public Class<String> getType() {
				return String.class;
			}
		});
		wrapperContainer.addGeneratedProperty(GridBean.FieldName.GENERATED_COLUMN_FIELD_NEW_VALUE.getValue(), new PropertyValueGenerator<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getValue(Item item, Object itemId, Object propertyId) {
				return newValue;
			}

			@Override
			public Class<String> getType() {
				return String.class;
			}
		});
	}

	private void setGridColumn(FieldName field) {
		Grid.Column gridCol = getColumn(field.getValue());
		AdminBatchUpdateGridColumnName column = AdminBatchUpdateGridColumnName.getValuefromName(field.name());
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
			break;
		default:
			break;
		}
	}

	@Override
	protected boolean setModelsToContainer() {
		wrapperContainer.removeAllItems();
		for (CompleteVanhatkirjat book : models) {
			int status = book.getVanhatkirjat().getStatus();
			if (status == Const.STATUS_NOT_WWW_AND_MODIFIED || status == Const.STATUS_NOT_WWW_AND_PUBLISHED || status == Const.STATUS_WWW_AND_MODIFIED || status == Const.STATUS_WWW_AND_PUBLISHED) {
				GridBean gridItem = convertToGridBean(book);
				container.addBean(gridItem);
			}
		}
		if (wrapperContainer.size() > 0) {
			setGridHeightInRows(30);
			setVisible(true);
			return true;
		}
		setVisible(false);
		return false;
	}
}

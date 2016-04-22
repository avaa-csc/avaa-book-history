/**
 * 
 */
package fi.csc.avaa.khl.results;

import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.TextField;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.results.GridBean.FieldName;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.AvaaBaseGrid;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public abstract class KirjakartoitusBaseGrid extends AvaaBaseGrid<GridBean, CompleteVanhatkirjat> {

	protected static final long serialVersionUID = 1L;

	protected KirjakartoitusBaseGrid(Translator translator) {
		super(translator, GridBean.class);
		setHeightMode(HeightMode.ROW);
	}
	
	protected void init() {
		super.init();
		setCellStyleGenerator(cellReference -> {
			if(cellReference != null && cellReference.getPropertyId() != null) {
				FieldName fName = FieldName.fromValue(String.valueOf(cellReference.getPropertyId()));
				if(fName != null) {
					switch (fName) {
					case AUTHOR:
						return "grid-cell-wrap";
					case TITLE:
						return "grid-cell-wrap";
					case CREATE_DATE:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_ACCEPT:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_DELETE_COMPLETELY:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_FIELD_CURRENT_VALUE:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_FIELD_NEW_VALUE:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_SET_DELETED:
						return "grid-cell-middle grid-cell-center";
					case GENERATED_COLUMN_UNDELETE:
						return "grid-cell-middle grid-cell-center";
					case MODIFY_DATE:
						return "grid-cell-middle grid-cell-center";
					case MUNICIPALITY:
						return "grid-cell-middle";
					case PUBLICATION_YEAR:
						return "grid-cell-middle grid-cell-center";
					default:
						break;
					}
					return null;
				}
			}
			return null;
		});
	}
	
	@Override
	protected GridBean convertToGridBean(CompleteVanhatkirjat cvk) {
		final int MAX_AUTHOR_LENGTH = 30;
		final int MAX_TITLE_LENGTH = 80;
		String municipality = StringTools.isEmptyOrNull(cvk.getKuntainfo() == null ? null : cvk.getKuntainfo().getCapitalkuntanimi()) ? translator.localize(Const.notKnownKey) : cvk.getKuntainfo().getCapitalkuntanimi();
		String author = StringTools.isEmptyOrNull(cvk.getVanhatkirjat().getTekija()) ? translator.localize(Const.notKnownKey) : cvk.getVanhatkirjat().getTekija();
		if(author.length() > MAX_AUTHOR_LENGTH) {
			author = author.substring(0, MAX_AUTHOR_LENGTH) + "..";
		}
		String title = StringTools.isEmptyOrNull(cvk.getVanhatkirjat().getTeoknimi()) ? translator.localize(Const.notKnownKey) : cvk.getVanhatkirjat().getTeoknimi();
		if(title.length() > MAX_TITLE_LENGTH) {
			title = title.substring(0, MAX_TITLE_LENGTH) + "..";
		}
		String publicationYear = cvk.getVanhatkirjat().getPainovuosi() == 0 ? translator.localize(Const.notKnownKey) : String.valueOf(cvk.getVanhatkirjat().getPainovuosi());
		String createDate = CompleteVanhatkirjatUtils.getStringFromDate(cvk.getVanhatkirjat().getPaivays(), translator);
		String modifyDate = CompleteVanhatkirjatUtils.getStringFromDate(cvk.getVanhatkirjat().getMuokattu(), translator);
		String deleteDate = CompleteVanhatkirjatUtils.getStringFromDate(cvk.getVanhatkirjat().getPoistettu(), translator);
		return new GridBean(cvk.getVanhatkirjat().getVkid(), municipality, author, title, publicationYear, createDate, modifyDate, deleteDate);
	}
	
	@Override
	protected void setCustomHeaders() {
		HeaderRow filterHeaderRow = appendHeaderRow();
		for (final Object pid : wrapperContainer.getContainerPropertyIds()) {
			HeaderCell cell = filterHeaderRow.getCell(pid);
			// Have an input field to use for filter
			TextField filterField = new TextField();
			filterField.setColumns(4);
			
			// Update filter When the filter input is changed
			filterField.addTextChangeListener(new FieldEvents.TextChangeListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void textChange(TextChangeEvent event) {
					// Can't modify filters so need to replace
					container.removeContainerFilters(pid);
				   // (Re)create the filter if necessary
				   if (!event.getText().isEmpty()) {
				       container.addContainerFilter(new SimpleStringFilter(pid, event.getText(), true, false));
				   }
				}
			});
			cell.setComponent(filterField);
		}
	}
}

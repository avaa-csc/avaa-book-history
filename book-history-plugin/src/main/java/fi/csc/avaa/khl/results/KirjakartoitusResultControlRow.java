/**
 * 
 */
package fi.csc.avaa.khl.results;

import java.util.Collection;

import com.vaadin.server.FontAwesome;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.tools.search.SearchBean;
import fi.csc.avaa.tools.search.result.ResultControlRow;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class KirjakartoitusResultControlRow extends ResultControlRow<CompleteVanhatkirjat> {

	private static final long serialVersionUID = 1L;

	public KirjakartoitusResultControlRow(Translator translator) {
		super(	translator, 
				VaadinTools.createButton(translator.localize("Application.Print"), FontAwesome.PRINT, null, "print-all-btn"), 
				VaadinTools.createButton(translator.localize("Application.Csv"), FontAwesome.DOWNLOAD, null, "download-csv-btn"),
				true);
	}

	@Override
	protected String getHtml(Collection<CompleteVanhatkirjat> searchResults,
			SearchBean queryBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html><html><body>");
		sb.append("<head><style>table, th, td {border-spacing: 2px 0; border: none; font-size: 12px;}</style></head>");
		sb.append(translator.localize("Search.Filter") + ":");
		sb.append(queryBean.getFieldsAsHtml(translator));
		sb.append("<table>");
		sb.append("<tr><th>" + translator.localize(Const.municipalityKey) + "</th><th>" + translator.localize(Const.authorKey) + "</th><th>" + translator.localize(Const.titleKey) + "</th><th>" + translator.localize(Const.publicationYearKey) + "</th></tr>");
		for (CompleteVanhatkirjat cvk : searchResults) {
			sb.append("<td>" + cvk.getKuntainfo().getCapitalkuntanimi() + "</td><td>" + cvk.getVanhatkirjat().getTekija() + "</td><td>" + cvk.getVanhatkirjat().getTeoknimi() + "</td><td>" + cvk.getVanhatkirjat().getPainovuosi() + "</td></tr>");
		}
		sb.append("</table></body></html>");
		return sb.toString();
	}
}

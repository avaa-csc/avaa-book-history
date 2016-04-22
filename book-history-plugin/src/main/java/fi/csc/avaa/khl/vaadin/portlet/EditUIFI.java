/**
 * 
 */
package fi.csc.avaa.khl.vaadin.portlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;

import fi.csc.avaa.khl.admin.EditContent;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.vaadin.portlet.AvaaUI;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
@Title("Kirja Suomessa vuoteen 1850 ADMIN")
@Theme("chameleon")
public class EditUIFI extends AvaaUI {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		super.init(request);
		translator.setDefaultLocale(LanguageConst.LOCALE_FI);
		try {
			setContent(new EditContent(request, ipc, translator));
		} catch (Exception e) {
			setContent(VaadinTools.createErrorLayout(e, translator.getDefaultLocaleStr()));
		}
	}
}

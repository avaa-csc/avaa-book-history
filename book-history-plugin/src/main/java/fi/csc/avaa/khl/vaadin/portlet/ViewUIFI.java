/**
 * 
 */
package fi.csc.avaa.khl.vaadin.portlet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import fi.csc.avaa.khl.ViewContent;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.vaadin.portlet.AvaaUI;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
@Title("Kirjojen levinneisyys Suomessa vuoteen 1850")
@Theme("chameleon")
public class ViewUIFI extends AvaaUI {

	@SuppressWarnings("serial")
	@WebServlet(value = "/VAADIN/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = true, ui = ViewUIFI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	private static final long serialVersionUID = 1L;
	private ViewContent view;

	@Override
	protected void init(VaadinRequest request) {
		super.init(request);
		translator.setDefaultLocale(LanguageConst.LOCALE_FI);
		try {
			view = new ViewContent(request, ipc, translator);
			setContent(view);
		} catch (Exception e) {
			setContent(VaadinTools.createErrorLayout(e, translator.getDefaultLocaleStr()));
		}
	}

	@Override
	protected void refresh(VaadinRequest request) {
		super.refresh(request);
		init(request);
	}
}

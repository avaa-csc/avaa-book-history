/**
 * 
 */
package fi.csc.avaa.khl.vaadin.portlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;

import fi.csc.avaa.khl.ViewContent;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.vaadin.portlet.AvaaUI;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
@Title("Distribution of books in Finland before 1850")
@Theme("chameleon")
public class ViewUIEN extends AvaaUI {

	private static final long serialVersionUID = 1L;
	private ViewContent view;

	@Override
	protected void init(VaadinRequest request) {
		super.init(request);
		translator.setDefaultLocale(LanguageConst.LOCALE_EN);
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

/**
 * 
 */
package fi.csc.avaa.khl.vaadin.portlet;

import java.util.Locale;

import com.vaadin.ui.UI;

import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.language.LanguageConst;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.portlet.AvaaUIProvider;

/**
 * @author jmlehtin
 *
 */
public class UIProvider extends AvaaUIProvider {

	private static final long serialVersionUID = 1L;
	private AvaaLogger log = new AvaaLogger(UIProvider.class.getName());

	@Override
	protected Class<? extends UI> getEditModeUI(Locale loc) {
		return EditUIFI.class;
	}

	@Override
	protected Class<? extends UI> getHelpModeUI(Locale loc) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Class<? extends UI> getViewModeUI(Locale loc) {
		String sessionLocStr = Translator.getLocaleStr(loc);
		if(Translator.getLocaleStr(LanguageConst.LOCALE_FI).equals(sessionLocStr)) {
			return ViewUIFI.class;
		} else if(Translator.getLocaleStr(LanguageConst.LOCALE_SE).equals(sessionLocStr)) {
			return ViewUISE.class;
		} else if(Translator.getLocaleStr(LanguageConst.LOCALE_EN).equals(sessionLocStr)) {
			return ViewUIEN.class;
		}
		log.error("Unknown locale in UIProvider");
		return null;
	}

}

/**
 * 
 */
package fi.csc.avaa.khl.tabs;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class InfoPage extends CustomComponent {
	private static final long serialVersionUID = 1L;

	public InfoPage(Translator translator) {
		Label info = new Label();
		info.setContentMode(ContentMode.HTML);
		info.setValue(translator.localize("Info.content"));
		info.setStyleName("info-layout");
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(info);
		setCompositionRoot(layout);
	}
}

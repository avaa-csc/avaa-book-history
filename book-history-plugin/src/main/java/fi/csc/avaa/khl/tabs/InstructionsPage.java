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
public class InstructionsPage extends CustomComponent {
	private static final long serialVersionUID = 1L;

	public InstructionsPage(Translator translator) {
		Label instructions = new Label();
		instructions.setContentMode(ContentMode.HTML);
		instructions.setValue(translator.localize("Instructions.content"));
		instructions.setStyleName("info-layout");
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(instructions);
		setCompositionRoot(layout);
	}
}

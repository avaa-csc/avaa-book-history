package fi.csc.avaa.khl.tabs;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.tools.vaadin.language.Translator;

public class FeedbackPage extends CustomComponent {

	private static final long serialVersionUID = 1L;

	public FeedbackPage(Translator translator) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		Label label = new Label(translator.localize("Application.Feedback.Description"), ContentMode.HTML);
		label.setStyleName("feedback-description");
		label.setWidth(50, Unit.PERCENTAGE);
		layout.addComponent(label);
		setCompositionRoot(layout);
	}
}

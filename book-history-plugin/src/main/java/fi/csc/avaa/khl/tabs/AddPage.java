/**
 * 
 */
package fi.csc.avaa.khl.tabs;

import java.util.Arrays;
import java.util.Date;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.results.VanhatkirjatDetailsWindow;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.email.SendEmailThread;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class AddPage extends CustomComponent {
	private static final long serialVersionUID = 1L;

	private static AvaaLogger log = new AvaaLogger(AddPage.class.getName());
	private Translator translator;
	private VerticalLayout baseLayout;
	
	public AddPage(Translator translator) {
		this.translator = translator;
		this.baseLayout = new VerticalLayout();
		init();
	}

	private void init() {
		baseLayout.setWidth(100, Unit.PERCENTAGE);
		baseLayout.setMargin(true);
		baseLayout.setSpacing(true);
		
		Label addBookText = new Label(translator.localize("Application.AddBook"));
		addBookText.setStyleName("add-book-header");
		Label addBookInfoText = new Label(translator.localize("Application.AddBook.Info"));
		
		Label bookInfoText = new Label(translator.localize("Application.BookInfo"));
		bookInfoText.addStyleName("vk-details-header");
		
		baseLayout.addComponents(addBookText, addBookInfoText, bookInfoText);
		
		FormLayout basicInfoLayout = new FormLayout();
		
		ComboBox authorField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.publicAuthors, CompleteVanhatkirjatCache.publicAuthors, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		setHelp(authorField, "Application.AddBook.Info.Author");
		authorField.setCaption(translator.localize(Const.authorKey));
		authorField.setNewItemsAllowed(true);
		
		TextField titleField = VaadinTools.createTextField(600, null, 150, false, "add-book-field");
		titleField.setCaption(translator.localize(Const.titleKey));
		setHelp(titleField,"Application.AddBook.Info.Title");
		titleField.setRequired(true);
		titleField.setValidationVisible(true);
		titleField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		titleField.setValidationVisible(false);
		
		TextField publicationYearField = VaadinTools.createTextField(50, null, 4, true, "add-book-field");
		publicationYearField.setCaption(translator.localize(Const.publicationYearKey));
		setHelp(publicationYearField, "Application.AddBook.Info.PublicationYear");
		publicationYearField.addValidator(value -> {
			if(value != null && value.toString().length() > 0) {
				try {
					Integer.valueOf(value.toString());
				} catch (NumberFormatException e) {
					throw new InvalidValueException(translator.localize("Application.Field.Error.IntegerFormat"));
				}
				if(value.toString().length() != 4) {
					throw new InvalidValueException(translator.localize("Application.Field.Error.YearLength"));
				}
			}
		});
		
		ComboBox placeOfPrintingField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.placeOfPrintings, CompleteVanhatkirjatCache.placeOfPrintings, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY)); // translator.localize(Const.countyInputPrompt)
		setHelp(placeOfPrintingField, "Application.AddBook.Info.Collection");
		placeOfPrintingField.setCaption(translator.localize(Const.placeOfPrintingKey));
		placeOfPrintingField.setValidationVisible(false);
		placeOfPrintingField.setNewItemsAllowed(true);
		setHelp(placeOfPrintingField, "Application.AddBook.Info.PlaceOfPrinting");
		
		
		TextField printingOfficeField = VaadinTools.createTextField(250, null, 50, true, "add-book-field");
		printingOfficeField.setCaption(translator.localize(Const.printingOfficeKey));
		setHelp(printingOfficeField, "Application.AddBook.Info.PrintingOffice");
		
		basicInfoLayout.addComponents(new Label(translator.localize("Application.AddBook.Author.Note")), authorField, titleField, publicationYearField, placeOfPrintingField, printingOfficeField);
		baseLayout.addComponent(basicInfoLayout);
		
		Label bookDetailsText = new Label(translator.localize("Application.BookInfo.Details"));
		bookDetailsText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(bookDetailsText);
		
		FormLayout detailedInfoLayout = new FormLayout();
		
		String[] publicationTypeDBValues = CompleteVanhatkirjatCache.publicationTypes.toArray(new String[CompleteVanhatkirjatCache.publicationTypes.size()]);
		NativeSelect publicationTypeField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(publicationTypeDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_PUBLICATIONTYPE, publicationTypeDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(publicationTypeField, "Application.AddBook.Info.PublicationType");
		publicationTypeField.setCaption(translator.localize(Const.publicationTypeKey));
		publicationTypeField.setRequired(true);
		publicationTypeField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		publicationTypeField.setValidationVisible(false);
		
		String[] langDBValues = CompleteVanhatkirjatCache.languages.toArray(new String[CompleteVanhatkirjatCache.languages.size()]);
		NativeSelect languageField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(langDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_LANGUAGE, langDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(languageField, "Application.AddBook.Info.Language");
		languageField.setCaption(translator.localize(Const.languageKey));
		languageField.setRequired(true);
		languageField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		languageField.setValidationVisible(false);
		
		String[] fromLanguageDBValues = CompleteVanhatkirjatCache.fromLanguages.toArray(new String[CompleteVanhatkirjatCache.fromLanguages.size()]);
		NativeSelect fromLanguageField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(fromLanguageDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_FROMLANGUAGE, fromLanguageDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(fromLanguageField, "Application.AddBook.Info.FromLanguage");
		fromLanguageField.setCaption(translator.localize(Const.fromLanguageKey));
		
		NativeSelect bookplateField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(bookplateField, "Application.AddBook.Info.Bookplate");
		bookplateField.setCaption(translator.localize(Const.bookplateKey));
		
		NativeSelect priceMarkField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(priceMarkField, "Application.AddBook.Info.PriceMark");
		priceMarkField.setCaption(translator.localize(Const.priceMarkKey));
		
		NativeSelect imprimaturField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(imprimaturField, "Application.AddBook.Info.Imprimatur");
		imprimaturField.setCaption(translator.localize(Const.imprimaturKey));
		
		NativeSelect mapsField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(mapsField, "Application.AddBook.Info.Maps");
		mapsField.setCaption(translator.localize(Const.mapsKey));
		
		String[] conditionFieldDBValues = CompleteVanhatkirjatCache.conditionTypes.toArray(new String[CompleteVanhatkirjatCache.conditionTypes.size()]);
		NativeSelect conditionField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(conditionFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_CONDITION, conditionFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(conditionField, "Application.AddBook.Info.Condition");
		conditionField.setCaption(translator.localize(Const.conditionKey));
		
		NativeSelect illustrationField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(illustrationField, "Application.AddBook.Info.Illustration");
		illustrationField.setCaption(translator.localize(Const.illustrationKey));
		
		NativeSelect stampField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(stampField, "Application.AddBook.Info.Stamp");
		stampField.setCaption(translator.localize(Const.stampKey));
		
		NativeSelect attachmentsField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(attachmentsField, "Application.AddBook.Info.Attachments");
		attachmentsField.setCaption(translator.localize(Const.attachmentsKey));
		
		NativeSelect editionSubscriptionField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(editionSubscriptionField, "Application.AddBook.Info.EditionSubscription");
		editionSubscriptionField.setCaption(translator.localize(Const.editionSubscriptionKey));
		
		String[] deficiencyFieldDBValues = CompleteVanhatkirjatCache.deficiencyTypes.toArray(new String[CompleteVanhatkirjatCache.deficiencyTypes.size()]);
		NativeSelect deficienciesField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(deficiencyFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_DEFICIENCIES, deficiencyFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(deficienciesField, "Application.AddBook.Info.Deficiencies");
		deficienciesField.setCaption(translator.localize(Const.deficienciesKey));
		
		String[] ligatureFieldDBValues = CompleteVanhatkirjatCache.ligatureTypes.toArray(new String[CompleteVanhatkirjatCache.ligatureTypes.size()]);
		NativeSelect ligatureField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(ligatureFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_LIGATURE, ligatureFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(ligatureField, "Application.AddBook.Info.Ligature");
		ligatureField.setCaption(translator.localize(Const.ligatureKey));
		
		NativeSelect sealField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		setHelp(sealField, "Application.AddBook.Info.Seal");
		sealField.setCaption(translator.localize(Const.sealKey));
		
		String[] worksOfLocalInhabitantFieldDBValues = CompleteVanhatkirjatCache.titleFromMunicipalityTypes.toArray(new String[CompleteVanhatkirjatCache.titleFromMunicipalityTypes.size()]);
		NativeSelect worksOfLocalInhabitantField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(worksOfLocalInhabitantFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_WORKS_OF_LOCAL_INHABITANT, worksOfLocalInhabitantFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		setHelp(worksOfLocalInhabitantField, "Application.AddBook.Info.WorksOfLocalInhabitant");
		worksOfLocalInhabitantField.setCaption(translator.localize(Const.worksOfLocalInhabitantKey));
		
		TextArea signatureField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		setHelp(signatureField, "Application.AddBook.Info.Signature");
		signatureField.setCaption(translator.localize(Const.signatureKey));
		
		TextArea ownerOfSubscriptionField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		setHelp(ownerOfSubscriptionField, "Application.AddBook.Info.Omiste");
		ownerOfSubscriptionField.setCaption(translator.localize(Const.omisteKey));
		
		TextArea edgeSubscriptionField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		setHelp(edgeSubscriptionField, "Application.AddBook.Info.EdgeSubscription");
		edgeSubscriptionField.setCaption(translator.localize(Const.edgeSubscriptionKey));
		
		TextArea additionalInfoField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		setHelp(additionalInfoField, "Application.AddBook.Info.AdditionalInfo");
		additionalInfoField.setCaption(translator.localize(Const.additionalInfoKey));
		
		detailedInfoLayout.addComponents(publicationTypeField, languageField, fromLanguageField, bookplateField, priceMarkField, imprimaturField, mapsField, conditionField, illustrationField, stampField, attachmentsField, editionSubscriptionField, deficienciesField, ligatureField, sealField, worksOfLocalInhabitantField, signatureField, ownerOfSubscriptionField, edgeSubscriptionField, additionalInfoField);
		baseLayout.addComponent(detailedInfoLayout);
		
		Label mappingInfoText = new Label(translator.localize("Application.MappingInfo"));
		mappingInfoText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(mappingInfoText);
		
		FormLayout mappingInfoLayout = new FormLayout();
		
		ComboBox municipalityField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.municipalities, CompleteVanhatkirjatCache.municipalities, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		setHelp(municipalityField, "Application.AddBook.Info.Municipality");
		municipalityField.setCaption(translator.localize(Const.municipalityKey));
		municipalityField.setRequired(true);
		municipalityField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		municipalityField.setValidationVisible(false);
		
		String[] mappingTargetDBValues = CompleteVanhatkirjatCache.mappingTargets.toArray(new String[CompleteVanhatkirjatCache.mappingTargets.size()]);
		NativeSelect mappingTargetField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(mappingTargetDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_MAPPINGTARGET, mappingTargetDBValues), translator.localize(Const.allMappingTargetsKey), 0);
		setHelp(mappingTargetField, "Application.AddBook.Info.MappingTarget");
		mappingTargetField.setCaption(translator.localize(Const.mappingTargetKey));
		mappingTargetField.setRequired(true);
		mappingTargetField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		mappingTargetField.setValidationVisible(false);
		
		ComboBox collectionField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.publicCollections, CompleteVanhatkirjatCache.publicCollections, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY)); // translator.localize(Const.countyInputPrompt)
		setHelp(collectionField, "Application.AddBook.Info.Collection");
		collectionField.setCaption(translator.localize(Const.collectionKey));
		collectionField.setValidationVisible(false);
		collectionField.setNewItemsAllowed(true);
		
		TextField emailField = VaadinTools.createTextField(250, null, 50, false, "add-book-field");
		setHelp(emailField, "Application.AddBook.Info.Email");
		emailField.setCaption(translator.localize(Const.emailKey));
		emailField.setRequired(true);
		emailField.setValidationVisible(true);
		emailField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		emailField.addValidator(new EmailValidator(translator.localize("Application.AddBook.EmailError")));
		emailField.setValidationVisible(false);
		
		mappingInfoLayout.addComponents(municipalityField, mappingTargetField, new Label(translator.localize("Application.AddBook.Collection.Note")), collectionField, emailField);
		baseLayout.addComponent(mappingInfoLayout);
		
		Label disclaimerText = new Label(translator.localize("Application.AddBook.DisclaimerText"), ContentMode.HTML);
		disclaimerText.addStyleName("disclaimer-text");
		disclaimerText.setWidth(50, Unit.PERCENTAGE);
		CheckBox disclaimer = VaadinTools.createCheckBox(translator.localize("Application.AddBook.DisclaimerAccept"), false, "disclaimer-accept");
		disclaimer.setRequired(true);
		disclaimer.setValidationVisible(false);
		disclaimer.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		baseLayout.addComponents(disclaimerText, disclaimer);
		
		NativeButton submitBtn = VaadinTools.createNativeButton(translator.localize("Application.AddBook.Add"), FontAwesome.PLUS, null, "add-book-submit");
		submitBtn.addClickListener(e -> {
			try {
				titleField.setValidationVisible(true);
				publicationYearField.setValidationVisible(true);
				publicationTypeField.setValidationVisible(true);
				languageField.setValidationVisible(true);
				municipalityField.setValidationVisible(true);
				mappingTargetField.setValidationVisible(true);
				emailField.setValidationVisible(true);
				disclaimer.setValidationVisible(true);
				titleField.validate();
				publicationYearField.validate();
				publicationTypeField.validate();
				languageField.validate();
				collectionField.validate();
				municipalityField.validate();
				mappingTargetField.validate();
				emailField.validate();
				disclaimer.validate();
				
				String author = authorField.getValue() == null ? null : authorField.getValue().toString();
				String title = StringTools.isEmptyOrNull(titleField.getValue()) ? null : titleField.getValue().toString();
				int publicationYear = StringTools.isEmptyOrNull(publicationYearField.getValue()) ? 0 : Integer.parseInt(publicationYearField.getValue());
				String placeOfPrinting = StringTools.isEmptyOrNull((String)placeOfPrintingField.getValue()) ? null : placeOfPrintingField.getValue().toString();
				String printingOffice = StringTools.isEmptyOrNull(printingOfficeField.getValue()) ? null : printingOfficeField.getValue().toString();
				String publicationType = publicationTypeField.getValue() == null ? null : publicationTypeField.getValue().toString();
				String language = languageField.getValue() == null ? null : languageField.getValue().toString();
				String fromLanguage = fromLanguageField.getValue() == null ? null : fromLanguageField.getValue().toString();
				int bookplate = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(bookplateField.getValue() == null ? null : bookplateField.getValue().toString());
				int priceMark = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(priceMarkField.getValue() == null ? null : priceMarkField.getValue().toString());
				int imprimatur = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(imprimaturField.getValue() == null ? null : imprimaturField.getValue().toString());
				int maps = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(mapsField.getValue() == null ? null : mapsField.getValue().toString());
				String condition = conditionField.getValue() == null ? null : conditionField.getValue().toString();
				int illustration = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(illustrationField.getValue() == null ? null : illustrationField.getValue().toString());
				int stamp = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(stampField.getValue() == null ? null : stampField.getValue().toString());
				int attachments = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(attachmentsField.getValue() == null ? null : attachmentsField.getValue().toString());
				int editionSubscription = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(editionSubscriptionField.getValue() == null ? null : editionSubscriptionField.getValue().toString());
				String deficiencies = deficienciesField.getValue() == null ? null : deficienciesField.getValue().toString();
				String ligature = ligatureField.getValue() == null ? null : ligatureField.getValue().toString();
				int seal = CompleteVanhatkirjatUtils.getBooleanLikeIntValueFromUIString(sealField.getValue() == null ? null : sealField.getValue().toString());
				String worksOfLocalInhabitant = worksOfLocalInhabitantField.getValue() == null ? null : worksOfLocalInhabitantField.getValue().toString();
				String signature = StringTools.isEmptyOrNull(signatureField.getValue()) ? null : signatureField.getValue().toString();
				String ownerOfSubscription = StringTools.isEmptyOrNull(ownerOfSubscriptionField.getValue()) ? null : ownerOfSubscriptionField.getValue().toString();
				String edgeSubscription = StringTools.isEmptyOrNull(edgeSubscriptionField.getValue()) ? null : edgeSubscriptionField.getValue().toString();
				String additionalInfo = StringTools.isEmptyOrNull(additionalInfoField.getValue()) ? null : additionalInfoField.getValue().toString();
				String municipality = municipalityField.getValue() == null ? null : municipalityField.getValue().toString();
				String mappingTarget = mappingTargetField.getValue() == null ? null : mappingTargetField.getValue().toString();
				String email = StringTools.isEmptyOrNull(emailField.getValue()) ? null : emailField.getValue().toString();
				String collection = collectionField.getValue() == null ? null : collectionField.getValue().toString();
				
				int newVkid = DBTools.getNextAvailableVkidInDatabase();
				Vanhatkirjat newVk = DBTools.getNewVanhatkirjatWithFields(newVkid, author, title, publicationYear, placeOfPrinting, printingOffice, publicationType, language, fromLanguage, bookplate, priceMark, imprimatur, maps, condition, illustration, stamp, attachments, editionSubscription, deficiencies, ligature, seal, worksOfLocalInhabitant, signature, ownerOfSubscription, edgeSubscription, additionalInfo, municipality, mappingTarget, 0, email, collection, new Date(), null, null);
				if(DBTools.addNewVanhatkirjatToDatabase(newVk, Const.STATUS_WWW_AND_UNPUBLISHED)) {
					log.info("Email address " + email + " (IP-address: " + UI.getCurrent().getPage().getWebBrowser().getAddress() + ") accepted disclaimer related to adding a new book with vkid (primary key in database) " + newVkid);
					CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(newVkid, false, false);
					AddBookNotificationEmail emailSender = new AddBookNotificationEmail(newVk);
					emailSender.doRun();
					VaadinTools.showNotification(translator.localize("Application.AddBook.SaveSuccess"), null);
					CompleteVanhatkirjat newCvk = new CompleteVanhatkirjat();
					try {
						newCvk.extend(newVk);
						UI.getCurrent().addWindow(new VanhatkirjatDetailsWindow(translator, newCvk, false));
					} catch (Exception e1) {
						log.error("Unable to extend vanhatkirjat");
					}
					
					baseLayout.removeAllComponents();
					init();
				} else {
					log.error("Unable to store vanhatkirjat model to database");
					VaadinTools.showError(translator.localize("Application.AddBook.SaveError"), translator.localize("Application.Error.ContactAvaa"));
				}
					
			} catch(InvalidValueException ex) {
				VaadinTools.showWarning(translator.localize("Application.AddBook.SubmitError"), null);
			}
		});
		baseLayout.addComponent(submitBtn);
		
		setCompositionRoot(baseLayout);
	}
	
	private void setHelp(AbstractComponent component, String propertyStr) {
		if(! translator.localize(propertyStr).trim().equals(Const.STRING_EMPTY)) {
			component.setIcon(FontAwesome.QUESTION_CIRCLE);
			component.setDescription(translator.localize(propertyStr));
		}
	}
	
	class AddBookNotificationEmail extends SendEmailThread<String> {

		private Vanhatkirjat newVk;
		private static final String FROM_EMAIL_ADDRESS = "no-reply@avaa.tdata.fi";
		private static final String SUBJECT = "Uusi kirja lisätty";
		private static final String TO_EMAIL_ADDRESS = "tuija.laine@helsinki.fi";
		
		public AddBookNotificationEmail(Vanhatkirjat newVk) {
			super(TO_EMAIL_ADDRESS, null);
			this.newVk = newVk;
		}
		
		@Override
		public void doRun() {
			String body = "Uusi kirja nimeltä \"" + newVk.getTeoknimi() + "\" lisättiin vanhatkirjat sovellukseen.";
			sendMail(FROM_EMAIL_ADDRESS, SUBJECT, body, true);
		}
		
	}
}

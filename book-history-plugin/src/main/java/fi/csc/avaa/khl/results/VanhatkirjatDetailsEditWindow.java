/**
 * 
 */
package fi.csc.avaa.khl.results;

import java.util.Arrays;
import java.util.Date;
import java.util.TreeSet;


import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;


import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.admin.tabs.Reconstructible;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.DBTools;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.customcomponent.ItemDetailsWindow;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class VanhatkirjatDetailsEditWindow extends ItemDetailsWindow {
	
	private static final long serialVersionUID = 1L;
	private CompleteVanhatkirjat cvk;
	private static AvaaLogger log = new AvaaLogger(VanhatkirjatDetailsEditWindow.class.getName());
	private int newStatus;
	private Reconstructible reconstructibleContainer;
	
	public VanhatkirjatDetailsEditWindow(Translator translator, CompleteVanhatkirjat cvk, String windowCaption, int newStatus, Reconstructible reconstructibleContainer) {
		super(translator, 700, 500, true, true, true);
		this.reconstructibleContainer = reconstructibleContainer;
		setCaption(windowCaption);
		baseLayout.setSpacing(true);
		this.cvk = cvk;
		this.newStatus = newStatus;
		init();
	}
	
	@Override
	protected void init() {
		Label bookInfoText = new Label(translator.localize("Application.BookInfo"));
		bookInfoText.addStyleName("vk-details-header");
		
		baseLayout.addComponent(bookInfoText);
		
		FormLayout basicInfoLayout = new FormLayout();
		
		ComboBox authorField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.adminAuthors, CompleteVanhatkirjatCache.adminAuthors, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		authorField.setCaption(translator.localize(Const.authorKey));
		authorField.setNewItemsAllowed(true);
		authorField.setValue(cvk.getVanhatkirjat().getTekija());
		
		TextField titleField = VaadinTools.createTextField(500, null, 150, false, "add-book-field");
		titleField.setCaption(translator.localize(Const.titleKey));
		titleField.setValue(cvk.getVanhatkirjat().getTeoknimi());
		titleField.setRequired(true);
		titleField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		titleField.setValidationVisible(false);
		
		TextField publicationYearField = VaadinTools.createTextField(50, null, 4, true, "add-book-field");
		publicationYearField.setCaption(translator.localize(Const.publicationYearKey));
		publicationYearField.setValue(String.valueOf(cvk.getVanhatkirjat().getPainovuosi()));
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
		
		ComboBox placeOfPrintingField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.placeOfPrintings, CompleteVanhatkirjatCache.placeOfPrintings, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		placeOfPrintingField.setCaption(translator.localize(Const.placeOfPrintingKey));
		placeOfPrintingField.setValidationVisible(false);
		placeOfPrintingField.setNewItemsAllowed(true);
		placeOfPrintingField.setValue(cvk.getVanhatkirjat().getPainopaikka() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getVanhatkirjat().getPainopaikka());
		
		TextField printingOfficeField = VaadinTools.createTextField(250, null, 50, true, "add-book-field");
		printingOfficeField.setCaption(translator.localize(Const.printingOfficeKey));
		printingOfficeField.setValue(cvk.getVanhatkirjat().getKirjapaino());
		
		basicInfoLayout.addComponents(authorField, titleField, publicationYearField, placeOfPrintingField, printingOfficeField);
		baseLayout.addComponent(basicInfoLayout);
		
		Label bookDetailsText = new Label(translator.localize("Application.BookInfo.Details"));
		bookDetailsText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(bookDetailsText);
		
		FormLayout detailedInfoLayout = new FormLayout();
		
		String[] publicationTypeDBValues = CompleteVanhatkirjatCache.publicationTypes.toArray(new String[CompleteVanhatkirjatCache.publicationTypes.size()]);
		NativeSelect publicationTypeField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(publicationTypeDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_PUBLICATIONTYPE, publicationTypeDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		publicationTypeField.setCaption(translator.localize(Const.publicationTypeKey));
		publicationTypeField.setValue(cvk.getJulkaisulajiinfo() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getJulkaisulajiinfo().getJulklaji());
		publicationTypeField.setRequired(true);
		publicationTypeField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		publicationTypeField.setValidationVisible(false);
		
		TreeSet<String> languages = CompleteVanhatkirjatCache.languages;
		languages.add(Const.UNKNOWN_KEY);
		String[] langDBValues = languages.toArray(new String[languages.size()]);
		NativeSelect languageField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(langDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_LANGUAGE, langDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		languageField.setCaption(translator.localize(Const.languageKey));
		languageField.setValue(cvk.getKieliinfo() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getKieliinfo().getKieli());
		languageField.setRequired(true);
		languageField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		languageField.setValidationVisible(false);
		
		String[] fromLanguageDBValues = CompleteVanhatkirjatCache.fromLanguages.toArray(new String[CompleteVanhatkirjatCache.fromLanguages.size()]);
		NativeSelect fromLanguageField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(fromLanguageDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_FROMLANGUAGE, fromLanguageDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		fromLanguageField.setCaption(translator.localize(Const.fromLanguageKey));
		fromLanguageField.setValue(cvk.getKielesta() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getKielesta().getKieli());
		
		NativeSelect bookplateField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		bookplateField.setCaption(translator.localize(Const.bookplateKey));
		bookplateField.setValue(convertForUI(cvk.getVanhatkirjat().getExlibris()));
		
		NativeSelect priceMarkField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		priceMarkField.setCaption(translator.localize(Const.priceMarkKey));
		priceMarkField.setValue(convertForUI(cvk.getVanhatkirjat().getHintamerk()));
		
		NativeSelect imprimaturField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		imprimaturField.setCaption(translator.localize(Const.imprimaturKey));
		imprimaturField.setValue(convertForUI(cvk.getVanhatkirjat().getImprimatur()));
		
		NativeSelect mapsField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		mapsField.setCaption(translator.localize(Const.mapsKey));
		mapsField.setValue(convertForUI(cvk.getVanhatkirjat().getKartat()));
		
		String[] conditionFieldDBValues = CompleteVanhatkirjatCache.conditionTypes.toArray(new String[CompleteVanhatkirjatCache.conditionTypes.size()]);
		NativeSelect conditionField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(conditionFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_CONDITION, conditionFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		conditionField.setCaption(translator.localize(Const.conditionKey));
		conditionField.setValue(cvk.getKuntoluokitus() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getKuntoluokitus().getKunto());
		
		NativeSelect illustrationField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		illustrationField.setCaption(translator.localize(Const.illustrationKey));
		illustrationField.setValue(convertForUI(cvk.getVanhatkirjat().getKuvitus()));
		
		NativeSelect stampField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		stampField.setCaption(translator.localize(Const.stampKey));
		stampField.setValue(convertForUI(cvk.getVanhatkirjat().getLeima()));
		
		NativeSelect attachmentsField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		attachmentsField.setCaption(translator.localize(Const.attachmentsKey));
		attachmentsField.setValue(convertForUI(cvk.getVanhatkirjat().getLiitteita()));
		
		NativeSelect editionSubscriptionField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		editionSubscriptionField.setCaption(translator.localize(Const.editionSubscriptionKey));
		editionSubscriptionField.setValue(convertForUI(cvk.getVanhatkirjat().getPainosmerk()));
		
		String[] deficiencyFieldDBValues = CompleteVanhatkirjatCache.deficiencyTypes.toArray(new String[CompleteVanhatkirjatCache.deficiencyTypes.size()]);
		NativeSelect deficienciesField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(deficiencyFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_DEFICIENCIES, deficiencyFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		deficienciesField.setCaption(translator.localize(Const.deficienciesKey));
		deficienciesField.setValue(cvk.getPuute() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getPuute().getPuutenimi());
		
		String[] ligatureFieldDBValues = CompleteVanhatkirjatCache.ligatureTypes.toArray(new String[CompleteVanhatkirjatCache.ligatureTypes.size()]);
		NativeSelect ligatureField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(ligatureFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_LIGATURE, ligatureFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		ligatureField.setCaption(translator.localize(Const.ligatureKey));
		ligatureField.setValue(cvk.getSidottu() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getSidottu().getSidonta());
		
		NativeSelect sealField = VaadinTools.createNativeSelect(Arrays.asList(Const.YES_KEY, Const.NO_KEY), Arrays.asList(translator.localize(Const.YES_KEY), translator.localize(Const.NO_KEY)), translator.localize(Const.notKnownKey), 0);
		sealField.setCaption(translator.localize(Const.sealKey));
		sealField.setValue(convertForUI(cvk.getVanhatkirjat().getSinetti()));
		
		String[] worksOfLocalInhabitantFieldDBValues = CompleteVanhatkirjatCache.titleFromMunicipalityTypes.toArray(new String[CompleteVanhatkirjatCache.titleFromMunicipalityTypes.size()]);
		NativeSelect worksOfLocalInhabitantField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(worksOfLocalInhabitantFieldDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_WORKS_OF_LOCAL_INHABITANT, worksOfLocalInhabitantFieldDBValues), translator.localize(Const.FIELD_CHOOSE_KEY), 0);
		worksOfLocalInhabitantField.setCaption(translator.localize(Const.worksOfLocalInhabitantKey));
		worksOfLocalInhabitantField.setValue(cvk.getTeospk() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getTeospk().getTeospknimi());
		
		TextArea signatureField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea");
		signatureField.setWordwrap(true);
		signatureField.setCaption(translator.localize(Const.signatureKey));
		signatureField.setValue(cvk.getVanhatkirjat().getNimikirj());
		
		TextArea ownerOfSubscriptionField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		ownerOfSubscriptionField.setWordwrap(true);
		ownerOfSubscriptionField.setCaption(translator.localize(Const.omisteKey));
		ownerOfSubscriptionField.setValue(cvk.getVanhatkirjat().getOmiste());
		
		TextArea edgeSubscriptionField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		edgeSubscriptionField.setWordwrap(true);
		edgeSubscriptionField.setCaption(translator.localize(Const.edgeSubscriptionKey));
		edgeSubscriptionField.setValue(cvk.getVanhatkirjat().getReunamerk());
		
		TextArea additionalInfoField = VaadinTools.createTextArea(0, null, 10000, true, "resizable-textarea"); 
		additionalInfoField.setWordwrap(true);
		additionalInfoField.setCaption(translator.localize(Const.additionalInfoKey));
		additionalInfoField.setValue(cvk.getVanhatkirjat().getLisatieto());
		
		detailedInfoLayout.addComponents(publicationTypeField, languageField, fromLanguageField, bookplateField, priceMarkField, imprimaturField, mapsField, conditionField, illustrationField, stampField, attachmentsField, editionSubscriptionField, deficienciesField, ligatureField, sealField, worksOfLocalInhabitantField, signatureField, ownerOfSubscriptionField, edgeSubscriptionField, additionalInfoField);
		baseLayout.addComponent(detailedInfoLayout);
		
		Label mappingInfoText = new Label(translator.localize("Application.MappingInfo"));
		mappingInfoText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(mappingInfoText);
		
		FormLayout mappingInfoLayout = new FormLayout();

		ComboBox collectionField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.adminCollections, CompleteVanhatkirjatCache.adminCollections, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		collectionField.setDescription(translator.localize("Application.AddBook.Info.Collection"));
		collectionField.setCaption(translator.localize(Const.collectionKey));
		collectionField.setValidationVisible(false);
		collectionField.setNewItemsAllowed(true);
		collectionField.setValue(cvk.getVanhatkirjat().getKokoelma() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getVanhatkirjat().getKokoelma());
		
		ComboBox municipalityField = VaadinTools.createComboBox(CompleteVanhatkirjatCache.municipalities, CompleteVanhatkirjatCache.municipalities, translator.localize(Const.FIELD_CHOOSE_KEY), translator.localize(Const.FIELD_CHOOSE_KEY));
		municipalityField.setCaption(translator.localize(Const.municipalityKey));
		municipalityField.setRequired(true);
		municipalityField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		municipalityField.setValidationVisible(false);
		municipalityField.setValue(cvk.getKuntainfo() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getKuntainfo().getCapitalkuntanimi());
		
		String[] mappingTargetDBValues = CompleteVanhatkirjatCache.mappingTargets.toArray(new String[CompleteVanhatkirjatCache.mappingTargets.size()]);
		NativeSelect mappingTargetField = VaadinTools.createNativeSelect(StringTools.getAlphabeticallyOrderedStringSet(mappingTargetDBValues), CompleteVanhatkirjatUtils.getTranslations(translator, Const.PREFIX_MAPPINGTARGET, mappingTargetDBValues), translator.localize(Const.allMappingTargetsKey), 0);
		mappingTargetField.setCaption(translator.localize(Const.mappingTargetKey));
		mappingTargetField.setRequired(true);
		mappingTargetField.setRequiredError(translator.localize(Const.FIELD_REQUIRED_KEY));
		mappingTargetField.setValidationVisible(false);
		mappingTargetField.setValue(cvk.getKartoituskohde() == null ? translator.localize(Const.FIELD_CHOOSE_KEY) : cvk.getKartoituskohde().getKartkohde());
		
		TextField dateField = VaadinTools.createTextField(250, null, 150, false, null);
		dateField.setCaption(translator.localize(Const.dateKey));
		dateField.setValue(StringTools.getStringOrEmptyFromDate(cvk.getVanhatkirjat().getPaivays()));
		dateField.setEnabled(true);
		dateField.addValidator(value -> {
			if(value != null && value.toString().length() > 0) {
				if(CompleteVanhatkirjatUtils.getDateFromString(value.toString()) == null) {
					throw new InvalidValueException(translator.localize("Application.Field.Error.DateFormat"));
				}
			}
		});
		
		TextField formNumberField = VaadinTools.createTextField(250, null, 150, false, null);
		formNumberField.setCaption(translator.localize(Const.formNumberKey));
		formNumberField.setValue(String.valueOf(cvk.getVanhatkirjat().getLomakenum() == 0 ? Const.STRING_EMPTY : cvk.getVanhatkirjat().getLomakenum()));
		formNumberField.setEnabled(true);
		formNumberField.addValidator(value -> {
			if(value != null && value.toString().length() > 0) {
				try {
					Integer.valueOf(value.toString());
				} catch (NumberFormatException e) {
					throw new InvalidValueException(translator.localize("Application.Field.Error.FormNumberFormat"));
				}
			}
		});
		
		TextField statusField = VaadinTools.createTextField(250, null, 150, false, null);
		statusField.setCaption(translator.localize(Const.statusKey));
		statusField.setValue(String.valueOf(cvk.getVanhatkirjat().getStatus()));
		statusField.setEnabled(false);
		
		TextField emailField = VaadinTools.createTextField(250, null, 50, false, "add-book-field");
		emailField.setCaption(translator.localize(Const.emailKey));
		emailField.setValue(cvk.getVanhatkirjat().getLahemail());
		
		mappingInfoLayout.addComponents(collectionField, municipalityField, mappingTargetField, emailField, dateField, formNumberField, statusField);
		baseLayout.addComponent(mappingInfoLayout);
		
		NativeButton submitBtn = VaadinTools.createNativeButton(translator.localize("Review.Accept.Modify.Save"), FontAwesome.SAVE, null, "add-book-submit");
		submitBtn.addClickListener(e -> {
			try {
				titleField.setValidationVisible(true);
				publicationYearField.setValidationVisible(true);
				publicationTypeField.setValidationVisible(true);
				languageField.setValidationVisible(true);
				municipalityField.setValidationVisible(true);
				mappingTargetField.setValidationVisible(true);
				formNumberField.setValidationVisible(true);
				dateField.setValidationVisible(true);
				titleField.validate();
				publicationYearField.validate();
				publicationTypeField.validate();
				languageField.validate();
				municipalityField.validate();
				mappingTargetField.validate();
				collectionField.validate();
				formNumberField.validate();
				dateField.validate();
				
				String author = authorField.getValue() == null ? null : authorField.getValue().toString();
				String title = StringTools.isEmptyOrNull(titleField.getValue()) ? null : titleField.getValue().toString();
				int publicationYear = StringTools.isEmptyOrNull(publicationYearField.getValue()) ? 0 : Integer.parseInt(publicationYearField.getValue());
				String placeOfPrinting = placeOfPrintingField.getValue() == null ? null : placeOfPrintingField.getValue().toString();
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
				int formNumber = StringTools.isEmptyOrNull(formNumberField.getValue()) ? 0 : Integer.parseInt(publicationYearField.getValue());
				Date paivays = dateField.getValue() == null ? null : CompleteVanhatkirjatUtils.getDateFromString(dateField.getValue());
				
				int vkid = cvk.getVanhatkirjat().getVkid();
				Vanhatkirjat modifiedVk = DBTools.getExistingVanhatkirjatWithNewFields(vkid, author, title, publicationYear, placeOfPrinting, printingOffice, publicationType, language, fromLanguage, bookplate, priceMark, imprimatur, maps, condition, illustration, stamp, attachments, editionSubscription, deficiencies, ligature, seal, worksOfLocalInhabitant, signature, ownerOfSubscription, edgeSubscription, additionalInfo, municipality, mappingTarget, formNumber, email, collection, paivays);
				if(modifiedVk != null && DBTools.updateVanhatkirjatToDatabaseWithStatus(modifiedVk, newStatus, true, false)) {
					CompleteVanhatkirjatCache.syncBookInDatabaseToCaches(vkid, false, false);
					VaadinTools.showNotification(translator.localize("Review.Accept.Modification.Success"), null);
					close();
					if(reconstructibleContainer != null) {
						reconstructibleContainer.refresh();
					}
				} else {
					log.error("Unable to store vanhatkirjat model to database");
					VaadinTools.showError(translator.localize("Review.Accept.Modification.Fail"), translator.localize("Application.Error.ContactAvaa"));
				}
					
			} catch(InvalidValueException ex) {
				VaadinTools.showWarning(translator.localize("Application.AddBook.SubmitError"), null);
			}
		});
		baseLayout.addComponent(submitBtn);
	}
	
	private String convertForUI(int code) {
		switch (code) {
		case 0:
			return Const.NO_KEY;
		case 1:
			return Const.YES_KEY;
		default:
			return Const.STRING_EMPTY;
		}
	}
}

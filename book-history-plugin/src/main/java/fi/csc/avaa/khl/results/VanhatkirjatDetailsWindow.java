/**
 * 
 */
package fi.csc.avaa.khl.results;

import java.util.Arrays;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.common.CompleteVanhatkirjatUtils;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.csv.CSVTools;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.StringTools;
import fi.csc.avaa.tools.vaadin.customcomponent.HorizontalKeyValueLabel;
import fi.csc.avaa.tools.vaadin.customcomponent.ItemDetailsWindow;
import fi.csc.avaa.tools.vaadin.language.LanguageTools;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.tools.VaadinTools;

/**
 * @author jmlehtin
 *
 */
public class VanhatkirjatDetailsWindow extends ItemDetailsWindow {

	private static final long serialVersionUID = 1L;
	private CompleteVanhatkirjat cvk;
	private boolean isAdmin;
	
	/**
	 * @param caption
	 */
	public VanhatkirjatDetailsWindow(Translator translator, CompleteVanhatkirjat cvk, boolean isAdmin) {
		super(translator, 700, 500, true, true, true);
		this.cvk = cvk;
		this.isAdmin = isAdmin;
		setCaption(translator.localize("Application.BookInfo.Window.Caption"));
		init();
	}
	
	@Override
	protected void init() {
		Vanhatkirjat vk = cvk.getVanhatkirjat();
		
		Label bookInfoText = new Label(translator.localize("Application.BookInfo"));
		bookInfoText.addStyleName("vk-details-header");
		HorizontalLayout firstRow = new HorizontalLayout();
		firstRow.addStyleName("vk-details-header-row");
		firstRow.setWidth(100, Unit.PERCENTAGE);
		Button csvBtn = VaadinTools.createButton(translator.localize("Application.Csv"), FontAwesome.DOWNLOAD, null, "download-one-btn");
		CSVTools csvTools = new CSVTools(translator, isAdmin);
		FileDownloader downloader = new FileDownloader(csvTools.getVanhatkirjatCSVStream(Arrays.asList(cvk), null));
		downloader.extend(csvBtn);

		firstRow.addComponents(bookInfoText, csvBtn);
		firstRow.setComponentAlignment(csvBtn, Alignment.MIDDLE_CENTER);
		baseLayout.addComponent(firstRow);
		
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.authorKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(vk.getTekija(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.titleKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(vk.getTeoknimi(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.publicationYearKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromYearValue(vk.getPainovuosi(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.placeOfPrintingKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(vk.getPainopaikka(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.printingOfficeKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(vk.getKirjapaino(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		
		Label bookDetailsText = new Label(translator.localize("Application.BookInfo.Details"));
		bookDetailsText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(bookDetailsText);
		
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.publicationTypeKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_PUBLICATIONTYPE, cvk.getJulkaisulajiinfo() == null ? Const.STRING_EMPTY : cvk.getJulkaisulajiinfo().getJulklaji(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.languageKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_LANGUAGE, cvk.getKieliinfo() == null ? Const.STRING_EMPTY : cvk.getKieliinfo().getKieli(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.fromLanguageKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_FROMLANGUAGE, cvk.getKielesta() == null ? Const.STRING_EMPTY : cvk.getKielesta().getKieli(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.bookplateKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getExlibris(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.priceMarkKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getHintamerk(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.imprimaturKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getImprimatur(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.mapsKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getKartat(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.conditionKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_CONDITION, cvk.getKuntoluokitus() == null ? Const.STRING_EMPTY : cvk.getKuntoluokitus().getKunto(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.illustrationKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getKuvitus(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.stampKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getLeima(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.attachmentsKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getLiitteita(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.editionSubscriptionKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getPainosmerk(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.deficienciesKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_DEFICIENCIES, cvk.getPuute() == null ? Const.STRING_EMPTY : cvk.getPuute().getPuutenimi(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.ligatureKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_LIGATURE, cvk.getSidottu() == null ? Const.STRING_EMPTY : cvk.getSidottu().getSidonta(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.sealKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromBooleanLikeIntValue(vk.getSinetti(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.worksOfLocalInhabitantKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_WORKS_OF_LOCAL_INHABITANT, cvk.getTeospk() == null ? Const.STRING_EMPTY : cvk.getTeospk().getTeospknimi(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.signatureKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromString(vk.getNimikirj(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.omisteKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromString(vk.getOmiste(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.edgeSubscriptionKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedBooleanFieldValueForUIFromString(vk.getReunamerk(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.additionalInfoKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(vk.getLisatieto(), translator, Const.notExistKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		
		Label mappingInfoText = new Label(translator.localize("Application.MappingInfo"));
		mappingInfoText.addStyleName("vk-details-subheading");
		baseLayout.addComponent(mappingInfoText);
		
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.mappingTargetKey), 1.0f, LanguageTools.getLocalizedValueForField(Const.PREFIX_MAPPINGTARGET, cvk.getKartoituskohde() == null ? Const.STRING_EMPTY : cvk.getKartoituskohde().getKartkohde(), translator, Const.notKnownKey), 2.0f, true, null, null, null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.municipalityKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(cvk.getKuntainfo() == null ? Const.STRING_EMPTY : cvk.getKuntainfo().getCapitalkuntanimi(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, getMunicipalityWikipediaUrl(cvk.getKuntainfo() == null ? Const.STRING_EMPTY : cvk.getKuntainfo().getCapitalkuntanimi()), null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.maakuntaKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(cvk.getMaakuntainfo() == null ? Const.STRING_EMPTY : cvk.getMaakuntainfo().getMaakunta(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.collectionKey), 1.0f, LanguageTools.getValueOrLocalizedEmptyValue(cvk.getVanhatkirjat().getKokoelma() == null ? Const.STRING_EMPTY : cvk.getVanhatkirjat().getKokoelma(), translator, Const.notKnownKey), 2.0f, true, null, "vk-details-item-value", null, null, null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.dateKey), 1.0f, CompleteVanhatkirjatUtils.getStringFromDate(vk.getPaivays(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
		baseLayout.addComponent(new HorizontalKeyValueLabel(translator.localize(Const.formNumberKey), 1.0f, CompleteVanhatkirjatUtils.getLocalizedFieldValueFromYearValue(vk.getLomakenum(), translator), 2.0f, true, null, "vk-details-item-value", null, null,null, null));
	}
	
	private ExternalResource getMunicipalityWikipediaUrl(String capitalkuntanimi) {
		if(StringTools.isEmptyOrNull(capitalkuntanimi)) {
			return null;
		}
		char[] stringArray = capitalkuntanimi.trim().toCharArray();
		for(int i=0; i < stringArray.length; i++) {
			if(i == 0) {
				stringArray[i] = Character.toUpperCase(stringArray[i]);
			} else {
				stringArray[i] = Character.toLowerCase(stringArray[i]);
			}
	    
	    }
		return new ExternalResource("https://fi.wikipedia.org/wiki/" + new String(stringArray));
	}

}

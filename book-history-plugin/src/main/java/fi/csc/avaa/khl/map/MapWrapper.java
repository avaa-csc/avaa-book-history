package fi.csc.avaa.khl.map;

import java.util.Map;
import java.util.Set;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.ViewContent;
import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.khl.search.QueryBean;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.javascript.JavaScriptTools;
import fi.csc.avaa.tools.vaadin.language.Translator;
import fi.csc.avaa.vaadin.iframe.HtmlContentFrame;

/**
 * 
 * Class for wrapping Map Iframe component into a Vaadin layout
 * 
 * @author jmlehtin
 *
 */
public class MapWrapper extends VerticalLayout {

	public enum TabType {
		FRONT("front"),
		SEARCH("search");
		
		private String val;
		
		private TabType(String val) {
			this.val = val;
		}
		
		public String getValue() {
			return val;
		}
	}

	private static AvaaLogger log = new AvaaLogger(JavaScriptTools.class.getName());
	private static final long serialVersionUID = 1L;
	private HtmlContentFrame mapIframe;

	public MapWrapper() {
		super();
		setSizeFull();
		setMargin(true);
	}
	
	public void setNewMapIframe(MapWrapper.TabType tabType, ResultStats stats, Translator translator, QueryBean queryBean) {
		if(tabType == MapWrapper.TabType.FRONT) {
			JavaScriptTools.sendEncodedStringVariableJavaScript(Const.MAP_DATA_VARIABLE_FRONT_PAGE_MUNICIPALITIES, MapWrapper.createMunicipalitiesJSON(stats.getNewToOriginalMunicipalityMapping(), stats.getMunicipalityAmounts(), stats.getMappingTargetAmountsByMunicipality(), translator, queryBean));
		} else if(tabType == MapWrapper.TabType.SEARCH) {
			JavaScriptTools.sendEncodedStringVariableJavaScript(Const.MAP_DATA_VARIABLE_SEARCH_PAGE_MUNICIPALITIES, MapWrapper.createMunicipalitiesJSON(stats.getNewToOriginalMunicipalityMapping(), stats.getMunicipalityAmounts(), stats.getMappingTargetAmountsByMunicipality(), translator, queryBean));
		}
		
		HtmlContentFrame newMapIframe = getNewMapIframe();
		newMapIframe.setSizeFull();
		newMapIframe.setHeight(800, Unit.PIXELS);
		super.replaceComponent(mapIframe, newMapIframe);
		mapIframe = newMapIframe;
	}

	public HtmlContentFrame getCurrentMapIframe() {
		return mapIframe;
	}
	
	private HtmlContentFrame getNewMapIframe() {
		return new HtmlContentFrame(ViewContent.cxtPath + "/kirjakartoitus.html", "map-iframe");
	}

	public static String createMunicipalitiesJSON(Map<String, Set<String>> newToOriginalMunicipalityMap, Map<String, Integer> municipalityAmounts, Map<String, Map<String, Integer>> mappingTargetAmountsByMunicipality, Translator translator, QueryBean queryBean) {
		try {
			JSONObject amountsByMunicipality = JSONFactoryUtil.createJSONObject();
			int newMunicipalityAmt = 0;
			
			for(Map.Entry<String, Set<String>> newToOriginalMunicipalityItem : newToOriginalMunicipalityMap.entrySet()) {
				String newMunicipality = newToOriginalMunicipalityItem.getKey();
				Set<String> origMunicipalities = newToOriginalMunicipalityItem.getValue();
				JSONObject newMunicipalityValueObj = JSONFactoryUtil.createJSONObject();
				JSONArray origMunicipalitiesValueArray = JSONFactoryUtil.createJSONArray();
				boolean newMunicipalityHasOnlySeurakuntaBooks = true;
				
				int newMunicipalityTotalBookAmt = 0;
				for(String origMunicipality : origMunicipalities) {
					int origMunicipalityTotalBookAmt = municipalityAmounts.get(origMunicipality);
					newMunicipalityTotalBookAmt += origMunicipalityTotalBookAmt;
					boolean origMunicipalityHasOnlySeurakuntaBooks = true;
					if(origMunicipalityTotalBookAmt > 0) {
						JSONObject municipalityValueObj = JSONFactoryUtil.createJSONObject();
						JSONArray mappingTargetsArray = JSONFactoryUtil.createJSONArray();
						Map<String, Integer> mappingTargetAmounts = mappingTargetAmountsByMunicipality.get(origMunicipality);
						if(mappingTargetAmounts == null) {
							log.error("Unable to find mapping target kunta for " + origMunicipality);
						}
						for(Map.Entry<String, Integer> mappingTargetItem : mappingTargetAmounts.entrySet()) {
							JSONObject mappingTargetObj = JSONFactoryUtil.createJSONObject();
							String mappingTargetKey = mappingTargetItem.getKey();
							if(!"seurakunta".equalsIgnoreCase(mappingTargetKey) && !Const.UNKNOWN_KEY.equals(mappingTargetKey)) {
								origMunicipalityHasOnlySeurakuntaBooks = false;
								newMunicipalityHasOnlySeurakuntaBooks = false;
							}
							mappingTargetObj.put("mappingTargetKey", mappingTargetKey);
							mappingTargetObj.put("mappingTargetName", translator.localize(Const.PREFIX_MAPPINGTARGET + mappingTargetKey));
							mappingTargetObj.put("mappingTargetAmount", mappingTargetItem.getValue());
							mappingTargetsArray.put(mappingTargetObj);
						}
						municipalityValueObj.put("originalMunicipalityName", origMunicipality);
						municipalityValueObj.put("originalMunicipalityTotalBookAmount", origMunicipalityTotalBookAmt);
						municipalityValueObj.put("mappingTargets", mappingTargetsArray);
						municipalityValueObj.put("originalMunicipalityHasOnlySeurakuntaBooks", origMunicipalityHasOnlySeurakuntaBooks);
						origMunicipalitiesValueArray.put(municipalityValueObj);
					}
				}
				newMunicipalityValueObj.put("newMunicipalityTotalBookAmount", newMunicipalityTotalBookAmt);
				newMunicipalityValueObj.put("newMunicipalityHasOnlySeurakuntaBooks", newMunicipalityHasOnlySeurakuntaBooks);
				newMunicipalityValueObj.put("originalMunicipalities", origMunicipalitiesValueArray);
				amountsByMunicipality.put(newMunicipality, newMunicipalityValueObj);
				newMunicipalityAmt++;
			}
			amountsByMunicipality.put("newMunicipalityTotalAmount", newMunicipalityAmt);
			if(queryBean != null) {
				amountsByMunicipality.put("query", queryBean.getFieldsAsTranslatedString(translator));
			}
			return amountsByMunicipality.toString(3).trim();
		} catch (JSONException e) {
	        log.error("Unable to create json object: " + e.toString());
	    }
		return null;
	}
}

/**
 * 
*/
package fi.csc.avaa.khl.map;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.tools.logging.AvaaLogger;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * NOT TO BE USED UNLESS SPECIFIED
 * 
 * @author jmlehtin
 *
 */
public class MapTypeSelectionWrapper extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private static AvaaLogger log = new AvaaLogger(MapTypeSelectionWrapper.class.getName());
	private OptionGroup typeSelection;
	private Translator translator;
	private LiferayIPC ipc;
	private Object prevValue;

	public MapTypeSelectionWrapper(Translator translator, LiferayIPC ipc) {
		this.translator = translator;
		this.ipc = ipc;
		setSizeFull();
		setResponsive(true);
	}

	public void createNewContents() {
		removeAllComponents();
		typeSelection = new OptionGroup();
		typeSelection.setMultiSelect(false);
		typeSelection.setImmediate(true);
		typeSelection.setNullSelectionAllowed(false);
		typeSelection.addStyleName("horizontal-radio-input horizontal");
		typeSelection.addItems(MapType.BOOK_AMOUNT, MapType.MAPPING_TARGET);
		typeSelection.setItemCaption(MapType.BOOK_AMOUNT, translator.localize("Application.Map.Type.BookAmount"));
		typeSelection.setItemCaption(MapType.MAPPING_TARGET, translator.localize("Application.Map.Type.MappingTarget"));
		typeSelection.setValue(prevValue == null ? MapType.BOOK_AMOUNT : prevValue);
		addComponent(typeSelection);
		setComponentAlignment(typeSelection, Alignment.BOTTOM_CENTER);
		typeSelection.addValueChangeListener(e -> {
			prevValue = e.getProperty().getValue();
			if(e.getProperty().getValue() == MapType.BOOK_AMOUNT) {
				this.ipc.sendEvent(Const.IPC_EVENT_CHANGE_MAP_FILL_TYPE, MapType.BOOK_AMOUNT.getValue());
			} else if(e.getProperty().getValue() == MapType.MAPPING_TARGET) {
				this.ipc.sendEvent(Const.IPC_EVENT_CHANGE_MAP_FILL_TYPE, MapType.MAPPING_TARGET.getValue());
			} else {
				log.error("Unable to change map type due to unrecognized map type selection event");
			}
		});
	}
	
	public MapType getMapTypeSelection() {
		return typeSelection.getValue().getClass() == MapType.class ? (MapType) typeSelection.getValue() : null;
	}
	
	public enum MapType {
		BOOK_AMOUNT("bookAmount"),
		MAPPING_TARGET("mappingTarget");
		
		private String val;
		
		private MapType(String val) {
			this.val = val;
		}
		
		public String getValue() {
			return val;
		}
	}
}

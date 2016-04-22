/**
 * 
 */
package fi.csc.avaa.khl.admin.tabs;

import java.util.Collection;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.CompleteVanhatkirjatCache;
import fi.csc.avaa.khl.common.CompleteVanhatkirjat;
import fi.csc.avaa.khl.results.KirjakartoitusAdminAcceptGrid;
import fi.csc.avaa.khl.results.KirjakartoitusAdminAddedModifiedGrid;
import fi.csc.avaa.khl.results.KirjakartoitusAdminDeletedGrid;
import fi.csc.avaa.khl.results.KirjakartoitusBaseGrid;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class ReviewPage extends CustomComponent implements Reconstructible {

	private static final long serialVersionUID = 1L;
	private VerticalLayout baseLayout;
	private Translator translator;
	private OptionGroup gridSelector;
	private VerticalLayout gridLayout;
	private KirjakartoitusAdminAcceptGrid acceptGrid;
	private KirjakartoitusAdminAddedModifiedGrid addedModifiedGrid;
	private KirjakartoitusAdminDeletedGrid deletedGrid;
	private static final String ACCEPT = "accept", ADDED_MODIFIED = "addedModified", DELETED = "deleted";
	
	public ReviewPage(Translator translator) {
		this.translator = translator;
		
		baseLayout = new VerticalLayout();
		baseLayout.setSpacing(true);
		baseLayout.setMargin(true);
		baseLayout.setSizeFull();
		
		gridLayout = new VerticalLayout();
		gridLayout.setMargin(true);
		gridLayout.setSpacing(true);
		gridLayout.setSizeFull();
		
		setCompositionRoot(baseLayout);
		
		gridSelector = new OptionGroup(this.translator.localize("Review.Choose.Choose"));
		gridSelector.setImmediate(true);
		gridSelector.setMultiSelect(false);
		gridSelector.setNewItemsAllowed(false);
		gridSelector.setNullSelectionAllowed(false);
		gridSelector.addStyleName("horizontal-radio-input");
		gridSelector.addItems(ACCEPT, ADDED_MODIFIED, DELETED);
		gridSelector.setItemCaption(ACCEPT, this.translator.localize("Review.Choose.Accept"));
		gridSelector.setItemCaption(ADDED_MODIFIED, this.translator.localize("Review.Choose.AddedModified"));
		gridSelector.setItemCaption(DELETED, this.translator.localize("Review.Choose.Deleted"));
		
		baseLayout.addComponents(gridSelector, gridLayout);
		
		acceptGrid = new KirjakartoitusAdminAcceptGrid(translator, this);
		addedModifiedGrid = new KirjakartoitusAdminAddedModifiedGrid(this.translator);
		deletedGrid = new KirjakartoitusAdminDeletedGrid(this.translator, this);
		
		gridSelector.addValueChangeListener(e -> {
			String value = (String) e.getProperty().getValue();
			updateGrid(value);
		});
		
		gridSelector.setValue(ACCEPT);
	}

	private void updateGrid(String selection) {
		if(ACCEPT.equals(selection)) {
			updateGridLayout(acceptGrid, CompleteVanhatkirjatCache.getAdminBooksCacheValues());
		} else if(ADDED_MODIFIED.equals(selection)) {
			updateGridLayout(addedModifiedGrid, CompleteVanhatkirjatCache.getAdminBooksCacheValues());
		} else if(DELETED.equals(selection)) {
			updateGridLayout(deletedGrid, CompleteVanhatkirjatCache.getAdminBooksCacheValues());
		}
	}

	private void updateGridLayout(KirjakartoitusBaseGrid grid, Collection<CompleteVanhatkirjat> books) {
		gridLayout.removeAllComponents();
		if(grid.populateGrid(books)) {
			Label resultAmtText = new Label(translator.localize("Search.FoundAmount") + grid.getContainerSize());
			gridLayout.addComponents(resultAmtText, grid);
		} else {
			Label resultAmtText = new Label(translator.localize("Search.FoundAmount") + 0);
			gridLayout.addComponent(resultAmtText);
		}
	}

	public void init() {
		updateGrid((String) gridSelector.getValue());
	}

	@Override
	public boolean hasPendingModifications() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		updateGrid((String) gridSelector.getValue());
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
}

package fi.csc.avaa.khl.admin.tabs;

public interface Reconstructible {
	void init();
	boolean hasPendingModifications();
	void refresh();
	void clean();
}

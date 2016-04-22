package fi.csc.avaa.khl.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.ui.VerticalLayout;

import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * 
 * Class for wrapping Chart component into a Vaadin layout
 * 
 * @author jmlehtin
 *
 */
public class YearDistributionChartWrapper extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private Chart chart;
	private YearDistributionChartFactory chartFactory;

	public YearDistributionChartWrapper(Translator translator) {
		super();
		chartFactory = new YearDistributionChartFactory(translator);
		setSizeFull();
	}
	
	public Chart getCurrentChart() {
		return chart;
	}
	
	public void setNewChart(ResultStats stats) {
		Chart newChart = chartFactory.getChart(stats);
		super.replaceComponent(chart, newChart);
		chart = newChart;
	}
}

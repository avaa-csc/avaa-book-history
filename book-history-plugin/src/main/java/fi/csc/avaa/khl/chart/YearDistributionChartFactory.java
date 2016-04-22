/**
 * 
 */
package fi.csc.avaa.khl.chart;

import java.util.Map;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.Axis;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.ZoomType;
import com.vaadin.server.Sizeable.Unit;

import fi.csc.avaa.khl.common.Const;
import fi.csc.avaa.khl.common.ResultStats;
import fi.csc.avaa.tools.vaadin.language.Translator;

/**
 * @author jmlehtin
 *
 */
public class YearDistributionChartFactory {

	private Translator translator;

	public YearDistributionChartFactory(Translator translator) {
		this.translator = translator;
	}

	public Chart getChart(ResultStats stats) {
		Chart chart = new Chart(ChartType.COLUMN);
		chart.setImmediate(true);
		chart.setResponsive(true);
		chart.setWidth(100, Unit.PERCENTAGE);
		chart.setHeight(250, Unit.PIXELS);
		
		Configuration conf = chart.getConfiguration();
		conf.getTooltip().setHeaderFormat("<span style='font-size: 12px'>" + translator.localize("YearSearch.FrontPage.Chart.XAxis") + ": <b>{point.key}</b></span><br/>");
		conf.getTooltip().setPointFormat("<span style='font-size: 12px'>" + translator.localize("YearSearch.FrontPage.Chart.YAxis") + ": <b>{point.y}</b><br/></span>");
		conf.getLegend().setEnabled(false);
		
		conf.setTitle("");
		Axis xAxis = conf.getxAxis();
		xAxis.setMin(stats.getMinRecordedYear());
		xAxis.setMax(stats.getMaxRecordedYear());
		xAxis.setTitle(translator.localize("YearSearch.FrontPage.Chart.XAxis"));
		xAxis.setTickPixelInterval(50);
		Axis yAxis = conf.getyAxis();
		yAxis.setTitle(translator.localize("YearSearch.FrontPage.Chart.YAxis"));
		int maxAmtInData = 0;
		DataSeries chartData = new DataSeries();
		for(Map.Entry<Integer, Integer> yearlyAmt : stats.getYearlyAmounts().entrySet()) {
			DataSeriesItem dsi = new DataSeriesItem();
			int year = yearlyAmt.getKey();
			int amt = yearlyAmt.getValue();
			dsi.setX(year);
			dsi.setY(amt);
			if(maxAmtInData < amt && year > Const.YEAR_THRESHOLD) {
				maxAmtInData = amt;
			}
			chartData.add(dsi);
		}
		yAxis.setMax(maxAmtInData + 1);
		conf.setSeries(chartData);
		
		PlotOptionsColumn plotOptions = new PlotOptionsColumn();
        plotOptions.setPointWidth(10);
        conf.setPlotOptions(plotOptions);
        
		chart.drawChart(conf);
		
		conf.getChart().setZoomType(ZoomType.XY);
		return chart;
	}

}

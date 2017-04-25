/**
 * 
 */
package org.iita.trainingunit.action;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.Action;

public class ProjectChartAction implements Action {

	private JFreeChart chart;
	private JFreeChart chartBar;

	@Override
	public String execute() throws Exception {

		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("Agriculture", 10);
		dataSet.setValue("Residential heating", 4);
		dataSet.setValue("Commercial products", 15);
		dataSet.setValue("Industry", 42);
		dataSet.setValue("Transportation", 26);
		dataSet.setValue("Others", 3);
		
		DefaultCategoryDataset dataBarSet = new DefaultCategoryDataset();
		dataBarSet.setValue(10, "", "Agriculture");
		dataBarSet.setValue(4, "", "Residential heating");
		dataBarSet.setValue(15, "", "Commercial products");
		dataBarSet.setValue(42, "", "Industry");
		dataBarSet.setValue(26, "", "Transportation");
		dataBarSet.setValue(3, "", "Others");

		chart = ChartFactory.createPieChart(
				"Source of Air Pollution ", // Title
				dataSet,                    // Data
				true,                       // Display the legend
				true,                       // Display tool tips
				false                       // No URLs
				);
		chartBar = ChartFactory.createBarChart3D(
				"Source of House Pollution ", // Title
				"Source",
				"Percentage",
				dataBarSet,                    // Data
				PlotOrientation.VERTICAL,
				true,                       // Display the legend
				true,                       // Display tool tips
				false                       // No URLs
				);

		chart.setBorderVisible(true);
		chartBar.setBorderVisible(true);

		return SUCCESS;
	}

	// This method will get called if we specify <param name="value">chart</param>
	public JFreeChart getChart() {
		return chart;
	}
	// This method will get called if we specify <param name="value">chartBar</param>
	public JFreeChart getChartBar() {
		return chartBar;
	}
}

/**
 * 
 */
package org.iita.jfreechart;

/**
 * @author ken
 *
 */
/*
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import org.jfree.chart.plot. *;
import org.jfree.data.time. *;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
*/
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DatasetUtilities;

import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;

import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.labels. *;

public class JFreeChartFactory {

	public static JFreeChart CreateBarChart()
	{
		//Generate ordinary pie chart
		JFreeChart chart = ChartFactory.createBarChart3D("", "Meat", "sales", getBarDateSet(), PlotOrientation.VERTICAL, true, false, false);
		// Set the chart title and change the font
		chart.setTitle (new TextTitle ("the meat volume of sales map", new Font("blackbody", Font.ITALIC, 22)));
		// Get the first Legend of the statistical charts
		LegendTitle legend = chart.getLegend (0);
		// Modify the font of the Legend (solve the garbage)
		legend.setItemFont (new Font ("Arial", Font.BOLD, 14));
		// Plot pie chart object
		CategoryPlot plot = chart.getCategoryPlot ();
		
		ValueAxis valueAxis = plot.getRangeAxis ();
		
		valueAxis.setLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set the y-axis title (to solve the garbage problem)
		valueAxis.setTickLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set text (solve the garbage problem y-axis)
		
		// ValueAxis.setAutoRange (true);
		// ValueAxis.setFixedAutoRange (50);
		valueAxis.setAutoRangeMinimumSize (50);
		valueAxis.setLowerBound (0);
		valueAxis.setUpperBound (700);
		
		plot.getDomainAxis().setLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set the x-axis title (solve the garbage problem)
		plot.getDomainAxis().setTickLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set the text of the x-axis (solve the garbage problem)
		
		// Set the background color
		plot.setBackgroundPaint(Color.white);
		
		// Set the line color of the y-axis
		plot.setDomainGridlinePaint (Color.PINK);
		// Set the x-axis line color
		plot.setRangeGridlinePaint (Color.PINK);
		
		
		BarRenderer3D renderer = new BarRenderer3D ();
		renderer.setBaseItemLabelGenerator (new StandardCategoryItemLabelGenerator ());
		renderer.setBaseItemLabelsVisible (true);
		
		// Note: this sentence is critical, without sentence, the digital display will be covered, giving the figure does not show up
		renderer.setBasePositiveItemLabelPosition (new ItemLabelPosition (ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset (10D);
		
		plot.setRenderer (renderer);
		
		// Below the "meat" on the top of the
		// Plot.setDomainAxisLocation (AxisLocation.TOP_OR_RIGHT);
		// The default on the left of the "sales" on the right of the
		plot.setRangeAxisLocation (AxisLocation.BOTTOM_OR_RIGHT);
		
		
		// Set the background transparency (0-1.0)
		plot.setBackgroundAlpha (0.9f);
		
		return chart;
	}
	
	private static CategoryDataset getBarDateSet ()
	{
		double da [] [] = new double [] [] {{200,340,400},{300,640,200},{400,340,100}};
		String row [] = {"pork", "dog", "lamb"};
		String colu [] = {"Guangzhou", "Shenzhen", ""};
		
		return DatasetUtilities.createCategoryDataset (row, colu, da);
	}
	/*
	public static JFreeChart CreateLineChart ()
	{
		JFreeChart chart = ChartFactory.createTimeSeriesChart (" Visits statistics timeline "," month ", "Information views", getLineDateSet(), true, true, true);
		
		// Set the sub-title
		TextTitle subtitle = new TextTitle ("the year 2007", new Font ("blackbody", Font.BOLD, 12));
		chart.addSubtitle (subtitle);
		// Set the main title
		chart.setTitle (new TextTitle ("A Honey Nut blog traffic statistics", new Font ("official script ", Font.ITALIC, 15)));
	
		// Get the first Legend of the statistical charts
		LegendTitle legend = chart.getLegend (0);
		// Modify the font of the Legend (solve the garbage)
		legend.setItemFont (new Font ("Arial", Font.BOLD, 14));
		
		XYPlot plot = chart.getXYPlot ();
		
		ValueAxis valueAxis = plot.getRangeAxis ();
		
		valueAxis.setLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set the y-axis title (to solve the garbage problem)
		valueAxis.setTickLabelFont (new Font ("Times New Roman", Font.BOLD, 14)) ;// set text (solve the garbage problem y-axis)
		
		plot.getDomainAxis().setLabelFont(new Font ("Times New Roman", Font.BOLD, 14)) ;// set the x-axis title (solve the garbage problem)
		plot.getDomainAxis().setTickLabelFont(new Font ("Times New Roman", Font.BOLD, 14)) ;// set the text of the x-axis (solve the garbage problem)
		
		
		
		// Set the grid background color
		plot.setBackgroundPaint (Color.white);
		// Set the grid color of the vertical line
		plot.setDomainGridlinePaint (Color.BLUE);
		// Set grid horizontal line color
		plot.setRangeGridlinePaint (Color.pink);
		// Set the the graph xy axis distance
		plot.setAxisOffset (new RectangleInsets (0D, 0D, 0D, 10D));
		
		// XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer ();
		// Xylineandshaperenderer.setBaseItemLabelsVisible (true);
		
		// Set the curve shows the value of the data point
		XYItemRenderer xyitem = plot.getRenderer ();
		xyitem.setBaseItemLabelsVisible (true);
		xyitem.setBasePositiveItemLabelPosition (
		new ItemLabelPosition (ItemLabelAnchor.OUTSIDE12,
		TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator (new
		StandardXYItemLabelGenerator ());
		xyitem.setBaseItemLabelFont (new Font ("Dialog", 1, 14));
		plot.setRenderer (xyitem);
		
		chart.setAntiAlias(true);
		return chart;
	}
	
	private static TimeSeriesCollection getLineDateSet ()
	{
		// Visits statistics Timeline
		TimeSeries timeSeries1 = new TimeSeries ("2010", Month.class);
		TimeSeries timeSeries2 = new TimeSeries ("2011", Month.class);
		// Time curve data collection
		TimeSeriesCollection To = new TimeSeriesCollection (TimeSeriesCollection lineDataset);
		// Constructor data collection
		timeSeries1.add(new Month(1, 2011), 11200);
		timeSeries1.add(new Month(2, 2011), 9000);
		timeSeries1.add(new Month(3, 2011), 6200);
		timeSeries1.add(new Month(4, 2011), 8200);
		timeSeries1.add(new Month(5, 2011), 8200);
		timeSeries1.add(new Month(6, 2011), 12200);
		timeSeries1.add(new Month(7, 2011), 13200);
		
		timeSeries2.add(new Month(1, 2011), 1120);
		timeSeries2.add(new Month(2, 2011), 800);
		timeSeries2.add(new Month(3, 2011), 3200);
		timeSeries2.add(new Month(4, 2011), 2200);
		timeSeries2.add(new Month(5, 2011), 1200);
		timeSeries2.add(new Month(6, 2011), 62200);
		timeSeries2.add(new Month(7, 2011), 3200);
		
		lineDataset.addSeries(timeSeries1);
		lineDataset.addSeries(timeSeries2);
		return lineDataset;
	}*/
	
	
	public static JFreeChart CreatePieChart ()
	{
		// Generate ordinary pie chart
		JFreeChart chart = ChartFactory.createPieChart3D("", 
			// ??Chart title
			getPieDataSet(),	//??data 
			true, // ??whether to display the legend
			true, // ??whether to display tool tips
			false // whether to generate the URL
		);
		// Set the chart title and change the font
		chart.setTitle (new TextTitle ("book sales charts", new Font("blackbody", Font.ITALIC, 14)));
		// Get the first Legend of the statistical charts
		LegendTitle legend = chart.getLegend (0);
		// Modify the legend font
		legend.setItemFont (new Font ("Arial", Font.BOLD, 12));
		// Plot pie chart object
		PiePlot plot = (PiePlot) chart.getPlot ();
		// Set the pie chart label font
		plot.setLabelFont (new Font ("Times New Roman", Font.BOLD, 12));
		
		// Set the start angle
		plot.setStartAngle (150D);
		// Set direction "clockwise"
		plot.setDirection (Rotation.CLOCKWISE);
		// Set transparency, 0.5f as translucent, opaque, 0 is fully transparent
		plot.setForegroundAlpha (0.5f);
		
		// Set the background transparency (0-1.0)
		plot.setBackgroundAlpha (0.9f);
		
		return chart;
	}
	
	private static DefaultPieDataset getPieDataSet ()
	{
	// Generate a pie chart data
		DefaultPieDataset dataset = new DefaultPieDataset ();
		dataset.setValue("Crazy Java handouts", 47000);
		dataset.setValue("lightweight Java EE enterprise combat", 38000);
		dataset.setValue("crazy Ajax handouts", 31000);
		dataset.setValue("Struts 2 The Definitive Guide", 29000);
		dataset.setValue("crazy XML handouts", 25000);
		return dataset;
	}

} 

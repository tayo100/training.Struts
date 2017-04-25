package org.iita.trainingunit.chartUtil;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class TraineeBarChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection dbConnection = null;
	private JFreeChart chart;
	
	public TraineeBarChartServlet() {
		dbConnection = DataAccessObject.getConnection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(dbConnection);

		try {
			dataset.executeQuery("SELECT DISTINCT YEAR(startDate) as Year, COUNT(YEAR(startDate)) as Total FROM Trainee WHERE startDate IS NOT NULL AND YEAR(startDate)>2010 GROUP BY YEAR(startDate) ORDER BY YEAR(startDate)");

			chart = ChartFactory.createBarChart3D("Trainees' Intake/Year", "Year", "Total", dataset, PlotOrientation.VERTICAL, true, true, false);
			
			chart.setTitle (new TextTitle("Trainees' Intake/Year", new Font ("blackbody", Font.ITALIC, 14))); 
			LegendTitle legend = chart.getLegend (0); 

			// modify the legend font 
			legend.setItemFont(new Font (" Times New Roman ", Font.PLAIN, 10)); 
			CategoryPlot plot = (CategoryPlot) chart.getPlot (); 
			chart.setBackgroundPaint (ChartColor.WHITE); 

			// set the histogram to the top of the distance 
			ValueAxis rangeAxis = plot.getRangeAxis() ; 
			rangeAxis.setUpperMargin(0.5); 

			// get the horizontal 
			CategoryAxis categoryAxis = plot.getDomainAxis (); 

			// set the horizontal axis shows the label's font 
			categoryAxis.setLabelFont(new Font("Arial", Font.PLAIN, 10)); 

			// category labels to 45 degree angle // 
			categoryAxis.setCategoryLabelPositions (CategoryLabelPositions.UP_45); 
			categoryAxis.setTickLabelFont(new Font ("Arial", Font.PLAIN, 10)); 
			// get the vertical axis 
			NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis (); 
			// set the vertical axis shows the label's font 
			numberAxis.setLabelFont (new Font ("Arial", Font.PLAIN, 10)); 
			// display data 
			BarRenderer custombarrenderer3d = new BarRenderer(); 
			custombarrenderer3d.setBaseItemLabelPaint(Color.BLACK); // data font color 
			custombarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
			custombarrenderer3d.setBaseItemLabelsVisible(true); 
			plot.setRenderer (custombarrenderer3d); 
			
			chart.setBorderVisible(true);
				
			if (chart != null) {
				int width = 450;
				int height = 250;
				response.reset();
				response.setContentType("image/jpeg");
				OutputStream out = response.getOutputStream();
				final File file1 = new File(getServletContext().getRealPath(".") + "/traineechart.png");
				ChartUtilities.saveChartAsPNG(file1, chart, 350, 200);
				ChartUtilities.writeChartAsJPEG(out, chart, width, height);
				out.flush();
			}
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}catch (Throwable t) {
		    throw new ServletException(t);
		}
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}

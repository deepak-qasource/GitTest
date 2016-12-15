package com.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GenerateSuiteChart {
	FileWriter fileWriter;

	public void genChart(String suiteName, int pass, int fail, int skipped, String outputDirectory) {
		
File file = new File(outputDirectory+"\\"+suiteName+"_chart.html");
		
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append("<html>");
			fileWriter.append("<head>");
			fileWriter.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			fileWriter.append("<title>Combined Results</title>");
			fileWriter.append("<link rel=\"stylesheet\" href=\"style1.css\" type=\"text/css\">");
			fileWriter.append("<script src=\"amcharts.js\" type=\"text/javascript\"></script>");
			fileWriter.append("<script src=\"pie.js\" type=\"text/javascript\"></script>");
			fileWriter.append("<script>var chart;var legend;var chartData = [");
					fileWriter.append("{\"Results\": \"Fail\",\"value\": "+fail+"},");
		fileWriter.append("{\"Results\": \"Pass\",\"value\": "+pass+"},");
		fileWriter.append("{\"Results\": \"Skip\",\"value\": "+skipped+"}");
		fileWriter.append("];");
		fileWriter.append("AmCharts.ready(function () {");
		                // PIE CHART
		fileWriter.append("chart = new AmCharts.AmPieChart();");
		fileWriter.append("chart.dataProvider = chartData;");
		fileWriter.append("chart.titleField = \"Results\";");
		fileWriter.append(" chart.valueField = \"value\";");
		fileWriter.append("chart.outlineColor = \"#FFFFFF\";");
		fileWriter.append("chart.outlineAlpha = 0.8;");
		fileWriter.append("chart.outlineThickness = 2;");
		fileWriter.append("chart.balloonText = \"[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>\";");
		                // this makes the chart 3D
		fileWriter.append("chart.depth3D = 15;");
		fileWriter.append(" chart.angle = 30;");

		                // WRITE
		fileWriter.append(" chart.write(\"chartdiv\");");
		fileWriter.append("});");
		fileWriter.append("</script>");
		fileWriter.append("</head>");

		fileWriter.append("<body>");
		fileWriter.append("<div id=\"chartdiv\" style=\"width: 100%; height: 400px;\"></div>");
		fileWriter.append(" </body>");

		fileWriter.append("</html>");
			fileWriter.close();
		}catch(

	IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// TODO Auto-generated method stub

}

}

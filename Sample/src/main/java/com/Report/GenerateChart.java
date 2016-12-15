package com.Report;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GenerateChart {
	FileWriter fileWriter;
	public void genChart(String suiteName, int pass, int fail, int skipped, String outputDirectory) {
		
File file = new File(outputDirectory+"\\"+suiteName+"_chart.html");
		
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append("<html>");
			fileWriter.append("<head>");
			fileWriter.append("<title>QASource Automation Summary");
			fileWriter.append("</title>");
			fileWriter.append("<LINK rel='stylesheet' href='style.css'></LINK>");
			fileWriter.append("<script type='text/javascript' src='jquery-1.3.2.min.js'></script>");
			fileWriter.append("<script type='text/javascript' src='main.js'></script>");
			fileWriter.append("<script type='text/javascript' src='chartapi.js'></script>");
			fileWriter.append("<script type='text/javascript'>");
			fileWriter.append("google.load('visualization', '1', {packages:['corechart']});");
			fileWriter.append("google.setOnLoadCallback(drawChart);");
			fileWriter.append("function drawChart() {");
			fileWriter.append("var data = google.visualization.arrayToDataTable([");
			fileWriter.append("['Task', '"+suiteName+"'],");
			fileWriter.append("['Passed',  "+pass+"],");
			fileWriter.append("['Failed',  "+fail+"],");
			fileWriter.append("['Skiped',  "+skipped+"],]);");
			fileWriter.append("var chart = new google.visualization.PieChart(document.getElementById('chart_div'));");
			fileWriter.append("chart.draw(data, {width: 430, height: 240, chartArea: { left: 0, top: 0, width: '70%', height: '70%'}, colors:['#70A772','#CB5959','#F5D76C']});");
			fileWriter.append("} </script>");
			fileWriter.append("</head><body>");
			fileWriter.append("<div id='chart_div'></div>");
			fileWriter.append("</body>");
			fileWriter.append("</html>");
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// TODO Auto-generated method stub

	}

}

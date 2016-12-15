package com.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SuiteReporter {
	File indexFile;
	FileWriter fileWriter;;
	
	public SuiteReporter(String outputdirectory){
		indexFile = new File(outputdirectory+ "//index.html");	

		try {
			fileWriter = new FileWriter(indexFile, true);
			fileWriter.append("<html><head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><meta name=\"description\" content=\"\"><meta name=\"author\" content=\"\"><title>QASource Report</title><link href=\"bootstrap.min.css\" rel=\"stylesheet\"><link href=\"heroic-features.css\" rel=\"stylesheet\"></head><body>");
    		fileWriter.append("<div class=\"container\"><header class=\"jumbotron hero-spacer\"><h3 align=\"center\">Final Result of Execution</h3>");
    		fileWriter.append("<div class='widget-content'>");
    		/*fileWriter.append("<table width='45%' cellpadding='0' cellspacing='0' border='0'><tr>");
    		fileWriter.append(" <td align='center' id='chart-container'>");*/
    		fileWriter.append("<iframe src='QASourceRegressionSuite_chart.html' scrolling='no' style='width: 750px; height: 400px; border: 0 none;'></iframe></div></div>");
    		fileWriter.append("</header><hr><div class=\"row\"><div class=\"col-lg-12\"  align=\"center\"><h3>Suites Executed</h3></div></div><div class=\"row text-center\">");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SReport(String suiteName){
		try {
			fileWriter.append("<div class=\"col-md-3 col-sm-6 hero-feature\">");
			fileWriter.append("<div class=\"thumbnail\">");
			fileWriter.append("<div class=\"caption\">");
			fileWriter.append("<h5>Suite Name: <a href=\""+suiteName+".html\" target='_blank'>"+suiteName+"</a></h5>");
			fileWriter.append("<iframe src='"+suiteName+"_chart.html' scrolling='no' style='width: 270px; height: 226px; border: 0 none;'></iframe>");
			fileWriter.append("</div></div></div>");
			
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		

public void closeSReport() {

	try {			
		fileWriter.append("</div><hr><footer><div class=\"row\"><div class=\"col-lg-12\"><p>Copyright &copy; QASource</p></div></div></footer></div><script src=\"js/jquery.js\"></script><script src=\"js/bootstrap.min.js\"></script></body></html>");
    fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}

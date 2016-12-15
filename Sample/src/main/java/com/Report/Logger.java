package com.Report;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	FileWriter fileWriter;
	private File fstream;
	
	public static int count=0;
	File file;
	

	public Logger(String outputdirectory, String suiteName) {
		
		 file = new File(outputdirectory+ "//"+suiteName+".html");	
			
			try {			
				count =0;
				fileWriter = new FileWriter(file, true);
				//	fileWriter = new BufferedWriter(fileWriter);
					
		            fileWriter.append("<html>");
		    		fileWriter.append("<head>");
		    		fileWriter.append("<title>Automation Summary</title>");
		    		fileWriter.append("<LINK rel='stylesheet' href='style.css'></LINK>");
		    		fileWriter.append("<script type='text/javascript' src='jquery-1.3.2.min.js'></script>");
		    		fileWriter.append("<script type='text/javascript' src='main.js'></script>");
		    		fileWriter.append("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
		    		fileWriter.append("</head><body>");
		    		fileWriter.append("<div id=\"chart_div\"></div>");		    	    
		    		fileWriter.append("<div style='width: 384px;'><label for='groupMethodsCheckBox' style='font-weight: bold; margin: 0;'>");
		    		/*fileWriter.append("<label for='methodsFilter_ALL' style='font-weight: bold; margin: 0;'>");
		    		fileWriter.append("<input id='methodsFilter_ALL' type='checkbox' onclick=\"testMethodsFilterChanged(this, 'ALL')\"></input>All</label>");
		    		*/fileWriter.append("<label for='methodsFilter_FAIL' style='margin-left: 20px;'>");
		    		fileWriter.append("<input id='methodsFilter_FAIL' type='checkbox' onclick=\"testMethodsFilterChanged(this, 'FAIL')\" checked=''></input>Failed</label>");
		    		fileWriter.append(" <label for='methodsFilter_PASS'>");
		    		fileWriter.append("<input id='methodsFilter_PASS' type='checkbox' onclick=\"testMethodsFilterChanged(this, 'PASS')\" checked=''></input>Passed</label>");
		    		fileWriter.append("<label for='methodsFilter_SKIP'>");
		    		fileWriter.append("<input id='methodsFilter_SKIP' type='checkbox' onclick=\"testMethodsFilterChanged(this, 'SKIP')\" checked=''></input>Skipped</label>");
		    		/*fileWriter.append("<label for='methodsFilter_CONF'>");
		    		fileWriter.append("<input id='methodsFilter_CONF' type='checkbox' onclick=\"testMethodsFilterChanged(this, 'CONF')\"></input>Config</label></div>");
		    		*/fileWriter.append("</div><br></br>");
		    		fileWriter.append("<div class='content'>");
		    		fileWriter.append("<h2>"+suiteName+" overview</h2>");
		    		fileWriter.append("<div class='widget-box'>");
		    		/*fileWriter.append("<div class='widget-header'>OVERVIEW</div>");*/
		    		fileWriter.append("<div class='widget-content1'>");
		    		fileWriter.append("<table cellpadding='0' cellspacing='0' border='0'><tr>");
		    		fileWriter.append(" <td align='center' id='chart-container'>");
		    		fileWriter.append("<iframe src='"+suiteName+"_chart.html' scrolling='no' style='width: 295px; height: 220px; border: 0 none;'></iframe></td></tr></table></div></div>");
		    		fileWriter.append("<div id='testMethodsByStatus'><table class='testMethodsTable' cellpadding='0' cellspacing='0'><tr class='methodsTableHeader'>");
		    		fileWriter.append("<td nowrap='true'>S.No.</td><td nowrap='true'>Name</td><td nowrap='true'>Description</td><td nowrap='true'>Duration</td><td>Exception</td><td>Screenshot</td>");
		    		fileWriter.append("</tr>");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void log(String name, String suiteName, String className, String desc, String result, String startedAt, String endTime, String duration, String params, String eheader, String exception, String screenshotName){
			try {
				
				if (result.contains("Pass"))
				{ count++;
					fileWriter.append("<tr class='testMethodStatusPASS'>");
                	fileWriter.append("<td width='20%' class='testMethodsTableSNo'>"+count+"</td><td nowrap='true'><a onclick=\"toggleDetailsVisibility('"+name+startedAt+"')\">");   					
                	fileWriter.append(name+"</a></td>");
                	fileWriter.append("<td nowrap='true'>"+desc+"</td>");
                	fileWriter.append("<td nowrap='true'>"+duration+"</td>");
                	/*fileWriter.append("<td nowrap='true'>"+startedAt+"</td>");*/
                	//fileWriter.append("<td nowrap='true' align='center'><a href='file:///" +j_iterator.get("ScreenshotName")+"' target='_blank'>View</a></td>");                    	
                	fileWriter.append("<td nowrap='true'>"+exception+"</td>");
                /*	if(screenshotName.contains("NA"))
                	{
                	fileWriter.append("<td nowrap='true'>"+screenshotName+"</td></tr>");
                	}
                	else
                	{*/
                		fileWriter.append("<td nowrap='true'><a href='Screenshots\\"+screenshotName+"' target='_blank'>View</a></td></tr>");	
                	//}
                	fileWriter.append(" <td colspan='6' class='detailsBox'><div id='"+name+startedAt+"' class='testMethodDetails'>");
                	fileWriter.append("<div><b>Name: </b>"+name+"</div></br>");
                	fileWriter.append("<div><b>Suite Name: </b>"+suiteName+"</div></br>");
                	fileWriter.append("<div><b>Class Name: </b>"+className+"</div></br>");
                	fileWriter.append("<div><b>Parameters: </b>"+params+"</div></br>");
                	fileWriter.append("<div><b>Exception: </b>"+exception+"</div></br>");
                	fileWriter.append("<div><b>Start time: </b>"+startedAt+"</div></br>");
                	fileWriter.append("<div><b>End time: </b>"+endTime+"</div></br>");
                	fileWriter.append("<div><b>Duration: </b>"+duration+"</div></br>");
                	fileWriter.append("</div></td></tr>");
				}
				else if (result.contains("Fail"))
				{
					count++;
					fileWriter.append("<tr id='"+name+startedAt+"_byStatus_failed_FAIL1_row' class='testMethodStatusFAIL'>");
                	fileWriter.append("<td width='20%' class='testMethodsTableSNo'>"+count+"</td><td nowrap='true'><a onclick=\"toggleDetailsVisibility('"+name+startedAt+"_byStatus_failed_FAIL1_exception')\">");   					
                	fileWriter.append(name+"</a></td>");
                	fileWriter.append("<td nowrap='true'>"+desc+"</td>");
                	fileWriter.append("<td nowrap='true'>"+duration+"</td>");
                	/*fileWriter.append("<td nowrap='true'>"+startedAt+"</td>");*/
                	//fileWriter.append("<td nowrap='true' align='center'><a href='file:///" +j_iterator.get("ScreenshotName")+"' target='_blank'>View</a></td>");                    	
                	fileWriter.append("<td nowrap='true'>"+eheader+"</td>");
                	/*if(screenshot.contains("NA"))
                	{
                	fileWriter.append("<td nowrap='true'>"+screenshot+"</td></tr>");
                	}
                	else
                	{*/
                		fileWriter.append("<td nowrap='true'><a href='Screenshots\\"+screenshotName+"' target='_blank'>View</a></td></tr>");	
                	//}
                	fileWriter.append(" <td colspan='6' class='detailsBox'><div id='"+name+startedAt+"_byStatus_failed_FAIL1_exception' class='testMethodDetails'>");
                	fileWriter.append("<div><b>Name: </b>"+name+"</div></br>");
                	fileWriter.append("<div><b>Suite Name: </b>"+suiteName+"</div></br>");
                	fileWriter.append("<div><b>Class Name: </b>"+className+"</div></br>");
                	fileWriter.append("<div><b>Parameters: </b>"+params+"</div></br></br>");
                	fileWriter.append("<div><b>Exception: </b>"+exception+"</div></br></br>");
                	fileWriter.append("<div><b>Start time: </b>"+startedAt+"</div></br>");
                	fileWriter.append("<div><b>End time: </b>"+endTime+"</div></br>");
                	fileWriter.append("<div><b>Duration: </b>"+duration+"</div></br>");
                	fileWriter.append("</div></td></tr>");
				}
				else if (result.contains("Skipped"))
				{ count++;
					fileWriter.append("<tr class='testMethodStatusSKIP'>");
                	fileWriter.append("<td width='20%' class='testMethodsTableSNo'>"+count+"</td><td nowrap='true'><a onclick=\"toggleDetailsVisibility('"+name+startedAt+"')\">");   					
                	fileWriter.append(name+"</a></td>");
                	fileWriter.append("<td nowrap='true'>"+desc+"</td>");
                	fileWriter.append("<td nowrap='true'>"+duration+"</td>");
                	/*fileWriter.append("<td nowrap='true'>"+startedAt+"</td>");*/
                	//fileWriter.append("<td nowrap='true' align='center'><a href='file:///" +j_iterator.get("ScreenshotName")+"' target='_blank'>View</a></td>");                    	
                	fileWriter.append("<td nowrap='true'>"+exception+"</td>");
                	if(screenshotName.contains("NA"))
                	{
                	fileWriter.append("<td nowrap='true'>"+screenshotName+"</td></tr>");
                	}
                	else
                	{
                		fileWriter.append("<td nowrap='true'><a href='file:///"+screenshotName+"' target='_blank'>View</a></td></tr>");	
                	}
                	fileWriter.append(" <td colspan='6' class='detailsBox'><div id='"+name+startedAt+"' class='testMethodDetails'>");
                	fileWriter.append("<div><b>Name: </b>"+name+"</div></br>");
                	fileWriter.append("<div><b>Suite Name: </b>"+suiteName+"</div></br>");
                	fileWriter.append("<div><b>Class Name: </b>"+className+"</div></br>");
                	fileWriter.append("<div><b>Parameters: </b>"+params+"</div></br>");
                	fileWriter.append("<div><b>Exception: </b>"+exception+"</div></br>");
                	fileWriter.append("<div><b>Start time: </b>"+startedAt+"</div></br>");
                	fileWriter.append("<div><b>End time: </b>"+endTime+"</div></br>");
                	fileWriter.append("<div><b>Duration: </b>"+duration+"</div></br>");
                	fileWriter.append("</div></td></tr>");
				}
				
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

	public void closelogger() {

		try {			
			fileWriter.append("</table></div>");
			fileWriter.append("<div class=\"rowLast\"><div class=\"col-lg-12\"><p>Copyright &copy; QASource</p></div></div>");
        fileWriter.append("</body>");
        fileWriter.append("</html>");
        fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.Report;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ReportUtils {

	public static String pstackTrace(Throwable t) {

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		t.printStackTrace(printWriter);
		printWriter.flush();

		String staketrace = stringWriter.getBuffer().toString();

		return staketrace;
	}

	public static String pstackHeader(Throwable t) {

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		t.printStackTrace(printWriter);
		printWriter.flush();

		String staketrace = stringWriter.getBuffer().toString();

		String fstaketrace = staketrace.substring(0, 50);

		return fstaketrace;
	}

	public static String parseTime(Long milliseconds) {

		return new SimpleDateFormat("hh:mm:ss").format(new Date(milliseconds));

	}

	public static String parseTimeDiff(Long endtimemillis, Long starttimemillis) {

		long tdiff = (endtimemillis - starttimemillis);
		long diff = tdiff / 1000;

		if (diff >= 59 && diff <= 540) {
			return (String.format("%.2f", (float) diff / 60) + " mins");

		} else if (diff >= 540 && diff <= 3600) {
			return String.valueOf((new SimpleDateFormat("mm:ss")
					.format(new Date(tdiff))));
		} else if (diff > 3600) {
			return String.valueOf((new SimpleDateFormat("hh:mm:ss")
					.format(new Date(tdiff))));
		} else
			return String.valueOf(diff + " secs");
	}

	public static void getfiles(String filepath) {
	
		File file = new File(filepath);
		
		String s_path = System.getProperty("user.dir");
		try {
			System.out.print("========="+new File(".").getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("=========-----"+System.getProperty("user.dir"));
		System.out.print("=======================================>>"+s_path.substring(0, s_path.lastIndexOf("\\")));

		String s_jsfiles = s_path.concat("\\reportHelpersFiles\\js");
		String s_cssfiles = s_path.concat("\\reportHelpersFiles\\css");
		String s_fontfiles = s_path.concat("\\reportHelpersFiles\\fonts");
		System.out.println(s_jsfiles);
		System.out.println(s_cssfiles);
		if (file.exists()) {
			try {
				
				//--------------------------------------------------
				

					String[]entries = file.list();
					for(String s: entries){
					    File currentFile = new File(file.getPath(),s);
					    currentFile.delete();
					}
					    file.delete();
					    file.mkdir();

				//------------------------------------------------------
				
				
				
				file.delete();
				Thread.sleep(10);
				file.mkdir();
				Thread.sleep(10);
				FileUtils.copyDirectory(new File(s_jsfiles), file);
				FileUtils.copyDirectory(new File(s_cssfiles), file);
				FileUtils.copyDirectory(new File(s_fontfiles), file);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {			
			try {
				file.mkdir();
				Thread.sleep(10);
				FileUtils.copyDirectory(new File(s_jsfiles), file);
				FileUtils.copyDirectory(new File(s_cssfiles), file);
				FileUtils.copyDirectory(new File(s_fontfiles), file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

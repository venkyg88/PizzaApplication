package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PizzaApplication { 

	
	/**
	 * Reads from a text file and sorts them stores in OrderData model class object
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static List<OrderData> readLinesAndSort(File file) throws Exception {	
		List<OrderData> orderList = new ArrayList<>();
		
	    if (!file.exists()) {
	        return orderList;
	     }	    
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     String line = reader.readLine();
	     //skipping first line
	     line = reader.readLine();
	     while (line != null) {
	         String[] splited = line.split("\\s+");
	          
	         if (splited.length > 1) {
	        	 OrderData data = new OrderData();
	        	 data.setPizzaType(splited[0]);
	        	 data.setEpochTime(Long.parseLong(splited[1]));
	        	 orderList.add(data);
	          }          
	          line = reader.readLine();
	      }	   
	      Collections.sort(orderList, orderDataSort);
	      return orderList;
	}
	
	
	
	/**
	 * returns a list of records with human readable strings to be written to a output file
	 * @param orderDataList
	 * @return
	 */
	public static List<String> getOutputList(List<OrderData> orderDataList) {
		
		List<String> list = new ArrayList<>();
		if (orderDataList != null) {
			for (OrderData orderData : orderDataList) {
				String date = convertToReadableDate(orderData.getEpochTime());
				list.add(orderData.getPizzaType() + "\t" + date);
			}
		}		
		return list;
	}
	
	
	
	
	/**
	 * converts the Epoch time (i.e., 1474295087) to Java Date (Mon, 19 Sep 2016 14:24:47 GMT)
	 * @param epochTime
	 * @return
	 */
	public static String convertToReadableDate(long epochTime) {
		
		Date date = new Date(epochTime * 1000L);
		DateFormat format = new SimpleDateFormat("EEE, MMM d, ''yy h:mm a");
	    format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String dateString = format.format(date);
		
		return dateString;	
	}


	
	
	/**
	 * comparator for sorting OrderData based on time Lexicographically
	 */
	private static Comparator<OrderData> orderDataSort = new Comparator<OrderData>() {
		
		@Override
		public int compare(OrderData o1, OrderData o2) {
			return Long.compare(o1.getEpochTime(), o2.getEpochTime());
		}
	};
	
	
	
	/**
	 * this method writes to an external file
	 * @throws IOException
	 */
	private static void writeToFile(File inFile, String outFilePath) throws IOException {
		
		//FileWriter writer = new FileWriter("/Users/venkat/Documents/workspace/PizzaApplication/src/output_data.txt");
		
		PrintWriter writer = new PrintWriter(outFilePath);
		List<String> orderList = new ArrayList<>();
		
		try {
			orderList = getOutputList(PizzaApplication.readLinesAndSort(inFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(String record: orderList){
			writer.write(record.toString());
			writer.write(System.lineSeparator());
			System.out.println(record.toString());
		}
		writer.close();
	}
	
	
	
	
	public static void main(String[] args) {
		
		String inFilePath = args[0];   //first command line argument 
		String outFilePath = args[1];  //second command line argument
		//File inFile = new File("/Users/venkat/Documents/workspace/PizzaApplication/src/sample_data_ordered.txt");
		File inFile = new File(inFilePath);
		
		try {
			//ReadDataFromTextFile.readLines(inFile);		
			PizzaApplication.writeToFile(inFile, outFilePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}

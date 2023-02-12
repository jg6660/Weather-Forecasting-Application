package com.CS9053.city;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.print.DocFlavor.URL;

public class CityList {
  private static CityList instance = new CityList();
  private ArrayList<City> cities = new ArrayList<City>();

  public ArrayList<City> findCitiesByName(String name) {
	  
    ArrayList<City> similarCities = new ArrayList<City>();
    for (City city : this.cities) {
      if (city.similarNameWith(name)) {
        similarCities.add(city);
      }
    }
    return similarCities;
  }

  public static CityList getInstance() {
    return instance;
  }

  private CityList() {
    try {
      this.loadCSV();
    } catch (FileNotFoundException e) {
      Logger.getLogger("CityList").info(e.toString());
    } catch (IOException e) {
      Logger.getLogger("CityList").info(e.toString());
    }
  }
  /*
  private void loadCSV() throws IOException {
    String fileName = "com/CS9053/city/city.csv";
	//String fileName = "/Users/amit/Documents/NYU/Classes/Special\\ Topics\\ Java/Java\\ Project/Resources/weather-forecast-master/src/main/resources/com/CS9053/city/city.csv";
    ClassLoader classLoader = getClass().getClassLoader();
    System.out.println("Class loader: "+classLoader.getResource(fileName).getFile());
    File file = new File(classLoader.getResource(fileName).getFile());
    CSVReader reader = new CSVReader(new FileReader(file));
    String [] nextLine;

    while ((nextLine = reader.readNext()) != null) {
      // nextLine[] is an array of values from the line
      this.cities.add(new City(
          Integer.parseInt(nextLine[0]),
          nextLine[1],
          new Coordinate(
              Double.parseDouble(nextLine[3]),
              Double.parseDouble(nextLine[4])),
          nextLine[2]
      ));
    }
  }
  */
  
  private void loadCSV() throws IOException {
	    String fileName = "com/CS9053/city/city.csv";
		//String fileName = "/Users/amit/Documents/NYU/Classes/Special\\ Topics\\ Java/Java\\ Project/Resources/weather-forecast-master/src/main/resources/com/CS9053/city/city.csv";
	    ClassLoader classLoader = getClass().getClassLoader();
	    java.net.URL url = Paths.get("city.csv").toUri().toURL();
	    File file = new File(url.getFile());
	    //CSVReader reader = new CSVReader(new FileReader(file));
	    
	    Scanner sc = new Scanner(new File("city.csv"));
	    sc.useDelimiter("\n");
	    while(sc.hasNext())
	    {
	    	String line = sc.next();
	    	String[] nextLine = line.split(",");
	    	try
	    	{
	        	City temp = new City();
	        	
	        	if(nextLine.length >= 5)
	        	{
	        		temp = new City(
		        	          Integer.parseInt(nextLine[0]),
		        	          nextLine[1],
		        	          new Coordinate(
		        	              Double.parseDouble(nextLine[3]),
		        	              Double.parseDouble(nextLine[4])),
		        	          nextLine[2]
		        	      );
	        	}
	        	else if(nextLine.length == 3)
	        	{
	        		temp = new City(
		        	          Integer.parseInt(nextLine[0]),
		        	          nextLine[1],
		        	          new Coordinate(
		        	              Double.parseDouble(nextLine[3]),
		        	              Double.parseDouble(nextLine[4])),""
		        	      );
	        	}
	        	else if(nextLine.length >= 2)
	        	{
	        		temp = new City(
		        	          Integer.parseInt(nextLine[0]),
		        	          nextLine[1],
		        	          new Coordinate(
		        	              0,
		        	              0),""
		        	      );
	        	}
	        	else if(nextLine.length >= 1)
	        	{
	        		temp = new City(
		        	          Integer.parseInt(nextLine[0]),
		        	          "",
		        	          new Coordinate(
		        	              0,
		        	              0),""
		        	      );
	        	}
	        	this.cities.add(temp);
	    	}
	    	catch(Exception ex)
	    	{
	    		continue;
	    	}
	    }
  }
  
}

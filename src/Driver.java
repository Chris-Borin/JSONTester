import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.Car;
import app.Rectangle;


/**
 * @author Lydia K Fritz
 * Oct 18, 2021
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		/*
		 * ObjectMapper objMapper = new ObjectMapper();
		 * 
		 * //create a JSON string for a rectangle String rectJSON =
		 * "{\"width\" : 12.5, \"length\" : 5}"; //make a Rectangle using the JSON
		 * string try { Rectangle r = objMapper.readValue(rectJSON, Rectangle.class);
		 * System.out.println(r); } catch(IOException e){
		 * System.out.println("JSON read unsuccessful"); }
		 */

	}
	
	private static void saveToFile(String fname, Car car, boolean append) {
		PrintWriter pw;
		
		FileWriter fw;
		try {
			File file = new File(fname);
			fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			ObjectMapper objMapper = new ObjectMapper();
			String json = objMapper.writeValueAsString(car);
			pw.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private static ArrayList<Car> readFromFile(String filename){
		
		
		return null;
		
	}
}

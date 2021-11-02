import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.Car;
import app.Rectangle;

/**
 * @author Lydia K Fritz Oct 18, 2021
 *
 */
public class Driver {

	public static void main(String[] args) {

		Car[] cars = new Car[5];
		cars[0] = new Car(2000, "Ford", "Mustang", 0, 1.5);
		cars[1] = new Car(2020, "Toyota", "Rav4", 100000, 1.5);
		cars[2] = new Car(2000, "Honda", "Civic", 123456, 1.5);
		cars[3] = new Car(1997, "Subaru", "Outback", 454540, 1.5);
		cars[4] = new Car(2005, "Ford", "F150", 500000, 1.5);

		/*
		 * for (int i = 0; i < 5; i++) { saveToFile("out.json", cars[i], true); }
		 */

		ArrayList<Car> carList = readFromFile("out.json");
		for (Car car : carList) {
			System.out.println(car);
		}

		/*
		 * ObjectMapper objMapper = new ObjectMapper();
		 * 
		 * // create a JSON string for a rectangle String rectJSON =
		 * "{\"width\" : 12.5, \"length\" : 5}"; // make a Rectangle using the JSON
		 * string try { Rectangle r = objMapper.readValue(rectJSON, Rectangle.class);
		 * System.out.println(r); } catch (IOException e) {
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
			System.out.println("end of try block");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static ArrayList<Car> readFromFile(String filename) {
		ArrayList<Car> cars = new ArrayList<Car>();

		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				String json = s.nextLine();
				ObjectMapper om = new ObjectMapper();
				Car car = om.readValue(json, Car.class);
				cars.add(car);
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cars;

	}
}

package app;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lydia K Fritz
 * Oct 18, 2021
 *
 */
public class Rectangle {
	private double len, wid;

	/**
	 * 
	 */
	public Rectangle() {
		wid = len = 1.0;
	}
	
	public Rectangle(double l, double w) {
		len = l;
		wid = w;
	}

	/**
	 * @return the len
	 */
	public double getLen() {
		return len;
	}

	/**
	 * @param len the len to set
	 */
	public void setLength(double len) {
		this.len = len;
	}

	/**
	 * @return the wid
	 */
	public double getWid() {
		return wid;
	}

	/**
	 * @param wid the wid to set
	 */
	public void setWidth(double wid) {
		this.wid = wid;
	}

	@Override
	public String toString() {
		String str = String.format("width = %.3f, length = %.3f\n", wid, len);
		return 	str;
	}
	

}

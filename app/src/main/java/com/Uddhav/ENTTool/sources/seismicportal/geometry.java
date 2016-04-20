package com.Uddhav.ENTTool.sources.seismicportal;

import java.util.List;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class geometry {

	private String		type;
	private List<Float>	coordinates;

	public String getType() {
		return type;
	}

	public List<Float> getCoordinates() {
		return coordinates;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCoordinates(List<Float> coordinates) {
		this.coordinates = coordinates;
	}

}

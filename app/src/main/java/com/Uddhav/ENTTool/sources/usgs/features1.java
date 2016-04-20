package com.Uddhav.ENTTool.sources.usgs;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class features1<P, G> {

	private String	type;
	private P		properties;
	private G		geometry;
	private String	id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public P getProperties() {
		return properties;
	}

	public void setProperties(P properties) {
		this.properties = properties;
	}

	public G getGeometry() {
		return geometry;
	}

	public void setGeometry(G geometry) {
		this.geometry = geometry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

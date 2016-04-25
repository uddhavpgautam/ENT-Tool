package com.Uddhav.ENTTool.sources.seismicportal;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class features<S, T> {

    private S geometry;
    private String type;
    private String id;
    private T properties;

    public S getGeometry() {
        return geometry;
    }

    public void setGeometry(S geometry) {
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getProperties() {
        return properties;
    }

    public void setProperties(T properties) {
        this.properties = properties;
    }

}

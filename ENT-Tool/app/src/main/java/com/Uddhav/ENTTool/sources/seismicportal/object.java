package com.Uddhav.ENTTool.sources.seismicportal;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class object<S, T> {

    private String type;
    private S metadata;
    private T features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public S getMetadata() {
        return metadata;
    }

    public void setMetadata(S metadata) {
        this.metadata = metadata;
    }

    public T getFeatures() {
        return features;
    }

    public void setFeatures(T features) {
        this.features = features;
    }

}

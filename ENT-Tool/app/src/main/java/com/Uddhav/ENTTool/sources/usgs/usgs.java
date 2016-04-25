package com.Uddhav.ENTTool.sources.usgs;

import java.util.List;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class usgs<M, F> {

    private String type;
    private M metadata;
    private List<F> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public M getMetadata() {
        return metadata;
    }

    public void setMetadata(M metadata) {
        this.metadata = metadata;
    }

    public List<F> getFeatures() {
        return features;
    }

    public void setFeatures(List<F> features) {
        this.features = features;
    }

}

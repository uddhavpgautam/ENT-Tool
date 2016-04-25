package com.Uddhav.ENTTool.sources.seismicportal;

/**
 * Created by Uddhav Gautam on 7.3.2016.
 * upgautam@ualr.edu
 */

import java.util.Date;

public class properties {

    private Date lastupdate;
    private String magtype;
    private String evtype;
    private double lon;
    private String auth;
    private double lat;
    private float depth;
    private String unid;
    private float mag;
    private Date time;
    private String source_id;
    private String source_catalog;
    private String flynn_region;

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getMagtype() {
        return magtype;
    }

    public void setMagtype(String magtype) {
        this.magtype = magtype;
    }

    public String getEvtype() {
        return evtype;
    }

    public void setEvtype(String evtype) {
        this.evtype = evtype;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public float getMag() {
        return mag;
    }

    public void setMag(float mag) {
        this.mag = mag;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSource_catalog() {
        return source_catalog;
    }

    public void setSource_catalog(String source_catalog) {
        this.source_catalog = source_catalog;
    }

    public String getFlynn_region() {
        return flynn_region;
    }

    public void setFlynn_region(String flynn_region) {
        this.flynn_region = flynn_region;
    }

}

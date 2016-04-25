package com.Uddhav.ENTTool.utils;

import com.Uddhav.ENTTool.database.EarthQuakes;
import com.Uddhav.ENTTool.sources.seismicportal.features;
import com.Uddhav.ENTTool.sources.seismicportal.geometry;
import com.Uddhav.ENTTool.sources.seismicportal.object;
import com.Uddhav.ENTTool.sources.seismicportal.properties;
import com.Uddhav.ENTTool.sources.seismicportal.totalCount;
import com.Uddhav.ENTTool.sources.usgs.features1;
import com.Uddhav.ENTTool.sources.usgs.geometry1;
import com.Uddhav.ENTTool.sources.usgs.metadata1;
import com.Uddhav.ENTTool.sources.usgs.properties1;
import com.Uddhav.ENTTool.sources.usgs.usgs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class SaveResponseToDB {

    private int decimalPlace = 1;

    public SaveResponseToDB() {
        // DatabaseHelper.getDbHelper().clearDatabase();
    }


    public void saveDatabaseSeismicPortal(String url) {

        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Tools.DATEFORMAT_SEISMICPORTAL).create();

            Type listType = new TypeToken<object<totalCount, List<features<geometry, properties>>>>() {
            }.getType(); //TypeToken(items).getType == listType
            //Type is just used to abstractly define it is one type of object. So, type is like generic way of defining things.

            String json = getJson(url);

            if (json == null || json.length() < 10) {
                return;
            }

            object<totalCount, List<features<geometry, properties>>> items = gson.fromJson(json, listType);

            if (items == null || items.getFeatures() == null || items.getFeatures().size() == 0) {
                return;
            }

            for (features<geometry, properties> item : items.getFeatures()) { //every feature has geometry and properties

                Calendar cal = Calendar.getInstance();
                cal.setTime(item.getProperties().getTime());
                cal.add(Calendar.HOUR_OF_DAY, 2);

                EarthQuakes eq = new EarthQuakes();
                eq.setDateMilis(cal.getTime().getTime());
                eq.setDepth(round(item.getProperties().getDepth(), decimalPlace));
                eq.setLatitude(item.getProperties().getLat());
                eq.setLongitude(item.getProperties().getLon());
                eq.setLocationName(item.getProperties().getFlynn_region().trim().toUpperCase());
                eq.setMagnitude(round(item.getProperties().getMag(), decimalPlace));
                eq.setSource(2);
                eq.Insert();

            }

        } catch (Exception e) {
            Tools.catchException(e);
        }

    }

    public void saveDatabaseUsgs(String url) { //save every earthquake fields like magnitude, latitude etc.

        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Tools.DATEFORMAT).create();
            //Gson is used to serialize/deserialize Json.
            Type listType = new TypeToken<usgs<metadata1, features1<properties1, geometry1>>>() {
            }.getType();
            //below I can use the getFeatures() because item is a type of object defined from Type interface


            String json = getJson(url); //getJson is using OkHttpClient

            if (json == null || json.length() < 10) { // JSON is null or empty
                return; //note: any code below return does not get executed. So, I don't need to put in If and else block. If if is true then return becomes last line for this function
            }

            usgs<metadata1, features1<properties1, geometry1>> items = gson.fromJson(json, listType);

            if (items == null || items.getFeatures() == null || items.getFeatures().size() == 0) { //check if item null or items' features null or item's features empty
                return;
            }

            for (features1<properties1, geometry1> item : items.getFeatures()) {

                String str1 = item.getProperties().getPlace().trim().toUpperCase();
                String str2 = str1.substring(str1.indexOf("OF") + 3);

                EarthQuakes eq = new EarthQuakes();
                eq.setDateMilis(Long.parseLong(item.getProperties().getTime()));
                eq.setDepth(round(item.getGeometry().getCoordinates().get(2), decimalPlace));
                eq.setLatitude(item.getGeometry().getCoordinates().get(1));
                eq.setLongitude(item.getGeometry().getCoordinates().get(0));
                eq.setLocationName(str2);
                eq.setMagnitude(round(item.getProperties().getMag(), decimalPlace));
                eq.setSource(3);
                eq.Insert();

            }

        } catch (Exception e) {
            Tools.catchException(e);
        }

    }

    private String getJson(String reqUrl) throws Exception {
        Request request = new Request.Builder().url(reqUrl).build(); //Request builder is used to get JSON url
        Response response = new OkHttpClient().newCall(request).execute(); //OkHttpClient is HTTP client to request
        return response.isSuccessful() ? response.body().string() : "";
    }

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}

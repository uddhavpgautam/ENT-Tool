package com.Uddhav.ENTTool.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.Uddhav.ENTTool.utils.Tools;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Comparator;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */

@DatabaseTable(tableName = "LastEarthquakeDate")
// This is the annotation (@). It is just telling metadata information
// annotation line does not do anything in the class
public class LastEarthquakeDate implements Parcelable, Comparator<LastEarthquakeDate> {

    public static final Creator<LastEarthquakeDate> CREATOR = new Creator<LastEarthquakeDate>() {
        //Parceable interface includes the Creator interface. Parceable is contained in android.os.
        //Creator<T>. T is any abstract  parceable instance.
        @Override
        public LastEarthquakeDate createFromParcel(Parcel in) {
            return new LastEarthquakeDate(in);
        }

        // earthquake is included as a parcel. So, you just return an parcel object. Parcel means, like a bag.
        @Override
        public LastEarthquakeDate[] newArray(int size) {
            return new LastEarthquakeDate[size];
        }
    };
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private Long DateMilis;

    public LastEarthquakeDate() {
        this.id = 1;
    }

    protected LastEarthquakeDate(Parcel in) {
        id = in.readInt();
    }

    public void Insert() {

        try {
            Dao<LastEarthquakeDate, Integer> Missionsinsert = (DatabaseHelper.getDbHelper()).getLastEarthquakeDateDataHelper();
            LastEarthquakeDate existenceCheck = Missionsinsert.queryForId(this.id); //retrieves an object associated with specific ID. existence Check, here, is that object.

            if (existenceCheck != null) {
                Missionsinsert.update(this);
            } else {
                Missionsinsert.create(this);
            }

        } catch (SQLException e) {
            Tools.catchException(e);
        }
    }

    public Long GetLastEarthquakeMilisDate() {
        LastEarthquakeDate lastDate = null;
        try {
            Dao<LastEarthquakeDate, Integer> dao = DatabaseHelper.getDbHelper().getLastEarthquakeDateDataHelper();
            lastDate = dao.queryForId(1);
        } catch (Exception e) {
            Tools.catchException(e);
        }
        return lastDate.getDateMilis();
    }

    public int GetRowCount() {
        int count = 0;

        try {
            Dao<LastEarthquakeDate, Integer> dao = DatabaseHelper.getDbHelper().getLastEarthquakeDateDataHelper(); //dao is to count the LastEarthquakes
            count = (int) dao.countOf();
        } catch (Exception e) {
            Tools.catchException(e);
        }

        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDateMilis() {
        return DateMilis;
    }

    public void setDateMilis(Long dateMilis) {
        DateMilis = dateMilis;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub

        dest.writeInt(id);
    }

    @Override
    public int compare(LastEarthquakeDate lhs, LastEarthquakeDate rhs) {
        return (int) (lhs.DateMilis - rhs.DateMilis);
    }

}

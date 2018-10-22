package com.example.mack_.a52parcables;


import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
    public int id;
    public String Name;
    public String URL;
    public String Keywords;
    public String Date;
    public String Share;
    public String Email;
    public String Rating;

    public MyParcelable() {
    }

    MyParcelable(int _id, String _Name, String _URL, String _Keywords, String _Date, String _Share, String _Email, String _Rating){
        id = _id;
        Name = _Name;
        URL = _URL;
        Keywords = _Keywords;
        Date = _Date;
        Share = _Share;
        Email = _Email;
        Rating = _Rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.Name);
        dest.writeString(this.URL);
        dest.writeString(this.Keywords);
        dest.writeString(this.Date);
        dest.writeString(this.Share);
        dest.writeString(this.Email);
        dest.writeString(this.Rating);
    }

    protected MyParcelable(Parcel in) {
        this.id = in.readInt();
        this.Name = in.readString();
        this.URL = in.readString();
        this.Keywords = in.readString();
        this.Date = in.readString();
        this.Share = in.readString();
        this.Email = in.readString();
        this.Rating = in.readString();
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}
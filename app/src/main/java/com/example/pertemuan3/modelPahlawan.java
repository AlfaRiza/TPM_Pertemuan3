package com.example.pertemuan3;

import android.os.Parcel;
import android.os.Parcelable;

public class modelPahlawan implements Parcelable {
    String heroNames, heroDetails;
    int heroImages;

    protected modelPahlawan(Parcel in) {
        heroNames = in.readString();
        heroDetails = in.readString();
        heroImages = in.readInt();
    }

    public static final Creator<modelPahlawan> CREATOR = new Creator<modelPahlawan>() {
        @Override
        public modelPahlawan createFromParcel(Parcel in) {
            return new modelPahlawan(in);
        }

        @Override
        public modelPahlawan[] newArray(int size) {
            return new modelPahlawan[size];
        }
    };

    public modelPahlawan() {

    }

    public String getHeroNames() {
        return heroNames;
    }

    public void setHeroNames(String heroNames) {
        this.heroNames = heroNames;
    }

    public String getHeroDetails() {
        return heroDetails;
    }

    public void setHeroDetails(String heroDetails) {
        this.heroDetails = heroDetails;
    }

    public int getHeroImages() {
        return heroImages;
    }

    public void setHeroImages(int heroImages) {
        this.heroImages = heroImages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroNames);
        dest.writeString(heroDetails);
        dest.writeInt(heroImages);
    }
}

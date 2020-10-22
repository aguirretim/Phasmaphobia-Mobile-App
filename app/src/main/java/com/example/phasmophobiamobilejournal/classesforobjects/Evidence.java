package com.example.phasmophobiamobilejournal.classesforobjects;

import android.os.Parcel;
import android.os.Parcelable;

public class Evidence implements Parcelable {


    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private String evidenceTitle;
    private int evidenceImageId;

    /****************************
     * Constructor for Object.  *
     ****************************/

    public Evidence(String evidenceTitle, int evidenceImageId) {
        this.evidenceTitle = evidenceTitle;
        this.evidenceImageId = evidenceImageId;
    }

    /************************
     * Getters and setters  *
     ************************/

    public String getEvidenceTitle() {
        return evidenceTitle;
    }

    public void setEvidenceTitle(String evidenceTitle) {
        this.evidenceTitle = evidenceTitle;
    }

    public int getEvidenceImageId() {
        return evidenceImageId;
    }

    public void setEvidenceImageId(int evidenceImageId) {
        this.evidenceImageId = evidenceImageId;
    }

    protected Evidence(Parcel in) {
        evidenceTitle = in.readString();
        evidenceImageId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(evidenceTitle);
        dest.writeInt(evidenceImageId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Evidence> CREATOR = new Parcelable.Creator<Evidence>() {
        @Override
        public Evidence createFromParcel(Parcel in) {
            return new Evidence(in);
        }

        @Override
        public Evidence[] newArray(int size) {
            return new Evidence[size];
        }
    };

}

package com.example.phasmophobiamobilejournal.classesforobjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Ghost implements Parcelable {


    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private String GhostName;
    private Evidence Evidence1;
    private Evidence Evidence2;
    private Evidence Evidence3;
    private ArrayList<Evidence> evideneceForGhost = new ArrayList<Evidence>();
    private String GhostDescription;


    /****************************
     * Constructor for Object.  *
     ****************************/

    public Ghost(String ghostName,Evidence evidence1, Evidence evidence2, Evidence evidence3, String ghostDescription) {
        GhostName=ghostName;
        Evidence1 = evidence1;
        Evidence2 = evidence2;
        Evidence3 = evidence3;
        evideneceForGhost.add(Evidence1);
        evideneceForGhost.add(Evidence2);
        evideneceForGhost.add(Evidence3);
        GhostDescription = ghostDescription;
    }

    /************************
     * Getters and setters  *
     ************************/

    public String getGhostName() {
        return GhostName;
    }

    public void setGhostName(String ghostName) {
        GhostName = ghostName;
    }


    public Evidence getEvidence1() {
        return Evidence1;
    }

    public void setEvidence1(Evidence evidence1) {
        Evidence1 = evidence1;
    }

    public Evidence getEvidence2() {
        return Evidence2;
    }

    public void setEvidence2(Evidence evidence2) {
        Evidence2 = evidence2;
    }

    public Evidence getEvidence3() {
        return Evidence3;
    }

    public void setEvidence3(Evidence evidence3) {
        Evidence3 = evidence3;
    }

    public String getGhostDescription() {
        return GhostDescription;
    }

    public void setGhostDescription(String ghostDescription) {
        GhostDescription = ghostDescription;
    }

    public ArrayList<Evidence> getEvideneceForGhost() {
        return evideneceForGhost;
    }

    public void setEvideneceForGhost(ArrayList<Evidence> evideneceForGhost) {
        this.evideneceForGhost = evideneceForGhost;
    }
    protected Ghost(Parcel in) {
        GhostName = in.readString();
        Evidence1 = (Evidence) in.readValue(Evidence.class.getClassLoader());
        Evidence2 = (Evidence) in.readValue(Evidence.class.getClassLoader());
        Evidence3 = (Evidence) in.readValue(Evidence.class.getClassLoader());
        if (in.readByte() == 0x01) {
            evideneceForGhost = new ArrayList<Evidence>();
            in.readList(evideneceForGhost, Evidence.class.getClassLoader());
        } else {
            evideneceForGhost = null;
        }
        GhostDescription = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(GhostName);
        dest.writeValue(Evidence1);
        dest.writeValue(Evidence2);
        dest.writeValue(Evidence3);
        if (evideneceForGhost == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(evideneceForGhost);
        }
        dest.writeString(GhostDescription);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Ghost> CREATOR = new Parcelable.Creator<Ghost>() {
        @Override
        public Ghost createFromParcel(Parcel in) {
            return new Ghost(in);
        }

        @Override
        public Ghost[] newArray(int size) {
            return new Ghost[size];
        }
    };

}

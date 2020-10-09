package com.example.phasmophobiamobilejournal.classesforobjects;

public class Ghost {

    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private String Evidence1;
    private String Evidence2;
    private String Evidence3;


    /****************************
     * Constructor for Object.  *
     ****************************/

    public Ghost(String evidence1, String evidence2, String evidence3) {
        Evidence1 = evidence1;
        Evidence2 = evidence2;
        Evidence3 = evidence3;
    }

    /************************
     * Getters and setters  *
     ************************/

    public String getEvidence1() {
        return Evidence1;
    }

    public void setEvidence1(String evidence1) {
        Evidence1 = evidence1;
    }

    public String getEvidence2() {
        return Evidence2;
    }

    public void setEvidence2(String evidence2) {
        Evidence2 = evidence2;
    }

    public String getEvidence3() {
        return Evidence3;
    }

    public void setEvidence3(String evidence3) {
        Evidence3 = evidence3;
    }


}

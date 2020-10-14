package com.example.phasmophobiamobilejournal.classesforobjects;

public class Ghost {

    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private Evidence Evidence1;
    private Evidence Evidence2;
    private Evidence Evidence3;

    /****************************
     * Constructor for Object.  *
     ****************************/

    public Ghost(Evidence evidence1, Evidence evidence2, Evidence evidence3) {
        Evidence1 = evidence1;
        Evidence2 = evidence2;
        Evidence3 = evidence3;
    }

    /************************
     * Getters and setters  *
     ************************/

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


}

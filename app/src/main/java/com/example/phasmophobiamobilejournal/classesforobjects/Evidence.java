package com.example.phasmophobiamobilejournal.classesforobjects;

public class Evidence {



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

}

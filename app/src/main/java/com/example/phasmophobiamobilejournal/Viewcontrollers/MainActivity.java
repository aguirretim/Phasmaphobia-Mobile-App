package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*************************************
     * Variables for Buttons and Field.  *
     *************************************/

    private TextView actionTitle;
    private ImageView emf5Image;
    private ImageView ghostOrbImage;
    private TextView emf5Text;
    private TextView ghostOrbText;
    private ImageView ghostWritingImage;
    private ImageView tempImage;
    private TextView ghostWritingText;
    private TextView freezingTempText;
    private ImageView spiritBoxImage;
    private ImageView fingerprintImage;
    private TextView spiritBoxText;
    private TextView fingerprintText;

    /*************************************
     *Init Variables  *
     *************************************/

    private ArrayList<Ghost> ghostList = new ArrayList<Ghost>();
    private ArrayList<Ghost> possibleGhostList = new ArrayList<Ghost>();
    private ArrayList<String> possibleEvidenceList = new ArrayList<String>();
    private String selectedEvidence;

    /**************************************
     * Main initialized Method.  *
     **************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Assigns the Views from the layout file to the corresponding variables.
        findViews();

        Ghost Spirit = new Ghost("Spirit Box","Fingerprints","Ghost Writing");
        Ghost Wraith  = new Ghost("Spirit Box","Fingerprints","Freezing Temperatures");
        Ghost Phantom = new Ghost("EMF Level 5","Ghost orb","Freezing Temperatures");
        Ghost Poltergeist  = new Ghost("Spirit Box","Fingerprints","Ghost Orb");
        Ghost Banshees = new Ghost("EMF Level 5","Fingerprints","Freezing Temperatures");
        Ghost Jinn = new Ghost("Spirit Box","Ghost Orb","EMF Level 5");
        Ghost Mare = new Ghost("Spirit Box","Ghost Orbs","Freezing Temperatures");
        Ghost Revenant = new Ghost("EMF Level 5","Fingerprints","Ghost Writing");
        Ghost Shade  = new Ghost("EMF Level 5","Ghost Orb","Ghost Writing");
        Ghost Demon = new Ghost("Spirit Box","Freezing Temperatures","Ghost Writing");
        Ghost Yurei  = new Ghost("Ghost Orb","Freezing Temperatures","Ghost Writing");
        Ghost Oni  = new Ghost("EMF Level 5","Spirit Box","Ghost Writing");

        ghostList.add(Spirit);
        ghostList.add(Wraith);
        ghostList.add(Phantom);
        ghostList.add(Poltergeist);
        ghostList.add(Banshees);
        ghostList.add(Jinn);
        ghostList.add(Mare);
        ghostList.add(Revenant);
        ghostList.add(Shade);
        ghostList.add(Demon);
        ghostList.add(Yurei);
        ghostList.add(Oni);




        emf5Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedEvidence = "EMF Level 5";

                possibleGhostList();
                possibleEvidenceCreator();
                //Need to figure out how to display the next screen with posisble evidence displayed

                //Show the Screen you want to show
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    /****************************************
     * Methods and Actions that do things  *
     ****************************************/

    private void findViews() {
        actionTitle = (TextView) findViewById(R.id.action_Title);
        emf5Image = (ImageView) findViewById(R.id.emf5Image);
        ghostOrbImage = (ImageView) findViewById(R.id.ghostOrbImage);
        emf5Text = (TextView) findViewById(R.id.emf5Text);
        ghostOrbText = (TextView) findViewById(R.id.ghostOrbText);
        ghostWritingImage = (ImageView) findViewById(R.id.ghostWritingImage);
        tempImage = (ImageView) findViewById(R.id.tempImage);
        ghostWritingText = (TextView) findViewById(R.id.ghostWritingText);
        freezingTempText = (TextView) findViewById(R.id.freezingTempText);
        spiritBoxImage = (ImageView) findViewById(R.id.spiritBoxImage);
        fingerprintImage = (ImageView) findViewById(R.id.fingerprintImage);
        spiritBoxText = (TextView) findViewById(R.id.spiritBoxText);
        fingerprintText = (TextView) findViewById(R.id.fingerprintText);
    }

    public void possibleEvidenceCreator(){
        for (Ghost ghost:possibleGhostList){

            if  (ghost.getEvidence1()!= selectedEvidence){
                possibleEvidenceList.add(ghost.getEvidence1());
            }
            if  (ghost.getEvidence2()!= selectedEvidence){
                possibleEvidenceList.add(ghost.getEvidence2());
            }
            if  (ghost.getEvidence3()!= selectedEvidence){
                possibleEvidenceList.add(ghost.getEvidence3());
            }

        }
    }

    public void possibleGhostList(){
        for (Ghost ghost:ghostList) {
            if  (ghost.getEvidence1()==selectedEvidence){
                possibleGhostList.add(ghost);
            }
            if  (ghost.getEvidence2()==selectedEvidence){
                possibleGhostList.add(ghost);
            }
            if  (ghost.getEvidence3()==selectedEvidence){
                possibleGhostList.add(ghost);
            }
        }
    }

}
package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.classesforobjects.Evidence;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    /*************************************
     * Variables for Buttons and Field.  *
     *************************************/

    private TextView actionTitle;
    private TableLayout evidenceTable;
    private TableRow evdTbRow1;
    private ImageView Image1;
    private ImageView Image2;
    private TableRow evdTbRow12;
    private TextView emf5Text;
    private TextView ghostOrbText;
    private TableRow evdTbRow2;
    private ImageView ghostWritingImage;
    private ImageView tempImage;
    private TableRow evdTbRow21;
    private TextView ghostWritingText;
    private TextView freezingTempText;
    private TableRow evdTbRow3;
    private ImageView spiritBoxImage;
    private ImageView fingerprintImage;
    private TableRow evdTbRow31;
    private TextView spiritBoxText;
    private TextView fingerprintText;

    /*************************************
     *Init Variables  *
     *************************************/

    private ArrayList<Ghost> ghostList = new ArrayList<Ghost>();
    private ArrayList<Ghost> possibleGhostList = new ArrayList<Ghost>();
    private ArrayList<Evidence> possibleEvidenceList = new ArrayList<Evidence>();
    private String selectedEvidence;
    ArrayList<Integer> imageIdlist = new ArrayList<Integer>();
    ArrayList<String> evideneTitlelist = new ArrayList<String>();
    ArrayList<String> evideneceCollected = new ArrayList<String>();

    int firstImage;
    int secoundImage;
    int thirdImage;
    int fourthImage;
    int fifthImage;
    int sixthImage;
    String firstTextRef;
    String secoundTextRef;
    String thirdTextRef;
    String fourthTextRef;
    String fifthTextRef;
    String sixthTextRef;

    // create a new TableRow
    // TableRow row = new TableRow(this);

    /**************************************
     * Main initialized Method.  *
     **************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Assigns the Views from the layout file to the corresponding variables.
        findViews();


        Evidence EMFLevel5 = new Evidence("EMF Level 5", R.drawable.emf5);
        Evidence GhostOrb = new Evidence("Ghost Orb", R.drawable.ghostorbs);
        Evidence GhostWriting = new Evidence("Ghost Writing", R.drawable.ghostwriting);
        Evidence FreezingTemperatures = new Evidence("Freezing Temperatures", R.drawable.freezing_tempt_info);
        Evidence SpiritBox = new Evidence("Spirit Box", R.drawable.spirit_box);
        Evidence Fingerprints = new Evidence("Fingerprints", R.drawable.fingerprints);

        Ghost Spirit = new Ghost(SpiritBox, Fingerprints, GhostWriting);
        Ghost Wraith = new Ghost(SpiritBox, Fingerprints, FreezingTemperatures);
        Ghost Phantom = new Ghost(EMFLevel5, GhostOrb, FreezingTemperatures);
        Ghost Poltergeist = new Ghost(SpiritBox, Fingerprints, GhostOrb);
        Ghost Banshees = new Ghost(EMFLevel5, Fingerprints, FreezingTemperatures);
        Ghost Jinn = new Ghost(SpiritBox, GhostOrb, EMFLevel5);
        Ghost Mare = new Ghost(SpiritBox, GhostOrb, FreezingTemperatures);
        Ghost Revenant = new Ghost(EMFLevel5, Fingerprints, GhostWriting);
        Ghost Shade = new Ghost(EMFLevel5, GhostOrb, GhostWriting);
        Ghost Demon = new Ghost(SpiritBox, FreezingTemperatures, GhostWriting);
        Ghost Yurei = new Ghost(GhostOrb, FreezingTemperatures, GhostWriting);
        Ghost Oni = new Ghost(EMFLevel5, SpiritBox, GhostWriting);

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


        possibleEvidenceList.add(EMFLevel5);
        possibleEvidenceList.add(GhostOrb);
        possibleEvidenceList.add(GhostWriting);
        possibleEvidenceList.add(FreezingTemperatures);
        possibleEvidenceList.add(SpiritBox);
        possibleEvidenceList.add(Fingerprints);

        imagesForScreenCreator();


        Image1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                selectedEvidence = "" + emf5Text.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();
                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();

                //Need to figure out how to display the next screen with posisble evidence displayed

               /* //Show the Screen you want to show
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);*/


            }
        });


    }

    /****************************************
     * Methods and Actions that do things  *
     ****************************************/

    private void findViews() {
        actionTitle = (TextView) findViewById(R.id.action_Title);
        evidenceTable = (TableLayout) findViewById(R.id.evidenceTable);
        evdTbRow1 = (TableRow) findViewById(R.id.evdTbRow1);
        Image1 = (ImageView) findViewById(R.id.Image1);
        Image2 = (ImageView) findViewById(R.id.Image2);
        evdTbRow12 = (TableRow) findViewById(R.id.evdTbRow12);
        emf5Text = (TextView) findViewById(R.id.emf5Text);
        ghostOrbText = (TextView) findViewById(R.id.ghostOrbText);
        evdTbRow2 = (TableRow) findViewById(R.id.evdTbRow2);
        ghostWritingImage = (ImageView) findViewById(R.id.ghostWritingImage);
        tempImage = (ImageView) findViewById(R.id.tempImage);
        evdTbRow21 = (TableRow) findViewById(R.id.evdTbRow21);
        ghostWritingText = (TextView) findViewById(R.id.ghostWritingText);
        freezingTempText = (TextView) findViewById(R.id.freezingTempText);
        evdTbRow3 = (TableRow) findViewById(R.id.evdTbRow3);
        spiritBoxImage = (ImageView) findViewById(R.id.spiritBoxImage);
        fingerprintImage = (ImageView) findViewById(R.id.fingerprintImage);
        evdTbRow31 = (TableRow) findViewById(R.id.evdTbRow31);
        spiritBoxText = (TextView) findViewById(R.id.spiritBoxText);
        fingerprintText = (TextView) findViewById(R.id.fingerprintText);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Evidence> possibleEvidenceCreator() {
        possibleEvidenceList.clear();
        for (Ghost ghost : possibleGhostList) {

            if (ghost.getEvidence1().getEvidenceTitle().contentEquals(selectedEvidence)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence1());
            }
            if (ghost.getEvidence2().getEvidenceTitle().contentEquals(selectedEvidence)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence2());
            }
            if (ghost.getEvidence3().getEvidenceTitle().contentEquals(selectedEvidence)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence3());
            }


        }

        possibleEvidenceList = (ArrayList) possibleEvidenceList.stream().distinct().collect(Collectors.toList());
        return possibleEvidenceList;
    }

    public void possibleGhostList() {
        for (Ghost ghost : ghostList) {
            if (ghost.getEvidence1().getEvidenceTitle().equals(selectedEvidence)) {
                possibleGhostList.add(ghost);
            }
            if (ghost.getEvidence2().getEvidenceTitle().equals(selectedEvidence)) {
                possibleGhostList.add(ghost);
            }
            if (ghost.getEvidence3().getEvidenceTitle().equals(selectedEvidence)) {
                possibleGhostList.add(ghost);
            }
        }
    }

    public void imagesForScreenCreator() {
        if (possibleEvidenceList.size() > 0) {


            for (int i = 0; i < possibleEvidenceList.size(); i++) {
                Evidence evidence = possibleEvidenceList.get(i);
                evideneTitlelist.add(evidence.getEvidenceTitle());
                imageIdlist.add(evidence.getEvidenceImageId());
            }

            try {
                firstImage = imageIdlist.get(0);
                firstTextRef = evideneTitlelist.get(0);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                firstImage = 0;
                firstTextRef = "";
            }
            try {
                secoundImage = imageIdlist.get(1);
                secoundTextRef = evideneTitlelist.get(1);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                secoundImage = 0;
                secoundTextRef = "";
            }
            try {
                thirdImage = imageIdlist.get(2);
                thirdTextRef = evideneTitlelist.get(2);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                thirdImage = 0;
                thirdTextRef = "";
            }
            try {
                fourthImage = imageIdlist.get(3);
                fourthTextRef = evideneTitlelist.get(3);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                fourthImage = 0;
                fourthTextRef = "";
            }
            try {
                fifthImage = imageIdlist.get(4);
                fifthTextRef = evideneTitlelist.get(4);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                fifthImage = 0;
                fifthTextRef = "";
            }
            try {
                sixthImage = imageIdlist.get(5);
                sixthTextRef = evideneTitlelist.get(5);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                sixthImage = 0;
                sixthTextRef = "";
            }

        } else {
            firstImage = 0;
            firstTextRef = "";
            secoundImage = 0;
            secoundTextRef = "";
            thirdImage = 0;
            thirdTextRef = "";
            fourthImage = 0;
            fourthTextRef = "";
            fifthImage = 0;
            fifthTextRef = "";
            sixthImage = 0;
            sixthTextRef = "";
        }


        Image1.setImageResource(firstImage);
        Image2.setImageResource(secoundImage);
        ghostWritingImage.setImageResource(thirdImage);
        tempImage.setImageResource(fourthImage);
        spiritBoxImage.setImageResource(fifthImage);
        fingerprintImage.setImageResource(sixthImage);

        emf5Text.setText(firstTextRef);
        ghostOrbText.setText(secoundTextRef);
        ghostWritingText.setText(thirdTextRef);
        freezingTempText.setText(fourthTextRef);
        spiritBoxText.setText(fifthTextRef);
        fingerprintText.setText(sixthTextRef);

        actionTitleChanger();

        evideneTitlelist.clear();
        imageIdlist.clear();
    }

    public void actionTitleChanger() {
        if (evideneceCollected.size() == 1) {
            actionTitle.setText("Select your 2nd evidence found");
        }
        if (evideneceCollected.size() == 2) {
            actionTitle.setText("Select your 3rd evidence found");
        }
    }

    public void onResume() {
        super.onResume();


    }
}


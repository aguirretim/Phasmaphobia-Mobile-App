package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.classesforobjects.Evidence;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;

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
    private TableRow evdTbRow32;
    private TextView spiritBoxText;
    private TextView fingerprintText;
    private ImageView dotsProjectorImage;
    private TextView dotsProjectorText;
    private TextView Evidence1;
    private TextView Evidence2;
    private TextView Evidence3;
    private ImageView ghostImage;
    private TextView possubleGhostTitle;
    private Button resetButton;


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
    int seventhImage;
    String firstTextRef;
    String secoundTextRef;
    String thirdTextRef;
    String fourthTextRef;
    String fifthTextRef;
    String sixthTextRef;
    String seventhTextRef;

    boolean newGhostReset = false;

    boolean ghostFound = false;



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


        intialSetup();

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);


        if (isFirstRun) {
            //show start activity
            // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("I made this app to help those who play the game Phasmaphobia, more easily find the ghost. This Mobile Journal acts similar to the one in the game but eliminates evidence as you see it making it easier to narrow down the ghost.")
                    .setTitle("Welcome Ghost Hunter");

            // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
            AlertDialog dialog = builder.create();

            dialog.show();

            // startActivity(new Intent(MainActivity.this, FirstLaunch.class));
           /* Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();*/
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();


        newGhostReset = getIntent().getBooleanExtra("newGhostReset", FALSE);
        if (newGhostReset) {
            onBackPressed();
        }

        Image1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                selectedEvidence = "" + emf5Text.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        Image2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + ghostOrbText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });


        ghostWritingImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + ghostWritingText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        tempImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + freezingTempText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        spiritBoxImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + spiritBoxText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        fingerprintImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + fingerprintText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        dotsProjectorImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                selectedEvidence = "" + dotsProjectorText.getText();
                evideneceCollected.add(selectedEvidence);

                possibleGhostList();

                possibleEvidenceList = possibleEvidenceCreator();

                imagesForScreenCreator();


            }
        });

        ghostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Screen you want to show
                Intent intent = new Intent(MainActivity.this, PossibleGhostList.
                        class);
                intent.putParcelableArrayListExtra("possibleGhostList", possibleGhostList);
                intent.putStringArrayListExtra("evideneceCollected", evideneceCollected);
                startActivity(intent);

            }
        });



        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                possibleGhostList.clear();
                evideneceCollected.clear();
                ghostFound = false;
                onBackPressed();
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
        dotsProjectorImage = (ImageView) findViewById(R.id.dotsProjectorImage);
        dotsProjectorText = (TextView) findViewById(R.id.dotsProjectorText);
        evdTbRow31 = (TableRow) findViewById(R.id.evdTbRow31);
        evdTbRow32 = (TableRow) findViewById(R.id.evdTbRow32);
        spiritBoxText = (TextView) findViewById(R.id.spiritBoxText);
        fingerprintText = (TextView) findViewById(R.id.fingerprintText);
        Evidence1 = (TextView) findViewById(R.id.Evidence1);
        Evidence2 = (TextView) findViewById(R.id.Evidence2);
        Evidence3 = (TextView) findViewById(R.id.Evidence3);
        ghostImage = (ImageView) findViewById(R.id.ghostImage);
        possubleGhostTitle = (TextView) findViewById(R.id.possubleGhostTitle);
        resetButton = (Button) findViewById(R.id.resetButton);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Evidence> possibleEvidenceCreator() {
        possibleEvidenceList.clear();
        String Evidence2;
        String Evidence3;
        Evidence2 = "";
        Evidence3 = "";
        if (evideneceCollected.size() == 2) {
            Evidence2 = evideneceCollected.get(1);
        }
        if (evideneceCollected.size() == 3) {
            Evidence3 = evideneceCollected.get(2);
        }

        for (Ghost ghost : possibleGhostList) {

            if (ghost.getEvidence1().getEvidenceTitle().contentEquals(selectedEvidence) ||
                    ghost.getEvidence1().getEvidenceTitle().contentEquals(evideneceCollected.get(0)) ||
                    ghost.getEvidence1().getEvidenceTitle().contentEquals(Evidence2)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence1());
            }
            if (ghost.getEvidence2().getEvidenceTitle().contentEquals(selectedEvidence) ||
                    ghost.getEvidence2().getEvidenceTitle().contentEquals(evideneceCollected.get(0)) ||
                    ghost.getEvidence2().getEvidenceTitle().contentEquals(Evidence2)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence2());
            }
            if (ghost.getEvidence3().getEvidenceTitle().contentEquals(selectedEvidence) ||
                    ghost.getEvidence3().getEvidenceTitle().contentEquals(evideneceCollected.get(0)) ||
                    ghost.getEvidence3().getEvidenceTitle().contentEquals(Evidence2)) {
            } else {
                possibleEvidenceList.add(ghost.getEvidence3());
            }


        }

        possibleEvidenceList = (ArrayList) possibleEvidenceList.stream().distinct().collect(Collectors.toList());


        return possibleEvidenceList;
    }

    public void possibleGhostList() {


        if (evideneceCollected.size() == 1) {
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
            if (evideneceCollected.contains("Ghost Orb")) {
                for (Ghost ghosty : ghostList) {
                    if ("The Mimic".equals(ghosty.getGhostName())) {
                        possibleGhostList.add(ghosty);
                    }
                }
            }
        }

        ArrayList<Ghost> newGhostList = new ArrayList<Ghost>();
        ArrayList<Evidence> evidenceToCycle = new ArrayList<Evidence>();
       Ghost mimicHolder = null;
        for (Ghost ghosty : ghostList) {
            if ("The Mimic".equals(ghosty.getGhostName())) {
                mimicHolder = ghosty;
            }
        }

        if (evideneceCollected.size() >= 2){

        for (Ghost ghost : possibleGhostList) {
            evidenceToCycle = ghost.getEvideneceForGhost();
            if (evidenceToCycle.get(0).getEvidenceTitle().contains(selectedEvidence) ||
                    evidenceToCycle.get(1).getEvidenceTitle().contains(selectedEvidence) ||
                    evidenceToCycle.get(2).getEvidenceTitle().contains(selectedEvidence)
            ) {
                newGhostList.add(ghost);
            }
        }
        if (evideneceCollected.contains("Ghost Orb") && evideneceCollected.contains("Spirit Box") ||
                evideneceCollected.contains("Ghost Orb") && evideneceCollected.contains("Fingerprints") ||
                evideneceCollected.contains("Ghost Orb") && evideneceCollected.contains("Freezing Temperatures")) {
            for (Ghost ghosty : ghostList) {
                if ("The Mimic".equals(ghosty.getGhostName())) {
                    possibleGhostList.add(ghosty);
                }
            }
            possibleGhostList.clear();

            possibleGhostList.addAll(newGhostList);
        }



        }


        if (evideneceCollected.size() == 3 &&
                evideneceCollected.contains("Ghost Orb")&&  evideneceCollected.contains("Fingerprints") &&  evideneceCollected.contains("Freezing Temperatures") ||
                evideneceCollected.contains("Ghost Orb")&&  evideneceCollected.contains("Freezing Temperatures") &&  evideneceCollected.contains("Spirit Box")
        ) {newGhostList.clear();
            for (Ghost ghost : possibleGhostList) {
                evidenceToCycle = ghost.getEvideneceForGhost();
                if (evidenceToCycle.get(0).getEvidenceTitle().contains(selectedEvidence) ||
                        evidenceToCycle.get(1).getEvidenceTitle().contains(selectedEvidence) ||
                        evidenceToCycle.get(2).getEvidenceTitle().contains(selectedEvidence) ||
                        evidenceToCycle.get(3).getEvidenceTitle().contains(selectedEvidence)
                ) {

                    newGhostList.add(ghost);
                }
            }

            possibleGhostList.clear();

            possibleGhostList.addAll(newGhostList);
       }  else if ((evideneceCollected.size() == 3) &&
                !((evideneceCollected.contains("Ghost Orb") && evideneceCollected.contains("Fingerprints") && evideneceCollected.contains("Freezing Temperatures")) ||
                        (evideneceCollected.contains("Ghost Orb") && evideneceCollected.contains("Freezing Temperatures") && evideneceCollected.contains("Fingerprints")))
        )  {
            ghostFound =true;
            Intent intent = new Intent(MainActivity.this, GhostDetailPage.
                    class);
            intent.putExtra("selectedGhost", possibleGhostList.get(0));
            intent.putParcelableArrayListExtra("possibleGhostList", possibleGhostList);
            intent.putStringArrayListExtra("evideneceCollected", evideneceCollected);
            startActivity(intent);
        } if ((evideneceCollected.size() == 4))  {

            Intent intent = new Intent(MainActivity.this, GhostDetailPage.
                    class);
            ghostFound = true;
            intent.putExtra("selectedGhost", possibleGhostList.get(0));
            intent.putParcelableArrayListExtra("possibleGhostList", possibleGhostList);
            intent.putStringArrayListExtra("evideneceCollected", evideneceCollected);
            startActivity(intent);
        }

        }






    public void imagesForScreenCreator() {

        if (evideneceCollected.size() < 4) {
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
                try {
                    seventhImage = imageIdlist.get(6);
                    seventhTextRef = evideneTitlelist.get(6);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    seventhImage = 0;
                    seventhTextRef = "";
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
                seventhImage = 0;
                seventhTextRef = "";
            }
        }


        Image1.setImageResource(firstImage);
        Image2.setImageResource(secoundImage);
        ghostWritingImage.setImageResource(thirdImage);
        tempImage.setImageResource(fourthImage);
        spiritBoxImage.setImageResource(fifthImage);
        fingerprintImage.setImageResource(sixthImage);
        dotsProjectorImage.setImageResource(seventhImage);

        emf5Text.setText(firstTextRef);
        ghostOrbText.setText(secoundTextRef);
        ghostWritingText.setText(thirdTextRef);
        freezingTempText.setText(fourthTextRef);
        spiritBoxText.setText(fifthTextRef);
        fingerprintText.setText(sixthTextRef);
        dotsProjectorText.setText(seventhTextRef);

        actionTitleChanger();

        evideneTitlelist.clear();
        imageIdlist.clear();


    }

    public void actionTitleChanger() {

        if (evideneceCollected.size() == 0) {
            actionTitle.setText("Select your 1st evidence found");
        }

        if (evideneceCollected.size() == 1) {
            actionTitle.setText("Select your 2nd evidence found");
        }
        if (evideneceCollected.size() == 2  ) {
            actionTitle.setText("Select your 3rd evidence found");
        }
        if (evideneceCollected.size() == 3 && possibleMimicChecker()){
            actionTitle.setText("Select your 4th evidence found To confirm Mimic or not");
        }

        possibleGhostButton();
    }

    public void possibleGhostButton() {
        Evidence1.setVisibility(View.GONE);

        if (evideneceCollected.size() >= 1) {
            ghostImage.setVisibility(View.VISIBLE);
            possubleGhostTitle.setVisibility(View.VISIBLE);
            resetButton.setVisibility(View.VISIBLE);
        }
        if (evideneceCollected.size() >= 2) {
            ghostImage.setVisibility(View.VISIBLE);
            possubleGhostTitle.setVisibility(View.VISIBLE);
            resetButton.setVisibility(View.VISIBLE);
        }

        if (evideneceCollected.isEmpty()) {
            ghostImage.setVisibility(View.GONE);
            possubleGhostTitle.setVisibility(View.GONE);
            Evidence1.setVisibility(View.GONE);
            Evidence2.setVisibility(View.GONE);
            Evidence3.setVisibility(View.GONE);
            resetButton.setVisibility(View.GONE);
        }

        if (evideneceCollected.size() >= 1) {
            Evidence1.setText("Evidence 1: " + evideneceCollected.get(0));
            Evidence1.setVisibility(View.VISIBLE);
        }
        if (evideneceCollected.size() == 2) {
            Evidence2.setText("Evidence 2: " + evideneceCollected.get(1));
            Evidence2.setVisibility(View.VISIBLE);
        }
        if (evideneceCollected.size() == 3) {
            Evidence3.setText("Evidence 3: " + evideneceCollected.get(2));
            Evidence3.setVisibility(View.VISIBLE);
        }


    }


    public void onResume() {




        if(evideneceCollected.size() == 3 && !(possibleMimicChecker())){
            evideneceCollected.clear();
            onBackPressed();
        }
        if(evideneceCollected.size() == 4){
            evideneceCollected.clear();
            onBackPressed();
        }
        if((evideneceCollected.size() == 3 && ghostFound)
        ||(evideneceCollected.size() == 4 && ghostFound)
        ){
        ghostFound = false;
            evideneceCollected.clear();
            onBackPressed();
        }
        super.onResume();


    }

    public void intialSetup() {
        Evidence EMFLevel5 = new Evidence("EMF Level 5", R.drawable.emf5);
        Evidence GhostOrb = new Evidence("Ghost Orb", R.drawable.ghostorbs);
        Evidence GhostWriting = new Evidence("Ghost Writing", R.drawable.ghostwriting);
        Evidence FreezingTemperatures = new Evidence("Freezing Temperatures", R.drawable.freezing_tempt_info);
        Evidence SpiritBox = new Evidence("Spirit Box", R.drawable.spirit_box);
        Evidence Fingerprints = new Evidence("Fingerprints", R.drawable.fingerprints);
        Evidence Dotsprojector = new Evidence("D.O.T.S. Projector", R.drawable.dotsprojector);

        Ghost Spirit = new Ghost("Spirit", SpiritBox, EMFLevel5, GhostWriting, getString(R.string.SpiritDesc));
        Ghost Wraith = new Ghost("Wraith", SpiritBox, EMFLevel5, Dotsprojector, getString(R.string.WraithDesc));
        Ghost Phantom = new Ghost("Phantom", SpiritBox, Fingerprints, Dotsprojector, getString(R.string.PhantomDesc));
        Ghost Poltergeist = new Ghost("Poltergeist", SpiritBox, GhostWriting, Fingerprints, getString(R.string.PoltergeistDesc));
        Ghost Banshees = new Ghost("Banshees", Dotsprojector, Fingerprints, GhostOrb, getString(R.string.BansheesDesc));
        Ghost Jinn = new Ghost("Jinn", Fingerprints, FreezingTemperatures, EMFLevel5, getString(R.string.JinnDesc));
        Ghost Mare = new Ghost("Mare", GhostWriting, GhostOrb, SpiritBox, getString(R.string.MareDesc));
        Ghost Revenant = new Ghost("Revenant", GhostOrb, FreezingTemperatures, GhostWriting, getString(R.string.RevenantDesc));
        Ghost Shade = new Ghost("Shade", EMFLevel5, FreezingTemperatures, GhostWriting, getString(R.string.ShadeDesc));
        Ghost Demon = new Ghost("Demon", GhostWriting, FreezingTemperatures, Fingerprints, getString(R.string.DemonDesc));
        Ghost Yurei = new Ghost("Yurei", GhostOrb, FreezingTemperatures, Dotsprojector, getString(R.string.YureiDesc));
        Ghost Oni = new Ghost("Oni", EMFLevel5, FreezingTemperatures, Dotsprojector, getString(R.string.OniDesc));
        Ghost Yokai = new Ghost("Yokai", GhostOrb, SpiritBox, Dotsprojector, getString(R.string.YokaiDesc));
        Ghost Hantu = new Ghost("Hantu", Fingerprints, GhostOrb, FreezingTemperatures, getString(R.string.HantuDesc));
        Ghost Myling = new Ghost("Myling", Fingerprints, EMFLevel5, GhostWriting, getString(R.string.MylingDesc));
        Ghost Goryo = new Ghost("Goryo", Fingerprints, EMFLevel5, Dotsprojector, getString(R.string.GoryoDesc));
        Ghost Obake = new Ghost("Obake", Fingerprints, EMFLevel5, GhostOrb, getString(R.string.ObakeDesc));
        Ghost Onryo = new Ghost("Onryo", GhostOrb, SpiritBox, FreezingTemperatures, getString(R.string.OnryoDesc));
        Ghost Raiju = new Ghost("Raiju", EMFLevel5, GhostOrb, Dotsprojector, getString(R.string.RaijuDesc));
        Ghost TheTwins = new Ghost("The Twins", SpiritBox, EMFLevel5, FreezingTemperatures, getString(R.string.TheTwinsDesc));
        Ghost TheMimic = new Ghost("The Mimic", SpiritBox, Fingerprints, FreezingTemperatures, getString(R.string.TheMimicDesc));
        Ghost Deogen = new Ghost("Deogen", SpiritBox, GhostWriting, Dotsprojector, getString(R.string.DeogenDesc));
        Ghost Moroi = new Ghost("Moroi", SpiritBox, GhostWriting, FreezingTemperatures, getString(R.string.MoroiDesc));
        Ghost Thaye = new Ghost("Thaye", GhostOrb, GhostWriting, Dotsprojector, getString(R.string.ThayeDesc));

        ghostList.clear();
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
        ghostList.add(Yokai);
        ghostList.add(Hantu);
        ghostList.add(Myling);
        ghostList.add(Goryo);
        ghostList.add(Obake);
        ghostList.add(Onryo);
        ghostList.add(Raiju);
        ghostList.add(TheTwins);
        ghostList.add(TheMimic);
        ghostList.add(Deogen);
        ghostList.add(Moroi);
        ghostList.add(Thaye);

        possibleEvidenceList.clear();
        possibleEvidenceList.add(EMFLevel5);
        possibleEvidenceList.add(GhostOrb);
        possibleEvidenceList.add(GhostWriting);
        possibleEvidenceList.add(FreezingTemperatures);
        possibleEvidenceList.add(SpiritBox);
        possibleEvidenceList.add(Fingerprints);
        possibleEvidenceList.add(Dotsprojector);

        imagesForScreenCreator();


    }

    public Boolean possibleMimicChecker(){
        Boolean possibleMimic = false;
        for (Ghost ghosty : this.possibleGhostList) {
            if ("The Mimic".equals(ghosty.getGhostName())) {
                possibleMimic = true;
                break;
            }}
    return possibleMimic;
    }

    @Override
    public void onBackPressed() {
        // code here to show dialog

        possibleEvidenceList.clear();
        possibleGhostList.clear();
        evideneceCollected.clear();

        intialSetup();
        //super.onBackPressed();  // optional depending on your needs

    }

}


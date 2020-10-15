package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.adapters.GhostAdapter;
import com.example.phasmophobiamobilejournal.classesforobjects.Evidence;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;

public class PossibleGhostList extends AppCompatActivity implements GhostAdapter.RecyclerClickListener {

    GhostAdapter GhostAdapter;
    private TextView evidence1Text;
    private TextView evidence2Text;
    private TextView evidence3Text;
    private TextView descriptionTitleText;
    private RecyclerView RecycleListView;
    private ImageView imageView2;
    private TextView textView5;
    private ArrayList<Ghost> possibleGhostArrayList = new ArrayList<Ghost>();

    Evidence EMFLevel5 = new Evidence("EMF Level 5", R.drawable.emf5);
    Evidence GhostOrb = new Evidence("Ghost Orb", R.drawable.ghostorbs);
    Evidence GhostWriting = new Evidence("Ghost Writing", R.drawable.ghostwriting);
    Evidence FreezingTemperatures = new Evidence("Freezing Temperatures", R.drawable.freezing_tempt_info);
    Evidence SpiritBox = new Evidence("Spirit Box", R.drawable.spirit_box);
    Evidence Fingerprints = new Evidence("Fingerprints", R.drawable.fingerprints);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Ghost Spirit = new Ghost("Spirit",SpiritBox, Fingerprints, GhostWriting, getString(R.string.SpiritDesc));
        Ghost Wraith = new Ghost("Wraith",SpiritBox, Fingerprints, FreezingTemperatures, getString(R.string.WraithDesc));
        Ghost Phantom = new Ghost("Phantom",EMFLevel5, GhostOrb, FreezingTemperatures, getString(R.string.PhantomDesc));
        Ghost Poltergeist = new Ghost("Poltergeist",SpiritBox, Fingerprints, GhostOrb, getString(R.string.PoltergeistDesc));
        Ghost Banshees = new Ghost("Banshees",EMFLevel5, Fingerprints, FreezingTemperatures, getString(R.string.BansheesDesc));
        Ghost Jinn = new Ghost("Jinn",SpiritBox, GhostOrb, EMFLevel5, getString(R.string.JinnDesc));
        Ghost Mare = new Ghost("Mare",SpiritBox, GhostOrb, FreezingTemperatures, getString(R.string.MareDesc));
        Ghost Revenant = new Ghost("Revenant",EMFLevel5, Fingerprints, GhostWriting, getString(R.string.RevenantDesc));
        Ghost Shade = new Ghost("Shade",EMFLevel5, GhostOrb, GhostWriting, getString(R.string.ShadeDesc));
        Ghost Demon = new Ghost("Demon",SpiritBox, FreezingTemperatures, GhostWriting, getString(R.string.DemonDesc));
        Ghost Yurei = new Ghost("Yurei",GhostOrb, FreezingTemperatures, GhostWriting, getString(R.string.YureiDesc));
        Ghost Oni = new Ghost("Oni",EMFLevel5, SpiritBox, GhostWriting, getString(R.string.OniDesc));

        possibleGhostArrayList.add(Spirit);
        possibleGhostArrayList.add(Wraith);
        possibleGhostArrayList.add(Phantom);
        possibleGhostArrayList.add(Poltergeist);
        possibleGhostArrayList.add(Banshees);
        possibleGhostArrayList.add(Jinn);
        possibleGhostArrayList.add(Mare);
        possibleGhostArrayList.add(Revenant);
        possibleGhostArrayList.add(Shade);
        possibleGhostArrayList.add(Demon);
        possibleGhostArrayList.add(Yurei);
        possibleGhostArrayList.add(Oni);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possible_ghost_list);
        findViews();

        GhostAdapter = new GhostAdapter(possibleGhostArrayList, PossibleGhostList.this);
        GhostAdapter.setRecyclerClickListener(this);
        RecycleListView.setAdapter(GhostAdapter);

        RecycleListView.setLayoutManager(new LinearLayoutManager(PossibleGhostList.this));
    }

    private void findViews() {
        evidence1Text = (TextView) findViewById(R.id.evidence1Text);
        evidence2Text = (TextView) findViewById(R.id.evidence2Text);
        evidence3Text = (TextView) findViewById(R.id.evidence3Text);
        descriptionTitleText = (TextView) findViewById(R.id.descriptionTitleText);
        RecycleListView = (RecyclerView) findViewById(R.id.ghostListView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView5 = (TextView) findViewById(R.id.textView5);
    }

    @Override
    public void onClickPerformed(int adapterPosition) {
        Log.e("Position clicked", " " + adapterPosition);

        Intent intent = new Intent(this, PossibleGhostList.class);
        //intent.putExtra("AssessmentID", AssessmentList.get(postion).getAssessmentId());
        // to pass a key intent.putExtra("name",name);
        //startActivity(intent);
    }
}



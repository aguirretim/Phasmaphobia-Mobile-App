package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.adapters.GhostAdapter;
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
    ArrayList<String> evideneceCollected = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possible_ghost_list);
        findViews();
        ArrayList<Ghost> extras = getIntent().getParcelableArrayListExtra("possibleGhostList");
        evideneceCollected = getIntent().getStringArrayListExtra("evideneceCollected");
        possibleGhostArrayList = extras;

        possibleEvidenceTextSet();

        GhostAdapter = new GhostAdapter(evideneceCollected,possibleGhostArrayList, PossibleGhostList.this);
        GhostAdapter.setRecyclerClickListener(this);
        RecycleListView.setAdapter(GhostAdapter);

        RecycleListView.setLayoutManager(new LinearLayoutManager(PossibleGhostList.this));

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Screen you want to show
                onBackPressed();

            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Screen you want to show
                onBackPressed();

            }
        });

    }


    private void findViews() {
        evidence1Text = (TextView) findViewById(R.id.evidence1Text);
        evidence2Text = (TextView) findViewById(R.id.evidence2Text);
        evidence3Text = (TextView) findViewById(R.id.evidence3Text);
        descriptionTitleText = (TextView) findViewById(R.id.descriptionTitleText);
        RecycleListView = (RecyclerView) findViewById(R.id.ghostDescText);
        imageView2 = (ImageView) findViewById(R.id.ghostImageIcon);
        textView5 = (TextView) findViewById(R.id.returnToGhostListTXT);
    }

    @Override
    public void onClickPerformed(int adapterPosition) {
        Log.e("Position clicked", " " + adapterPosition);

        Intent intent = new Intent(this, GhostDetailPage.class);
        intent.putExtra("selectedGhost", possibleGhostArrayList.get(adapterPosition));
        intent.putStringArrayListExtra("evideneceCollected", evideneceCollected);
        // to pass a key intent.putExtra("name",name);
        startActivity(intent);
    }

    public void possibleEvidenceTextSet() {
        evidence1Text.setVisibility(View.GONE);


        if (evideneceCollected.size() >= 1) {
            evidence1Text.setText("Evidence 1: " + evideneceCollected.get(0));
            evidence1Text.setVisibility(View.VISIBLE);
        }
        if (evideneceCollected.size() >= 2) {
            evidence2Text.setText("Evidence 2: " + evideneceCollected.get(1));
            evidence2Text.setVisibility(View.VISIBLE);
        }
        if (evideneceCollected.size() >= 3) {
            evidence3Text.setText("Evidence 3: " + evideneceCollected.get(2));
            evidence3Text.setVisibility(View.VISIBLE);
        }


    }

    public void onBackPressed() {
        // code here to show dialog

        super.onBackPressed();  // optional depending on your needs
    }

}



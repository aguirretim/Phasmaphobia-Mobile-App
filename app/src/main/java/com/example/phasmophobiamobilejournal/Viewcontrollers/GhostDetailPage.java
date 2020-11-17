package com.example.phasmophobiamobilejournal.Viewcontrollers;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.classesforobjects.Evidence;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;
import java.util.Locale;

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;
import static java.lang.Boolean.TRUE;

public class GhostDetailPage extends AppCompatActivity {

    private TextView evidence1Text;
    private TextView evidence2Text;
    private TextView evidence3Text;
    private TextView descriptionTitleText;
    private TextView ghostDescText;
    private ImageView ghostImageIcon;
    private TextView returnToGhostListTXT;
    private TextView ghostEvidenceRemainText;
    private Ghost selectedGhost;
    ArrayList<String> evideneceCollected = new ArrayList<String>();
    ArrayList<String> selectedGhostArray = new ArrayList<String>();
    ArrayList<String> descriptionTextToBold = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ghost_detail_page);
        findViews();
        selectedGhost = (Ghost) getIntent().getExtras().get("selectedGhost");

        selectedGhostArray.add(selectedGhost.getGhostName());


        descriptionTitleText.setText(emboldenKeywords("Based on the evidence you selected. The ghost could be a " + selectedGhost.getGhostName(), selectedGhostArray));

        descriptionTextToBold.add("Unique Strengths");
        descriptionTextToBold.add("Weaknesses");

        ghostDescText.setText(emboldenKeywords(selectedGhost.getGhostDescription(), descriptionTextToBold));
        evideneceCollected = getIntent().getStringArrayListExtra("evideneceCollected");
        possibleEvidenceTextSet();
        remainingEvidenceGenerator();


        ghostImageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Screen you want to show
                onBackPressed();
            }
        });

        returnToGhostListTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Screen you want to show

                Intent intent = new Intent(GhostDetailPage.this, MainActivity.
                        class);
                intent.putExtra("newGhostReset", TRUE);

                onBackPressed();

            }
        });


    }


    private void findViews() {
        evidence1Text = (TextView) findViewById(R.id.evidence1Text);
        evidence2Text = (TextView) findViewById(R.id.evidence2Text);
        evidence3Text = (TextView) findViewById(R.id.evidence3Text);
        descriptionTitleText = (TextView) findViewById(R.id.descriptionTitleText);
        ghostDescText = (TextView) findViewById(R.id.ghostDescText);
        ghostImageIcon = (ImageView) findViewById(R.id.ghostImageIcon);
        returnToGhostListTXT = (TextView) findViewById(R.id.returnToGhostListTXT);
        ghostEvidenceRemainText = (TextView) findViewById(R.id.ghostEvidenceRemainText);
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

    public void remainingEvidenceGenerator() {

        String remainEvidenceString;
        descriptionTextToBold.add("Needed evidence to confirm:");
        remainEvidenceString = "Needed evidence to confirm:\n ";

        ArrayList<Evidence> evidenceToCycle = new ArrayList<Evidence>();
        if (evideneceCollected.size() == 1) {

            evidenceToCycle = selectedGhost.getEvideneceForGhost();
            if (!evidenceToCycle.get(0).getEvidenceTitle().contains(evideneceCollected.get(0))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(0).getEvidenceTitle() + "\n ";
            }
            if (!evidenceToCycle.get(1).getEvidenceTitle().contains(evideneceCollected.get(0))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(1).getEvidenceTitle() + "\n ";
            }
            if (!evidenceToCycle.get(2).getEvidenceTitle().contains(evideneceCollected.get(0))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(2).getEvidenceTitle() + "\n ";
            }

        }

        if (evideneceCollected.size() == 2) {

            evidenceToCycle = selectedGhost.getEvideneceForGhost();
            if (!(evidenceToCycle.get(0).getEvidenceTitle().contains(evideneceCollected.get(1))) && (!evidenceToCycle.get(0).getEvidenceTitle().contains(evideneceCollected.get(0)))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(0).getEvidenceTitle() + "\n ";
            }
            if (!evidenceToCycle.get(1).getEvidenceTitle().contains(evideneceCollected.get(1)) && (!evidenceToCycle.get(1).getEvidenceTitle().contains(evideneceCollected.get(0)))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(1).getEvidenceTitle() + "\n ";
            }
            if (!evidenceToCycle.get(2).getEvidenceTitle().contains(evideneceCollected.get(1)) && (!evidenceToCycle.get(2).getEvidenceTitle().contains(evideneceCollected.get(0)))) {
                remainEvidenceString = remainEvidenceString + evidenceToCycle.get(2).getEvidenceTitle() + "\n ";
            }
        }

        if (evideneceCollected.size() == 3) {
            descriptionTitleText.setText(emboldenKeywords("Based on the evidence you selected The ghost is a " + selectedGhost.getGhostName(),selectedGhostArray));
            returnToGhostListTXT.setText("Reset and Return to \nHunting More Ghost");
            ghostImageIcon.setImageDrawable(getResources().getDrawable(R.drawable.ghostinspecticon));
            ghostEvidenceRemainText.setVisibility(View.GONE);

        }

        ghostEvidenceRemainText.setText(emboldenKeywords(remainEvidenceString, descriptionTextToBold));

    }

    public void onBackPressed() {
        // code here to show dialog

        super.onBackPressed();  // optional depending on your needs
    }

    private static SpannableStringBuilder emboldenKeywords(final String text,
                                                           final ArrayList<String> searchKeywords) {
        // searching in the lower case text to make sure we catch all cases
        final String loweredMasterText = text.toLowerCase(Locale.ENGLISH);
        final SpannableStringBuilder span = new SpannableStringBuilder(text);

        // for each keyword
        for (final String keyword : searchKeywords) {
            // lower the keyword to catch both lower and upper case chars
            final String loweredKeyword = keyword.toLowerCase(Locale.ENGLISH);

            // start at the beginning of the master text
            int offset = 0;
            int start;
            final int len = keyword.length(); // let's calculate this outside the 'while'

            while ((start = loweredMasterText.indexOf(loweredKeyword, offset)) >= 0) {
                // make it bold
                span.setSpan(new StyleSpan(Typeface.BOLD), start, start + len, SPAN_INCLUSIVE_INCLUSIVE);
                // move your offset pointer
                offset = start + len;
            }
        }
        // put it in your TextView and smoke it!
        return span;
    }

}


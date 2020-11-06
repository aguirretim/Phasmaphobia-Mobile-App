package com.example.phasmophobiamobilejournal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phasmophobiamobilejournal.R;
import com.example.phasmophobiamobilejournal.classesforobjects.Ghost;

import java.util.ArrayList;
import java.util.List;

public class GhostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private ArrayList<String> evideneceCollected = new ArrayList<String>();
    private List<Ghost> vlist;
    private Context vContext;
    private LayoutInflater vInflator;
    private Ghost vGhost;
    private GhostAdapter.RecyclerClickListener recyclerClickListener;


    /****************************
     * Constructor for Object.  *
     ****************************/

    public GhostAdapter(ArrayList<String> evideneceCollected, List<Ghost> vlist, Context vContext) {
        this.evideneceCollected = evideneceCollected;
        this.vlist = vlist;
        this.vContext = vContext;
        this.vInflator = LayoutInflater.from(vContext);
    }

    /****************************
     * Methods for adapter      *
     ****************************/

    // Responsible for telling what each cell is suppose to look like.
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = vInflator.inflate(R.layout.ghost_list_item, parent, false);
        return new GhostAdapter.ViewHolder(v);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    // Responsible to give values to each value in a layout.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GhostAdapter.ViewHolder ViewHolder = (GhostAdapter.ViewHolder) holder;
        vGhost = vlist.get(position);
        ViewHolder.ghostNameId.setText(vGhost.getGhostName());

        String Evidence1, Evidence2, Evidence3;
        Evidence1 = "";
        if (evideneceCollected.size() >= 1) {
            Evidence1 = evideneceCollected.get(0);
        }

        Evidence2 = "";
        if (evideneceCollected.size() >= 2) {
            Evidence2 = evideneceCollected.get(1);
        }

        Evidence3 = "";
        if (evideneceCollected.size() >= 3) {
            Evidence3 = evideneceCollected.get(2);
        }

        String GhostEvidence1 = vGhost.getEvidence1().getEvidenceTitle() + ", ";
        String GhostEvidence2 = vGhost.getEvidence2().getEvidenceTitle() + ", ";
        String GhostEvidence3 = vGhost.getEvidence3().getEvidenceTitle();


        if (!(Evidence1.contentEquals(vGhost.getEvidence1().getEvidenceTitle())) &&
                !(Evidence2.contentEquals(vGhost.getEvidence1().getEvidenceTitle())) &&
                !(Evidence3.contentEquals(vGhost.getEvidence1().getEvidenceTitle()))
        ) {
            GhostEvidence1 = vGhost.getEvidence1().getEvidenceTitle() + ", ";
        } else {
            GhostEvidence1 = "";
        }
        if (!(Evidence1.contentEquals(vGhost.getEvidence2().getEvidenceTitle())) &&
                !(Evidence2.contentEquals(vGhost.getEvidence2().getEvidenceTitle())) &&
                !(Evidence3.contentEquals(vGhost.getEvidence2().getEvidenceTitle()))) {
            GhostEvidence2 = vGhost.getEvidence2().getEvidenceTitle() + ", ";
        } else {
            GhostEvidence2 = "";
        }
        if (!(Evidence1.contentEquals(vGhost.getEvidence3().getEvidenceTitle())) &&
                !(Evidence2.contentEquals(vGhost.getEvidence3().getEvidenceTitle())) &&
                !(Evidence3.contentEquals(vGhost.getEvidence3().getEvidenceTitle()))) {
            GhostEvidence3 = vGhost.getEvidence3().getEvidenceTitle();
        } else {
            GhostEvidence3 = "";
        }


        ViewHolder.evidenceneededText.setText(GhostEvidence1 +
                GhostEvidence2 + GhostEvidence3);


    }

    // Responsible for how many elements are in the recycle view.
    @Override
    public int getItemCount() {
        return vlist.size();
    }

    /****************************
     * View holder binding the data ??*
     ****************************/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ghostNameId;
        TextView evidenceNeededTitle;
        TextView evidenceneededText;

        public ViewHolder(View v) {

            super(v);
            ghostNameId = (TextView) v.findViewById(R.id.ghostNameId);
            evidenceNeededTitle = (TextView) v.findViewById(R.id.evidenceNeededTitle);
            evidenceneededText = (TextView) v.findViewById(R.id.evidenceneededText);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (recyclerClickListener != null) {
                recyclerClickListener.onClickPerformed(getAdapterPosition());
            }
        }
    }

    public void setRecyclerClickListener(GhostAdapter.RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
    }

    public interface RecyclerClickListener {
        void onClickPerformed(int adapterPosition);

    }


}


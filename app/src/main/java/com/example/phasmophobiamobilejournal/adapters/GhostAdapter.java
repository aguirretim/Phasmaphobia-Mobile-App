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

import java.util.List;

public class GhostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**************************************
     * initialized Variables for Object.  *
     **************************************/

    private List<Ghost> vlist;
    private Context vContext;
    private LayoutInflater vInflator;
    private Ghost vGhost;
    private GhostAdapter.RecyclerClickListener recyclerClickListener;

    /****************************
     * Constructor for Object.  *
     ****************************/

    public GhostAdapter(List<Ghost> vlist, Context vContext) {
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
        ViewHolder.evidenceneededText.setText(vGhost.getEvidence1().getEvidenceTitle() + ", " + vGhost.getEvidence2().getEvidenceTitle() + ", " + vGhost.getEvidence3().getEvidenceTitle());


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


package com.app.web.ags.colombiaelige.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.web.ags.colombiaelige.POJOS.Candidate;
import com.app.web.ags.colombiaelige.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.ViewHolder>{

    private Context context;
    private List<Candidate> candidates;

    public CandidatesAdapter(Context context, List<Candidate> candidates) {
        this.context = context;
        this.candidates = candidates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.candidateitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(candidates.get(position).getImageUrl()).into(holder.imageView);
        holder.candidateName.setText(candidates.get(position).getName() + " " + candidates.get(position).getLastname());
        holder.candidatePoliticParty.setText(candidates.get(position).getPolitic_party());
    }

    @Override
    public int getItemCount() {
        return candidates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imageView;
        private TextView candidateName;
        private TextView candidatePoliticParty;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.candidate_card);
            imageView = itemView.findViewById(R.id.candidate_image);
            candidateName = itemView.findViewById(R.id.candidate_name);
            candidatePoliticParty = itemView.findViewById(R.id.candidate_party);
        }
    }
}

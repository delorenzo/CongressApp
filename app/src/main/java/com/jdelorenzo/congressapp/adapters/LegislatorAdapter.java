package com.jdelorenzo.congressapp.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.model.Legislator;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link android.support.v7.widget.RecyclerView.Adapter} for {@link Legislator} items
 */

public class LegislatorAdapter extends RecyclerView.Adapter<LegislatorAdapter.LegislatorAdapterViewHolder> {
    private List<Legislator> items;
    private Context context;
    private View emptyView;

    public LegislatorAdapter(Context context, View emptyView) {
        this.context = context;
        this.emptyView = emptyView;
    }

    @Override
    public int getItemCount() {
        return items == null ? 0: items.size();
    }

    public void setItems(List<Legislator> items) {
        this.items = items;
        emptyView.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(LegislatorAdapterViewHolder holder, int position) {
        if (items == null || items.size() == 0) return;
        Legislator legislator = items.get(position);
        holder.titleView.setText(legislator.title);
        holder.nameView.setText(String.format(Locale.getDefault(),
                        context.getString(R.string.legislator_name_format),
                        legislator.firstName,
                        legislator.lastName));
        holder.party.setText(legislator.party);
        holder.partyIconView.setText(legislator.party);
        holder.partyIconView.setBackground(legislator.isDemocrat() ?
                ContextCompat.getDrawable(context, R.drawable.circle_d) :
                ContextCompat.getDrawable(context, R.drawable.circle_r));
        holder.stateView.setText(legislator.state);
    }

    @Override
    public LegislatorAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (parent instanceof RecyclerView) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.legislator_item, parent, false);
           view.setFocusable(true);
           return new LegislatorAdapterViewHolder(view);
       } else {
           throw new RuntimeException("LegislatorAdapter not bound to RecyclerView");
       }
    }

    class LegislatorAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name) TextView nameView;
        @BindView(R.id.state) TextView stateView;
        @BindView(R.id.partyIcon) TextView partyIconView;
        @BindView(R.id.party) TextView party;
        @BindView(R.id.title) TextView titleView;

        LegislatorAdapterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

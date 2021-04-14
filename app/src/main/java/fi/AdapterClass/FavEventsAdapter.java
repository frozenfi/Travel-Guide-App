package fi.AdapterClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.nischhal.travelguide.R;


public class FavEventsAdapter extends RecyclerView.Adapter<FavEventsAdapter.FavEventViewHolder> {

    ArrayList<FavEventHelper> favEvents;

    public FavEventsAdapter(ArrayList<FavEventHelper> favEvents) {
        this.favEvents = favEvents;
    }

    @NonNull
    @Override
    public FavEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_event_card_design, parent, false);
        return  new FavEventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FavEventViewHolder holder, int position) {
        FavEventHelper favEventHelper = favEvents.get(position);
        holder. imgURL.setImageResource(favEventHelper.getImgURL());
        holder.nameOfEvent .setText(favEventHelper.getNameOfEvent());
        holder.descOfEvent.setText(favEventHelper.getDesOfEvent());
        holder.  placeOfEvent.setText(favEventHelper.getPlaceOfEvent());

    }

    @Override
    public int getItemCount() {
        return favEvents.size();
    }

    public static class  FavEventViewHolder extends RecyclerView.ViewHolder {

        ImageView imgURL;
        TextView nameOfEvent, descOfEvent, placeOfEvent;

        public FavEventViewHolder(@NonNull View itemView) {
            super(itemView);
            imgURL= itemView.findViewById(R.id.fav_event_img);
            nameOfEvent = itemView.findViewById(R.id.txt_event_title);
            descOfEvent= itemView.findViewById(R.id.txt_event_description);
            placeOfEvent= itemView.findViewById(R.id.txt_event_month);

        }

    }
}



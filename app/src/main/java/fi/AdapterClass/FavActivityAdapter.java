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


public class FavActivityAdapter extends RecyclerView.Adapter<FavActivityAdapter.FavActivityViewHolder> {

    ArrayList<FavActivityHelper> favActivity;

    public FavActivityAdapter(ArrayList<FavActivityHelper> favActivity) {
        this.favActivity = favActivity;
    }

    @NonNull
    @Override
    public FavActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_activity_card_design, parent, false);
        return  new FavActivityViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FavActivityViewHolder holder, int position) {
        FavActivityHelper favActivityHelper = favActivity.get(position);
        holder.imgURL.setImageResource(favActivityHelper.getImgURL());
        holder.nameOfEvent .setText(favActivityHelper.getNameOfEvent());
        holder.descOfEvent.setText(favActivityHelper.getDesOfEvent());
        holder.placeOfEvent.setText(favActivityHelper.getPlaceOfEvent());

    }

    @Override
    public int getItemCount() {
        return favActivity.size();
    }

    public static class  FavActivityViewHolder extends RecyclerView.ViewHolder {

        ImageView imgURL;
        TextView nameOfEvent, descOfEvent, placeOfEvent;

        public FavActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            imgURL= itemView.findViewById(R.id.fav_activity_img);
            nameOfEvent = itemView.findViewById(R.id.txt_activity_title);
            descOfEvent= itemView.findViewById(R.id.txt_activity_desc);
            placeOfEvent= itemView.findViewById(R.id.txt_activity_month);

        }

    }
}




package fi.AdapterClass;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.binod.travelguide.SplashScreen;
import fi.nischhal.travelguide.MainActivity;
import fi.nischhal.travelguide.R;
import fi.user.DetailsActivity;
import fi.user.FrontPage;


public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder> {


    ArrayList<RecommendationHelperClass> recommendedLocations;

    public RecommendationAdapter(ArrayList<RecommendationHelperClass> recommendedLocations) {
        this.recommendedLocations = recommendedLocations;
    }

    @NonNull
    @Override
    public RecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommendation_card_design, parent, false);
        return  new RecommendationViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecommendationViewHolder holder, int position) {
        RecommendationHelperClass featuredHelperClass = recommendedLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImg());
        holder.title.setText(featuredHelperClass.getItems());
        holder.desc.setText(featuredHelperClass.getItemDescription());

        holder.itemView.setOnClickListener(view -> {
           //view.getContext().startActivity( new Intent(view.getContext(), DetailsActivity.class));
        Intent intent = new Intent((view.getContext()), DetailsActivity.class);
        intent.putExtra("title", featuredHelperClass.getItems());
        intent.putExtra("desc", featuredHelperClass.getItemDescription());
        intent.putExtra("image", featuredHelperClass.getImg());
        view.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return recommendedLocations.size();
    }

    public static class  RecommendationViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;


        public RecommendationViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_text);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
}


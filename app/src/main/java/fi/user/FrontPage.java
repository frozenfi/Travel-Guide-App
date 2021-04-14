package fi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import fi.AdapterClass.FavActivityAdapter;
import fi.AdapterClass.FavActivityHelper;
import fi.AdapterClass.FavEventHelper;
import fi.AdapterClass.FavEventsAdapter;
import fi.AdapterClass.RecommendationAdapter;
import fi.AdapterClass.RecommendationHelperClass;
import fi.nischhal.travelguide.R;

public class  FrontPage extends AppCompatActivity {

    TextView txtViewSeeActivity,txtViewSeeEvent;
    RecyclerView featuredRecycler, favEventRecycler, favActivityRecycler;
    RecyclerView.Adapter featAdapter, favEventAdapter, favActivityAdapter;

    //Drawer Menu
    //DrawerLayout drawerLayout;
    //NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        txtViewSeeActivity = findViewById(R.id.txt_activity_see_all);
        txtViewSeeEvent = findViewById(R.id.txt_event_see_all);

        featuredRecycler = findViewById(R.id.recycler_recommendation);
        favEventRecycler = findViewById(R.id.fav_event_recycler);
        favActivityRecycler = findViewById(R.id.fav_activity_recycler);

        MyClick myClick = new MyClick();
        txtViewSeeEvent.setOnClickListener(myClick);
        txtViewSeeActivity.setOnClickListener(myClick);

        featuredRecycler();
        favEventRecycler();
        favActivityRecycler();
        //initSearchWidgets();

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<RecommendationHelperClass> recommendedLocations = new ArrayList<>();

        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel5, "Beautiful Helsinki", "Dummy text about the beautiful Helsinki "));
        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel2, "Next Page", "Dummy text about the beautiful Helsinki "));
        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel3, "Other Helsinki", "Dummy text about the beautiful Helsinki "));
        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel2, "Something new Helsinki", "Dummy text about the beautiful Helsinki "));
        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel6, "Can See it Helsinki", "Dummy text about the beautiful Helsinki "));
        recommendedLocations.add(new RecommendationHelperClass(R.drawable.hel5, "Really Helsinki", "Dummy text about the beautiful Helsinki "));

        featAdapter = new RecommendationAdapter(recommendedLocations);
        featuredRecycler.setAdapter(featAdapter);

        //Menu hooks
        //drawerLayout =findViewById(R.id.drawerLayout);
        //navigationView =findViewById(R.id.navigationView);

    }

    private void favEventRecycler() {
        favEventRecycler.setHasFixedSize(true);
        favEventRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FavEventHelper> favEvents = new ArrayList<>();

        favEvents.add(new FavEventHelper("Flow Festival", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.concert));
        favEvents.add(new FavEventHelper("Rock and roll", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.nature));
        favEvents.add(new FavEventHelper("Hard Rock Cafe", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.sauna));
        favEvents.add(new FavEventHelper("Heavy Metal", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.hel4));
        favEvents.add(new FavEventHelper("Black Sabbath", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.hel5));
        favEvents.add(new FavEventHelper("Eminen World Tour", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.hel6));

        favEventAdapter = new FavEventsAdapter(favEvents);
        favEventRecycler.setAdapter(favEventAdapter);

        //Menu hooks
        //drawerLayout =findViewById(R.id.drawerLayout);
        //navigationView =findViewById(R.id.navigationView);

    }

    private void favActivityRecycler() {
        favActivityRecycler.setHasFixedSize(true);
        favActivityRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FavActivityHelper> favActivity = new ArrayList<>();

        favActivity.add(new FavActivityHelper("Sauna by the lake", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.sauna));
        favActivity.add(new FavActivityHelper("Nature trails", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.nature));
        favActivity.add(new FavActivityHelper("A walk to remember", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.library));
        favActivity.add(new FavActivityHelper("The art cafe", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.recreation));
        favActivity.add(new FavActivityHelper("Open Swimming Pool", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.hel2));
        favActivity.add(new FavActivityHelper("The great circus", "Helsinki", "Dummy text about the beautiful Helsinki ", R.drawable.hel6));

        favActivityAdapter = new FavActivityAdapter(favActivity);
        favActivityRecycler.setAdapter(favActivityAdapter);


    }

    /*
    private void initSearchWidgets() {
        SearchView searchView = (SearchView) findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<FavActivityHelper> filterSearch = new ArrayList<FavActivityHelper>();

                for(FavActivityHelper favAct: filterSearch ) {
                    if(favAct.getNameOfEvent().toLowerCase().contains(newText.toLowerCase())) {
                        filterSearch.add(favAct);
                    }

                }
                FavActivityAdapter favActivityAdapter = new FavActivityAdapter(filterSearch);
                favActivityRecycler.setAdapter(favActivityAdapter);

                return false;
            }
        });
    }
*/
    private class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.txt_activity_see_all) {


            } else if(v.getId() == R.id.txt_event_see_all) {


            }
        }
    }


}


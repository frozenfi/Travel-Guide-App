package fi.nischhal.travelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import fi.nischhal.travelguide.events.EventsDatesList;
import fi.nischhal.travelguide.events.EventsDescriptionList;
import fi.nischhal.travelguide.events.EventsLocationList;

public class Intro_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_);
        TextView intro = findViewById(R.id.intro);
        TextView body = findViewById(R.id.body);
        TextView streetAddress = findViewById(R.id.streetAddress);
        TextView postalCode = findViewById(R.id.postalCode);
        TextView locality = findViewById(R.id.locality);
        TextView startDay = findViewById(R.id.startDay);
        TextView endDay = findViewById(R.id.endDay);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("intro");

        EventsDescriptionList descriptionList = EventsDescriptionList.getEventsDescriptionInstance();
        EventsLocationList eventsLocationList = EventsLocationList.getEventsLocationInstance();
        EventsDatesList eventsDatesList = EventsDatesList.getEventsDatesInstance();

        intro.setText(descriptionList.getDescription(position).getIntro());
        body.setText(descriptionList.getDescription(position).getBody());

        streetAddress.setText(eventsLocationList.getEventsLocation(position).getStreetAddress());
        postalCode.setText(eventsLocationList.getEventsLocation(position).getPostalCode()+",");
        locality.setText(eventsLocationList.getEventsLocation(position).getLocality());
        startDay.setText(eventsDatesList.getEventsDates(position).getStarting_day());
        endDay.setText(eventsDatesList.getEventsDates(position).getEnding_day());

    }
}
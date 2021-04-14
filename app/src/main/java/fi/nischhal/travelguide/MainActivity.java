package fi.nischhal.travelguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import fi.nischhal.travelguide.events.EventsDates;
import fi.nischhal.travelguide.events.EventsDatesList;
import fi.nischhal.travelguide.events.EventsDescription;
import fi.nischhal.travelguide.events.EventsDescriptionList;
import fi.nischhal.travelguide.events.EventsLocation;
import fi.nischhal.travelguide.events.EventsLocationList;
import fi.nischhal.travelguide.events.EventsName;
import fi.nischhal.travelguide.events.EventsNameList;
import fi.nischhal.travelguide.events.EventsTags;

public class MainActivity extends AppCompatActivity {
    private EventsName nameObj;
    private EventsLocation address;
    private EventsDescription description;
    private EventsDates eventDates;
    private EventsTags eventsTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getEvents();
    }

    public void getEvents(){
        String getJson = null;
        Gson gson = new Gson();
        EventsNameList eventsList = EventsNameList.getEventsInstance();
        EventsDescriptionList descriptionList = EventsDescriptionList.getEventsDescriptionInstance();
        EventsLocationList eventslocationList = EventsLocationList.getEventsLocationInstance();
        EventsDatesList eventsDatesList = EventsDatesList.getEventsDatesInstance();

        ListView lv = findViewById(R.id.listView);
        try{
            InputStream file = getAssets().open("events.json");
            int size = file.available();
            byte[] buffer = new byte[size];
            file.read(buffer);
            file.close();

            getJson = new String(buffer,"UTF-8");
            JSONObject events = new JSONObject(getJson);
            JSONArray arrayOfData = events.getJSONArray("data");

            for(int i = 0; i < arrayOfData.length(); i++){
                JSONObject getData = arrayOfData.getJSONObject(i);
                //getting access to the name object in events.json file
                String id = getData.getString("id");
                JSONObject nameData = getData.getJSONObject("name");
                //String nameEn = nameData.getString("en");
                //getting access to location object in events.json file
                JSONObject locationData = getData.getJSONObject("location");
                //getting access to address object from location object in events.json file
                JSONObject addressData = locationData.getJSONObject("address");
                //events url info
                String eventsUrl = getData.getString("info_url");
                //getting access to description object from location object in events.json file
                JSONObject eventDescription = getData.getJSONObject("description");
                //String des = eventDescription.getString("intro");
                //fetching array of tags from data
                JSONArray arrayOfEventsTags = getData.getJSONArray("tags");
                for(int j = 0; j <arrayOfEventsTags.length(); j++){
                    JSONObject getEventsObj = arrayOfEventsTags.getJSONObject(j);
                    eventsTags = gson.fromJson(String.valueOf(getEventsObj),EventsTags.class);
                    //txt.append(eventsTags.getName()+"\n");
                }

                //getting access to event dates object in events.json file
                JSONObject eventDate = getData.getJSONObject("event_dates");

                //changing values of Object to class
                nameObj = gson.fromJson(String.valueOf(nameData),EventsName.class);
                address = gson.fromJson(String.valueOf(addressData),EventsLocation.class);
                description = gson.fromJson(String.valueOf(eventDescription),EventsDescription.class);
                eventDates = gson.fromJson(String.valueOf(eventDate),EventsDates.class);
                //eventsTags = gson.fromJson(String.valueOf(eventsTagObj), (Type) EventsTags.class);

                //txt.append("from Json"+ nameObj.getEn()+"\n");
                //txt.append(address.getLocality()+"\n");
                //txt.append(address.getPostal_code()+"\n");
                //txt.append(address.getStreet_address()+"\n");
                //txt.append(eventsUrl+"\n");
                //txt.append(description.getIntro()+"\n");
                //txt.append(description.getBody()+"\n\n");
                //txt.append(eventDates.getEnding_day()+"\n");
                //txt.append(eventDates.getStarting_day()+"\n");
                eventsList.addEventsName(nameObj);
                descriptionList.addEventsIntro(description);
                eventslocationList.addEventsLocation(address);
                eventsDatesList.addEventsDates(eventDates);
            }
            lv.setAdapter(new ArrayAdapter<EventsName>(
                    this,
                    android.R.layout.simple_expandable_list_item_1,
                    eventsList.getAllEventsName()
            ));

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this,Intro_Activity.class);
                    intent.putExtra("intro",position);
                    startActivity(intent);
                }
            });

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
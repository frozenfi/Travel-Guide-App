package fi.nischhal.travelguide.events;

import java.util.ArrayList;
import java.util.List;

public class EventsLocationList {
    private static final EventsLocationList eventsLocationInstance = new EventsLocationList();
    private List<EventsLocation> eventsLocationList;

    public static EventsLocationList getEventsLocationInstance(){
        return  eventsLocationInstance;
    }

    private EventsLocationList(){
        this.eventsLocationList = new ArrayList<>();
    }

    public void addEventsLocation(EventsLocation location){
        this.eventsLocationList.add(location);
    }

    public EventsLocation getEventsLocation(int position){
        return this.eventsLocationList.get(position);
    }
    public List<EventsLocation> getAllEventsLocation(){
        return this.eventsLocationList;
    }
}

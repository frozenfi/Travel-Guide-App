package fi.nischhal.travelguide.events;

import java.util.ArrayList;
import java.util.List;

public class EventsNameList {
    private static final EventsNameList eventsListInstance = new EventsNameList();
    private List<EventsName> eventsNameList;

    public static EventsNameList getEventsInstance(){
        return  eventsListInstance;
    }

    private EventsNameList(){
        this.eventsNameList = new ArrayList<>();
    }

    public void addEventsName(EventsName eventName){
        this.eventsNameList.add(eventName);
    }

    public List<EventsName> getAllEventsName(){
        return this.eventsNameList;
    }
}

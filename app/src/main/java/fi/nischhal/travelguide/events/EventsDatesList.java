package fi.nischhal.travelguide.events;

import java.util.ArrayList;
import java.util.List;

public class EventsDatesList {
    private static final EventsDatesList eventsDatesInstance = new EventsDatesList();
    private List<EventsDates> eventsDatesList;

    public static EventsDatesList getEventsDatesInstance(){
        return  eventsDatesInstance;
    }

    private EventsDatesList(){
        this.eventsDatesList = new ArrayList<>();
    }

    public void addEventsDates(EventsDates dates){
        this.eventsDatesList.add(dates);
    }

    public EventsDates getEventsDates(int position){
        return this.eventsDatesList.get(position);
    }
    public List<EventsDates> getAllEventsDates(){
        return this.eventsDatesList;
    }
}

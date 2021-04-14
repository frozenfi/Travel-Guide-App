package fi.nischhal.travelguide.events;

import java.util.ArrayList;
import java.util.List;

public class EventsDescriptionList {
    private static final EventsDescriptionList eventsDescriptionInstance = new EventsDescriptionList();
    private List<EventsDescription> eventsDescriptionList;

    public static EventsDescriptionList getEventsDescriptionInstance(){
        return eventsDescriptionInstance;
    }

    private EventsDescriptionList(){
        this.eventsDescriptionList = new ArrayList<>();
    }

    public void addEventsIntro(EventsDescription intro){
        this.eventsDescriptionList.add(intro);
    }

    public EventsDescription getDescription(int position){
        return this.eventsDescriptionList.get(position);
    }

    public List<EventsDescription> getAllDescription(){
        return this.eventsDescriptionList;
    }
}

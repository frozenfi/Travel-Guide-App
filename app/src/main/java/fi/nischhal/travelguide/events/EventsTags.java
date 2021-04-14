package fi.nischhal.travelguide.events;

public class EventsTags {
    private String name;
    private String id;

    public EventsTags(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}

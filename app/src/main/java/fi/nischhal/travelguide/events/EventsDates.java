package fi.nischhal.travelguide.events;

public class EventsDates {
    private String starting_day;
    private String ending_day;

    public String getStarting_day() {
        if(starting_day != null){
            return starting_day;
        }else{
            return "Sorry! Information not available";
        }
    }

    public String getEnding_day() {
        if(starting_day != null){
            return ending_day;
        }else{
            return "Sorry! Information not available";
        }
    }
}

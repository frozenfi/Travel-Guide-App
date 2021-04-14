package fi.nischhal.travelguide.events;

import com.google.gson.annotations.SerializedName;

public class EventsName {
    private String en;
    private String fi;
    private String nz;
    //"EurLex-2 en"
    @SerializedName("EurLex-2 en")
    private String enz;

    public EventsName(String en, String fi, String nz, String enz) {
        this.en = en;
        this.fi = fi;
        this.nz = nz;
        this.enz = enz;
    }

    public String getEn() {
        return en;
    }

    public String getFi() {
        return fi;
    }

    public String getNz() {
        return nz;
    }

    public String getEnz() {
        return enz;
    }

    @Override
    public String toString() {
        if(this.en != null){
            return this.en;
        }else{
            return "Content not available";
        }
    }
}

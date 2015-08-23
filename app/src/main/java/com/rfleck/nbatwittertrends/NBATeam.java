package com.rfleck.nbatwittertrends;

import android.os.Parcel;
import android.os.Parcelable;

public class NBATeam implements Parcelable {
    private String teamCity;
    private String teamName;
    private int teamLogo;

    public String getTeamCity() {
        return this.teamCity;
    }

    public void setTeamCity(String city) {
        this.teamCity = city;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public int getTeamLogo() {
        return this.teamLogo;
    }

    public void setTeamLogo(int logo) {
        this.teamLogo = logo;
    }

    public NBATeam(String city, String name, int logo) {
        this.teamCity = city;
        this.teamName = name;
        this.teamLogo = logo;
    }

    public NBATeam(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        teamCity = in.readString();
        teamName = in.readString();
        teamLogo = in.readInt();
    }

    public static final Parcelable.Creator<NBATeam> CREATOR
            = new Parcelable.Creator<NBATeam>() {
        public NBATeam createFromParcel(Parcel in) {
            return new NBATeam(in);
        }

        public NBATeam[] newArray(int size) {
            return new NBATeam[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamCity);
        dest.writeString(teamName);
        dest.writeInt(teamLogo);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

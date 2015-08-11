package com.rfleck.nbatwittertrends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rfleck on 8/4/2015.
 */
public class NBATeam{
    private String teamCity;
    private String teamName;
    private int teamLogo;

    public NBATeam(String city, String name, int logo){
        this.teamCity = city;
        this.teamName = name;
        this.teamLogo = logo;
    }

    public String getTeamCity(){
        return this.teamCity;
    }

    public void setTeamCity(String city){
        this.teamCity  = city;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public void setTeamName(String name){
        this.teamName = name;
    }

    public int getTeamLogo(){
        return this.teamLogo;
    }

    public void setTeamLogo(int logo){
        this.teamLogo  = logo;
    }
}

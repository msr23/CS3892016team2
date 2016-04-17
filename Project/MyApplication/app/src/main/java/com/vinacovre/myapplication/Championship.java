package com.vinacovre.myapplication;
import java.util.ArrayList;
/**
 * Created by Christian on 4/16/16.
 */
public class Championship {
   // int ChampionshipId = 0; //I wonder what the database standard practice is for ID's zzz
    private String ChampionshipName;
    private String ChampionshipCreator;
    /*private String ChampionshipLocation;

    private String ChampionshipDate;
    private String ChampionshipTime;
    private String ChampionshipType;
    // int x = 0;
    //String[] ChampionshipPlayers = new String[10]; //I know for sure that you cannot create an
    //Array like this and have the size be updated by a variable, but its okay I will change it to type
    //ArrayList when I am done doing what I need to do, I also wont even be using this in the database anyway
    //Its ok for this field to always be blank!!

    ArrayList<Player> players = new ArrayList();*/

    public Championship()
    {
        //blank
    }

    public Championship(String n, String c)
    {
        this.ChampionshipName = n;
        this.ChampionshipCreator = c;
    }


  /*  public int getChampionshipId()
    {
        return ChampionshipId;
    } */

    public String getChampionshipName()
    {
        return ChampionshipName;
    }

 /*  public String getChampionshipLocation()
    {
        return ChampionshipLocation;
    }*/


    public String getChampionshipCreator() {
        return ChampionshipCreator;
    }



   /* public String getChampionshipDate()
    {
        return ChampionshipDate;
    }

    public String getChampionshipTime()
    {
        return ChampionshipTime;
    }

    public String getChampionshipType()
    {
        return ChampionshipType;
    }
    public String getPlayer()
    {
        return getPlayerName() + " " + getPlayerID();
    }
    public String getPlayerName()
    {
        for (int i = 0; i < players.size(); i++)
            return players.get(i).getPlayerName();
        return players.get(players.size()).getPlayerName();
    }

    public int getPlayerID()
    {
        for (int i = 0; i <= players.size(); i ++)
            return players.get(i).getPlayerId();
        return players.get(players.size()).getPlayerId();
    }

    public void setChampionshipId(int i)
    {
        ChampionshipId = i;
    } */

    public void setChampionshipName(String n)
    {
        ChampionshipName = n;
    }

  /*  public void setChampionshipLocation(String l)
    {
        ChampionshipLocation = l;
    } */

    public void setChampionshipCreator(String c){ChampionshipCreator = c;}

 /*   public void setChampionshipDate(String d)
    {
        ChampionshipDate = d;
    }

    public void setChampionshipTime(String t)
    {
        ChampionshipTime = t;
    }

    public void setChampionshipType(String T)
    {
        ChampionshipType = T;
    }

    public void setPlayer(Player p)
    {
        players.add(players.size() + 1, p);
    } */
}

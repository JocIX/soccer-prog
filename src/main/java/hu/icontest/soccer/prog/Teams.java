package hu.icontest.soccer.prog;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author developer
 */
public class Teams {

    private String name;
    private String nationality;
    private double strength;
    private double squadValue;
    private Coaches coach;
    private Owners owner;

    

    public Teams(String name, String nationality, double strength, double squadValue, Owners owner, Coaches coach) {
        this.name = name;
        this.nationality = nationality;
        this.strength = strength;
        this.squadValue = squadValue;
        this.owner = owner;
        this.coach = coach;
    }

    public Teams(String name, String nationality, double strength, double squadValue) {
        this.name = name;
        this.nationality = nationality;
        this.strength = strength;
        this.squadValue = squadValue;
    }

    public Teams() {
    }

    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSquadValue() {
        return squadValue;
    }

    public void setSquadValue(double squadValue) {
        this.squadValue = squadValue;
    }

    public Owners getOwner() {
        return owner;
    }

    public void setOwner(Owners tulaj) {
        owner = tulaj;
    }

    private List<Players> keret = new ArrayList<Players>();

    public List<Players> getKeret() {
        return keret;
    }

    public void addJatekos(Players jatekos) {
        keret.add(jatekos);
    }

    
    public Coaches getCoach() {
        return coach;
    }

    public void setCoach(Coaches coach) {
        this.coach = coach;
    }
    
    @Override  //ez azért kell, mert a println a toStringet használja, és a default toStringgel (a DB-ben definiált függvény) számunkra "értelmetlen"/értelmezhetetlen karaktresorozatot ad vissza.
    public String toString() {
        return this.name;
    }
}

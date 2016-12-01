package hu.icontest.soccer.prog.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author developer
 */
@Entity(name = "teams")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String nationality;
    private double strength;
    private double squadValue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Team() {
    }

    public Team(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double s) {
        strength = s;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nat) {
        nationality = nat;
    }

    public double getSquadValue() {
        return squadValue;
    }

    public void setSquadValue(double sv) {
        squadValue = sv;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner ow) {
        owner = ow;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach c) {
        coach = c;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}

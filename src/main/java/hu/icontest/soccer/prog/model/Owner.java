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
@Entity(name = "owners")

public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private double netWorth;
    private double competence;
    private double control;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team currentTeam;

    public Owner() {
    }

    public Owner(long id) {
        this.id = id;
    }

    public Owner(String firstName, String lastName, String nationality, double netWorth, double competence, double control) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.netWorth = netWorth;
        this.competence = competence;
        this.control = control;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        lastName = ln;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nat) {
        nationality = nat;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double nw) {
        netWorth = nw;
    }

    public double getCompetence() {
        return competence;
    }

    public void setCompetence(double comp) {
        competence = comp;
    }

    public double getControl() {
        return control;
    }

    public void setControl(double c) {
        control = c;
    }

    public Team getTeam() {
        return currentTeam;
    }

    public void setTeam(Team t) {
        currentTeam = t;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Owner other = (Owner) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}

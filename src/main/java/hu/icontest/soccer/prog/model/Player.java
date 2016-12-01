package hu.icontest.soccer.prog.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author developer
 * @since Nov 25, 2016
 */
@Entity(name = "players")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private String position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_ID")
    private Team currentTeam;
    private double currentSalary;
    private double fitness;
    private double skills;
    private double value;

    public Player() {
    }

    public Player(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nat) {
        nationality = nat;
    }

    public Team getTeam() {
        return currentTeam;
    }

    public void setTeam(Team t) {
        currentTeam = t;
    }

    public double getSalary() {
        return currentSalary;
    }

    public void setSalary(double sal) {
        currentSalary = sal;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        position = pos;
    }

    public double getSkills() {
        return skills;
    }

    public void setSkills(double skills) {
        this.skills = skills;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dto;

import hu.icontest.soccer.prog.model.Team;
import java.io.Serializable;

/**
 *
 * @author developer
 *
 * data transfer object - ebben küldjük az objectet a server felé, a service
 * rétegnek
 */
public class TeamDto implements Serializable {

    private String name;
    private String nationality;
    private double strength;
    private double squadValue;

    public TeamDto() {
    }

    public TeamDto(String name, String nationality, double strength, double squadValue) {
        this.name = name;
        this.nationality = nationality;
        this.strength = strength;
        this.squadValue = squadValue;
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

    public static TeamDto fromTeam(Team team) {
        return new TeamDto(team.getName(), team.getNationality(), team.getStrength(), team.getSquadValue());
    }

    public static Team toTeam(TeamDto teamDto) {
        return new Team(null, teamDto.getName(), teamDto.getNationality(), teamDto.getStrength(), teamDto.getSquadValue(), null, null);  
    }

}

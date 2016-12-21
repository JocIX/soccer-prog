/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dto;

import hu.icontest.soccer.prog.model.Player;
import java.io.Serializable;

/**
 *
 * @author developer
 */
public class PlayerDto implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private String position;
    private double currentSalary;
    private double fitness;
    private double skills;
    private double value;

public PlayerDto(){}

    public PlayerDto(String firstName, String lastName, int age, String nationality, String position, double currentSalary, double fitness, double skills, double value) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.currentSalary = currentSalary;
        this.fitness = fitness;
        this.skills = skills;
        this.value = value;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
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

public static PlayerDto fromPlayer(Player player){
return new PlayerDto(player.getFirstName(), player.getLastName(), player.getAge(), player.getNationality(), player.getPosition(), player.getCurrentSalary(), player.getFitness(), player.getSkills(), player.getValue());
}
  
public static Player toPlayer(PlayerDto playerDto){
return new Player(playerDto.getFirstName(), playerDto.getLastName(), playerDto.getAge(), playerDto.getNationality(), playerDto.getPosition(), playerDto.getCurrentSalary(), playerDto.getFitness(), playerDto.getSkills(), playerDto.getValue());
}

}

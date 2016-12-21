/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dto;

import hu.icontest.soccer.prog.model.Coach;
import java.io.Serializable;

/**
 *
 * @author developer
 */
public class CoachDto implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private int experience;
    private String nationality;
    private String accomplishment;
    private double salary;

    public CoachDto() {
    }

    public CoachDto(String firstName, String lastName, int age, String nationality, int experience, String accomplishment, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.experience = experience;
        this.accomplishment = accomplishment;
        this.salary = salary;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(String accomplishment) {
        this.accomplishment = accomplishment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static CoachDto fromCoach(Coach coach) {
        return new CoachDto(coach.getFirstName(), coach.getLastName(), coach.getAge(), coach.getNationality(), coach.getExperience(), coach.getAccomplishment(), coach.getSalary());
    }

//    public static Team toTeam(TeamDto teamDto) {
//        return new Team(null, teamDto.getName(), teamDto.getNationality(), teamDto.getStrength(), teamDto.getSquadValue(), null, null);
//    }
public static Coach toCoach(CoachDto coachDto) {
        return new Coach(coachDto.getFirstName(), coachDto.getLastName(), coachDto.getAge(), coachDto.getNationality(), coachDto.getExperience(), coachDto.getAccomplishment(), coachDto.getSalary());

}
}

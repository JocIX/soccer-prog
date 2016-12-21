/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.dto;

import hu.icontest.soccer.prog.model.Owner;

/**
 *
 * @author developer
 */
public class OwnerDto {

    private String firstName;
    private String lastName;
    private String nationality;
    private double netWorth;
    private double competence;
    private double control;

    public OwnerDto() {
    }

    public OwnerDto(String firstName, String lastName, String nationality, double netWorth, double competence, double control) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.netWorth = netWorth;
        this.competence = competence;
        this.control = control;
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

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public double getCompetence() {
        return competence;
    }

    public void setCompetence(double competence) {
        this.competence = competence;
    }

    public double getControl() {
        return control;
    }

    public void setControl(double control) {
        this.control = control;
    }

    public static OwnerDto fromOwner(Owner owner) {
        return new OwnerDto(owner.getFirstName(), owner.getLastName(), owner.getNationality(), owner.getNetWorth(), owner.getCompetence(), owner.getControl());
    }

    public static Owner toOwner(OwnerDto ownerDto) {
        return new Owner(ownerDto.getFirstName(), ownerDto.getLastName(), ownerDto.getNationality(), ownerDto.getNetWorth(), ownerDto.getCompetence(), ownerDto.getControl());

    }

}

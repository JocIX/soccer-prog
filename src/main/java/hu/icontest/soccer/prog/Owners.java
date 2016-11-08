package hu.icontest.soccer.prog;

/**
 *
 * @author developer
 */
public class Owners extends Person {

    //private String first_name;
    //private String last_name;
    private double net_worth;
    private double competence;
    private double control;
    private Teams current_team;

    public Owners(String first_name, String last_name, double net_worth, double competence, double control, Teams current_team) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.net_worth = net_worth;
        this.competence = competence;
        this.control = control;
        this.current_team = current_team;
    }

    public Owners(String first_name, String last_name, int age, double net_worth, double competence, double control) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.net_worth = net_worth;
        this.competence = competence;
        this.control = control;
    }

    public Owners() {

    }

    /*public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
     */
    public double getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(double net_worth) {
        this.net_worth = net_worth;
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

    public Teams getCurrent_team() {
        return current_team;
    }

    public void setCurrent_team(Teams current_team) {
        this.current_team = current_team;
    }

    public String toString() {
        return first_name + " " + last_name;
    }

}

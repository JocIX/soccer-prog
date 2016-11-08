package hu.icontest.soccer.prog;

/**
 *
 * @author developer
 */
public class Coaches extends Person {

    //private String first_name;
    //private String last_name;
    //private int age;
    private int experience;
    private String accomplishment;
    private Teams current_team = new Teams();
    private double salary;

    public Coaches(String first_name, String last_name, int age, int experience, String accomplishment, double salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.experience = experience;
        this.accomplishment = accomplishment;
        this.salary = salary;
    }

    public Coaches() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     */
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

    public Teams getCurrent_team() {
        return current_team;
    }

    public void setCurrent_team(Teams current_team) {
        this.current_team = current_team;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }

}

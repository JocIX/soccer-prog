package hu.icontest.soccer.prog;

/**
 *
 * @author developer
 */
public class Players extends Person {

    //private String first_name;
    //private String last_name;
    //private int age;
    private String position;
    
    private Teams current_team = new Teams();
    private double current_salary;
    private double fitness;
    private double skills;
    private double value;

    public Players(String first_name, String last_name, String position, int age, String nationality, Teams current_team, double current_salary, double fit, double skills, double value) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.age = age;
        this.nationality = nationality;
        this.current_team = current_team;
        this.current_salary = current_salary;
        this.fitness = fit;
        this.skills = skills;
        this.value = value;
    }

    public Players(String first_name, String last_name, String position, int age, String nationality, double current_salary, double fit, double skills, double value) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.age = age;
        this.nationality = nationality;
        //this.current_team = current_team;
        this.current_salary = current_salary;
        this.fitness = fit;
        this.skills = skills;
        this.value = value;
    }

    public Players() {
    }

    /*
    public String getFirst_name() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Teams getCurrent_team() {
        return current_team;
    }

    public void setCurrent_team(Teams current_team) {
        this.current_team = current_team;
    }

    public double getCurrent_salary() {
        return current_salary;
    }

    public void setCurrent_salary(double current_salary) {
        this.current_salary = current_salary;
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

    /*@Override 
    public String toString() { 
    return this.getCurrent_team().getName() ;


}
*/

    @Override
    public String toString() {
        return  "lastname=" + last_name + "," + "position=" + position + ", current team=" + current_team + ", current salary=" + current_salary + ", fitness=" + fitness + ", skills=" + skills + ", value=" + value + '}';
 
    
    }
    
    }

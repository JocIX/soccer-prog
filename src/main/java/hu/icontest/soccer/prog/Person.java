
package hu.icontest.soccer.prog;

/**
 *
 * @author developer
 */
public class Person {

    protected String first_name;
    protected String last_name;
    protected int age;
    protected String nationality;
    public Person(String first_name, String last_name, int age, String nationality) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.nationality = nationality;
    }

    
    public Person(){
    
    }

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }



}

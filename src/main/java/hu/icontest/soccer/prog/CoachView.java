/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import hu.icontest.soccer.prog.dao.CoachDao;
import hu.icontest.soccer.prog.model.Coach;
import hu.icontest.soccer.prog.model.Team;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author developer
 */
public class CoachView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "CoachView";
    private TextField firstName;
    private TextField lastName;
    private TextField age;
    private TextField nationality;
    private TextField experience;
    private TextField accomplishment;
    private TextField currentTeam;
    private TextField salary;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //addComponent(new Label("Hello, PLayer!"));

        Button button1 = new Button("List coaches");
        button1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                /*try {
                    List<Coaches> edzolista = DB.readCoach();

                    for (Coaches edzo : edzolista) {
                        addComponent(new Label(edzo.toString()));
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                 */
                final Table table = new Table("Coaches");
                //table.addContainerProperty("ID", Long.class, null);
                table.addContainerProperty("Firstname", String.class, null);
                table.addContainerProperty("Lastname", String.class, null);
                table.addContainerProperty("Age", Integer.class, null);
                table.addContainerProperty("Nationality", String.class, null);
                table.addContainerProperty("Experience", Integer.class, null);
                table.addContainerProperty("Accomplishment", String.class, null);
                table.addContainerProperty("Current team", String.class, null);
                table.addContainerProperty("Salary", Double.class, null);

                List<Coach> edzok = null;
                edzok = CoachDao.readCoach();

                for (int i = 0; i < edzok.size(); ++i) {   
                    List<Object> temp = new ArrayList();
                   // temp.add(edzok.get(i).getId());
                    temp.add(edzok.get(i).getFirstName());
                    temp.add(edzok.get(i).getLastName());
                    temp.add(edzok.get(i).getAge());
                    temp.add(edzok.get(i).getNationality());
                    temp.add(edzok.get(i).getExperience());                   
                    temp.add(edzok.get(i).getAccomplishment());
                    temp.add(edzok.get(i).getTeam().getName());
                    temp.add(edzok.get(i).getSalary());
                    table.addItem(temp.toArray(new Object[temp.size()]), i + 1);
                }
                table.setPageLength(table.size());
                addComponent(table);
            }
        });
        addComponent(button1);
      
        firstName = new TextField("Firstname");
        lastName = new TextField("Lastname");
        age = new TextField("Age");
        nationality = new TextField("Nationality");
        experience = new TextField("Experience");
        currentTeam = new TextField("Current team");
        accomplishment = new TextField("Accomplishment");
        salary = new TextField("Salary");

        HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();
        HorizontalLayout horizontal2 = new HorizontalLayout();
        horizontal.addComponent(firstName);
        horizontal.addComponent(lastName);
        horizontal.addComponent(age);
        horizontal2.addComponent(nationality);
        horizontal2.addComponent(experience);
        horizontal2.addComponent(currentTeam);
        horizontal2.addComponent(accomplishment);
        horizontal2.addComponent(salary);

        addComponent(horizontal);
        addComponent(horizontal2);
        addComponent(vertical);

        Button button = new Button("Add new coach");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                Coach edzo = new Coach();
                edzo.setFirstName(firstName.getValue());
                edzo.setLastName(lastName.getValue());
                edzo.setAge(Integer.parseInt(age.getValue()));
                edzo.setNationality(nationality.getValue());
                edzo.setExperience(Integer.parseInt(experience.getValue()));
                //Team team = new Team();
               // team.setName(currentTeam.getValue());
                //edzo.setTeam(team);
                edzo.setAccomplishment(accomplishment.getValue());
                edzo.setSalary(Double.parseDouble(salary.getValue()));

                
                    //DB.insertCoach(edzo);
                    CoachDao.addCoach(edzo, currentTeam.getValue());
                    
                
            }
        });
        addComponent(button);

        Button button2 = new Button("Delete coach");
        button2.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                Coach edzo = new Coach();
                // jatekos.setFirst_name(firstName.getValue());
                edzo.setLastName(lastName.getValue());

                CoachDao.removeCoach(edzo);
            }
        });
        addComponent(button2);

        Button button3 = new Button("Clear");
        button3.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                firstName.setValue("");
                lastName.setValue("");
                age.setValue("");
                nationality.setValue("");
                experience.setValue("");
                currentTeam.setValue("");
                accomplishment.setValue("");
                salary.setValue("");

                Coaches edzo = new Coaches();
                edzo.setFirst_name(firstName.getValue());
                edzo.setLast_name(lastName.getValue());
                edzo.setAge(Integer.parseInt(age.getValue()));
                edzo.setNationality(nationality.getValue());
                edzo.setExperience(Integer.parseInt(experience.getValue()));
                Teams team = new Teams();
                team.setName(currentTeam.getValue());
                edzo.setCurrent_team(team);
                edzo.setAccomplishment(accomplishment.getValue());
                edzo.setSalary(Double.parseDouble(salary.getValue()));

            }
        });
        addComponent(button3);

        Link link = new Link("Home",
                new ExternalResource("http://localhost:8080/soccer-prog/"));
        addComponent(link);
    }

}

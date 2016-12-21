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
import hu.icontest.soccer.prog.dao.PlayerDao;
import hu.icontest.soccer.prog.model.Player;
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
public class PlayerView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "PlayerView";
    private TextField firstName;
    private TextField lastName;
    private TextField age;
    private TextField nationality;
    private TextField position;
    private TextField currentTeam;

    private TextField currSal;
    private TextField fitness;
    private TextField skills;
    private TextField value;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //addComponent(new Label("Hello, PLayer!"));

        Button button1 = new Button("List players");
        button1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                /* try {
                    List<Players> jatekoslista = DB.readPlayer();

                    for (Players player : jatekoslista) {
                        addComponent(new Label(player.toString()));
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                } */
                final Table table = new Table("Players");

                table.addContainerProperty("Firstname", String.class, null);
                table.addContainerProperty("Lastname", String.class, null);
                table.addContainerProperty("Age", Integer.class, null);
                table.addContainerProperty("Nationality", String.class, null);
                table.addContainerProperty("Position", String.class, null);
                table.addContainerProperty("Salary", Double.class, null);
                table.addContainerProperty("Current team", String.class, null);
                table.addContainerProperty("Fitness", Double.class, null);
                table.addContainerProperty("Skills", Double.class, null);
                table.addContainerProperty("Value", Double.class, null);

                List<Player> players = null;
                players = PlayerDao.readPlayers();
                for (int i = 0; i < players.size(); ++i) {   // 
                    List<Object> temp = new ArrayList();
                    temp.add(players.get(i).getFirstName());
                    temp.add(players.get(i).getLastName());
                    temp.add(players.get(i).getAge());
                    temp.add(players.get(i).getNationality());
                    temp.add(players.get(i).getPosition());
                    temp.add(players.get(i).getCurrentSalary());
                    //temp.add(players.get(i).getCurrentTeam().getName());
                    temp.add("");
                    temp.add(players.get(i).getFitness());
                    temp.add(players.get(i).getSkills());
                    temp.add(players.get(i).getValue());
                    
                    // Object ide[] = new Object[temp.size()];
                    table.addItem(temp.toArray(new Object[temp.size()]), i + 1);
                }
                table.setPageLength(table.size());
                addComponent(table);
            }
        });

        addComponent(button1);

        /*
        table.addContainerProperty("Firstname", String.class, null);
        table.addContainerProperty("Lastname", String.class, null);
        table.addContainerProperty("Age", Integer.class, null);
        table.addContainerProperty("Nationality", String.class, null);
        table.addContainerProperty("Position", String.class, null);
        table.addContainerProperty("Salary", Double.class, null);

        table.addContainerProperty("Fitness", Double.class, null);
        table.addContainerProperty("Skills", Double.class, null);
        table.addContainerProperty("Value", Double.class, null);

        List<Players> jatekosok = null;
        try {
            jatekosok = DB.readPlayer();
        } catch (ClassNotFoundException | SQLException e) {
            // empty block
        }
        for (int i = 0; i < jatekosok.size(); ++i) {   // 
            List<Object> temp = new ArrayList();
            temp.add(jatekosok.get(i).first_name);
            temp.add(jatekosok.get(i).last_name);
            temp.add(jatekosok.get(i).age);
            temp.add(jatekosok.get(i).nationality);
            temp.add(jatekosok.get(i).getPosition());
            temp.add(jatekosok.get(i).getCurrent_salary());
            temp.add(jatekosok.get(i).getFitness());
            temp.add(jatekosok.get(i).getSkills());
            temp.add(jatekosok.get(i).getValue());

            // Object ide[] = new Object[temp.size()];
            table.addItem(temp.toArray(new Object[temp.size()]), i + 1);
        }

        table.setPageLength(table.size());
        addComponent(table);
         */
        firstName = new TextField("Firstname");
        lastName = new TextField("Lastname");
        age = new TextField("Age");
        nationality = new TextField("Nationality");
        position = new TextField("Position");
        currentTeam = new TextField("Current team");
        currSal = new TextField("Current salary");
        fitness = new TextField("Fitness");
        skills = new TextField("Skills");
        value = new TextField("Value");

        HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();
        HorizontalLayout horizontal2 = new HorizontalLayout();
        horizontal.addComponent(firstName);
        horizontal.addComponent(lastName);
        horizontal.addComponent(age);
        horizontal.addComponent(nationality);
        horizontal.addComponent(position);
        horizontal2.addComponent(currentTeam);
        //horizontal2.addComponent(new TextField("Current team"));
        horizontal2.addComponent(currSal);
        horizontal2.addComponent(fitness);
        horizontal2.addComponent(skills);
        horizontal2.addComponent(value);

        addComponent(horizontal);
        addComponent(horizontal2);
        addComponent(vertical);

        Button button = new Button("Add new player");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                Player jatekos = new Player();
                /* jatekos.setFirst_name(firstName.getValue());
                jatekos.setLast_name(lastName.getValue());
                jatekos.setAge(Integer.parseInt(age.getValue()));
                jatekos.setNationality(nationality.getValue());
                jatekos.setPosition(position.getValue());
                Teams team = new Teams();
                team.setName(currentTeam.getValue());
                jatekos.setCurrent_team(team);
                jatekos.setCurrent_salary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue())); */
                jatekos.setLastName(lastName.getValue());
                jatekos.setFirstName(firstName.getValue());
                jatekos.setAge(Integer.parseInt(age.getValue()));
                jatekos.setNationality(nationality.getValue());
                jatekos.setPosition(position.getValue());
                jatekos.setCurrentSalary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue()));

                // DB.insertPlayer(jatekos);
                PlayerDao.addPlayer(jatekos, currentTeam.getValue());

            }
        });
        addComponent(button);

        Button button2 = new Button("Delete player");
        button2.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                Player jatekos = new Player();
                // jatekos.setFirst_name(firstName.getValue());
                jatekos.setLastName(lastName.getValue());

                PlayerDao.removePlayer(jatekos);
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
                position.setValue("");
                currentTeam.setValue("");
                currSal.setValue("");
                fitness.setValue("");
                skills.setValue("");
                value.setValue("");

                Players jatekos = new Players();
                jatekos.setFirst_name(firstName.getValue());
                jatekos.setLast_name(lastName.getValue());
                jatekos.setAge(Integer.parseInt(age.getValue()));
                jatekos.setNationality(nationality.getValue());
                jatekos.setPosition(position.getValue());
                Teams team = new Teams();
                team.setName(currentTeam.getValue());
                jatekos.setCurrent_team(team);
                jatekos.setCurrent_salary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue()));
            }
        });
        addComponent(button3);

        Link link = new Link("Home",
                new ExternalResource("http://localhost:8080/soccer-prog/"));
        addComponent(link);
    }

}

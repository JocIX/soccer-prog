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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author developer
 */
public class TeamView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "TeamView";
    private TextField name;
    private TextField nationality;
    private TextField strength;
    private TextField squadValue;
    private TextField coach;
    private TextField owner;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Button button1 = new Button("List teams");
        button1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                /* try {
                    List<Teams> csapatlista = DB.readTeam();

                    for (Teams team : csapatlista) {
                        addComponent(new Label(team.toString()));
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                 */
                final Table table = new Table("Teams");

                table.addContainerProperty("Name", String.class, null);
                table.addContainerProperty("Nationality", String.class, null);
                table.addContainerProperty("Strength", Double.class, null);
                table.addContainerProperty("Value of squad", Double.class, null);
                table.addContainerProperty("Owner", String.class, null);
                table.addContainerProperty("Coach", String.class, null);
                
                List<Teams> csapatok = null;
                try {
                    csapatok = DB.readTeam();
                } catch (ClassNotFoundException | SQLException e) {
                    // empty block
                    e.printStackTrace(); //Sose hagyd üresen a catch részt!!!
                }
                for (int i = 0; i < csapatok.size(); ++i) {   // 
                    List<Object> temp = new ArrayList();
                    temp.add(csapatok.get(i).getName());
                    temp.add(csapatok.get(i).getNationality());
                    temp.add(csapatok.get(i).getStrength());
                    temp.add(csapatok.get(i).getSquadValue());
                    temp.add(csapatok.get(i).getOwner().toString());
                    temp.add(csapatok.get(i).getCoach().forName());
                    table.addItem(temp.toArray(new Object[temp.size()]), i + 1);
                }
                table.setPageLength(table.size());
                addComponent(table);
            }
        });
        addComponent(button1);

        name = new TextField("Name");
        nationality = new TextField("Nationality");
        strength = new TextField("Strength");
        squadValue = new TextField("Value of squad");
        owner = new TextField("Owner");
        coach = new TextField("Coach");

        HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();
        HorizontalLayout horizontal2 = new HorizontalLayout();
        horizontal.addComponent(name);
        horizontal.addComponent(nationality);
        horizontal.addComponent(strength);
        horizontal2.addComponent(squadValue);
        horizontal2.addComponent(owner);
        horizontal2.addComponent(coach);

        addComponent(horizontal);
        addComponent(horizontal2);
        addComponent(vertical);

        Button button = new Button("Add new team");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                Teams csapat = new Teams();
                csapat.setName(name.getValue());
                csapat.setNationality(nationality.getValue());
                csapat.setStrength(Double.parseDouble(strength.getValue()));
                csapat.setSquadValue(Double.parseDouble(squadValue.getValue()));
                Owners tulaj = new Owners();
                String nevek[] = owner.getValue().split(" ");
                tulaj.setFirst_name(nevek[0]);
                tulaj.setLast_name(nevek[1]);
                csapat.setOwner(tulaj);

                Coaches edzo = new Coaches();
                nevek = coach.getValue().split(" ");
                edzo.setFirst_name(nevek[0]);
                edzo.setLast_name(nevek[1]);
                csapat.setCoach(edzo);

                try {
                    DB.InsertTeam(csapat);

                } catch (SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Button button3 = new Button("Clear");
        button3.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                name.setValue("");
                nationality.setValue("");
                strength.setValue("");
                squadValue.setValue("");
                owner.setValue("");
                coach.setValue("");

                Teams csapat = new Teams();
                csapat.setName(name.getValue());
                csapat.setNationality(nationality.getValue());

                Owners tulaj = new Owners();
                String nevek[] = owner.getValue().split(" ");
                tulaj.setFirst_name(nevek[0]);
                tulaj.setLast_name(nevek[1]);
                csapat.setOwner(tulaj);

                Coaches edzo = new Coaches();
                nevek = coach.getValue().split(" ");
                edzo.setFirst_name(nevek[0]);
                edzo.setLast_name(nevek[1]);
                csapat.setCoach(edzo);

            }
        });
        addComponent(button3);

        addComponent(button);
        Link link = new Link("Home",
                new ExternalResource("http://localhost:8080/soccer-prog/"));
        addComponent(link);

    }

}

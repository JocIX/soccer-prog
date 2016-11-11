package hu.icontest.soccer.prog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
@Theme("mytheme")
@Widgetset("hu.icontest.soccer.prog.MyAppWidgetset")
public class MyUI extends UI {

    private TextField firstName;
    private TextField lastName;
    private TextField age;
    private TextField nationality;
    private TextField position;
    //private TextField currentTeam;

    private TextField currSal;
    private TextField fitness;
    private TextField skills;
    private TextField value;
    // private TextField

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout(); //egymás alá kerülnek a dolgok elrendezésben a képernyőn
        layout.setMargin(true);
        setContent(layout);

        firstName = new TextField("Firstname");
        lastName = new TextField("Lastname");
        age = new TextField("Age");
        nationality = new TextField("Nationality");
        position = new TextField("Position");
        //currentTeam = new TextField("Current team");
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
        //horizontal2.addComponent(new TextField("Current team"));
        horizontal2.addComponent(currSal);
        horizontal2.addComponent(fitness);
        horizontal2.addComponent(skills);
        horizontal2.addComponent(value);

        layout.addComponent(horizontal);
        layout.addComponent(horizontal2);
        layout.addComponent(vertical);

        Button button = new Button("Add new player");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                Players jatekos = new Players();
                jatekos.setFirst_name(firstName.getValue());
                jatekos.setLast_name(lastName.getValue());
                jatekos.setAge(Integer.parseInt(age.getValue()));
                jatekos.setNationality(nationality.getValue());
                jatekos.setPosition(position.getValue());
                //jatekos.setCurrent_team();                
                jatekos.setCurrent_salary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue()));

                try {
                    DB.insertPlayer(jatekos);
                    
                    // TODO db.insert
                } catch (SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        layout.addComponent(button);
        
        
        Button button2 = new Button("Delete player");
        button2.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event)  {

                Players jatekos = new Players();
                // jatekos.setFirst_name(firstName.getValue());
                jatekos.setLast_name(lastName.getValue());
                /* jatekos.setAge(Integer.parseInt(age.getValue()));
                jatekos.setNationality(nationality.getValue());
                jatekos.setPosition(position.getValue());
                //jatekos.setCurrent_team();                
                jatekos.setCurrent_salary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue())); */

                try {
                    try {
                        DB.removePlayer(jatekos);
                        
                        // TODO db.insert
                    } catch (IOException ex) {
                        Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        layout.addComponent(button2);
        
        
        
        
        
        Button button3 = new Button("Clear");
        button3.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                firstName.setValue("");
                lastName.setValue("");
                age.setValue("");
                nationality.setValue("");
                position.setValue("");
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
                //jatekos.setCurrent_team();                
                jatekos.setCurrent_salary(Double.parseDouble(currSal.getValue()));
                jatekos.setFitness(Double.parseDouble(fitness.getValue()));
                jatekos.setSkills(Double.parseDouble(skills.getValue()));
                jatekos.setValue(Double.parseDouble(value.getValue()));
                }
        });
        layout.addComponent(button3);
        
        
        
        
        
        
        /* TextField tf = new TextField();
        tf.setValue("first name");
        
        final HorizontalLayout layout2 = new HorizontalLayout(); 
        layout2.setMargin(true);
        layout.addComponent(layout2);
        
        final HorizontalLayout layout3 = new HorizontalLayout(); 
        layout3.setMargin(true);
        layout.addComponent(layout3);
        //setContent(layout3);
        
        TextField tf2 = new TextField();
        tf2.setValue("last name");
        
        TextField tf3 = new TextField();
        tf3.setValue("age");
        
        TextField tf4 = new TextField();
        tf4.setValue("nationality");
        
        TextField tf5 = new TextField();
        tf5.setValue("position");
        
        TextField tf6 = new TextField();
        tf6.setValue("current team");
        
        TextField tf7 = new TextField();
        tf7.setValue("current salary");
        
        TextField tf8 = new TextField();
        tf8.setValue("fitness");
        
        TextField tf9 = new TextField();
        tf9.setValue("skills");
        
        TextField tf10 = new TextField();
        tf10.setValue("value");
        
        layout2.addComponent(new TextField(tf));
        layout2.addComponent(new TextField(tf2));
        layout2.addComponent(new TextField(tf3));
        layout2.addComponent(new TextField(tf4));
        layout2.addComponent(new TextField(tf5));
        layout2.addComponent(new TextField(tf6));
        layout3.addComponent(new TextField(tf7));
        layout3.addComponent(new TextField(tf8));
        layout3.addComponent(new TextField(tf9));
        layout3.addComponent(new TextField(tf10));
    
         */
 /*HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();
        HorizontalLayout horizontal2 = new HorizontalLayout();
        horizontal.addComponent(new TextField("Firstname"));
        horizontal.addComponent(new TextField("Lastname"));
        horizontal.addComponent(new TextField("Age"));
        horizontal.addComponent(new TextField("Nationality"));
        horizontal.addComponent(new TextField("Position"));
        horizontal2.addComponent(new TextField("Current team"));
        horizontal2.addComponent(new TextField("Current salary"));
        horizontal2.addComponent(new TextField("Fitness"));
        horizontal2.addComponent(new TextField("Skills"));
        horizontal2.addComponent(new TextField("Value"));
        
        layout.addComponent(horizontal);
        layout.addComponent(horizontal2);
        layout.addComponent(vertical); */
    }

    
    
    
    
    
    
    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)

    public static class MyUIServlet extends VaadinServlet {
    }
}

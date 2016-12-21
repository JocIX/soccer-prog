package hu.icontest.soccer.prog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
// @Theme("mytheme")
// @Widgetset("hu.icontest.soccer.prog.MyAppWidgetset")
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

    private static final String NAVIGABLE_CONTENT = "navigableContent";
    
    private Panel navigableContent;
    private ViewProvider viewProvider;
    
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        
        navigableContent = new Panel();
        navigableContent.setSizeUndefined();
        navigableContent.setId(NAVIGABLE_CONTENT);
        
        viewProvider = new MyViewProvider();
        Navigator navigator = new Navigator(this, navigableContent);
        navigator.addProvider(viewProvider);
        
        setContent(navigableContent);
        
 emf = Persistence.createEntityManagerFactory("soccer-prog-pu");
    }

    public static EntityManagerFactory emf;
    
    
    
    
    
    
    
   
}

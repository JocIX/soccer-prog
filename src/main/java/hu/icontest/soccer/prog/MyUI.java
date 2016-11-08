package hu.icontest.soccer.prog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
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

    @Override
    protected void init(VaadinRequest vaadinRequest) {  
        final VerticalLayout layout = new VerticalLayout(); //egymás alá kerülnek a dolgok elrendezésben a képernyőn
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event)  { // dummy
                List<Players> jatekosok = null;
                try {
                    jatekosok = DB.readPlayer();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MyUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (Players jatekos : jatekosok) {
                    layout.addComponent(new Label(jatekos.toString()));
                }

            }
        });
        layout.addComponent(button);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

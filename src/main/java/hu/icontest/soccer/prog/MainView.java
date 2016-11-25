/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnResizeEvent;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author developer
 */
public class MainView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "MainView";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("Welcome!")); //To change body of generated methods, choose Tools | Templates.

        Link link = new Link("Players",
                new ExternalResource("http://localhost:8080/soccer-prog/#!PlayerView"));
        addComponent(link);

        Link link2 = new Link("Coaches",
                new ExternalResource("http://localhost:8080/soccer-prog/#!CoachView"));
        addComponent(link2);

        Link link3 = new Link("Teams",
                new ExternalResource("http://localhost:8080/soccer-prog/#!TeamView"));
        addComponent(link3);

 /*       final Table table = new Table("The Brightest Stars");

// Define two columns for the built-in container
        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Mag", Float.class, null);

// Add a row the hard way
        Object newItemId = table.addItem();
        Item row1 = table.getItem(newItemId);
        row1.getItemProperty("Name").setValue("Sirius");
        row1.getItemProperty("Mag").setValue(-1.46f);

// Add a few other rows using shorthand addItem()
        table.addItem(new Object[]{"Canopus", -0.72f}, 2);
        table.addItem(new Object[]{"Arcturus", -0.04f}, 3);
        table.addItem(new Object[]{"Alpha Centauri", -0.01f}, 4);

// Show exactly the currently contained rows (items)
        table.setPageLength(table.size());

        addComponent(table);

        // Allow selecting items from the table.
        table.setSelectable(true);

// Send changes in selection immediately to server.
        table.setImmediate(true);

// Shows feedback from selection.
        final Label current = new Label("Selected: -");

// Handle selection change.
        table.addValueChangeListener(new Property.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                current.setValue("Selected: " + table.getValue());
            }

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
*/
/*table.addColumnResizeListener(new Table.ColumnResizeListener(){
    public void columnResize(ColumnResizeEvent event) {
        // Get the new width of the resized column
        int width = event.getCurrentWidth();

        // Get the property ID of the resized column
        String column = (String) event.getPropertyId();

        // Do something with the information
        table.setColumnFooter(column, String.valueOf(width) + "px");
*/    

};

// Must be immediate to send the resize events immediately



    }



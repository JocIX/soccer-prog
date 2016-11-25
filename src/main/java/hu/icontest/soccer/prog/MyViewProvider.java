/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;

/**
 *
 * @author developer
 */
public class MyViewProvider implements ViewProvider {

    @Override
    public String getViewName(String viewAndParameters) {
        return viewAndParameters; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public View getView(String viewName) {

        if (viewName.equals(PlayerView.VIEW_NAME)) {
            return new PlayerView();
        } else if (viewName.equals(CoachView.VIEW_NAME)) {
            return new CoachView();
        } else if (viewName.equals(TeamView.VIEW_NAME)) {
            return new TeamView();
        }

        else return new MainView();
    }

}

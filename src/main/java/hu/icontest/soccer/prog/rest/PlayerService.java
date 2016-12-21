/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.rest;

import static hu.icontest.soccer.prog.dao.CoachDao.getCoach;
import static hu.icontest.soccer.prog.dao.CoachDao.readCoach;
import static hu.icontest.soccer.prog.dao.PlayerDao.getPlayer;
import static hu.icontest.soccer.prog.dao.PlayerDao.readPlayers;
import hu.icontest.soccer.prog.dto.CoachDto;
import hu.icontest.soccer.prog.dto.PlayerDto;
import hu.icontest.soccer.prog.model.Coach;
import hu.icontest.soccer.prog.model.Player;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author developer
 */
@Path("/player-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerService {

    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private String position;
    private double currentSalary;
    private double fitness;
    private double skills;
    private double value;

    @GET
    @Path("query-all")
    public List<PlayerDto> queryAll() {

        List<Player> playerList = readPlayers();
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player : playerList) {
            PlayerDto resultDto = PlayerDto.fromPlayer(player);
            playerDtoList.add(resultDto);

            //coachDtoList.add(CoachDto.fromCoach(coach));
        }
        return playerDtoList;
    }

    @GET
    @Path("get-by-id")
    public PlayerDto queryByID(@QueryParam("id") Long id) {
        Player player = getPlayer(id);

        PlayerDto resultDto = PlayerDto.fromPlayer(player);
        return resultDto;
    }
}

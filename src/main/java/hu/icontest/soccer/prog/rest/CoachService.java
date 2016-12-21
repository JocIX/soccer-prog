/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.rest;

/**
 * @author developer
 */
import static hu.icontest.soccer.prog.dao.CoachDao.readCoach;
import static hu.icontest.soccer.prog.dao.CoachDao.getCoach;
import hu.icontest.soccer.prog.dto.ResultDto;
import hu.icontest.soccer.prog.dto.CoachDto;
import hu.icontest.soccer.prog.model.Coach;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/coach-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoachService {

    @GET
    @Path("query-all")
    public List<CoachDto> queryAll() {

        List<Coach> coachList = readCoach();
        List<CoachDto> coachDtoList = new ArrayList<>();
        for (Coach coach : coachList) {
            CoachDto resultDto = CoachDto.fromCoach(coach);
            coachDtoList.add(resultDto);

            //coachDtoList.add(CoachDto.fromCoach(coach));
        }
        return coachDtoList;
    }

    @GET
    @Path("get-by-id")
    public CoachDto queryByID(@QueryParam("id") Long id) {
        Coach coach = getCoach(id);

        CoachDto resultDto = CoachDto.fromCoach(coach);
        return resultDto;
    }

}

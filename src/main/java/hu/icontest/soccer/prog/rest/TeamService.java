package hu.icontest.soccer.prog.rest;

import static hu.icontest.soccer.prog.dao.TeamDao.listTeam;
import static hu.icontest.soccer.prog.dao.TeamDao.getTeam;
import hu.icontest.soccer.prog.dto.ResultDto;
import hu.icontest.soccer.prog.dto.TeamDto;
import hu.icontest.soccer.prog.model.Team;
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
@Path("/team-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamService {

    @GET
    @Path("query-all")
    public List<TeamDto> queryAll() {
        /*
        1. meghivni a DAO-t, az visszaad egy team-listát.
        2. for ciklus az adott teamlistán, ezeket dto-vá alakitani, ezeket belerakni új listába, aztán ezeket returnnel
           visszaadni. 
         List<Team> teams = teamDao.listTeam();
         */
        List<Team> teamList = listTeam();
        List<TeamDto> teamDtoList = new ArrayList<>();
        for (Team team : teamList) {
            // teamDtoList.add(TeamDto.fromTeam(team));
            TeamDto resultDto = TeamDto.fromTeam(team);
            teamDtoList.add(resultDto);

        }
        return teamDtoList;
    }

    @GET
    @Path("get-by-id")
    public TeamDto queryByID(@QueryParam("id") Long id) {
        Team team = getTeam(id);
//        if (team == null) {
//            System.out.println("Nincs ilyen csapat");
//            return null;
//        } else {
        TeamDto resultDto = TeamDto.fromTeam(team);
        return resultDto;
//        }
        //return TeamDto.fromTeam(getTeam(id));
    }
}

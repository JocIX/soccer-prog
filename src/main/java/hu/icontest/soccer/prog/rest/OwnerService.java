/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.icontest.soccer.prog.rest;

import static hu.icontest.soccer.prog.dao.OwnerDao.getOwners;
import static hu.icontest.soccer.prog.dao.OwnerDao.getOwner;
import hu.icontest.soccer.prog.dto.ResultDto;
import hu.icontest.soccer.prog.dto.OwnerDto;
import hu.icontest.soccer.prog.model.Owner;
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

    
@Path("/owner-service")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class OwnerService {

        @GET
        @Path("query-all")
        public List<OwnerDto> queryAll() {

            List<Owner> ownerList = getOwners();
            List<OwnerDto> ownerDtoList = new ArrayList<>();
            for (Owner owner : ownerList) {
                OwnerDto resultDto = OwnerDto.fromOwner(owner);
                ownerDtoList.add(resultDto);
                
                //coachDtoList.add(CoachDto.fromCoach(coach));
            }
            return ownerDtoList;
        }

@GET
    @Path("get-by-id")
    public OwnerDto queryByID(@QueryParam("id") Long id) {
        Owner owner = getOwner(id);
       
        OwnerDto resultDto = OwnerDto.fromOwner(owner);
        return resultDto;

    }
    
    }





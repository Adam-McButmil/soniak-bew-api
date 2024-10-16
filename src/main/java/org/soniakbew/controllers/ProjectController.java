package org.soniakbew.controllers;

import io.swagger.annotations.Api;
import org.soniakbew.exceptions.FailedToCreateException;
import org.soniakbew.exceptions.InvalidException;
import org.soniakbew.models.Project;
import org.soniakbew.services.ClientService;
import org.soniakbew.services.ProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Project API")
@Path("/api/project")
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(final Project project) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(project.createProject(project))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            System.out.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}

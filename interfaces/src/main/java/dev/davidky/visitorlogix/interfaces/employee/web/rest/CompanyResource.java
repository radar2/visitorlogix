package dev.davidky.visitorlogix.interfaces.employee.web.rest;


import dev.davidky.visitorlogix.domain.entity.Employee;
import dev.davidky.visitorlogix.interfaces.employee.facade.EmployeeManagementFacade;
import dev.davidky.visitorlogix.interfaces.employee.facade.dto.CreatedEmployeeDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@ApplicationScoped
@Path("/employee")
@Tag(name = "Employee Management", description = "Company employees management")
public class CompanyResource {

    @Inject
    private EmployeeManagementFacade employeeManagementFacade;

    @Path("/create")
    @POST
    @Produces(value = {"application/json"})
    @Consumes(value = {"application/json"})
    public Response createNewEmployee(CreatedEmployeeDTO body) {
        return Response.status(201)
                .entity(
                employeeManagementFacade.createEmployee(body)).build();
    }

    @Path("")
    @GET
    @Produces(value =  "application/json")
    public Response  retrieveEmployeesList() {
        return Response.ok(employeeManagementFacade.getEmployeeList()).build();
    }
}

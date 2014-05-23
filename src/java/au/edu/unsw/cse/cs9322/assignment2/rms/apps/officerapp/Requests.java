package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestList;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/requests")
public class Requests extends OfficerAppResource {

    public Requests(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);

        if (getUserId(req) == null)
            raiseError("not authorized");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void showRequests() throws IOException, ServletException {
        showRequests("NEW");
    }

    @GET
    @Path("status/{status}")
    @Produces(MediaType.TEXT_HTML)
    public void showRequests(
            @PathParam("status") String status)
            throws IOException, ServletException {

        RequestStatus reqStatus = RequestStatus.valueOf(status);

        List<RequestItem> toRemove = new ArrayList<RequestItem>();
        RequestList list = getRequestBuilder(service.path("registration").path("requests"))
                .accept(MediaType.APPLICATION_XML)
                .get(RequestList.class);
//        RequestList list=RequestDB.getQueueList();
        for (RequestItem r : list) {
            if (r.getStatus() != reqStatus)
                toRemove.add(r);
        }
        list.removeAll(toRemove);

        httpRequest.setAttribute("requestPathBase", getPath("requests"));
        httpRequest.setAttribute("logoutAction", getPath("logout"));
        httpRequest.setAttribute("statusList", RequestStatus.values());
        httpRequest.setAttribute("requestList", list);

        render("requests.jsp");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public void showRequestDetail(
            @PathParam("id") String id)
            throws IOException, ServletException {

        try {

            RequestItem r = getRequestBuilder(service.path("request").path(id))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);
            httpRequest.setAttribute("requestDetail", r);
            render("detail.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }

    }
}

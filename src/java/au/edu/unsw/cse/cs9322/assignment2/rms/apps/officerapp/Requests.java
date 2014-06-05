package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestList;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

/*
 GET /RMS/apps/officer/request/list
 GET /RMS/apps/officer/request/list/[status]
 */
@Path("/request")
public class Requests extends OfficerAppResource {

    public Requests(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);

        if (getUserId() == null)
            raiseError("not authenticated");
        httpRequest.setAttribute("homePage", getPathFromApp("request/list/NEW"));
    }

    @GET
    @Path("list")
    @Produces(MediaType.TEXT_HTML)
    public void showRequests() throws IOException, ServletException {
//        showRequests("NEW");
        httpResponse.sendRedirect(getPathFromApp("request/list/NEW"));
    }

    private Set<Map.Entry<String, String>> getNavButtons() {
        Map<String, String> btns = new HashMap<String, String>();
        for (RequestStatus s : RequestStatus.values())
            if (s != RequestStatus.ARCHIVED)
                btns.put(s.name(), getPathFromApp("request/list/" + s.name()));

        return btns.entrySet();
    }

    @GET
    @Path("list/{status}")
    @Produces(MediaType.TEXT_HTML)
    public void showRequests(
            @PathParam("status") String status)
            throws IOException, ServletException {

        // path
        httpRequest.setAttribute("requestPathBase", getPathFromApp("request"));
        httpRequest.setAttribute("logoutAction", getPathFromApp("logout"));

        // status
        RequestStatus reqStatus = RequestStatus.valueOf(status);
        httpRequest.setAttribute("navButtons", getNavButtons());
        httpRequest.setAttribute("navButtons_active", reqStatus.name());

        // list
        List<RequestItem> toRemove = new ArrayList<RequestItem>();
        RequestList list = getRequestBuilder(
                service.path("request").path("list"))
                .accept(MediaType.APPLICATION_XML)
                .get(RequestList.class);
        //RequestList list=RequestDB.getQueueList();//for debug
        for (RequestItem r : list) {
            if (r.getStatus() != reqStatus)
                toRemove.add(r);
        }
        list.removeAll(toRemove);
        httpRequest.setAttribute("requestList", list);

        render("requests.jsp");
    }

}

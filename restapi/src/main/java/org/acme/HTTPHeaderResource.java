package org.acme;


import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@Path("/httpheader")
public class HTTPHeaderResource {

    //
    @GET
    public String getHeader(@HeaderParam("User-Agent") String userAgent) {
        return userAgent;
    }
}
package com.greg.privatelink.note;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.UUID;

@Path("/notes")
public class NoteResource {

    private final NoteService noteService = new InMemoryNoteService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo uriInfo, NoteRequest request) {
        URI requestUri = uriInfo.getRequestUri();
        String text = request.getText();
        UUID id = noteService.add(text);
        URI noteURI = URI.create(String.valueOf(requestUri) + '/' + id);
        NoteResponse response = new NoteResponse(id, text);

        return Response.created(noteURI)
                .entity(response)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAndRemove(@PathParam("id") UUID id) {

        return noteService.findAndRemove(id)
                .map(text -> new NoteResponse(id, text))
                .map(noteResponse -> Response.ok(noteResponse).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }
}

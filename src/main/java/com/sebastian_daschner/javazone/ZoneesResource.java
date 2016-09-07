package com.sebastian_daschner.javazone;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("zonees")
public class ZoneesResource {

    @Inject
    JavaZone javaZone;

    @Inject
    String property;

    @Inject
    @Configured("property_name")
    String configuredProperty;

    @Inject
    Event<Zonee> newZonees;

    @GET
    public JsonArray getZonees() {
        return javaZone.getZonees().stream().map(z -> Json.createObjectBuilder()
                .add("zonee_name", z.getName())
                .add("property", property)
                .add("configured_property", configuredProperty)
                .build())
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createZonee(@Valid @NotNull Zonee zonee) {
        javaZone.createZonee(zonee);
        newZonees.fire(zonee);
    }

}

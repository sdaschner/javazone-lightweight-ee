package com.sebastian_daschner.javazone;

import java.util.Arrays;
import java.util.List;

public class JavaZone {

    public List<Zonee> getZonees() {
        return Arrays.asList(new Zonee("Hello"), new Zonee("Norge"));
    }

    public void createZonee(final Zonee zonee) {
        System.out.println("new Zonee! " + zonee);
    }

    public boolean isUsernameTaken(final String string) {
        return "abc".equals(string);
    }

}

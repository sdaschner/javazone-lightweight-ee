package com.sebastian_daschner.javazone;

import javax.validation.constraints.NotNull;

public class Zonee {

    @NotNull
    @UsernameNotTaken
    private String name;

    public Zonee() {
    }

    public Zonee(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zonee{" +
                "name='" + name + '\'' +
                '}';
    }

}

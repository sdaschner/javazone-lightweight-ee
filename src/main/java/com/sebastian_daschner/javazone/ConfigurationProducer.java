package com.sebastian_daschner.javazone;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class ConfigurationProducer {

    @Produces
    public String exposeConfig(InjectionPoint injectionPoint) {
        return injectionPoint.getMember().getDeclaringClass() + ":" + injectionPoint.getMember().getName();
    }

    @Produces
    @Configured("unused")
    public String exposeConfiguredProperty(InjectionPoint injectionPoint) {
        return injectionPoint.getMember().getDeclaringClass() + ":" + injectionPoint.getMember().getName() + ":"
                + injectionPoint.getAnnotated().getAnnotation(Configured.class).value();
    }

}

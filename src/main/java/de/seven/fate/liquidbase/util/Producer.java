package de.seven.fate.liquidbase.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
public class Producer {

    @Produces
    @Named("logger")
    public Logger produceLog(InjectionPoint injectionPoint) {

        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}

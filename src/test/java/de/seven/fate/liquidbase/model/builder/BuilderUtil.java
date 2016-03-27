package de.seven.fate.liquidbase.model.builder;

import de.seven.fate.liquidbase.model.builder.annotations.Models;
import de.seven.fate.model.builder.AbstractModelBuilder;
import de.seven.fate.model.util.NumberUtil;

import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by Mario on 26.03.2016.
 */
public final class BuilderUtil {

    private static final int RANDOM_SIZE = -1;

    public static int getCollectionSize(InjectionPoint injectionPoint) {

        int size = injectionPoint.getAnnotated().getAnnotation(Models.class).size();

        if (size == RANDOM_SIZE) {
            size = NumberUtil.random(1, 10);
        }

        return size;
    }
}

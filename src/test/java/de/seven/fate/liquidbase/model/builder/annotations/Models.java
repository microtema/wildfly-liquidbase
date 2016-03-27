package de.seven.fate.liquidbase.model.builder.annotations;

import de.seven.fate.liquidbase.model.builder.enums.CollectionType;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
public @interface Models {

    int size() default -1;

    CollectionType value() default CollectionType.LIST;
}

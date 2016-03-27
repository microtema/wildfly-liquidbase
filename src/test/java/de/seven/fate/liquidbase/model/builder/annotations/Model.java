package de.seven.fate.liquidbase.model.builder.annotations;

import de.seven.fate.liquidbase.model.builder.enums.ModelType;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


@Qualifier
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })
public @interface Model {

	ModelType value() default ModelType.MIN;
}

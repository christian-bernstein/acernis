package de.christianbernstein.acernis.api.service;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubscribeEvent {

    String bus() default "*";

}

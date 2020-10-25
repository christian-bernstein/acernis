package de.christianbernstein.acernis.api.internal.service;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubscribeEvent {

    String bus() default "*";

    EventPriority priority() default EventPriority.NORMAL;

}

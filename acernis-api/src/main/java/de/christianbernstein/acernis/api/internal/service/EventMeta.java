package de.christianbernstein.acernis.api.internal.service;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventMeta {

    boolean hasResult() default true;

    boolean isCancellable() default true;

}

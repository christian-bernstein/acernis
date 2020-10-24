package de.christianbernstein.acernis.api.service;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cancelable {
}

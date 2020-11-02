package de.christianbernstein.acernis.node;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NodeDeclaration {
}

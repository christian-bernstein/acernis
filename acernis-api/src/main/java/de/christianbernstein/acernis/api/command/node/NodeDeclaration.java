package de.christianbernstein.acernis.api.command.node;

import java.lang.annotation.*;

/**
 * @author Christian Bernstein
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NodeDeclaration {
}

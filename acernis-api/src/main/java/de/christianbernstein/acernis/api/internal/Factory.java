package de.christianbernstein.acernis.api.internal;

import java.io.Serializable;

/**
 * @author Christian Bernstein
 */
public interface Factory<T> extends Serializable {

    T create();

}

package de.christianbernstein.acernis.util;

import java.io.Serializable;

/**
 * @author Christian Bernstein
 */
public interface Factory<T> extends Serializable {

    T create();

}

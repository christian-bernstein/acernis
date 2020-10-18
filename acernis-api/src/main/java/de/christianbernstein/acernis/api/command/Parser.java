package de.christianbernstein.acernis.api.command;

/**
 * Represents a simple parser. (This is a separate interface from {@link java.util.function.Function} for clarity)
 *
 * This is a functional interface
 * whose functional method is {@link #parse(V)}.
 *
 * @param <T> tge type of input given to parse;
 * @param <V> the type of results supplied by this parser
 *
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface Parser<T, V>  {

    /**
     * Get a instance of V, from a provided instance of T.
     *
     * @param input Takes an instance of T
     * @return Parses the input into V
     */
    V parse(T input);

}

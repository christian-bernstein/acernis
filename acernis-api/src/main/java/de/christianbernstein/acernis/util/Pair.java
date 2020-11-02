package de.christianbernstein.acernis.util;

import lombok.*;

/**
 * @author Christian Bernstein
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Pair<T, V> {

    @Getter
    @Setter
    private T val1;

    @Getter
    @Setter
    private V val2;

}

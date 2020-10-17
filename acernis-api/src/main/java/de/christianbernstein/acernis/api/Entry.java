package de.christianbernstein.acernis.api;

import de.christianbernstein.acernis.api.internal.JsonDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * A base class for project/package entries. More specific information should be stored via the meta
 *
 * @author Christian Bernstein
 */
@Builder
@AllArgsConstructor
@Data
public class Entry {

    @Builder.Default
    private final UUID uuid = UUID.randomUUID();

    @Builder.Default
    private final JsonDocument meta = new JsonDocument();

    private final Type type;

    private final String path;

    private final String name;

    /**
     * Arbitrary solution for type differentiation
     */
    public enum Type {
        PROJECT, PACKAGE
    }
}

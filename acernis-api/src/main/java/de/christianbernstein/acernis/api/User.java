package de.christianbernstein.acernis.api;

import de.christianbernstein.acernis.api.internal.JsonDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

/**
 * @author Christian Bernstein
 */
@Builder
@AllArgsConstructor
@Data
public class User {

    @Builder.Default
    private final UUID uuid = UUID.randomUUID();

    @NonNull
    private String name;

    @Builder.Default
    private String organization = null;

    @NonNull
    private String group;

    @Builder.Default
    private final JsonDocument meta = new JsonDocument();

}

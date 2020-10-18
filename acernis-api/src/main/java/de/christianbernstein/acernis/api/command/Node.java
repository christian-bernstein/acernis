package de.christianbernstein.acernis.api.command;

import lombok.*;

import java.util.List;

/**
 *
 * @author Christian Bernstein
 */
@Data
@Builder
@ToString
public class Node implements INode {

    @NonNull
    private final String literal;

    @Singular(ignoreNullCollections = true)
    private final List<String> aliases;

    @Singular(ignoreNullCollections = true)
    private final List<String> permissions;

    private final String description;

    private final String usage;

    @Builder.Default
    private final boolean confirmationReliant = false;

    @NonNull
    @Builder.Default
    private final Visibility visibility = Visibility.PUBLIC;

    private final IDocument parameters;

    private final IExecutor executor;
}

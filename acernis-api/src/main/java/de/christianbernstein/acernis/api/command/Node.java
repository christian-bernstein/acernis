package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.util.IDocument;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

/**
 *
 * @author Christian Bernstein
 */
@Data
@Builder
public class Node implements INode {

    @NonNull
    private final String literal;

    @NonNull
    @Singular(ignoreNullCollections = true)
    private final List<String> aliases;

    @NonNull
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

    @NonNull
    private final IExecutor executor;
}

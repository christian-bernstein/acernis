package de.christianbernstein.acernis.api.command.node;

import de.christianbernstein.acernis.api.command.IContextCompiler;
import de.christianbernstein.acernis.api.command.IExecutor;
import de.christianbernstein.acernis.api.command.parameters.IContainer;
import de.christianbernstein.acernis.api.internal.JsonDocument;
import lombok.*;

import java.util.List;

/**
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

    private final IContainer parameters;

    private final IExecutor executor;

    @Builder.Default
    private final JsonDocument meta = JsonDocument.newDocument();

    @Builder.Default
    private final IContextCompiler contextCompiler = null;
}

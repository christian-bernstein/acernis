package de.christianbernstein.acernis.node;

import de.christianbernstein.acernis.IContextCompiler;
import de.christianbernstein.acernis.IExecutor;
import de.christianbernstein.acernis.parameters.IContainer;
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
    private final IContextCompiler contextCompiler = null;
}

package de.christianbernstein.acernis.api.internal.command.node;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface INodeRunner {

    Optional<INode> getNode(@NonNull Set<RegisteredNode> nodes, @NonNull List<String> nodeRequest) throws NodeException;

}

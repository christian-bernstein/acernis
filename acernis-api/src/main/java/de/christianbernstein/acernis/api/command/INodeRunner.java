package de.christianbernstein.acernis.api.command;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Christian Bernstein
 */
public interface INodeRunner {

    Optional<INode> getNode(Set<RegisteredNode> nodes, List<String> nodeRequest);

}

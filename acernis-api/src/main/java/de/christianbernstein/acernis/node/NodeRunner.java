package de.christianbernstein.acernis.node;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Christian Bernstein
 */
public class NodeRunner implements INodeRunner {

    @Override
    public Optional<INode> getNode(Set<RegisteredNode> nodes, List<String> nodeRequest) throws NodeException {
        final Optional<RegisteredNode> root = nodes.stream().filter(node -> node.test(nodeRequest.get(0))).findFirst();
        if (!root.isPresent()) return Optional.empty();
        final AtomicReference<RegisteredNode> currentNode = new AtomicReference<>(root.get());
        for (int i = 1; i < nodeRequest.size(); i++) {
            final String currentRequest = nodeRequest.get(i);
            // Process all child nodes
            currentNode.get().getChildNodes().forEach(child -> {
                if (child.test(currentRequest)){
                    currentNode.set((RegisteredNode) child);
                }
            });
            // Validate the new parent node
            if (!currentNode.get().test(currentRequest)){
                System.err.println("Algorithm hit dead end, probably caused by a missing node (The command should be checked)");
                return Optional.empty();
            }
        }
        return Optional.of(currentNode.get().getNode());
    }
}

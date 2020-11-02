package de.christianbernstein.acernis.command;

import de.christianbernstein.acernis.command.node.INodeSource;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 * @author Christian Bernstein
 */
public class CommandFramework {

    private final List<INodeSource> nodeSources;

    @Builder
    public CommandFramework(@Singular(value = "source") List<INodeSource> nodeSources) {
        this.nodeSources = nodeSources;
    }
}

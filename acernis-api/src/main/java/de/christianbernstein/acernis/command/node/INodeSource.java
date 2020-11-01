package de.christianbernstein.acernis.command.node;

import java.util.List;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface INodeSource {

    List<INode> get();

}

package de.christianbernstein.acernis.node;

import java.util.List;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface INodeSource {

    List<INode> get();

}

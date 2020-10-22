package de.christianbernstein.acernis.api.command.node;

import lombok.NonNull;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
public interface IRegisteredNode extends Predicate<String> {

    @NonNull
    INode getNode();

    @NonNull
    Set<String> getStringNodes();

    @NonNull
    Set<IRegisteredNode> getChildNodes();

}

package de.christianbernstein.acernis;

import de.christianbernstein.acernis.node.INode;
import lombok.NonNull;

/**
 * The actual executor for a command, which get wrapped into a {@link INode}.
 *
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface IExecutor {

    void execute(@NonNull ICommandDispatchContext context);

}

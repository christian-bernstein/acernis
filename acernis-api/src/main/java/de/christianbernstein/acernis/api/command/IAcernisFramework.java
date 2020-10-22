package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.conduction.IConductor;
import de.christianbernstein.acernis.api.command.node.RegisteredNode;

import java.io.Closeable;
import java.time.Duration;

/**
 * @author Christian Bernstein
 *
 */
public interface IAcernisFramework extends Closeable {

    /**
     * Prepares the command framework
     * Some parts of the command framework need to be initialized. If the handshakes are based on reflectional
     * access, this method will handle them.
     *
     * @return The init method can take a long time to finish, especially if using any reflectional access on large
     * class paths. The returned {@link Duration} is a simple way to monitor the speed, this can be useful when improving
     * performance & launch time.
     */
    Duration init();

    /**
     *
     * @param conductor A object referring to the issuer of the command, with a set of permissions, and a way to send
     *                  messages directly via {@link IConductor#sendMessage(String)}. A conductor doesn't necessarily
     *                  point to a person trying to execute the command. Furthermore the whole concept is just to have
     *                  some sort of information about the executing component and its permissions.
     *                  This concept pays out, if multiple persons, algorithms, even from different environments
     *                  use this command interface. Then you can differentiate between all systems and treat them
     *                  separately.
     *                  Keep in mind, that this system of essentially comparing permissions isn't a safety mechanism
     *                  at all, for this to be somewhat save, the executor must have no control about which permissions
     *                  are applied to him or any way to parse a proxied conductor.
     * @param command A raw and unprocessed string, representing the command, issued by the conductor.
     * @return A meta, containing information, that could be useful by the code, that issued the command.
     */
    ICommandReturnContext dispatch(IConductor conductor, String command);

    void removeNode(RegisteredNode node);

}

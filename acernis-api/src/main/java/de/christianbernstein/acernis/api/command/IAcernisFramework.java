package de.christianbernstein.acernis.api.command;

import java.io.Closeable;
import java.time.Duration;

/**
 * @author Christian Bernstein
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

    void dispatch(IConductor conductor, String command);
}

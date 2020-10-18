package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.util.IDocument;
import lombok.NonNull;

import java.util.Properties;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface IExecutor {

    void execute(@NonNull IConductor conductor, @NonNull IDocument parameters, @NonNull Properties properties, @NonNull String raw);

}

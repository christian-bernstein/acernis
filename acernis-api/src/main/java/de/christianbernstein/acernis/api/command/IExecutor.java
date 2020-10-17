package de.christianbernstein.acernis.api.command;

import lombok.NonNull;

import java.util.Properties;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface IExecutor {

    void execute(@NonNull IConductor conductor, @NonNull IParameters parameters, @NonNull Properties properties, @NonNull String raw);

}

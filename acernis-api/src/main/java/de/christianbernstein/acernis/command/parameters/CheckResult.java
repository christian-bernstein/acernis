package de.christianbernstein.acernis.command.parameters;

import lombok.Data;

import java.util.List;

/**
 * @author Christian Bernstein
 */
@Data
public class CheckResult {

    private final boolean success;

    private final List<Throwable> throwables;

    private final String message;
}

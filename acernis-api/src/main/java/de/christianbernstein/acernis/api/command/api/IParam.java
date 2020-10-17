package de.christianbernstein.acernis.api.command.api;

import java.util.function.Function;

/**
 * @author Christian Bernstein
 */
public interface IParam {

    boolean validate(String s);

    Function<String, String> replacementService();

}

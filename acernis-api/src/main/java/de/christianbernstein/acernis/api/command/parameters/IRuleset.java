package de.christianbernstein.acernis.api.command.parameters;

import java.util.List;

/**
 * @author Christian Bernstein
 */
public interface IRuleset {

    List<IParameter> getRuleset();

    boolean validate(List<String> parameters);

}

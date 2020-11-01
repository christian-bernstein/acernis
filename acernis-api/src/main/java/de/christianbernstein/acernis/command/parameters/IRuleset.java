package de.christianbernstein.acernis.command.parameters;

import de.christianbernstein.acernis.internal.Pair;

import java.util.List;

/**
 * @author Christian Bernstein
 */
public interface IRuleset {

    List<IParameter> getRuleset();

    Pair<Boolean, List<CheckResult>> validate(List<String> parameters);

}

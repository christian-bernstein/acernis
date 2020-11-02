package de.christianbernstein.acernis.parameters;

import de.christianbernstein.acernis.util.Pair;

import java.util.List;

/**
 * @author Christian Bernstein
 */
public interface IRuleset {

    List<IParameter> getRuleset();

    Pair<Boolean, List<CheckResult>> validate(List<String> parameters);

}

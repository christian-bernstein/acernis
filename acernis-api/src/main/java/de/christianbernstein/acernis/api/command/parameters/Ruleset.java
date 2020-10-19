package de.christianbernstein.acernis.api.command.parameters;

import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Bernstein
 */
@Builder
public class Ruleset implements IRuleset {

    @Singular
    private final List<IParameter> ruleset = new ArrayList<>();

    @Override
    public List<IParameter> getRuleset() {
        return new ArrayList<>(this.ruleset);
    }

    @Override
    public boolean validate(List<String> parameters) {
        int i = 0;
        for (final IParameter rule : this.ruleset) {
            final String s1 = parameters.get(i);
            rule.validate(s1);
        }
        return false;
    }
}

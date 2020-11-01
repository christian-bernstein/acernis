package de.christianbernstein.acernis.command.parameters;

import de.christianbernstein.acernis.internal.Pair;
import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Bernstein
 */
@Builder
public class Ruleset implements IRuleset {

    @Singular(value = "parameter")
    private final List<IParameter> ruleset;

    @Override
    public List<IParameter> getRuleset() {
        return new ArrayList<>(this.ruleset);
    }

    @Override
    public Pair<Boolean, List<CheckResult>> validate(List<String> parameters) {
        boolean overallSuccess = true;
        int i = 0;
        final List<CheckResult> results = new ArrayList<>();
        for (final IParameter rule : this.ruleset) {
            final String s1 = parameters.get(i);
            final CheckResult result = rule.validate(s1);
            if (!result.isSuccess()) overallSuccess = false;
            results.add(result);
        }
        return new Pair<>(overallSuccess, results);
    }
}

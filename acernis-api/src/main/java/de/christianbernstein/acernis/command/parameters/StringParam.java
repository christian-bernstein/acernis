package de.christianbernstein.acernis.command.parameters;

import lombok.Builder;
import lombok.NonNull;

import java.util.Collections;

@Builder
public class StringParam implements IParameter {

    private final String regex;

    @Override
    public CheckResult validate(@NonNull String param) {
        return new CheckResult(true, Collections.emptyList(), "");
    }
}

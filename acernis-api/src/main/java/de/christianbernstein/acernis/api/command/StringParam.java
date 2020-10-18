package de.christianbernstein.acernis.api.command;

import lombok.Builder;
import lombok.NonNull;
import java.util.regex.Pattern;

@Builder
public class StringParam implements IParameter {

    private final String regex;

    @Override
    public boolean validate(@NonNull String param) {
        if (regex == null) return true;
        return Pattern.compile(this.regex).matcher(param).matches();
    }
}

package de.christianbernstein.acernis.command.conduction;

import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author Christian Bernstein
 */
public class PermissionValidator implements Predicate<PermissionAttachment> {

    public static final Pattern regex = Pattern.compile("([a-zA-Z]*\\.)*([a-zA-Z]*)(\\*|[a-zA-Z])$");

    @Override
    public boolean test(PermissionAttachment attachment) {
        for (final Map.Entry<String, Boolean> entry : attachment.getPermissions().entrySet()) {
            if (!regex.asPredicate().test(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}

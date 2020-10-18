package util;

import de.christianbernstein.acernis.api.command.IConductor;
import de.christianbernstein.acernis.api.command.Permissible;
import de.christianbernstein.acernis.api.command.PermissionAttachment;

import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
public class DebugConductor extends Permissible implements IConductor {

    public static final UUID debugConductorUUID = UUID.fromString("");

    public DebugConductor(Set<PermissionAttachment> attachments, Predicate<PermissionAttachment> permissionValidator) {
        super(attachments, permissionValidator);
    }

    @Override
    public UUID getPersistentID() {
        return debugConductorUUID;
    }
}

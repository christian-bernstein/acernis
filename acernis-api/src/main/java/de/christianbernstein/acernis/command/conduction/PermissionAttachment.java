package de.christianbernstein.acernis.command.conduction;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author Christian Bernstein
 */
@Builder
@ToString
public class PermissionAttachment {

    @Getter
    @Builder.Default
    private final UUID uuid = UUID.randomUUID();

    @Getter
    @Setter
    @ToString.Exclude
    private Consumer<PermissionAttachment> removalCallback;

    @Getter
    @ToString.Exclude
    private final IPermissible permissible;

    @Singular
    private final Map<String, Boolean> permissions;

    public Map<String, Boolean> getPermissions() {
        return new HashMap<>(this.permissions);
    }

    public void addPermission(@NonNull String name, @NonNull Boolean value){
        this.permissions.put(name, value);
    }

    public void removePermission(@NonNull String name){
        this.permissions.remove(name);
    }
}

package de.christianbernstein.acernis.conduction;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
public interface IPermissible {

    PermissionAttachment addAttachment();

    PermissionAttachment addAttachment(@NonNull PermissionAttachment attachment);

    PermissionAttachment addAttachment(@NonNull String name, @NonNull boolean value);

    PermissionAttachment addAttachment(@NonNull PermissionAttachment attachment, @NonNull long delay, @NonNull TimeUnit unit);

    Optional<PermissionAttachment> getAttachment(@NonNull UUID uuid);

    void removeAttachment(@NonNull PermissionAttachment attachment);

    void removeAttachmentIf(Predicate<PermissionAttachment> attachmentPredicate);

    boolean hasPermission(@NonNull String name);

    Set<PermissionAttachment> getAttachments();

    List<Runnable> shutdownExpiringExecutor();

    Predicate<PermissionAttachment> getPermissionValidator();
}

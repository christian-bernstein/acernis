package de.christianbernstein.acernis.api.internal.command.conduction;

import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
public class Permissible implements IPermissible {

    private final Set<PermissionAttachment> attachments;

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Getter
    private final Predicate<PermissionAttachment> permissionValidator;

    public Permissible(final Set<PermissionAttachment> attachments, final Predicate<PermissionAttachment> permissionValidator) {
        this.attachments = attachments;
        this.permissionValidator = permissionValidator;
    }

    @Override
    public PermissionAttachment addAttachment() {
        final PermissionAttachment attachment = PermissionAttachment.builder().permissible(this).build();
        this.attachments.add(attachment);
        return attachment;
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull PermissionAttachment attachment) {
        if (this.validateAttachment(attachment)){
            throw new IllegalArgumentException("Attachment didn't pass the permission validation");
        }
        this.attachments.add(attachment);
        return attachment;
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull String name, @NonNull boolean value) {
        final PermissionAttachment attachment = PermissionAttachment.builder().permissible(this).permission(name, value).build();
        if (this.validateAttachment(attachment)){
            throw new IllegalArgumentException("Attachment didn't pass the permission validation");
        }
        this.attachments.add(attachment);
        return attachment;
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull PermissionAttachment attachment, @NonNull long delay, @NonNull TimeUnit unit) {
        if (this.validateAttachment(attachment)){
            throw new IllegalArgumentException("Attachment didn't pass the permission validation");
        }
        this.attachments.add(attachment);
        this.executor.schedule(() -> this.removeAttachment(attachment), delay, unit);
        return null;
    }

    @Override
    public Optional<PermissionAttachment> getAttachment(@NonNull UUID uuid) {
        return this.attachments.stream().filter(attachment -> attachment.getUuid().equals(uuid)).findFirst();
    }

    @Override
    public void removeAttachment(@NonNull PermissionAttachment attachment) {
        this.attachments.remove(attachment);
        attachment.getRemovalCallback().accept(attachment);
    }

    @Override
    public void removeAttachmentIf(Predicate<PermissionAttachment> attachmentPredicate) {
        this.attachments.forEach(attachment -> {
            if (attachmentPredicate.test(attachment)){
                this.removeAttachment(attachment);
            }
        });
    }

    @Override
    public boolean hasPermission(@NonNull String name) {
        for (final PermissionAttachment attachment : this.getAttachments()) {
            final Optional<Map.Entry<String, Boolean>> permission = attachment.getPermissions().entrySet().stream().filter(entry -> entry.getKey().equals(name)).findFirst();
            if (permission.isPresent() && permission.get().getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<PermissionAttachment> getAttachments() {
        return new HashSet<>(this.attachments);
    }

    @Override
    public List<Runnable> shutdownExpiringExecutor() {
        return this.executor.shutdownNow();
    }

    private boolean validateAttachment(@NonNull final PermissionAttachment attachment){
        return this.getPermissionValidator().test(attachment);
    }
}

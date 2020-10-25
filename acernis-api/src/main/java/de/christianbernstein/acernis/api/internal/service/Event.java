package de.christianbernstein.acernis.api.internal.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Christian Bernstein
 */
@ToString
public abstract class Event {

    @Getter
    private boolean cancelled = false;

    @Getter
    private Result result = Result.DEFAULT;

    /**
     * Checks, if the event is cancellable. The check consists of retrieving the optional {@link EventMeta}
     * and returning its {@link EventMeta#isCancellable()}.
     *
     * @return The value, which stands for the capability of cancelling the command. If the event isn't annotated with
     * a meta, the event is considered to be cancelable.
     */
    public boolean isCancelable(){
        if (this.getClass().isAnnotationPresent(EventMeta.class)){
            final EventMeta meta = this.getClass().getAnnotation(EventMeta.class);
            return meta.isCancellable();
        }
        return true;
    }

    public boolean hasResult(){
        if (this.getClass().isAnnotationPresent(EventMeta.class)){
            final EventMeta meta = this.getClass().getAnnotation(EventMeta.class);
            return meta.hasResult();
        }
        return true;
    }

    public void setResult(@NonNull Result result) throws UnsupportedOperationException {
        if (!this.hasResult()){
            throw new UnsupportedOperationException("Tried to change the result of an event, which doesn't support results");
        }
        this.result = result;
    }

    public void setCancelled(@NonNull boolean cancelled) throws UnsupportedOperationException {
        if (!this.isCancelable()){
            throw new UnsupportedOperationException("An un-cancelable event was tried to be cancelled");
        }
        this.cancelled = cancelled;
    }

    public enum Result {

        DENY, ALLOW, DEFAULT;

    }
}

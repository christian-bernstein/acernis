package de.christianbernstein.acernis.api.service;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Christian Bernstein
 */
public abstract class Event {

    @Getter
    private boolean cancelled = false;

    @Getter
    private Result result = Result.DEFAULT;

    public boolean isCancelable(){
        return this.getClass().isAnnotationPresent(Cancelable.class);
    }

    public boolean hasResult(){
        return this.getClass().isAnnotationPresent(HasResult.class);
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

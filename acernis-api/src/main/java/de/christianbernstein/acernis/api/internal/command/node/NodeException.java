package de.christianbernstein.acernis.api.internal.command.node;

import lombok.Getter;

import java.security.PrivilegedActionException;
import java.util.List;
import java.util.Set;

/**
 * @author Christian Bernstein
 */
public class NodeException extends Exception {

    /**
     * The node, at which the exception occurred. This value can be null, e.g. the {@link INodeRunner} throws
     * a NodeException, but lets this variable be null. There might be other examples, that are not listed here
     *
     * @see INodeRunner#getNode(Set, List)
     */
    @Getter
    private final String node;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public NodeException(String node) {
        this.node = node;
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NodeException(String message, String node) {
        super(message);
        this.node = node;
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A {@code null} value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public NodeException(String message, Throwable cause, String node) {
        super(message, cause);
        this.node = node;
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of {@code (cause==null ? null : cause.toString())} (which
     * typically contains the class and detail message of {@code cause}).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A {@code null} value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public NodeException(Throwable cause, String node) {
        super(cause);
        this.node = node;
    }

    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 1.7
     */
    public NodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String node) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.node = node;
    }
}

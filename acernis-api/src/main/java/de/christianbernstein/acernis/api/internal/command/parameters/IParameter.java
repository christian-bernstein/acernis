package de.christianbernstein.acernis.api.internal.command.parameters;

import lombok.NonNull;

/**
 * A parameter makes it easy manage parameters in commands, which had to be handled manually by the
 * executors. The process of handling input takes mostly the longest time, produces lots of repeating
 * code. The parameters try make safe commands creation easier for developers and those who read the code.
 * <p>
 * How to create an implementation:
 * If a parameter needs to be configured, all configurations should be made via a builder {@link lombok.Builder}.
 * Especially for realtime data, it might be worth considering to use {@link java.util.function.Supplier} as a way
 * to retrieve (keep up-to-date) validation data. But data can change during processing!
 *
 * @see StringParam
 *
 * @author Christian Bernstein
 */
public interface IParameter {

    /**
     * Before a command is executed, all string parameters have to be validated.
     * This feature is meant to make the creation of commands easier, because if it comes to an execution,
     * the parameters will be there and matching the requirements.
     *
     * @see CheckResult
     *
     * @param param The string parameter, matching in position
     * @return A detailed report
     */
    CheckResult validate(@NonNull String param);

}

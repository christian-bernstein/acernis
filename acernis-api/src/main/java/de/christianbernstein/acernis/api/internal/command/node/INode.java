package de.christianbernstein.acernis.api.internal.command.node;


import de.christianbernstein.acernis.api.internal.command.IContextCompiler;
import de.christianbernstein.acernis.api.internal.command.IExecutor;
import de.christianbernstein.acernis.api.internal.command.parameters.IContainer;
import de.christianbernstein.acernis.api.internal.JsonDocument;

import java.util.List;

/**
 * A node is an object for structuring the command tree.
 *
 * @author Christian Bernstein
 */
public interface INode {

    String getLiteral();

    List<String> getAliases();

    List<String> getPermissions();

    String getDescription();

    String getUsage();

    boolean isConfirmationReliant();

    IContainer getParameters();

    IExecutor getExecutor();

    JsonDocument getMeta();

    /**
     * Certain commands can rely on a custom context compiler.
     * The system will check the availability of a custom compiler, if it does exist, it will will be used for
     * compilation if not, the systems default compiler is used instead. This kind of fallback mechanism as well applies
     * in situations, where the custom compiler fails (Unhandled Exceptions, Null return)
     *
     * @return A custom {@link IContextCompiler}
     */
    IContextCompiler getContextCompiler();
}

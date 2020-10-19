package de.christianbernstein.acernis.api.command;


import de.christianbernstein.acernis.api.command.parameters.IDocument;
import de.christianbernstein.acernis.api.internal.JsonDocument;

import java.util.List;

/**
 * @author Christian Bernstein
 */
public interface INode {

    String getLiteral();

    List<String> getAliases();

    List<String> getPermissions();

    String getDescription();

    String getUsage();

    boolean isConfirmationReliant();

    IDocument getParameters();

    IExecutor getExecutor();

    JsonDocument getMeta();
}

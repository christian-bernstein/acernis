package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.util.IDocument;

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

    Visibility getVisibility();

    IDocument getParameters();

    IExecutor getExecutor();
}

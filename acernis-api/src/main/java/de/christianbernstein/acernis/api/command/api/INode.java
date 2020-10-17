package de.christianbernstein.acernis.api.command.api;

import de.christianbernstein.acernis.api.command.Visibility;

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

    IParameters getParameters();

    IExecutor getExecutor();
}

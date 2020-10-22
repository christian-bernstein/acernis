package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.internal.IDocument;
import de.christianbernstein.acernis.api.internal.JsonDocument;

/**
 * @author Christian Bernstein
 */
public interface ICommandReturnContext {

    int getReturnCode();

    IDocument<JsonDocument> getMeta();

}

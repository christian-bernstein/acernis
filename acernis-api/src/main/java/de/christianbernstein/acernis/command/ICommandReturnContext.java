package de.christianbernstein.acernis.command;

import de.christianbernstein.acernis.internal.IDocument;
import de.christianbernstein.acernis.internal.JsonDocument;

/**
 * @author Christian Bernstein
 */
public interface ICommandReturnContext {

    int getReturnCode();

    IDocument<JsonDocument> getMeta();

}

package de.christianbernstein.acernis.internal;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Map;

/**
 * Provides simple helper methods for {@link IDocument} related actions.
 *
 * @see IDocument Structure class
 *
 * @author Christian Bernstein
 */
@UtilityClass
public class DocumentUtils {

    /**
     * A simple utility method to add default values to an existing document. This method find its usage, when
     * default values should be applied without wiping existing values. Otherwise {@link IDocument#append(Map)} should
     * be used, but it does replace existing values with the provided map
     *
     * @param document The target for placing default values
     * @param defaults A map of default values to put into target, if absent
     * @param overrideNulls Special option to determine, if null values should be overwritten with the default value
     * @param <T> Type of Document
     * @return The eventually modified document
     *
     * @see IDocument Structure class
     * @see JsonDocument A default implementation
     */
    public <T extends IDocument<?>> T defaults(final @NonNull T document, final Map<String, Object> defaults, final @NonNull boolean overrideNulls){
        if (defaults == null) return document;
        defaults.forEach((s, o) -> {
            if (!document.contains(s) && (overrideNulls && document.getString(s) == null)){
                document.append(s, o);
            }
        });
        document.append(defaults);
        return document;
    }
}

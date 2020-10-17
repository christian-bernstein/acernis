package de.christianbernstein.acernis.api;

import lombok.NonNull;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
public interface IEntryService {

    List<Entry> getEntries(List<Predicate<Entry>> filters);

    /**
     * Important: Possible heap pollution from parameterized vararg type
     *
     * @param filters Filters for entries
     * @return list of filtered entries
     */
    List<Entry> getEntries(Predicate<Entry>... filters);

    boolean createEntry(@NonNull Entry entry);

}

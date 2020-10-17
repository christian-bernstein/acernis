import de.christianbernstein.acernis.api.Entry;
import de.christianbernstein.acernis.api.internal.JsonDocument;
import de.christianbernstein.acernis.api.internal.CacheBuilder;
import de.christianbernstein.acernis.api.internal.JCacheListener;

import javax.cache.Cache;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import java.util.UUID;

/**
 * @author Christian Bernstein
 */
public class CacheTest2 {

    public static void main(String[] args) {

        final MutableConfiguration<UUID, Entry> configuration = new MutableConfiguration<>();

        final Cache<UUID, Entry> cache = new CacheBuilder<UUID, Entry>().configuration(configuration).id("central").listener(
                FactoryBuilder.factoryOf(new JCacheListener.JCacheUpdatedListener<>(){
                    @Override
                    public void onUpdated(Iterable<CacheEntryEvent<? extends UUID, ? extends Entry>> iterable) throws CacheEntryListenerException {
                        System.out.println("The cache was updated!");
                    }
                })
        ).cache();

        // Create a package entry
        final UUID uuid1 = UUID.randomUUID();
        cache.put(uuid1, Entry.builder()
                .type(Entry.Type.PACKAGE)
                .name("internal")
                .uuid(uuid1)
                .path("A:")
                .meta(JsonDocument.newDocument("permission.see", "system")).build());

        // Create a project entry
        final UUID uuid2 = UUID.randomUUID();
        cache.put(uuid2, Entry.builder()
                .type(Entry.Type.PROJECT)
                .name("Spawn")
                .uuid(uuid2)
                .path("A:internal")
                .build());
    }
}

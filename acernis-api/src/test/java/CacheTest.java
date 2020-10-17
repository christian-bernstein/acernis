import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryUpdatedListener;
import javax.cache.spi.CachingProvider;
import java.io.Serializable;

/**
 * @author Christian Bernstein
 */
public class CacheTest {

    public static void main(String[] args) {
        final CachingProvider provider = Caching.getCachingProvider();
        final CacheManager manager = provider.getCacheManager();
        final MutableConfiguration<String, String> configuration = new MutableConfiguration<>();

        final JCacheCreatedListener<String, String> createdListener = new JCacheCreatedListener<String, String>() {
            @Override
            public void onCreated(Iterable<CacheEntryEvent<? extends String, ? extends String>> iterable) throws CacheEntryListenerException {
                System.out.println("An entry was created!");
            }
        };
        final JCacheUpdatedListener<String, String> updatedListener = new JCacheUpdatedListener<>() {
            @Override
            public void onUpdated(Iterable<CacheEntryEvent<? extends String, ? extends String>> iterable) throws CacheEntryListenerException {
                System.out.println("The cache was updated!");
            }
        };

        final Cache<String, String> cache = manager.createCache("central", configuration);

        cache.registerCacheEntryListener(new MutableCacheEntryListenerConfiguration<>(
                FactoryBuilder.factoryOf(createdListener), null, false, true
        ));
        cache.registerCacheEntryListener(new MutableCacheEntryListenerConfiguration<>(
                FactoryBuilder.factoryOf(updatedListener), null, false, true)
        );

        cache.put("message", "hello world");
        cache.put("message", "not hello world!");

        System.out.println("--------------------------------------------------------------------");
        cache.forEach(entry -> {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });
        System.out.println("--------------------------------------------------------------------");

        manager.close();
    }

    public abstract static class JCacheUpdatedListener<T, V> implements CacheEntryUpdatedListener<T, V>, Serializable {
    }

    public abstract static class JCacheCreatedListener<T, V> implements CacheEntryCreatedListener<T, V>, Serializable {
    }


}

package de.christianbernstein.acernis.api.internal;

import lombok.NonNull;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Factory;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryListener;
import javax.cache.spi.CachingProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Christian Bernstein
 */
@Deprecated
public class CacheBuilder<T, V> {

    private String id;

    private final List<Factory<? extends CacheEntryListener<T, V>>> listeners = new ArrayList<>();

    private MutableConfiguration<T, V> configuration;

    public CacheBuilder<T, V> listener(@NonNull final Factory<? extends CacheEntryListener<T, V>> listener){
        this.listeners.add(listener);
        return this;
    }

    public CacheBuilder<T, V> id(@NonNull final String id){
        this.id = id;
        return this;
    }

    public CacheBuilder<T, V> configuration(@NonNull final MutableConfiguration<T, V> configuration){
        this.configuration = configuration;
        return this;
    }

    public Cache<T, V> cache(){
        Objects.requireNonNull(this.id);
        Objects.requireNonNull(this.configuration);
        final CachingProvider provider = Caching.getCachingProvider();
        final CacheManager manager = provider.getCacheManager();
        final Cache<T, V> cache = manager.createCache(this.id, this.configuration);
        this.listeners.forEach(factory -> cache.registerCacheEntryListener(new MutableCacheEntryListenerConfiguration<>(
                factory, null, false, true
        )));
        return cache;
    }
}

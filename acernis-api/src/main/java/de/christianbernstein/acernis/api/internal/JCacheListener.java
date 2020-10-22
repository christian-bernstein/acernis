package de.christianbernstein.acernis.api.internal;

import lombok.experimental.UtilityClass;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryExpiredListener;
import javax.cache.event.CacheEntryRemovedListener;
import javax.cache.event.CacheEntryUpdatedListener;
import java.io.Serializable;

/**
 * @author Christian Bernstein
 */
@Deprecated
@UtilityClass
public class JCacheListener {

    public abstract static class JCacheUpdatedListener<T, V> implements CacheEntryUpdatedListener<T, V>, Serializable {
    }

    public abstract static class JCacheCreatedListener<T, V> implements CacheEntryCreatedListener<T, V>, Serializable {
    }

    public abstract static class JCacheRemovedListener<T, V> implements CacheEntryRemovedListener<T, V>, Serializable {
    }

    public abstract static class JCacheExpiredListener<T, V> implements CacheEntryExpiredListener<T, V>, Serializable {
    }
}

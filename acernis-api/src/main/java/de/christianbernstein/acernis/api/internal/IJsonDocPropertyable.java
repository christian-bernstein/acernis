package de.christianbernstein.acernis.api.internal;

public interface IJsonDocPropertyable {

    <E> IJsonDocPropertyable setProperty(JsonDocProperty<E> docProperty, E val);

    <E> E getProperty(JsonDocProperty<E> docProperty);

    <E> IJsonDocPropertyable removeProperty(JsonDocProperty<E> docProperty);

    <E> boolean hasProperty(JsonDocProperty<E> docProperty);

    JsonDocument getProperties();

}

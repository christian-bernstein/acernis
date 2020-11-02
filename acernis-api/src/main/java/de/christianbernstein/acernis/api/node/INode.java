package de.christianbernstein.acernis.api.node;

import lombok.NonNull;

import java.util.List;

public interface INode<T extends INode<T, V>, V> extends Iterable<T> {

    List<T> getChildren();

    int calculateDepth();

    INode<T, V> addChild(@NonNull T child);

    INode<T, V> removeChild(@NonNull T child);
}

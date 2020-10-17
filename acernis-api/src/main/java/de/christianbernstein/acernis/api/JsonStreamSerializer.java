package de.christianbernstein.acernis.api;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import lombok.Getter;

import java.io.IOException;

/**
 * @author Christian Bernstein
 */
public class JsonStreamSerializer<T> implements StreamSerializer<T> {

    @Getter
    private final Class<T> type;

    private final int typeId;

    public JsonStreamSerializer(Class<T> type, int typeId) {
        this.type = type;
        this.typeId = typeId;
    }

    @Override
    public void write(ObjectDataOutput objectDataOutput, T t) throws IOException {

    }

    @Override
    public T read(ObjectDataInput objectDataInput) throws IOException {
        return null;
    }

    @Override
    public int getTypeId() {
        return typeId;
    }

    @Override
    public void destroy() {

    }
}

package de.christianbernstein.acernis.api.command;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

public class ParameterContainer implements IDocument {

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key) {
        return false;
    }

    @Override
    public char getChar(String key) {
        return 0;
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public float getFloat(String key) {
        return 0;
    }

    @Override
    public short getShort(String key) {
        return 0;
    }

    @Override
    public byte getByte(String key) {
        return 0;
    }

    @Override
    public Date getDate(String key) {
        return null;
    }

    @Override
    public Class<?> getClass(String key) {
        return null;
    }

    @Override
    public UUID getUUID(String key) {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        return null;
    }

    @Override
    public BigInteger getBigInteger(String key) {
        return null;
    }

    @Override
    public <T> T asInstance(String id, Function<String, T> parser) {
        return null;
    }

    @Override
    public <T> T asInstance(Type type) {
        return null;
    }
}

package de.christianbernstein.acernis.api.internal.command.parameters;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author Christian Bernstein
 */
public interface IContainer {

    String get(String key);

    int getInt(String key);

    boolean getBoolean(String key);

    char getChar(String key);

    long getLong(String key);

    double getDouble(String key);

    float getFloat(String key);

    short getShort(String key);

    byte getByte(String key);

    Date getDate(String key);

    Class<?> getClass(String key);

    UUID getUUID(String key);

    BigDecimal getBigDecimal(String key);

    BigInteger getBigInteger(String key);

    Locale getLocale(String key);

    <T> T asInstance(String key, Function<String, T> parser);

    @NonNull
    boolean obtainsData();
}

package de.christianbernstein.acernis.api.internal.command.parameters;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author Christian Bernstein
 */
@RequiredArgsConstructor
public class Parameters implements IContainer {

    private final Map<String, Object> storage;

    @Override
    public String get(String key) {
        try {
            return this.storage.get(key).toString();
        }catch (final NullPointerException e){
            return null;
        }
    }

    @Override
    public int getInt(String key) {
        try {
            return Integer.parseInt(this.get(key));
        }catch (final NumberFormatException e){
            return -1;
        }
    }

    @Override
    public boolean getBoolean(String key) {
        try {
            return Boolean.parseBoolean(this.get(key));
        }catch (final NumberFormatException e){
            return false;
        }
    }

    @Override
    public char getChar(String key) {
        try {
            return this.get(key).charAt(0);
        }catch (final NumberFormatException e){
            return '~';
        }
    }

    @Override
    public long getLong(String key) {
        try {
            return Long.parseLong(this.get(key));
        }catch (final NumberFormatException e){
            return -1L;
        }
    }

    @Override
    public double getDouble(String key) {
        try {
            return Double.parseDouble(this.get(key));
        }catch (final NumberFormatException e){
            return -1.0;
        }
    }

    @Override
    public float getFloat(String key) {
        try {
            return Float.parseFloat(this.get(key));
        }catch (final NumberFormatException e){
            return -1.0f;
        }
    }

    @Override
    public short getShort(String key) {
        try {
            return Short.parseShort(this.get(key));
        }catch (final NumberFormatException e){
            return -1;
        }
    }

    @Override
    public byte getByte(String key) {
        try {
            return Byte.parseByte(this.get(key));
        }catch (final Exception e){
            return -1;
        }
    }

    @Override
    public Date getDate(String key) {
        try {
            return new Date(this.get(key));
        }catch (final Exception e){
            return Date.from(Instant.MIN);
        }
    }

    @Override
    public Class<?> getClass(String key) {
        try {
            return Class.forName(this.get(key), false, this.getClass().getClassLoader());
        }catch (final ClassNotFoundException e){
            return null;
        }
    }

    @Override
    public UUID getUUID(String key) {
        try {
            return UUID.fromString(this.get(key));
        }catch (final Exception e){
            return null;
        }
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        try {
            return new BigDecimal(this.get(key));
        }catch (final Exception e){
            return null;
        }
    }

    @Override
    public BigInteger getBigInteger(String key) {
        try {
            return new BigInteger(this.get(key));
        }catch (final Exception e){
            return null;
        }
    }

    @Override
    public Locale getLocale(String key) {
        try {
            return Locale.forLanguageTag(this.get(key));
        }catch (final Exception e){
            return null;
        }
    }

    @Override
    public <T> T asInstance(String key, Function<String, T> parser) {
        if (parser == null) return null;
        try {
            return parser.apply(this.get(key));
        }catch (final Exception e){
            return null;
        }
    }

    @Override
    public boolean obtainsData() {
        return !this.storage.isEmpty();
    }
}

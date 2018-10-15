package hr.from.ivanrezic.comicsapp.utils;

public final class Util {

    private Util() {}

    public static String validateProperty(String value, String propertyName) {
        return value == null ? "Ups.. " + propertyName + " missing :(" : value;
    }
}

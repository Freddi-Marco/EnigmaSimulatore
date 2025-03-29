package com.iiscastelli.enigmasimulatore;

public class Cavo {
    private final char a, b;

    public Cavo(char a, char b) {
        this.a = a;
        this.b = b;
    }

    public Character scambia(char c) {
        if (c == a)
            return b;
        if (c == b)
            return a;

        return c;
    }
}

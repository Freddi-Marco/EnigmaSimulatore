package com.iiscastelli.enigmasimulatore;

public class Cavo {
    private Character a, b;

    public Cavo(char a, char b) {
        setFirst(a);
        setSecond(b);
    }

    public Cavo() {}

    public boolean selezionato(char c) {
        return a == c || b == c;
    }

    public void setFirst(char first) {
        this.a = Character.toUpperCase(first);
    }

    public char getFirst() {
        return this.a;
    }

    public void setSecond(char second) {
        this.b = Character.toUpperCase(second);
    }

    public char getSecond() {
        return this.b;
    }

    public Character scambia(char c) {
        if (c == a)
            return b;
        if (c == b)
            return a;

        return c;
    }
}
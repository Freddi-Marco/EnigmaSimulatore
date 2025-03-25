package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;
import java.util.Collections;

public class Rotore {
    int pos = 0;
    ArrayList<Character> traduzione;


    public Rotore(String traduzione, int pos) {
        this.traduzione = new ArrayList<>();
        for (int i = 0; i < traduzione.length(); i++) {
            this.traduzione.add(traduzione.charAt(i));
        }
        this.pos = pos % 26;
    }

    public Rotore() {
        new Rotore("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0);
    }

    //Traduce un carattere
    public Character traduci(char c) {
        c = Character.toLowerCase(c);
        if (Character.isAlphabetic(c)) {
            int idx = ((int) c - 'a' + pos) % 26;

            return Character.toUpperCase(traduzione.get(idx));
        }
        return null;
    }

    public Character traduci_inverso(char c) {
        c = Character.toLowerCase(c);
        if (Character.isAlphabetic(c)) {
            int pos = 0;
            for (int i = 0; i < traduzione.size(); i++) {
                if (traduzione.get(i) == c) {
                    pos = i;
                    break;
                }
            }

            return (char) ('A' + pos);
        }
        return null;
    }

    // Ruota di n spazi il rotore
    public boolean ruota(int n) {
        this.pos += n;
        if (pos >= 26) {
            pos = pos % 26;
            return true;
        }
        return false;
    }

    //Ruota di 1 spazio
    public boolean ruota() {
        return ruota(1);
    }
}

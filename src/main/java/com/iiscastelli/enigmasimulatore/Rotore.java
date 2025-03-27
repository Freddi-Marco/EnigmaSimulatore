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
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c);
            int idx = ((int) c - 'A' + pos) % 26;

            int trad = traduzione.get(idx) - pos;
            if (trad < 'A')
                trad += 26;

            return Character.toUpperCase((char) trad);
        }
        return null;
    }

    public Character traduci_inverso(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c);
            for (int i = 0; i < traduzione.size(); i++) {
                if (traduzione.get(i) == c) {
                    i += pos;
                    if (i >= 26) {
                        i -= 26;
                    }
                    return (char) ('A' + i);
                }
            }
        }
        return null;
    }

    // Ruota di n spazi il rotore
    public boolean ruota(int n) {
        this.pos += n % 26;
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

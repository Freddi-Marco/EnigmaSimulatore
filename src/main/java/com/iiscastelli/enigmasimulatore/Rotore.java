package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class Rotore {
    ArrayList<Character> traduzione;
    int pos = 0;


    public Rotore(String traduzione, int pos) {
        this.traduzione = new ArrayList<>();
        for (int i = 0; i < traduzione.length(); i++) {
            this.traduzione.add(traduzione.charAt(i));
        }
        this.pos = pos % 26;
    }

    //Traduce un carattere
    public Character traduci(char c) {
        if (Character.isAlphabetic(c)) {

            int idx = ((int) c + pos - 'a') % 26;

            return Character.toUpperCase(traduzione.get(idx));
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

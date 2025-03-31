package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class Rotore {
    private int pos = 0;
    private int checkpoint;
    private ArrayList<Character> traduzione;

    String[] traduzioni_rotori = {
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
            "AJDKSIRUXBLHWTMCQGZNPYFVOE",
            "BDFHJLCPRTXVZNYEIWGAKMUSQO",
    };

    int[] checkpoints = {
            16,
            4,
            21,
    };

    public Rotore(int rot, int pos) {
        setRotore(rot);
        setPos(pos);
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
            c += pos;
            if (c > 'Z') {
                c -= 26;
            }
            for (int i = 0; i < traduzione.size(); i++) {
                if (traduzione.get(i) == c) {
                    i -= pos;
                    if (i < 0) {
                        i += 26;
                    }
                    return (char) ('A' + i);
                }
            }
        }
        return null;
    }

    // Ruota di n spazi il rotore
    public boolean ruota(int n) {
        int prev = pos;
        this.pos += n % 26;
        boolean rotate = prev <= checkpoint && pos > checkpoint;
        if (pos >= 26) {
            pos = pos % 26;
        }
        return rotate;
    }

    public void setRotore(int rot) {
        this.traduzione = new ArrayList<>();

        for (int i = 0; i < traduzioni_rotori[rot].length(); i++) {
            this.traduzione.add(traduzioni_rotori[rot].charAt(i));
        }

        this.checkpoint = checkpoints[rot];
    }

    public void setPos(int idx) {
        if (idx < 0) {
            idx += 26;
        }
        this.pos = idx % 26;
    }

    public char getPosChar() {
        return (char)('A' + pos);
    }

    public int getPos() {
        return pos;
    }

    //Ruota di 1 spazio
    public boolean ruota() {
        return ruota(1);
    }
}

package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;
import java.util.Collections;

public class Rotore {
    private ArrayList<Character> traduzione;
    int pos;

    public Rotore(String traduzione, int pos) {
        traduzione = traduzione.toLowerCase();
        this.traduzione = new ArrayList<>();
        for (char c : traduzione.toCharArray()) {
            this.traduzione.add(c);
        }
        this.pos = pos;
    }

    public Character traduci(char c) {
        int idx = Character.toLowerCase(c) - 'a';

        return (char)((traduzione.get((idx + pos)) - 'a' - pos + 26) % traduzione.size() + 'a');
    }

    public Character traduciContrario(char c) {
        int idx = (traduzione.indexOf(c) + pos) % traduzione.size();
        return (char) ('a' + idx);
    }

    public boolean ruota() {
        pos++;
        return traduzione.get(pos % traduzione.size()) == 'a';
    }
}

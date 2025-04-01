package com.iiscastelli.enigmasimulatore;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PannelloScambiatore {
    private ArrayList<Cavo> cavi = new ArrayList<Cavo>(6);
    private Cavo toAdd;

    public char scambia(char c) {
        char res = c;
        for (Cavo cavo : cavi) {
            res = cavo.scambia(c);
        }

        return res;
    }

    public void select(char c) {
        for (int i = 0; i < cavi.size(); i++) {
            if (cavi.get(i).selezionato(c)) {
                cavi.remove(i);
                i--;
                return;
            }
        }

        if (cavi.size() >= 6) {
            cavi.remove(cavi.size() - 1);
        }

        if (toAdd == null) {
            toAdd = new Cavo();
            toAdd.setFirst(c);
        } else {
            toAdd.setSecond(c);
            cavi.add(toAdd);
            toAdd = null;
        }
    }

    public int[] ritornaLayout() {
        int[] layout = new int[26];

        for (int i = 0; i < cavi.size(); i++) {
            layout[cavi.get(i).getFirst()-'A'] = i+1;
            layout[cavi.get(i).getSecond()-'A'] = i+1;
        }

        return layout;
    }
}

package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class GestioneRotori {
    ArrayList<Rotore> rotori;
    Riflessore riflessore;

    String[] traduzioni_rotori = {
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
            "AJDKSIRUXBLHWTMCQGZNPYFVOE",
            "BDFHJLCPRTXVZNYEIWGAKMUSQO",
    };

    public GestioneRotori(int pos1, int idx1, int pos2, int idx2, int pos3, int idx3, int idxRif) {
        rotori = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            rotori.add(new Rotore());
        }

        rotori.set(pos1, new Rotore(traduzioni_rotori[0], idx1));
        rotori.set(pos2, new Rotore(traduzioni_rotori[1], idx2));
        rotori.set(pos3, new Rotore(traduzioni_rotori[2], idx3));

        riflessore = new Riflessore(idxRif);
    }

    public Character codifica(char c) {
        Character res = c;
        boolean ruota_next = true;
        for (Rotore r : rotori) {
            if (ruota_next) {
                ruota_next = r.ruota();
            }
            res = r.traduci(res);
        }

        res = riflessore.lettera(res);

        for (int i = rotori.size() - 1; i >= 0; i--) {
            Rotore r = rotori.get(i);
            res = r.traduci_inverso(res);
        }

        return res;
    }

}
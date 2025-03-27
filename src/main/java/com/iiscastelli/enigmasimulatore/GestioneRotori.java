package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class GestioneRotori {
    private final ArrayList<Rotore> rotori;
    private final Riflessore riflessore;

    public GestioneRotori(int rot1, int idx1, int rot2, int idx2, int rot3, int idx3, int idxRif) {
        rotori = new ArrayList<>(3);

        rotori.add(new Rotore(rot1, idx1));
        rotori.add(new Rotore(rot2, idx2));
        rotori.add(new Rotore(rot3, idx3));

        riflessore = new Riflessore(idxRif);
    }

    public Character codifica(char c) {
        Character res = Character.toUpperCase(c);
        boolean ruota_next = true;

        for (int i = 0; i < 3; i++) {
            Rotore r = rotori.get(i);
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
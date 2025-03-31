package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;
import java.util.TreeMap;

public class GestioneRotori {
    private final ArrayList<Rotore> rotori;
    private final Riflessore riflessore;

    private static TreeMap<String, Integer> mappa_rotori;
    private static TreeMap<String, Integer> mappa_riflessore;

    public static String[] getRotoriLabels() {
        mappa_rotori = new TreeMap<>();
        mappa_rotori.put("I", 0);
        mappa_rotori.put("II", 1);
        mappa_rotori.put("III", 2);

        return mappa_rotori.keySet().toArray(new String[0]);
    }

    public static String[] getRiflessoreLabels() {
        mappa_riflessore = new TreeMap<>();
        mappa_riflessore.put("A", 0);
        mappa_riflessore.put("B", 1);
        mappa_riflessore.put("C", 2);

        return mappa_riflessore.keySet().toArray(new String[0]);
    }

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

        res = riflessore.codifica(res);

        for (int i = rotori.size() - 1; i >= 0; i--) {
            Rotore r = rotori.get(i);
            res = r.traduci_inverso(res);
        }

        return res;
    }

    public void setRotore(int i, String rot) {
        if (i >= 0 && i <= 2) {
            rotori.get(i).setRotore(mappa_rotori.get(rot));
        } else if (i == 3) {
            riflessore.setRiflessore(mappa_riflessore.get(rot));
        }
    }

    public void setPosRotore(int i, int pos) {
        if (i >= 0 && i <= 2) {
            rotori.get(i).setPos(pos);
        }
    }

}
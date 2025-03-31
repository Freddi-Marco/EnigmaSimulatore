package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class Riflessore {
    private ArrayList<Character> traduzione;
    final static private String[] riflessori = {
            "EJMZALYXVBWFCRQUONTSPIKHGD",
            "YRUHQSLDPXNGOKMIEBFZCWVJAT",
            "FVPJIAOYEDRZXWGCTKUQSBNMHL"
    };

    public Riflessore(int n) {
        this.traduzione = new ArrayList<>();
        setRiflessore(n);
    }

    // imposta il riflessore in base al numero del rotore, converte la stringa in un array di caratteri e aggiunge le posizioni numeriche delle lettere all'array
    public void setRiflessore(int n) {
        traduzione = new ArrayList<>();
        for (char c : riflessori[n].toCharArray()) {
            traduzione.add(c);
        }
    }

    // prende un carattere c, trova la posizione riflessa nel riflessore e restituisce il carattere corrispondente
    public Character codifica(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c);
            return traduzione.get(c - 'A');
        }
        return null;
    }
}

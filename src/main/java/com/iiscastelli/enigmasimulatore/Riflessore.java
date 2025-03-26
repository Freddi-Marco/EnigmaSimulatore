package com.iiscastelli.enigmasimulatore;

import java.util.ArrayList;

public class Riflessore {
    private final ArrayList<Character> riflessore;

    public Riflessore(int n) {
        this.riflessore = new ArrayList<>();
        codifica(n);
    }

    private void codifica(int n) { // imposta il riflessore in base al numero del rotore, converte la stringa in un array di caratteri e aggiunge le posizioni numeriche delle lettere all'array
        String[] riflessori = {
                "EJMZALYXVBWFCRQUONTSPIKHGD",
                "YRUHQSLDPXNGOKMIEBFZCWVJAT",
                "FVPJIAOYEDRZXWGCTKUQSBNMHL"
        };
        for (char c : riflessori[n].toCharArray()) {
            riflessore.add(c);
        }
    }

    // prende un carattere c, trova la posizione riflessa nel riflessore e restituisce il carattere corrispondente
    public Character lettera(char c) {
        if (Character.isLetter(c)) {
            c = Character.toUpperCase(c);
            return riflessore.get(c - 'A');
        }
        return null;
    }
}

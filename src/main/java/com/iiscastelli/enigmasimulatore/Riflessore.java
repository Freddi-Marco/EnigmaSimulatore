package com.iiscastelli.enigmasimulatore;

public class Riflessore {
    private String riflessore;

    public Riflessore(String s){
        this.riflessore = s;
    }

    public char riflette(char c){
        int pos = c- 'A';
        return riflessore.charAt(pos);
    }
}

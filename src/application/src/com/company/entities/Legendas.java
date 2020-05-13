package com.company.entities;


public class Legendas {

    private String tempoFormato;
    private int delay;
    private int total;

    public Legendas(String tempoFormato, int delay){
        this.tempoFormato = tempoFormato;
        this.delay = delay;

        int hor = Integer.parseInt(tempoFormato.substring(0,2))*60*60*1000;
        int min = Integer.parseInt(tempoFormato.substring(3,5))*60*1000;
        int seg = Integer.parseInt(tempoFormato.substring(6,8))*1000;
        int ms  = Integer.parseInt(tempoFormato.substring(9));

        int total = hor + min + seg + ms + this.delay;
        this.total = total;
    }

    public String atualizar(){
        int hor = this.total/(3600*1000);
        int tot = this.total - hor*(3600*1000);
        int min = tot/(60*1000);
        tot = tot - (min * (60 * 1000));
        int seg = tot/1000;
        int ms = this.total%1000;
        return (String.format("%02d", hor))+":"
                +(String.format("%02d", min))+":"
                +(String.format("%02d", seg))+","
                +Integer.toString(ms);
    }
}

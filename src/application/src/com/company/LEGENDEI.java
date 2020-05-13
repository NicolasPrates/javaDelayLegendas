package com.company;


import java.io.*;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import com.company.entities.Legendas;

import static java.nio.charset.StandardCharsets.UTF_8;


public class LEGENDEI {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Coloque a legenda na mesma pasta do programa e escreva o nome da mesma aqui: ");

        String nomeDaLegenda = sc.nextLine ();


        System.out.println("Entre com o delay em milisegundos: ");
        int delay = sc.nextInt();

        String caminhoSource = ".\\" + nomeDaLegenda + ".srt";

        String targetFileStr =  ".\\" + nomeDaLegenda + "Modified.srt";

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(caminhoSource), "ISO-8859-1"))) {


            String getTempo = br.readLine();

            try (BufferedWriter bw = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream(targetFileStr), UTF_8))) {

                while (getTempo != null) {
                    if (getTempo.contains(" --> ")) {
                        Legendas leg1 = new Legendas(getTempo.substring(0, 12), delay);
                        Legendas leg2 = new Legendas(getTempo.substring(17, 29), delay);
                        bw.write(leg1.atualizar() + " --> " + leg2.atualizar() + "\n");
                    } else {
                        bw.write(getTempo + "\n");
                    }
                    getTempo = br.readLine();
                }

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println ( "Error reading file: " + e.getMessage () );
        }
        sc.close();
    }
}


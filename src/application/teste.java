package application;


import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Legendas;

import static java.nio.charset.StandardCharsets.UTF_8;


public class teste {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        System.out.println("Entre com o delay em milisegundos: ");
        int delay = sc.nextInt();

        File sourceFile = new File("c:\\Users\\monitora\\CursoUdemy\\legenda.srt");

        String targetFileStr =  "c:\\Users\\monitora\\CursoUdemy\\saida.srt";

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("c:\\Users\\monitora\\CursoUdemy\\legenda.srt"), "ISO-8859-1"))) {


            String getTempo = br.readLine();

            try (BufferedWriter bw = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream("c:\\Users\\monitora\\CursoUdemy\\saida.srt"), UTF_8))) {

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
            System.out.println("Error reading file: " + e.getMessage());
        }
        sourceFile.renameTo ( new File ( targetFileStr ) );
        sc.close();
    }
}


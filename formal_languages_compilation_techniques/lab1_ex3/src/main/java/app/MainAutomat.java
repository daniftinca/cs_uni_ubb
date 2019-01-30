package app;

import service.FileHandlerService;
import service.automate.AutomatFinit;

import java.io.IOException;

public class MainAutomat {
    public static void main(String[] args) {
        FileHandlerService fileHandlerService = new FileHandlerService();
        try {
            AutomatFinit automatFinit = fileHandlerService.readFromJson(".\\assets\\afConst.json");
            System.out.println(automatFinit.toString());

            System.out.println("Lista de stari finale:");
            automatFinit.getFinalStates().forEach(item -> System.out.println(item.getName()));


            System.out.println("Alfabetul: ");
            System.out.println(automatFinit.getAlphabet());


            String sequence = "3333.1254...415";
            try {
                //System.out.println("Accepted: "+automatFinit.accepts(sequence));
                System.out.println("Longest accepted prefix of sequence: "+automatFinit.getLongestAcceptedPrefix(sequence));
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

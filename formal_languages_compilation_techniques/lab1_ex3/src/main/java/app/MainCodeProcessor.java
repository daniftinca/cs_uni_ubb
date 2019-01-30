package app;

import javafx.util.Pair;
import service.FileHandlerService;
import service.automate.AutomatFinit;
import service.processing.CodeProcessor;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 * MainCodeProcessor part of the program
 */
public class MainCodeProcessor {

    public static void main(String[] args) {
        System.out.println("Program Start...");
        FileHandlerService fileHandlerService = new FileHandlerService();
        try {
            CodeProcessor codeProcessor = new CodeProcessor();
            AutomatFinit afConst = fileHandlerService.readFromJson(".\\assets\\afConst.json");
            AutomatFinit afId = fileHandlerService.readFromJson(".\\assets\\afID.json");
            codeProcessor.setAutomatConst(afConst);
            codeProcessor.setAutomatId(afId);
            codeProcessor.analyzeCode(".\\assets\\cerc.js");
            Hashtable<String, Integer> codeProcessorTsConst = codeProcessor.getTsConst();
            Hashtable<String, Integer> codeProcessorTsId = codeProcessor.getTsID();
            List<Pair<String, String>> codeProcessorFip = codeProcessor.getFip();
            System.out.println("TSConst: ");
            System.out.println(codeProcessorTsConst.toString());
            System.out.println("TSId: ");
            System.out.println(codeProcessorTsId.toString());
            System.out.println("Fip: ");
            codeProcessorFip.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

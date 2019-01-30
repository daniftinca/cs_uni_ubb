package service.processing;

import javafx.util.Pair;
import service.FileHandlerService;
import service.automate.AutomatFinit;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class which contains methods for grammar validation
 */
public class CodeProcessor {

    private static final String ATOM_FILE = ".\\assets\\atom.properties";
    private Map<String, Integer> atomMap = new HashMap<String, Integer>();
    private FileHandlerService fileHandlerService = new FileHandlerService();
    private Properties prop = new Properties();
    private Hashtable<String, Integer> tsConst = new Hashtable<>();
    private Hashtable<String, Integer> tsID = new Hashtable<>();
    private Integer currentTsConst = 0;
    private Integer currentTsId = 0;
    private List<Pair<String, String>> fip = new ArrayList<>();
    private int currenLineNr = 0;
    private AutomatFinit automatId;
    private AutomatFinit automatConst;

    public AutomatFinit getAutomatId() {
        return automatId;
    }

    public void setAutomatId(AutomatFinit automatId) {
        this.automatId = automatId;
    }

    public AutomatFinit getAutomatConst() {
        return automatConst;
    }

    public void setAutomatConst(AutomatFinit automatConst) {
        this.automatConst = automatConst;
    }

    /**
     * The class initializes its Atoms from the properties file located in the assets directory.
     *
     * @throws IOException
     */
    public CodeProcessor() throws IOException {
        prop.load(new FileInputStream(ATOM_FILE));
    }

    /**
     * A method which takes a file and analyzes the code, populating the FIP and TSs.
     *
     * @param fileName name of the file to be analyzed
     * @throws IOException
     */
    public void analyzeCode(String fileName) throws Exception {
        /*
         - string din fisier. linie cu linie
         - while (linia are caractere):
         - cel mai lung prefix acceptat de automatul de iduri.
            - daca e >0:
                - verificam daca e cuv rezervat
                    -da: il tratam ca pe un cuv rezervat
                    -nu: il tratam ca pe un id
            - daca e = 0:
                - cel mai lung prefix de la automatul de constante
                - daca e > 0:
                    verificam daca urmat caracter este spatiu sau caract rezervat sau eol
                    il tratam ca pe o constanta
                - daca nu:
                    - luam un caracter, verificam cu lista de caractere acceptate
                    daca da:
                        - tratam ca atare
                    daca e spatiu:
                        ignore
                    else :
                        eroare
            - taiem stringul prelucrat din linie
         */



//
        List<String> lines = fileHandlerService.readFromFile(fileName);
//        System.out.println("Now parsing " + fileName);
//        lines.forEach(line -> {
//            currenLineNr++;
//            List<String> tokens = getTokens(line);
//            fixTokens(tokens);
//            tokens.forEach(token -> {
//                String tokenId = prop.getProperty(token);
//                addCorresponding(token, tokenId, currenLineNr);
//            });
//        });
        int cutIndex = -1;
        int endIndex = -1;
        boolean hasError = false;
        int lineIndex = 0;
        for (String line : lines) {
            lineIndex++;
            while (line.length() > 0) {

                String automatIdResult = automatId.getLongestAcceptedPrefix(line);

                if (automatIdResult.length() > 0) {
                    cutIndex = automatIdResult.length();

                    if (prop.containsKey(automatIdResult)) {//daca e ceva predefinit
                        fip.add(new Pair<>(prop.getProperty(automatIdResult), "-"));

                    } else {//daca e id
                        //BigInteger idValue = convertStringToAscii(automatIdResult);
                        if (!tsID.containsKey(automatIdResult)) {
                            tsID.put(automatIdResult, currentTsId);

                            currentTsId++;
                        }
                        fip.add(new Pair<>("1", tsID.get(automatIdResult).toString()));
                    }
                } else {// automat const
                    String automatConstResult = automatConst.getLongestAcceptedPrefix(line);
                    cutIndex = automatConstResult.length();
                    if (automatConstResult.length() > 0) {
                        if (prop.containsKey(automatConstResult)) {//daca e ceva predefinit
                            fip.add(new Pair<>(prop.getProperty(automatConstResult), "-"));
                        } else {//daca e const
                            //BigInteger constValue = convertStringToAscii(automatConstResult);
                            if (!tsConst.containsKey(automatConstResult)) {
                                tsConst.put(automatConstResult, currentTsConst);
                                currentTsConst++;
                            }
                            fip.add(new Pair<>("2", tsConst.get(automatConstResult).toString()));
                        }

                    } else {
                        if (line.charAt(0) != ' ') {
                            if (line.length() > 1) {
                                if (prop.containsKey(Character.toString(line.charAt(0)) + Character.toString(line.charAt(1)))) {
                                    fip.add(new Pair<>(prop.getProperty(Character.toString(line.charAt(0)) + Character.toString(line.charAt(1))), "-"));
                                } else if (prop.containsKey(Character.toString(line.charAt(0)))) {//daca e ceva predefinit
                                    fip.add(new Pair<>(prop.getProperty(Character.toString(line.charAt(0))), "-"));

                                } else {
                                    fip.add(new Pair<>("error", "Error at line " + lineIndex + ": " + line));
                                    hasError = true;
                                    break;
                                }
                            } else {
                                if (prop.containsKey(Character.toString(line.charAt(0)))) {//daca e ceva predefinit
                                    fip.add(new Pair<>(prop.getProperty(Character.toString(line.charAt(0))), "-"));

                                } else {
                                    fip.add(new Pair<>("error", "Error at line " + lineIndex + ": " + line));
                                    hasError = true;

                                    break;
                                }
                            }
                        }
                        cutIndex = 1;

                    }
                }
                endIndex = line.length();
                line = line.substring(cutIndex, endIndex);
            }
            if (hasError) {

                break;
            }
        }



    }

    /**
     * Handles the conditions and adds the tokens to their respective sets.
     *
     * @param token   token to add
     * @param tokenId tokenID
     * @param lineNr  The line nr. at which the token is located in the file.
     */
    private void addCorresponding(String token, String tokenId, int lineNr) {
        if (tokenId == null) {
            if (isConst(token)) {
                if (!tsConst.containsKey(token)) {
                    tsConst.put(token, currentTsConst);
                    currentTsConst++;
                }
                fip.add(new Pair<>("2", tsConst.get(token).toString()));
            } else {
                if (token.contains(".")) {
                    List<String> ids = Arrays.asList(token.split("\\."));
                    ids.forEach(this::addId);
                } else {
                    addId(token);
                }
            }
        } else {
            fip.add(new Pair<>(tokenId, "-"));
        }
    }

    /**
     * Handles validating and adding the id token in the corresponding sets
     *
     * @param token Id token to handle
     */
    private void addId(String token) {
        if (isValidId(token)) {
            if (!tsID.containsKey(token)) {
                tsID.put(token, currentTsId);
                currentTsId++;
            }
            fip.add(new Pair<>("1", tsID.get(token).toString()));

        } else {
            fip.add(new Pair<>("1", "ID is not valid at line " + currenLineNr));
        }
    }

    /**
     * Checks if the ID token is valid.
     *
     * @param toTest Id token to test
     * @return true or false
     */
    private boolean isValidId(String toTest) {
        return toTest.matches("(^(_|[a-z]|[A-Z])(_|[a-zA-Z.0-9])+$)|(^([a-z]|[A-Z])+$)") && toTest.length() <= 250;
    }

    /**
     * Checks if the const token is valid.
     *
     * @param toTest const token to test
     * @return true or false
     */
    private boolean isConst(String toTest) {
        return toTest.matches("(^[\"'][\\w ]*[\"']$)|(^[0-9]+$)|(^[0-9]+.[0-9]+$)");
    }


    /**
     * Checks the tokens for double operators. (eg ==, >=,...) and fixes them accordingly.
     *
     * @param tokens
     */
    private void fixTokens(List<String> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("=")) {
                if (tokens.get(i + 1).equals("=")) {
                    if (tokens.get(i + 2).equals("=")) {
                        tokens.set(i, "===");
                        tokens.remove(i + 1);
                        tokens.remove(i + 1);
                    } else {
                        tokens.set(i, "==");
                        tokens.remove(i + 1);
                    }
                }
            } else if (tokens.get(i).equals("<")) {
                if (tokens.get(i + 1).equals("=")) {
                    tokens.set(i, "<=");
                    tokens.remove(i + 1);
                }
            } else if (tokens.get(i).equals(">")) {
                if (tokens.get(i + 1).equals("=")) {
                    tokens.set(i, ">=");
                    tokens.remove(i + 1);
                }
            }
            if(tokens.get(i).startsWith("\"")&&!tokens.get(i).equals("\"\"")){
               tokens.set(i,tokens.get(i)+" ");
                while(!tokens.get(i).endsWith("\"")){
                    tokens.set(i,tokens.get(i)+" "+tokens.get(i+1));
                    tokens.remove(i+1);
                }

                tokens.set(i, tokens.get(i).replaceAll("( )+", " "));
            }
        }
    }


    /**
     * Parses a line to extract the tokens.
     *
     * @param line string to be parsed
     * @return a list of strings representing the extracted tokens
     */
    private List<String> getTokens(String line) {
        return Arrays
                .asList(line.split("(?<=(===)|[\\<\\>\\,\\;\\=\\-\\+\\/\\*\\(\\)\\[\\] ])|(?=(===)|[\\<\\>\\,\\;\\=\\-\\+\\/\\*\\(\\)\\[\\] ])"))
                .stream()
                .map(word -> {
                    String regex = "^\\s+";
                    return word.replaceAll(regex, "");
                })
                .filter(word -> !word.equals(""))
                .collect(Collectors.toList());
    }

    public Hashtable<String, Integer> getTsConst() {
        return tsConst;
    }

    public void setTsConst(Hashtable<String, Integer> tsConst) {
        this.tsConst = tsConst;
    }

    public Hashtable<String, Integer> getTsID() {
        return tsID;
    }

    public void setTsID(Hashtable<String, Integer> tsID) {
        this.tsID = tsID;
    }

    public List<Pair<String, String>> getFip() {
        return fip;
    }

    public void setFip(List<Pair<String, String>> fip) {
        this.fip = fip;
    }
}

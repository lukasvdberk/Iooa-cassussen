package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class  TextFileUtilities {
    public static ArrayList<String> leesRuweTekst(String bestandLocatie) throws Exception {
        File file = new File(bestandLocatie);

        BufferedReader br = new BufferedReader(new FileReader(file));

        ArrayList<String> regels = new ArrayList<String>();

        String huidigeRegel = br.readLine();
        while (huidigeRegel != null) {
            regels.add(huidigeRegel);
            huidigeRegel = br.readLine();
        }
        return regels;
    }

    public static String opSchonenenWoord(String woord) {

        String[] charactersToRemove = {" ", "?", "!", ".", ",", ";", ";", "","(", ")", "[", "]", "@", "$", "%", "/", "*", "&", "^", "#", "-", "+", "_", "=", "'", "\"", ">", "<"};

        for(String characterToRemove: charactersToRemove) {
            woord = woord.replace(characterToRemove, "");
        }
        return  woord.toLowerCase();
    }

    public static void schrijfWoordFrequentieNaarFile(HashMap<String, Integer> frequentieWoorden, String bestandLocatie) throws IOException {
        // Sluit de file automatische
        try (PrintWriter fileWriter = new PrintWriter(bestandLocatie)) {
            for (String woord : frequentieWoorden.keySet()) {
                fileWriter.write(woord + ":" + frequentieWoorden.get(woord) + "\n");
            }
        }
    }
}
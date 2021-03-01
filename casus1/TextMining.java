package casus1;

import java.util.ArrayList;
import java.util.HashMap;

public class TextMining {

    public static void main(String[] args) throws Exception {
        ArrayList<String> regels = TextFileUtilities.leesRuweTekst("dirk.txt");

        HashMap<String, Integer> word2frequency = new HashMap<String, Integer>();

        for(String regel: regels) {
            for(String woord: regel.split(" ")) {
                woord = TextFileUtilities.opSchonenenWoord(woord);

                if(!woord.equals("")) {
                    if(!word2frequency.containsKey(woord)) {
                        word2frequency.put(woord, 1);
                    } else {
                        int aantal = word2frequency.get(woord);

                        // Replace the previous word with the new counter
                        word2frequency.remove(woord);
                        aantal+= 1;
                        System.out.println(aantal);
                        word2frequency.put(woord, aantal);
                    }
                }
            }
        }

        for (String woord : word2frequency.keySet()) {
            System.out.println(woord + ":" + word2frequency.get(woord));
        }
        TextFileUtilities.schrijfWoordFrequentieNaarFile(word2frequency, "results.txt");
    }
}

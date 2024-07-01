package AliounePackage;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Main keepThis = new Main();
        String[] deckJosh = new String[]{"T","8"};
        String[] deckSteve = new String[]{"T","9"};
//        keepThis.whoWins(deckJosh,deckSteve);
        System.out.println(keepThis.whoWins(deckJosh, deckSteve));
    }

    public String whoWins(String[] deckJosh, String[] deckSteve) {
        List<Integer> parseForSteve = new ArrayList<>();
        List<Integer> parseForJosh = new ArrayList<>();
        int value = 0;
        for (int i = 0; i < deckSteve.length; i++) {
            switch (deckSteve[i]) {
                case "T":
                    value = 10;
                    parseForSteve.add(value);
                    break;
                case "J":
                    value = 11;
                    parseForSteve.add(value);
                    break;
                case "Q":
                    value = 12;
                    parseForSteve.add(value);
                    break;
                case "K":
                    value = 13;
                    parseForSteve.add(value);
                    break;
                case "A":
                    value = 14;
                    parseForSteve.add(value);

                    break;

            }
            if (deckSteve[i].contains("T") || deckSteve[i].contains("J") || deckSteve[i].contains("Q") || deckSteve[i].contains("K") || deckSteve[i].contains("A")) {
                continue;
            } else {
                int parseValue = Integer.valueOf(deckSteve[i]);
                parseForSteve.add(parseValue);
            }
        }
        for (int i = 0; i < deckJosh.length; i++) {
            switch (deckJosh[i]) {
                case "T":
                    value = 10;
                    parseForJosh.add(value);
                    break;
                case "J":
                    value = 11;
                    parseForJosh.add(value);
                    break;
                case "Q":
                    value = 12;
                    parseForJosh.add(value);
                    break;
                case "K":
                    value = 13;
                    parseForJosh.add(value);
                    break;
                case "A":
                    value = 14;
                    parseForJosh.add(value);

            }
            if (deckJosh[i].contains("T") || deckJosh[i].contains("J") || deckJosh[i].contains("Q") || deckJosh[i].contains("K") || deckJosh[i].contains("A")) {
                continue;
            } else {
                int parseValueAgain = Integer.valueOf(deckJosh[i]);
                parseForJosh.add(parseValueAgain);
            }
        }

        int countForJosh = 0;
        int countForSteve = 0;
        for (int i = 0; i < parseForJosh.size(); i++) {
            if (parseForJosh.get(i) > parseForSteve.get(i)) {
                countForJosh += 1;
            }
            if (parseForJosh.get(i) < parseForSteve.get(i)) {
                countForSteve += 1;
            }
        }
        if (countForJosh > countForSteve) {
            String parseDamnJosh = String.valueOf(countForJosh);
            String parseDamnSteve = String.valueOf(countForSteve);
            return "Josh wins " + parseDamnJosh + " to " + parseDamnSteve;
        }
        if (countForSteve > countForJosh) {
            String parseAwaysteve = String.valueOf(countForSteve);
            String parseAwayWontYou = String.valueOf(countForJosh);
            return "Steve wins " + parseAwaysteve + " to " + parseAwayWontYou;
        }

        return "Tie";
    }
}




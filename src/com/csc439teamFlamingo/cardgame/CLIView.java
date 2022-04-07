package com.csc439teamFlamingo.cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements the View interface's abstract methods for command line interactions between the user and the game.
 */

public class CLIView implements View {

    @Override
    public int displayTitleScreenAndGetPlayerCount() throws IllegalArgumentException {
        System.out.println("\n" +
                "\n" +
                ".------..------..------..------.\n" +
                "|G.--. ||O.--. ||L.--. ||F.--. |\n" +
                "| :/\\: || :/\\: || :/\\: || :(): |\n" +
                "| :\\/: || :\\/: || (__) || ()() |\n" +
                "| '--'G|| '--'O|| '--'L|| '--'F|\n" +
                "`------'`------'`------'`------'\n" +
                "\n");
        try {
            String numPlayers = getUserInput("How many players: ");
            if(numPlayers == null) {
                throw new IllegalArgumentException("ERROR: NOTHING ENTERED IN NUMBER OF PLAYERS");
            }
            for(int x = 0; x < numPlayers.length(); x++) {
                if(Character.isAlphabetic(numPlayers.charAt(x))) {
                    throw new IllegalArgumentException("ERROR: NUMBER OF PLAYERS MUST BE A NUMBER");
                }
            }
            if(Integer.parseInt(numPlayers) < 0) {
                throw new IllegalArgumentException("ERROR: NEGATIVE NUMBER OF PLAYERS PROVIDED");
            }
            return Integer.parseInt(numPlayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String getUserInput(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}

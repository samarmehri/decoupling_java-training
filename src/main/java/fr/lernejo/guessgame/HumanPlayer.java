package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Entrez une réponse");
        long answer = Long.parseLong(this.scanner.nextLine());
        this.logger.log("Player answer : " + answer);
        return answer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            this.logger.log("la solution est plus petit");
        }
        else{
            this.logger.log("la solution est plus grand");
        }
    }

}

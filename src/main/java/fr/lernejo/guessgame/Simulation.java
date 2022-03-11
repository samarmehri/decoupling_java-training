
package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long numPlayerAsk = this.player.askNextGuess();
        if (numPlayerAsk == this.numberToGuess) {
            this.logger.log("Player find number");
            return true;
        }
        this.player.respond(numPlayerAsk > this.numberToGuess);
        this.logger.log("Player didn't find the number");
        return false;
    }

    public void loopUntilPlayerSucceed(long maxLoop) {
        boolean end;
        long timeBegin = System.currentTimeMillis();
        do {
            end = this.nextRound();
            maxLoop--;
        } while (!end && maxLoop > 0);
        long timeEnd = System.currentTimeMillis();
        SimpleDateFormat f = new SimpleDateFormat("mm:ss:SSS");
        String time = f.format(timeEnd - timeBegin);
        if (end) {
            this.logger.log("Fin de partie, gagné en " + time);
        } else {
            this.logger.log("Fin de partie, perdu en " + time);
        }

    }
}

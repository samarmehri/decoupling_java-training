package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("computer");
    private boolean higher;
    private long min;
    private long max;
    private long guess;
    public ComputerPlayer(Long parseLong) {
        higher = false;
        min = -1;
        max = parseLong;
        guess = 0;
    }


    @Override
    public long askNextGuess() {
        if (this.min == -1L) {
            this.guess = this.max / 2;
            this.min = 0;
        }
        else {
            this.min = !this.higher ? guess : this.min;
            this.max = this.higher ? guess : this.max;
            guess = (this.min + this.max) / 2;
        }

        this.logger.log("Answer : " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.higher = lowerOrGreater;
        if (lowerOrGreater) {
            this.logger.log("la solution est plus petit");
        }
        else{
            this.logger.log("la solution est plus grand");
        }
    }

}

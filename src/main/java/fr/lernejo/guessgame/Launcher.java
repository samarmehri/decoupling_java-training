package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        long maxLoop = 0;
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        Simulation simulation = null;
        if (args[0].equals("-interactive")) {
            simulation = new Simulation(new HumanPlayer());
            maxLoop = Long.MAX_VALUE;

            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(maxLoop);
        }
        else if (args[0].equals("-auto")) {
            simulation = new Simulation(new ComputerPlayer(Long.parseLong((args[1]))));
            maxLoop = 1000;
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(maxLoop);
        }
        else {
            System.out.println("Veuillez choisir entre -interactive ou -auto");
        }
    }
}

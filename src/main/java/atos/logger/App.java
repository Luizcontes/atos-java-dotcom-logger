package src.main.java.atos.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws IOException{

        final Logger logger = Logger.getLogger("LogApp");
        logger.setLevel(Level.ALL);
        
        // console logger
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        // file logger
        FileHandler fh = new FileHandler("myLogger.log", true);
        fh.setLevel(Level.ALL);
        logger.addHandler(fh);


        logger.info("Program started!!!");

        int randomNum = (int) (Math.random() * 5);
        int[] locations = { randomNum, randomNum + 1, randomNum + 2 };

        int y = 0;
        int[] guessesUsed = new int[10];

        String result1 = "miss";

        SimpleDotCom theDotCom = new SimpleDotCom();

        theDotCom.setLocationCells(locations);

        int numOfGuesses = 0;
        boolean isAlive = true;

        GameHelper helper = new GameHelper();

        while (isAlive == true) {
            
            String guess = "";

            try {
                guess = helper.getUserInput("\nEnter a number:");
            } catch (Exception e) {
                logger.warning("Number in a wrong format" + e.getStackTrace());
            }
            
            int check = Integer.parseInt(guess);
            theDotCom.setguessesUsed(guessesUsed);
            String cCheck = theDotCom.checkGuesses(guess);

            if (cCheck.equals("Number chosen alredy")) {

                System.out.println(cCheck);

            } else {

                guessesUsed[y] = check;
                String result = theDotCom.checkYourself(guess);
                result1 = result;
                numOfGuesses++;
                y++;

            }

            if (result1.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }

    }

}

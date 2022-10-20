package src.main.java.atos.logger;

public class SimpleDotCom {

    int[] locationCells;
    int numOfHits = 0;
    int y = 0;

    int[] guessesUsed;

    public void setguessesUsed(int[] gu) {
        guessesUsed = gu;
    }

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkGuesses(String stringCheckGuesses) {

        int check = Integer.parseInt(stringCheckGuesses);        

        String alredyUsed = "none";

        for (int cell1 : guessesUsed) {

            if (check == cell1) {

                alredyUsed = "Number chosen alredy";  
                
                break;
                          
            } 
            
        }

        System.out.println(guessesUsed[0]);
        
        
        return alredyUsed;
    }

    public String checkYourself(String stringGuess) {

        int guess = Integer.parseInt(stringGuess);
        
        String result = "miss";

        for (int cell : locationCells) {

            if (guess == cell) {

                result = "hit";

                numOfHits++;

                break;
            }
        }

        if (numOfHits == locationCells.length) {

            result = "kill";

        }

        System.out.println(result);

        return result;

    }
}
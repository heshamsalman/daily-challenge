import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshamsalman on 10/20/15.
 * REQUIRES Java 1.8
 * (I'm using the new stream APIs & lambdas)
 *
 * Make sure to set the HOLD_VALUES parameter to the values that the AI player should hold at. It can take as many
 * arguments as you'd like to give it, but be aware that the game is played with ONLY ONE DECK. If the number of
 * parameters is too high, the deck will draw-out and the program will crash. A responsible maximum number of parameters
 * is 6 or 7.
 */
public class PlayBlackjack {
    private static final int MAX_ITERATIONS = 1000;
    private static final int[] HOLD_VALUES = {17, 18, 19, 20}; // Set the values for each player to stop at
    private static final int NUMBER_OF_PLAYERS = HOLD_VALUES.length; // in addition to the dealer

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack(HOLD_VALUES);
        List<HandState[]> simulationResults = new ArrayList<>();
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            HandState[] gameResults = blackjack.playGame();
            simulationResults.add(gameResults);
        }

        printPlayerRatings(simulationResults);
    }

    /**
     * Prints the results of the simulation for each player
     * @param simulationResults
     */
    private static void printPlayerRatings(List<HandState[]> simulationResults) {
        //Evaluate Each Player's Wins, Losses, and Ties
        for (int player = 0; player < NUMBER_OF_PLAYERS; player++) {
            System.out.printf("Player %d:\n", player+1);
            System.out.printf("Holds at %d\n", HOLD_VALUES[player]);
            int winCount = 0;
            int loseCount = 0;
            int drawCount = 0;

            for (HandState[] gameResults : simulationResults) {
                HandState state = gameResults[player];
                switch (state) {
                    case WIN:
                        winCount++;
                        break;
                    case LOSE:
                        loseCount++;
                        break;
                    case DRAW:
                        drawCount++;
                        break;
                }
            }

            double winRate = (double) winCount / MAX_ITERATIONS * 100;
            double loseRate = (double) loseCount / MAX_ITERATIONS * 100;
            double drawRate = (double) drawCount / MAX_ITERATIONS * 100;

            System.out.printf("Win Rate: %.2f\n", winRate);
            System.out.printf("Draw Rate: %.2f\n", drawRate);
            System.out.printf("Lose Rate: %.2f\n", loseRate);
            System.out.println();
        }
    }
}

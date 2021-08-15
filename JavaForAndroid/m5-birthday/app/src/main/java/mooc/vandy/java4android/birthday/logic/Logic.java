package mooc.vandy.java4android.birthday.logic;

import android.util.Log;

import java.util.*;
import java.util.Random;

import mooc.vandy.java4android.birthday.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
     */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.println("Error: Group Size must be in the range 2-365.");
            return;
        }
        if (!(simulationCount >= 1 && simulationCount <= 100000)) {
            mOut.println("Error: Simulation Count must be in the range 1-100000.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage "
                + " of times that two people share the same birthday is "
                + String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        // TODO -- add your code here
        int numOfBirthdayMatch = 0;
        for (int i = 1; i <= count; i++) {
            Random rand = new Random();
            rand.setSeed(i);
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j <= size; j++) {
                int birthday = rand.nextInt(365);
                if (hasDuplicate(list, birthday)) {
                    list.add(birthday);
                    numOfBirthdayMatch += 1;
                    break;
                } else {
                    list.add(birthday);
                }
            }
        }
        double percent = (double)(numOfBirthdayMatch * 100) / count;
        return percent;

    }

    // TODO -- add your helper methods here
    // Helper function that counts the occurrences of a number
    public static boolean hasDuplicate(List<Integer> list, int num) {
        for (int el: list) {
            if (el == num) {
               return true;
            }
        }
        return false;
    }
    
}

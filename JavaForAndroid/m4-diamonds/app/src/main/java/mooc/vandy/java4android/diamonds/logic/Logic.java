package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
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
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        frameLine(size);
        mOut.print("\n");
        for (int i = 1; i < size; i++) {
            topHalf(size, i);
        }
        middleLine(size);
        for (int i = size + 1; i < 2 * size; i++) {
            bottomHalf(size, i);
        }
        frameLine(size);
    }

    // TODO -- add any helper methods here
    // Helper method that prints the frame line
    public void frameLine(int size) {
        mOut.print("+");
        for (int i = 1; i <= 2 * size; i++) {
            mOut.print("-");
        }
        mOut.print("+");
    }

    // Helper method that prints the top half of the art

    public void topHalf(int size, int line) {
        mOut.print("|");
        if (line % 2 == 0) {
            for (int i = 1; i < size - line + 1; i++) {
                mOut.print(" ");
            }
            mOut.print("/");
            for (int i = 1; i <= 2 * line - 2; i++) {
                mOut.print("-");
            }
            mOut.print("\\");
            for (int i = size + line + 1; i <= 2 * size; i++) {
                mOut.print(" ");
            }
        }
        else if (line % 2 == 1) {
            for (int i = 1; i < size - line + 1; i++) {
                mOut.print(" ");
            }
            mOut.print("/");
            for (int i = 1; i <= 2 * line - 2; i++) {
                mOut.print("=");
            }
            mOut.print("\\");
            for (int i = size + line + 1; i <= 2 * size; i++) {
                mOut.print(" ");
            }
        }
        mOut.print("|\n");
    }

    // Helper method that prints the middle line of the art
    public void middleLine(int line) {
        mOut.print("|<");
        for (int i = 1; i <= 2 * line - 2; i++) {
            if (line % 2 == 0) {
                mOut.print("-");
            } else {
                mOut.print("=");
            }
        }
        mOut.print(">|\n");
    }

    // Helper method that prints the bottom half of the art
    public void bottomHalf(int size, int line) {
        mOut.print("|");
        if (line % 2 == 0) {
            for (int i = 1; i <= line - size; i++) {
                mOut.print(" ");
            }
            mOut.print("\\");
            for (int i = 1; i <= 4 * size - 2 * line - 2; i++) {
                mOut.print("-");
            }
            mOut.print("/");
            for (int i = 1; i <= line - size; i++) {
                mOut.print(" ");
            }
        }
        else if (line % 2 == 1) {
            for (int i = 1; i <= line - size; i++) {
                mOut.print(" ");
            }
            mOut.print("\\");
            for (int i = 1; i <= 4 * size - 2 * line - 2; i++) {
                mOut.print("=");
            }
            mOut.print("/");
            for (int i = 1; i <= line - size; i++) {
                mOut.print(" ");
            }
        }
        mOut.print("|\n");
    }
}

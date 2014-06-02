/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mupuzzle;

/**
 *
 * @author Nat
 */
public class MUPuzzle
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        findMIString();
    }

    public static void findMIString()
    {
        int randomRule = 1;
        int loopCount = 0;

        String string = "MI";

        while (!string.equals("MU"))
        {
            randomRule = (int) (1 + Math.random() * 4);
            String beforeString = string;

            switch (randomRule)
            {
                case 1:
                    if (string.endsWith("I"))
                    {
                        string += "U";
                    }
                    break;
                case 2:
                    string += string.substring(string.indexOf('M') + 1);
                    break;
                case 3:
                    if (string.contains("III"))
                    {
                        string = string.replace("III", "U");
                    }
                    break;
                case 4:
                    if (string.contains("UU"))
                    {
                        string = string.replace("UU", "");
                    }
                    break;
            }

            // Increse loop counter and output results if rule has been applied.
            if (!beforeString.equals(string))
            {
                System.out.print("Loop: " + ++loopCount + " Rule: " + randomRule + " String: " + string + "\n");
            }

            // Exit when string is longer than 100
            if (string.length() > 10)
            {
                string = "MU";
            }

        }
    }

    /**
     * Attempt to find MI using invariants. Source code from
     * https://en.wikipedia.org/wiki/Invariant_(computer_science)
     */
    public static void findMIInvariant()
    {
        int randomRule = 1;
        int iCount = 1, uCount = 0, loopCount = 0;
        // Should be endless loop
        while (iCount % 3 != 0)
        {
            randomRule = (int) (1 + Math.random() * 4);

            switch (randomRule)
            {
                case 1:
                    uCount += 1;
                    break;
                case 2:
                    iCount *= 2;
                    uCount *= 2;
                    break;
                case 3:
                    iCount -= 3;
                    uCount += 1;
                    break;
                case 4:
                    uCount -= 2;
                    break;
            }

            // Output loop count, iCount mod 3, iCount and uCount
            System.out.println("Loop: " + ++loopCount + "\niCount Mod 3: " + iCount % 3);
            System.out.println("iCount: " + iCount + "\nuCount: " + uCount + "\n");
        }
    }

}

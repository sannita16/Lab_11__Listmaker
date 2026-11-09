import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

        } while(retString.length() == 0);

        return retString;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(
                    "\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println(
                            "You must enter a value between "
                                    + low + " and " + high + ".");
                }
            }
            else
            {
                trash = pipe.nextLine();

                System.out.println(
                        "You must enter a valid integer, not: " + trash);
            }

        } while(!done);

        return retVal;
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean done = false;
        boolean retVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N.");
            }

        } while(!done);

        return retVal;
    }


    public static String getRegExString(
            Scanner pipe,
            String prompt,
            String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retVal = pipe.nextLine();

            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Invalid input. Try again.");
            }

        } while(!done);

        return retVal;
    }
}
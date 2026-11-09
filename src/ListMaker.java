import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String choice = "";
        boolean done = false;

        do
        {
            displayList(list);
            displayMenu();

            choice = SafeInput.getRegExString(
                    in,
                    "Enter your choice",
                    "[AaDdIiPpQq]");


            if(choice.equalsIgnoreCase("A"))
            {
                addItem(in, list);
            }

            else if(choice.equalsIgnoreCase("D"))
            {
                deleteItem(in, list);
            }

            else if(choice.equalsIgnoreCase("I"))
            {
                insertItem(in, list);
            }

            else if(choice.equalsIgnoreCase("P"))
            {
                printList(list);
            }

            else if(choice.equalsIgnoreCase("Q"))
            {
                done = SafeInput.getYNConfirm(
                        in,
                        "Are you sure you want to quit");
            }

        } while(!done);

        System.out.println("\nGoodbye!");
    }


    private static void displayMenu()
    {
        System.out.println();
        System.out.println("List Maker Menu");
        System.out.println("----------------");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }


    private static void displayList(ArrayList<String> list)
    {
        System.out.println();
        System.out.println("Current List");
        System.out.println("------------");

        if(list.size() == 0)
        {
            System.out.println("The list is empty.");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }


    private static void addItem(
            Scanner in,
            ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(
                in,
                "Enter the item to add");

        list.add(item);

        System.out.println(
                "\"" + item + "\" was added to the list.");
    }


    private static void deleteItem(
            Scanner in,
            ArrayList<String> list)
    {
        if(list.size() == 0)
        {
            System.out.println(
                    "\nThe list is empty. There is nothing to delete.");

            return;
        }

        displayList(list);

        int itemNumber = SafeInput.getRangedInt(
                in,
                "Enter the item number to delete",
                1,
                list.size());

        String removedItem = list.remove(itemNumber - 1);

        System.out.println(
                "\"" + removedItem + "\" was deleted from the list.");
    }


    private static void insertItem(
            Scanner in,
            ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(
                in,
                "Enter the item to insert");

        int location = SafeInput.getRangedInt(
                in,
                "Enter the location where you want to insert the item",
                1,
                list.size() + 1);

        list.add(location - 1, item);

        System.out.println(
                "\"" + item + "\" was inserted at position "
                        + location + ".");
    }


    private static void printList(ArrayList<String> list)
    {
        System.out.println();
        System.out.println("Your List");
        System.out.println("---------");

        if(list.size() == 0)
        {
            System.out.println("The list is empty.");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println(
                        (i + 1) + ". " + list.get(i));
            }
        }
    }
}
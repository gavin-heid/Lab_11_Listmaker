import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        final String menu = "A - Add   D - Delete   P - Print   Q-Quit";
        boolean done = false;
        String cmd = "";


        do {
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd) {
                case "A":
                    addItem(console);
                    break;
                case "D":
                    deleteItem(console);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(console, "Are you sure you wish to quit?");


            }


        } while (!done);
        console.close();

    }

    private static void addItem(Scanner console) {
        System.out.println("Current list:");
        printList();

        // Ask user for index to add the new item
        int index = SafeInput.getRangedInt(console, "Enter the index where you want to add the item", 1, list.size() + 1);

        // Prompt user for new item
        String newItem = SafeInput.getNonZeroLenString(console, "Enter the item to add");

        // Add item at specified index
        list.add(index - 1, newItem);
        System.out.println("Item added successfully.");

    }

    private static void deleteItem(Scanner console) {
        if (list.isEmpty()) {
            System.out.println("List is empty. No items to delete.");
            return;
        }

        System.out.println("Current list:");
        printList();

        int index = SafeInput.getRangedInt(console, "Enter the index of the item you want to delete", 1, list.size());

        // Remove the item at the specified index
        String removedItem = list.remove(index - 1);

        System.out.println("Item '" + removedItem + "' deleted successfully.");

    }

    private static void printList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%10d  %-10s", i + 1, list.get(i));
                // check if current item is not last item and multiple 3
                if ((i + 1) % 3 == 0 && i != list.size() - 1)
            {
                System.out.println(""); // Add line after third item
            }
            }
            System.out.println("");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } else
            System.out.println("+++            List is Empty              +++");
    }
}
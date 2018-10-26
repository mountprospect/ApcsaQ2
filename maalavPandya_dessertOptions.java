import java.util.ArrayList;
import java.util.Scanner;

public class maalavPandya_dessertOptions
{
//Add pics?
//make constriuctor for this class to run the progrsam in combined class?
   static ArrayList<String> dessertNames = new ArrayList<String>();
   static ArrayList<String> dessertPrices = new ArrayList<String>();
   static String contDessertAns;
   static double subtotal, total, counter, tip;
   static final String[][] dessertList = {
   {"(1)TIRAMISU...............", 
   "(2)CARROT CAKE............",
   "(3)STRAWBERRY SHORTCAKE...",
   "(4)FUDGE CAKE.............",
   "(5)BLACK-OUT CAKE........."},
   {"Italian Custard topped with Whipped Cream and Ground Chocolate.", 
   "Deliciously Moist Layers of Carrot Cake and Cream Cheese Icing.",
   "Shortcake Topped with Vanilla Ice Cream, Strawberries and Whipped Cream.",
   "Layers of Rich Chocolate Cake and Fudge Frosting.",
   "Rich Chocolate Cake with Chocolate Chips, Finished with Almonds." },
   {"\t\t\t14.99","\t\t\t11.99","10.99","\t\t\t\t\t\t\t\t16.99","\t\t\t19.99"}
   };
   static final String[][] dessertNamesAndPrices = {
   {"TIRAMISU...............",
   "CARROT CAKE............",
   "STRAWBERRY SHORTCAKE...",
   "FUDGE CAKE.............",
   "BLACK-OUT CAKE........."},
   {"14.99", "11.99", "10.99", "16.99","19.99"}
   };

   //strings to make tabs?
   public static double totalCalc() {
         tip = subtotal * 0.07;
         total = subtotal + tip;
         System.out.println();
         System.out.println("Subtotal: " + subtotal);
         System.out.println("Tip (7%): " + tip);
         System.out.println();
         System.out.println("Total (rounded down to nearest dollar): $" + (int) total);
         return total;
   }
   public static void dessertSelect()
   {
      try
      {
         Scanner input = new Scanner(System.in);
         System.out.println("Name\t\t\t\t\t\t\t   Description\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice($)");
         for (int i = 0; i < 5; i++) System.out.println(dessertList[0][i] + "\t" +  dessertList[1][i] + "\t" + dessertList[2][i]);
         System.out.println("Would you like dessert?");
         String dessertAns = input.nextLine();
         dessertAns = dessertAns.toLowerCase();
         if (dessertAns.equals("y") || dessertAns.equals("yes"))
         {
            do
            {
               System.out.print("Which item would you like? (Enter the corresponding number) ");
               int dessertChoice = input.nextInt();
               System.out.println(dessertList[0][dessertChoice - 1] + " added to order.");
               System.out.println("Would you like anything else? (Yes or No)");
               input.nextLine();
               contDessertAns = input.nextLine();
               contDessertAns = contDessertAns.toLowerCase();
               subtotal += Double.parseDouble(dessertList[2][dessertChoice - 1]);
               counter++;
               dessertNames.add(dessertNamesAndPrices[0][dessertChoice - 1]);
               dessertPrices.add(dessertNamesAndPrices[1][dessertChoice - 1]);
            } while (contDessertAns.equals("y") || contDessertAns.equals("yes"));
         //add tax, if counter is full
         System.out.println("Final Dessert Reciept: ");
         for (int i = 1; i <= counter; i++)
         {
            System.out.println(dessertNames.get(i - 1) + dessertPrices.get(i - 1));
         }
         totalCalc();
      }
         else 
         {
            System.out.println("Ok. Have a good day");
         }
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         System.out.println("Caught ArrayIndexOutOfBoundsException -- input numbers within array indices");
      }
   }
   
   public static void main(String[] args) { 
    //TODO: REMOVE main
      dessertSelect();
   }
}
package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

//class needs to be same name as the file.
public class ShoppingCart{

  //Create an entry point
  public static void main(String[] args){

    List<String> cart = new LinkedList<>();
    Console cons = System.console();
    Boolean stop = false;

    while(!stop){
      //line
      //add <item>
      //delete <num>
      //exit

      String line = cons.readLine("> ");
      //Clean the userinput
      //userinput delimited by space
      line = line.trim();
      //add apple => ["add", "apple"]
      //list => ["list"]
      String[] terms = line.split(" ");
      //use if or switch; use switch if too many cases

      /*//if you are unsure, or want to debug error, print it oout to check
      System.out.printf("Command: %s\n",terms[0]);*/

      switch (terms[0]){
        case "list":
        if(cart.size()<=0){
          System.out.println("Your cart is empty");
        } else {
          System.out.println("The contents of your cart");
          for(Integer idx = 0; idx < cart.size();idx++)
            System.out.printf("%d. %s\n",(idx+1),cart.get(idx));
        }
          break;
        // add apple orange pear
        // add -> please specify item to add
        // Check if add has any items
        case "add":
          cart.add(terms[1]);
          System.out.printf("Added %s to cart\n",terms[1]);
          break;
        
        case "delete":
          // delete has any number and if the number is valid
          Integer index = Integer.parseInt(terms[1]);
          cart.remove((int)index);
          break;
        case "exit":
          stop=true;
          break;
        //set default in case 
        default:
          System.out.printf("Unknown command: %s\n", terms[0]);
      }

    }
    System.out.println("Thank you for shopping with us. Bye bye.");
  }

}
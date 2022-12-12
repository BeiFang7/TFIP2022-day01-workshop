package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class DraftShoppingCart{

  public static void main (String[] args){

    System.out.printf("Welcome to your Shopping Cart\n");

    Console cons = System.console();
    List <String> cart = new LinkedList<>();
    String input = "";

    while (true){
      input = cons.readLine();
      input = input.replaceAll(", "," ");
      String[] splitInput = input.split(" ");
      Integer index = 0;

      if(splitInput[index].equals("add")){
        
        for (Integer count =1; count<splitInput.length; count++){
          if(cart.contains(splitInput[count])){
            System.out.printf("%s is already in cart.\n", splitInput[count]);
          } else{
          cart.add(splitInput[count]);
          System.out.printf("%s added to cart.\n",splitInput[count]);
          }
        }
      } else  if(splitInput[index].equals("delete")){        
        Integer value = Integer.parseInt(splitInput[splitInput.length-1]);
        
        if(value <= cart.size()){
          System.out.printf("%s removed from cart.\n",cart.get(value-1));
          cart.remove(value-1);
        } else {
          System.out.printf("Incorrect item index\n");
        }
        
      } else if(splitInput[index].equals("list")){
        if(cart.size()==0){
          System.out.printf("Your cart is empty.\n");
        } else if (input.equals("list")){
          for (Integer i =0; i < cart.size(); i++)
          System.out.printf("%d. %s\n",(i+1),cart.get(i));
        }
      } else if(splitInput[index].equals("exit")){
        System.out.println("Thank you for shopping with us. See you next time. Bye Bye!");
        break;
      } else{
        System.out.printf("Undefined input. Please key in list, add, delete, exit\n");
      }
      
      
    }
  }
}


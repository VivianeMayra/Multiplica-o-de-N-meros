import java.util.*;
import java.util.Scanner;
  
public class GFG{
  
    // Linked list node
    static class Node
    {
        int data;
        Node next;
          
        Node(int data){
            this.data = data;
            next = null;
        }
    }
  
    // Multiply contents of two linked lists
    static long multiplyTwoLists(Node first, Node second)
    {
        long N = 1000000007;
        long num1 = 0, num2 = 0;
  
        while (first != null || second !=  null){
              
            if(first != null){
                num1 = ((num1)*10)%N + first.data;
                first = first.next;
            }
              
            if(second != null)
            {
                num2 = ((num2)*10)%N + second.data;
                second = second.next;
            }
              
        }
        return ((num1%N)*(num2%N))%N;
    }
  
    // A utility function to print a linked list
    static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data);
            if(node.next != null)
                System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }
  
    // Driver program to test above function
    public static void main(String args[])
    {
        /* create first list 9->4->6
        Node first = new Node(9);
        first.next = new Node(4);
        first.next.next = new Node(6);
        System.out.print("First List is: ");
        printList(first);*/

        Scanner scanner= new Scanner(System.in);
        System.out.println("Digite seu valor:");
        String valor= scanner.nextLine();
        String[] firstList = valor.split("");
        System.out.println(Arrays.toString(firstList));
        System.out.println("Digite seu segundo valor:");
        String valor2= scanner.nextLine();
        String[] secondList = valor2.split("");
        System.out.println(Arrays.toString(secondList));
        
        Node first = new Node(Integer.parseInt(firstList[0]));
        for(int x=1; x<firstList.length;x++){
            first.next = new Node(Integer.parseInt(firstList[x]));
            
        }
        Node second = new Node(Integer.parseInt(secondList[0]));
        for(int x=1; x<secondList.length;x++){
            second.next = new Node(Integer.parseInt(secondList[x]));
            
        }
        printList(first);
        System.out.println("");
        printList(second);
        System.out.println("");
        System.out.println(multiplyTwoLists(first, second));
       

  
        /* create second list 8->4
        Node second = new Node(8);
        second.next = new Node(4);
        System.out.print("Second List is: ");
        printList(second);
  
        // Multiply the two lists and see result
        System.out.print("Result is: ");
       C;*/
    }
}
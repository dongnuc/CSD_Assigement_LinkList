/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Main_CSD_Assigment {

    public static void main(String[] args) throws IOException {
        ManagerBook manager = new ManagerBook();

//        System.out.println("Search by Code: ");
//        String xBcode = Validation.inputString("Input Code: ");
//        Node searchNode = manager.searchByBcode(xBcode);
//        if (searchNode != null) {
//            System.out.println(searchNode.bookInfo.toString());
//        } else {
//            System.err.println("Not found");
//        }
//
//        System.out.println("Delete By Code: ");
//        String codeDelete = Validation.inputString("Input Code: ");
//        Node deleteNode = manager.searchByBcode(codeDelete);
//        if (deleteNode != null) {
//            manager.deleteNode(deleteNode);
//            System.out.println("Delete successful");
//            manager.display();
//        } else {
//            System.err.println("Node is not exist");
//        }
//
//        System.out.println("Sort by Code");
//        manager.sortByBcode();
//        manager.display();
//
//        System.out.println("Input and add beginning");
//        Book addHead = manager.addBook();
//        manager.addBookHead(addHead);
//        manager.display();
//
//        System.out.println("Add after position");
//        System.out.println("Create a Node: ");
//        Book b2 = manager.addBook();
//        int positionX = Validation.inputInt("Input position: ");
//        manager.addAfter(positionX, b2);
//        manager.display();
//        
//        System.out.println("Delete position");
//        int positionDele = Validation.inputInt("Input a position: ");
//        manager.deletePosition(positionX);
//        manager.display();
//        System.out.println("");
//        
        String[] ops = {"1.Load data from file\n" + "2.Input & add to the end\n" + "3.Display data\n"
            + "4.Save product list to file\n" + "5.Search by pcode\n" + "6.Delete by pcode\n" + "7.Sort by pcode\n"
            + "8.Add after position  k\n" + "9.Delete the node after the node having code = xCode\n" + "10.Exits\n"};

        while (true) {
            for (int i = 0; i < ops.length; i++) {
                System.out.print(ops[i]);
            }
            int choice = Validation.inputInt("Input choice: ");
            switch (choice) {
                case 1:
                    manager.loadDataFromFile();
                    manager.display();
                    break;
                case 2:
                    Book b1 = manager.addBook();
                    manager.addBookEnd(b1);
                    break;
                case 3:
                    manager.displayData();                   
                    break;
                case 4:
                    manager.savatoFile();
                    break;
                case 5:
                    String xBcode = Validation.inputString("Input Code: ");
                    Node searchNode = manager.searchByBcode(xBcode);
                    if (searchNode != null) {
                        System.out.println(searchNode.bookInfo.toString());
                    } else {
                        System.err.println("Not found");
                    }
                    break;
                case 6:
                    System.out.println("Delete By Code: ");
                    String codeDelete = Validation.inputString("Input Code: ");
                    Node deleteNode = manager.searchByBcode(codeDelete);
                    if (deleteNode != null) {
                        manager.deleteNode(deleteNode);
                        System.out.println("Delete successful");
                        manager.display();
                    } else {
                        System.err.println("Node is not exist");
                    }
                    break;
                case 7:
                    System.out.println("Sort by Code");
                    manager.sortByBcode();
                    manager.display();
                    break;
                case 8:
                    System.out.println("Create a Node: ");
                    Book b2 = manager.addBook();
                    int positionX = Validation.inputInt("Input position: ");
                    manager.addAfter(positionX, b2);
                    break;                    
                case 9:
                    String xBcodeDelete = Validation.inputString("Input Bcode: ");
                    manager.deleteNodeAfter(xBcodeDelete);
                    break;
                case 10:
                    return;
                default:
                    System.err.println("Please choose ops arange[1-10]");
            }
        }
    }
}

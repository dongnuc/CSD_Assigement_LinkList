/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Book;
import Model.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManagerBook {

    Scanner sc = new Scanner(System.in);
    Node tail, head;

    public ManagerBook() {
        tail = head = null;
    }

    public void addBookEnd(Book x) {

        Node newNode = new Node(x);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addBookHead(Book b1) {
        Node newNode = new Node(b1);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.bookInfo.toString());
            temp = temp.next;
        }
    }

    public Node searchByBcode(String inputBcode) {
        boolean check = false;
        Node temp = head;
        while (temp != null) {
            if (temp.bookInfo.getBcode().equalsIgnoreCase(inputBcode)) {
                check = true;
                return temp;
            }
            temp = temp.next;
        }
        if (!check) {
            System.err.println("Not found book");
        }
        return null;
    }

    public void deleteNode(Node temp) {
        if (temp == null) {
            System.err.println("Bcode is not exist");
        } else {
            Node beforeTemp = head;
            if (temp == head) {
                head = head.next;
                if (head == null) {                   
                    tail = null;
                }
                return;
            }
            while (beforeTemp != null && beforeTemp.next != temp) {
                beforeTemp = beforeTemp.next;
            }
            Node afterTemp = temp.next;
            beforeTemp.next = afterTemp;
            if (beforeTemp.next == null) {
                tail = beforeTemp;
            }
        }
    }

    public void sortByBcode() {
        Node p1, p2;
        p1 = head;
        Book temp;
        while (p1 != null) {
            p2 = p1.next;
            while (p2 != null) {
                if (p2.bookInfo.getBcode().compareToIgnoreCase(p1.bookInfo.getBcode()) < 0) {
                    temp = p2.bookInfo;
                    p2.bookInfo = p1.bookInfo;
                    p1.bookInfo = temp;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }

    public void addAfter(int position, Book a) {
    int sizeL = sizeList();
    int count = 0;
    Node x = new Node(a);
    Node nodePosi = head;
    while (nodePosi != null && count < position) {
        count++;
        nodePosi = nodePosi.next;
    }
    if (nodePosi == null) {
        System.err.println("Position not found");
        return;
    }
    x.next = nodePosi.next; 
    nodePosi.next = x; 
}

    public void deletePosition(int position) {
        Node delete = searchPos(position);
        if (delete != null) {
            deleteNode(delete);
        } else {
            System.err.println("Node is not exist");
        }

    }

    public Node searchPos(int position) {
        Node first = head;
        int count = 0;
        while (first != null) {
            if (count == position) {
                return first;
            }
            first = first.next;
            count++;
        }
        return null;
    }

    public int sizeList() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Book addBook() {
        String bCode;
        while (true) {
            bCode = Validation.inputString("Input bCode's Book: ");
            if (!checkID(bCode)) {
                break;
            }
            System.err.println("ID is exist");
        }
        String title = Validation.inputString("Input title's Book: ");
        int quantity = Validation.inputInt("Input quantity's Book: ");
        int lended = Validation.inputInt("Input lended's Book: ");
        double price = Validation.inputDouble("Input price's Book: ");
        double value = price * quantity;
        Book b1 = new Book(bCode, title, quantity, lended, price, value);
        return b1;
    }

    public void loadDataFromFile() throws FileNotFoundException, IOException {
        File xFile = new File("Data.txt");
        FileReader readerFi = new FileReader(xFile);
        BufferedReader buffRead = new BufferedReader(readerFi);
        while (true) {
            String line = buffRead.readLine();
            if (line == null) {
                break;
            }
            String[] attBook = line.split("[|]");
            String bCode = attBook[0].trim();
            String nameBook = attBook[1].trim();
            int quantity = Integer.parseInt(attBook[2].trim());
            int lended = Integer.parseInt(attBook[3].trim());
            double price = Double.parseDouble(attBook[4].trim());
            double value = Double.parseDouble(attBook[5].trim());
            Book b1 = new Book(bCode, nameBook, quantity, lended, price, value);
            addBookEnd(b1);
        }

        buffRead.close();
        readerFi.close();
    }

    public void savatoFile() throws IOException {
        File xFile = new File("Data.txt");
        FileWriter writeFile = new FileWriter(xFile);
        BufferedWriter buffWrite = new BufferedWriter(writeFile);
        Node firstNode = head;
        while (firstNode != null) {
            buffWrite.write(firstNode.bookInfo.toStringData()+ "\n");
            firstNode = firstNode.next;
        }
        buffWrite.close();
        writeFile.close();
    }

    public void deleteNodeAfter(String xCode) {
        Node current = head;

        while (current != null && !current.bookInfo.getBcode().equals(xCode)) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }else{
            System.err.println("Code is not exist");
        }
    }

    public void displayData() {
        Node temp = head;
        formatDisplay();
        while (temp != null) {
            System.out.println(temp.bookInfo.toStringData());
            temp = temp.next;
        }
    }

    public boolean checkID(String xID) {
        Node first = head;
        while (first != null) {
            if (first.bookInfo.getBcode().equalsIgnoreCase(xID)) {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    public void formatDisplay() {
        System.out.printf("%-5s| %-10s| %-5s| %-5s| %-7s | %-7s", "bcode", "title", "quantity", "lended", "price", "value");
        System.out.println("");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Node {
    Book bookInfo;
    Node next;
    
    public Node() {
    }

    Node(Book a, Node x) {
        this.bookInfo = a;
        this.next = x;
    }
    
    public Node(Book x){
        this.bookInfo = x;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.csc229_lab08;

import java.util.Scanner;

/**
 *
 * @author jsieb
 */
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class CSC229_Lab08 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a number for n: ");
        int n = scnr.nextInt();

        SinglyLinkedList prime = new SinglyLinkedList();
        SinglyLinkedList primeThree = new SinglyLinkedList();

        // adds primes to list
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                prime.add(i);
            }
        }

        // moves primes with '3'
        Node curr = prime.head;
        while (curr != null) {
            if (isPrime(curr.data) && hasThree(curr.data)) {
                primeThree.add(curr.data);
            }
            curr = curr.next;
        }

        // sums primeThree
        int sum = 0;
        curr = primeThree.head;
        while (curr != null) {
            sum += curr.data;
            curr = curr.next;
        }

        System.out.println("List of prime numbers");
        prime.print();
        System.out.println("List of prime numbers with digit 3: ");
        primeThree.print();
        System.out.println("Sum of list primes with digit three: " + sum);
    }

    public static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasThree(int x) {
        while (x > 0) {
            if (x % 10 == 3) {
                return true;
            }
            x /= 10;
        }

        return false;
    }
}

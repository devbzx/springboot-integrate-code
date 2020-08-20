package com.lhq.task.service;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int a ,b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        while (a != b){
            if (a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        System.out.println(a);
    }
}

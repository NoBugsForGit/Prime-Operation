package main;

public class Main {
    public static void main(String[] args){
        System.out.println("This is test program.");
        Prime test=new Prime();
        boolean c=test.examine(200);
        System.out.println(c);
    }
}

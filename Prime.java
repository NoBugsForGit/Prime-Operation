package main;

import java.lang.Math;

public class Prime {

    public class PrimeError extends Exception{
        public PrimeError(String s){
            super(s);
        }
    }
    boolean[] b;
    boolean b2 = false;
    int[] primes;
    int start, end;

    public int getCount(int start, int end) {
        int i, j;
        int count = 0;
        this.start = start;
        this.end = end;
        if (this.start < 2) {
            this.start = 2;
        }
        if (this.start > this.end) {
            System.out.println("Error: The value of start must less than the value of end!");
            return 0;
        }
        if (this.end > 2147483640) {
            System.out.println("Warning: You'd better use BigPrime.");
        }

        if (this.end < 2) {
            return 0;
        }
        if (this.end == 2) {
            primes = new int[1];
            primes[0] = 2;
            this.b2 = true;
            return 1;
        }
        if (this.start == 2) {
            count++;
            b2 = true;
        }
        if (this.start % 2 == 0) {
            this.start++;
        }
        int count_of_b = (this.end - this.start) / 2 + 1;
        b = new boolean[count_of_b];
        for (i = 0; i < count_of_b; i++) {
            b[i] = true;
        }

        for (i = 0; i < count_of_b; i++) {
            if (this.b[i]) {
                count++;
                for (j = (3 * i) + this.start; j < count_of_b; j += (2 * i + this.start)) {
                    b[j] = false;
                }
            }
        }
        return count;
    }

    public int[] getArr(int start, int end) {
        int temp = this.getCount(start, end);
        if (temp == 0) {
            return null;
        }
        if ((temp == 1) && b2) {
            this.primes = new int[1];
            this.primes[0] = 2;
        }
        this.primes = new int[temp];
        int j = 0;
        if (b2) {
            primes[0] = 2;
            j++;
        }
        if(b==null)
            return null;
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                this.primes[j] = 2 * i + this.start;
                j++;
            }
        }
        return primes;
    }

    public boolean examine(int num) {
        if (num<1) {
            try {
                throw new PrimeError("error:num must bigger than 0");
            } catch (PrimeError e) {
                e.printStackTrace();
            }
        }
        this.primes = getArr(2, (int) (Math.sqrt(num) + 1));
        if (this.primes==null){
            if (num==1)
                return false;
            else if(num==2)
                return true;
            else
                System.out.println("unknown error");
        }
        for (int i : this.primes){
            if (num%i==0)
                return false;
        }
        return true;
    }
}
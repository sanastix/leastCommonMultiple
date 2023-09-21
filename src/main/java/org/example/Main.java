package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));
        int amount = in.nextInt();
        long[] nums = new long[amount];

        for (int i = 0; i < amount; i++) {
            nums[i] = in.nextInt();
        }

        in.close();

        long lcm = findLCM(nums);

        PrintWriter out = new PrintWriter("output.txt");
        out.print(lcm);

        out.close();

    }

    public static long findLCM(long[] numArr) {
        long result = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            result = findLCM(result, numArr[i]);
        }
        return result;
    }

    public static long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long findLCM(long a, long b) {
        return (a / findGCD(a, b)) * b;
    }
}

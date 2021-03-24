package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    @FunctionalInterface
    public interface ArrayCreate {
        Integer[] process(int a, int b);
    }

    public static void main(final String[] args) {

        ArrayCreate custom1 = (si, in) -> {
            Integer[] arr = new Integer[si];
            for (int i = 0; i < si; i++) {
                arr[i] = i + in;
            }
            return arr;
        };

        ArrayCreate custom2 = (si, in) -> {
            Integer[] arr = new Integer[si];
            for (int i = 0; i < si; i++) {
                arr[i] = i * in;
            }
            return arr;
        };

        ArrayCreate custom3 = (si, in) -> {
            Integer[] arr = new Integer[si];
            for (int i = 0; i < si; i++) {
                if (i % 2 == 0) {
                    arr[i] = i / 2 + in;
                } else {
                    arr[i] = i * i - in;
                }
            }
            return arr;
        };

        ArrayCreate custom4 = (si, in) -> {
            Integer[] arr = new Integer[si];
            for (int i = 0; i < si; i++) {
                if (i % 2 == 0) {
                    arr[i] = si - i;
                } else {
                    arr[i] = si + in;
                }
            }
            return arr;
        };

        ArrayCreate custom5 = (si, in) -> {
            Integer[] arr = new Integer[si];
            for (int i = 0; i < si; i++) {
                arr[i] = si * i - in;
            }
            return arr;
        };


        Scanner s = new Scanner(System.in);
        System.out.print("Введите число: ");
        int input = s.nextInt();

        final int size = 10;

        Integer[] myArray1 = getFilledArray(size, input, custom1);
        Integer[] myArray2 = getFilledArray(size, input, custom2);
        Integer[] myArray3 = getFilledArray(size, input, custom3);
        //число = для чётного индекса <размер массива минус индекс>, для нечётного <размер массива плюс модификатор>
        Integer[] myArray4 = getFilledArray(size, input, custom4);
        //число = размер массива помноженный на индекс минус идентификатор
        Integer[] myArray5 = getFilledArray(size, input, custom5);
        System.out.println(Arrays.toString(myArray1));
        System.out.println(Arrays.toString(myArray2));
        System.out.println(Arrays.toString(myArray3));
        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(myArray4));
        System.out.println(Arrays.toString(myArray5));

        s.close();
    }

    public static Integer[] getFilledArray(final int size, final int input, final ArrayCreate r) {
        return r.process(size, input);
    }
}


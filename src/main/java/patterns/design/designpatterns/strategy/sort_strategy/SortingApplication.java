package patterns.design.designpatterns.strategy.sort_strategy;

import java.util.Scanner;

public class SortingApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Sorter sorter = new Sorter();

        System.out.println("Enter integers to be sorted, separated by spaces: ");
        String[] input = scanner.nextLine().split(" ");

        int[] array = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        while (true) {
            System.out.println("Choose sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Merge Sort");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sorter.setStrategy(new BubbleSort());
                    break;
                case 2:
                    sorter.setStrategy(new QuickSort());
                    break;
                case 3:
                    sorter.setStrategy(new MergeSort());
                    break;
                default:
                    System.out.println("invalid selection");
                    continue;
            }

            sorter.sortArray(array);
            System.out.println("sorted array:");

            for (int num : array) {
                System.out.print(num + " ");
            }

            System.out.println();

            System.out.println("Would you like to try another sorting algorithm? (y/n)");

            char tryAgain = scanner.next().charAt(0);

            if (tryAgain == 'n') {
                break;
            }
        }

        System.out.println("Program completed");
        scanner.close();
    }
}

package patterns.design.designpatterns.decorator;


import patterns.design.designpatterns.decorator.cpu.HighEndCPU;
import patterns.design.designpatterns.decorator.cpu.NormalCPU;
import patterns.design.designpatterns.decorator.gpu.BasicGPU;
import patterns.design.designpatterns.decorator.gpu.HighEndGPU;
import patterns.design.designpatterns.decorator.memory.HighMemory;
import patterns.design.designpatterns.decorator.memory.LowMemory;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Data Center Configuration Tool!");

        System.out.println("Select Server Type:");
        System.out.println("1. High-End CPU");
        System.out.println("2. Normal CPU");
        int serverChoice = scanner.nextInt();
        Server server = null;

        if (serverChoice == 1) {
            server = new HighEndCPU();
        } else if (serverChoice == 2) {
            server = new NormalCPU();
        }

        System.out.println("Select Memory Type:");
        System.out.println("1. High Memory");
        System.out.println("2. Low Memory");
        int memoryChoice = scanner.nextInt();

        if (memoryChoice == 1) {
            server = new HighMemory(server);
        } else if (memoryChoice == 2) {
            server = new LowMemory(server);
        }

        System.out.println("Select GPU Type:");
        System.out.println("1. High-End GPU");
        System.out.println("2. Basic GPU");
        int gpuChoice = scanner.nextInt();

        if (gpuChoice == 1) {
            server = new HighEndGPU(server);
        } else if (gpuChoice == 2) {
            server = new BasicGPU(server);
        }

        System.out.printf("Total Price: $%.5f\n", server.getCost());

        String description = "Description: Server with ";
        description += (serverChoice == 1) ? "High-End CPU" : "Normal CPU";
        description += ", with ";
        description += (memoryChoice == 1) ? "High Memory" : "Low Memory";
        description += ", with ";
        description += (gpuChoice == 1) ? "High-End GPU" : "Basic GPU";

        System.out.println(description);

        scanner.close();
    }
}

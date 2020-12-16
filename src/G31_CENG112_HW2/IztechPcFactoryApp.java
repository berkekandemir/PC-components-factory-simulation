package G31_CENG112_HW2;

import java.lang.Math;
import java.util.Scanner;
/**
 * This class is the main app class. All the other things are being used in here.
 */
public class IztechPcFactoryApp {
	/**
	 * This block is the definitions of the objects and the variables that will be used in the remaining part.
	 */
	private static int rowNumber = 1;
	private static int soldRAM = 0;
	private static int soldCPU = 0;
	private static int soldCache = 0;
	private static int soldMotherboard = 0;
	private static int soldGraphicsCard = 0;
	private static String item;
	private static Warehouse<String> cacheWarehouse = new Warehouse<String>();
	private static Warehouse<String> cpuWarehouse = new Warehouse<String>();
	private static Warehouse<String> graphicsCardWarehouse = new Warehouse<String>();
	private static Warehouse<String> motherboardWarehouse = new Warehouse<String>();
	private static Warehouse<String> ramWarehouse = new Warehouse<String>();
 	private static FactoryLine<String> factoryLine = new FactoryLine<String>();
	private static Scanner keyboard = new Scanner(System.in);
	private static String[] products = {"RAM", "CPU", "Graphics Card", "Motherboard", "Cache"};
	private static int range1 = 3;
	private static int range2 = 5;
	private static String product;
	
	public static void main(String[] args) {
		System.out.println("*** WELCOME TO THE IZTECH PC PARTS FACTORY ***\n");
		System.out.println("Enter the number of random request cycles: ");
		/**
		 * We get the user input and simulate the app for the given number.
		 */
		int request = keyboard.nextInt();
		for (int i = 0; i < request; i++) {
			int r1 = (int) (Math.random() * range1);
			if (r1 == 0) {
				int r2 = (int) (Math.random() * range2);
				/**
				 * According to the random numbers, program chooses the options. 
				 */
				product = products[r2];
				/**
				 * This block is the "marketing analyst" block. The element that has been chosen randomly from the products array will be enqueued in the factoryLine.
				 */
				try {
					factoryLine.enqueue(product);
					System.out.println(rowNumber + ". Marketing Analyst requesting " + product + ", SUCCESS, " + product + " manufactured!\n");
					rowNumber++;
				} catch (Exception e) {
					System.out.println(rowNumber + ". Marketing Analyst requesting " + product + ", FAIL, " + product + " is not manufactured!\n");
					rowNumber++;
				}
			} else if (r1 == 1) {
				/**
				 * This block is the "storage chief" block. The element that is on the frontIndex of the factoryLine will be stored in the suitable warehouse for it. 
				 */
				if (factoryLine.isEmpty()) {
					System.out.println(rowNumber + ". Storage Chief could not store any item, FAIL, the Factory Line is empty!\n");
					rowNumber++;
					continue;
				}
				item = factoryLine.dequeue();
				if (item == "RAM") {
					ramWarehouse.push(item);
					System.out.println(rowNumber + ". Storage Chief storing " + item + ", SUCCESS, " + item + " stored in " + item + " warehouse!\n");
					rowNumber++;
				} else if (item == "CPU") {
					cpuWarehouse.push(item);
					System.out.println(rowNumber + ". Storage Chief storing " + item + ", SUCCESS, " + item + " stored in " + item + " warehouse!\n");
					rowNumber++;
				} else if (item == "Graphics Card") {
					graphicsCardWarehouse.push(item);
					System.out.println(rowNumber + ". Storage Chief storing " + item + ", SUCCESS, " + item + " stored in " + item + " warehouse!\n");
					rowNumber++;
				} else if (item == "Motherboard") {
					motherboardWarehouse.push(item);
					System.out.println(rowNumber + ". Storage Chief storing " + item + ", SUCCESS, " + item + " stored in " + item + " warehouse!\n");
					rowNumber++;
				} else if (item == "Cache") {
					cacheWarehouse.push(item);
					System.out.println(rowNumber + ". Storage Chief storing " + item + ", SUCCESS, " + item + " stored in " + item + " warehouse!\n");
					rowNumber++;
				} else {
					continue;
				}
			} else if (r1 == 2) {
				int r2 = (int) (Math.random() * range2);
				product = products[r2];
				/**
				 * This block is the "customer" block. Customer tries to buy the item that has been chosen randomly from the products array. If customer bought the item, item will be removed from its warehouse.
				 */
				if (product == "RAM") {
					if (ramWarehouse.isEmpty()) {
						System.out.println(rowNumber + ". Customer buying " + product + ", FAIL, " + product + " warehouse is empty!\n");
						rowNumber++;
						continue;
					} else {
						ramWarehouse.pop();
						soldRAM++;
						System.out.println(rowNumber + ". Customer buying " + product + ", SUCCESS, " + "Customer bought " + product + "!\n");
						rowNumber++;
					}
				} else if (product == "CPU") {
					if (cpuWarehouse.isEmpty()) {
						System.out.println(rowNumber + ". Customer buying " + product + ", FAIL, " + product + " warehouse is empty!\n");
						rowNumber++;
						continue;
					} else {
						cpuWarehouse.pop();
						soldCPU++;
						System.out.println(rowNumber + ". Customer buying " + product + ", SUCCESS, " + "Customer bought " + product + "!\n");
						rowNumber++;
					}
				} else if (product == "Graphics Card") {
					if (graphicsCardWarehouse.isEmpty()) {
						System.out.println(rowNumber + ". Customer buying " + product + ", FAIL, " + product + " warehouse is empty!\n");
						rowNumber++;
						continue;
					} else {
						graphicsCardWarehouse.pop();
						soldGraphicsCard++;
						System.out.println(rowNumber + ". Customer buying " + product + ", SUCCESS, " + "Customer bought " + product + "!\n");
						rowNumber++;
					}
				} else if (product == "Motherboard") {
					if (motherboardWarehouse.isEmpty()) {
						System.out.println(rowNumber + ". Customer buying " + product + ", FAIL, " + product + " warehouse is empty!\n");
						rowNumber++;
						continue;
					} else {
						motherboardWarehouse.pop();
						soldMotherboard++;
						System.out.println(rowNumber + ". Customer buying " + product + ", SUCCESS, " + "Customer bought " + product + "!\n");
						rowNumber++;
					}
				} else if (product == "Cache") {
					if (cacheWarehouse.isEmpty()) {
						System.out.println(rowNumber + ". Customer buying " + product + ", FAIL, " + product + " warehouse is empty!\n");
						rowNumber++;
						continue;
					} else {
						cacheWarehouse.pop();
						soldCache++;
						System.out.println(rowNumber + ". Customer buying " + product + ", SUCCESS, " + "Customer bought " + product + "!\n");
						rowNumber++;
					}
				}
			}
			product = null;
		}
		/**
		 * This block is the "results" block. This block prints the results of the simulation. 
		 */
		System.out.println("Amount of RAM in Factory Line: " + factoryLine.getCount("RAM"));
		System.out.println("Amount of CPU in Factory Line: " + factoryLine.getCount("CPU"));
		System.out.println("Amount of Graphics Card in Factory Line: " + factoryLine.getCount("Graphics Card"));
		System.out.println("Amount of Motherboard in Factory Line: " + factoryLine.getCount("Motherboard"));
		System.out.println("Amount of Cache in Factory Line: " + factoryLine.getCount("Cache") + "\n");
		
		System.out.println("Amount of RAM in RAM Warehouse: " + ramWarehouse.getLength());
		System.out.println("Amount of CPU in CPU Warehouse: " + cpuWarehouse.getLength());
		System.out.println("Amount of Graphics Card in Graphics Card Warehouse: " + graphicsCardWarehouse.getLength());
		System.out.println("Amount of Motherboard in Motherboard Warehouse: " + motherboardWarehouse.getLength());
		System.out.println("Amount of Cache in Cache Warehouse: " + cpuWarehouse.getLength() + "\n");
		
		System.out.println("Amount of RAM sold: " + soldRAM);
		System.out.println("Amount of CPU sold: " + soldCPU);
		System.out.println("Amount of Graphics Card sold: " + soldGraphicsCard);
		System.out.println("Amount of Motherboard sold: " + soldMotherboard);
		System.out.println("Amount of Cache sold: " + soldCache + "\n");
		
	}

}

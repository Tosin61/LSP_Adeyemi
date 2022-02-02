package org.howard.edu.lsp.assignment2;
import java.util.Scanner;
public class Simple_text_processor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("New String?");
		String token = input.nextLine();
		while (!token.equals("Goodbye")) {
			String [] arrofNums = token.split(" ");

			int sum_num = 0;
			int prod_num = 1;
			for (String a : arrofNums) {
				sum_num = sum_num + Integer.parseInt(a);
			}
			for (String a : arrofNums) {
				prod_num = prod_num * Integer.parseInt(a);
			}
			System.out.println("Sum: " + sum_num);
			System.out.println("Product: " + prod_num);
			System.out.println("New String?");
			token = input.nextLine();
		}
	}
}

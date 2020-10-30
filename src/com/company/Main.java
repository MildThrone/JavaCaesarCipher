package com.company;
import com.company.Cipher.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    String text = "";
	    String processedText = "";
	    int key = 0;

	    Scanner scanner = new Scanner(System.in);

/*
*	Using the arguments parser - args
*/
		if (args.length != 0) {
			for (String s : args) {
				switch (s) {
					case "-t":
						text = text.concat(s + 1);
						break;
					case "-k":
						key = Integer.parseInt(s + 1);
						break;
					case "-e":
						Encrypt encrypt = new Encrypt();
						encrypt.setRawText(text);
						encrypt.setKey(key);
						System.out.println("Encrypted Text : " + encrypt.encText());
						break;
					case "-d":
						Decrypt decrypt = new Decrypt();
						decrypt.setCipherText(text);
						decrypt.setKey(key);
						System.out.println("Raw Text : " + decrypt.decText());
						break;
				}
			}

			return;
		}
/*
*	Done with the argument parser
* 	Exit program if arguments were passed
* 	Continue program like normal if no arguments were passed
*/

		System.out.print("Enter Text : ");
		try {
			text = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Problem with Input");
			return;
		}

		int choice;

		try {
			do {
				System.out.print("Options \n 1 : Encrypt \n 2 : Decrypt \nSelect : ");
				choice = scanner.nextInt();
			} while ((choice != 1) && (choice != 2));

			do {
				System.out.print("Enter Key (1-25): ");
				key = scanner.nextInt();
			} while (!(key > 0 && key < 26));
		} catch (Exception e) {
			System.out.println("Something went wrong. Try again");
			return;
		}


		switch (choice) {
			case 1:
				Encrypt encrypt = new Encrypt();
				encrypt.setKey(key);
				encrypt.setRawText(text);
				processedText = encrypt.encText();
				break;
			case 2:
				Decrypt decrypt = new Decrypt();
				decrypt.setKey(key);
				decrypt.setCipherText(text);
				processedText = decrypt.decText();
				break;
			default:
				System.out.println("Something went wrong. XTry again");
		}

		System.out.println("Output : " + processedText);
    }

}

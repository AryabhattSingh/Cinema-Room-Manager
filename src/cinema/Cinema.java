package cinema;

import java.util.Scanner;

public class Cinema {

	private final static Scanner sc = new Scanner (System.in);
	private char seatMatrix[][];
	private int rows, seatsInARow;
	private int userRowNumber, userSeatNumber;
	private int totalSeats;
	private int currentIncome, totalPossibleIncome;

	public Cinema() {
		System.out.println("Enter the number of rows:");
		rows = sc.nextInt();
		System.out.println("Enter the number of seats in each row:");
		seatsInARow = sc.nextInt();
		totalSeats = rows * seatsInARow;
		seatMatrix = new char[rows][seatsInARow];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seatsInARow; j++) {
				seatMatrix[i][j] = 'S';
			}
		}
	}

	protected void showSeatMatrix() {
		//        int seatsInARow = seatMatrix[0].length;
		//        int rows = seatMatrix.length;
		//        
		System.out.println("\nCinema:");
		System.out.print("  ");
		for (int i = 1; i <= seatsInARow; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < seatsInARow; j++) {
				System.out.print (seatMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	protected void buyATicket() {
		System.out.println("Enter a row number:");
		userRowNumber = sc.nextInt();
		System.out.println("Enter a seat number in that row:");
		userSeatNumber = sc.nextInt();

		if (userRowNumber <= rows && userSeatNumber <= seatsInARow) {
			userRowNumber--;
			userSeatNumber--;
			if (seatMatrix[userRowNumber][userSeatNumber] == 'B') {
				System.out.println("That seat has already been purchased!");
				buyATicket();
			}
			else {
				int ticketPrice = 0;

				if (totalSeats <= 60) {
					ticketPrice = 10;
				}
				else {
					int frontRows = rows / 2;
					//int backRows = rows - frontRows;
					if (userRowNumber >= 0 && userRowNumber < frontRows) {
						ticketPrice = 10;
					}
					else {
						ticketPrice = 8;
					}
				}
				currentIncome += ticketPrice;
				System.out.println("\nTicket price: $" + ticketPrice);
				seatMatrix[userRowNumber][userSeatNumber] = 'B';
			}
		}
		else {
			System.out.println("Wrong input!");
		}
	}

	protected void showStatistics() {
		int purchasedTicketsCount = 0;
		for (char[] arr : seatMatrix) {
			for (char seat : arr) {
				if (seat == 'B') {
					purchasedTicketsCount++;
				}
			}
		}

		System.out.println("Number of purchased tickets: " + purchasedTicketsCount);
		double percentage = ((double) purchasedTicketsCount / totalSeats) * 100.0;
		System.out.printf("Percentage: %.2f", percentage);
		System.out.println("%");
		System.out.println("Current income: $" + currentIncome);
		if (totalSeats <= 60) {
			totalPossibleIncome = 10 * totalSeats;
		}
		else {
			int frontRows = rows / 2;
			int backRows = rows - frontRows;
			totalPossibleIncome = frontRows * 10 * seatsInARow + backRows * 8 * seatsInARow;
		}
		System.out.println ("Total income: $" + totalPossibleIncome);
	}

	protected void showMenu() {
		System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
	}


}

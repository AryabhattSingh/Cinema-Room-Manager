package cinema;

import java.util.Scanner;

public class CinemaManager {
	
	private final static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
//		char ch = '5';
//	    int ch2 = 6;
//	    System.out.printf("Marks for my assignment is %d%d",ch, ch2);
//	
		
		
		Cinema cinema = new Cinema();
        cinema.showMenu();
        int choice = sc.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1 :
                    cinema.showSeatMatrix();
                    cinema.showMenu();
                    break;
                case 2 :
                    cinema.buyATicket();
                    cinema.showMenu();
                    break;
                case 3 :
                	cinema.showStatistics();
                	cinema.showMenu();
                	break;
            }
            choice = sc.nextInt();
        }

	}

}

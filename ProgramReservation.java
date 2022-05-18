package exerciciotrycatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramReservation {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		//SE CHECK-OUT NÃO FOR DEPOIS DE CHECK-IN - ISSO SIGNIFICA ERRO
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			//DATA DE AGORA
			Date now = new Date();
			//SE A DATA DE CHECK-IN FOR ANTES DE AGORA OU DATA DE CHECK-OUT FOR ANTES DE AGORA
			//NÃO PODE SER ACEITO
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future");
			}else {
				if(!checkOut.after(checkIn)) {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}else {
					reservation.updateDates(checkIn, checkOut);
					System.out.println("Reservation: " + reservation);
				}
			}
			
			
		}
		
		

	}

}

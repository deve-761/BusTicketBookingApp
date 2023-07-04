package com.Usecases;

import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;
import com.model.BookingDetails;

public class BookTicket {
	
	public BookTicket(int userid,String date,String uname,int bid) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("_________________________\n");

		BusRoute dao = new BusRouteImpl();
		try {
			List<BookingDetails> booking = dao.bookingDetailsPrint(userid,date,uname);
			booking.forEach(ticketDetails -> System.out.println(ticketDetails));
			
			System.out.println("\nEnter 1 : cancel booking");
			System.out.println("Enter 0 : Exit");
			
			int select = scn.nextInt();
			if(select == 1) {
				CancelBooking cb = new CancelBooking(uname);
			}else if(select == 0) {
				System.out.println("\nThank you :)");
			}else {
				System.out.println("Enter valid choice . ");
			}
		} catch (BookingException e) {
			System.out.println(e.getMessage());
		}
	}

}

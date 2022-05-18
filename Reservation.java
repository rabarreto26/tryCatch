package exerciciotrycatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws ExceptionPersonalizado {
		if(!checkOut.after(checkIn)) {
			throw new ExceptionPersonalizado("Check-out date must be after checkin date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
		public Date getCheckOut() {
		return checkOut;
	}
	public long duration() {
		//DIFEREN�A ENTRE AS DUAS DATAS EM MILISEGUNDOS
		long diff = checkOut.getTime() - checkIn.getTime();
		//CONVERTER MILISEGUNDOS PARA DIAS
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) throws ExceptionPersonalizado {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new ExceptionPersonalizado("Reservation dates for update must be future dates");
		}
		if(!checkOut.after(checkIn)) {
			throw new ExceptionPersonalizado("Check-out date must be after checkin date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	@Override
	
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+" nights";
	}
	
	

}


public class BusList {
	public String start;
	public String end;
	public String starttime;
	public String Class;
	public int seats;
	public int price;
	public String date;
	
	
	public BusList() {
		
	}
	
	public BusList(String start, String end, String starttime, String class1, int seats, int price, String date) {
		super();
		this.start = start;
		this.end = end;
		this.starttime = starttime;
		Class = class1;
		this.seats = seats;
		this.price = price;
		this.date = date;
	}

	@Override
	public String toString() {
		return "BusLIst [start=" + start + ", end=" + end + ", starttime=" + starttime + ", Class=" + Class + ", seats="
				+ seats + ", price=" + price + ", date=" + date + "]";
	}
	
	
	
}



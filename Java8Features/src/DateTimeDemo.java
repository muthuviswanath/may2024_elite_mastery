import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
	public static void main(String[] args) {
		//		LocalDate today = LocalDate.now();
		//		System.out.println(today);
		LocalDateTime currenttime = LocalDateTime.now();
		System.out.println(currenttime);
		//		LocalTime lt = LocalTime.now();
		//		System.out.println(lt);
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		String formatted_date = currenttime.format(pattern);
		System.out.println(formatted_date);
		LocalDate today = LocalDate.now();
		System.out.println(today.getDayOfWeek());
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfYear());
		System.out.println(today.getMonth());
		System.out.println(today.getMonthValue());
		System.out.println(today.getYear());

		//Set the date to a custom date.
		LocalDate  mybday = LocalDate.of(1984,5, 16);
		System.out.println(mybday);
		LocalDate myfianceebday = LocalDate.of(1984, 5, 12);
		System.out.println(myfianceebday.isAfter(mybday));
		System.out.println(mybday.isAfter(myfianceebday));
		System.out.println(Math.abs(myfianceebday.compareTo(mybday)));

	}
}

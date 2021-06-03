package kebala_V2_2;

import java.time.LocalDate;
import java.time.LocalTime;

public class test {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		String fe = date + " ";
		String ho = time + " ";
		String to = fe + ho;
		System.out.print(to);
	}

}

package fr.norsys.pronostic.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * permet de converti des Date au different format
 *
 * @author mar1
 *
 */
public final class DateFormat {

	private DateFormat() {
	}

	/**
	 *
	 * @param date
	 *            : Java7 Date type
	 * @return : Java8 LocalDate type
	 */
	public static LocalDate formatToLocalDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 *
	 * @param timestamp
	 *            sql date type
	 * @return Java8 LocalDateTime type
	 *
	 */
	public static LocalDateTime formatToLocalDateTime(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
	}
}

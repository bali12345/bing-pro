package com.bing.utils.xml;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author benkangchen
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	private final DateTimeFormatter formatter;

	public LocalDateTimeAdapter(String pattern) {
		formatter = DateTimeFormatter.ofPattern(pattern);
	}

	@Override
	public LocalDateTime unmarshal(String dateTimeText) {
		return LocalDateTime.parse(dateTimeText, formatter);
	}

	@Override
	public String marshal(LocalDateTime dateTime) {
		return dateTime.format(formatter);
	}

	public static final class DateTimeFormatDefault extends LocalDateTimeAdapter {

		public DateTimeFormatDefault() {
			super("yyyy-MM-dd HH:mm:ss");
		}
	}

	public static final class DateTimeFormatShort extends LocalDateTimeAdapter {

		public DateTimeFormatShort() {
			super("yyyyMMddHHmmss");
		}
	}
}

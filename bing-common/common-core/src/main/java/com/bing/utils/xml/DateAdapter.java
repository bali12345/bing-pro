package com.bing.utils.xml;



import com.bing.utils.DateUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

/**
 * @author benkangchen
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	private final String formatter;

	public DateAdapter(String pattern) {
		formatter = pattern;
	}

	@Override
	public Date unmarshal(String dateText) {
		return DateUtils.parseDate(dateText);
	}

	@Override
	public String marshal(Date date) {
		return DateUtils.parseDateToStr(formatter, date);
	}

	public static final class DateTimeFormatDefault extends DateAdapter {

		public DateTimeFormatDefault() {
			super("yyyy-MM-dd HH:mm:ss");
		}
	}

	public static final class DateTimeFormatShort extends DateAdapter {

		public DateTimeFormatShort() {
			super("yyyyMMddHHmmss");
		}
	}
}

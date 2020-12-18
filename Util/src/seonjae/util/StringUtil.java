package seonjae.util;

import lombok.experimental.UtilityClass;

import java.text.DecimalFormat;
import java.util.List;

@UtilityClass
public class StringUtil {
	
	public String repeatString(String str, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) sb.append(str);
		return sb.toString();
	}
	
	public String connectString(List<String> list, String connectChar) {
		return connectString(list, 0, connectChar);
	}
	public String connectString(List<String> list, int start, String connectChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < list.size(); i++) {
			String msg = list.get(i);
			if (msg != null) sb.append((sb.length() < 1 ? "" : connectChar) + msg);
		}
		return sb.toString();
	}
	public String connectString(String[] array, String connectChar) {
		return connectString(array, 0, connectChar);
	}
	public String connectString(String[] array, int start, String connectChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < array.length; i++) {
			String msg = array[i];
			if (msg != null) sb.append((sb.length() < 1 ? "" : connectChar) + msg);
		}
		return sb.toString();
	}
	public String toDecimalFormat(long number, String pattern) {
		return new DecimalFormat(pattern).format(number);
	}
	public String toDecimalFormat(double number, String pattern) {
		return new DecimalFormat(pattern).format(number);
	}
}

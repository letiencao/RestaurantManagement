package com.letiencao.service;

public class BaseService {
	public boolean hasSpecialCharacter(String s) {
		// Dem so ky tu dac biet trong s
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			// Kiem tra la co ky tu dac biet thi ++ 1
			if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))
					&& !Character.isWhitespace(s.charAt(i))) {
				count++;
			}
		}
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
}

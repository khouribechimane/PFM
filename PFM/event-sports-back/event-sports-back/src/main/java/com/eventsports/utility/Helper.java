package com.eventsports.utility;

public class Helper {

	public static String generateEventBookingId() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(16);
		sb.append("B-");

		for (int i = 0; i < 14; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString().toUpperCase();
	}

	public static String generateBookingPaymentId() {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(16);
		sb.append("P-");

		for (int i = 0; i < 14; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString().toUpperCase();
	}

}

package com.rajhans.tenniscalculator;

public class Application {

	public static void main(String[] args) {
		String result;
		Match match = new Match("player 1", "player 2");
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		result = match.score();
		System.out.println(result);
		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		// this will return "0-0, 40-15"
		result = match.score();
		System.out.println(result);

		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		// this will return "0-0, Deuce"
		result = match.score();
		System.out.println(result);

		match.pointWonBy("player 1");
		// this will return "0-0, Advantage player 1"
		result = match.score();
		System.out.println(result);

		match.pointWonBy("player 1");
		// this will return "1-0"
		result = match.score();
		System.out.println(result);
	}
}

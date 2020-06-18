package com.rajhans.tenniscalculator;

import java.util.HashMap;

public class Match implements TennisMatch {
	
	private String player1Name;
	private String player2Name;
	
	private int match_score1 = 0;
	private int match_score2 = 0;
	private int won_game1 = 0;
	private int won_game2 = 0;
	
	private static final int ZERO = 0;
	private static final int FIFTEEN = 1;
	private static final int THIRTY = 2;
	private static final int FORTY = 3;
	private static final int OVER_FORTY = 4;
	
	HashMap<Integer,String> scoremap = new HashMap<Integer,String>() {{
	    put(ZERO, "0");
	    put(FIFTEEN, "15");
	    put(THIRTY, "30");
	    put(FORTY, "40");
	}}; 
	
	public Match(String player1, String player2) {
		player1Name = player1;
		player2Name = player2;
	}
	
	@Override
	public void pointWonBy(String playerName) {
		if(playerName == "player 1") {
			match_score1 += 1;
		} else {
			match_score2 += 1;
		}
	}

	@Override
	public String score() {
		if(isTie()) {
			return formatScore(tieScore()); 
		} else if(isWin()) {
			return formatScore(winScore());
		}
		return formatScore(noTieNoWinScore());
	}
	
	public boolean isTie() {
		return match_score1 == match_score2;
	}
	
	public boolean isWin() {
		return match_score1 >= OVER_FORTY || match_score2 >= OVER_FORTY;
	}
	
	public String winScore() {
		String score;
		int diff = match_score1 - match_score2;
		if(diff == 1) {
			score = "Advantage player 1";
		} else if (diff == -1) {
			score = "Advantage player 2";
		} else if (diff >= 2) {
			won_game1 += 1;
			score = "";
		} else {
			won_game2 += 1;
			score = "";
		}
		return score;
	}
	
	public String tieScore() {
		 switch(match_score1) {
		 case ZERO:
			 return "0-0";
		 case FIFTEEN: 
			 return "15-15";
		 case THIRTY:
			 return "30-30";
		 default:
			 return "Deuce";
		 }
	}
	
	public String noTieNoWinScore() {
		String score = "";
		int temp;
		for (int i = 1; i < 3; i++) {
			if(i==1) {
				temp = match_score1;
			} else {
				score += "-";
				temp = match_score2;
			}
			score += scoremap.get(temp);
		}
		return score;
	}
	
	public String formatScore(String score) {
		return won_game1 + "-" + won_game2 + ", " + score;
	}
}

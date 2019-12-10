package com.competition.mastercard;

import java.io.*;
import java.util.*;

public class CandidateCode {
   private static final int maxBatBowler = 6;
   private static final int minBatBowler = 3;
   private static final int maxWktAllrnder = 4;
   private static final int minWktAllrnder = 1;
   private static final int maxPlayerFromCt = 7;
   private static final int totalPlayer = 11;
   
   
   public static void main(String args[] ) throws Exception {
	   Scanner sc = new Scanner(System.in);
	   List<Player> playerList = new ArrayList<Player>();
	   for(int i=0; i<22; i++) {
		   String pol = sc.next();
		   int pt = sc.nextInt();
		   String ct = sc.next();
		   
		   Player player = new Player(pol, pt, ct);
		   playerList.add(player);
	   }
	   
	   
	   
	   sc.close();
   }
}


class Player{
	private String playerPool;
	private int playerPoint;
	private String cityOfOrigin;
	
	Player(String type, int pt, String cityName) {
		playerPool = type;
		playerPoint = pt;
		cityOfOrigin = cityName;
	}

	public String getPlayerPool() {
		return playerPool;
	}

	public int getPlayerPoint() {
		return playerPoint;
	}

	public String getCityOfOrigin() {
		return cityOfOrigin;
	}

	public void setPlayerPool(String playerPool) {
		this.playerPool = playerPool;
	}

	public void setPlayerPoint(int playerPoint) {
		this.playerPoint = playerPoint;
	}

	public void setCityOfOrigin(String cityOfOrigin) {
		this.cityOfOrigin = cityOfOrigin;
	}
}
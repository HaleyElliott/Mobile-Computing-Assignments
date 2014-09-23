package com.example.rock_paper_scissors;

import java.util.Random;

public class gameFile {
	public int randomNumber;
	
	public gameFile(){
		randomNumber = 0;
	}
		
	public String winner(int playersChoice){
		Random rand = new Random();
		//scissors = 1; rock = 2; paper = 3
	    int compChoice = rand.nextInt(3) + 1;
		if(compChoice == 1 && playersChoice == 2){
			return "player";
		}
		else if(compChoice == 1 && playersChoice == 3){
			return "computer";
		}		
		else if(compChoice == 2 && playersChoice == 1){
			return "computer";
		}
		else if(compChoice == 2 && playersChoice == 3){
			return "player";
		}
		else if(compChoice == 3 && playersChoice == 1){
			return "player";
		}
		else if(compChoice == 3 && playersChoice == 2){
			return "computer";
		}
		else{
			return "tie";
		}
	}
	
}

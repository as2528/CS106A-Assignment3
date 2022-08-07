// This file runs hangman games. It creates text, gives hints, and shows stats for the hangman games played. 

import acm.program.*;
import acm.util.*;
import java.io.*;    // for File
import java.util.*;  // for Scanner

public class Hangman extends HangmanProgram {
	
	public void run() {
		int gamesPlayed=0;
		int gamesWon = 0;
		int best = 0;
		int guessTrack = 0;
		while(gamesPlayed==0||readBoolean("Play again?","Y","N")) {
		intro();
		canvas.clear();
		gamesPlayed++;
		guessTrack = playOneGame("Programmer");
		if(guessTrack!=0) {
			if(guessTrack>best) {
				best=guessTrack;
			}
			gamesWon++;
		}
		}
		stats(gamesPlayed, gamesWon, best);
	}
	
	// This method will create only the intro text. 
	//input:nothing
	//output:intro text
	private void intro() {
		print("CS 106A Hangman!\n I will think of a random word.\nYou'll try to guess its letters\nEvery time you guess a letter\nthat isn't in my word, a new body appears.\nGuess correctly to avoid the gallows!\n");
	}

	// This method will run one game. 
	//input:Secret word from the run method. 
	//Output: The entire game
	private int playOneGame(String secretWord) {
		int guessTrack = 0;
		secretWord=secretWord.toUpperCase();
		guessTrack = outPut(secretWord);
		

	return guessTrack;
	}
	
	private String strDashes(String secretWord) {
		
		//This method makes the string of dashes that appears in the display by Secret Word
		//input:Secretword String 
		//output: A string of dashes with the number of dashes equalling the number of chars in the string
		
	String strDashes = "";

	for(int i=0; i!=secretWord.length();i++) {
		strDashes = strDashes.concat("-");
	}
	return strDashes;
	}
	
	private int outPut(String secretWord) {
		//This method runs a single game. 
		//input: Secret word
		//Output: The entire display screen for the game being played. It also returns an integer with the number of guesses left. 
		String guessRecord = "";
		int guessLeft = secretWord.length();

		while(guessLeft!=0 && (createHint(secretWord, guessRecord).equals(secretWord))==false) {
			
			
			println("Secret Word:"+createHint(secretWord, guessRecord));
			println("Your Guesses:"+guessRecord);
			println("Guesses Left:"+guessLeft);
			displayHangman(guessLeft);
			String userGuess = readLine("Your Guess?").toUpperCase();
			
			
		
		while(guessRecord.contains(userGuess)== true||userGuess.length()!=1) {
		
			while(guessRecord.contains(userGuess) ) {
				println(readGuess(userGuess));
				userGuess = readLine("Your Guess?").toUpperCase();
			}
			while(userGuess.length()!=1) {
				println(lengthLong());
				userGuess = readLine("Your Guess?").toUpperCase();
			}

		}
		if(guessRecord.contains(userGuess)== false &&userGuess.length()==1) {
		println(checkWord(secretWord, userGuess));}
		guessRecord+=userGuess;
		
		if(secretWord.contains(userGuess)!=true) {
			guessLeft-=1;
		}

	}
		if(guessLeft!=0) {
			println("You win! My word was "+secretWord);
			return guessLeft;
		}
		else {
			displayHangman(guessLeft);
			println("You lose");
			return 0;
		}


	}
	

	
	private String checkWord(String secretWord, String userGuess) {
		//Checks the guess against the word to see if the guess is correct
		//input:secret word as input
		//output: correct or incorrect guess

		if(secretWord.contains(userGuess)) {
			return "Correct";
		}
		else {
				return "Incorrect";
			
				
			}

		}
	
	
	// This method gives the dashed line output in the program. It will replace the dashes with letters that have been guessed as the game goes on. 
	//input: secret word, guessed letters
	//output:dashed with guessed letters replaced
	private String createHint(String secretWord, String guessedLetters) {

		int i=0;
		int k=0;
		String strDashes2 = strDashes(secretWord);
		if(guessedLetters.length()!=0) {
			for(i=0;i!=secretWord.length();i++) {
			for(k=0; k!=guessedLetters.length();k++) {
				
			if((guessedLetters.charAt(k)-secretWord.charAt(i))==0) { 
				
				int index = i;
				char replace = secretWord.charAt(i);
				strDashes2 = strDashes2.substring(0, index) + replace+ strDashes2.substring(index + 1);
				
						}
			}
		}
		return strDashes2;
	}
		else {
			return strDashes2;
		}
	}
	
	// This method will catch and return if any letters have been repeated in the players guesses
	//input:guessed letters
	//output:string saying the letter is guessed
	private String readGuess(String guessedLetters) {
		return("You already guessed that letter");
			
		}
	//This method activates if the user has entered something larger than a single letter in their guess.
	//input:nothing
	//output:string that says to type a single letter from A-Z
	private String lengthLong() {
		return("Type a single letter from A-Z");
	}
	
	// This method creates the ascii art. It uses a try and switch statement to achievbe this
	//input: number of guesses left
	//output: ascii art for the guess left
	private void displayHangman(int guessCount) {
		try{switch(guessCount) {


		case(8):
			canvas.clear();
			BufferedReader rd8 = new BufferedReader(new FileReader(("res/display8.txt")));
		
		String strRd8 = rd8.readLine();
		while(strRd8!=null){
		
			canvas.println(strRd8);
			strRd8 = rd8.readLine();
			}
			rd8.close();
			break;
		case(7):
			canvas.clear();
			BufferedReader rd7 = new BufferedReader(new FileReader(("res/display7.txt")));
		
		String strRd7 = rd7.readLine();
		while(strRd7!=null){
		
			canvas.println(strRd7);
			strRd7 = rd7.readLine();
			}
			rd7.close();
			break;
			
		case(6):
			canvas.clear();
			BufferedReader rd6 = new BufferedReader(new FileReader(("res/display6.txt")));
		
		String strRd6 = rd6.readLine();
		while(strRd6!=null){
		
			canvas.println(strRd6);
			strRd6 = rd6.readLine();
			}
			rd6.close();
			break;
			
		case(5):
			canvas.clear();
			BufferedReader rd5 = new BufferedReader(new FileReader(("res/display5.txt")));
		
		String strRd5 = rd5.readLine();
		while(strRd5!=null){
		
			canvas.println(strRd5);
			strRd5 = rd5.readLine();
			}
			rd5.close();
			break;
			
		case(4):
			canvas.clear();
			BufferedReader rd4 = new BufferedReader(new FileReader(("res/display4.txt")));
		
		String strRd4 = rd4.readLine();
		while(strRd4!=null){
		
			canvas.println(strRd4);
			strRd4 = rd4.readLine();
			}
			rd4.close();
			break;
			
		case(3):
			canvas.clear();
			BufferedReader rd3 = new BufferedReader(new FileReader(("res/display3.txt")));
		
		String strRd3 = rd3.readLine();
		while(strRd3!=null){
		
			canvas.println(strRd3);
			strRd3 = rd3.readLine();
			}
			rd3.close();
			break;
			
		case(2):
			canvas.clear();
			BufferedReader rd2 = new BufferedReader(new FileReader(("res/display2.txt")));
		
		String strRd2 = rd2.readLine();
		while(strRd2!=null){
		
			canvas.println(strRd2);
			strRd2 = rd2.readLine();
			}
			rd2.close();
			break;
			
		case(1):
			canvas.clear();
			BufferedReader rd1 = new BufferedReader(new FileReader(("res/display1.txt")));
		
		String strRd1 = rd1.readLine();
		while(strRd1!=null){
		
			canvas.println(strRd1);
			strRd1 = rd1.readLine();
			}
			rd1.close();
			break;
			
		case(0):
			canvas.clear();
			BufferedReader rd0 = new BufferedReader(new FileReader(("res/display0.txt")));
		
		String strRd0 = rd0.readLine();
		while(strRd0!=null){
		
			canvas.println(strRd0);
			strRd0 = rd0.readLine();
			}
			rd0.close();
			break;
		}

		}
		catch(IOException e) {
		    println("Please check file name");
		}
		}
	
	
	// Returns the stats of the games played
	//input: count of games, the count of games won, best guesses in game
	//output: text showing stats of the games
	private void stats(int gamesCount, int gamesWon, int best) {
		println("Overall Statistics:");
		println("Games Played:"+ gamesCount);
		println("Games won:"+gamesWon);
		println("Win Percent:"+((float)gamesWon/(float)gamesCount)*100);
		println("Best Game:"+best);
		println("Thanks for Playing!");
	}
	
	// TODO: comment this method
	private String getRandomWord(String filename) {
		// TODO: write this method
		
		return "";
	}
}

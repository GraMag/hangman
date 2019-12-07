package Actividad6;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		char[] word = wordOptions();
		
		result(theGame(theWord(word),word));
		playAgain();
		
		rectangleWithMessages(0, "");
	}


	private static void rectangleWithMessages(int num, String message) {
		
		// A decorative sign.
		
		for (int i = 0; i < num; i++) {
			System.out.print("="); 
	}
		System.out.println("");
		
		System.out.println(message);
		
		for (int i = 0; i < num; i++) {
			System.out.print("=");
	}
		System.out.println("");
	}
	
	private static void playAgain() {
		
		// The game starts again or ends.
	
		char keepPlaying = ' ';
		do {
		System.out.println("Jugar otra vez? S/N");
		Scanner enter = new Scanner(System.in);
	keepPlaying = enter.nextLine().toUpperCase().charAt(0);
	switch (keepPlaying) {
	case 'S':
		char[] word = wordOptions();
		result(theGame(theWord(word),word));
		break;
	case 'N':
		rectangleWithMessages(30, "||  Gracias, vuelva prontos ||");
		break;
	default:
		System.out.println("Opción incorrecta");
		break;
	}
	
	} while (keepPlaying != 'N');
	}

	

	private static void result(boolean win) {
		// Este metodo indica si se gano o se perdio el juego

		if (!win) { // Game Over
			rectangleWithMessages(24,"||  X.X GAME OVER X.X ||");
		} else { // WIN :D !!!
			rectangleWithMessages(22,"|| ^_^ GANASTE! ^_^ ||");
		}
	}

	private static boolean theGame(char[] answer, char[] word) {
		/* 
		 * 
		 */
		
		int lifes = 5; // Life at the beginning
		int points = 0; // Score at the beginning
		String bad = ""; // Wrong letters accumulator
		boolean win = true;
		
		do { // Do while life > 0	
			
		
		// Letter in

		System.out.println("Ingrese una letra:");
		Scanner enter = new Scanner(System.in);
		char letter = enter.nextLine().toUpperCase().charAt(0); // Lee la letra, lo pone en mayuscula y toma solo el primer caracter en caso de que le pifie y ponga mas de una letra.
		
		boolean flag = false;
		
		
		for (int i = 0; i < word.length; i++) { // Compara la letra ingresada con el array de la pla
			if  (letter == word[i]) {
				answer[i] = letter;
				flag = true;
			}   
		
		System.out.print(answer[i] + " ");

		}	

		System.out.println("");
		
		if (flag == false) { // Acumula las letras erradas
			
		bad = bad + letter + " ";	
		
		System.out.print(bad);
		
		}
		
		System.out.println(" ");
		
		
		if (flag == false) { // Cuenta las vidas
			lifes = lifes-1;
			
			switch (lifes) {
			case 4:
				System.out.println("Vidas restantes: " + lifes + ". No pasa nada. :)");
				break;
			case 3:
				System.out.println("Vidas restantes: " + lifes + ". Querés un diccionario?");
				break;
			case 2:
				System.out.println("Vidas restantes: " + lifes + ". Ay, ay, ay.");
				break;
			case 1:
				System.out.println("Vidas restantes: " + lifes + ". Dedicate al tateti.");
				break;
			default:
				System.out.println(word);
				break;
			}
		} else {
			System.out.println("Vidas restantes: " + lifes);
		}
		
		if (flag == false) {
			points = points - 10;
		} else {
			points = points + 5;
		}
		
		System.out.println("Puntos: " + points);
	
		if (lifes == 0) {
			win = false;
		}
		
		boolean endOFTheGame = true;
		for (int i = 0; i < word.length; i++) {
			if (answer[i] == '_') {
				endOFTheGame = false;
			}
		}
		if (endOFTheGame) {
			lifes = 0;
			win = true;
		}			
		} while (lifes > 0);
		
		return win;
	}

	private static char[] theWord(char[] word) { 
		
		/* Blank spaces:
		 * This method takes the word length and turn it into 
		 * char[] answer fill with '_' to hide the characters and show its length.
		 */
		
		char[] answer = new char[word.length];
		for (int i = 0; i < word.length; i++) {
			answer[i] = '_';
			System.out.print(answer[i] + " ");
		}
		
		System.out.println("");
		
		return answer;
	}

	private static char[] wordOptions() {
		
		// Random words to play with.
		
		String[] dictionary = {"Camilla", "Perro", "Otorrinolaringologo", "Pi", "Java", "Hipocampo", "Gato", "Elegante", "Google", "Murcielago"};
		char[] word = dictionary[(int)(Math.random() * dictionary.length)].toUpperCase().toCharArray();
		return word;
	}
}




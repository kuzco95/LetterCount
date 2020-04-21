package driver;
import java.util.Scanner;
public class main {
/* This project was made for to help solve a problem for my Info Sec class
 * at University College: Dublin during Semester 2, 2019. The console takes
 * user input and counts the frequency of the letters entered. Using the 
 * letter frequency helped me decrypt a message that was part of my assignment. 
 */
	public static void main(String[] args){
		System.out.println("Enter a string.");
		String userText;
		Scanner textIn = new Scanner(System.in);
		userText = textIn.nextLine().toUpperCase();
		textIn.close();	
		counter(userText);
		return;
		}

	static void counter(String userText){
			char alphabet[] = new char[26];
			char i = 65; //65 is ASCII value for 'A'
			
			//instantiate alphabet using ASCII values
			for(int a = 0; a < 26; a++) {
				alphabet[a] = i;
				i++;
				System.out.print(alphabet[a]);
			}
			
			//instantiate counter for each letter
			int counterArr[] = new int[26];
			for(int x = 0; x < 26; x++) {
				counterArr[x] = 0;
			}
						
			System.out.printf("\nSTRING LENGTH: %d\n", userText.length());
			int index;
			
			//iterate through string
			for(int c = 0; c < userText.length(); c++){
				char letter = userText.charAt(c);
				//compare values
				for(index = 0; index < 26; index++) {
				if(letter == alphabet[index]) counterArr[index]++;
				}
			}
			printValues(counterArr, alphabet);
			bubbleSort(counterArr, alphabet);
	}

	public static void bubbleSort(int[] arr, char [] arrJr) {
		//code from: http://www.algolist.net/Algorithms/Sorting/Bubble_sort
		//modified to sort alphabet array as well
	    boolean swapped = true;
	    int j = 0;
	    int tmp;
	    char tmpA;
	
	    while (swapped) {
	          swapped = false;
	          j++;
	          for (int i = 0; i < arr.length - j; i++) {                                       
	                if (arr[i] > arr[i + 1]) {                          
	                      tmp = arr[i];
	                      tmpA = arrJr[i];
	                      
	                      arr[i] = arr[i + 1];
	                      arr[i + 1] = tmp;
	                      
	                      arrJr[i] = arrJr[i+1];
	                      arrJr[i+1] = tmpA;
	                      swapped = true;
	                }
	          }                
	    }
	    printValues(arr, arrJr);
	}
	
	public static void printValues(int[] countArr, char [] letterArr) {
		int col = 0;
		int index;
		System.out.print("\n");
	    for(index = 0; index < 26; index++) {
			
			System.out.printf(" %s: %d \t", letterArr[index], countArr[index]);
			col++;
			if(col > 4) {
				System.out.print("\n");
				col = 0;
			}
		}
	}
}

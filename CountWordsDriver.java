/**
 * 
 * This project took me about 1 and a half hours. I 
 * struggled a bit with my strategy, because at first I
 * tried to use arrays, however, I soon figured out that 
 * using arraylists was much eaiser. I also struggled with 
 * removing the non letter parts of the word using 
 * javas built in methods, but that didn't work so I mad 
 * my own method.
 * 
 */




import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountWordsDriver {

	

	public static void main(String[] args) {
	//	print(read("lincoln.txt"));
//		ArrayList<Word> a = new ArrayList<Word>();
//		Word word = new Word("Cat", 2);
//		a.add(word);
//		Word word2 = new Word("Bat", 3);
//		a.add(word2);
//		Word word3 = new Word("Sat", 4);
//		a.add(word3);
//		Word word4 = new Word("Hat", 1);
//		a.add(word4);
//		
//		System.out.println(a);
		//sort(a);
		//print(a);
		ArrayList<Word> b = read("lincoln.txt");
		//print(b);
		sort(b);
		print(b);
		//System.out.println(remove(remove(remove(",@%happy", ','), '@'), '%'));
		//System.out.println(convert(",@%happy"));
		
		
		
		
		

	}
	public static ArrayList<Word> read(String fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		ArrayList<Word> a = new ArrayList<Word>();
		int i = 0;
		boolean cont = false;
		while(true) {
			try {
				String line = scanner.nextLine();
				String[] strs = line.split(" ");
				for(String str : strs) {
					str = convert(str);
					if(str.length()==0) continue;
					
					Word w = new Word(str, 1);
					if(contains(w, a)>=0) {
						a.get(contains(w,a)).setFreq(a.get(contains(w,a)).getFreq()+1);
					}
					else {
						a.add(i, w);
						i++;
					}
					
				}
				
				
				
			} catch(NoSuchElementException e) {
				
				break;
			}
		}
		return a;
		
	}
	//return  index of word if its there
	// other wise returns -1
	public static int contains(Word w, ArrayList<Word> a) {
	//	if(a==null) return -1;
		w.setName(w.getName().toLowerCase()); 
		for(int i = 0; i<a.size(); i++) {
			if(a.get(i).equals(w)) return i;
		}
		return -1;
	}
	public static void print(ArrayList<Word> a ) {
	
		
		for(int i = 0; i<30; i++) {
			System.out.println((i+1) + "\t" + a.get(i).toString());
			
		}
		System.out.println("Number of unique words used = " + a.size());
		int w = 0;
		for(int i = 0; i<a.size();i++) {
			w = w + a.get(i).getFreq();
		}
		System.out.println("Total # of words = " + w);
		
		
	}
	public static void sort(ArrayList<Word> a) {
		for(int i = 1; i<a.size(); i++) {
			Word target = a.get(i);
			int ind = i;
			//System.out.println(a.get(ind).getFreq());
			while(ind>0 && a.get(ind-1).getFreq()<target.getFreq()) {
			//	System.out.println(a.get(ind).getFreq());
				
				ind--;
			}
			a.add(ind, a.remove(i));
			//System.out.println(a);
		}
		
	}
	
	private static void swap(ArrayList<Word> a, int i, int k) {
		Word temp = a.get(i);
		a.set(i, a.get(k));
		a.set(k, temp);
		
	}
	public static String convert(String str) {
		int i = 0;
		while(i<str.length()) {
			char a = str.charAt(i);
			if(a<96 ||a>122) {
				 str = remove(str, str.charAt(i));
				
			}
			else {
				i++;
			}
		}
		return str;
	}
	public static String remove(String str, char a) {
		str = str.toLowerCase();
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)==a) {
				str = str.substring(0,i).concat(str.substring(i+1,str.length()));
			}
		}
		return str;
	}
	

}
class Word implements Comparable<Word>{
	String name;
	int freq;
	public Word(String nam, int fre) {
		name = nam;
		freq = fre;
	}
	public String getName() {
		return name;
	}
	public int getFreq() {
		return freq;
	}
	public void setName(String nam) {
		name = nam;
	}
	public void setFreq(int fre) {
		freq = fre;
	}
	public int compareTo(Word w) {
		return freq - w.getFreq();
	}
	public boolean equals(Word w) {
		return name.equals(w.getName());
	}
	public String toString() {
		return freq + "\t" + name;
	}
	
}





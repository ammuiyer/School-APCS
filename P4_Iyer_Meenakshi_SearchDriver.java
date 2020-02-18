import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * 
 * 
 * @author meenakshiiyer
 * This lab took me baout 20 minutes to do. I struggled with loading the file 
 * a bit since I forgot things from Filereader. 
 * 
 * 
 * Second Reflection:
 * This is a resubmit because my code didn't work the first time.  I realized that 
 * my problem was in the sort method, I called merge instead of mergeSort. Very dumb of me.
 * 
 *
 * Lab 19.2 Reflection:
 * This lab was pretty easy. I struggled a bit on the recursive binary search but I realized that
 * the reason it didnt work was because of Parentheses. I did first + last/2 instead of (first + last)/2. 
 * This is very dumb of me. I also lost 1/2 a point on my math test because of parentheses. 
 *
 */



public class P4_Iyer_Meenakshi_SearchDriver {
	
	public static void main(String[] args) {
//		FileWriter f;
//		try {
//			f = new FileWriter("output.txt");
//			f.write("hi");
//			f.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		Store s = new Store("file50.txt");
		s.sort();
		s.displayStore();
		s.testSearch();
	}
}

		
class Item implements Comparable<Item> {

	private int myId;
	private int myInv;

	/**
	*  Constructor for the Item object
	*
	* @param  id   id value
	* @param  inv  inventory value
	*/	
	public Item(int id, int inv){
		myId = id;
		myInv = inv;
	}
	
	/**
	*  Gets the id attribute of the Item object
	*
	* @return    The id value
	*/	
	public int getId(){
		return myId;
	}
	
	/**
	*  Gets the inv attribute of the Item object
	*
	* @return    The inv value
	*/	
	public int getInv(){
		return myInv;
	}
	
	/**
	*  Compares this item to another item based on id number. Returns the
	*  difference between this item's id and the other item's id. A
	*  difference of zero means the items' ids are equal in value.
	*
	* @param  other  Item object to compare to
	* @return        positive int if myId > other.myId
	*                0 if myId == other.myId
	*                negative int if myId < other.myId
	*/	
	public int compareTo(Item other){
		return myId-other.getId();
	}
	
	/**
	*  Compares the Item to the specified object
	*
	* @param  otherObject  Item object to compare to
	* @return              true if equal, false otherwise
	*/	
	public boolean equals(Item other){
		if(this.compareTo(other)==0) {
			return true;
		}
		return false;
	}

	/**
	*  Overrides the default toString() of Object.
	*  Returns a String representation of this object. It's up to you
	*  exactly what this looks like.
	*/
	public String toString(){
		return  myId + "\t " + myInv ;
	}
}	


class Store {

	private ArrayList <Item> myStore = new ArrayList <Item>();

	/**
	*  Creates a Store object from data stored in the given file name
	*
	*  @param  fName  name of the file containing id/inv pairs of data
	*/
	public Store(String fName){
		loadFile(fName);
	}
	
	/**
	*  Reads a file containing id/inv data pairs one pair per line. 
	*
	*  @param  inFileName  name of file containing id/inv pairs of data
	*/
	private void loadFile(String inFileName){
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(inFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				String line = scanner.nextLine();
				Scanner scanner2 = new Scanner(line);
				int myId = Integer.parseInt(scanner2.next());
				int myInv = Integer.parseInt(scanner2.next());
				Item item = new Item(myId, myInv);
				myStore.add(item);
				
			}
			catch(NoSuchElementException e) {
				break;
			}
		}
	}
	
	/**
	*  Prints the store contents in the format shown below
	*  Line #   	Id	     	Inv
	*  1	       	184	    	14
	*  2	       	196	    	60
	*/
	public void displayStore(){
		
		System.out.println("Line #\t Id\t Inv");
		
		for(int i = 0; i<myStore.size(); i++) { 
			if(i%10==0)System.out.println();
			System.out.println(i+1  + "\t" + myStore.get(i).toString());
			
		}
	}

	/**
	*  Sorts the store ArrayList using recursive mergesort
	*/
	public void sort(){
		mergeSort(myStore, 0, myStore.size()-1);
		// (If your mergeSort is broken, then use a quadratic sort)
	}
	
	private void merge(ArrayList <Item> a, int first, int mid, int last){
		
		  int i = first;
		  
			int j = mid;
			
			ArrayList <Item> b = new ArrayList <Item>();
			
			while(i<mid || j<=last) {
				
				if(i>mid-1) {

					
					b.add(a.get(j));
					
					j++;
					
				}
			
				else if(j>last) {
					
					b.add(a.get(i));

					i++;

				}
				
				else if((a.get(i).compareTo(a.get(j))<0)) {
					
					b.add(a.get(i));
					
					i++;
				}
				else if((a.get(j).compareTo(a.get(i))<=0)) {
					
					b.add(a.get(j));
					
					j++;
				}
				
				
			}
			for(int k = first; k<=last; k++) {
				
				a.set(k, b.get(k-first));
			}
			//System.out.println(a);
			
	  }
	
	
	/**
	*  Recursive mergesort of an ArrayList of Items
	*
	* @param  a      reference to an ArrayList of Items to be sorted
	* @param  first  starting index of range of values to be sorted
	* @param  last   ending index of range of values to be sorted
	*/
	public void mergeSort(ArrayList <Item> a, int first, int last){
		if(first==last) {
			
		}
		else if(last==first + 1) {
			if(a.get(last).compareTo(a.get(first))<0) {
				Item temp = a.get(last);
				a.set(last, a.get(first));
				a.set(first, temp);
			}
		}
		else {
			 
			int mid = (first+last)/2;
			//System.out.println(mid);
			
			 
			mergeSort(a, first, mid);
			mergeSort(a, mid, last);
			merge(a, first, mid, last);
			
			
		}
		
	}
	public void testSearch(){
		   int idToFind;
		   int invReturn;
		   int index;
		   Scanner in = new Scanner(System.in);

		   System.out.println("Testing search algorithm\n");
		   do{
		      System.out.println();
		      System.out.print("Enter Id value to search for (-1 to quit) ---> ");
		      idToFind = in.nextInt();
		      //index = bsearch(new Item(idToFind, 0));
		      //recursive version call
		      index = bsearch (new Item(idToFind, 0), 0, myStore.size()-1);
		      System.out.print("Id # " + idToFind);
		      if (index == -1){
		         System.out.println(" No such part in stock");
		      }else{
		         System.out.println(" Inventory = " + myStore.get(index).getInv());
		      }
		   } while (idToFind >= 0);
		}

		/**
		   * Searches the myStore ArrayList of Item Objects for the specified
		   * item object using a iterative binary search algorithm
		   *
		   * @param idToSearch Item object containing id value being searched for
		   * @return index of Item if found, -1 if not found
		*/
		private int bsearch(Item idToSearch){
			int f = 0; 
			int l = myStore.size()-1;
			while(l>=f) {
				int m = (f+l)/2;
				if(myStore.get(m).compareTo(idToSearch)==0) return m;
				else if(idToSearch.compareTo(myStore.get(m))>0) {
					f = m+1;
					
				}
				else if(idToSearch.compareTo(myStore.get(m))<0) {
					l = m-1;
				}
				
			}
			return -1; 
		}

		/**
		* Searches the specified ArrayList of Item Objects for the specified
		   * id using a recursive binary search algorithm
		   *
		   * @param idToSearch Id value being search for
		   * @param first Starting index of search range
		   * @param last Ending index of search range
		   * @return index of Item if found, -1 if not found
		*/
		private int bsearch(Item idToSearch, int first, int last){
			int mid = (first+last)/2;
			if(last<first)return -1;
			if(myStore.get(mid).compareTo(idToSearch)==0) {
				return mid;
			}
			else if(idToSearch.compareTo(myStore.get(mid))>0) {
				return bsearch(idToSearch, mid+1, last);
			}
			else if(idToSearch.compareTo(myStore.get(mid))<0) {
				return bsearch(idToSearch, first, mid-1);
			}
		   return -1;
		}
}		
	
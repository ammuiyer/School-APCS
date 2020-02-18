/**
 * 
 * This lab took me about half an hour. It may not be right because I included methods as 
 * as a step as well. I was intrigued by the fact that insertion sort wasn't as effecient as 
 * I expected.
 */
import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Meenakshi Iyer
 * @created    Jan 16, 2020
 */
public class P4_Iyer_Meenakshi_Sorts{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  public P4_Iyer_Meenakshi_Sorts(){
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(ArrayList <Comparable> list){
	  steps+=2;
	for(int end = 0; end<list.size() -1 ; end++) {
		steps+=2;
		for(int i = list.size()-1; i>end;i--) {
			swap(list, i, i-1);
			steps+=1;
		}
		steps+=1;
	}
	System.out.println();
	System.out.println("Bubble Sort");
	System.out.println();
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(ArrayList <Comparable> list){
	  steps+=2;
	  for(int end = list.size() -1; end>0; end--) {
		  steps+=2;
			Comparable max = list.get(end);
			steps+=1;
			int maxIndex = end;
			steps+=2;
			for(int i = end-1; i>=0; i--) {
				steps+=3;
				if(list.get(i).compareTo(max)>0) {
					steps+=2;
					max = list.get(i);
					steps+=1;
					maxIndex = i;
				}
				steps+=1;
			}
			swap(list, maxIndex, end);
			System.out.println(list);
			
			steps+=1;
		}
	System.out.println();
	System.out.println("Selection Sort");
	System.out.println();
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(ArrayList <Comparable> list){
	  steps+=2;
	  for(int out = 1; out<list.size(); out++) {
		  steps+=1;
			int outInd = out;
			steps+=2;
			Comparable target = list.get(out);
			steps+=4;
			while(outInd>0 && list.get(outInd-1).compareTo(target)>0) {
				
				steps+=1;
				outInd--;
				steps+=4;
			}
			list.remove(out);
			steps+=1;
			list.add(outInd, target);
			steps+=1;
			
			steps+=1;	
	}
	System.out.println(steps);
	System.out.println("Insertion Sort");
	System.out.println();

	
  }


 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  private void merge(ArrayList <Comparable> a, int first, int mid, int last){
	//replace these lines with your code
	System.out.println();
	System.out.println("Merge");
	System.out.println();

  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(ArrayList <Comparable> a, int first, int last){
	//replace these lines with your code
	System.out.println();
	System.out.println("Merge Sort");
	System.out.println();
  }

 
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount(){
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(long stepCount){
    steps = stepCount;
  }
  
   /**
   *  Interchanges two elements in an ArrayList
   *
   * @param  list  reference to an array of integers
   * @param  a     index of integer to be swapped
   * @param  b     index of integer to be swapped
   */
  public void swap(ArrayList <Comparable> list, int a, int b){
	  steps+=2;
	  	Comparable temp = list.get(a);
	  	steps+=3;
		list.set(a, list.get(b));
		steps+=2;
		list.set(b, temp);
	System.out.println();
	System.out.println("Swap");
	System.out.println();
  }
}
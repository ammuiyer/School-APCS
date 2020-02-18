/**
 * This lab took me about an hour because I was debugging the merge method.  I finally realized
 * that instead of adding arr.get(i) to the arrayList, I was adding i. This made numbers that
 * weren't in the arrayList show up which made me very confused.
 * 
 */

import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
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
	System.out.println();
	System.out.println("Bubble Sort");
	System.out.println();
		}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(ArrayList <Comparable> list){
	  for(int out = 1; out<list.size(); out++) {
			int outInd = out;
			Comparable target = list.get(out);
			while(outInd>0 && list.get(outInd-1).compareTo(target)>0) {
				
				
				outInd--;
			}
			list.remove(out);
			list.add(outInd, target);
			System.out.println(list);
		
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
	  long startTime = System.currentTimeMillis();
	  selectionSort(list);
	  long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
		System.out.println(steps);
	System.out.println();
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
	  steps++;
	  int i = first;
	  steps++;
		int j = mid;
		steps+=2;
		ArrayList <Comparable> b = new ArrayList <Comparable>();
		
		while(i<mid || j<=last) {
			steps+=3;
//			System.out.println(i);
//			System.out.println(j);
//			System.out.println((i>mid-1));
			steps+=2;
			if(i>mid-1) {
//				System.out.println("cat");
				steps+=2;
				b.add(a.get(j));
				steps+=1;
				j++;
				
			}
		
			else if(j>last) {
				steps+=2;
				steps+=3;
				b.add(a.get(i));

				i++;

			}
			
			else if((a.get(i).compareTo(a.get(j))<0)) {
				steps+=4;
				steps+=3;
				b.add(a.get(i));
				
				i++;
			}
			else if((a.get(j).compareTo(a.get(i))<=0)) {
				steps+=4;
				steps+=3;
				b.add(a.get(j));
				
				j++;
			}
//			System.out.println(i);
//			System.out.println(j);
//			System.out.println(a);
//			System.out.println(b);
			
			
			
		}
		for(int k = first; k<=last; k++) {
			steps+=3;
			a.set(k, b.get(k-first));
		}
		//System.out.println(a);
		System.out.println();
		System.out.println("Merge");
		System.out.println();

  }
  public void mergeSort(ArrayList <Comparable> a, int first, int last) {
	  long startTime = System.currentTimeMillis();
	 mergessort(a,first, last);
	  long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
		System.out.println(steps);
  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergessort(ArrayList <Comparable> a, int first, int last){
	  System.out.println(a);
	  steps+=1;
	if(first==last) {
		
	}
	else if(last==first + 1) {
		 steps+=1;
		 steps+=4;
		if(a.get(last).compareTo(a.get(first))<0) {
			 steps+=2;
			Comparable temp = a.get(last);
			 steps+=2;
			a.set(last, a.get(first));
			 steps+=2;
			a.set(first, temp);
		}
	}
	else {
		 steps+=1;
		int mid = (first+last)/2;
		//System.out.println(mid);
		
		 steps+=3;
		mergeSort(a, first, mid);
		mergeSort(a, mid, last);
		merge(a, first, mid, last);
		
		
	}
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
	  Comparable temp = list.get(a);
	  list.set(a, list.get(b));
	  list.set(b, temp);
		
	System.out.println();
	System.out.println("Swap");
	System.out.println();
  }
  
  public void QuickSort(ArrayList<Comparable> a, int start, int end) {
	  setStepCount(0);
	  long startTime = System.currentTimeMillis();
	  quickSort(a,start, end);
	  long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
		System.out.println(steps);
		
  }
  
  public void quickSort(ArrayList<Comparable> a, int start, int end){
	  
	
	
	  steps+=1;
		  
		if(start<end) {
			steps+=1;
			int pivot = move(a,start,end);
			steps+=2;
			quickSort(a, start, pivot-1);
			quickSort(a, pivot+1, end);
		}
		
		
	}
  


	public  int move(ArrayList<Comparable> a, int start, int end) {
		steps+=1;
		Comparable pivot = a.get(end);
		steps+=1;
		int i = start-1;
		
		for(int k = start; k<=end-1; k++) {
			steps+=3;
			if(a.get(k).compareTo(pivot)<=0) {
				steps+=3;
				i++;
				steps+=1;
				swap(a,i,k);
				//System.out.println(a);
			}
		}
		steps+=1;
		i++;
		steps+=1;
		swap(a,i, end);
		System.out.println(a);
		steps+=1;	
		return i;
	}


	


}
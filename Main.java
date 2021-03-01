import java.util.*;
import java.io.*;

class Main{
   public static void main(String[] args) throws IOException {
    int[] arr1 = {5, 9, 3, 4, 2, 0, 9};
    stats("Text.txt");
    
  }

  public static String[] insert(String s, int i, String[] a, int logicalSize){
    String[] aCopy = Arrays.copyOf(a, a.length);
    if(logicalSize == a.length){
      return null;
    }

    if(a[i] == null){
      aCopy[i] = s; 
    }
    else{
      for(int b = a.length - 1; b >= i; b--){
        if(aCopy[b] != null){
          aCopy[b + 1] = aCopy[b];
          aCopy[b] = null;
        }
      }
      aCopy[i] = s;
    }
    
    
    for(String x : aCopy){
      System.out.println(x);
    }
    return aCopy;
  }
  
  public static int[] delete(int target, int[] a, int logicalSize){
    int[] copy = new int[a.length - 1];
    int position = 0;

    for(int i = 0; i < logicalSize - 1; i++){
      if(a[i] != target){
        copy[i] = a[i];
      }
      else{
        position = i;
        break;
      }
    }

    for(int i = position; i < logicalSize - 1; i++){
      copy[i] = a[i + 1];
    }

    for(int x : copy){
      System.out.println(x);
    }
    return copy;
  }

  public static void stats(String filename) throws IOException{
    Scanner fileReader = new Scanner(new File(filename));
    int[] buffer = new int[5000];
    int count = 0;

    while(fileReader.hasNext()){
      buffer[count] = fileReader.nextInt();
      count++;
    }

    int[] numbers = Arrays.copyOf(buffer, count);
    buffer = null;



    System.out.println("Mean: " + getMean(numbers));
    System.out.println("Median: " + getMedian(numbers));
    System.out.println("Standard Deviation: " + Lab.stdev(numbers));
    
  }


  private static double getMean(int[] arr1){
    double counter = 0;
    for(int x : arr1){
      counter += x;
    }

    return counter / arr1.length;
  }

  private static double getMedian(int[] arr1){
    int[] arr2 = Arrays.copyOf(arr1, arr1.length);
    double median = 0;
    Arrays.sort(arr2);
    
    if(arr2.length % 2 == 0){
      median = ((double)(arr2[(arr2.length/2) - 1]) + (double)(arr2[(arr2.length/2)])) / 2;
    }
    else{
      median = arr2[((int)arr2.length/2) + 1];
    }
    return median;
  }
}
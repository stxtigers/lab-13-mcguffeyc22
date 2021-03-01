import java.util.Arrays;
import java.lang.Math;

public class Lab{
  public static void main(String[] args){
    int[] arr1 = {8, 3, 5, 7, 2, 4};
    int[] arr2 = {500, 300, 241, 99, 501};
    
  }

  public static int lastIndexOf(int[] list, int target){
    for(int i = 0; i < list.length; i++){
      if(list[i] == target){
        return i;
      }
    }
    return -1;
  }

  public static int range(int[] list){
    int[] ListCopy = Arrays.copyOf(list, list.length);
    Arrays.sort(ListCopy);
    System.out.println("Largest Num = " + ListCopy[ListCopy.length - 1] + " Smallest Num = " + ListCopy[0]);
    return (ListCopy[ListCopy.length - 1] - ListCopy[0]) + 1;
  }

  public static int countInRange(int[] list, int min, int max){
    int counter = 0;
    for(int i = 0; i < list.length; i++){
      if(list[i] >= min && list[i] <= max){
        counter++;
      }
    }
    return counter;
  }

  public static boolean isSorted(double[] list){
    if(list.length <= 1){
      return true;
    }
    for(int i = 0; i < list.length - 1; i++){
      if(list[i] > list[i + 1]){
        return false;
      }
    }
    return true;
  }

  public static double stdev(int[] a){
    double sum = 0.0;
    double standardDeviation = 0.0;
    int length = a.length;

    for(int num : a) {
      sum += num;
    }

    double mean = sum/length;

    for(int num: a) {
      standardDeviation += Math.pow(num - mean, 2);
    }

    return Math.sqrt(standardDeviation/length);

  }

  public static int kthLargest(int k, int[] a){
    int[] aCopy = Arrays.copyOf(a, a.length);
    if(k < a.length){
      Arrays.sort(aCopy);
      return aCopy[(a.length) - k];
    }
    return 0;
  }
  
  public static int minGap(int[] a){
    int[] holdArr = new int[a.length - 1];
    if(a.length < 2){
      return 0;
    }
    for(int i = 0; i < holdArr.length; i++){
      holdArr[i] = a[i + 1] - a[i];
    }
    Arrays.sort(holdArr);
    return holdArr[0];
  }
  
  public static int priceIsRight(int[] bids, int price){
    int[] newArr = new int[bids.length + 1];
    for(int i = 0; i < bids.length; i++){
      newArr[i] = bids[i];
    }
    
    newArr[bids.length] = price;
    Arrays.sort(newArr);
    int position = 0; 
    for(int i = 0; i < newArr.length; i++){
      if(newArr[i] == price){
        position = i; 
        break;
      }
    }
    if(position == 0){
      return -1;
    } 
    return newArr[position - 1];
  }
  
  public static int[] vowelCount(String str){
    char[] cstr = new char[str.length()];
    str = str.toLowerCase();
    str.getChars(0, str.length(), cstr, 0);
    int[] count = new int[5];
    
    for(char c: cstr){
      if(c == 'a'){
        count[0] += 1;
      }
      else if(c == 'e'){
        count[1] += 1;
      }
      else if(c == 'i'){
        count[2] += 1;
      }
      else if(c == 'o'){
        count[3] += 1;
      }
      else if(c == 'u'){
        count[4] += 1;
      }
      
      
    }
    for(int x : count){
      System.out.println(x);
    }
    return count;
  }
}
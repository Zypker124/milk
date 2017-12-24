
/*
ID: angusjy1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader reader = new BufferedReader(new FileReader("milk.in"));
                                                  // input file name goes above
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(reader.readLine());
						  // Get line, break into tokens
    int amountOfMilk = Integer.parseInt(st.nextToken());
    int numOfFarmers = Integer.parseInt(st.nextToken());
    ArrayList<Integer> price = new ArrayList<Integer>();
    ArrayList<Integer> milkOffered = new ArrayList<Integer>();
    while(true){
    	try{
    		st = new StringTokenizer(reader.readLine());
    	}catch(NullPointerException np){
    		break;
    	}
    	price.add(Integer.parseInt(st.nextToken()));
    	milkOffered.add(Integer.parseInt(st.nextToken()));
    }
    int[][] priceAndMilk = new int[price.size()][2];
    for(int ind = 0; ind < price.size(); ind++){
    	priceAndMilk[ind][0]=price.get(ind);
    	priceAndMilk[ind][1]=milkOffered.get(ind);
    }
    priceAndMilk = doInsertionSort(priceAndMilk);
    for(int ind = 0; ind < priceAndMilk.length; ind++){
    	System.out.println(priceAndMilk[ind][0]+"|"+priceAndMilk[ind][1]);
    }
    int currentMilk = 0;
    int totalPrice = 0;
    int index = 0;
    while(currentMilk < amountOfMilk){
    	int priceOfMilk = priceAndMilk[index][0];
    	int milkAmount = priceAndMilk[index][1];
    	if(milkAmount < amountOfMilk - currentMilk){
    		totalPrice+=priceOfMilk*milkAmount;
    		currentMilk+=milkAmount;
    	}else{
    		int remainingMilkNeeded = amountOfMilk - currentMilk;
    		totalPrice+=priceOfMilk*remainingMilkNeeded;
    		break;
    	}
    	index++;
    }
    writer.println(totalPrice);
    writer.close();                                  // close the output file
  }
  
  public static int[] doInsertionSort2(int[] input){
      
      int temp;
      for (int i = 1; i < input.length; i++) {
          for(int j = i ; j > 0 ; j--){
              if(input[j] < input[j-1]){
                  temp = input[j];
                  input[j] = input[j-1];
                  input[j-1] = temp;
              }
          }
      }
      return input;
  }
  
  public static int[][] doInsertionSort(int[][] input){
      
      int[] temp;
      for (int i = 1; i < input.length; i++) {
          for(int j = i ; j > 0 ; j--){
              if(input[j][0] < input[j-1][0]){
                  temp = input[j];
                  input[j] = input[j-1];
                  input[j-1] = temp;
              }
          }
      }
      return input;
  }
}
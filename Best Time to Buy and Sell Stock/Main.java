// Best Time to Buy and Sell Stock; complete: y
// date: 09.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};

		Solution obj = new Solution();
		System.out.println(obj.maxProfit(prices));
	}
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        
        int profit = 0, maxprice = 10001;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < maxprice) maxprice = prices[i];
            
            if (prices[i] - maxprice > profit) profit = prices[i] - maxprice;
        }
        
        return profit;
    }   
}
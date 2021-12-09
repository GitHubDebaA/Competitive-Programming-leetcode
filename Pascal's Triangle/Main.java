// Pascal's Triangle; complete: y
// date: 09.12.2021

import java.util.*;
class Main {
	public static void main(String[] args) {
		int numRows = 5;
        List<List<Integer>> pascalList = new ArrayList <> ();

		Solution obj = new Solution();

		pascalList = obj.generate(numRows);

		for(List<Integer> clist : pascalList) {
			System.out.println(clist);
		}
	}
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList <> ();
        List<Integer> plist;

        List<List<Integer>> pascalList = new ArrayList <> ();
        list.add(1);
        pascalList.add(list);
        if(numRows == 1) return pascalList;
        list = new ArrayList<> ();
        
        list.add(1);
        list.add(1);

        pascalList.add(list);
        if(numRows == 2) return pascalList;
        
        for(int i=3; i<=numRows; i++) {
            plist = pascalList.get(i-2);
            
            list = new ArrayList<> ();
            
            list.add(1);
            for(int j=1; j<=i-2; j++) {
                list.add((int)plist.get(j-1) + (int)plist.get(j));
            }
            list.add(1);
            pascalList.add(list);
        }
        return pascalList;
    }
}
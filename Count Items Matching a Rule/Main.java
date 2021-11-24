// Count Items Matching a Rule; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {

		List<String> l1 = Arrays.asList("phone","blue","pixel");
		List<String> l2 = Arrays.asList("computer","silver","phone");
		List<String> l3 = Arrays.asList("phone","gold","iphone");

		List<List<String>> items = Arrays.asList(l1, l2, l3);

		String ruleKey = "type", ruleValue = "phone";

		System.out.println(countMatches(items, ruleKey, ruleValue));
	}

	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {	
		int count = 0, keyIndex = findColumn(ruleKey);

		for(int i=0; i<items.size(); i++) {
			String keyValue = items.get(i).get(keyIndex);

			if(keyValue.equals(ruleValue)) count += 1;
		}

		return count;
	}

	public static int findColumn(String ruleKey) {
		if(ruleKey.equals("type")) return 0;
		if(ruleKey.equals("color")) return 1;
		if(ruleKey.equals("name")) return 2;

		return 0;
	}
}
// Count Common Words With One Occurrence; complete: y
// date: 30.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {

		String words1[] = {"b","bb","bbb"};
		String words2[] = {"a","aa","aaa"};

		System.out.println(countWords(words1, words2));
	}

    public static int countWords(String[] words1, String[] words2) {
		HashMap<String, Integer> map1 = new HashMap<> ();
		HashMap<String, Integer> map2 = new HashMap<> ();

		for(int i=0; i<words1.length; i++) {
			if(map1.containsKey(words1[i])) {
				//update occurance
				map1.put(words1[i], map1.get(words1[i]) + 1);
			}
			else {
				//No occurance, put the word in map with occurance 1
				map1.put(words1[i], 1);
			}
		}   

		for(int i=0; i<words2.length; i++) {
			if(map2.containsKey(words2[i])) {
				map2.put(words2[i], map2.get(words2[i]) + 1);
			}
			else {
				map2.put(words2[i], 1);
			}
		}        
     	
     	int count = 0;
     	for(Map.Entry word : map1.entrySet()) {
     		if((int)word.getValue() == 1) {
	     		if(map2.containsKey(word.getKey())) {
	     			if(map2.get(word.getKey()) == 1) count += 1;
	     		}
     		}
     	}

     	return count;
    }
}
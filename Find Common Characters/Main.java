// Find Common Characters; complete: n
// date: 01.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		String words[] = {"bella","label","roller"};

		System.out.println(commonChars(words));
	}

	public static List<String> commonChars(String[] words) {

		List<String> l1 = new ArrayList<> ();
        String current = words[0];
        int flag = 1;
        for(int j=0; j<current.length(); j++) {
        	char c = current.charAt(j);
        	for(int i=1; i<words.length; i++) {
        		if(words[i].indexOf(c) == -1) {
        			flag = 0;
        			break;
        		}
        	}

        	if(flag == 1) {
        		l1.add(String.valueOf(c));
        		for(int i=1; i<words.length; i++) {
        			String word = words[i];
        			int index = word.indexOf(c);

        			word = word.substring(0, index) + word.substring(index+1);

        			words[i] = word;
        		}
        	}
        }

        return l1;
    }
}
// Find Common Characters; complete: y
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
        System.out.println("current String: "+current);

        int flag;
        for(int j=0; j<current.length(); j++) {
        	char c = current.charAt(j);
        	flag = 1;
        	// System.out.println("current Character: "+c);
        	for(int i=1; i<words.length; i++) {
        		if(words[i].indexOf(c) == -1) {
        			flag = 0;
        			break;
        		}
        	}

       		// System.out.println("\tflag: "+flag);

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
        // System.out.println(l1);
        return l1;
    }
}
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;


public class TwiceRemoved {
	static String words[] = new String[] {"lore", "hero", "cant", "sure", "sell", "kine", "peon",
						"lice", "alti", "rise", "link", "lira", "imam", "fone", "calm", "fence", "conic", "nurse",
						"vales", "retag", "stamp", "alter", "derate", "thetical"};
	static HashSet dict = new HashSet();	
	
	
	public static void main(String args[]) throws Exception {
		
		//initialize dictionary
		BufferedReader br = new BufferedReader( new FileReader("/usr/share/dict/words"));
		String line;
		while ((line = br.readLine()) != null) {
			dict.add(line);
			//System.out.println(line);
		}
		if (args.length > 0) {
		    words = args;
		}
		for (int w = 0; w < words.length; w++) {
			String word = words[w];
			System.out.println("Checking input: " + word + " ....");
			char c1;
			char c2;
			int count = 0;
			for (c1= 'a'; c1 <= 'z'; c1++) {
				//System.out.println("c=" + c1);
				for (c2 = 'a'; c2 <= 'z'; c2++) {
					int i1;
					int i2;
					for (i1 = -1; i1 < word.length(); i1++) {
						for(i2= i1 + 1; i2 < word.length(); i2++) {
							String prefix = "";
							prefix = word.substring(0, i1 + 1);
							StringBuilder head = new StringBuilder().append(prefix).append(c1).append(c2);
							String middle = word.substring (i1+1, i2+1);
							String tail = word.substring (i2+1, word.length());
							String result = new String(head.append(middle).append(c1).append(c2).append(tail));
							count++;
							//System.out.println(count + ") " + result);
							if (dict.contains(result)) {
								System.out.println("Found word: " + result + " for input:" + word + ", letter pair added: " + 
											new String(new StringBuffer().append(c1).append(c2)));
							}
						}
					}
				}
			}
		}
	}

}

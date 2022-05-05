import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter {
    
    private Map<Character, Integer> charCount = new HashMap<Character, Integer>();
    private Map<String, Integer> wordCount = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String doc = in.nextLine();
       
        Counter counter = new Counter();
        counter.analyze(doc);
        counter.display();
    }
    
    public void display() {
        System.out.println(wordCount);
        System.out.println(charCount);
    }
    
    public void analyze(String doc) {
        for (char ch: doc.toCharArray()) {
            if (Character.isSpaceChar(ch))  continue;
            if (!charCount.containsKey(ch)) {
                charCount.put(ch, 1);
            } else {
                charCount.put(ch, ((int) charCount.get(ch)) + 1);
            }
        }

        StringTokenizer tokenizer = new StringTokenizer(doc);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, ((int) wordCount.get(token)) + 1);
            }
        }

    }
}
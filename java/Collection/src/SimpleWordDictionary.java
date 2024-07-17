import java.util.*;

public class SimpleWordDictionary {
    List<String> words;
    Map<Character, List<String>> dic;   // <a   : "faysal">
                                        // <'b' : ball
    public SimpleWordDictionary(){
        dic = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            dic.put(c, new ArrayList<>());
        }
    }
    public void addtoDic(String word){
        char firstLetter = Character.toLowerCase(word.charAt(0));
        if(Character.isAlphabetic(firstLetter)){
            dic.get(firstLetter).add(word.toLowerCase());
        }
        Collections.sort(dic.get(firstLetter));         // dic.get(f): git the value  --> output: faysal
    }                                                   //

    public void printAll(){
        for(char c : dic.keySet()){
            System.out.println(c + " : " +  dic.get(c));
        }
    }

    public void printWords(char c){
        System.out.println(c + " : " + dic.get(c));
    }
}

public class Solution {

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        if (arr1.length > arr2.length) {
            return areSentencesSimilar(sentence2, sentence1); 
        }
        int start = 0;
        int end1 = arr1.length - 1;
        int end2 = arr2.length - 1;


        while (start < arr1.length && arr1[start].equals(arr2[start])) {
            start++;
        }
        while (end1 >= 0 && arr1[end1].equals(arr2[end2])) {
            end1--;
            end2--;
        }

        return start > end1;
    }

    public static void main(String[] args) {
        String sentence1 = "Hello Jane";
        String sentence2 = "Hello my name is Jane";

        System.out.println(areSentencesSimilar(sentence1, sentence2));  

        sentence1 = "Frog cool";
        sentence2 = "Frogs are cool";

        System.out.println(areSentencesSimilar(sentence1, sentence2));  
    }
}

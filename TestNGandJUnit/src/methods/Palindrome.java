package methods;

public class Palindrome {

    public static void main(String[] args) {

        Palindrome tt = new Palindrome();

        System.out.println(tt.isPalindrome("KayaK"));

    }

    public boolean isPalindrome (String input){
        if (input == null || input.isEmpty()){
            return true;
        }

        String temp ="";
        int i = input.length() -1;

        while (i >= 0){
            temp += input.charAt(i);
            i--;
        }
        return input.equals(temp);
    }
}

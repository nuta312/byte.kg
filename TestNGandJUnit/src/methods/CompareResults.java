package methods;

import java.util.Arrays;
import java.util.List;

public class CompareResults {

    public static void main(String[] args) {

        List<String> expectedProducts = Arrays.asList("Watermelon", "Pineapple", "Apple","Oranges");
        List<String> actualProducts = Arrays.asList("Watermelon", "Pineapple", "Apple");
        List<String> expectedProducts2 = Arrays.asList("Watermelon","Pineapple","Apple","Oranges");
        List<String> actualProducts2 = Arrays.asList("Watermelon","Pineapple", "Apple","Oranges");

        System.out.println(compareResults(expectedProducts,actualProducts));
        System.out.println(compareResults(expectedProducts2,actualProducts2));

    }

    public static boolean compareResults (List<String> expectedList, List<String> actualList) {
        if (expectedList.isEmpty() && actualList.isEmpty()) {
            return true;
        }
        return expectedList.containsAll(actualList) && expectedList.size() == actualList.size();
    }
}

package methods;

public class asd {



    public static int evenNums(int a){
        int[] b = new int[a];
        int result = 0;
        for (int i = 0; i <= b.length; i++){
            if (b[i] % 2 == 0){
                return b[i];
            }

        }
        return a;
    }



    public static void main(String[] args) {


        System.out.println(evenNums(20));

    }
}

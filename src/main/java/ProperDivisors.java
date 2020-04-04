import java.util.Scanner;

public class ProperDivisors {

    public static void  main(String args[]){
        Scanner input = new Scanner(System.in);

        int numberToFindProperDivisors =input.nextInt();
        ProperDivisors properDivisors = new ProperDivisors();
        System.out.println(properDivisors.findSumOfProperDivisorsForGivenNumber(numberToFindProperDivisors));


    }

    public int findSumOfProperDivisorsForGivenNumber(int numberToFindProperDivisors){
            int sumofProperDivisorsForANumber =0;
        for ( int i=1 ; i <= (numberToFindProperDivisors/2) ;i++){
                if((numberToFindProperDivisors %i )==0){
                    sumofProperDivisorsForANumber+=i;
                }
        }
            return sumofProperDivisorsForANumber;
    }
}

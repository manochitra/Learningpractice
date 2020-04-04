import java.io.File;
import java.util.Arrays;

public class TestPractice {

      int  num =15 ;

    public  static void main(String[] args) {
       TestPractice practice = new TestPractice();
       String testStrings= "name";
       int a =3;
       int sum =0;
       while(sum++ <3){
           int b = (1 + 2 * sum)%3;
           switch (b) {
               case 0 :
                   a -=1;
                   break;
               case 1 :
                   a +=5;
               default:
           }
           System.out.println(a);
       }




    }
}

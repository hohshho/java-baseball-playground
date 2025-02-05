import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();
        String[] values = value.split(" ");

        int sum = getSum(values);

        System.out.println(sum);
    }

    public static int getSum(String[] values) {
        int sum = Integer.parseInt(values[0]);
        for(int i=1; i<values.length; i+=2){
            char operator = values[i].charAt(0);
            int num = Integer.parseInt(values[i+1]);

            if(operator == '+'){
                sum = add(sum, num);
            }
            else if(operator == '-'){
                sum = subtract(sum, num);
            }
            else if(operator == '*'){
                sum = multiply(sum, num);
            }
            else if(operator == '/'){
                sum = divide(sum, num);
            }
        }
        return sum;
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide(int a, int b){
        return a / b;
    }
}

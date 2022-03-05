import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start the program and continue till user enter "quit"

        while (true){
            String operation = scanner.next();
            if (operation.equals("equals"))
                break;
            else if (operation.equals("prime")){
                int n = scanner.nextInt();
                if (isPrime(n))
                    System.out.println("true");
                else
                    System.out.println(false);
                printPrime(n);
            }else {
                // get inputs and calculate the result in output
                double x= scanner.nextDouble();
                double y= scanner.nextDouble();
                double output = 0;
                // choose the operation by switch case block
                switch (operation){
                    case "add":
                        output = x + y;
                        break;
                    case "subtract":
                        output = x - y;
                        break;
                    case "multiply":
                        output = x * y;
                        break;
                    case "divide":
                        //Handle Divide By Zero Exception
                        try {
                            output = x/y; // throw Exception
                        }
                        catch (ArithmeticException e) {
                            // Exception handler
                            System.out.println("Divided by zero operation cannot possible");
                        }
                        break;
                    default:
                        System.out.println("Invalid input!");
                }
                System.out.println(output);
            }

        }
    }
    // function check whether a number is prime or not
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // Function to print primes
    static void printPrime(int n)
    {
        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }
}


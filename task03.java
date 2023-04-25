import java.util.Scanner;
import java.util.Stack;

public class task03 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final Stack<Integer> stack = new Stack<Integer>();
    
        System.out.println("Введитен постфикс: ");
        String expression = input.nextLine();
        String[] elements = expression.split(" ");
    
        for(int i = 0; i < elements.length; i++) {
            if(isNumeric(elements[i])) { // Если это число, пушим в стак
                stack.push(Integer.parseInt(elements[i]));
            } else { 
                int b = stack.pop();
                int a = stack.pop();
                switch(elements[i]) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
    
        if(stack.size() == 1) { 
            int result = stack.pop();
            System.out.println("Result: " + result);
        } else { 
            System.out.println("Invalid expression!");
        }
    }
    
    
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
}

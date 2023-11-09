import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String expression = "5 3 + 8 * 4 -";
        System.out.println("Результат вычисления: " + evaluateExpression(expression));
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // Если элемент - число, поместить его в стек
                stack.push(Integer.parseInt(token));
            } else {
                // Иначе, если элемент - оператор, выполнить соответствующую операцию
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop(); // Результат будет находиться на вершине стека
    }
}

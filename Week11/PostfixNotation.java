package Week11;

public class PostfixNotation {
    int evaluate(String expression) {
        String tokens[] = expression.split(" ");
        int stack[] = new int[tokens.length];
        int top = -1;

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack[++top] = Integer.parseInt(token);
            } else {
                int b = stack[top--];
                int a = stack[top--];

                int result = 0;
                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else if (token.equals("/")) {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = a / b;
                }
                stack[++top] = result;
            }
        }

        return stack[top];
    }

    public static void main(String[] args) {
        PostfixNotation obj = new PostfixNotation();
        String expression = "12 3 4 * + 2 /";
        System.out.println(obj.evaluate(expression));
    }
}


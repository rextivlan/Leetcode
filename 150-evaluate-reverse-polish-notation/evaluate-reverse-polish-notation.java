class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack<>();
        HashSet<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        int res = 0;
        for(String token: tokens){
            if(!ops.contains(token)){
                myStack.push(Integer.parseInt(token));
            }
            else if(!myStack.isEmpty()){
                int op1 = myStack.pop();
                int op2 = myStack.pop();
                switch(token){
                    case "+":
                        res += op1 + op2;
                        myStack.push(res);
                        res = 0;
                        break;
                    case "-":
                        res += op2 - op1;
                        myStack.push(res);
                        res = 0;
                        break;
                    case "*":
                        res += op1 * op2;
                        myStack.push(res);
                        res = 0;
                        break;
                    case "/":
                        res += op2 / op1;
                        myStack.push(res);
                        res = 0;
                        break;
                }
            }
            
        }
        return myStack.pop();
    }
}
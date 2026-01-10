class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> myList = new ArrayList<>();
        Stack<Double> myStack = new Stack<>();
        for(int i = 0; i < position.length; i++){
            myList.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(myList, (a, b) -> Integer.compare(b[0], a[0]));
        for(int[] a: myList){
            //System.out.println(Arrays.toString(a));
            myStack.push((double) (target - a[0]) / a[1]);
            if(myStack.size() >= 2 && 
            myStack.peek() <= myStack.get(myStack.size() - 2)){
                myStack.pop();
            }
        }
        return myStack.size();
    }
}
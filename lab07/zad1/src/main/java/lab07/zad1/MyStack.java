package lab07.zad1;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List <Integer> stack;
	
	public List<Integer> getStack() {
		return stack;
	}

	public void setStack(List<Integer> stack) {
		this.stack = stack;
	}

	public boolean isNull(){
		if (stack.isEmpty()){
			return true;
		}
		else return false;
	}
	
	public void myPush(int a){
		stack.add(a);
	}
	
	public void myPop (){
		if (stack.size() == 0){
			throw new ArrayIndexOutOfBoundsException();
		}
		else stack.remove(stack.size()-1);
	}
	
	public int myTop(){
		if (stack.size() == 0){
			throw new ArrayIndexOutOfBoundsException();
		}
		else return stack.get(stack.size()-1);
	}
}

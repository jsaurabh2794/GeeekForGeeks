package Array_Basics;

public class Implement_stack_using_array {
	
	int top;
	int arr[] = new int[1000];

	Implement_stack_using_array()
		{
			top = -1;
		}

	/*
	 * The method push to push element into the stack
	 */
	void push(int a) {
		if (top < 1000) {
			top++;
			arr[top] = a;
		}
	}

	/*
	 * The method pop which return the element poped out of the stack
	 */
	int pop() {
		int result = -1;
		if (top > -1) {
			result = arr[top];
			top--;
		}
		return result;
	}
}

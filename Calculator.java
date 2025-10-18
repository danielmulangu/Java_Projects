//Name: Daniel Mulangu Kaseya
//ID: 72826452
//Email: dkaseya@unomaha.edu

import java.util.*;
import java.lang.Math;

public class Calculator {
	//Create a stack here
	
    public static String convert(String infix) {
		// use a stack to covert infix to postfix
		
		/* You are not allowed to add additional functions e.g., precedence(), isOperator(), etc.
         You are not allowed to create variables using a list or a dictionary like below. 
            priority = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
            operators = ['(', ')', '-', '+', '*', '/', '^']
         Keep the pseudo code (for loops) below with your code.*/
        for c in infix:
            if c == ‘(’ stack.push(c)
            else if c == ‘)’
                while stack.isEmpty() == false && stack.peek() != ‘(‘
                    poped_char = stack.pop() and postfix.append(poped_char)
            else if c == ‘+’ || c == ‘-’
                while stack.isEmpty() == false && stack.peek() == ‘/’ || ‘*’ || ‘+’ || ‘-’
                    poped_char = stack.pop() and postfix.append(poped_char)
            else if c == ‘/’ || c == ‘*’
                while stack.isEmpty() == false && stack.peek() == ‘/’ || ‘*’
                    poped_char = stack.pop() and postfix.append(poped_char)
            else
                stack.push(c)

        while stack.isEmpty() == false
            poped_char = stack.pop() and postfix.append(poped_char)

        return postfix
    }
	
	// This Return double for division
	public static Double evaluate(String postfix) {
		//Use stack of tokens
       
        // Keep the instructions below with your code.
        // implement as directed
        //• Repeat
        //• If operand, push onto stack
        //• If operator
        //   • pop operands off the stack
        //   • evaluate operator on operands
        //   • push result onto stack
        //• Until expression is read
        //• Return top of stack
	}
    
    public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		String input; 		//From user

		String postfix = covert(input);
		System.out.println(postfix);
		
		double result = evaluate(postfix);
		System.out.println(result);
    }
}

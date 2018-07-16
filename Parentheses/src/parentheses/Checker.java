package parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

import static parentheses.Parenthesis.isParenthesis;
import static parentheses.Parenthesis.of;

public class Checker {
		
	private Deque<Parenthesis> stack = new ArrayDeque<Parenthesis>();
	
	
	public boolean check(String calculation){
				
		for (byte b : calculation.getBytes()){
			
			if (isParenthesis(b)){
				Parenthesis processed= of(b);
				if (processed.isOpen()){
					pushParenthesis(processed);
				} else {
					boolean success = popAndCheckMatching(processed);
					if (!success){
						return false;
					}
				}								
			}
		}
		
		return stack.isEmpty();
	}

	private boolean popAndCheckMatching(Parenthesis processed) {
		if (stack.isEmpty()){
			return false;
		}
		Parenthesis last = stack.pop();
		return last.getMatchingCode() == processed.getCode();
	}

	private void pushParenthesis(Parenthesis processed){
		stack.push(processed);
	};
	
}

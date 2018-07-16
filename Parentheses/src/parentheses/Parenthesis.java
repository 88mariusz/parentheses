package parentheses;

import java.util.Arrays;

public enum Parenthesis {

	OPEN_PARENTESIS('(', ')', Boolean.TRUE),
	CLOSE_PARENTESIS(')', '(', Boolean.FALSE),
	OPEN_BRACKET('[', ']', Boolean.TRUE),
	CLOSE_BRACKET(']', '[', Boolean.FALSE),
	OPEN_BRACE('{', '}', Boolean.TRUE),
	CLOSE_BRACE('}', '}', Boolean.FALSE);

	private int code;
	private int matchingCode;
	private boolean open;

	private Parenthesis(int code, int match, boolean open) {
		this.code = code;
		this.matchingCode = match;
		this.open = open;
	}

	public int getCode() {
		return code;
	}

	public int getMatchingCode() {
		return matchingCode;
	}

	public boolean isOpen() {
		return open;
	}

	public static Parenthesis of(int code) {
		return Arrays.asList(values()).stream()
				.filter(p -> p.code == code)
				.findAny()
				.orElseThrow(() 
						-> new IllegalArgumentException("check if Parenthesis before casting!"));
	}

	public static boolean isParenthesis(int code) {
		return Arrays.asList(values()).stream()
				.filter(p -> p.code == code)
				.findAny()
				.isPresent();
	}

}

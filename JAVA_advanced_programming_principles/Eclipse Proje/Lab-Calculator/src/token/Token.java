/**
 * Here are the tokens.
 */
package token;

/**
 * @author Dan
 * Abstrakte Klasse fur einen Token.
 */
public class Token {

	private String value;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Token(String value) {
		super();
		this.value = value;
	}

	/**
	 * Liefer true wenn die Value einen Operator enthalt, false wenn nicht.
	 * @return boolean
	 */
	public boolean isOperator() {
		if(value.equals("+")) {
			return true;
		} else if(value.equals("-")) {
			return true;
		} else if(value.equals("*")) {
			return true;
		} else if(value.equals("/")) {
			return true;
		} else if(value.equals("(")) {
			return true;
		} else if(value.equals(")")) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}

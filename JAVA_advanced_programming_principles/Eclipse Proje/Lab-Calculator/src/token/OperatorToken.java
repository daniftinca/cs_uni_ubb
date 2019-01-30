package token;

public class OperatorToken extends Token {

	public OperatorToken(String value) {
		super(value);
	}

	/**
	 * Liefert die Prioritaet des Operatores. 
	 * @return
	 */
	public int getPrecedence() {
		if(this.getValue().equals("(")|| this.getValue().equals(")") ) {
			return 0;
		} else if (this.getValue().equals("+")) {
			return 1;
		} else if(this.getValue().equals("-")) {
			return 1;
		} else if (this.getValue().equals("*")) {
			return 2;
		} else if(this.getValue().equals("/")) {
			return 2;
		}
		return -1;
	}
	
	
	
}

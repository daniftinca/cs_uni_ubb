package sEtests;

import java.security.InvalidParameterException;

public class JungException extends Exception{

    private static final long serialVersionUID;

    static {
        serialVersionUID = 6546277393945226602L;
    }

    public JungException() {}

    public JungException(String message)
    {
        super(message);
    }
}

package com.grupo.o.antlr.grupootp;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {
    private boolean hasErrors = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        hasErrors = true;
        System.err.println("Error sintactico/lexico en linea " + line + ":" + charPositionInLine + " - " + msg);
    }

    public boolean hasErrors() {
        return hasErrors;
    }
}

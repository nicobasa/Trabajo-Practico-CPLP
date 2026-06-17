package com.grupo.o.antlr.grupootp;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    private static final String EXTENSION = "smp";

    public static void main(String[] args) throws IOException {
        String program = args.length > 0 ? args[0] : "test/test." + EXTENSION;

        System.out.println("Interpretando archivo: " + program);

        SimpleLexer lexer = new SimpleLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);

        SyntaxErrorListener errorListener = new SyntaxErrorListener();
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        parser.addErrorListener(errorListener);

        SimpleParser.ProgramContext tree = parser.program();

        if (errorListener.hasErrors() || parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("No se ejecuta el programa porque tiene errores lexicos o sintacticos.");
            return;
        }

        try {
            SimpleCustomVisitor interpreter = new SimpleCustomVisitor();
            interpreter.visit(tree);
            System.out.println("Interpretacion finalizada correctamente.");
        } catch (SemanticException e) {
            System.err.println("Error semantico: " + e.getMessage());
        }
    }
}

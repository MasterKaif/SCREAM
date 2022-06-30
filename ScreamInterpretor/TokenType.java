package ScreamInterpretor;

enum TokenType {
    // Single-character tokens.
    LEFT_PAREN, RIGHT_PAREN, COMMA, MINUS, PLUS, SEMICOLON, SLASH, STAR, MODULO,

    // One or two character tokens.
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,
    AND, OR, NOT,

    // Literals.
    IDENTIFIER, STRING, NUMBER,

    // Keywords.
    LET, VAR, FUNC, BEGIN, END, ARRAY, IF, ELSE, WHILE, TRUE, FALSE, NIL, RETURN, HALT, PRINT;

}

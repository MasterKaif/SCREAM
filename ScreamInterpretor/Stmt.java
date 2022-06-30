package ScreamInterpretor;

import java.util.List;

import ScreamInterpretor.Expr.Binary;

abstract class Stmt {

    abstract String accept(Visitor visitor);

    static class Block extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitBlockStmt(this);
        }

        Block(List<Stmt> statements) {
            this.statements = statements;
        }

        final List<Stmt> statements;
    }

    static class Expression extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitExpressionStmt(this);
        }

        Expression(Expr expression) {
            this.expression = expression;
        }

        final Expr expression;
    }

    static class Print extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitPrintStmt(this);
        }

        Print(Expr expression) {
            this.expression = expression;
        }

        final Expr expression;
    }

    static class Var extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitVarStmt(this);
        }

        Var(Token name, Expr initializer) {
            this.name = name;
            this.initializer = initializer;
        }

        final Token name;
        final Expr initializer;
    }

    static class If extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitIfStmt(this);
        }

        If(Expr condition, Stmt thenBranch, Stmt elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        final Expr condition;
        final Stmt thenBranch;
        final Stmt elseBranch;
    }

    static class While extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitWhileStmt(this);
        }
        While(Expr condition, Stmt body) {
            this.condition = condition;
            this.body = body;
        }

        final Expr condition;
        final Stmt body;
    }

    static class Function extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitFunctionStmt(this);
        }

        Function(Token name, List<Token> params, List<Stmt> body) {
            this.name = name;
            this.params = params;
            this.body = body;
        }

        final Token name;
        final List<Token> params;
        final List<Stmt> body;
    }

    static class Return extends Stmt {

        @Override
        String accept(Visitor visitor) {
            return (String) visitor.visitReturnStmt(this);
        }

        Return(Token keyword, Expr value) {
            this.keyword = keyword;
            this.value = value;
        }

        final Token keyword;
        final Expr value;
    }

    interface Visitor<T> {
        T visitBlockStmt(Stmt.Block stmt);

        T visitExpressionStmt(Stmt.Expression stmt);

        T visitFunctionStmt(Stmt.Function stmt);

        T visitIfStmt(Stmt.If stmt);

        T visitPrintStmt(Stmt.Print stmt);

        T visitReturnStmt(Stmt.Return stmt);

        T visitVarStmt(Stmt.Var stmt);

        T visitWhileStmt(Stmt.While stmt);

        String visitBinaryExpr(Binary binary);

    }

}

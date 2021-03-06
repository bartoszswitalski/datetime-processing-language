/*
 *	Name:		IfStatement.java
 *	Purpose:
 *
 *	@author:     Bartosz Świtalski
 *
 *	Warsaw University of Technology
 *	Faculty of Electronics and Information Technology
 */
package main.grammar;

import main.errors.Errors;
import main.visitor.Visitable;
import main.visitor.Visitor;

public class IfStatement extends Statement implements Visitable {     // "if", "(", condition, ")", block, ["else", block] ;
    private OrCond orCond;
    private Block ifBlock;
    private Statement elseStatement;

    public IfStatement(OrCond orCond, Block ifBlock){
        this.orCond = orCond;
        this.ifBlock = ifBlock;
        this.elseStatement = null;
    }

    public IfStatement(OrCond orCond, Block ifBlock, Statement elseStatement){
        this.orCond = orCond;
        this.ifBlock = ifBlock;
        this.elseStatement = elseStatement;
    }

    @Override
    public void accept(Visitor visitor) throws Errors.InterpreterError {
        visitor.visit(this);
    }

    public OrCond getOrCond() { return this.orCond; }
    public Block getIfBlock() { return this.ifBlock; }
    public Statement getElseStatement() { return this.elseStatement; }
}

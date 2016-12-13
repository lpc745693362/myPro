package com.lpc.design.command;

/**
 * ³éÏóÃüÁî½ÇÉ«
 */
public interface Command {

    /**
     * Ö´ĞĞÃüÁî
     */
    public void execute();

    /**
     * ³·ÏúÃüÁî
     */
    public void undo();

}

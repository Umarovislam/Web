package Controller;

import Controller.command.Command;

import dao.DaoChecks;
import dao.DaoFree;

public class ActionManager {
    private DaoChecks checksManager;
    private DaoFree numManager;


    private enum COMMANDS {
        CHECKS,
        NUMS,
        COOKIES
    }

    /**
     * set beans
     * @param bookMan
     * @param formMan
     */
    public void setBeans(DaoChecks bookMan, DaoFree formMan) {
        checksManager = bookMan;
        numManager = formMan;
    }

    /**
     * get command by name
     * @param commandName name of command
     * @return appropriate action
     */
    public  Command getCommand(String commandName) {
        COMMANDS command = COMMANDS.valueOf(commandName.toUpperCase());
        switch(command) {
            case CHECKS:
                return new CheckAction(checksManager);
            case NUMS:
                return new NumAction(numManager);
            case COOKIES:
                return new CookiesAction();
            default:
                throw new UnsupportedOperationException(commandName);
        }
    }
}

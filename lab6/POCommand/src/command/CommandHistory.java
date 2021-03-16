package command;

import java.util.Stack;

public class CommandHistory
{
    private Stack<Command> history;

    public CommandHistory()
    {
        history = new Stack<>();
    }

    public void push(Command command)
    {
        this.history.push(command);
    }

    public Command pop()
    {
        if(history.isEmpty())
        {
            throw new NullPointerException("No command to undo");
        }
        else
        {
            return history.pop();
        }
    }
}


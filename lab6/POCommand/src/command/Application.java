package command;

public class Application
{
    public Editor editor = null;
    public String clipboard = null;
    public CommandHistory history;
    public GUI gui;

    public Application()
    {
        editor = new Editor();
        history = new CommandHistory();
    }

    public void createGUI()
    {
        this.gui = new GUI(this);
    }

    public void executeCommand(Command command)
    {
        command.execute();
        history.push(command);
    }

    public void undo()
    {
        history.pop().undo();
    }

}

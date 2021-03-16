package command;

public class CopyCommand extends Command
{
    public CopyCommand(Application app, Editor editor)
    {
        super(app, editor);
    }

    @Override
    public void execute()
    {
        app.clipboard = editor.getSelection();
        System.out.println("Copied " + app.clipboard);
    }

    @Override
    public void undo()
    {
        app.clipboard = null;
        System.out.println("Copy undone");
    }
}

package command;

public class CutCommand extends Command
{
    public CutCommand(Application app, Editor editor)
    {
        super(app, editor);
    }

    @Override
    public void execute()
    {
        this.saveBackup();
        app.clipboard = editor.getSelection();
        editor.deleteSelection();
        System.out.println("Cut " + app.clipboard);
    }

    @Override
    public void undo()
    {
        this.app.clipboard = null;
        editor.text.setText(this.backup);
        System.out.println("Cut undone");
    }
}

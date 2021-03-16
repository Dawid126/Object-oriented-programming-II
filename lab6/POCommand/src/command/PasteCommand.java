package command;

public class PasteCommand extends Command
{
    public PasteCommand(Application app, Editor editor)
    {
        super(app, editor);
    }

    @Override
    public void execute()
    {
        this.saveBackup();
        if(app.clipboard != null)
        {
            editor.replaceSelection(app.clipboard);
            System.out.println("Pasted " + app.clipboard);
        }
        else
        {
            System.out.println("Clipboard empty");
        }
    }

    @Override
    public void undo()
    {
        editor.text.setText(this.backup);
        System.out.println("Paste undone");
    }
}

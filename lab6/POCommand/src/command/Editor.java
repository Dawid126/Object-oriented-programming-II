package command;

import javax.swing.*;

public class Editor
{
    JTextPane text;

    public Editor()
    {
        text = new JTextPane();
        text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget dictum odio, eget interdum nisl. Aliquam " +
                "vitae ante eu enim sodales ultricies ac id libero.");
    }

    public void deleteSelection()
    {
        this.text.replaceSelection("");
    }

    public void replaceSelection(String text)
    {
        this.text.replaceSelection(text);
    }

    public String getSelection()
    {
        return this.text.getSelectedText();
    }
}

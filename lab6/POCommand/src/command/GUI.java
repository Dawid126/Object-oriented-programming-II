package command;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUI
{
    Application app;
    private JFrame frame;
    JButton copyCommandButton;
    JButton pasteCommandButton;
    JButton cutCommandButton;
    JButton undoCommandButton;

    public GUI(Application app)
    {
        this.app = app;
        this.frame = new JFrame();

        this.copyCommandButton = new JButton("Copy");
        this.pasteCommandButton = new JButton("Paste");
        this.cutCommandButton = new JButton("Cut");
        this.undoCommandButton = new JButton("Undo");
        this.copyCommandButton.setVisible(true);
        this.pasteCommandButton.setVisible(true);
        this.cutCommandButton.setVisible(true);
        this.undoCommandButton.setVisible(true);
        this.copyCommandButton.setPreferredSize(new Dimension(110, 24));
        this.pasteCommandButton.setPreferredSize(new Dimension(110, 24));
        this.cutCommandButton.setPreferredSize(new Dimension(110, 24));
        this.undoCommandButton.setPreferredSize(new Dimension(110, 24));
        this.copyCommandButton.setBounds(300, 10, 110, 24);
        this.pasteCommandButton.setBounds(300, 44, 110, 24);
        this.cutCommandButton.setBounds(300, 78, 110, 24);
        this.undoCommandButton.setBounds(300, 112, 110, 24);

        JTextPane text =  this.app.editor.text;
        text.setEditable(false);
        text.setPreferredSize(new Dimension(200, 200));
        text.setBounds(10, 10, 200, 200);

        copyCommandButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Command cmd = new CopyCommand(app, app.editor);
                app.executeCommand(cmd);
            }
        });

        pasteCommandButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Command cmd = new PasteCommand(app, app.editor);
                text.setEditable(true);
                app.executeCommand(cmd);
                text.setEditable(false);
            }
        });

        cutCommandButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Command cmd = new CutCommand(app, app.editor);
                text.setEditable(true);
                app.executeCommand(cmd);
                text.setEditable(false);
            }
        });

        undoCommandButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                text.setEditable(true);
                app.undo();
                text.setEditable(false);
            }
        });

        this.frame.add(copyCommandButton);
        this.frame.add(pasteCommandButton);
        this.frame.add(cutCommandButton);
        this.frame.add(undoCommandButton);
        this.frame.add(this.app.editor.text);


        frame.setLayout(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Text editor");
        frame.setResizable(false);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (screenDimension.getWidth() / 2 - 220),
                (int) (screenDimension.getHeight() /2 - 250));
        frame.setVisible(true);
        frame.setSize(440, 500);
    }

}

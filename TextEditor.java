import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class TextEditor extends JFrame {

	JTextArea area;

	public static void main(String[] args) {


		new TextEditor();

	}

	public TextEditor() {

		super("Text Editor");
		setSize(700,700);

		initialize();

		setVisible(true);

	}

	private void initialize() {
		area = new JTextArea(30, 20);
		add(area);

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu fileMenu = new JMenu("File");

		JMenuItem newItem = new JMenuItem("New");
			fileMenu.add(newItem);
			JMenuItem openItem = new JMenuItem("Open");
			fileMenu.add(openItem);
			JMenuItem saveItem = new JMenuItem("Save");
			fileMenu.add(saveItem);
			JMenuItem saveAsItem = new JMenuItem("Save As");
			fileMenu.add(saveAsItem);
			JMenuItem printItem = new JMenuItem("Print");
			fileMenu.add(printItem);


		JMenu editMenu = new JMenu("Edit");

		JMenuItem copyItem = new JMenuItem("Copy");
			editMenu.add(copyItem);
			JMenuItem pasteItem = new JMenuItem("Paste");
			editMenu.add(pasteItem);

		bar.add(fileMenu);
		bar.add(editMenu);

		}
	}


/*
 * value/policy iteration
 * expectiminimax
 * Q learning
 * ActionListener
 * regular expressions
 */

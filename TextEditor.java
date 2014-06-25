import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

// Made a text editor class.
public class TextEditor extends JFrame implements ActionListener {

	//Class owns a text area
	JTextArea area;

	//On running make new object using this class
	public static void main(String[] args) {

		new TextEditor();

	}

	//Constructor of text editor.
	public TextEditor() {

		//Commanding JFrame constructor to run.
		super("Text Editor");
		setSize(700,700);

		//Initialize it
		initialize();

		//Make visible
		setVisible(true);

	}

	//Create the text area and menu bar.
	private void initialize() {

		area = new JTextArea(30, 20);
		add(area);

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		JMenu fileMenu = new JMenu("File");

			JMenuItem newItem = new JMenuItem("New");
			newItem.setActionCommand("New");
			newItem.addActionListener(this);	
			fileMenu.add(newItem);
			
			JMenuItem openItem = new JMenuItem("Open");
			//set action command to open.
			openItem.setActionCommand("Open");
			// Tell item to add events here.
			openItem.addActionListener(this);
			//Add the item to the file menu
			fileMenu.add(openItem);
			
			JMenuItem saveItem = new JMenuItem("Save");
			saveItem.setActionCommand("Save");
			saveItem.addActionListener(this);		
			fileMenu.add(saveItem);
			
			JMenuItem saveAsItem = new JMenuItem("Save As");
			saveAsItem.setActionCommand("Save As");
			saveAsItem.addActionListener(this);	
			fileMenu.add(saveAsItem);
			
			JMenuItem printItem = new JMenuItem("Print");
			printItem.setActionCommand("Print");
			printItem.addActionListener(this);	
			fileMenu.add(printItem);


		JMenu editMenu = new JMenu("Edit");

			JMenuItem cutItem = new JMenuItem("Cut");
			editMenu.add(cutItem);
			JMenuItem copyItem = new JMenuItem("Copy");
			editMenu.add(copyItem);
			JMenuItem pasteItem = new JMenuItem("Paste");
			editMenu.add(pasteItem);
			JMenuItem undoItem = new JMenuItem("Undo");
			editMenu.add(undoItem);
			JMenuItem redoItem = new JMenuItem("Redo");
			editMenu.add(redoItem);
			JMenuItem deleteItem = new JMenuItem("Delete");
			editMenu.add(deleteItem);

		JMenu viewMenu = new JMenu("View");

			JMenuItem actualSizeItem = new JMenuItem("Actual Size");
			viewMenu.add(actualSizeItem);

		//Make a filter menu.
		JMenu filterMenu = new JMenu("Filter");
		
		JMenuItem removeProfanity = new JMenuItem("Remove Profanity");
		removeProfanity.setActionCommand("Remove Profanity");
		removeProfanity.addActionListener(this);
		filterMenu.add(removeProfanity);	
		
		JMenuItem removeTrolling = new JMenuItem("Remove Trolling");
		removeTrolling.setActionCommand("Remove Trolling");
		removeTrolling.addActionListener(this);
		filterMenu.add(removeTrolling);
				
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(viewMenu);
		bar.add(filterMenu);

	}


	public void openFile() {
		
		System.out.println("Haha! You think you can get a file from me.");
		File f = new File("Mydata");
		try {
			String content = "";
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				//Append another line of input
				content = content  + "\n" + s.nextLine();
			}
			//Tell text area what text is.
			area.setText(content);
		} catch (FileNotFoundException e) {
			System.out.println("Not a file!");
			//e.printStackTrace();
		}
		
	}
	
	public void saveFile() {
		
		System.out.println("Hehe! You think I'll let you save any stuff.");
		
	}
	
	public void saveAsFile() {
		
		System.out.println("Hoo Hoo! You think I'll let you save any stuff.");
		
	}
	
	public void newFile() {
		
		System.out.println("Hehe! You think I'll let you make a new file!");
		
	}
	
	public void printFile() {
		
		System.out.println("Hehe! You think I'll let you print anything... I'm an evil Text Editor.");
		System.out.println("Muahahahahahahaha!");
		
	}
	
	public void removeTrolling() {
		String wb = "\\b";
		String content = area.getText();
		// \\b = word boundary
		// + = one or more times
		// * = zero or more times
		area.setText(content);
		content = content.replaceAll("(?i)" + wb + "troll" + wb, "No no no.");
		content = content.replaceAll("(?i)" + wb + "trol(ol)*" + wb, "No no no.");
		content = content.replaceAll("(?i)" + wb + "haha(ha)+" + wb, "Haha");
		content = content.replaceAll("(?i)" + wb + "ha+ha+" + wb, "Haha");
		content = content.replaceAll("(?i)" + wb + "hm+" + wb, "Hmm");
		area.setText(content);
	}
	
	public void removeProfanity() {
	
		String content = area.getText();
		// \\b = word boundary
		String[] badWords = {"darn", "heck", "shoot", "gadha", "budhu", "uloo", "gadhi", "paagal", "gadhe" };
		for(String words : badWords) {
			content = content.replaceAll("(?i)\\b" + words + "\\b", "Hoo Hoo Ha Ha");	
		}
		area.setText(content);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		System.out.println(command);
		
		if(command.equals("Open")) {
			openFile();
		}
		if(command.equals("Save")) {
			saveFile();
		}
		if(command.equals("New")) {
			newFile();
		}
		if(command.equals("Save As")) {
			saveAsFile();
		}
		if(command.equals("Print")) {
			printFile();
		}
		if(command.equals("Remove Profanity")) {
			removeProfanity();
		}
		if(command.equals("Remove Trolling")) {
			removeTrolling();
		}
	}

}


/*
  value/policy iteration
  expectiminimax
 Q learning
  ActionListener
 regular expressions
 */

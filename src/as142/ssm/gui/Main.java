package as111.ssm.gui;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;

import as111.ssm.Directory;
import as111.ssm.DirectorySerializer;

public class Main {
	public static final String filePath = "directory.xml";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Directory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Directory directory = null;
		if(new File(filePath).exists()) {
			directory = DirectorySerializer.loadDirectory(filePath);
		} else {
			directory = new Directory();
		}
		final Directory directoryArg = directory;
		
		frame.setContentPane(new ApplicationWindow(directory));
		frame.pack();
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DirectorySerializer.saveDirectory(directoryArg, filePath);
				super.windowClosing(e);
			}
		});
	}
}

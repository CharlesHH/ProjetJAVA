package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;






public class MazeWindow
  extends JFrame
{
	private MazeViewController mazeController;
	private MazeView mazeView;
	private static final long serialVersionUID = 1L;
  
	public MazeWindow(String paramString, MazeViewController paramMazeViewController)
	{
		super(paramString);
		this.mazeView = new MazeView(paramMazeViewController.getMazeViewSource());
		this.mazeController = paramMazeViewController;
		setupUI();
		setVisible(true);
	}
  
	private void newLabyrinth() {
		this.mazeController.newMaze();
		setMaze(this.mazeController);
	}
  
	private void openLabyrinth() {
		JFileChooser localJFileChooser = new JFileChooser();
		FileNameExtensionFilter localFileNameExtensionFilter = new FileNameExtensionFilter("Maze & Text files", new String[] { "maze", "txt" });
		localJFileChooser.setFileFilter(localFileNameExtensionFilter);
		int i = localJFileChooser.showOpenDialog(this);
		if (i == 0) {
			this.mazeController.openMaze(localJFileChooser.getSelectedFile().getPath());
			setMaze(this.mazeController);
		}
	}
  
	private void saveLabyrinth() {
		JFileChooser localJFileChooser = new JFileChooser();
		FileNameExtensionFilter localFileNameExtensionFilter = new FileNameExtensionFilter("Maze & Text files", new String[] { "maze", "txt" });
		localJFileChooser.setFileFilter(localFileNameExtensionFilter);
    
		int i = localJFileChooser.showSaveDialog(this);
		if (i == 0) {
			this.mazeController.saveMazeAs(localJFileChooser.getSelectedFile().getPath());
		}
	}
  
	private void exit()
	{
		System.exit(0);
	}
  
	private void setupUI() {
		setPreferredSize(new Dimension(800, 600));
		setupMenu();
    
		JPanel localJPanel1 = new JPanel(new BorderLayout());
		localJPanel1.add(this.mazeView, "Center");
    
		JPanel localJPanel2 = new JPanel(new FlowLayout());
		JButton localJButton = new JButton("Solve");
		localJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
				MazeWindow.this.mazeController.calculateShortestPath();
				MazeWindow.this.mazeView.repaint();
			}
		});
		localJPanel2.add(localJButton);
    
		localJPanel1.add(localJPanel2, "South");
		setContentPane(localJPanel1);
		getContentPane().setPreferredSize(getPreferredSize());
    
		pack();
	}
  
	private void setupMenu() {
		JMenuBar localJMenuBar = new JMenuBar();
    
		JMenu localJMenu = new JMenu("File");
		localJMenu.add(new AbstractAction("New Labyrinth") {
			private static final long serialVersionUID = 1L;
      
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) { MazeWindow.this.newLabyrinth();
			}
      

		});
		localJMenu.add(new AbstractAction("Open Labyrinth") {
			private static final long serialVersionUID = 1L;
      
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) { MazeWindow.this.openLabyrinth();
			}
      

		});
		localJMenu.add(new AbstractAction("Save") {
			private static final long serialVersionUID = 1L;
      
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) { MazeWindow.this.saveLabyrinth();
			}
      

		});
		localJMenu.add(new AbstractAction("Exit") {
			private static final long serialVersionUID = 1L;
      
			public void actionPerformed(ActionEvent paramAnonymousActionEvent) { MazeWindow.this.exit();
			}
      

		});
		localJMenuBar.add(localJMenu);
		setJMenuBar(localJMenuBar);
	}
  
	private void setMaze(MazeViewController paramMazeViewController) {
		this.mazeController = paramMazeViewController;
		this.mazeView.setMazeViewSource(paramMazeViewController.getMazeViewSource());
	}
}
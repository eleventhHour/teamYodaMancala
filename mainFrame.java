import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.*;

public class mainFrame extends JFrame{

	private MancalaGameModel model;
	private int player;
	private Style style;
	private ArrayList<PitsView> pitView; //hold all the pits view information
	private StoreView firstStore; //first store
	private StoreView secondStore; //second store
	private JPanel mainPanel; //Panel that located in center part of main frame, contains all Pits display;
	private JPanel topPanel; // Panel that located in top part of main frame, contains JLabel "PlayerB"
	private JPanel leftPanel;  // Panel that located in left part of main frame, contains JLabel "Player B's Mancala store"
	private JPanel rightPanel; // Panel that located in right part of main frame, contains JLabel "Player A's Mancala store"
	private JPanel bottomPanel;  // Panel that located in bottom part of main frame, contains JLabel "PlayerA" and undo button.
	private JPanel MiddlePanel; //Panel that contains the Pits
	private JPanel topLabelPanel; // Panel that contains label for player B, B6, B5.....
	private JPanel bottomLabelPanel; // Panel that contains label for player A, A1, A2, A3

	public mainFrame(MancalaGameModel m, Style s)
	{
		model = m;
		style = s;

		MiddlePanel = new JPanel(); 
		topLabelPanel = new JPanel();
		bottomLabelPanel = new JPanel(); 

		topPanel = new JPanel();
		leftPanel = new JPanel(); 
		rightPanel = new JPanel();
		bottomPanel = new JPanel(); 

		//adding components to topPanel
		JLabel topLabel = new JLabel("PLAYER B");
		topPanel.add(topLabel);
		topLabel.setFont(new Font("Courier New", Font.BOLD, 20));

		//adding compoents to bottomPanel
		JLabel bottomLabel = new JLabel("PLAYER A");
		bottomPanel.add(bottomLabel);
		bottomLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		JButton undoButton = new JButton("Undo");
		bottomPanel.add(undoButton);


		//Action listener for undo button 
		undoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.undo();
			}
		});



		//adding components for first store
		firstStore = new StoreView(model);
		firstStore.setStyle(style); // setting styles;
		JTextArea StoreA = new JTextArea("M\nA\nN\nC\nA\nL\nA\n \nA"); //Label for store
		StoreA.setEditable(false);
		StoreA.setFont(new Font("monospaced", Font.BOLD, 20));
		rightPanel.add(firstStore);
		rightPanel.add(StoreA);


		//adding components for second store
		JTextArea StoreB = new JTextArea("M\nA\nN\nC\nA\nL\nA\n \nB"); //Label for store
		StoreB.setEditable(false);
		StoreB.setFont(new Font("monospaced", Font.BOLD, 20));
		leftPanel.add(StoreB);
		secondStore = new StoreView(model);
		secondStore.setStyle(style);
		leftPanel.add(secondStore);




		//creating 12 pits views, and add them to array list
		pitView = new ArrayList<PitsView>();
		for (int i=0; i<12;i++)
		{
			PitsView p = new PitsView(model.getStones(), model);
			p.setOpaque(true);
			p.setIndex(i);
			p.setStyle(style);
			pitView.add(p);
		}

		//adding the pits views to model
		for (int i=0;i<12;i++)
		{
			model.addView(pitView.get(i));
		}
		//adding the store views to model
		model.addView(firstStore);
		model.addView(secondStore);

		//action listener for resizing the main frame window
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {

				for (int i=0; i<12;i++)
				{
					int x = MiddlePanel.getWidth()/6-10;
					int y = MiddlePanel.getHeight()/2-5;

					pitView.get(i).setYpos(y);
					pitView.get(i).setXpos(x);

					pitView.get(i).repaint();
				}

				int leftX = MiddlePanel.getWidth()/4;
				int leftY = MiddlePanel.getHeight()/10*7;
				secondStore.setXpos(leftX);
				secondStore.setYpos(leftY);

				int rightX = MiddlePanel.getWidth()/4;
				int rightY = MiddlePanel.getHeight()/10*7;
				firstStore.setXpos(rightX);
				firstStore.setYpos(rightY);

				secondStore.repaint();
				firstStore.repaint();

			}
		});

		
		//adding labels for top panel
		topLabelPanel.setLayout(new GridLayout(0,6));
		for (int i=0; i<6;i++)
		{
			String b = "            B"+(6-i);
			topLabelPanel.add(new JLabel(b));
		}
		
		
		
		//adding all the pits display in middle panel
		MiddlePanel.setLayout(new GridLayout(2,6));
		for (int i=11; i>5;i--){
			MiddlePanel.add(pitView.get(i));
		}
		for (int i=0; i<6;i++){
			MiddlePanel.add(pitView.get(i));
		}
		
		//adding labels for bottom panel
		bottomLabelPanel.setLayout(new GridLayout(0,6));
		for (int i=0; i<6;i++)
		{
			String a = "           A"+(1+i);
			bottomLabelPanel.add(new JLabel(a));
		}

		//adding compoents for main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topLabelPanel, BorderLayout.NORTH);
		mainPanel.add(MiddlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomLabelPanel, BorderLayout.SOUTH);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		mainPanel.setPreferredSize(new Dimension(600, 200));

		//set the layout of main frame and adding all the components
		setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(mainPanel, BorderLayout.CENTER);




		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setVisible(true);


		




	}





}

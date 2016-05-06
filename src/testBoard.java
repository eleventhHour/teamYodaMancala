import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.*;

public class testBoard extends JFrame{

	private MancalaGameModel model;
	private int player;
	Style style;
	public testBoard(MancalaGameModel m, Style s)
	{
		model = m;
		style = s;
		final JPanel MiddlePanel = new JPanel();
		JPanel topLabelPanel = new JPanel();
		JPanel bottomLabelPanel = new JPanel();
		JPanel topPanel = new JPanel();
		final JPanel leftPanel = new JPanel();
		final JPanel rightPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JLabel topLabel = new JLabel("PLAYER B");
		JTextArea StoreA = new JTextArea("M\nA\nN\nC\nA\nL\nA\n \nA");
		JTextArea StoreB = new JTextArea("M\nA\nN\nC\nA\nL\nA\n \nB");
		topPanel.add(topLabel);
		topLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		JLabel bottomLabel = new JLabel("PLAYER A");
		bottomPanel.add(bottomLabel);
		bottomLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		JButton undoButton = new JButton("Undo");
		bottomPanel.add(undoButton);
		
		
		undoButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    model.undo();
			  }
			});
		
		
		//setSize(1910,650);
		final ArrayList<PitsView> pitView= new ArrayList<PitsView>();
		final StoreView firstStore = new StoreView(model);
		firstStore.setStyle(style);
		StoreA.setEditable(false);
		StoreA.setFont(new Font("monospaced", Font.BOLD, 20));
		StoreB.setEditable(false);
		StoreB.setFont(new Font("monospaced", Font.BOLD, 20));
		leftPanel.add(StoreB);
		rightPanel.add(firstStore);
		final StoreView secondStore = new StoreView(model);
		secondStore.setStyle(style);
		leftPanel.add(secondStore);
		rightPanel.add(StoreA);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topLabelPanel, BorderLayout.NORTH);
		mainPanel.add(MiddlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomLabelPanel, BorderLayout.SOUTH);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		mainPanel.setPreferredSize(new Dimension(600, 200));
		for (int i=0; i<12;i++)
		{
			PitsView p = new PitsView(model.getStones(), model);
			p.setOpaque(true);
			p.setIndex(i);
			p.setStyle(style);
			//int x = MiddlePanel.getWidth()/6-10;
    		//int y = MiddlePanel.getHeight()/2-5;
    		//System.out.println("x is: "+x+" y is: "+y);
    		//p.setYpos(y);
			//p.setXpos(x);
			//p.validate();
			//p.repaint();
			pitView.add(p);
		}
		
		for (int i=0;i<12;i++)
		{
			model.addView(pitView.get(i));
		}
		model.addView(firstStore);
		model.addView(secondStore);
		

		
		
		this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
        		
        		for (int i=0; i<12;i++)
        		{
        			int x = MiddlePanel.getWidth()/6-10;
            		int y = MiddlePanel.getHeight()/2-5;
            		
            		System.out.println("new x is: "+x+" new y is: "+y);
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
		
		
		//MiddlePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		MiddlePanel.setLayout(new GridLayout(2,6));
		topLabelPanel.setLayout(new GridLayout(0,6));
		bottomLabelPanel.setLayout(new GridLayout(0,6));
		for (int i=0; i<6;i++)
		{
			String b = "            B"+(6-i);
			topLabelPanel.add(new JLabel(b));
		}
		for (int i=11; i>5;i--){
			MiddlePanel.add(pitView.get(i));
		}

		for (int i=0; i<6;i++){
			MiddlePanel.add(pitView.get(i));
		}
		for (int i=0; i<6;i++)
		{
			String a = "           A"+(1+i);
			bottomLabelPanel.add(new JLabel(a));
		}
		
		//MiddlePanel.validate();
		//MiddlePanel.repaint();
		
	
		
		
		
		//mainPanel.setPreferredSize(new Dimension(1600,400));
		//mainPanel.setMinimumSize(new Dimension(1600,400));
		setLayout(new BorderLayout());
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(mainPanel, BorderLayout.CENTER);
		/*setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.gridx = 0;
        gbc.weightx = 0.1;
        add(leftPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.1;
        add(mainPanel, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.1;
        add(rightPanel, gbc);*/

		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setVisible(true);
		//setLocationRelativeTo(null);
		
		mainPanel.revalidate();
		
		
		 

	}
	


	
	
}

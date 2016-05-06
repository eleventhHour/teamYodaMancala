import java.awt.*;

import javax.swing.*;

public class WinnerWindow extends JDialog{
	
	private MancalaGame model;
	 public WinnerWindow(MancalaGame m)
	 {
		
		 model = m;
	     this.setSize(400, 300);
	     
	     //ImagePanel panel = new ImagePanel(new ImageIcon("back2.jpg").getImage());
	     //this.getContentPane().add(panel);
	     
	     this.setLayout(new BorderLayout());
	     JPanel northPanel = new JPanel();
	     JTextField textNorth = new JTextField();
	     String messageNorth = "Player " + model.checkWin() + " wins!";
	     Font fontNorth = new Font(messageNorth, Font.BOLD, 20);
	     textNorth.setFont(fontNorth);
	     textNorth.setText(messageNorth);
	     northPanel.add(textNorth, BorderLayout.CENTER);
	     this.add(northPanel, BorderLayout.NORTH);
	          
	     JPanel centerPanel = new JPanel(new BorderLayout());
	     
	     //centerPanel.add(back);
	     
	     JLabel textCenterC = new JLabel(); 
	     String messageC = "Player 1: " + model.getFirstStore() + " Player 2: " + model.getSecondStore();
	     Font fontC = new Font(messageC, Font.BOLD, 15);
	     textCenterC.setFont(fontC);
	     textCenterC.setText(messageC);
	     textCenterC.setHorizontalAlignment(JLabel.CENTER);
	     centerPanel.add(textCenterC, BorderLayout.CENTER);
	     
	     JLabel textCenterS = new JLabel();
	     String messageS = "Play Again?";
	     Font fontS = new Font(messageS, Font.BOLD, 15);
	     textCenterS.setFont(fontS);
	     textCenterS.setText(messageS);
	     textCenterS.setHorizontalAlignment(JLabel.CENTER);
	     centerPanel.add(textCenterS, BorderLayout.SOUTH);
	     
	     /*JPanel southPanel = new JPanel(new FlowLayout());
	     button1 = new JButton("Yes");
	     button1.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent event){
	             this.setVisible(false);
	             Mancala.oncreate();
	             this.dispose();
	         }
	     });
	     button2 = new JButton("No");
	     button2.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent event){
	             this.setVisible(false);
	             this.dispose();
	         }
	     });
	     southPanel.add(button1);
	     southPanel.add(button2);*/
	     
	     this.add(centerPanel, BorderLayout.CENTER);
	   
	     this.add(northPanel, BorderLayout.NORTH);
	     this.setVisible(true);   
		 
	 }
	  

}

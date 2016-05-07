
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MancalaTest {
	public static void main(String[] args) {
		MancalaTest main = new MancalaTest();
	}

	
	private final JFrame frame;
	private final JPanel panel;

	public MancalaTest(){
		frame = new JFrame();
		frame.setSize(500, 150);
		frame.setBackground(java.awt.Color.CYAN);

		JLabel label = new JLabel("Select Style: ");

		JButton styleButton1 = new JButton("Style 1");
		styleButton1.setPreferredSize(new Dimension(100, 30));
		
		styleButton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				int stones = findNumStones();
				MancalaGameModel model = new MancalaGameModel(stones);

				mainFrame createGame = new mainFrame(model, new firstStyle());
				frame.dispose();
			}
		});

		JButton styleButton2 = new JButton("Style 2");
		styleButton2.setPreferredSize(new Dimension(100, 30));
		styleButton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				int stones = findNumStones();
				MancalaGameModel model = new MancalaGameModel(stones);
				mainFrame createGame = new mainFrame(model, new secondStyle());
				frame.dispose();
			}
		});

		panel = new JPanel();
		panel.add(label);
		panel.add(styleButton1);
		panel.add(styleButton2);

		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public int findNumStones(){
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = {3, 4};
		String initialSelection  = "3";
		Object selection = JOptionPane.showInputDialog(null, "Select number of stones",
				"",JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		return (int) selection;
	}
}

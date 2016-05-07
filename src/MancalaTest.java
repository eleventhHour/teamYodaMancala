/**
 * Mancala : MancalaTest
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Class that has the main function; also creates a frame that let the
 * player chooses style of board, and a JDialog that for the number of 
 * stones preferred
 */
public class MancalaTest {
    
    //Main class
    public static void main(String[] args) {
	MancalaTest main = new MancalaTest();
    }                
    //private final MancalaGameModel model;
    private final JFrame frame;
    private final JPanel panel;
    
    /**
     * Constructor for MancalaTest that creates a small frame and let user 
     * choose a pattern/style of the board, pits and color of the stones
     */
    public MancalaTest(){
        frame = new JFrame();
        frame.setSize(1000, 150);
        frame.setBackground(Color.CYAN);
        
        //first button: first style - ellipse red pits with blue stones
        JLabel label = new JLabel("Select Style: ");
        JButton styleButton1 = new JButton("Ellipse Red Pits with Blue Stones");
        styleButton1.setPreferredSize(new Dimension(250, 20));
        styleButton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                int stones = findNumStones();
                MancalaGameModel model = new MancalaGameModel(stones);       
                MainFrame test = new MainFrame(model, new FirstStyle());
                frame.dispose();
            }
        });
        
        //second button: second style - square blue pits with yellow stones
        JButton styleButton2 = new JButton("Square Blue Pits with Yellow Stones");
        styleButton2.setPreferredSize(new Dimension(250, 20));
        styleButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                int stones = findNumStones();
                MancalaGameModel model = new MancalaGameModel(stones);
                MainFrame test = new MainFrame(model, new SecondStyle());
                frame.dispose();
            }
        });
        //add all components into the panel
        panel = new JPanel();
        panel.add(label);
        panel.add(styleButton1);
        panel.add(styleButton2);
        
        //add panel into the frame
        frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
    /**
     * Method that creates a JDialog and let user how many stones are preferred for the game
     * @return the number of stones user selected
     */
    public int findNumStones(){
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = {3, 4};
        String initialSelection  = "3";
        Object selection = JOptionPane.showInputDialog(null, "Select Number of Stones",
                "",JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return (int) selection;
    }
}

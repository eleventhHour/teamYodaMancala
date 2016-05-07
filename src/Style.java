/**
 * Mancala : Style - interface
 * Interface for Strategy Pattern (choosing style)
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
import java.awt.*;

public interface Style {
    void paintPits(Graphics g, int xPos, int yPos, int stones);
    void paintMancala(Graphics g, int xPos, int yPos, int stones);
}

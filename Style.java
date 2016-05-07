import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;

//Strategy interface
public interface Style {
    void paintPits(Graphics g, int xPos, int yPos, int stones);
    void paintMancala(Graphics g, int xPos, int yPos, int stones);
}

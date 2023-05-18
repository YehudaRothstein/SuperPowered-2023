import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Counus {
    boolean color;
    public String layer;


    public boolean isColor() {
        return color;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Counus(boolean color, String layer) {
        ImageIcon icon = new ImageIcon("C:\\Users\\אורי\\IdeaProjects\\Scout\\src\\conos.png");
        JLabel image = new JLabel();
        image.setIcon(icon);
        image.setBounds(130, 40, 700, 500);

    }{

    }
}

package view;

import javax.swing.*;
import java.awt.*;

public class CreatComp extends JFrame {
    protected void addComp(Component comp, int x, int y, int width, int height){
        comp.setBounds(x,y,width,height);
        add(comp);
    }
}

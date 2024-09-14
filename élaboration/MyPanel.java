import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    
    public int i,j;

    
    public MyPanel(int i,int j){
        this.i=i;
        this.j=j;
        JPanel panneau = new JPanel();

    }


    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }
}
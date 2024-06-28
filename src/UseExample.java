import javax.swing.*;
import java.awt.*;

class UseExample extends JFrame{

    Slider slider = new Slider(400,400);


    UseExample(){
        setSize(500,500);
        setLayout(null);
        ui();
        setVisible(true);
    }

    private void ui() {

        slider.setLocation(50,50);
        slider.setSelectorColor(Color.BLUE);
        slider.setLinesColor(Color.orange);
        slider.setLineH(25);
        add(slider);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Slider extends JPanel implements MouseMotionListener , ActionListener {
    private int lineH = 20;
    private int selectorX = getWidth();
    private int buttonSizer = selectorX/5;
    private Color linesColor = Color.black;
    private Color selectorColor = Color.red;
    JButton button = new JButton();
    JTextField text = new JTextField();

    Slider(int h, int w){
        setSize(w,h);
        setLayout(null);

        button.setBounds(50,250,50,50);
        button.addActionListener(this);
        add(button);

        text.setBounds(200,300,100,50);
        text.setEditable(false);
        add(text);
    }


    public int getSelectorX(){
        return selectorX;
    }

    public void setLineH(int h){
        lineH = h;
        addMouseMotionListener(this);
        repaint();
    }

    public Color getLinesColor() {
        return linesColor;
    }

    public void setLinesColor(Color linesColor) {
        this.linesColor = linesColor;
    }

    public Color getSelectorColor() {
        return selectorColor;
    }

    public void setSelectorColor(Color selectorColor) {
        this.selectorColor = selectorColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());

        g.setColor(linesColor);
        g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
        g.drawLine(getWidth()/5,getHeight()/2-lineH/2,getWidth()/5,getHeight()/2+lineH/2);
        g.drawLine(getWidth()/5*2,getHeight()/2-lineH/2,getWidth()/5*2,getHeight()/2+lineH/2);
        g.drawLine(getWidth()/5*3,getHeight()/2-lineH/2,getWidth()/5*3,getHeight()/2+lineH/2);
        g.drawLine(getWidth()/5*4,getHeight()/2-lineH/2,getWidth()/5*4,getHeight()/2+lineH/2);
        g.drawLine(getWidth()/5*5,getHeight()/2-lineH/2,getWidth()/5*5,getHeight()/2+lineH/2);

        g.setColor(selectorColor);
        g.fillOval(selectorX,getHeight()/2-10,20,20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getX()>selectorX&&e.getX()<selectorX+20&&e.getX()<getWidth()&&e.getX()>0){
            selectorX=e.getX()-10;
            buttonSizer=selectorX/5;
            text.setText((Integer.toString(selectorX)));
            button.setSize(buttonSizer,buttonSizer);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectorX = 190;
        buttonSizer=selectorX/5;
        text.setText((Integer.toString(selectorX)));
        button.setSize(buttonSizer,buttonSizer);
        repaint();
    }
}

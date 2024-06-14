package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//Class governing the boundary
public class GUI implements ItemListener{

    //primary GUI components get declared
    private int width = 1255;
    private int height = 720;
    private Controller controller;
    private JFrame frame;

    private JPanel panel;
    private JPanel randTextPan;
    private JPanel clockPan;
    private JPanel rotateObjPan;

    private JLabel movingText;
    private JLabel clock;

    private ShapeComponent shape;

    private JToggleButton toggleRandomtextBtn;
    private JToggleButton toggleClockBtn;
    private JToggleButton toggleRotateShapeBtn;

    //initialize components
    public GUI(Controller controller){
        this.controller = controller;

        frame = new JFrame();
        frame.setLocation(400,150);

        frame.setSize(width,height);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(width,height);
        panel.setBackground(Color.BLACK);

        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);

        randTextPan = new JPanel(null);
        randTextPan.setSize(400,400);
        randTextPan.setLocation(10,( ( height/2 ) - 250 ) );
        randTextPan.setBackground(Color.DARK_GRAY);
        randTextPan.setBorder(whiteLine);
        randTextPan.setVisible(true);

        clockPan = new JPanel(null);
        clockPan.setSize(400,400);
        clockPan.setLocation(420,( ( height/2 ) - 250 ));
        clockPan.setBackground(Color.DARK_GRAY);
        clockPan.setBorder(whiteLine);
        clockPan.setVisible(true);

        shape = new ShapeComponent();
        shape.setSize(shape.getPreferredSize());

        rotateObjPan = new JPanel();
        rotateObjPan.setSize(400,400);
        rotateObjPan.setLocation(830,( ( height/2 ) - 250 ));
        rotateObjPan.setBackground(Color.LIGHT_GRAY);
        rotateObjPan.setBorder(whiteLine);
        rotateObjPan.setLayout(null);
        rotateObjPan.setVisible(true);

        clock = new JLabel("Clock");
        clock.setForeground(Color.WHITE);
        clock.setSize(180,40);
        clock.setLocation(110 ,160 );
        clock.setFont(new Font("Serif", Font.PLAIN, 50));
        clock.setVisible(true);

        movingText = new JLabel("I'm here");
        movingText.setForeground(Color.WHITE);
        movingText.setLocation(335,380); // max x = 335, max y = 380;
        movingText.setFont(new Font("Serif", Font.PLAIN, 20));
        movingText.setSize(65,20);
        movingText.setVisible(true);

        toggleRandomtextBtn = new JToggleButton();
        toggleRandomtextBtn.setText("Start");
        toggleRandomtextBtn.setSize(100,25);
        toggleRandomtextBtn.setLocation(155,520);
        toggleRandomtextBtn.addItemListener(this);
        toggleRandomtextBtn.setVisible(true);

        toggleRotateShapeBtn = new JToggleButton();
        toggleRotateShapeBtn.setText("Start");
        toggleRotateShapeBtn.setSize(100,25);
        toggleRotateShapeBtn.setLocation(980,520);
        toggleRotateShapeBtn.addItemListener(this);
        toggleRotateShapeBtn.setVisible(true);

        toggleClockBtn = new JToggleButton();
        toggleClockBtn.setText("Start");
        toggleClockBtn.setSize(100,25);
        toggleClockBtn.setLocation(570,520);
        toggleClockBtn.addItemListener(this);
        toggleClockBtn.setVisible(true);

        frame.add(panel);

        panel.add(randTextPan);
        panel.add(toggleRandomtextBtn);
        panel.add(toggleClockBtn);
        panel.add(toggleRotateShapeBtn);
        panel.add(clockPan);
        panel.add(rotateObjPan);

        //adding main components to their panels
        randTextPan.add(movingText);

        clockPan.add(clock);

        rotateObjPan.add(shape);

        frame.setTitle("Multiple Thread Demonstrator");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    //getters for components
    public JLabel getMovingText() {
        return movingText;
    }

    public JLabel getClock() {
        return clock;
    }

    public ShapeComponent getShape() {
        return shape;
    }

    //listener for togglebuttons
    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getSource() == toggleRandomtextBtn){
            if(toggleRandomtextBtn.isSelected()){
                toggleRandomtextBtn.setText("Stop");
                controller.toggleRandTextOn();
            }
            else{
                toggleRandomtextBtn.setText("Start");
                controller.toggleRandTextOff();
            }
        }

        if(e.getSource() == toggleClockBtn){
            if(toggleClockBtn.isSelected()){
                toggleClockBtn.setText("Stop");
                controller.toggleClockOn();
            }
            else{
                toggleClockBtn.setText("Start");
                controller.toggleClockOff();
            }
        }

        if(e.getSource() == toggleRotateShapeBtn){
            if(toggleRotateShapeBtn.isSelected()){
                toggleRotateShapeBtn.setText("Stop");
                controller.toggleRotateOn();
            }
            else {
                toggleRotateShapeBtn.setText("Start");
                controller.toggleRotateOff();
            }
        }

    }
}

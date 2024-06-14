package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

//a shape component class used to display a graphic 2D shape
public class ShapeComponent extends JComponent {

    private int rotation; //rotational value

    public ShapeComponent(){

    }

    //make graphic 2D component, add the rotational value, paint it out
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //rendering parameters such as anti aliasing
        g2d.setRenderingHints(renderingHints);

        Rectangle2D.Double rectangle = new Rectangle2D.Double(150,150,100,100); //draw square
        g2d.rotate(Math.toRadians(rotation),200,200); //add rotation (degrees to radians)

        g2d.setColor(Color.BLACK); //color shape black
        g2d.fill(rectangle); //fill shape with color
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    //prefered size for the shape
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(400, 400);
    }

}

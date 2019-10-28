package javadraw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This class creates circle!
 * @author Danijel Stefanovic 000789046
 */
public class Circle extends GeometricObject implements DrawMethod {

//Create constructor 
public Circle(double newX, double newY, double newWidth, double newHeight,Color newOutlineColor,Color newFillColor, int newStrokeWidth) {
   
    super(newX,newY,newWidth,newHeight,newOutlineColor,newFillColor,newStrokeWidth);
   
} 

/**
 * draw method for circle
 * @param gc 
 */
public void draw(GraphicsContext gc) {
    
    gc.setLineWidth(getStrokeWidth());
    gc.setStroke(getOutlineColor());
    gc.strokeOval(getX(), getY(), getWidth(), getHeight());
    
    gc.setFill(getFillColor());
    gc.fillOval(getX(), getY(), getWidth(), getHeight());
    
}

/**
 * 
 * @return name of the geometric object 
 */
@Override
public String toString() {
    
    return "Name of the object: Circle!";
}

}

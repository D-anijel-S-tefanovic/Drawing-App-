package javadraw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is creates rectangle!
 * @author Danijel Stefanovic 000789046
 */

public class Rectangle extends GeometricObject implements DrawMethod {
    
//create constructor
Rectangle(double newX, double newY, double newWidth, double newHeight, Color newOutlineColor, Color newFillColor,int newStrokeWidth) {    
    
    super(newX,newY,newWidth,newHeight,newOutlineColor,newFillColor,newStrokeWidth);
   
}

/**
 *  draw method for rectangle 
 * @param gc 
 */
public void draw(GraphicsContext gc) {
    
    
    gc.setLineWidth(getStrokeWidth());
    gc.setStroke(getOutlineColor());
    gc.strokeRect(getX(), getY(), getWidth(), getHeight());
    
    gc.setFill(getFillColor());
    gc.fillRect(getX(), getY(), getWidth(), getHeight());
}

/**
 * 
 * @return name of the geometric object 
 */
@Override
public String toString() {
    
    return "Name of the object: Rectangle!";
}

}

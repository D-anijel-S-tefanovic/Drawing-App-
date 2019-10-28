package javadraw;

import javafx.scene.paint.Color;

/**
 * This is parent class for geometric objects!
 * @author Danijel Stefanovic 000789046
 */
public class GeometricObject {

//Declare variables     
private double x;
private double y;
private double width;
private double height;
private Color fillColor;
private Color outlineColor;
private int strokeWidth;

//Create constructor 
public GeometricObject(double newX, double newY, double newWidth, double newHeight, Color newOutlineColor, Color newFillColor, int newStrokeWidth) {
    
    this.x = newX;
    this.y = newY;
    this.width = newWidth;
    this.height = newHeight;
    this.outlineColor = newOutlineColor;
    this.fillColor = newFillColor;
    this.strokeWidth = newStrokeWidth;
  
}

    /**
     * 
     * @return x coordinate of the shape 
     */
    public double getX() {
        
        return x;
    }

   
    /**
     * 
     * @return y coordinate of the shape 
     */
    public double getY() {
        
        return y;
    }
    
    
    /**
     * 
     * @return width of the shape 
     */
    public double getWidth() {
        
        return width;
    
    }
    
    
    /**
     * 
     * @return height of the shape 
     */
    public double getHeight() {
        
        return height;
    
    }

     /**
     * 
     * @return outlineColor of the shape 
     */
    public Color getOutlineColor() {
        
        return outlineColor;
    
    }
    
    /**
     * 
     * @return fillColor of the shape 
     */
    public Color getFillColor() {
        
        return fillColor;
    
    }

    /**
     * 
     * @return stroke width of the shape 
     */
    public int getStrokeWidth() {
     
        return strokeWidth;
    
    }
    
}

package javadraw;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


/**
 * This is JAVA FX template with GUI components!
 * @author Danijel Stefanovic 000789046
 */
public class DrawingApp extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws NumberFormatException
     */
    
    //Declare variables, objects and array lists 
    private GraphicsContext gc;
    
    private TextField userInput;
    private Button circle,rect,undo,clear;
    
    private ColorPicker cPicker1 = new ColorPicker();
    private ColorPicker cPicker2 = new ColorPicker();
    
    private Color fillColor;
    private Color outlineColor;
    
    private Circle  cShape;
    private Rectangle rShape;
   
    private int choice;
    private double corX;
    private double corY;
    private double width,height;
    private int strokeWidth;
    
    private ArrayList<GeometricObject> shapesList = new ArrayList<>();
    private ArrayList<Integer> subList = new ArrayList<>();
 
    
    /**
     * This method is limiting the space for drawing on the canvas
     */
    private void limitSpace(){
        
        for ( int i = 0; i < shapesList.size(); i++){
            
            if (shapesList.get(i).getX() > 400 || shapesList.get(i).getY() > 400 ){
                
                gc.setFill(Color.GREY);
                gc.fillRect(0,400,1000,300);
                break;
            }
        }
    }
    
    /**
     * This method is handler for Circle Button
     * @param e 
     */
    private void circleButton(ActionEvent e) {
        
        choice = 1;
        circle.setTextFill(Color.BLUE);
        rect.setTextFill(Color.BLACK);
        
        limitSpace();
    }
    
    
    /**
     * This method is handler for Rectangle Button
     * @param e 
     */
    private void rectangleButton(ActionEvent e) {
        
        choice = 2;
        rect.setTextFill(Color.BLUE);
        circle.setTextFill(Color.BLACK);
        
        limitSpace();
    }
    
    /**
     * This method starts the drawing by memorizing first coordinates 
     * @param me 
     */ 
    private void pressHandler(MouseEvent me) {
            
            corX = me.getX();
            corY = me.getY();
            
        //Validate input by usin Exception object    
        try {
            
            int strokeWidth = Integer.parseInt(userInput.getText());

        }
        
        catch (NumberFormatException e) {
            
            userInput.setText("");
            
            new Alert(Alert.AlertType.WARNING, "Invalid Width,Please Try Again!").showAndWait();
        
        }
        
        limitSpace();

    }
    
    /**
     * This method is drags the line in creation of shapes
     * @param me 
     */
    private void dragHandler(MouseEvent me){
        
        width = (me.getX());
        height = (me.getY());
        
        limitSpace();
        
        if (choice == 1) {
            gc.setLineWidth(strokeWidth);
            cShape = new Circle(corX,corY,width,height,outlineColor,fillColor,strokeWidth);
            cShape.draw(gc);
            cShape.toString();
            
            shapesList.add(cShape);
            
            subList.add(0);
            
            System.out.println(shapesList);
        } 
        
        else if (choice == 2) {
            gc.setLineWidth(strokeWidth);
            rShape = new Rectangle(corX,corY,width,height,outlineColor,fillColor,strokeWidth);
            rShape.draw(gc);
            rShape.toString();
            
            shapesList.add(rShape);
            
            subList.add(1);
            
            System.out.println(shapesList);
        } 
    
        limitSpace();
     
    }
     
    /**
     * This method finishes the drawing by memorizing last coordinates 
     * @param me 
     */
    private void releaseHandler(MouseEvent me) {
        
        //Calculate width and height 
        width = (me.getX() - corX);
        height = (me.getY() - corY);
        
        if (choice == 1) {
            
            gc.setLineWidth(strokeWidth);
            cShape = new Circle(corX,corY,width,height,outlineColor,fillColor,strokeWidth);
            cShape.draw(gc);
            cShape.toString();
            
            shapesList.add(cShape);
            
            subList.add(0);
            
            System.out.println(shapesList);
        } 
        
        else if (choice == 2) {
            
            gc.setLineWidth(strokeWidth);
            rShape = new Rectangle(corX,corY,width,height,outlineColor,fillColor,strokeWidth);
            rShape.draw(gc);
            rShape.toString();
            
            shapesList.add(rShape);
            
            subList.add(1);
            
            System.out.println(shapesList);
        } 
    
        limitSpace();
    }
    
    /**
     * This method role is to undo last object drawn
     * @param e 
     */
    private void undoButton(ActionEvent e) {
        
        shapesList.remove(shapesList.size() - 1);
        
        //It has role to distinguish Circle and Rectangle 
        subList.remove(subList.size() - 1);
        
        
        gc.clearRect(0, 0, 1000, 400);
        
        System.out.println(shapesList);
        
        
        for (int i = 0; i < shapesList.size(); i++) {
            
            //Mark this as a Circle 
            if(subList.get(i)==0) {
                cShape = (Circle)shapesList.get(i);
                cShape.draw(gc);
                
                System.out.println(shapesList);
                
            }
            
            if(subList.get(i)==1) {
                //Mark this as a Rectangle 
                rShape = (Rectangle)shapesList.get(i);
                rShape.draw(gc);
                
                System.out.println(shapesList);
            }
        
            else {
                
                System.out.println("List is empty");
            }
        
        }
        
        limitSpace();
    }
  
    /**
     * This method clears the canvas 
     * @param e 
     */
    private void clearButton(ActionEvent e) {
        shapesList.removeAll(shapesList);
        
        gc.clearRect(0, 0, 1000, 400);
        
        System.out.println(shapesList);
    }
    
    /**
     * This method stores the user choice for outline color 
     * @param e 
     */
    private void outlineColorButton(ActionEvent e) {
        
        outlineColor = cPicker1.getValue();
    }
    
    
    /**
     * This method stores the user choice for fill color 
     * @param e 
     */
    private void fillColorButton(ActionEvent e) {
        
        fillColor = cPicker2.getValue();
    
    }
    
   
    @Override
    public void start(Stage stage) throws NumberFormatException {
        
        Group root = new Group();
        Scene scene = new Scene(root);
        
        // Set canvas size in pixels
        Canvas c = new Canvas(1000, 600); 
        
        // Set canvas size in pixels
        stage.setTitle("Java Draw Application"); 
        root.getChildren().addAll(c);
        
        stage.setScene(scene);
        gc = c.getGraphicsContext2D();
       
        
        gc.setFill(Color.GREY);
        gc.fillRect(0,400,1000, 300);
        
        //Create labels
        Label title1 = new Label("Outline Color");
        Label title2 = new Label("Fill Color");
        Label title3 = new Label("Stroke Width");
        
        //Create input field 
        userInput = new TextField("");
        userInput.setPrefColumnCount(7);
        userInput.setText("Enter Number");

        //Create buttons 
        circle = new Button("Circle");
        rect = new Button("Rectangle");
        undo = new Button("Undo");
        clear = new Button("Clear");
        
        //Position and set the size of all components 
        title1.setLayoutX(300);
        title1.setLayoutY(570);
        
        title2.setLayoutX(500);
        title2.setLayoutY(570);
        
        title3.setLayoutX(820);
        title3.setLayoutY(570);
                
        userInput.setLayoutX(810);
        userInput.setLayoutY(540);
        
        circle.setLayoutX(60);
        circle.setLayoutY(440);
        circle.setPrefSize(80,20);
        
        rect.setLayoutX(170);
        rect.setLayoutY(440);
        rect.setPrefSize(80,20);
        
        undo.setLayoutX(750);
        undo.setLayoutY(440);
        undo.setPrefSize(80,20);
        
        clear.setLayoutX(860);
        clear.setLayoutY(440);
        clear.setPrefSize(80,20);
        
        cPicker1.setLayoutX(300);
        cPicker1.setLayoutY(540);
        
        cPicker2.setLayoutX(500);
        cPicker2.setLayoutY(540);
        
        //Add components to the canvas 
        root.getChildren().addAll(title1,title2,title3,userInput,circle,rect,undo,clear,cPicker1,cPicker2);
        
        //Call on action all handlers 
        
        circle.setOnAction(this::circleButton);
        rect.setOnAction(this::rectangleButton);
        undo.setOnAction(this::undoButton);
        clear.setOnAction(this::clearButton);
        cPicker1.setOnAction(this::outlineColorButton);
        cPicker2.setOnAction(this::fillColorButton);
        
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);    
      
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }

   
}

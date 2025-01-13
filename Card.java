import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Card extends Actor
{
   public enum Shape
   {
       CIRCLE, SQUARE, TRIANGLE, NO_SHAPE;
   }
   public enum Color
   {
       RED, GREEN, BLUE, NO_COLOR;
   }
   private Shape shape;
   private Color color;
   private boolean isSelected;
   private GreenfootImage cardImage, selectedCardImage;
   private int numberOfShapes, shading;
   
   public Card(Shape shape, Color color, int numberOfShapes, 
   int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
   {
       this.shape = shape;
       this.color = color;
       this.numberOfShapes = numberOfShapes;
       this.shading = shading;
       this.cardImage = cardImage;
       this.selectedCardImage = selectedCardImage;
       setImage(cardImage);
   }
   
   public Shape getShape()
   {
       return shape;
   }
   
   public Color getColor()
   {
       return color;
   }
   
   public boolean getIsSelected()
   {
       return isSelected;
   }
   
   public GreenfootImage getCardImage()
   {
       return cardImage;
   }
   
   public GreenfootImage getSelectedCardImage()
   {
       return selectedCardImage;
   }
   
   public int getNumberOfShapes()
   {
       return numberOfShapes;
   }
   
   public int getShading()
   {
       return shading;
   }
   
   public void setIsSelected(boolean isSelected)
   {
       this.isSelected = isSelected;
   }
}


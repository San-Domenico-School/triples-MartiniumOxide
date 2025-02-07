import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * deal the cards
 * check if triples
 * @martin
 * @Jan 28, 2025
 */
public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    private boolean shapeFactor;
    private boolean colorFactor;
    private boolean numberOfShapesFactor;
    private boolean shadingFactor;
    public Dealer(int numCardsInDeck) 
    {
        this.numCardsInDeck = numCardsInDeck;
        this.triplesRemaining = numCardsInDeck / 3;
        this.deck = new Deck(numCardsInDeck);
        this.cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world) 
    {
        dealBoard();
        setUI();
        
    }

    // Task 6 - Implement dealBoard
    public void dealBoard() 
    {
        Greenfoot.playSound("shuffle.wav");
        deck.createShuffledDeck();
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Card card = deck.getTopCard();
                getWorld().addObject(card, 130*j+80, 90*i+50);
            }
        }
    }

    
    public void setUI() 
    {
        int cardsRemaining = deck.getNumCardsInDeck(); 
        Integer score = Scorekeeper.getScore();
        getWorld().showText("" + cardsRemaining, 314, 469);
        getWorld().showText("" + score, 314, 505);
    }

    
    public void endGame() 
    {
        Greenfoot.stop();
    }

    public void checkIfTriple(Card[] cardsSelected) 
    {
        this.cardsSelected = cardsSelected;
        checkShape(cardsSelected);
        checkColor(cardsSelected);
        checkNumberOfShapes(cardsSelected);
        checkShading(cardsSelected);
        System.out.println("cardsOnBoard size: " + cardsOnBoard.size());
        System.out.println("selectedCardsIndex: " + selectedCardsIndex);
        System.out.println("cardsSelected: " + cardsSelected);
        if (shapeFactor && colorFactor && numberOfShapesFactor
            && shadingFactor)
        {
            actionIfTriple(cardsSelected);
            System.out.println("triple found");
        }
    }
    
    public boolean checkShape(Card[] cardsSelected)
    {
        if (cardsSelected[0].getShape() == cardsSelected[1].getShape() 
            && cardsSelected[0].getShape() == cardsSelected[2].getShape() )
        {
            shapeFactor = true;
        }
        else if (cardsSelected[0].getShape() != cardsSelected[1].getShape() 
            && cardsSelected[0].getShape() != cardsSelected[2].getShape() 
            && cardsSelected[1].getShape() != cardsSelected[2].getShape())
        {
            shapeFactor = true;
        }
        else
        {
            shapeFactor = false;
        }
        return shapeFactor;
    }
    
    public boolean checkColor(Card[] cardsSelected)
    {
        if (cardsSelected[0].getColor() == cardsSelected[1].getColor() 
            && cardsSelected[0].getColor() == cardsSelected[2].getColor() )
        {
            colorFactor = true;
        }
        else if (cardsSelected[0].getColor() != cardsSelected[1].getColor() 
            && cardsSelected[0].getColor() != cardsSelected[2].getColor() 
            && cardsSelected[1].getColor() != cardsSelected[2].getColor())
        {
            colorFactor = true;
        }
        else
        {
            colorFactor = false;
        }
        return colorFactor;
    }
    
    public boolean checkNumberOfShapes(Card[] cardsSelected)
    {
        if (cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes() 
            && cardsSelected[0].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes() )
        {
            numberOfShapesFactor = true;
        }
        else if (cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes() 
            && cardsSelected[0].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes() 
            && cardsSelected[1].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes())
        {
            numberOfShapesFactor = true;
        }
        else
        {
            numberOfShapesFactor = false;
        }
        return numberOfShapesFactor;
    }

    public boolean checkShading(Card[] cardsSelected)
    {
        if (cardsSelected[0].getShading() == cardsSelected[1].getShading() 
            && cardsSelected[0].getShading() == cardsSelected[2].getShading() )
        {
            shadingFactor = true;
        }
        else if (cardsSelected[0].getShading() != cardsSelected[1].getShading() 
            && cardsSelected[0].getShading() != cardsSelected[2].getShading() 
            && cardsSelected[1].getShading() != cardsSelected[2].getShading())
        {
            shadingFactor = true;
        }
        else
        {
            shadingFactor = false;
        }
        return shadingFactor;
    }

    
    public void actionIfTriple(Card[] cardsSelected) 
    {
        for(int i = 0; i < 3; i++)
        {
            Scorekeeper.updateScore();
            int xPos = cardsSelected[i].getX();
            int yPos = cardsSelected[i].getY();
            getWorld().removeObject(cardsSelected[i]);
            if (deck.getNumCardsInDeck() > 0) 
            {
                Card card = deck.getTopCard();
                getWorld().addObject(card, xPos, yPos);
            }
        }
        cardsOnBoard = new ArrayList<>(getWorld().getObjects(Card.class));
        setUI();
    }

    public void setCardsSelected(ArrayList<Card> selectedCards, 
                                ArrayList<Integer> selectedIndexes, 
                                Card[] selectedArray) 
    {
        this.cardsOnBoard = selectedCards;
        this.selectedCardsIndex = selectedIndexes;
        this.cardsSelected = selectedArray;
    }
    
}

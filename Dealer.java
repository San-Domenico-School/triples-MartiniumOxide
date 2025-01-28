import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    
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
        Deck deck = new Deck(27);
        deck.createShuffledDeck();
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Card card = deck.getTopCard();
                getWorld().addObject(card, 100*i, 100*j);
            }
        }
    }

    
    public void setUI() 
    {
        int cardsRemaining = deck.getNumCardsInDeck();
        Integer score = triplesRemaining;
        //example text
        getWorld().showText("Cards Remaining: " + cardsRemaining, 50, 50);
        getWorld().showText("Score: " + score, 50, 80);
    }

    
    public void endGame() 
    {
        Greenfoot.stop();
    }

    public void checkIfTriple() {
        // Logic to check if selected cards form a triple
    }

    public void actionIfTriple() {
        // Logic for actions if a triple is found
    }

    public void setCardsSelected(ArrayList<Card> selectedCards, ArrayList<Integer> selectedIndexes, Card[] selectedArray) {
        this.cardsOnBoard = selectedCards;
        this.selectedCardsIndex = selectedIndexes;
        this.cardsSelected = selectedArray;
    }
    
}

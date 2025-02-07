import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Play
 * 
 * @martin
 * @Jan 30, 2025
 */
public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    ArrayList<Card> cardsOnBoard;
    ArrayList<Integer> selectedCardsIndex;
    
    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        this.cardsSelected = new Card[3];
        this.cardsOnBoard = new ArrayList<>();
        this.selectedCardsIndex = new ArrayList<>();
    }
    
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex,cardsSelected);
            dealer.checkIfTriple(cardsSelected);
            resetCardsSelected();
        }
    }
    
    public void addedToWorld(World world) 
    {
         cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                Card card = cardsOnBoard.get(i);
                if (card.getIsSelected()) 
                {
                    card.setIsSelected(false);
                    card.setImage(card.getCardImage());
                    selectedCardsIndex.remove(i);
                } 
                else 
                {
                    card.setIsSelected(true);
                    card.setImage(card.getSelectedCardImage());
                    selectedCardsIndex.add(i);
                }
            }
        }
    }
    
    private void resetCardsSelected()
    {
        for (Card card : cardsOnBoard)
        {
            card.setImage(card.getCardImage());
            card.setIsSelected(false);
        }
        selectedCardsIndex.clear();
    }
    
    private boolean setCardsSelected()
    {
        if (selectedCardsIndex.size() == 3)
        {
            for(int i = 0; i < 3; i++)
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
            return true;
        }
        return false;
    }
}

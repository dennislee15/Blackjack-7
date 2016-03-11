package models;

/**
 * Created by ramcharan on 3/10/16.
 */
public class playerGame extends Game
{
    @Override
    public void initialDeal()
    {
        for(int i = 0; i < 2; i++)
        {
            cols.get(1).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);

            playerValues.add(cols.get(1).get(cols.get(1).size()-1).getValue());
        }
        playerScore=getTotalScore(playerValues);
    }
    @Override
    public void split(){
        if(cols.get(1).get(0).value == cols.get(1).get(1).value) {


            Suit suit = cols.get(1).get(1).suit;
            String value = cols.get(1).get(1).value;
            Card newCard = new Card(value, suit);
            cols.get(1).remove(1);
            cols.get(2).add(newCard);

        }
        else{
            errMsg = "Invalid Split";
        }

    }
}

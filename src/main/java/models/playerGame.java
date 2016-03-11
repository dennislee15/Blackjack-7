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
}

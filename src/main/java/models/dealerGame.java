package models;

/**
 * Created by ramcharan on 3/10/16.
 */
public class dealerGame extends Game
{
    @Override
    public void initialDeal()
    {
        for(int i = 0; i < 2; i++)
        {
            cols.get(0).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);

            dealerValues.add(cols.get(0).get(cols.get(0).size()-1).getValue());
        }
        dealerScore=getTotalScore(dealerValues);
    }
    @Override
    public void split(){

    }
}

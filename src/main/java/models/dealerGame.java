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
    public void hit(int colNum)
    {
        if (dealerScore >= 21)
        {
            return;
        }
        cols.get(0).add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);

        dealerValues.add(cols.get(0).get(cols.get(0).size()-1).getValue());

        dealerScore=getTotalScore(dealerValues);
    }

    public void play()
    {
        dealerScore = getTotalScore(dealerValues);
        while(dealerScore<17)
        {
            hit(0);
        }
        //dealerScore = getTotalScore(dealerValues);
        stay(0);
    }

    @Override
    public void stay(int colNum)
    {
        if (dealerScore > 21)
        {
            dealerScore = 0;
            dealerValues.clear();
        }
    }

    @Override
    public void split()
    {

    }
}

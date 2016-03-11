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
    public void hit(int colNum)
    {
        cols.get(colNum).add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);

        if (colNum==1)
        {
            playerValues.add(cols.get(colNum).get(cols.get(colNum).size()-1).getValue());
            playerScore=getTotalScore(playerValues);
        }
        else
        {
            splitValues.add(cols.get(colNum).get(cols.get(colNum).size()-1).getValue());
            splitScore=getTotalScore(splitValues);
        }
    }

    @Override
    public void stay(int colNum)
    {
        if (colNum==1)
        {
            if (playerScore > 21)
            {
                playerScore = 0;
                playerValues.clear();
            }
        }
        else
        {
            if(splitScore > 21)
            {
                splitScore = 0;
                splitValues.clear();
            }
        }
    }
}

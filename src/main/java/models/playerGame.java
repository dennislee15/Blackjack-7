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
        if(colNum ==1) {
            if (playerScore > 21) {
                return;
            }
        }
        else if(colNum == 2){
            if(splitScore > 21){
                return;
            }
        }

        cols.get(colNum).add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);

        if (colNum==1) {
            playerValues.add(cols.get(colNum).get(cols.get(colNum).size() - 1).getValue());
            playerScore = getTotalScore(playerValues);
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

    @Override
    public void split()
    {
        if(cols.get(1).get(0).value.equals(cols.get(1).get(1).value))
        {
            Suit suit = cols.get(1).get(1).suit;
            String value = cols.get(1).get(1).value;
            Card newCard = new Card(value, suit);

            cols.get(1).remove(1);
            playerValues.remove(value);
            cols.get(2).add(newCard);
            splitValues.add(value);
            splitScore=getTotalScore(splitValues);
            errMsg = "Successful Split";
        }
        else
        {
            errMsg = "Invalid Split";
        }
    }
}

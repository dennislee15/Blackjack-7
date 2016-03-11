package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by ramcharan on 3/9/16.
 */
public abstract class Game
{
    public int playerScore;
    public int dealerScore;
    public ArrayList<String> playerValues = new ArrayList<>();
    public ArrayList<String> dealerValues = new ArrayList<>();
    public String errMsg= "";
    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public Game()
    {
        playerScore=0;
        dealerScore=0;

        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }
    public abstract void split();
    public void buildDeck()
    {
        for(int i=2;i<11;i++)
        {
            deck.add(new Card(Integer.toString(i),Suit.Diamonds));
            deck.add(new Card(Integer.toString(i),Suit.Hearts));
            deck.add(new Card(Integer.toString(i),Suit.Clubs));
            deck.add(new Card(Integer.toString(i),Suit.Spades));
        }

        for(int i=0;i<3;i++)
        {
            deck.add(new Card("10",Suit.Clubs));
            deck.add(new Card("10",Suit.Spades));
            deck.add(new Card("10",Suit.Hearts));
            deck.add(new Card("10",Suit.Diamonds));
        }

        deck.add(new Card("A",Suit.Clubs));
        deck.add(new Card("A",Suit.Spades));
        deck.add(new Card("A",Suit.Hearts));
        deck.add(new Card("A",Suit.Diamonds));
    }

    public void shuffle()
    {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public abstract void initialDeal();

    public int getTotalScore(ArrayList<String> scores)
    {
        int total=0;

        for(int i=0;i<scores.size();i++)
        {
            if (scores.get(i).equals("A"))
            {
                total+=11;
                if (total>21)
                {
                    total-=11;
                    total+=1;
                }
            }
            else
            {
                total+=Integer.valueOf(scores.get(i));
            }
        }
        return total;
    }


}

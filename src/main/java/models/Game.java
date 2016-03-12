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
    public int splitScore;
    public ArrayList<String> playerValues = new ArrayList<>();
    public ArrayList<String> dealerValues = new ArrayList<>();
    public ArrayList<String> splitValues = new ArrayList<>();

    public String errMsg= "";
    public String winner="";

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public Game()
    {
        playerScore=0;
        splitScore=0;
        dealerScore=0;

        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    public abstract void initialDeal();
    public abstract void hit(int colNum);
    public abstract void stay(int colNum);
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


    public int getTotalScore(ArrayList<String> scores)
    {
        int total=0;
        int totalAces=0;

        for(int i=0;i<scores.size();i++)
        {
            if (scores.get(i).equals("A"))
            {
                totalAces+=1;
            }
            else
            {
                total+=Integer.valueOf(scores.get(i));
            }
        }

        for(int i=0;i<totalAces;i++)
        {
            if (total>21)
            {
                total+=1;
                continue;
            }
            total+=11;
            if (total>21)
            {
                total-=11;
                total+=1;
            }
        }
        return total;
    }

    public void checkWinner(int dScore,int pScore, int spScore)
    {
        if(pScore > spScore){
            if(dScore > pScore) {
                winner = "Dealer Wins";
            }
            else if(pScore > dScore){
                winner = "Player Wins";
            }
            else{
                winner = "Draw";
            }

        }
        else{
            if(dScore > spScore){
                winner =  "Dealer wins";
            }
            else if(spScore > dScore){
                winner = "Player Wins because < spScore";
            }
            else{
                winner = "Draw";
            }

        }
        /*if (player.playerScore > player.splitScore)
        {
            if (dealer.dealerScore > player.playerScore)
            {
                return "dealer";
            }
            else if (player.playerScore > dealer.dealerScore)
            {
                return "player";
            }
            else
            {
                return "draw";
            }
        }
        else
        {
            if (dealer.dealerScore > player.splitScore)
            {
                return "dealer";
            }
            else if (player.splitScore > dealer.dealerScore)
            {
                return "player";
            }
            else
            {
                return "draw";
            }
        }*/

    }
}
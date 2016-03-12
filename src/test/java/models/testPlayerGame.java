package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Created by ramcharan on 3/10/16.
 */
public class testPlayerGame
{
    @Test
    public void testGameObjCreation()
    {
        playerGame g = new playerGame();
        assertNotNull(g);
    }

    @Test
    public void testIfRightObj()
    {
        playerGame g = new playerGame();
        assertThat(g,instanceOf(playerGame.class));
    }

    @Test
    public void testScoreValues()
    {
        playerGame g = new playerGame();
        assertEquals(g.playerScore,0);
        assertEquals(g.dealerScore,0);
    }

    @Test
    public void testBuildDeck()
    {
        playerGame g = new playerGame();
        g.buildDeck();

        assertEquals(52,g.deck.size());
    }

    @Test
    public void testShuffle()
    {
        playerGame g = new playerGame();
        g.buildDeck();

        g.shuffle();

        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testInitialDeal()
    {
        playerGame g = new playerGame();
        g.buildDeck();
        g.shuffle();

        g.initialDeal();

        assertEquals(2,g.cols.get(1).size());
    }

    @Test
    public void testCustomInitialDeal()
    {
        playerGame g = new playerGame();
        String val1="A";
        String val2="9";

        g.cols.get(1).add(new Card(val1,Suit.Diamonds));
        g.playerValues.add(val1);

        g.cols.get(1).add(new Card(val2,Suit.Hearts));
        g.playerValues.add(val2);

        g.playerScore=g.getTotalScore(g.playerValues);

        assertEquals(20,g.playerScore);
    }

    @Test
    public void testHit()
    {
        playerGame g = new playerGame();
        g.buildDeck();
        g.shuffle();
        g.initialDeal();
        int initialDealTotalScore=g.getTotalScore(g.playerValues);

        g.hit(1);

        assertNotEquals(initialDealTotalScore,g.getTotalScore(g.playerValues));
    }

    @Test
    public void testStay()
    {
        playerGame g = new playerGame();
        g.buildDeck();
        g.shuffle();
        g.initialDeal();

        int score=g.playerScore;

        g.stay(1);

        assertEquals(score,g.playerScore);
        assertNotEquals(g.playerValues.size(),0);

        g.playerValues.add("10");
        g.playerValues.add("10");
        g.playerScore=g.getTotalScore(g.playerValues);

        g.stay(1);

        assertEquals(g.playerScore,0);
        assertEquals(g.playerValues.size(),0);
    }

    @Test
    public void testSplitStay()
    {
        playerGame g = new playerGame();
        dealerGame dealer = new dealerGame();
        dealer.buildDeck();
        dealer.shuffle();
        g.buildDeck();
        g.shuffle();

        dealer.initialDeal();
        dealer.play();

        g.cols.get(1).add(new Card("10",Suit.Clubs));
        g.cols.get(1).add(new Card("10",Suit.Hearts));

        g.split();

        g.hit(1);
        g.hit(1);

        g.stay(1);

        g.hit(2);
        g.hit(2);

        g.stay(2);

        g.checkWinner(dealer.dealerScore,g.playerScore,g.splitScore);
        assertNotEquals(g.winner,"");
        //assertEquals(,g.checkWinner(dealer.dealerScore,g.playerScore,g.splitScore));

    }

    @Test
    public void testCheckWinner()
    {
        playerGame player = new playerGame();
        dealerGame dealer = new dealerGame();

        player.buildDeck();
        player.shuffle();
        dealer.buildDeck();
        dealer.shuffle();

        player.initialDeal();
        dealer.initialDeal();

        player.checkWinner(dealer.dealerScore,player.playerScore,player.splitScore);

        if (player.playerScore > dealer.dealerScore)
        {
            assertEquals(player.winner,"player");
        }
        else if (dealer.dealerScore > player.playerScore)
        {
            assertEquals(player.winner,"dealer");
        }
        else
        {
            assertEquals(player.winner,"draw");
        }
    }

    @Test
    public void testPlayerSplit()
    {
        playerGame g = new playerGame();
        Card card1 = new Card("10", Suit.Hearts);
        Card card2 = new Card("10", Suit.Clubs);
        g.cols.get(1).add(card1);
        g.cols.get(1).add(card2);
        g.split();
        assertNotEquals(null, g.cols.get(2).get(0));
        System.out.println(g.cols.get(1).contains(card2));
        assertFalse(g.cols.get(1).contains(card2));
        assertThat(g.cols.get(2).get(0), instanceOf(Card.class));
    }
}

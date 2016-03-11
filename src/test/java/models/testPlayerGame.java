package models;

import org.junit.Test;

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
    public void testPlayerSplit(){
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

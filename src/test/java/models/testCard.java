package models;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by ramcharan on 3/9/16.
 */
public class testCard
{
    @Test
    public void testObjCreation()
    {
        Card c = new Card("5",Suit.Spades);
        assertNotNull(c);
    }

    @Test
    public void testIfRightObj()
    {
        Card c = new Card("5",Suit.Clubs);
        assertThat(c,instanceOf(Card.class));
    }

    @Test
    public void testGetValue()
    {
        Card c = new Card("5",Suit.Diamonds);
        assertEquals("5",c.getValue());
    }

    @Test
    public void testGetSuit()
    {
        Card c = new Card("5",Suit.Hearts);
        assertEquals(Suit.Hearts,c.getSuit());
    }

    @Test
    public void testToString()
    {
        Card c = new Card("5",Suit.Clubs);
        assertEquals("5Clubs",c.toString());
    }
}

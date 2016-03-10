package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ramcharan on 3/9/16.
 */
public class Card
{
    public final int value;
    public final Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public suit getSuit()
    {
        return this.suit;
    }

    public int getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return this.value + this.suit.toString();
    }
}

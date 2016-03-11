package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ramcharan on 3/9/16.
 */
public class Card
{
    public String value;
    public Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") String value, @JsonProperty("suit") Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public String getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return this.value + this.suit.toString();
    }
}

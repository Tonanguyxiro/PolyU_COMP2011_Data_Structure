package Lecture.Assignment1_template;

import java.util.Arrays;

/*
 * @author Yixin Cao (September 11, 2021)
 *
 * You have been deliver a hand of cards, and you sorted them in the suit-first order: 
 * spades, hearts, clubs, and diamonds, each suit in decreasing order. 
 *
 * See {@code main} where the input is in this order.
 * [♠A, ♠10, ♠8, ♠4, ♠2, ♥K, ♥J, ♥9, ♥8, ♥2, ♣10, ♣4, ♦A, ♦J, ♦9, ♦7, ♦6, ♦4]
 *
 * Your task is to reorder them into rank-first order: for cards of the same rank, you follow the order of spade, heart, club, and then diamond.
 * 
 * For the given hand, the correct result should be: 
 * [♠A, ♦A, ♥K, ♥J, ♦J, ♠10, ♣10, ♥9, ♦9, ♠8, ♥8, ♦7, ♦6, ♠4, ♣4, ♦4, ♠2, ♥2]
 * 
 * You need to set your "text file encoding" to UTF-8 to run this class.
 * Otherwise, the suits of cards cannot be shown properly. 
 * 
 * The class {@code Card} is at the end of this file.
 */
public class CardGame_12345678d_TangTszkei { // Please change!

    /**
     * VERY IMPORTANT.
     * 
     * I've discussed this question with the following students:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * I've sought help from the following Internet resources and books:
     *     1. 
     *     2. 
     *     3. 
     *     ... 
     * 
     * Running time: O(   ).   
     */ 
    public static void reorder(Card[] hand) {}
    

    /*
      Bonus question: reorder in the other direction: rank-first to suit-firt.
      public static void reorderBack(Card[] hand) {
      }
    */    
    
    public static void main(String[] args) {
        /*
         * The following 12 lines are for setting our test data.
         * You can revise them to change the hand for testing. 
         */
        byte[][] data = {{14, 10, 8, 4, 2}, // Spades 
                {13, 11, 9, 8, 2}, // Hearts 
                {10, 4}, // Clubs
                {14, 11, 9, 7, 6, 4} // Diamonds
                };
        Card[] hand = new Card[18];
        for (int i = 0; i < hand.length; i++) {
            for (byte suit = 0; suit < 4; suit++) {
                for (int j = 0; j < data[suit].length; j++) 
                    hand[i++] = new Card(suit, data[suit][j]);
            }
        }
        System.out.println("original: " + Arrays.toString(hand));
        reorder(hand);
        System.out.println("after reordering: " + Arrays.toString(hand));
    }
}

/*
 * Each Card has a suit and a rank, between 2 and 14 (A).
 */
class Card {
    byte suit;
    byte rank;
    public static final byte SPADE = 0;
    public static final byte HEART = 1;
    public static final byte CLUB = 2;
    public static final byte DIAMOND = 3;

    public Card(byte suit, byte rank) {
        this.suit = suit; 
        this.rank = rank;
    }
    public String toString() {
        String s = null;
        switch(suit) {
        case SPADE : s = "\u2660"; break;
        case HEART : s = "\u2665"; break;
        case CLUB : s = "\u2663"; break;
        case DIAMOND : s = "\u2666"; break;
        }
        char[] c = {'J', 'Q', 'K', 'A'};
        s += rank > 10?c[rank-11]:String.valueOf(rank);
        return s;
    }
}

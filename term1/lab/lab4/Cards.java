package lab4;

public class Cards {
    enum Rank {
        ace, 
        two,
        three,
        four,
        five,
        six,
        seven,
        eight,
        nine,
        ten,
        jack,
        queen,
        king
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Rank highCard;
        Rank faceCard;
        Rank card1;
        Rank card2;
        int card1Va1;
        int card2Va2;
        
        highCard = Rank.ace;
        faceCard = Rank.jack;
        card1 = Rank.six;
        card2 = Rank.ten;
        
        System.out.println("A blackjack hand: " + highCard 
                + " and " + faceCard);
        card1Va1 = card1.ordinal() + 1;
        card2Va2 = card2.ordinal() + 1;
        System.out.println("A two card hand: " + card1 + " and " + card2);
        System.out.println("Hand value: " + (card1Va1 + card2Va2));
        // TODO Auto-generated method stub

    }
}

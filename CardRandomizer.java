import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class CardRandomizer {
    public static void main(String[] args) {
        //create window
        JFrame frame = new JFrame("Card Randomizer");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the panel
        JPanel cardPanel = new JPanel();

        //arrange the panel 52 grid
        cardPanel.setLayout(new GridLayout(4, 13));

        //load the card
        //ImageIcon cardImage = new ImageIcon("Cards/2_of_clubs.png");

        //get image out of ImageIcon
        //Image image = cardImage.getImage();

        //resize image
        //Image resizedImage = image.getScaledInstance(60, 90, Image.SCALE_SMOOTH);

        //put the resized image back into an Image Icon
        //cardImage = new ImageIcon(resizedImage);

        //put card image in label
        //JLabel cardLabel = new JLabel(cardImage);

       //put label inside card panel
        //cardPanel.add(cardLabel);

        String[] values = {
                "ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "jack", "queen", "king"
        };

        String[] suits = {
                "clubs", "diamonds", "hearts", "spades"
        };

        ArrayList<JLabel> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String value : values) {
                String fileName = "Cards/" + value + "_of_" + suit + ".png";
                ImageIcon cardImage = new ImageIcon(fileName);
                Image image = cardImage.getImage();
                Image resizedImage = image.getScaledInstance(60, 90, Image.SCALE_SMOOTH);
                cardImage = new ImageIcon(resizedImage);
                JLabel cardLabel = new JLabel(cardImage);

                //add the JLabel to the arrayList
                deck.add(cardLabel);
            }
        }

        //add the cards to the panel
        for(JLabel card: deck) {
            cardPanel.add(card);
        }

        //put the card panel inside the window
        frame.add(cardPanel, BorderLayout.CENTER);

        //Button
        JButton shuffleButton = new JButton("Shuffle");

        //event listener that listens for a user click
        shuffleButton.addActionListener(e-> {
            //Collections has a method that can randomly rearrange an ArrayList
            Collections.shuffle(deck);

            //Remove the currently displayed cards
            cardPanel.removeAll();

            //Add them back into their new shuffled order
            for(JLabel card: deck) {
                cardPanel.add(card);
            }

            //Tell Swing the layout changed
            cardPanel.revalidate();

            //Redraw the panel
            cardPanel.repaint();

            //System.out.println("SHUFFLED");
        });

        //put the button inside the window
        frame.add(shuffleButton, BorderLayout.SOUTH);

        //show everything
        frame.setVisible(true);


    }
}

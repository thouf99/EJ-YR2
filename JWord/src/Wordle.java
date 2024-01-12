import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;


public class Wordle implements ActionListener {

    class PanelForGuesses extends JPanel{
    //This class will set the text for each of
    //the guesses by taking what is inputted to each of the panels
    //and displaying each letter on each panel.

        //this will only take one guess only

        JLabel[] termPillars = new JLabel[5];
        //split up the word by each of their letter and each letter
        //will displayed on each label.
        //Array of size 5 as it will have only 5-letter words
        public PanelForGuesses() {
            //constructor initialise all the components
            this.setLayout(new GridLayout(1,5));
            //layout of each row of labels
            Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
            //this will set the border for the game user interface, more for aesthetics
            for (int i = 0; i < 5; i++){
                //initialises each label inside the array.
                termPillars[i] = new JLabel();
                termPillars[i].setOpaque(true);
                //sets opacity of the label
                termPillars[i].setBorder(blackBorder);
                this.add(termPillars[i]);
            }
        }

        public void clearPanelForGuesses() {
            for (int i = 0; i < 5; i++) {
                termPillars[i].setText("");
            }
        }

        public void setPanelForGuessesText(String characterVal, int pos, Color color){
            //This will set the text for the panel and the color based on the user input
            //
            this.termPillars[pos].setText(characterVal);
            this.termPillars[pos].setBackground(color);
        }
    }
    class UserInterfacePanel extends JPanel{
    //Will accept the user input from when they type and press the button

        private JTextField userInputField;
        //Private so that specific user input can be manipulated and checked with target words
        private JButton checkButton;
        //Private so only when the button is pressed to call the action once users have pressed the button
        public UserInterfacePanel(){
        //initialises the buttons and the textfield
            this.setLayout(new GridLayout(1,3));
            userInputField = new JTextField();
            this.add(userInputField);
            checkButton = new JButton("Check");
            this.add(checkButton);
        }

        public JTextField getUserInput() {
            //get the text from what is inputted by the user
            return userInputField;
        }

        public JButton getcheckButton() {
            //get the button and then later the actionlistener is added in the wordle constructor
            return checkButton;
        }
    }

    private JFrame wordleGameFrame;
    //entire game from

    private PanelForGuesses[] wordPanelArray = new PanelForGuesses[6];
    //creates an array of panel for 6 of the guesses that users have
    private UserInterfacePanel userInterfacePanel;
    //so all the methods from this class can be reused for the user inputs and such
    private String wordOfTheDay;
    //stores the randomly generated wordle string for the user to guess

    private int lives = 0;
    //how many guesses the user has start from 0 and will end at 6 guesses

    public Wordle() {
        //this will take the panel of guesses and the userInterfacePanel and integrate them here
        wordleGameFrame = new JFrame("Wordle Game");
        //set the name of the window of the game
        wordleGameFrame.setSize(450,450);
        //set the width and height
        wordleGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //function when the game is closed by used the 'x' button
        wordleGameFrame.setLayout(new GridLayout(14,1));
        //layout of the game frame 1 column as it will be stored in one
        //column amongs the rows for each of the panels from the userss
        //guess and then also implementing the userInterface at the bottom

        //instructions for the game
        JLabel instructions = new JLabel("Here are the rules: " );
        JLabel instructions1 = new JLabel("1) You will have only six guesses");
        JLabel instructions2 = new JLabel("2) Words only five letters long");
        JLabel instructions3 = new JLabel("3) If the tile is Grey then the letter is not in the word");
        JLabel instructions4 = new JLabel("4) If the tile is Yellow then letter is in word but not in correct position");
        JLabel instructions5 = new JLabel("5) If the tile is Green then the letter iss in the correct position and in the word");

        wordleGameFrame.add(instructions);
        wordleGameFrame.add(instructions1);
        wordleGameFrame.add(instructions2);
        wordleGameFrame.add(instructions3);
        wordleGameFrame.add(instructions4);
        wordleGameFrame.add(instructions5);


        for (int i = 0; i < 6; i++){
            wordPanelArray[i] = new PanelForGuesses();
            //make each array of panels for the  six guesses
            wordleGameFrame.add(wordPanelArray[i]);
            //then add each of these row of panels to the game frame
        }
        userInterfacePanel = new UserInterfacePanel();
        userInterfacePanel.getcheckButton().addActionListener(this);
        //adding the action listener when the check button is pressed
        wordleGameFrame.add(userInterfacePanel);
        wordleGameFrame.revalidate();
        //making sure that every component of the game has loaded correctly
        wordleGameFrame.setVisible(true);


        wordOfTheDay = getWordleWordString();
        //get the string of the word to guess and displays it in the console
        System.out.println("word of the day : " + wordOfTheDay);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userTextGuess = this.userInterfacePanel.getUserInput().getText();
        //converts the text entered by the user to a string


        if (userTextGuess.length() > 4) {
            //making sure that the length of the users guess is 5  and is equal to the wordOfTheDay
            if (getDictionaryString().contains(userTextGuess)){
                if (isWordleWordEqualToUserGuess(userTextGuess.trim().toUpperCase())) {
                    clearAllPanels();
                    JOptionPane.showMessageDialog(null, "You Win!!!", "Congrats", JOptionPane.INFORMATION_MESSAGE);
                    wordleGameFrame.dispose();
                    return;
                }
            } else{
                lives--;
                JOptionPane.showMessageDialog(null, "Word is not in the dictionary", "Whoops",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            //if it is not then allow the user to get another chance to enter another word and not lose a life
            lives--;
            JOptionPane.showMessageDialog(null, "Please enter a 5 letter word", "Whoops",
            JOptionPane.INFORMATION_MESSAGE);
        }
        if (lives > 5) {
            //if all lives are used then the user looses
            JOptionPane.showMessageDialog(null, "You Lost. Better luck next time.", "Whoops",
                    JOptionPane.INFORMATION_MESSAGE);
            wordleGameFrame.dispose();
            return;
        }
        lives++;
    }

    private void clearAllPanels() {
        for (int i = 0; i < lives; i++){
            wordPanelArray[i].clearPanelForGuesses();
            //clears the panel at the current lives
        }
    }

    private boolean isWordleWordEqualToUserGuess(String userTextGuess) {
        //checks if the guess is equal to the word of the day
        List<String> listOfWordleWords = Arrays.asList(wordOfTheDay.split(""));
        //splits the word of the day to compare each letter and assign a color to it
        String[] userTextGuessArray = userTextGuess.split("");
        //array of the users guess
        List<Boolean> doesWordMatchListTF = new ArrayList<>();
        //if letter matches word and in right position it will be correct for that word and when all words
        // are true only return true and user will win the game


        for (int i = 0; i < 5; i++) {
            //goes through the panel row for the guess
            if (listOfWordleWords.contains(userTextGuessArray[i])) {
                //if the word of the day contains letters from user input then
                if (listOfWordleWords.get(i).equals(userTextGuessArray[i])) {
                    //check to see if each position of the letters is the same, if so change to green put boolean to true to
                    //hold the information that that word is in the list.
                    getCurrentPanel().setPanelForGuessesText(userTextGuessArray[i], i, Color.GREEN);
                    //sets the active panel to green
                    doesWordMatchListTF.add(true);
                    //sets true when if word matches position
                } else {
                    getCurrentPanel().setPanelForGuessesText(userTextGuessArray[i], i, Color.YELLOW);
                    //sets color to yellow if letter is in the word but not in the right position
                    doesWordMatchListTF.add(false);
                    //sets false as the word is not correct yet.
                }
            } else {
                getCurrentPanel().setPanelForGuessesText(userTextGuessArray[i], i, Color.GRAY);
                //set color to gray as the word is not in the list
                doesWordMatchListTF.add(false);
                //sets false as word is not in the list.
            }
        }
        //if any of the letters are false return false and the word is not correct
        return !doesWordMatchListTF.contains(false);
    }

    public PanelForGuesses getCurrentPanel() {
        //gets the current active by look at teh current lives the user has and will look at that row.
        return this.wordPanelArray[lives];
    }

    public String getWordleWordString() {
        Path track = Paths.get("..\\\\JWord\\\\targetWords.txt");
        //reads the targetWords file and is added to the list called wordleList
        List<String> wordleList = new ArrayList<>();

        try {
            wordleList = Files.readAllLines(track);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        int position = random.nextInt(wordleList.size());
        return wordleList.get(position).trim().toUpperCase();
        //this will return the randomized word for the user to guess
    }

    public HashSet<String> getDictionaryString() {
        HashSet<String> dict = new HashSet<>();
        try{
            Scanner in_dict  = new Scanner(new File("gameDictionary.txt"));
            while(in_dict.hasNext()){
                dict.add(in_dict.next());
            }
            in_dict.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dict;
        //returns the hashset of all the words in the dictionary.
    }
}
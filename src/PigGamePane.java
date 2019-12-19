import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PigGamePane extends GridPane{
    //all labels
    private Label gameLabel;
    private Label p1RoundScore;
    private Label p1GameScore;
    private Label p2RoundScore;
    private Label p2GameScore;
    private Label die1Outcome;
    private Label die2Outcome;
    private Label turnLabel;
    private Label roundScoreLabel;
    private Label gameScoreLabel;

    //boolean for keeping track of turns and a new Score object to keep track of players' scores
    public Boolean p1Turn = true;

    //creating the gameScore to keep track of points
    public Score gameScore = new Score();

    //allows the images of die faces to be viewable
    private ImageView image1 = new ImageView();
    private ImageView image2 = new ImageView();

    //importing the images of die faces
    private Image faceOne = new Image("Face1.png", 50, 50, true, false);
    private Image faceTwo = new Image("Face2.jpg", 50, 50, true, false);
    private Image faceThree = new Image("Face3.jpg", 50,50, true, false);
    private Image faceFour = new Image("Face4.jpg",50,50,true,false);
    private Image faceFive = new Image("Face5.png", 50,50, true, false);
    private Image faceSix = new Image("Face6.jpg",50,50,true,false);

    //creating the dice used in game
    Die die1 = new Die();
    Die die2 = new Die();

    public PigGamePane(){

        //setting constants fonts for text and labels
        Font font = new Font(18);
        Font bigFont = new Font(24);

        //beginning of formatting texts and labels

        GridPane.setHalignment(image1,HPos.CENTER);
        GridPane.setHalignment(image2,HPos.CENTER);

        Button rollBtn = new Button("Roll");
        rollBtn.setOnAction(this::processRollPress);

        Button passBtn = new Button("Pass");
        passBtn.setOnAction(this::processPassPress);
        Label die1Label = new Label("Dice 1:");
        die1Label.setFont(font);
        GridPane.setHalignment(die1Label,HPos.CENTER);

        Label die2Label = new Label("Dice 2:");
        die2Label.setFont(font);
        GridPane.setHalignment(die2Label,HPos.CENTER);

        gameLabel = new Label("PIG DICE");
        gameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        gameLabel.setTextFill(Color.BLACK);
        GridPane.setHalignment(gameLabel,HPos.CENTER);

        Label p1Label = new Label("Player 1:");
        p1Label.setFont(font);
        GridPane.setHalignment(p1Label,HPos.CENTER);

        Label p2Label = new Label("Player 2:");
        p2Label.setFont(font);
        GridPane.setHalignment(gameLabel,HPos.CENTER);

        turnLabel = new Label("Player 1's Turn");
        turnLabel.setFont(font);
        GridPane.setHalignment(turnLabel,HPos.CENTER);

        roundScoreLabel = new Label("Round\nScore:");
        roundScoreLabel.setFont(font);
        GridPane.setHalignment(roundScoreLabel,HPos.CENTER);

        gameScoreLabel = new Label("Game\nScore:");
        gameScoreLabel.setFont(font);
        GridPane.setHalignment(gameScoreLabel,HPos.CENTER);

        p1RoundScore = new Label("0");
        p1RoundScore.setFont(font);
        GridPane.setHalignment(p1RoundScore,HPos.CENTER);

        p1GameScore = new Label("0");
        p1GameScore.setFont(font);
        GridPane.setHalignment(p1GameScore,HPos.CENTER);
        
        p2RoundScore = new Label("0");
        p2RoundScore.setFont(font);
        GridPane.setHalignment(p2RoundScore,HPos.CENTER);

        p2GameScore = new Label("0");
        p2GameScore.setFont(font);
        GridPane.setHalignment(p2GameScore,HPos.CENTER);

        die1Outcome = new Label("--");
        die1Outcome.setFont(font);
        GridPane.setHalignment(die1Outcome,HPos.LEFT);

        die2Outcome = new Label("--");
        die2Outcome.setFont(font);
        GridPane.setHalignment(die2Outcome,HPos.LEFT);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: skyblue");

        add(image2,2,6);
        add(image1, 2, 5 );
        add(gameLabel, 2, 0);
        add(p1Label,1,2);
        add(p2Label, 3, 2);
        add(p1RoundScore,1,3);
        add(p1GameScore,1,4);
        add(p2RoundScore,3,3);
        add(p2GameScore,3,4);
        add(roundScoreLabel,0,3);
        add(gameScoreLabel,0,4);
        add(die1Label,1,5);
        add(die2Label,1,6);
        add(die1Outcome,3,5);
        add(die2Outcome,3,6);
        add(turnLabel,2,1);
        add(rollBtn,1,7);
        add(passBtn,3,7);

        //end of formatting texts and labels
    }

    private void processRollPress(ActionEvent event){
        //rolls dice and changes text boxes
        die1.roll();
        die2.roll();
        die1Outcome.setText(Integer.toString(die1.getFace()));
        die2Outcome.setText(Integer.toString(die2.getFace()));

        //Changes the image of die 1 to be the same as number rolled
        if(die1.getFace()==1)
            image1.setImage(faceOne);
        if(die1.getFace()==2)
            image1.setImage(faceTwo);
        if(die1.getFace()==3)
            image1.setImage(faceThree);
        if(die1.getFace()==4)
            image1.setImage(faceFour);
        if(die1.getFace()==5)
            image1.setImage(faceFive);
        if(die1.getFace()==6)
            image1.setImage(faceSix);

        //changes image of die 2 to be the same as number rolled
        if(die2.getFace()==1)
            image2.setImage(faceOne);
        if(die2.getFace()==2)
            image2.setImage(faceTwo);
        if(die2.getFace()==3)
            image2.setImage(faceThree);
        if(die2.getFace()==4)
            image2.setImage(faceFour);
        if(die2.getFace()==5)
            image2.setImage(faceFive);
        if(die2.getFace()==6)
            image2.setImage(faceSix);

        if(p1Turn){ //player ONE turn
            //neither dice rolls a one
            if(die1.getFace() > 1 && die2.getFace() > 1){
                p1RoundScore.setText(Integer.toString(gameScore.noOnesP1(die1.getFace(), die2.getFace())));
            }
            //one die rolls a one
            else if((die1.getFace() == 1 && die2.getFace() > 1)||(die1.getFace() != 1 && die2.getFace() == 1)){
                gameScore.setP1RScore(0);
                p1Turn = !p1Turn;
                turnLabel.setText("Player 2's Turn");
                p1RoundScore.setText("0");
            }
            //both dies roll a one
            else if(die1.getFace() == 1 && die2.getFace() ==1){
                gameScore.bothOnesP1();
                p1GameScore.setText("0");
                p1RoundScore.setText("0");
                p1Turn = !p1Turn;
                turnLabel.setText("Player 2's Turn");
            }
            if(gameScore.checkWinP1()){
                gameLabel.setText("PLAYER 1 WINS!!!");
            }
            else if(gameScore.checkWinP2()){
                gameLabel.setText("PLAYER 2 WINS!!!");
            }
        }
        else{ //player TWO turn
            //neither dice rolls a one
            if(die1.getFace() > 1 && die2.getFace() > 1){
                p2RoundScore.setText(Integer.toString(gameScore.noOnesP2(die1.getFace(), die2.getFace())));
            }
            //one die rolls a one
            else if((die1.getFace() == 1 && die2.getFace() != 1)||(die1.getFace() != 1 && die2.getFace() == 1)){
                gameScore.setP2RScore(0);
                p1Turn = !p1Turn;
                turnLabel.setText("Player 1's Turn");
                p2RoundScore.setText("0");
            }
            //both dies roll a one
            else if(die1.getFace() == 1 && die2.getFace() ==1){
                gameScore.bothOnesP2();
                p2GameScore.setText("0");
                p2RoundScore.setText("0");
                p1Turn = !p1Turn;
                turnLabel.setText("Player 1's Turn");
            }
        }
        //check for winners
        if(gameScore.checkWinP1()){
            gameLabel.setText("Please Exit Now.");
            turnLabel.setText("PLAYER 1 WINS!!!");
            p1RoundScore.setText("PLAYER 1 WINS!!!");
            p2RoundScore.setText("PLAYER 1 WINS!!!");
            p1GameScore.setText("PLAYER 1 WINS!!!");
            p2GameScore.setText("PLAYER 1 WINS!!!");
            roundScoreLabel.setText("PLAYER 1 WINS!!!");
            gameScoreLabel.setText("PLAYER 1 WINS!!!");
        }
        else if(gameScore.checkWinP2()){
            gameLabel.setText("Please Exit Now.");
            turnLabel.setText("PLAYER 2 WINS!!!");
            p1RoundScore.setText("PLAYER 2 WINS!!!");
            p2RoundScore.setText("PLAYER 2 WINS!!!");
            p1GameScore.setText("PLAYER 2 WINS!!!");
            p2GameScore.setText("PLAYER 2 WINS!!!");
            roundScoreLabel.setText("PLAYER 2 WINS!!!");
            gameScoreLabel.setText("PLAYER 2 WINS!!!");
        }
    }
//pass button is pressed
    private void processPassPress(ActionEvent event){
        //player one presses
        if(p1Turn){
            turnLabel.setText("Player 2's Turn");
            p1Turn = !p1Turn;
            p1GameScore.setText(Integer.toString(gameScore.passPressP1()));
            p1RoundScore.setText("0");
        }
        //player two presses
        else{
            turnLabel.setText("Player 1's Turn");
            p1Turn = !p1Turn;
            p2GameScore.setText(Integer.toString(gameScore.passPressP2()));
            p2RoundScore.setText("0");
        }
        //checking for winners
        if (gameScore.checkWinP1()) {
            gameLabel.setText("Please Exit Now.");
            turnLabel.setText("PLAYER 1 WINS!!!");
            p1RoundScore.setText("PLAYER 1 WINS!!!");
            p2RoundScore.setText("PLAYER 1 WINS!!!");
            p1GameScore.setText("PLAYER 1 WINS!!!");
            p2GameScore.setText("PLAYER 1 WINS!!!");
            roundScoreLabel.setText("PLAYER 1 WINS!!!");
            gameScoreLabel.setText("PLAYER 1 WINS!!!");
        } else if (gameScore.checkWinP2()) {
            gameLabel.setText("Please Exit Now.");
            turnLabel.setText("PLAYER 2 WINS!!!");
            p1RoundScore.setText("PLAYER 2 WINS!!!");
            p2RoundScore.setText("PLAYER 2 WINS!!!");
            p1GameScore.setText("PLAYER 2 WINS!!!");
            p2GameScore.setText("PLAYER 2 WINS!!!");
            roundScoreLabel.setText("PLAYER 2 WINS!!!");
            gameScoreLabel.setText("PLAYER 2 WINS!!!");
        }
    }
}

public class Score {
    //variables to keep trach of each player's game and round scores
    public int p1RScore = 0;
    public int p1GScore = 0;
    public int p2RScore = 0;
    public int p2GScore = 0;

    public Score(){
    }
    //getters for each of the score variables
    public int getP1RScore(){
        return p1RScore;
    }
    public int getP1GScore(){
        return p1GScore;
    }
    public int getP2RScore(){
        return p2RScore;
    }
    public int getP2GScore(){
        return p2GScore;
    }

    //setters for each of the score variables
    public void setP1RScore(int set1){
        p1RScore = set1;
    }
    public void setP1GScore(int set2){
        p1GScore = set2;
    }
    public void setP2RScore(int set3){
        p2RScore = set3;
    }
    public void setP2GScore(int set4){
        p2GScore = set4;
    }

    //methods for score manipulation if both die roll something other than one
    public int noOnesP1(int die1, int die2){
        p1RScore = p1RScore + die1 + die2;
        return p1RScore;
    }
    public int noOnesP2(int die1, int die2){
        p2RScore = p2RScore + die1 + die2;
        return p2RScore;
    }

    //methods for score manipulation if a player passes their turn
    public int passPressP1(){
        p1GScore = p1GScore + p1RScore;
        p1RScore = 0;
        return p1GScore;
    }
    public int passPressP2(){
        p2GScore = p2GScore+p2RScore;
        p2RScore = 0;
        return p2GScore;
    }

    //methods for score manipulation if both die roll a one
    public void bothOnesP1(){
        p1GScore = 0;
        p1RScore = 0;
    }
    public void bothOnesP2(){
        p2GScore = 0;
        p2RScore = 0;
    }

    //methods for checking if each player has one yet
    public boolean checkWinP1(){
        if(p1GScore >= 100){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkWinP2(){
        if(p2GScore >= 100){
            return true;
        }
        else{
            return false;
        }
    }
}

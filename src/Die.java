public class Die {
    private int face = 1; //the face and value of the die

    public Die() {
    }

    //getter to see face values
    public int getFace() {
        return face;
    }

    //making a roll method randomizing numbers from 1 to 6
    public void roll(){
        face = (int)((Math.random()*6)+1);
    }

}

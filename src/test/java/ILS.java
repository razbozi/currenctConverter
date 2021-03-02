import java.io.Serializable;

public class ILS extends Coin implements Serializable {
    private final double value=0.28;

    @Override
    public double getValue(){
        return value;
    }


    public double calculate (double input){
        return input * getValue();
    }
}
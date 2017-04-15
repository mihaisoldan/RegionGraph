import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mihai on 25/01/17.
 */
public class ClockConstraint {

    private Clock clock;
    private String operator;
    private int clockValue;
    //private boolean intervalClosed = false;
    private boolean pastClosed = false;

    ClockConstraint(Clock c, String inv) throws IllegalArgumentException{
        Pattern p = Pattern.compile("^([<>]?=?)\\s*(\\d+)$");
        Matcher m = p.matcher(inv);
        if(!m.matches())
            throw new IllegalArgumentException("The clock constraint is not a valid one.");
        this.clock = c;
        this.operator = m.group(1);
        this.clockValue = Integer.parseInt(m.group(2));
        if (this.operator.equals("<") || this.operator.equals("<="))
            this.pastClosed=true;
    }

    public Clock getClock() {
        return clock;
    }

    public String getOperator() {
        return operator;
    }

    public int getclockValue() {
        return clockValue;
    }

    public boolean isPastClosed() {
        return pastClosed;
    }

    @Override
    public String toString() {
        return  clock + operator + clockValue;
    }
}

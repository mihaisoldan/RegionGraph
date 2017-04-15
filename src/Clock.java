import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mihai on 25/01/17.
 */
public class Clock {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public Clock(String name) {
        Pattern p = Pattern.compile("^\\s*(\\w+)\\s*$");
        Matcher m = p.matcher(name);
        if (!m.matches())
            throw new IllegalArgumentException("The names of the clocks should be an alphanumeric string.");
        this.name = m.group(1);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clock clock = (Clock) o;

        return name.equals(clock.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName(){
        return name;
    }
}

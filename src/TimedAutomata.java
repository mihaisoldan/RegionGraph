import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by mihai on 25/01/17.
 */
public class TimedAutomata {
    private ArrayList<Clock> clocks = new ArrayList<Clock>();
    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

    public void setClocks(String... clocks) throws IllegalArgumentException{
        for (String c: clocks)
            this.clocks.add(new Clock(c));
    }

    public void setLocations(String... locations) throws IllegalArgumentException{
        for(String l:locations){
            if(!this.locations.contains(new Location(l)))
                this.locations.add(new Location(l));
            else
                throw new IllegalArgumentException("You cannot use the same name for different locations.");
        }
    }
    public void addInvariant(String loc, String inv) throws IllegalArgumentException{
        if(!locations.contains(new Location(loc))) throw new IllegalArgumentException("The specified Invariant refers " +
                "to an absent location");
        Location location = null;
        for(Location l:locations)
            if(l.getName().equals(loc)) {
                location = l;
                break;
            }
        Pattern p = Pattern.compile("^\\s*(\\w)\\s*([<>]?=?\\s*\\d+)\\s*$");
        Matcher m = p.matcher(inv);
        boolean b = m.matches();
        if(!b) throw new IllegalArgumentException("The specified invariant is not syntatically correct.");
        Clock tempClock = new Clock(m.group(1));
        if(!this.clocks.contains(tempClock)) throw new IllegalArgumentException("The specified clock hasn't been declared.");
        ClockConstraint tempInv = new ClockConstraint(tempClock, m.group(2));
        location.addInvariant(tempInv);
    }

    //public void addEdge(String origin, String destination, String guard, String action, String...)

    public ArrayList<Clock> getClocks() {
        return clocks;
    }

    public ArrayList<Location> getLocations(){
        return locations;
    }

    @Override
    public String toString() {
        return "TimedAutomata{\n" +
                "clocks=" + clocks + "\n" +
                "locations=" + locations + "\n" +
                '}';
    }
}

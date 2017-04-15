import java.util.ArrayList;

/**
 * Created by mihai on 20/02/17.
 */
public class Edge {
    private Location origin;
    private Location destination;
    private ArrayList<ClockConstraint> guard;
    private ArrayList<Clock> resetSet;
    private String action;

    public Edge(Location origin, Location destination, ArrayList<ClockConstraint> guard, ArrayList<Clock> resetSet, String action) {
        this.origin = origin;
        this.destination = destination;
        this.guard = guard;
        this.resetSet = resetSet;
        this.action = action;
    }
}

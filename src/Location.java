import java.util.ArrayList;

/**
 * Created by mihai on 24/01/17.
 */
public class Location {
    private String name;
    private ArrayList<ClockConstraint> invariants = new ArrayList<>();

    public Location(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        return name != null ? name.equals(location.name) : location.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        if (invariants.size()==0)
            return name;
        String toPrint = "";
        int i =0;
        for(; i< this.invariants.size()-1;i++)
            toPrint+=this.invariants.get(i).toString() + " && ";
        toPrint+=invariants.get(i).toString();
        return name + ": " + toPrint;

    }

    public void addInvariant(ClockConstraint constraint) throws IllegalArgumentException{
        if (constraint.isPastClosed())
            this.invariants.add(constraint);
        else
            throw new IllegalArgumentException("The clock constraint has to be past closed.");
    }
}

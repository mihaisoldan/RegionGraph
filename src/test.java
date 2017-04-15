/**
 * Created by mihai on 25/01/17.
 */
public class test {
    public static void main(String[] args){
        TimedAutomata myAutomata = new TimedAutomata();
        myAutomata.setClocks("a", "b");
        //myAutomata.printClocks();
        //ClockConstraint cons = new ClockConstraint(myAutomata.getClocks().get(0),"<=10");
        //System.out.println(cons.getClock().getName()+ "\n" + cons.getOperator() + "\n" + cons.getClock_value());
        myAutomata.setLocations("start", "finish");
        //System.out.println(myAutomata.getLocations().toString());
        myAutomata.addInvariant("start", "a<=10");
        myAutomata.addInvariant("start", "b<=5");
        System.out.println(myAutomata.toString());

    }
}

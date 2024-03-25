import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class balok {
    List<String> onTable = new ArrayList<>();
    List<String> clear = new ArrayList<>();
    String holding = null;

    public balok() {
        for (int i = 1; i <= 10; i++) {
            onTable.add(String.valueOf(i));
            clear.add(String.valueOf(i));
        }
    }

    public void pickup(String block) {
        if (onTable.contains(block) && clear.contains(block) && holding == null) {
            onTable.remove(block);
            clear.remove(block);
            holding = block;
            System.out.println("PICKUP(" + block + ")");
        }
    }

    public void putdown(String block) {
        if (holding != null && holding.equals(block)) {
            onTable.add(block);
            clear.add(block);
            holding = null;
            System.out.println("PUTDOWN(" + block + ")");
        }
    }

    public void printState() {
        System.out.println("On Table: " + onTable.stream().collect(Collectors.joining(", ")));
        System.out.println("Clear: " + clear.stream().collect(Collectors.joining(", ")));
        System.out.println("Holding: " + (holding == null ? "None" : holding));
    }

    public static void main(String[] args) {
        balok world = new balok();
        world.printState();

        world.pickup("1");
        world.printState();

    }
}
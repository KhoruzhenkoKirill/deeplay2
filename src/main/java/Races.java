import java.util.*;

public enum Races {
    HUMAN(new int[]{5, 2, 3, 1}),
    SWAMPER(new int[]{2, 2, 5, 2}),
    WOODMAN(new int[]{3, 3, 2, 2});

    private final Map<Character, Integer> movement;

    Races(final int[] steps) {
        final char[] locations = {'S', 'W', 'T', 'P'};
        movement = new HashMap<>();

        for (int i = 0; i < locations.length; i++) {
            movement.put(locations[i], steps[i]);
        }
    }

    public List<Integer> getWeightList(final String map) {
        final List<Integer> weights = new ArrayList<>();
        for (final char ch : map.toCharArray()) {
            weights.add(movement.get(ch));
        }
        return weights;
    }

    public List<Integer> getWeightListExp(final String map) {
        return map.chars().map(i -> movement.get((char) i)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}

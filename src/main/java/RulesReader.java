import java.io.*;
import java.util.*;

public class RulesReader {
    public Map<Character, Integer> getMovementFromFile(final String race) {
        final Validator validator = new Validator();
        final Map<Character, Integer> records = new HashMap<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(Objects.requireNonNull
                                     (getClass().getClassLoader().getResourceAsStream(Parameters.NAME_OF_FILE))))) {

            String line = reader.readLine();

            final List<String> races = Arrays.asList(line.split(","));
            races.stream().filter(r -> !"".equals(r)).forEach(validator::validateRace);

            while ((line = reader.readLine()) != null) {
                final String[] movement = line.split(",");
                validator.validateLocation(movement[0]);
                validator.validateWeights(movement[races.indexOf(race)]);
                records.put(movement[0].charAt(0), Integer.parseInt(movement[races.indexOf(race)]));
            }
        } catch (final IOException ioe) {
            throw new IllegalStateException(ErrorCode.ILLEGAL_RULES.getMessage());
        }
        return records;
    }

    public List<Integer> getWeightsList(final String map, final Map<Character, Integer> movement) {
        final List<Integer> weights = new ArrayList<>();
        for (final char ch : map.toCharArray()) {
            weights.add(movement.get(ch));
        }
        return weights;
    }
}

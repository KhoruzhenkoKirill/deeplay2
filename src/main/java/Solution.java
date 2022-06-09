import java.util.List;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Solution {
    private static final int INF = Integer.MAX_VALUE;
    public static int getResult(final String values, final String race, final RulesType rule) {
        final Validator validator = new Validator();
        final RulesReader reader = new RulesReader();

        validator.validateValues(values);
        for (final char ch : values.toCharArray())
            validator.validateLocation(String.valueOf(ch));
        validator.validateRace(race);

        final List<Integer> weights;

        if (rule == RulesType.FROM_ENUM)
            weights = Races.valueOf(race.toUpperCase()).getWeightList(values);
        else if (rule == RulesType.FROM_FILE)
            weights = reader.getWeightsList(values, reader.getMovementFromFile(race));
        else
            throw new IllegalArgumentException("Incorrect rule " + rule);

        /*
          current - лист весов дуг, полученный из входной строки values
          graph - таблица смежности
          user - массив помеченных/непомеченных вершин
          dist - массив расстояния
         */

        final int[][] graph = new int[Parameters.BOARD_SIZE][Parameters.BOARD_SIZE];
        final boolean[] used = new boolean[Parameters.BOARD_SIZE];
        final int[] dist = new int[Parameters.BOARD_SIZE];

        /*
          Здесь происходит заполнение таблицы смежности.
          В рамках нашей задачи (игровое поле 4х4) заполнение будет всегда происходить по одному алгоритму
          OFFSET - смещение относительно главной диагонали
          COLS - тоже смещение относительно главной диагонали.
                 Обусловленно тем, что мы указываем вес вершины, которая находится в том же столбце в другой строке
          weights.remove(0) - нам нужен т.к. вес стартовой локации не учитывается
         */

        weights.remove(0);

        for (final int[] i : graph)
            fill(i, INF);

        for (int i = 0; i < graph.length - Parameters.OFFSET; i++) {
            if ((i + Parameters.OFFSET) % Parameters.COLS != 0)
                graph[i][i + Parameters.OFFSET] = weights.get(i);
            if (i < graph.length - Parameters.COLS)
                graph[i][i + Parameters.COLS] = weights.get(i + Parameters.COLS - Parameters.OFFSET);
        }

        fill(dist, INF);
        dist[0] = 0;

        for (; ; ) {
            int v = -1;
            for (int nv = 0; nv < Parameters.BOARD_SIZE; nv++)
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv]))
                    v = nv;
            if (v == -1) break;
            used[v] = true;
            for (int nv = 0; nv < Parameters.BOARD_SIZE; nv++)
                if (!used[nv] && graph[v][nv] < INF)
                    dist[nv] = min(dist[nv], dist[v] + graph[v][nv]);
        }

        return dist[Parameters.BOARD_SIZE - 1];
    }
}
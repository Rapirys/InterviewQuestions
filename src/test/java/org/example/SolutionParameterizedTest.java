package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class SolutionParameterizedTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "allocateResources({0}, {1}) -> {2}")
  @CsvFileSource(resources = "/test_cases.csv", numLinesToSkip = 1, delimiter = ';', maxCharsPerColumn = 100000)
  void shouldSolveCsvCases(String costs, int budget, String expected) {
    List<List<Integer>> result = solution.allocateResources(parseCosts(costs), budget);
    List<List<Integer>> exp = parseExpected(expected);

    assertThat(result)
        .usingRecursiveFieldByFieldElementComparator()
        .containsExactlyInAnyOrderElementsOf(exp);
  }

  private static int[] parseCosts(String s) {
    String inner = s.trim();
    inner = inner.substring(1, inner.length() - 1).trim(); // remove [ ]
    if (inner.isEmpty()) return new int[0];

    return Arrays.stream(inner.split(",\\s*"))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  private static List<List<Integer>> parseExpected(String s) {
    String t = s.trim();
    if (t.equals("[]")) return List.of();

    t = t.substring(2, t.length() - 2); // remove outer [[ and ]]
    String[] groups = t.split("\\],\\s*\\[");

    List<List<Integer>> res = new ArrayList<>();
    for (String g : groups) {
      List<Integer> combo = Arrays.stream(g.split(",\\s*"))
          .map(Integer::parseInt)
          .toList();
      res.add(combo);
    }
    return res;
  }
}

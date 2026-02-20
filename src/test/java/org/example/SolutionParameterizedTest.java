package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class SolutionParameterizedTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "rob({0}) -> {1}")
  @CsvFileSource(resources = "/rob_cases.csv", numLinesToSkip = 1)
  void shouldSolveProvidedExamples(String nums, int expected) {
    assertThat(solution.planWork(parseInput(nums))).isEqualTo(expected);
  }

  private static int[] parseInput(String s) {
    String inner = s.trim().replaceAll("^\\[|\\]$", "").trim();
    if (inner.isEmpty()) return new int[0];

    return Arrays.stream(inner.split("\\s*,\\s*"))
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}

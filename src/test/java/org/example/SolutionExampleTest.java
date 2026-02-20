package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionExampleTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "allocateResources({0}, {1}) = {2}")
  @MethodSource("exampleCases")
  void shouldSolveProvidedExamples(int[] instanceCosts, int budget, List<List<Integer>> expected) {
    List<List<Integer>> result = solution.allocateResources(instanceCosts, budget);

    assertThat(result)
        .usingRecursiveComparison()
        .ignoringCollectionOrder()
        .isEqualTo(expected);
  }

  static Stream<Arguments> exampleCases() {
    return Stream.of(
        Arguments.of(new int[]{2, 3, 6, 7}, 7, List.of(
            List.of(2, 2, 3),
            List.of(7)
        )),
        Arguments.of(new int[]{2, 3, 5}, 8, List.of(
            List.of(2, 2, 2, 2),
            List.of(2, 3, 3),
            List.of(3, 5)
        )),
        Arguments.of(new int[]{2}, 1, List.of())
    );
  }
}

package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionExampleTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "rob({0}) = {1}")
  @MethodSource("exampleCases")
  void shouldSolveProvidedExamples(int[] nums, int expected) {
    int result = solution.planWork(nums);
    assertThat(result).isEqualTo(expected);
  }

  static Stream<Arguments> exampleCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 1}, 4),
        Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
    );
  }
}

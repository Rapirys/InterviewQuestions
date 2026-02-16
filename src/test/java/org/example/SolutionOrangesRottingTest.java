package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionOrangesRottingTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "orangesRotting(case {index}) -> {1}")
  @MethodSource("cases")
  void shouldComputeMinutesToRotAllOranges(int[][] grid, int expected) {
    assertThat(solution.orangesRotting(grid)).isEqualTo(expected);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
        Arguments.of(new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        }, 4),
        Arguments.of(new int[][]{
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        }, -1),
        Arguments.of(new int[][]{{0, 2}}, 0),
        Arguments.of(new int[][]{
            {2, 2},
            {2, 2}
        }, 0),
        Arguments.of(new int[][]{{1}}, -1)
    );
  }
}

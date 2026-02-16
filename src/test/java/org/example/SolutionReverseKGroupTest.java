package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionReverseKGroupTest {

  private final Solution solution = new Solution();

  @ParameterizedTest(name = "reverseKGroup(case {index})")
  @MethodSource("cases")
  void shouldReverseNodesInGroupsOfK(int[] values, int k, int[] expected) {
    Solution.ListNode head = toList(values);

    Solution.ListNode reversed = solution.reverseKGroup(head, k);

    assertThat(toArray(reversed)).isEqualTo(expected);
  }

  static Stream<Arguments> cases() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{2, 1, 4, 3, 5}),
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, new int[]{3, 2, 1, 4, 5}),
        Arguments.of(new int[]{1, 2}, 3, new int[]{1, 2}),
        Arguments.of(new int[]{1, 2, 3, 4}, 1, new int[]{1, 2, 3, 4}),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{3, 2, 1, 6, 5, 4})
    );
  }

  private static Solution.ListNode toList(int[] values) {
    Solution.ListNode dummy = new Solution.ListNode(0);
    Solution.ListNode current = dummy;

    for (int value : values) {
      current.next = new Solution.ListNode(value);
      current = current.next;
    }

    return dummy.next;
  }

  private static int[] toArray(Solution.ListNode head) {
    List<Integer> values = new ArrayList<>();
    Solution.ListNode current = head;

    while (current != null) {
      values.add(current.val);
      current = current.next;
    }

    return values.stream().mapToInt(Integer::intValue).toArray();
  }
}

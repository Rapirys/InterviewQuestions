package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  public int rob(int[] nums) {
    int prevTwo = 0;
    int prevOne = 0;

    for (int num : nums) {
      int current = Math.max(prevOne, prevTwo + num);
      prevTwo = prevOne;
      prevOne = current;
    }

    return prevOne;
  }

  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<int[]> queue = new ArrayDeque<>();
    int fresh = 0;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 2) {
          queue.offer(new int[]{row, col});
        } else if (grid[row][col] == 1) {
          fresh++;
        }
      }
    }

    if (fresh == 0) {
      return 0;
    }

    int minutes = 0;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    while (!queue.isEmpty() && fresh > 0) {
      int size = queue.size();
      minutes++;

      for (int i = 0; i < size; i++) {
        int[] cell = queue.poll();
        int row = cell[0];
        int col = cell[1];

        for (int[] direction : directions) {
          int nextRow = row + direction[0];
          int nextCol = col + direction[1];

          if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
            continue;
          }

          if (grid[nextRow][nextCol] != 1) {
            continue;
          }

          grid[nextRow][nextCol] = 2;
          fresh--;
          queue.offer(new int[]{nextRow, nextCol});
        }
      }
    }

    return fresh == 0 ? minutes : -1;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode groupPrev = dummy;

    while (true) {
      ListNode kth = getKthNode(groupPrev, k);
      if (kth == null) {
        break;
      }

      ListNode groupNext = kth.next;
      ListNode prev = groupNext;
      ListNode current = groupPrev.next;

      while (current != groupNext) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }

      ListNode oldGroupStart = groupPrev.next;
      groupPrev.next = kth;
      groupPrev = oldGroupStart;
    }

    return dummy.next;
  }

  private ListNode getKthNode(ListNode start, int k) {
    ListNode current = start;
    for (int i = 0; i < k; i++) {
      current = current.next;
      if (current == null) {
        return null;
      }
    }
    return current;
  }

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}

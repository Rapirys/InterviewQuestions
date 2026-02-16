## Option 1: Dynamic Programming — House Robber

### Task
You are a freelance developer planning your work schedule for a sequence of upcoming days. You have
a list of potential daily contracts, represented by an integer array `nums`, where `nums[i]`
represents the payment offered for a project on day `i`.

However, you have a strict personal rule to maintain your health: **to prevent burnout, you cannot
work two consecutive days.**

Given the array of potential daily payments, return the **maximum amount of money** you can earn
without breaking your anti-burnout rule.

### Examples

#### Example 1

**Input:** `nums = [1, 2, 3, 1]`
**Output:** `4`

#### Example 2

**Input:** `nums = [2, 7, 9, 3, 1]`
**Output:** `12`

### Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`

---

## Option 2: Grid BFS — Rotting Oranges (multi-source BFS)

### Task
In a 2D grid with `0 = empty`, `1 = fresh`, `2 = rotten`, each minute rotten oranges spread to
4-directional neighbors. Return the number of minutes needed to rot all fresh oranges, or `-1` if
it is impossible.

### Why it’s good
Clean BFS with a queue, level-by-level processing, and multi-source starting points.

### Follow-ups

- Add diagonals or obstacles.
- Return coordinates of the last rotted cells.
- Discuss memory optimization and large-grid considerations.

---

## Option 3: Linked list manipulation — Reverse nodes in k-group

### Task
Given a singly linked list, reverse nodes in groups of size `k`. If the remaining nodes are fewer
than `k`, leave them as-is.

### Why it’s good
Builds pointer discipline, careful boundary handling, and in-place manipulation with `O(1)` extra
space.

### Follow-ups

- Compare recursive vs iterative approaches.
- Detect cycles and refuse processing.
- Discuss performance and readability tradeoffs.

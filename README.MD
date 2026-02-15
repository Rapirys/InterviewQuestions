## Problem Statement

You are a freelance developer planning your work schedule for a sequence of upcoming days. You have
a list of potential daily contracts, represented by an integer array `nums`, where `nums[i]`
represents the payment offered for a project on day `i`.

However, you have a strict personal rule to maintain your health: **to prevent burnout, you cannot
work two consecutive days.**

Given the array of potential daily payments, return the **maximum amount of money** you can earn
without breaking your anti-burnout rule.

## Examples

### Example 1

**Input:** `nums = [1, 2, 3, 1]`
**Output:** `4`
**Explanation:**

- Take the contract on Day 1 (pay = 1).
- Skip Day 2 to rest.
- Take the contract on Day 3 (pay = 3).
- Skip Day 4.
- **Total earnings:** 1 + 3 = 4.

### Example 2

**Input:** `nums = [2, 7, 9, 3, 1]`
**Output:** `12`
**Explanation:**

- Take contract on Day 1 (pay = 2).
- Skip Day 2.
- Take contract on Day 3 (pay = 9).
- Skip Day 4.
- Take contract on Day 5 (pay = 1).
- **Total earnings:** 2 + 9 + 1 = 12.

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`
## Problem Statement

You are a DevOps engineer tasked with configuring a custom server cluster for a client. You have a list of available instance types, represented by an array `instance_costs`, where each integer represents the hourly cost of a specific server type.

The client has a strict hourly budget, represented by the integer `budget`. Your task is to find **all possible unique cluster configurations** where the total hourly cost equals the `budget` exactly.

**Rules:**
1. You can provision **as many instances of the same type** as you need (unlimited usage).
2. The order of instances in a configuration does not matter.
3. Two configurations are considered different only if the quantity of at least one instance type chosen is different.

Return a list of all valid configurations.

## Examples

### Example 1

**Input:** `instance_costs = [2, 3, 6, 7]`, `budget = 7`
**Output:** `[[2, 2, 3], [7]]`
**Explanation:**
You can achieve a total cost of 7 using these two configurations:
1. Two instances costing 2 and one instance costing 3 ($2 + 2 + 3 = 7$).
2. One instance costing 7 ($7 = 7$).

### Example 2

**Input:** `instance_costs = [2, 3, 5]`, `budget = 8`
**Output:** `[[2, 2, 2, 2], [2, 3, 3], [3, 5]]`
**Explanation:**
The available configurations to hit the budget of 8 are:
- Four instances of cost 2.
- One instance of cost 2 and two instances of cost 3.
- One instance of cost 3 and one instance of cost 5.

### Example 3

**Input:** `instance_costs = [2]`, `budget = 1`
**Output:** `[]`
**Explanation:**
The minimum cost is 2, so it is impossible to satisfy a budget of 1.

## Constraints

- `1 <= instance_costs.length <= 30`
- `2 <= instance_costs[i] <= 40`
- All elements of `instance_costs` are **distinct**.
- `1 <= budget <= 40`
- The output is guaranteed to have fewer than 150 unique combinations.
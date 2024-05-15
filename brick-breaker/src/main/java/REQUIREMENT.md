### Problem Description

You are given a grid where:
- `w` represents a wall
- `g` represents ground
- `o` represents the ball
- Numbers represent bricks

**Input Details:**
1. Grid Size: 7x7
2. Number of Bricks: 6
3. Brick Positions: (2, 2), (2, 3), (2, 4), (3, 2), (3, 3), (3, 4)
4. Initial Ball Position: (6, 3) with 5 lives

The grid initially looks like this:
```
w w w w w w w
w           w
w  1  1  1  w
w  1  1  1  w
w           w
w           w
w g g o g g w
```

**Commands:**
1. **`st` (straight)**: The ball moves straight up.
    - If there is a brick (`1`) in the path, the ball hits the brick, and the brick disappears. The ball returns to its original position.
    - If there is no brick in the path, the ball hits the wall and comes back to its original position.

2. **`lt` (left)**: The ball moves diagonally to the upper left.
    - If there is a brick in the path, the ball hits the brick, the brick disappears, and the ball falls vertically down.
    - If there is no brick in the path, the ball hits the wall, reflects horizontally, and continues moving. If it encounters a brick in this path, it hits the brick, the brick disappears, and the ball falls vertically down.
    - If there is no brick in the path, the ball hits the wall, reflects horizontally, and continues moving. If the ball hits the wall for the second time without hitting a brick, the ball will fall to the ground 90 degrees downward vertically.
    - Whenever the ball lands on a different position from the starting point, one ball life is reduced, and the new position becomes the starting point for the next ball.

3. **`rt` (right)**: The ball moves diagonally to the upper right.
    - Similar to `lt`, but moves to the upper right.

**Example Execution:**

1. **Command: `st`**
    - Grid before:
      ```
      w w w w w w w
      w           w
      w  1  1  1  w
      w  1  1  1  w
      w           w
      w           w
      w g g o g g w
      ```
    - Grid after:
      ```
      w w w w w w w
      w           w
      w  1  1  1  w
      w  1  1  1  w
      w           w
      w           w
      w g g o g g w
      ```
    - Ball count: 5

   The ball moves straight up, hits the brick at (2, 3), and returns to its original position. The brick at (2, 3) disappears.

2. **Command: `lt`**
    - Grid before:
      ```
      w w w w w w w
      w           w
      w  1  1  1  w
      w  1  1  1  w
      w           w
      w           w
      w g g o g g w
      ```
    - Grid after:
      ```
      w w w w w w w
      w           w
      w  1  1  1  w
      w  1  1     w
      w           w
      w           w
      w g o g g g w
      ```
    - Ball count: 4

   The ball moves diagonally left, hits the wall, reflects horizontally, hits the brick at (3, 2), and then continues downward. The brick at (3, 2) disappears, and the ball lands at (6, 2). Since the ball lands on a different position, one ball life is reduced, and (6, 2) becomes the new starting position.

**Additional Module Details:**
In the second module, each brick has a value that decreases with each hit and disappears only when it reaches zero.

There are a total of 7 modules in the problem set, each introducing new mechanics or rules.
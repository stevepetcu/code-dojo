# The Diamond Kata

## Problem description
**Given**: an alphabet &Lambda;, beginning with a character &alpha;;

**Given**: an arbitrary character &tau;, belonging to the alphabet;

**Requirements**: print a diamond starting with the character &alpha;, having the character &tau; at its widest point and having a palindromic shape over both of its (X and Y) axes.

## Example
Given:
- &Lambda; = A, B, C, D, E, F, G, H, I, J
- &tau; = D

Expected result:
```
   A
  B B
 C   C
D     D
 C   C
  B B
   A
```

## Tips
<details>
<summary>Tip #1: Visualising the diamond</summary>

### Replacing space with something else gives us a better visualisation of the diamond:
```
---A
--B-B
-C---C
D-----D
-C---C
--B-B
---A
```
</details>

<details>
<summary>Tip #2: Properties of the diamond</summary>

### Think about how the diamond's properties
- what are its height and width?
- what's the relation between a character's first position in a row, and its last position, as we build the diamond?
- what's a simple way of dealing with the diamond's tips - which contain only 1 character (hard-coding excluded)?
</details>

<details>
<summary>Tip #3: Building the diamond</summary>

### Building the diamond
Try to build the first "half" of the diamond (down to the &tau; character). Building the second "half" should be easy - it's (almost) a mirror of the first.
</details>
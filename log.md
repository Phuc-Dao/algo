### jun 6
#### 1. Relative sort Array
* Tried to forcefully use a technique from another algorithm, resulted in an overly-complicated technique for an easy problem 
    * solution: overly-scrutinize every solution that you come up with to make sure it works
    * solution: Sometimes you might come up with a different approach to a similar problem, its ok just accept that and roll with it  
* Tried to prematurely optimize for space
    * solution: Come up with unoptimal space/time first
* Went down a rabbithole of the wrong technique, next time try to go breadth first
    * solution: At first don't sweat the details, think high-level first 

### jun 7
#### (2) Number of dice rolls with target sum 
* Got this pretty good, but need to work on debugging dynamic programming questions
* Test components as you go instread of waiting til lthe end to test everything. This will actually make you faster !

### jun 16
#### (3) 1176. Diet Plan Performance
* What I did wrong
    - Handwaved solution and in the end wasted alot of time implementing the wrong solution 
    - Tried to use a prefix sum solution even though it used fixed sliding window
* Key takeway:
    - Don't handwave your solution, really try to scrutinize it

### jun 17
#### (4) overlap rectangle
* What I did wrong
    - Tried coming up with an overly complex soluton
    - Did not utilize the fact that they only gave two corners of the rectangle (this was used to determine where the triangle began and end)
    - Got lost in all the edge cases
* Key Takeaway:
    - Problems with multiple cases try to draw all the cases quickly
    - Utilize unique properties of the problem to come up with a solution 

### jun 18
#### (5) two sum bst
* What I did wrong
    - Did traversal twice 
* Key Takeaway:
#### (6) Leaf similar Trees
#### (7) Reverse and invert image 

### jun 26
#### (6) 88 merge sorted array
* The crux of the problem was to recognize that you can insert at the end to preserve
the ordering when you shift elements around
* Key Takeaway:
    - sometimes try inserting elements at the end of a list
    
#### Python
* Use collections.Counter() to count things
* Sorted works on dictionaries to sort the keys
* Slices create a shallow copy, and is noninclusive on the right side

#### Sliding window
* Understand when to use prefix sums and when to use regular sliding window (Tried to use prefix sum with problem 1176 which is wrong)

#### Dynamic programming
* It helps to write out every possible state when you are not sure what the recurrance relation is
* It helps to think of it in terms of the last step (burst balloons)

#### Tricky problems (When you are absolutely stuck)
* Look at every possible constraint/properties
* Draw out the edge cases

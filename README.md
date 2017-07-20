# Kotlin Algorithm
An algorithm is a step-by-step procedure to solve a problem.

- [How to Run Kotlin Program](#how-to-kotlin-program)
- [Big-Oh Notation](#big-oh-notation)
- [Iterative Algorithms](#iterative-algorithms)
- [Divide-and-Conquer Algorithms](#divide-and-conquer-algorithms)
- [Greedy Algorithms](#greedy-algorithms)
- [Dynamic Algorithms](#dynamic-algorithms)
- [Back-Tracking Algorithms](#back-tracking-algorithms)

### How to Run Kotlin Program 
Produce a runnable JAR assembly

    $ cd bubble-sort 
    $ kotlinc src/BubbleSort.kt -include-runtime -d BubbleSort.jar
    $ java -jar BubbleSort.jar

### Big-Oh Notation
The worst case time complexity of an algorithm is *O(f(N))* which means its running time varies in proportion to a growth-rate function *f(N)*.

##### Performance from good to bad
*O(Log N)*, *O(N)*, *O(N log N)*, *O(N^2)*, *O(N^3)*, *O(2^N)*  
*N*: size of a problem  

### Iterative Algorithms 
Certain steps are repeated in loops

- [Bubble Sort](https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm): Compare adjacent elements to bubble up the largest one to the sorted list
- [Insertion Sort](https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm): Insert an element into the sorted list
- [Selection Sort](https://www.tutorialspoint.com/data_structures_algorithms/selection_sort_algorithm.htm): Select the smallest element and put it in the sorted list

### Divide-and-Conquer Algorithms 
The problem is divided into smaller sub-problems which are solved independently.  
Three-step process: Divide/Break > Conquer/Solve > Merge/Combine 

- [Merge Sort](https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm)
- [Quick Sort](https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm)
- Binary Search

### Greedy Algorithms 
An immediately available best solution at each step is chosen.

- Travelling Salesman Problem
- Scheduling Problem
- Graph Problem

### Dynamic Algorithms 
The problem is divided into smaller overlapping sub-problems which are solved by remembering and using previous solved result .  

- Fibonacci Number
- Knapsack Problem
- Tower of Hanoi

### Back-Tracking Algorithms 
All possible solutions are explored and the steps are traced back.

- Depth First Search
- Breadth First Search


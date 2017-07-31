# Kotlin Algorithm
An algorithm is a step-by-step procedure to solve a problem.

- [How to Run Kotlin Program](#how-to-kotlin-program)
- [Big-Oh Notation](#big-oh-notation)
- [Iterative Algorithms](#iterative-algorithms)
- [Divide-and-Conquer Algorithms](#divide-and-conquer-algorithms)
- [Back-Tracking Algorithms](#back-tracking-algorithms)
- [Greedy Algorithms](#greedy-algorithms)
- [Dynamic Algorithms](#dynamic-algorithms)
- [Data Structure](#data-structure)

### How to Run Kotlin Program 
Produce a runnable JAR assembly

    $ cd bubble-sort 
    $ kotlinc src/BubbleSort.kt -include-runtime -d BubbleSort.jar
    $ java -jar BubbleSort.jar

### Big-Oh Notation
- The worst case time complexity of an algorithm is *O(f(N))* which means its running time varies in proportion to a growth-rate function *f(N)*.  
- The worst case space complexity is the additional space the algorithm used, apart from the input data space.

##### Time performance from good to bad
*O(Log N)*, *O(N)*, *O(N log N)*, *O(N^2)*, *O(N^3)*, *O(2^N)*  
*N*: problem size

##### Algorithm complexity
| Algorithm            | Best Time Complexity | Worst Time Complexity | Average Time Complexity | Worst Space Complexity |
| :------------------: | :------------------: | :-------------------: | :---------------------: | :--------------------: |
| Bubble Sort          | *O(N)*               | *O(N^2)*              | *O(N^2)*                | *O(1)*                 |
| Insertion Sort       | *O(N)*               | *O(N^2)*              | *O(N^2)*                | *O(1)*                 |
| Selection Sort       | *O(N^2)*             | *O(N^2)*              | *O(N^2)*                | *O(1)*                 |
| Merge Sort           | *O(N log N)*         | *O(N log N)*          | *O(N log N)*            | *O(N)*                 |
| Quick Sort           | *O(N log N)*         | *O(N^2)*              | *O(N log N)*            | *O(log N)*             |
| Shell Sort           | *O(N)*               | *O(N^2)*              | *O(N^2)*                | *O(1)*                 |
| Binary Search        | *O(1)*               | *O(log N)*            | *O(log N)*              | *O(1)*                 |
| Depth First Search   | *O(b^m)*             | *O(b^m)*              | *O(b^m)*                | *O(bm)*                |
| Breadth First Search | *O(b^d)*             | *O(b^d)*              | *O(b^d)*                | *O(b^d)*               |

*b*: branching factor  
*m*: the maximum depth of the search tree  
*d*: the depth of the shallowest solution

### Iterative Algorithms 
Certain steps are repeated in loops

- [Bubble Sort](https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm): 
Compare adjacent elements to bubble up the largest one to the sorted list
- [Insertion Sort](https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm): 
Insert an element into the sorted list
- [Selection Sort](https://www.tutorialspoint.com/data_structures_algorithms/selection_sort_algorithm.htm): 
Select the smallest element and put it in the sorted list

### Divide-and-Conquer Algorithms 
The problem is divided into smaller sub-problems which are solved independently.  
Three-step process: Divide/Break > Conquer/Solve > Merge/Combine 

- [Merge Sort](https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm):
Divide an array into two equal sub-arrays and then combine them in a sorted manner
- [Quick Sort](https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm):
Partition an array into two sub-arrays, one has larger values and the other has smaller values as compared with the specified pivot
- [Shell Sort](https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm): 
Divide an array into smaller sub-arrays with equal interval and then sort them with insertion sort
- [Binary Search](https://www.tutorialspoint.com/data_structures_algorithms/binary_search_algorithm.htm):
Halve the searchable items by comparing middle one of an sorted array

### Back-Tracking Algorithms 
All possible solutions are explored and the steps are traced back.

- [Depth First Search](http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/):
Traverse a graph deeply and use a stack to get next vertex for new iterative search
- [Breadth First Search](http://www.geeksforgeeks.org/level-order-tree-traversal/):
Traverse a graph widely and use a queue to get next vertex for new iterative search

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

### Data Structure 
- Set: 
Store unordered and non-repeated values
- List: 
Can increase or decrease size
- Map: 
Store pairs of key and value, each pair maps an unique key to only one value
- [Array](https://www.tutorialspoint.com/data_structures_algorithms/array_data_structure.htm):
Fixed size with the same type
- [Stack](https://www.tutorialspoint.com/data_structures_algorithms/stack_algorithm.htm):
Allow operation at one end only, LIFO (Last In First Out)
- [Queue](https://www.tutorialspoint.com/data_structures_algorithms/dsa_queue.htm): 
Allow operation at both ends, one end is for insertion and the other is for deletion, FIFO (First In First Out)
- [Binary Search Tree](https://www.tutorialspoint.com/data_structures_algorithms/binary_search_tree.htm):
Each node has a maximum of two children, left sub-tree is less than and right sub-tree is greater than its parent

##### Data structure complexity
| Data Structure | Average Time Complexity - Access | Average Time Complexity - Search | Average Time Complexity - Insertion | Average Time Complexity - Deletion | Worst Space Complexity |  
| :------------: | :------------: | :------------: | :------------: | :------------: | :------------: |
| Array          | *O(1)*         | *O(N)*         | *O(N)*         | *O(N)*         | *O(N)*         |
| Stack          | *O(N)*         | *O(N)*         | *O(1)*         | *O(1)*         | *O(N)*         |
| Queue          | *O(N)*         | *O(N)*         | *O(1)*         | *O(1)*         | *O(N)*         |
| Binary Search Tree | *O(log N)* | *O(log N)*     | *O(log N)*     | *O(log N)*     | *O(N)*         |

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
| Counting Sort        |                      | *O(N + k)*            |                         |                        |
| Radix Sort           |                      | *O(N log B(N))*       |                         |                        |
| Bucket Sort          | *O(N)*               |                       |                         |                        |
| Shell Sort           | *O(N)*               | *O(N^2)*              | *O(N^2)*                | *O(1)*                 |
| | | | | |
| **Comparison Based** | |  |  |  |
| Merge Sort           | *O(N log N)*         | *O(N log N)*          | *O(N log N)*            | *O(N)*                 |
| Quick Sort           | *O(N log N)*         | *O(N^2)*              | *O(N log N)*            | *O(log N)*             |
| Heap Sort            | *O(N log N)*         | *O(N log N)*          | *O(N log N)*            | *O(1)*                 |
| | | | | |
| Binary Search        | *O(1)*               | *O(log N)*            | *O(log N)*              | *O(1)*                 |
| Depth First Search   | *O(b^m)*             | *O(b^m)*              | *O(b^m)*                | *O(bm)*                |
| Breadth First Search | *O(b^d)*             | *O(b^d)*              | *O(b^d)*                | *O(b^d)*               |

*b*: branching factor  
*m*: the maximum depth of the search tree    
*d*: the depth of the shallowest solution  
*B*: base to represent the numbers  
*k*: elements are in range from 1 to k

### Iterative Algorithms 
Certain steps are repeated in loops

- [Bubble Sort](https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm): 
Compare adjacent elements to bubble up the largest one to the sorted list
- [Insertion Sort](https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm): 
Insert an element into the sorted list
- [Selection Sort](https://www.tutorialspoint.com/data_structures_algorithms/selection_sort_algorithm.htm): 
Select the smallest element and put it in the sorted list
- [Heap Sort](https://www.geeksforgeeks.org/heap-sort/)
Improved selection sort, generate heap tree and then switch root and last node to have max heap
    - **Heap Tree** is complete binary tree, nodes need to have left and right node except leave nodes
    - **Max Heap**: parent node value is larger than child node value, root has the largest value
- [Counting Sort](https://www.geeksforgeeks.org/counting-sort/)
Use keys (element range size) as array indexes to count element and accumulate count by range order
- [Radix Sort](https://www.geeksforgeeks.org/radix-sort/)
Distribute element into digit buckets and output element by bucket and the original order
    - LSD (Least Significant Digit) for small digits
    - MSD (Most Significant Digit) for large digits
    - good for large element range from 1 to n^2
- [Bucket Sort](https://www.geeksforgeeks.org/bucket-sort-2/)
Distribute input into buckets, sort each bucket with insertion sort, and concatenate buckets
    - input is uniformly distributed over a range, like floating numbers
    - each bucket contains a list

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
    - Inorder: left, root, right
    - Preorder: root, left, right
    - Post: left, right, root
- [Breadth First Search](http://www.geeksforgeeks.org/level-order-tree-traversal/):
Traverse a graph widely and use a queue to get next vertex for new iterative search

### Greedy Algorithms 
An immediately available best solution at each step is chosen.

- Travelling Salesman Problem
- Scheduling Problem
- [Dijkstra's Shortest Path Algorithm](https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/)
    - find the shortest path from a single source vertex to all other vertices in the given graph
    - cannot have minus distance
    - *O(N^2)* 
- [A* Search Algorithm](https://www.geeksforgeeks.org/a-search-algorithm/)
    - better than Dijkstra
    - *f(n) = g(n) + h(n)* <br/>
      *f(n)*: current node score <br/>
      *g(n)*: distance from start to current node <br/>
      *h(n)*: heuristic estimated distance from current to target node <br/> 

### Dynamic Algorithms 
The problem is divided into smaller overlapping sub-problems which are solved by remembering and using previous solved result .  

- [Kadane's Algorithm](https://www.youtube.com/watch?v=86CQq3pKSUw)
    - find a contiguous subarray with the maximum sum
    - brute force solution is to check all possible subarrays, *O(N^2)*
    - find out the maximum subarray ending at each index and then get the maximum one
    - local maximum subarray is either current element or current element combined with previous maximum subarray
    - *O(N)*
- Fibonacci Number
- Knapsack Problem
- Tower of Hanoi

### Data Structure 

- [Array](https://www.tutorialspoint.com/data_structures_algorithms/array_data_structure.htm):
Hold a fix number of items with the same type

- [Binary Search Tree](https://www.tutorialspoint.com/data_structures_algorithms/binary_search_tree.htm):
Each node has a maximum of two children, left sub-tree is less than and right sub-tree is greater than its parent

- Map: 
Store pairs of key and value, each pair maps an unique key to only one value

- [Hash Map](https://www.linkedin.com/pulse/10-things-java-developer-should-know-hashmap-chinmay-parekh/):
To find out an element in a list, the lookup order is proportional to the list length. 
By splitting the list into multiple mini-lists and quickly telling which mini-list has the element, HashMap builds an array of mini-lists to greatly reduce the lookup order.
    - **collision** means 2 distinct keys generate the same hash code
    - **HashMap resizing** is time consuming, which will double the size and move chunk of data to new space
    
- Hash Table:
**Hash table** uses an array to store data with the unique generated index.
**Hash function** converts a key to an array index, 
which easily computes and uniformly distributes the keys.
    - Fast insertion or search

- [Heap](http://www.geeksforgeeks.org/binary-heap/):
Complete binary tree represented as array, min heap has parent value which is smaller than or equal to its child value
    - **min Heap** uses default priority queue
    - **max Heap** needs to override the compare method

- List:
Add/remove element and check if the list contains certain element

- Linked List:
A linked list is represented by a pointer to the first node called **head**.
Each node contains a **data** and a pointer to the **next** node. 
The last node is **null**.
    - Dynamic size
    - Easy to insert or delete node
    - No random access
    - Extra memory for pointer

- [Queue](https://www.tutorialspoint.com/data_structures_algorithms/dsa_queue.htm):
Allow operation at both ends, one end is for insertion and the other is for deletion, FIFO (First In First Out)

- Set:
Store unordered and non-repeated values

- [Stack](https://www.tutorialspoint.com/data_structures_algorithms/stack_algorithm.htm):
Allow operation at one end only, LIFO (Last In First Out)

- Tree:
The topmost node is called **root**. 
**Parent** and **children** nodes are directly above or under each other.
The node which has no children is called **leave**.
    - Hierarchical data

#### Hash Map vs Hash Table
|| HashMap | HashTable|
| :-----: | :-----: | :-----: |
| Synchronized | No | Yes |
| Thread Safe  | No | Yes |
| Key/Value | allow one null key and many null values | not allow any null key and value |
| Application Type | non-threading | multithreading |
| Iterator Type | Fail fast iterator | Fail safe iterator | 
| Performance | Fast | Slower | 

#### Complexity
| Data Structure | Average Time Complexity - Access | Average Time Complexity - Search | Average Time Complexity - Insertion | Average Time Complexity - Deletion | Worst Space Complexity |  
| :------------: | :------------: | :------------: | :------------: | :------------: | :------------: |
| Array          | *O(1)*         | *O(N)*         | *O(N)*         | *O(N)*         | *O(N)*         |
| Stack          | *O(N)*         | *O(N)*         | *O(1)*         | *O(1)*         | *O(N)*         |
| Queue          | *O(N)*         | *O(N)*         | *O(1)*         | *O(1)*         | *O(N)*         |
| Binary Search Tree | *O(log N)* | *O(log N)*     | *O(log N)*     | *O(log N)*     | *O(N)*         |
| Heap           | *O(1)*         | *O(log N)*     | *O(log N)*     | *O(log N)*     | *O(N)*         |
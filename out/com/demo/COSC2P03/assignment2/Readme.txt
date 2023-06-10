1. read from file

2. create freq node for each character - 2 Arrays (Label, freq)


3.
class Node
String label
int frequency
Node left
Node right

4. will iterate over array
   will create node for each label
   will push into min heap (Java PriorityQueue)

while minheap is empty 5 and 6
5. union of nodes
   pick 2 nodes from min heap  - a:1  b:2
   create union node of lables and freq - ab:3
   unionNode.left = a:1
   unionNode.right = b:2

6. push this Union Node into minHeap


Last Node === root node (Tree)


7.Travers through tree
  for each leaf node, print Codebook




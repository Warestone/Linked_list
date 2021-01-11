# Results of collections comparison

## ArrayList & LinkedList

 - add():
    + linkedlist better
    + linkedlist better
	
 - add(index) in 100000 elements:
    + head: linkedlist
    + tail: arraylist better
    + middle: arraylist better
	
 - remove() 1 element in 100000 elements:    
    + head: linkedlist better
    + tail: arraylist better
    + middle: arraylist better
    
	
## HashSet, LinkedHashSet & TreeSet

- add() 100000 elements:
    1. linkedHashSet
	2. hashSet
	3. treeSet
	
- remove() 1 element in 100000 elements:
	#### Results between positions are equal
	1. linkedHashSet
	2. hashSet
	3. treeSet
	
	
## HashMap, LinkedHashMap & TreeMap  

- add() 10000 elements:
    1. hashMap
	2. linkedHashMap
	3. treeMap
  
- remove() 1 element in 100000 elements:
	#### Results between positions are equal
	1. linkedHashMap
	2. hashMap
	3. treeMap

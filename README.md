# Genetic-Algorithms-next-gen-
A major part of a GA is to create the next population (generation) of chromosome or Genome. For example, if a GA has a population of say 100 Genome, then the next generation created from the current population will consist of 100 Genome, generated by way of inheritance, mutation, inversion, and crossover

- A package called GENE which supports the Genome type as an interface. 
- In essence, a Genome consists of a string of items defined by an alphabet defined as a separate interface. For example if a Genome is to represent “aabdgba” then the alphabet consists of the characters “abdg” only. 
- To hold the Genome I used a String, where the contents of the string must belong to the defined alphabet. Each Genome has a length (Cardinality) and usually all Genome in a given GA will be the same length

# Tree
Dynamic Tree

The 'Tree' package contains an implementation of a dynamic tree data structure in Java. At its core is the Node class, which represents a node within the tree. Each 'node' contains an identifier, parent ID, and data. The package provides functionality for creating, modifying, and navigating the tree. Nodes can be added to the tree, and their data can be printed. Additionally, the package includes methods for retrieving information about a node's children and parents. The tree can be printed in a hierarchical manner to visualize its structure. Overall, the 'Tree' package offers a comprehensive solution for working with dynamic trees, allowing for the management and traversal of tree data efficiently.
In order to add this 'Tree' package you have to type in the beginning of your java file "import Tree.Node" , then you can have access in this service .

                                                                 INIT  
                                                        +-------------------+
                                                        + ID = 0 PID = null +
                                                        + Nodes : rootA     +
                                                        + NodesID : 1       +
                                                        +-------------------+
                                                               +     +
                                                               +     +
                                                         rootA +     +
                                                        +-------------------+
                                                        + ID = 1 PID = 0    +
                                                        + Nodes : A,B,...   +
                                                        + NodesID : 2,3,... +
                                                        +-------------------+
                                                       +       +             + 
                                                      +        +              +
                                           A         +     B   +               +     K
                                       +------------+    +------------+         +------------+
                                       + ID=2 PID=1 +    + ID=3 PID=1 +  ....   + ID=X PID=1 +
                                       +     ...    +    +     ...    +         +     ...    +
                                       +------------+    +------------+         +------------+

NOTES : 
1) The 'INIT' is a node which is already exsist before the creation of the rootA . Futhermore , this node is constructed by the same the class before even you create the 'root' node.
2) ...

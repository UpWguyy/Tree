package Tree;
import java.util.ArrayList;

public class Node {
    private int id;
    private int pid;
    private String data;  //Data of current Node
    private static int Val = 1;
    private final Node Next; //Point to Father-Node
    private final ArrayList<Node> Parent; // A List of Nodes that pointing in to the kids-Node
    private final ArrayList<Integer> KidIdNode; // Every Node contains an ArrayList with the ids of every child it has0,
    private final static Node Init = new Node(); //God of roots
    private String Blanks = "\t"; // Printing Tabs in output in order to make clear all kinds of a dynamic tree

    //Constructors for Nodes
    public Node() {
        Next = null;
        Parent = new ArrayList<>();
        KidIdNode = new ArrayList<>();
        if(this == Init){
            id = 0;
            pid = 0;
        }
    }

    private Node(Node N) {
        this.Next = N;
        this.Parent = N.Parent;
        this.KidIdNode = N.KidIdNode;
    }

    public Node(String data) { // Use this Constructor if you want to create a new root
        this.Parent = new ArrayList<>();
        this.KidIdNode = new ArrayList<>();
        this.data = data;
        this.Next = Init;
        try {
            Init.Parent.add(this);
            this.pid = Init.id;
            this.id = Val;
            Init.KidIdNode.add(this.id);
            Val++;
        }catch (NullPointerException e){
            System.out.println("Null Pointer");
        }
    }

    private Node(String data, Node N) {
        this.data = data;
        this.Next = N;
        this.id = Val;
        this.pid = this.Next.id;
        Parent = new ArrayList<>();
        KidIdNode = new ArrayList<>();
        Val++;
    }

    private String GetData() {
        return this.data;
    }
    private int GetId(){ return this.id; }
    public Node GetNext() {
        return this.Next;
    }

    // Add a New Node in current tree
    public void AddNode(String Data) {
        try {
            Node NewN = new Node(Data, this);  // Create a new Node which points in its father
            this.KidIdNode.add(NewN.id);
            this.Parent.add(NewN); // Add a new Node in the List which pointing in the Kid-Nodes
        }catch (NullPointerException e){
            System.out.println("Null Pointer Exception");
        }
    }

    //Print Data of children of a Father-Node
    public void PrintData() {
        for (Node child : this.Parent) {
            System.out.println(child.data);
        }
    }

    // Print the dynamic tree
    public void PrintTree() {
        try {
            if(Init.Parent.isEmpty()) throw new NullPointerException("There is no root");
            Node head = new Node(this); //Create a temporarily Node
            head = head.Next; // Force to point to Main Node
            assert head != null; // We make an assumption about head Node
            System.out.println("|" + head.data + "|");
            if(!head.GetParent().isEmpty()) {
                for (int i = 0; i < head.Parent.size(); i++) { // Recursive loop for every Node in this Tree
                    System.out.print(head.Blanks);
                    head.GetKid(i).Blanks = head.GetKid(i).Blanks.concat(head.Blanks);
                    head.GetKid(i).PrintTree();
                }
            }
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public Node GetNode(){return this;}

    public Node GetKid(int i){return this.Parent.get(i);}
    private int GetNumKid(Node N){
        return this.Parent.indexOf(N);
    }
    private int GetNumKid(int Num){
        return this.KidIdNode.indexOf(Num);
    }

    public ArrayList<Node> GetParent(){ return this.Parent; }

    public void CutNode(Node Cut){
        try {
            Cut.Next.Parent.remove(Cut.Next.GetNumKid(Cut));
            System.out.println("Node has been deleted successfully");
        }catch (NullPointerException e){
            System.out.println("Null Pointer -- 2");
        }
    }
    public Node GetKidFromAnyNode(int... Num){
        Node NewN = new Node(this); boolean chk = false;
        try {
            NewN = NewN.Next;
            for (int N : Num) {
                assert NewN != null;
                if (!(N >= 0 && N < NewN.Parent.size())) throw new Exception("Allocated Node -- 1");
                NewN = NewN.GetKid(N);
                chk = true;
            }
            if(!chk){
                NewN = NewN.Next;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return NewN;
    }

    // A method which helps us measure the deep of this tree
    public int GetDeep() {
        Node N = new Node(this);
        N = N.Next;
        if (N == null) {
            return 0;
        } else {
            int maxChildDepth = 0;
            for (Node child : N.Parent) {
                int childDepth = child.GetDeep();
                if (childDepth > maxChildDepth) {
                    maxChildDepth = childDepth;
                }
            }
            return maxChildDepth + 1;
        }
    }
}
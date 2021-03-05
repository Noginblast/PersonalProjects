import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
  int key, data, height;
  Node left, right;

  Node(int key, int data) {
    this.key = key;
    this.data = data;
    height = 1;
  }
}

public class AVL {

  Node root;

  private int height(Node N) {
    if (N == null)
      return 0;

    return N.height;
  }

  private int max(int a, int b) {
    return (a > b) ? a : b;
  }

  private Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;

    // Return new root
    return x;
  }

  
  private Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
  }

  // Get Balance factor of node N
  int getBalance(Node N) {
    if (N == null)
      return 0;

    return height(N.left) - height(N.right);
  }

  private Node insert(Node node, int key, int data) {

    if (node == null)
      return (new Node(key, data));

    if (key < node.key)
      node.left = insert(node.left, key, data);
    else if (key > node.key)
      node.right = insert(node.right, key, data);
    else
      return node;


    node.height = 1 + max(height(node.left), height(node.right));

    
    int balance = getBalance(node);

    if (balance > 1 && key < node.left.key)
      return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > node.right.key)
      return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node.right.key) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }


  
  private void rangeMinFunc(Node node, int k1, int k2, List<Integer> minList) { 
      
    /* base case */
    if (node == null) { 
        return; 
    } 

    /* Since the desired o/p is sorted, recurse for left subtree first 
     If root->data is greater than k1, then only we can get o/p keys 
     in left subtree */
    if (k1 < node.key) { 
    	rangeMinFunc(node.left, k1, k2, minList); 
    } 

    /* if root's data lies in range, then prints root's data */
    if (k1 <= node.key && k2 >= node.key) { 
        minList.add(node.data); 
    } 

    /* If root->data is smaller than k2, then only we  
     can get o/p keys in right subtree */
    if (k2 > node.key) { 
    	rangeMinFunc(node.right, k1, k2, minList); 
    } 
}
  
  private void rangeMinimum(Node node, int k1, int k2) {
	  
	  List<Integer> minValue = new ArrayList<>();
	  rangeMinFunc(node, k1, k2, minValue);
	  
	  int min = minValue.get(0);
	  
	  
	  for(int i = 1; i < minValue.size(); i++) {
		  if(min >= minValue.get(i)) {
			  min = minValue.get(i);
		  }
	  }
	  
	  System.out.println(min);
  }
  
  
  public static void main(String[] args) throws FileNotFoundException {
    AVL tree = new AVL();

    int rangeMin = Integer.MAX_VALUE;
    int instructNum = 0;
    
    // Creating file and scanner objects
    File input = new File(args[0]);
    Scanner file = new Scanner(input);

    // Vetting File object for instruction length
    if (file.hasNextLine()) {
      instructNum = Integer.parseInt(file.nextLine());
    }

    // Reading and executing file commands
    while (instructNum >= 1 && file.hasNextLine()) {
      String[] line = file.nextLine().split(" ");

      if (line[0].equals("IN")) {
        tree.root = tree.insert(tree.root, Integer.parseInt(line[1]), Integer.parseInt(line[2]));
      }
      if (line[0].equals("RM")){
        tree.rangeMinimum(tree.root, Integer.parseInt(line[1]), Integer.parseInt(line[2]));
      }
      instructNum--;
    }

  }
}


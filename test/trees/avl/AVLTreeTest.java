package trees.avl;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {
	
	AVLTree<Integer, Integer> tree;
	
	@Before public void setUp(){
		tree = new AVLTree<>();
	}
	
	@Test
	public void insert() {
		
		int[] arr = {5,2,7,1,3,4,0};
		
		for(int a : arr){
			tree.insert(a, a);
		}
		
		assertTrue(tree.isBST(tree.root));
		assertTrue(tree.isBalanced(tree.root));
		
	}
	
	@Test
	public void massInsert(){
		Random rnd = new Random();
		
		int N = 20;
		
		for(int i = 0; i < N; i++)
			tree.insert( rnd.nextInt(N), 1);
		
		assertTrue(tree.isBST(tree.root));
		if (tree.isBalanced(tree.root) == false){
		    tree.print();
		    
		    System.out.println(tree.height(tree.root));
		    System.out.println(tree.height(tree.root.left));
		    System.out.println(tree.height(tree.root.right));
		}
				
	}
	
	@Test
	public void delete() {
		
		int[] arr = {5,2,7,1};
		
		for(int a : arr){
			tree.delete(a);
		}
		
		assertTrue(tree.isBST(tree.root));
		assertTrue(tree.isBalanced(tree.root));
		
	}

}

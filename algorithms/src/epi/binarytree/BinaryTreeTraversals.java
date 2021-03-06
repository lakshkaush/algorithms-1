package epi.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversals {

	public static List<BinaryTreeNode<Integer>> getPreOrderTraversal(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
		getPreOrderTraversalInner(root, list);
		return list;
	}

	private static void getPreOrderTraversalInner(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> list) {
		if (root == null)
			return;
		list.add(root);
		getPreOrderTraversalInner(root.getLeft(), list);
		getPreOrderTraversalInner(root.getRight(), list);
	}

	public static List<BinaryTreeNode<Integer>> getInOrderTraversal(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
		getInOrderTraversalInner(root, list);
		return list;
	}

	private static void getInOrderTraversalInner(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> list) {
		if (root == null)
			return;
		getInOrderTraversalInner(root.getLeft(), list);
		list.add(root);
		getInOrderTraversalInner(root.getRight(), list);
	}

	public static List<BinaryTreeNode<Integer>> getPostOrderTraversal(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
		getPostOrderTraversalInner(root, list);
		return list;
	}

	private static void getPostOrderTraversalInner(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> list) {
		if (root == null)
			return;
		getPostOrderTraversalInner(root.getLeft(), list);
		getPostOrderTraversalInner(root.getRight(), list);
		list.add(root);
	}

	public static List<BinaryTreeNode<Integer>> getLevelOrderTraversal(BinaryTreeNode<Integer> root) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			list.add(node);
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return list;
	}

	public static List<BinaryTreeNode<Integer>> getLevelOrderTraversal(BinaryTreeNode<Integer> root, int level) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		return levelOrderHelper(queue, 0, level);
	}

	private static List<BinaryTreeNode<Integer>> levelOrderHelper(Queue<BinaryTreeNode<Integer>> queue,
			int currentLevel, int desiredLevel) {
		if (currentLevel == desiredLevel) {
			List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
			list.addAll(queue);
			return list;
		} else {
			Queue<BinaryTreeNode<Integer>> newQueue = new LinkedList<BinaryTreeNode<Integer>>();
			while (!queue.isEmpty()) {
				BinaryTreeNode<Integer> node = queue.poll();
				if (node.getLeft() != null)
					newQueue.add(node.getLeft());
				if (node.getRight() != null)
					newQueue.add(node.getRight());
			}
			return levelOrderHelper(newQueue, currentLevel + 1, desiredLevel);
		}
	}

	public static List<BinaryTreeNode<Integer>> getNodeAtLevelByDepthFirstTraversal(BinaryTreeNode<Integer> root,
			int level) {
		List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
		depthFirstTraversal(root, list, 0, level);
		return list;
	}

	private static void depthFirstTraversal(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> list,
			int currentLevel, int desiredLevel) {
		if (currentLevel == desiredLevel) {
			list.add(node);
			return;
		} else {
			if (node.getLeft() != null)
				depthFirstTraversal(node.getLeft(), list, currentLevel + 1, desiredLevel);
			if (node.getRight() != null)
				depthFirstTraversal(node.getRight(), list, currentLevel + 1, desiredLevel);
		}
	}
}

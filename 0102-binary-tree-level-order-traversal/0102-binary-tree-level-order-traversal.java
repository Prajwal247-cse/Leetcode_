class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Final answer
        List<List<Integer>> result = new ArrayList<>();

        // Empty tree
        if (root == null)
            return result;

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // Start from root
        queue.offer(root);

        // Traverse level by level
        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int size = queue.size();

            // Store one level
            List<Integer> level = new ArrayList<>();

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                level.add(current.val);

                // Add left child
                if (current.left != null)
                    queue.offer(current.left);

                // Add right child
                if (current.right != null)
                    queue.offer(current.right);
            }

            // Store current level
            result.add(level);
        }

        return result;
    }
}
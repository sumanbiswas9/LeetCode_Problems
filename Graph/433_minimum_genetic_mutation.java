// ============================================================
// Problem    : 433. Minimum Genetic Mutation
// Difficulty : Medium
// URL        : https://leetcode.com/problems/minimum-genetic-mutation/
// Language   : Java
// Date       : 2026-05-28
// ============================================================
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int mutationSteps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutationSteps;
                }
                for (String candidateGene : bank) {
                    int allowedDifferences = 2;
                    for (int j = 0; j < 8 && allowedDifferences > 0; j++) {
                        if (currentGene.charAt(j) != candidateGene.charAt(j)) {
                            allowedDifferences--;
                        }
                    }
                    if (allowedDifferences > 0 && !visited.contains(candidateGene)) {
                        queue.offer(candidateGene);
                        visited.add(candidateGene);
                    }
                }
            }
            mutationSteps++;
        }
        return -1;
    }
}
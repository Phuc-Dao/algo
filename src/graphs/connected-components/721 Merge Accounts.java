class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>(); // <email node, neighbor nodes>
        Map<String, String> name = new HashMap<>(); // <email, username>
        // Build the graph;
        // Tricky Part!
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                System.out.println("adding "+ account.get(i));
                graph.putIfAbsent(account.get(i), new HashSet<>());
                name.put(account.get(i), userName); // eaz

                // Skip i -1 is the name which we want to ignore
                if (i == 1)
                    continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        //Perform bfs on each of the connected components
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        // Iterate through list of emails
        for (String email : name.keySet()) {
            if (!visited.contains(email)) {
                List<String> list = new ArrayList<>();
                list.add(name.get(email));
                q.add(email);
                while (!q.isEmpty()) {
                    String next = q.remove();
                    if (!visited.contains(next)) {
                        list.add(next);
                    }
                    visited.add(next);
                    // Iterate throguh the neighbors
                    for (String s : graph.get(next)) {
                        if (!visited.contains(s)) {
                            q.add(s);
                        }
                    }
                }
                Collections.sort(list);
                res.add(list);
            }
        }
        return res;
    }
}
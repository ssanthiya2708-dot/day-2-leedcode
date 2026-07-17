import java.util.*;

class ThroneInheritance {

    // Store the king's name
    private String king;

    // Store parent -> list of children
    private Map<String, List<String>> family;

    // Store dead people
    private Set<String> dead;

    // Constructor
    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }

    // Birth of a child
    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName, new ArrayList<>());
        family.get(parentName).add(childName);
    }

    // Mark a person as dead
    public void death(String name) {
        dead.add(name);
    }

    // Return inheritance order
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    // DFS (Preorder Traversal)
    private void dfs(String person, List<String> order) {

        // Add person if alive
        if (!dead.contains(person)) {
            order.add(person);
        }

        // Visit all children
        if (family.containsKey(person)) {
            for (String child : family.get(person)) {
                dfs(child, order);
            }
        }
    }
}

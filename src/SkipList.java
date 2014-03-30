
// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:39:15 PM 

public class SkipList {

    class Node {
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private Node[] levels = new Node[32];
}

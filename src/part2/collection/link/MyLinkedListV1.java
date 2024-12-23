package part2.collection.link;

public class MyLinkedListV1 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node node = new Node(e);

        // 첫번째 노드가 null 이라면
        // 새로 생성한 노드를 첫번째 노드로 함
        if (first == null) {
            first = node;
        }else{
            // 아니라면, 노드 마지막 뒤에 추가 한다.
            Node lastNode = getLast();
            lastNode.next = node;
        }
        // 추가했으니 사이즈 증가
        ++size;
    }

    private Node getLast() {
        Node x = first;
        // 노드의 다음 노드가 != null 이면
        // 즉 다음 노드가 존재한다면 반복
        // 존재하지 않으면 null 이므로, 마지막 노드임
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }


    public Object set(int index, Object element) {
        // index 에 해당하는 node 를 가져온다.
        Node x = getNode(index);
        // return 하기 위해 old Node
        Object oldValue = x.item;
        // 현재 노드를 새로 들어온 object 로 변경
        x.item = element;
        return oldValue;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = first;
        // index 까지 반복하여, 해당 node 리턴
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o) {
        int index = 0;
        // 첫번째 노드부터
        // 다음 노드가 != null 이라면 (즉 다음 노드가 존재한다면)
        // 다음노드로 이동
        for (Node x = first; x != null; x = x.next) {
            // 찾으려는 값이 다음 노드와 같다면 리턴
            if (o.equals(x.item)) {
                return index;
            }
            // 아니라면 다음 노드를 조회해야 하므로 인덱스 증가
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
            "first=" + first +
            ", size=" + size +
            '}';
    }
}

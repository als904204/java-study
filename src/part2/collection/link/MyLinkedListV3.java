package part2.collection.link;

public class MyLinkedListV3<E> {

    private Node<E> first;
    private int size = 0;

    public void add(E e) {
        Node<E> node = new Node<E>(e);

        // 첫번째 노드가 null 이라면
        // 새로 생성한 노드를 첫번째 노드로 함
        if (first == null) {
            first = node;
        }else{
            // 아니라면, 노드 마지막 뒤에 추가 한다.
            Node<E> lastNode = getLast();
            lastNode.next = node;
        }
        // 추가했으니 사이즈 증가
        ++size;
    }

    private Node<E> getLast() {
        Node<E> x = first;
        // 노드의 다음 노드가 != null 이면
        // 즉 다음 노드가 존재한다면 반복
        // 존재하지 않으면 null 이므로, 마지막 노드임
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public void add(int index, E e) {
        Node<E> newNode = new Node<E>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        }else{
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;
        if (index == 0) {
            first = removeNode.next;
        }else{
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removedItem;
    }

    public E set(int index, E element) {
        // index 에 해당하는 node 를 가져온다.
        Node<E> x = getNode(index);
        // return 하기 위해 old Node
        E oldValue = x.item;
        // 현재 노드를 새로 들어온 object 로 변경
        x.item = element;
        return oldValue;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        // index 까지 반복하여, 해당 node 리턴
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(E o) {
        int index = 0;
        // 첫번째 노드부터
        // 다음 노드가 != null 이라면 (즉 다음 노드가 존재한다면)
        // 다음노드로 이동
        for (Node<E> x = first; x != null; x = x.next) {
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
        return "MyLinkedListV2{" +
            "first=" + first +
            ", size=" + size +
            '}';
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }


        // [A->B->C]
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> x = this;

            sb.append("[");
            while (x != null) {
                sb.append(x.item);
                if (x.next != null) {
                    sb.append("->");
                }
                x = x.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}

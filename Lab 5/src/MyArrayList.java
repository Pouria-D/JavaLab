//import javax.lang.model.util.ElementScanner14;

class MyArrayList<E> {
    Node<E> head;

    MyArrayList() {
        head = null;
    }

    MyArrayList(int initSize) {
        if (initSize == 0) {
            head = null;
            return;
        }
        head = new Node<E>();
        Node<E> cur = head;
        while (--initSize > 0) {
            Node<E> tmp = new Node<E>();
            cur.next = tmp;
            tmp.pre = cur;
            cur = tmp;
        }
    }

    boolean isEmpty() {
        return size() == 0;
    }

    void add(E element) {
        if (head == null) {
            head = new Node<E>();
            head.value = element;
        }
        else {
            Node<E> cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = new Node<E>();
            cur.next.value = element;
            cur.next.pre = cur;
        }
    }

    void addBefore(int index, E element) {
        if (0 <= index  &&  index < size()) {
            Node<E> cur = head;
            while (index-- > 0)
                cur = cur.next;
            Node<E> tmp = new Node<E>();
            if (cur.pre != null)
                cur.pre.next = tmp;
            else
                head = tmp;
            tmp.value = element;
            tmp.pre = cur.pre;
            tmp.next = cur;
            cur.pre = tmp;
        }
        else
            System.out.println("Wrong index!");
    }

    E get(int index) {
        if (index < 0  ||  size() <= index) {
            System.out.println("There's no such index!");
            return null;
        }
        else {
            Node<E> cur = head;
            while (index-- > 0)
                cur = cur.next;
            return cur.value;
        }
    }

    MyArrayList<Integer> indexOf(E element) {
        MyArrayList<Integer> res = new MyArrayList<Integer>();
        for (int i = 0; i < size(); i++)
            if (element.equals(get(i)))
                res.add(i);
        return res;
    }

    void set(int index, E element) {
        if (index < 0  ||  size() <= index)
            System.out.println("There's no such index!");
        Node<E> cur = head;
        while (index-- > 0)
            cur = cur.next;
        cur.value = element;
    }

    boolean contains(E element) {
        return indexOf(element).size() > 0;
    }

    void clear() {
        head = null;
    }

    void remove(int index) {
        if (index < 0  ||  size() <= index) {
            System.out.println("Wrong index!");
            return;
        }
        Node<E> cur = head;
        while (index-- > 0)
            cur = cur.next;
        if (cur.pre == null)
            head = cur.next;
        else
            cur.pre.next = cur.next;
        if (cur.next != null)
            cur.next.pre = cur.pre;
    }

    int size() {
        int res = 0;
        Node<E> cur = head;
        while (cur != null) {
            res++;
            cur = cur.next;
        }
        return res;
    }

    void print() {
        System.out.print("{");
        for (int i = 0; i + 1 < size(); i++)
            System.out.print(get(i) + ", ");
        if (size() > 0)
            System.out.print(get(size() - 1));
        System.out.println("}");
    }
}
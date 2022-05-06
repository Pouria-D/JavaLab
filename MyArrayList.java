import javax.lang.model.util.ElementScanner14;

class MyArrayList<E> {
    Node<E> head;
    int size;

    MyArrayList() {
        head = null;
        size = 0;
    }

    MyArrayList(int initSize) {
        if (initSize == 0) {
            head = null;
            size = 0;
            return;
        }
        head = new Node<E> ();
        Node<E> cur = head;
        for (int i = 1; i < initSize; i++)
        {
            Node<E> tmp = new Node<E> ();
            cur.next = tmp;
            tmp.pre = cur;
            cur = tmp;
        }
        size = initSize;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void add(E element) {
        MyArrayList<E> arr = new MyArrayList<E> (size + 1);
        Node<E> cur1 = this.head;
        Node<E> cur2 = arr.head;
        for (int i = 0; i < size; i++) {
            cur2.value = cur1.value;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2.value = element;
        this.head = arr.head;
        this.size = arr.size;
    }

    void add(int index, E element) {
        if (0 <= index  &&  index < size) {
            Node<E> cur = head;
            for (int i = 0; i < index; i++)
                cur = cur.next;
            Node<E> tmp = new Node<E> ();
            tmp.value = element;
            if (cur.pre != null)
                cur.pre.next = tmp;
            else
                head = tmp;
            tmp.pre = cur.pre;
            tmp.next = cur;
            cur.pre = tmp;
            size++;
        }
        else
            System.out.println("Wrong index!");
    }

    void remove(E element) {
        Node<E> cur = head;
        while (cur != null) {
            if (cur.value.equals(element)) {
                if (cur.pre == null) {
                    head = cur.next;
                    if (head != null)
                        head.pre = null;
                }
                else {
                    cur.pre.next = cur.next;
                    if (cur.next != null)
                        cur.next.pre = cur.pre;
                }
                size--;
            }
            else
                cur = cur.next;
        }
    }

    E get(int index) {
        if (index < 0  ||  size <= index) {
            System.out.println("There's no such index!");
            return null;
        }
        else {
            Node<E> cur = head;
            while (index-- > 0)
                cur = cur.next;
            return (E) cur.value;
        }
    }

    int[] indexOf(E element) {
        int[] res = new int[0];
        Node<E> cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.value.equals(element)) {
                int[] tmp = new int[res.length + 1];
                for (int i = 0; i < res.length; i++)
                    tmp[i] = res[i];
                tmp[res.length] = index;
                res = tmp;
            }
            cur = cur.next;
            index++;
        }
        return res;
    }

    void set(int index, E element) {
        if (index < 0  ||  size <= index)
            System.out.println("There's no such index!");
        Node<E> cur = head;
        while (index-- > 0)
            cur = cur.next;
        cur.value = element;
    }

    boolean contains(E element) {
        return indexOf(element).length > 0;
    }

    void clear() {
        head = null;
        size = 0;
    }

    E[] toArray() {
        E[] res = (E[]) new Object[size];
        Node<E> cur = head;
        for (int i = 0; i < size; i++) {
            res[i] = (E) cur.value;
            cur = cur.next;
        }
        return res;
    }
}
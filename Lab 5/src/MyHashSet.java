
class MyHashSet<E>{


    private HashMapCustom<E, Object> hashMapCustom;

    public MyHashSet(){
        hashMapCustom=new HashMapCustom<>();
    }

    public void add(E value){
        hashMapCustom.put(value, null);
    }

    public boolean contains(E obj){
        return hashMapCustom.contains(obj) !=null ? true :false;
    }

    public void display(){
        hashMapCustom.displaySet();
    }

    public boolean remove(E obj){
        return hashMapCustom.remove(obj);
    }

}


class HashMapCustom<K, V> {

    private Entry<K,V>[] table;   //Array of Entry.
    private int capacity= 4;  //Initial capacity of HashMap


    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public HashMapCustom(){
        table = new Entry[capacity];
    }


    public void put(K newKey, V data){
        if(newKey==null)
            return;    //does not allow to store null.

        int hash=hash(newKey);
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);

        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){ //we have reached last entry of bucket.
                if(current.key.equals(newKey)){
                    if(previous==null){  //node has to be insert on first of bucket.
                        newEntry.next=current.next;
                        table[hash]=newEntry;
                        return;
                    }
                    else{
                        newEntry.next=current.next;
                        previous.next=newEntry;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }


    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }


    public boolean remove(K deleteKey){

        int hash=hash(deleteKey);

        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){ //we have reached last entry node of bucket.
                if(current.key.equals(deleteKey)){
                    if(previous==null){  //delete first entry node.
                        table[hash]=table[hash].next;
                        return true;
                    }
                    else{
                        previous.next=current.next;
                        return true;
                    }
                }
                previous=current;
                current = current.next;
            }
            return false;
        }

    }



    public void display(){

        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
                }
            }
        }

    }


    public K contains(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return key;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }



    public void displaySet(){

        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                    System.out.print(entry.key+" ");
                    entry=entry.next;
                }
            }
        }

    }


    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

}


class HashSetCustomApp {

    public static void main(String[] args) {
        MyHashSet<Integer> hashSetCustom = new MyHashSet<>();
        hashSetCustom.add(21);
        hashSetCustom.add(25);
        hashSetCustom.add(30);
        hashSetCustom.add(33);
        hashSetCustom.add(35);

        System.out.println("HashSetCustom contains 21 ="+hashSetCustom.contains(21));
        System.out.println("HashSetCustom contains 51 ="+hashSetCustom.contains(51));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

        System.out.println("\n\n21 removed: "+hashSetCustom.remove(21));
        System.out.println("22 removed: "+hashSetCustom.remove(22));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

    }
}

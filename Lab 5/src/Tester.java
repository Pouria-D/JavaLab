import java.util.Scanner;

//import javax.lang.model.util.ElementScanner14;

public class Tester {
    static boolean isInt(String input) {
        int idx = -1;
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '.') {
                idx = i;
                break;
            }

        if (idx == -1) {
            for (int i = 0; i < input.length(); i++)
                if (input.charAt(i) < '0'  ||  '9' < input.charAt(i))
                    return false;
            if (input.length() == 0)
                return false;
            return true;
        }
        else {
            if (0 < idx  &&  idx + 1 < input.length()) {
                for (int i = 0; i < idx; i++)
                    if (input.charAt(i) < '0'  ||  '9' < input.charAt(i))
                        return false;
                for (int i = idx + 1; i < input.length(); i++)
                    if (input.charAt(i) < '0'  ||  '9' < input.charAt(i))
                        return false;
                return true;
            }
            else
                return false;
        }
    }

    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<String>();
        System.out.println("A = {}");
        System.out.println("Acceptable commands: add value, addBefore index value, remove index, size, get index, set index value, find value, clear, extendLengthBy delta");
        System.out.println();
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.next();
            //System.out.println(input);
            if (input.equals("add")) {
                String value = in.nextLine();
                value = value.substring(1, value.length());
                //System.out.println(value);
                if (isInt(value)) {
                    arr.add(value);
                }
                else {
                    System.out.println("Entered value is not an number.");
                    System.out.println();
                    continue;
                }
            }
            else if (input.equals("addBefore")) {
                String index = in.next();
                if (isInt(index) == false) {
                    System.out.println("Entered index is not a number.");
                    System.out.println();
                    continue;
                }
                int idx = Integer.parseInt(index);
                String value = in.nextLine();
                value = value.substring(1, value.length());
                if (0 <= idx  &&  idx < arr.size()) {
                    if (isInt(value)) {
                        arr.addBefore(idx, value);
                    }
                    else {
                        System.out.println("Entered value is not an number.");
                        System.out.println();
                        continue;
                    }
                }
                else {
                    arr.addBefore(idx, value);
                }
            }
            else if (input.equals("remove")) {
                String index = in.nextLine();
                index = index.substring(1, index.length());
                if (isInt(index) == false) {
                    System.out.println("Entered index is not a number.");
                    System.out.println();
                    continue;
                }
                int idx = Integer.parseInt(index);
                arr.remove(idx);
            }
            else if (input.equals("size")) {
                System.out.println(arr.size());
                System.out.println();
                continue;
            }
            else if (input.equals("get")) {
                String index = in.nextLine();
                index = index.substring(1, index.length());
                if (isInt(index) == false) {
                    System.out.println("Entered index is not a number.");
                    System.out.println();
                    continue;
                }
                int idx = Integer.parseInt(index);
                System.out.println(arr.get(idx));
                System.out.println();
                continue;
            }
            else if (input.equals("set")) {
                String index = in.next();
                if (isInt(index) == false) {
                    System.out.println("Entered index is not a number.");
                    System.out.println();
                    continue;
                }
                int idx = Integer.parseInt(index);
                String value = in.nextLine();
                value = value.substring(1, value.length());
                if (0 <= idx  &&  idx < arr.size()) {
                    if (isInt(value)) {
                        arr.set(idx, value);
                    }
                    else {
                        System.out.println("Entered value is not an number.");
                        System.out.println();
                        continue;
                    }
                }
                else {
                    arr.set(idx, value);
                }
            }
            else if (input.equals("find")) {
                String value = in.nextLine();
                value = value.substring(1, value.length());
                //System.out.println(value);
                if (isInt(value)) {
                    arr.indexOf(value).print();
                    System.out.println();
                    continue;
                }
                else {
                    System.out.println("Entered value is not an number.");
                    System.out.println();
                    continue;
                }
            }
            else if (input.equals("clear")) {
                arr.clear();
            }
            else if (input.equals("extendLengthBy")) {
                String delta = in.nextLine();
                delta = delta.substring(1, delta.length());
                //System.out.println(value);
                if (isInt(delta)) {
                    boolean dot = false;
                    for (int i = 0; i < delta.length(); i++)
                        if (delta.charAt(i) == '.')
                            dot = true;
                    if (dot) {
                        System.out.println("Entered value is not a non-negative integer.");
                        System.out.println();
                        continue;
                    }
                    else {
                        int n = Integer.parseInt(delta);
                        MyArrayList<String> tmp = new MyArrayList<String>(arr.size() + n);
                        for (int i = 0; i < arr.size(); i++)
                            tmp.set(i, arr.get(i));
                        arr = tmp;
                    }
                }
                else {
                    System.out.println("Entered value is not a non-negative integer.");
                    System.out.println();
                    continue;
                }
            }
            else {
                System.out.println("Not a valid command.");
                System.out.println();
                continue;
            }
            System.out.print("A = ");
            arr.print();
            System.out.println();
        }
    }
}
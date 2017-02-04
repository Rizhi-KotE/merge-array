package merger;

import java.util.*;

public class Main {

    public static void ValicMerge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int bpos = 0;
        int length = a.size();
        if (a.get(0) > b.get(0)) a.add(0, b.get(bpos++));
        int l, r, el;

        for (int i = 0; i < length + bpos; i++) {
            if (bpos == b.size()) break;
            l = a.get(i);
            r = (i == length + bpos - 1) ? Integer.MAX_VALUE : a.get(i + 1);
            el = b.get(bpos);
            if (el >= l && el < r) {
                a.add(i + 1, el);
                bpos++;
            }
        }
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int resultLength = a.size() + b.size();
        a.ensureCapacity(resultLength);
        int aSize = a.size(), bSize = b.size();
        a.addAll(b);
        int aPos, bPos, pos;
        for (aPos = aSize - 1, bPos = bSize - 1, pos = resultLength - 1; pos >= 0 && aPos >= 0 && bPos >= 0; pos--) {
            if (a.get(aPos) < b.get(bPos)) {
                a.set(pos, b.get(bPos));
                bPos--;
            } else {
                a.set(pos, a.get(aPos));
                aPos--;
            }
        }
        while (aPos >= 0) {
            a.set(pos, a.get(aPos));
            pos--;
            aPos--;
        }
        while (bPos >= 0) {
            a.set(pos, b.get(bPos));
            pos--;
            bPos--;
        }
    }

    public static void justSort(List<Integer> a, List<Integer> b) {
        ArrayList<Object> objects = new ArrayList<>(a.size() + b.size());
        objects.addAll(a);
        objects.addAll(b);
    }

    public static void merge(LinkedList<Integer> a, LinkedList<Integer> b) {
        if (a.isEmpty()) {
            a.addAll(b);
            return;
        }
        if (b.isEmpty()) return;
        ListIterator<Integer> aIterator = a.listIterator(), bIterator = b.listIterator();
        Integer bElem = bIterator.next();
        while (aIterator.hasNext()) {
            Integer rightElement = aIterator.next();
            aIterator.previous();
            while (bElem < rightElement) {
                aIterator.add(bElem);
                if (bIterator.hasNext())
                    bElem = bIterator.next();
                else return;
            }
            aIterator.next();
        }
        a.addLast(bElem);
        while (bIterator.hasNext()) {
            a.addLast(bIterator.next());
        }
    }
}

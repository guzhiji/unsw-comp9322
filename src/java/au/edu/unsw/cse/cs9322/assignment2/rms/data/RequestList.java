package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestList implements List<RequestItem> {

    private List<RequestItem> l;

    public RequestList() {
        l = new ArrayList<RequestItem>();
    }

    public RequestList(List<RequestItem> list) {
        l = list;
    }

    public List<RequestItem> getList() {
        return l;
    }

    public void setList(List<RequestItem> list) {
        l = list;
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return l.contains(o);
    }

    @Override
    public Iterator<RequestItem> iterator() {
        return l.iterator();
    }

    @Override
    public Object[] toArray() {
        return l.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return l.toArray(a);
    }

    @Override
    public boolean add(RequestItem e) {
        return l.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return l.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return l.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends RequestItem> c) {
        return l.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends RequestItem> c) {
        return l.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return l.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return l.retainAll(c);
    }

    @Override
    public void clear() {
        l.clear();
    }

    @Override
    public RequestItem get(int index) {
        return l.get(index);
    }

    @Override
    public RequestItem set(int index, RequestItem element) {
        return l.set(index, element);
    }

    @Override
    public void add(int index, RequestItem element) {
        l.add(index, element);
    }

    @Override
    public RequestItem remove(int index) {
        return l.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return l.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return l.lastIndexOf(o);
    }

    @Override
    public ListIterator<RequestItem> listIterator() {
        return l.listIterator();
    }

    @Override
    public ListIterator<RequestItem> listIterator(int index) {
        return l.listIterator(index);
    }

    @Override
    public List<RequestItem> subList(int fromIndex, int toIndex) {
        return l.subList(fromIndex, toIndex);
    }

}

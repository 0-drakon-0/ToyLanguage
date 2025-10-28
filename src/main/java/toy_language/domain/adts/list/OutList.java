package toy_language.domain.adts.list;

import toy_language.domain.my_exceptions.EmptyListException;
import toy_language.domain.my_exceptions.IndexOutOfBoundsException;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OutList<E> implements MyList<E> {

    private List<E> outList;

    public OutList() {
        outList = new ArrayList<>();
    }

    @Override
    public void append(E elem) {
        this.outList.add(elem);
    }
    @Override
    public E get(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (this.outList.isEmpty())
            throw new EmptyListException();
        if (index < 0 || index >= this.outList.size())
            throw new IndexOutOfBoundsException(index);
        return this.outList.get(index);
    }
    @Override
    public E remove(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (this.outList.isEmpty())
            throw new EmptyListException();
        if (index < 0 || index >= this.outList.size())
            throw new IndexOutOfBoundsException(index);
        return this.outList.remove(index);
    }
    @Override
    public int size() {
        return this.outList.size();
    }
    @Override
    public boolean isEmpty() {
        return this.outList.isEmpty();
    }
    @Override
    public String toString() {
        String contents = this.outList.stream()
                                      .map(element -> element.toString())
                                      .collect(Collectors.joining(", "));
        return "{ " + contents + " }";
    }
}

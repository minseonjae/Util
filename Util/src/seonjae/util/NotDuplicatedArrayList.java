package seonjae.util;

import java.util.ArrayList;
import java.util.Collection;

public class NotDuplicatedArrayList<E> extends ArrayList<E> {

  public boolean add(E e) {
    return contains(e) ? false : super.add(e);
  }

  public boolean addAll(Collection<? extends E> c) {
    c.forEach(v -> add(v));

    return true;
  }

}

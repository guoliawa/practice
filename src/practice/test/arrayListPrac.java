package practice.test;

import java.io.IOException;
import java.util.*;

public class arrayListPrac<E> extends AbstractList<E> implements List<E>,
		RandomAccess, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 8683452581122892189L;

	private transient Object[] elementData;

	private int size;

	public arrayListPrac(int initialCapacity) {
		super();
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: "
					+ initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
	}

	public arrayListPrac() {
		this(10);
	}

	public arrayListPrac(Collection<? extends E> c) {
		elementData = c.toArray();
		size = elementData.length;
		if (elementData.getClass() != Object[].class)
			elementData = Arrays.copyOf(elementData, size, Object[].class);
	}

	public void trimToSize() {
		modCount++;
		int oldCapacity = elementData.length;
		if (size < oldCapacity) {
			elementData = Arrays.copyOf(elementData, size);
		}
	}

	public void ensureCapacity(int minCapacity) {
		modCount++;
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			Object oldData[] = elementData;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	public boolean add(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elementData[i]))
					return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = size - 1; i >= 0; i--)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());

		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	public E get(int index) {
		RangeCheck(index);
		return (E) elementData[index];
	}

	public E set(int index, E element) {
		RangeCheck(index);
		E oldValue = (E) elementData[index];
		elementData[index] = element;
		return oldValue;
	}

	public void add(int index, E element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);
		}

		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size
				- index);
		elementData[index] = element;
		size++;
	}

	public E remove(int index) {
		RangeCheck(index);
		modCount++;
		E oldValue = (E) elementData[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		}
		elementData[--size] = null;
		return oldValue;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++) {
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
			}
		} else {
			for (int index = 0; index < size; index++) {
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
			}
		}

		return false;
	}

	private void fastRemove(int index) {
		// TODO Auto-generated method stub
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--size] = null;
	}

	public void clear() {
		modCount++;
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	public boolean addAll(Collection<? extends E> c) {
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacity(size + numNew);
		System.arraycopy(a, 0, elementData, size, numNew);
		size += numNew;
		return numNew != 0;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);
		}

		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacity(size + numNew);

		int numMoved = size - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew,
					numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		size += numNew;
		return numNew != 0;
	}

	protected void removeRange(int fromIndex, int toIndex) {
		modCount++;
		int numMoved = size - toIndex;
		System.arraycopy(elementData, toIndex, elementData, fromIndex, numMoved);

		int newSize = size - (toIndex - fromIndex);
		while (size != newSize)
			elementData[--size] = null;
	}

	public Object clone() {
		try {
			arrayListPrac<E> v = (arrayListPrac<E>) super.clone();
			v.elementData = Arrays.copyOf(elementData, size);
			v.modCount = 0;
			return v;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	private void writeObject(java.io.ObjectOutputStream s) throws IOException {
		int expectedModCount = modCount;
		s.defaultWriteObject();
		s.writeInt(elementData.length);
		for (int i = 0; i < size; i++) {
			s.writeObject(elementData[i]);
		}

		if (modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}

	private void readObject(java.io.ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		int arrayLength = s.readInt();

		Object[] a = elementData = new Object[arrayLength];

		for (int i = 0; i < size; i++) {
			a[i] = s.readObject();
		}
	}

	private void RangeCheck(int index) {
		// TODO Auto-generated method stub
		if (index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);
	}

	private static void isRandomAccessSupported(List list) {
		if (list instanceof RandomAccess) {
			System.out.println("RandomAccess implemented");
		} else {
			System.out.println("RandomAccess not implemented");
		}
	}

	public static void iteratorThroughRandomAccess(List list) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		endTime = System.currentTimeMillis();
		long interval = endTime - startTime;
		System.out.println("iteratorThroughRandomAccess：" + interval + " ms");
	}

	public static void iteratorThroughIterator(List list) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			iter.next();
		}
		endTime = System.currentTimeMillis();
		long interval = endTime - startTime;
		System.out.println("iteratorThroughIterator：" + interval + " ms");
	}

	public static void iteratorThroughFor2(List list) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		for (Object obj : list)
			;
		endTime = System.currentTimeMillis();
		long interval = endTime - startTime;
		System.out.println("iteratorThroughFor2：" + interval + " ms");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list1 = new arrayListPrac();
		for (int i = 0; i < 100000; i++) {
			list1.add(i);
		}

		iteratorThroughRandomAccess(list1);
		iteratorThroughIterator(list1);
		iteratorThroughFor2(list1);

		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		list.add(0, "5");

		System.out.println("the first element is:" + list.get(0));
		list.remove("3");
		System.out.println("Arraylist size =: " + list.size());
		System.out.println("ArrayList contains 3 is: " + list.contains(3));
		list.set(1, "10");

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			System.out.println("next is: " + iter.next());
		}

		// 将ArrayList转换为数组
		String[] arr = (String[]) list.toArray(new String[0]);
		for (String str : arr)
			System.out.println("str: " + str);
		// 清空ArrayList
		list.clear();
		// 判断ArrayList是否为空
		System.out.println("ArrayList is empty: " + list.isEmpty());
	}

}

package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Functions_GUI implements functions {
	Collection<function> collection = new ArrayList<function>();

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public boolean isEmpty() {
		if (collection.size() ==0)
			return true;
		return false;
	}

	@Override
	public boolean contains(Object o) {
		if(collection.contains(o))
			return true;
		return false;

	}

	@Override
	public Iterator<function> iterator() {
		//		this.collection.iterator().hasNext();
		return null;
	}

	@Override
	public Object[] toArray() {
		try {
			collection.toArray();
		}
		catch(NullPointerException ex) {
			throw new NullPointerException("An NullPointerException occured, please re-check");
		}
		catch(  ArrayStoreException  ex ) {
			throw new ArrayStoreException("An ArrayStoreException occured, please re-check");
		}

		return collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		try {
			collection.toArray(a);
		}
		catch(NullPointerException ex) {
			throw new NullPointerException("An NullPointerException occured, please re-check");
		}
		catch(  ArrayStoreException  ex ) {
			throw new ArrayStoreException("An ArrayStoreException occured, please re-check");
		}
		return collection.toArray(a);
	}

	@Override
	public boolean add(function e) {
		try {
			collection.add(e);
		}
		catch(ClassCastException | NullPointerException | UnsupportedOperationException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		try {
			collection.remove(o);
		}
		catch(  NullPointerException | ClassCastException  ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		try {
			collection.containsAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException |IllegalStateException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		try {
			collection.addAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException  ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		try {
			collection.removeAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException  ex ) {
			return false;
		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		try {
			collection.retainAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException  ex ) {
			return false;
		}

		return true;
	}

	@Override
	public void clear() {
		try {
			collection.clear();
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException  ex ) {
			System.out.println("An error occured. please check");
		}

	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}

package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Functions_GUI implements functions {
	Collection<function> collection = new ArrayList<function>();

	@Override
	public int size() {//v
		return collection.size();
	}

	@Override
	public boolean isEmpty() {	//v
		return collection.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {//v
		try {
			collection.contains(o);
		}
		catch(ClassCastException |NullPointerException ex) {
			return false;
		}
		return true;
		}
		@Override
	public Iterator<function> iterator() {//v
	return collection.iterator();
	}

	@Override
	public Object[] toArray() {//v
	return collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {//v
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
	public boolean add(function e) {//v
		try {
			collection.add(e);
		}
		catch(ClassCastException | NullPointerException | UnsupportedOperationException|IllegalArgumentException | IllegalStateException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {//v
		try {
			collection.remove(o);
		}
		catch(  NullPointerException | ClassCastException|UnsupportedOperationException  ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {//v
		try {
			collection.containsAll(c);
		}
		catch( NullPointerException |ClassCastException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {//v
		try {
			collection.addAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | IllegalArgumentException |IllegalStateException|ClassCastException ex ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {//v
		try {
			collection.removeAll(c);
		}
		catch( UnsupportedOperationException |NullPointerException | ClassCastException  ex ) {
			return false;
		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {//v
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

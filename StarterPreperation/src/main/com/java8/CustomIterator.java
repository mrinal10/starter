package com.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomIterator<T> implements Iterator<T>{
	
	List<T> customList;
	int pos = 0;
	
	public CustomIterator(List<T> tList) {
		this.customList = tList;
	}

	@Override
	public boolean hasNext() {
		while(pos < customList.size()) {
			if(customList.get(pos).hashCode() != 0) {
				return true;
			}
			pos++;
		}
		return false;
	}

	@Override
	public T next() {
		if(hasNext()) {
			return customList.get(pos++);
		}
		throw new NoSuchElementException();
	}
	
}

class IteratorTest{
	public static void main(String[] args) {
		List<String> list = Arrays.asList("alone", "Alice", "Texas");
		CustomIterator<String> itr = new CustomIterator<String>(list);
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
 
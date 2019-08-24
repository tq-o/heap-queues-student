package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	 

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	/**
	   * Given an index of some "node" returns the index to that "nodes" left
	   * child.
	   * 
	   * @param index
	   *            an index in this {@link AbstractArrayHeap}
	   * @return the index of the specified "nodes" left child
	   * @throws IndexOutOfBoundsException
	   *             if {@code index} is less than 0
	   */
	
	@Override
	  protected int getLeftChildOf(int index) {
		  if (index < 0) throw new IndexOutOfBoundsException();
		  return (2*index+1);
	  } 

	  /**
	   * Given an index of some "node" returns the index to that "nodes" right
	   * child.
	   * 
	   * @param index
	   *            a "nodes" index
	   * @return the index of the specified "nodes" right child
	   * @throws IndexOutOfBoundsException
	   *             if {@code index} is less than 0
	   */
	@Override
	  protected int getRightChildOf(int index) {
		  if (index < 0) throw new IndexOutOfBoundsException();
		  return (2*index+2);
	  }

	  /**
	   * Given an index of some "node" returns the index to that "nodes" parent.
	   * 
	   * @param index
	   *            a "nodes" index
	   * @return the index of the specified "nodes" parent
	   * @throws IndexOutOfBoundsException
	   *             if {@code index} is less than 1
	   */
	@Override
	  protected int getParentOf(int index) {
		 if (index < 1) throw new IndexOutOfBoundsException();
		  return ((index-1)/2);
	}

	  /**
	   * <p>
	   * This results in the entry at the specified index "bubbling up" to a
	   * location such that the property of the heap are maintained. This method
	   * should run in O(log(size)) time.
	   * </p>
	   * <p>
	   * Note: When add is called, an Entry is placed at the end of the internal
	   * array and then this method is called on that index.
	   * </p>
	   * 
	   * @param index
	   *            the index to bubble up
	   */
	  protected void bubbleUp(int index) {

		  while ((index > 0) && (comparator.compare(heap.get(index).getPriority(), heap.get((index-1)/2).getPriority())) > 0) {
			  swap(index, getParentOf(index)); 
			  index =  getParentOf(index);
		}

	  }

	  /**
	   * <p>
	   * This method results in the entry at the specified index "bubbling down"
	   * to a location such that the property of the heap are maintained. This
	   * method should run in O(log(size)) time.
	   * </p>
	   * <p>
	   * Note: When remove is called, if there are elements remaining in this
	   * {@link AbstractArrayHeap} the bottom most element of the heap is placed
	   * at the 0th index and bubbleDown(0) is called.
	   * </p>
	   * 
	   * @param index
	   */
	  protected void bubbleDown(int index) {
		  int largerChild;
		  int elem = index;
		  while (index < size()/2) { // has at least 1 child
		  
		  int left = getLeftChildOf(index), right = getRightChildOf(index);
		  if (right < size() && // right child exists 
				  comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
			  largerChild = right;
		  else
			  largerChild = left;
		  if (comparator.compare(heap.get(elem).getPriority(),heap.get(largerChild).getPriority()) >= 0)
			  break;
		  swap(index,largerChild);
		 // heap[index] = heap[largerChild];
		  bubbleDown(largerChild);
		  index = largerChild;
		  }
		 // heap[index] = elem;
		  
	  }
}


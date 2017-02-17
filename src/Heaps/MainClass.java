package Heaps;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heapSize=6;
		int heapArr[]={12, 11, 13, 5, 6, 7};
		
		MaxHeap maxheap=new MaxHeap();
		maxheap.heapSize=heapSize;

		maxheap.buildHeap(heapArr);
		maxheap.printHeap(heapArr);
				
				
		
	}

}

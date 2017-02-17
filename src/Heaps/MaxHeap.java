package Heaps;

public class MaxHeap {
	
	int heapSize;
	//int heapArr[]={12, 11, 13, 5, 6, 7}; //default value, can be changed

	public void printHeap(int[] heapArr){
		for(int i=0;i<this.heapSize;i++){
			System.out.print(heapArr[i]+" ");
		}
	}
	public void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public int parent(int i){
		return (i-1)/2;
	}	
	public int left(int i){
		return 2*i+1;
	}	
	public int right(int i){
		return 2*i+2;
	}
	public void heapifyRec(int[] heapArr,int i){
		int largest=i;
		System.out.println(i);
		if(largest<this.heapSize && heapArr[largest]<left(i))
			largest=left(i);
		if(largest<this.heapSize && heapArr[largest]<right(i))
			largest=right(i);
		System.out.println(largest);
		if(largest!=i){
			swap(heapArr,i,largest);
			System.out.println("About to recurse");
			heapifyRec(heapArr,largest);
		}
	}	
	public void heapifyIter(int[] heapArr,int i){
		int largest=i;
		int temp=i;
		while(largest<=this.heapSize/2){
			if(largest<this.heapSize && heapArr[largest]<left(temp))
				largest=left(i);
			if(largest<this.heapSize && heapArr[largest]<right(temp))
				largest=right(i);
			if(largest != temp){
				swap(heapArr,temp,largest);
				temp=largest;
				largest=temp;
			}
			else
				break;
		}
	}
	public void buildHeap(int[] heapArr){
		for(int i=(this.heapSize)/2-1;i>=0;i--){
			//System.out.println(i);
			heapifyRec(heapArr,i);}
	}
	public int extractMax(int[] heapArr){
		int max=heapArr[0];
		heapArr[0]=heapArr[this.heapSize-1];
		this.heapSize--;
		heapifyRec(heapArr,0);
		return max;
	}
	public void insertKey(int[] heapArr,int key){
		this.heapSize++;
		int i=this.heapSize-1;
		heapArr[i]=key;
		while(i>0 && heapArr[parent(i)]<heapArr[i]){
			swap(heapArr,i,parent(i));
			i=parent(i);
		}
	}
	
}

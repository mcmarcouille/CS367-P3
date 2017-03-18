import java.util.Comparator;

/**
 * An implementation of the MinPriorityQueueADT interface. This implementation stores FileLine objects.
 * See MinPriorityQueueADT.java for a description of each method. 
 *
 */
public class FileLinePriorityQueue implements MinPriorityQueueADT<FileLine> {
    // TODO。
	private FileLine [] arr;
    private Comparator<FileLine> cmp;
    private int maxSize;
    private int size = 0;

    public FileLinePriorityQueue(int initialSize, Comparator<FileLine> cmp) {
		this.cmp = cmp;
		maxSize = initialSize+1;
		// TODO
		//Create a new array named arr.
		arr = new FileLine[maxSize];
		
    }

    public FileLine removeMin() throws PriorityQueueEmptyException {
    	//最小堆
		// TODO
    	if(size == 0) throw new PriorityQueueEmptyException();
    	int pos = 1;
    	FileLine min = arr[1];
    	arr[1] = arr[size - 1];
    	size = size - 1;
    	while(2 * pos <= size){
        	int temp = 2 * pos;//temp就是你想要比较的节点  // temp is the node you want to compare.
    		if(temp + 1 <= size){
    			if(cmp.compare(arr[temp],arr[temp + 1]) > 0){//判断如果左节点大于右节点。 // if lift node bigger than right
    				temp = temp + 1;//那么把想要比较的子节点设为右节点。 // then set node which you want to compare to the right node
    			}
    		}
    		if(cmp.compare(arr[pos], arr[temp]) > 0) { //pos为当前父节点，temp为当前子节点， 如果父节点大于子节点，要互相交换 // pos is parent node, temp is curr node. if the parent node bigger than child node , swap
    			FileLine t = arr[pos];  //设置一个新的变量t ， 把当前父节点的值存进去， //set a new node, save the value from parent node
    			arr[pos] = arr[temp];  //设最小子节点的值为新的父节点。// set the min value to be the new parent node
    			arr[temp] = t;     //然后把父节点设为子节点的值。目的是维持堆的性质。 // then set the new child node, the value from child node.
    		}
    		pos = temp;
    	}
    			
    	
		return min;
    }

    public void insert(FileLine fl) throws PriorityQueueFullException {
		// TODO
    	if(size == maxSize) throw new PriorityQueueFullException();
    	arr[size] = fl;
    	int child = size;
    	while(child / 2 >= 1) {
    		if(cmp.compare(arr[child / 2], arr[child]) > 0) {
    			FileLine t2 = arr[child/2];
    			arr[child/2] = arr[child];
    			arr[child] = t2;
    		
    	child = child/2;		
    		}
    		size++;
    	}
     
  
    	        
    	
    }

    public boolean isEmpty() {
		// TODO
    	
    	
		return size == 0;
    }
}

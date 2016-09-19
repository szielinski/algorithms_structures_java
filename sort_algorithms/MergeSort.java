class MergeSort {

	static void sort(int[] b) { // Sort b 
		int segLength = 16; // tentative initial segment length	
		// ensure even number of rounds
		int runLength = segLength; 
		boolean even = true; // is the number of rounds needed even?
		while (runLength<b.length) {
			runLength = runLength*2; even = !even;
		}
		if (!even) segLength = segLength*2;	
		// sort the segments initially	
		for (int lo=0; lo<b.length; lo=lo+segLength) {
			int hi = lo+segLength; if(hi>b.length) hi = b.length;
			simpleSort(b,lo,hi);
		}
		// repeatedly merge adjacent segments between b and temp 
		int[] temp = new int[b.length];
		while (segLength<b.length) {
			mergeRuns(b, segLength, temp); segLength = segLength*2;
			mergeRuns(temp, segLength, b); segLength = segLength*2;
		}
	}

	private static void mergeRuns(int[] c, int segLength, int[] d) {
	// c and d equal size. c is sorted runs of length segLength
	// (last segment may be short). Merge neighbouring segments into
	// corresponding positions in d
		int lo = 0; int mid = 0; int hi = 0;
		while (lo+segLength<c.length) {
			mid = lo+segLength; 
			hi = mid+segLength; if (hi>c.length) hi = c.length;
			merge(c,lo,mid,hi,d);
			lo = lo+segLength*2;
		}
		// move any final unpaired segment in c to d
		while (lo<c.length) {d[lo] = c[lo]; lo++;}
	}
	    
	private static void merge(int[] c, int lo, int mid, int hi, int[] d) {
		// c[lo..mid-1], c[mid..hi-1] sorted. Merge into corresponding 
		// positions in d
		int i = lo; int j = mid; int k=lo;
		while (i<mid&&j<hi) {
			if(c[i]<=c[j]) {d[k] = c[i]; i++;}
			else {d[k] = c[j]; j++;}
			k++;
		}
		// copy any unused tail in a segment (at most one such)
		while (i<mid) { d[k] = c[i]; i++; k++;}
		while (j<hi) { d[k] = c[j]; j++; k++;}  	
	}
		   
	private static void simpleSort(int[] w, int lo, int hi) {
	// Sort w[lo..hi-1] using selection sort
		int j = lo;
		while (j<hi-1) {
			int min = j;  int i = j+1; 
			while (i<hi) {
				if (w[i]<w[min]) min = i;
				i++;
			}
			int temp = w[j]; w[j] = w[min]; w[min] = temp;
			j++;
		}
	}

}


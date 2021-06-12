package com.zero.linkedlist;

public class DoublyTroubly {

}

class BeingZeroDLL {
	DLLNode clone(DLLNode h) {
		DLLNode curr = h, temp;

		while (curr != null) {
			temp = curr.d;
			curr.d = new DLLNode(curr.data);
			curr.d.d = temp;
			curr = temp;
		}
		curr = h;
		while (curr != null) {
			curr.d.t = curr.t.d;
			if(curr.d!=null){ 
				curr =  curr.d.d;
			}else{
				curr =  curr.d;
			}
		}
		DLLNode original = h, copy = h.d;
		temp = copy;
		while (original != null && copy != null) {
			
			original.d = original.d != null ? original.d.d : original.d;

			copy.d = copy.d != null ? copy.d.d : copy.d;
			original = original.d;
			copy = copy.d;
		}
		return temp;
	}
}
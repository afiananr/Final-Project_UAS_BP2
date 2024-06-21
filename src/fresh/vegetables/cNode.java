package fresh.vegetables;

public class cNode {

    cTransaksi data;
    cNode next;

    cNode(cTransaksi d) {
        this.data = d;
        this.next = null;
    }

    public void setData(cTransaksi d) {
        this.data = d;
    }

    public void setNext(cNode n) {
        this.next = n;
    }

    public cTransaksi getData() {
        return data;
    }

    public cNode getNext() {
        return next;
    }
}

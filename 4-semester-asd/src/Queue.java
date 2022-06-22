import java.util.Iterator;

public class Queue {

    private Node data;
    private Queue nextElem;

    public Queue(Node data, Queue nextElem) {
        this.data = data;
        this.nextElem = nextElem;
    }

    public Queue(Iterator<Node> iterator) {
        this.data = iterator.next();
        if(iterator.hasNext()) {
            this.nextElem = new Queue(iterator);
        }
    }

    public Queue(Node node) {
        this.data = node;
    }

    public Node getData() {
        return data;
    }

    public boolean hasNextElem() {
        return nextElem != null;
    }

    public Queue getNextElem() {
        return nextElem;
    }

    public void addElem(Node node) {
        if(this.data.getCount() > node.getCount()) {
          //Jeśli this.data.getcount jest większy to NODE musi być wcześniej
                Queue temp = new Queue(this.data, this.nextElem);
                this.data = node;
                this.nextElem = temp;
        } else {
            //Jeśli this.data.getcount jest mniejszy to NODE jest później
            if(this.hasNextElem()) {
                this.nextElem.addElem(node);
            } else {
                this.nextElem = new Queue(node);
            }
        }
    }

    public Node pollFirstElem() {
        Queue temp = new Queue(this.data, this.nextElem);

        if(this.hasNextElem()) {
            this.data = this.nextElem.data;
            this.nextElem = this.nextElem.nextElem;
        } else {
            this.data = new Node("",0);
            this.nextElem = null;
        }
        return temp.data;
    }
}

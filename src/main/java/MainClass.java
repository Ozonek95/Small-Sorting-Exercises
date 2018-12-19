public class MainClass {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Executable superTask = () -> System.out.println("Super!");
        myQueue.add(() -> System.out.println("1"));
        myQueue.add(superTask);
        myQueue.add(() -> System.out.println("2"));
        myQueue.add(superTask);
        myQueue.add(() -> System.out.println("3"));
        myQueue.add(superTask);
        myQueue.add(() -> System.out.println("4"));
        myQueue.add(superTask);
        myQueue.add(() -> System.out.println("5"));
        myQueue.add(superTask);
        //TODO: run Executables one by one in loop
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();
        myQueue.get().execute();

    }
}

interface Executable {
    void execute();
}

class MyQueue {

    private Box head;
    private Box tail;

    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public Box getTail() {
        return tail;
    }

    public void setTail(Box tail) {
        this.tail = tail;
    }

    public void add(Executable executable) {
        if(getHead()==null){
            setHead(new Box(executable));
            setTail(getHead());
        }
        else {
            Box tail = new Box(executable);
            Box tempBox = getTail();
            getTail().setPreviousBox(tail);
            setTail(tail);
            getTail().setNextBox(tempBox);
        }
    }

    public Executable get() {
        if(getHead()!=null){
            Box tempBox = getHead();
            setHead(getHead().getPreviousBox());
            return tempBox.getExecutable();
        }
        else return null;


    }

    public int size() {
        int counter = 1;
        if(getTail()==null){
            return 0;
        }
        else if(getTail()!=null){

            Box tempBox = getTail();
            while (tempBox.getNextBox()!=null){
                counter++;
                tempBox = tempBox.getNextBox();
            }
        }

        return counter;
    }

    @Override
    public String toString() {
        // TODO: fill it with body
        // prints all elements
        return "MyQueue[]";
    }
    class Box{
        private Executable executable;
        private Box nextBox;
        private Box previousBox;

        public Box(Executable executable) {
            this.executable = executable;
        }

        public Box getNextBox() {
            return nextBox;
        }

        public void setNextBox(Box nextBox) {
            this.nextBox = nextBox;
        }

        public Box getPreviousBox() {
            return previousBox;
        }

        public void setPreviousBox(Box previousBox) {
            this.previousBox = previousBox;
        }

        public Executable getExecutable() {
            return executable;
        }
    }
}
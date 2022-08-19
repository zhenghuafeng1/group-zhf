package demo.test;

public class ProJava implements WorkEventListener {

    @Override
    public void toTime(WorkEvent w) {
        System.out.println("Java To Work");
    }

    public void toTime(WorkEvent w,int i) {
        System.out.println("Java To Work");
    }
}

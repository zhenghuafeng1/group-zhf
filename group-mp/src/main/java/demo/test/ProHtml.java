package demo.test;

public class ProHtml implements WorkEventListener {
    @Override
    public void toTime(WorkEvent w) {
        System.out.println("Html To Work");
    }
}

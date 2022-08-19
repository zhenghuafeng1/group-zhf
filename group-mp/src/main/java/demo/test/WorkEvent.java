package demo.test;

import java.util.EventObject;

public class WorkEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private boolean time;    //true表示上,false表示下
    public WorkEvent(Object source, boolean time) {
        super(source);
        this.time = time;
    }
    public void setTime(boolean time) {
        this.time = time;
    }
    public boolean getTime() {
        return this.time;
    }
}

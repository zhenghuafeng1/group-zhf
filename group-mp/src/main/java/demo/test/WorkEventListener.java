package demo.test;

import java.util.EventListener;

interface WorkEventListener extends EventListener {
    void toTime(WorkEvent w);
}

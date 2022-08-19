package demo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkEventSource {
    private List<WorkEventListener> listener;

    public WorkEventSource() {
        listener = new ArrayList<WorkEventListener>();
    }

    //给事件源绑定监听器
    public void addListener(WorkEventListener worker) {
        listener.add(worker);
    }

    //事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
    public void toTime(boolean time) {
        String type = time ? "八点半" : "六点";
        System.out.println(type + "时间到！");
        WorkEvent event = new WorkEvent(this, time);
        notifies(event);    //通知注册在该事件源上的所有监听器
    }

    //当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
    protected void notifies(WorkEvent w) {
        WorkEventListener ren = null;
        Iterator<WorkEventListener> iterator = listener.iterator();
        while (iterator.hasNext()) {
            ren = iterator.next();
            ren.toTime(w);
        }
    }
}

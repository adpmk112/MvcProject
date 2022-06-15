package ace.project.function;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoId {
	private AtomicInteger c = new AtomicInteger(1);
 
    public int increment() {
        int id = c.getAndIncrement();
		return id;
     }
}

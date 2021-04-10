import java.util.LinkedList;
import java.util.List;


public class CircularBuffer <T> {
    private final int bufferFixedSize;
    private final List<T> data;
    
    public CircularBuffer (int bufferFixedSize) {
        // Pre-condition : bufferFixedSize must be greater than 0
//        if (bufferFixedSize <= 0) {
//            throw new BufferIOException("Buffer size must be greater than 0");
//        }
        this.bufferFixedSize = bufferFixedSize;
        this.data = new LinkedList<>();
        
    }
    
    public void write(T element) throws BufferIOException {
        // Pre-condition : a slot must be available
        if (data.size() >= bufferFixedSize) {
            throw new BufferIOException("Tried to write to full buffer");
        }
        
        data.add(element);
    }
    
    public void overwrite(T element) throws BufferIOException {
        if (data.size() >= bufferFixedSize) {
            this.read();
        }
        this.write(element);
    }
    
    public T read() throws BufferIOException {
        // Pre-condition : the buffer must not be empty
        if (data.isEmpty()) {
            throw new BufferIOException("Tried to read from empty buffer");
        }
        
        return data.remove(0);
    }
    
    public void clear() {
        data.clear();
    }
    
}

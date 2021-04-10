import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> ops = new ArrayList<>();
        for (Signal signal : Signal.values()) {
            if ((number & signal.getCode()) != 0) {
                if (signal == Signal.REVERSE) {
                    Collections.reverse(ops);
                } else {
                    ops.add(signal);
                }
            }
        }
        return ops;
    }

}
enum Signal {
    WINK(0b00001),
    DOUBLE_BLINK(0b00010),
    CLOSE_YOUR_EYES(0b00100),
    JUMP(0b01000),
    REVERSE(0b10000);

    private int code;

    Signal(int code) { this.code = code; }

    public int getCode() { return code; }
}

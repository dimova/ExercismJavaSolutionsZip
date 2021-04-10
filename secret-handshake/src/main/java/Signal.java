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

import java.util.Objects;

public class Clock {
    private int _hours;
    private int _minutes;

    public Clock(int hours, int minutes) {
        _hours = hours;
        _minutes = minutes;
        normalize();
    }

    private void normalize() {
        _hours += _minutes / 60;
        _minutes %= 60;

        if (_minutes < 0) {
            _hours--;
            _minutes += 60;
        }

        _hours %= 24;

        if (_hours < 0) {
            _hours += 24;
        }
    }

    public void add(int minutes) {
        _minutes += minutes;
        normalize();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", _hours, _minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return _hours == clock._hours && _minutes == clock._minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_hours, _minutes);
    }
}

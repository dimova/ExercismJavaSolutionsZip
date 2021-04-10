import java.util.List;

public class BinarySearch {

    private final List<Integer> sortedList;

    public BinarySearch(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    public int indexOf(int searchingFor) throws ValueNotFoundException {
        int start = 0;
        int mid;
        int end = sortedList.size() - 1;

        while (start <= end) {
            mid = (start + end) / 2;

            int value = sortedList.get(mid);

            if (value == searchingFor) {
                return mid;
            } else if (value > searchingFor) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }
}

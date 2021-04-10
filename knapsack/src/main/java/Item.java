public class Item {
    private final int weight;
    private final int value;

    Item( int weight, int value ){
        this.weight = weight;
        this.value = value;
    }

    int getWeight() { return this.weight; }

    int getValue() { return this.value; }
}

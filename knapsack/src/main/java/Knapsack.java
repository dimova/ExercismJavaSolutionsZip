import java.util.ArrayList;

class Knapsack {

    int maximumValue(int maximumWeight, ArrayList<Item> items) {
        return maximumValueHelperBottomUp(maximumWeight, items);
    }

    // MW:
    // There is only one way to solve this problem. Pretty mathematical problem
    private int maximumValueHelperBottomUp(
            int maximumWeight, ArrayList<Item> items) {
        int[][] knapsack = new int[items.size() + 1][maximumWeight + 1];
        for (int item = 0; item <= items.size(); item++) {
            for (int weight = 0; weight <= maximumWeight; weight++) {
                knapsack[item][weight] = 0; // Return 0 if not filled
            }
        }
        for (int item = 0; item <= items.size(); item++) {
            for (int weight = 0; weight <= maximumWeight; weight++) {
                if (item == 0 || weight == 0) {
                    knapsack[item][weight] = 0;
                } else if (items.get(item - 1).getWeight() > weight) {
                    knapsack[item][weight] = knapsack[item - 1][weight];
                } else {
                    int itemValue  = items.get(item - 1).getValue();
                    int itemWeight  = items.get(item - 1).getWeight();
                    knapsack[item][weight] =
                            Math.max(
                                    itemValue + knapsack[item - 1][weight - itemWeight],
                                    knapsack[item - 1][weight]
                            );
                }
            }
        }
        return knapsack[items.size()][maximumWeight];
    }

}
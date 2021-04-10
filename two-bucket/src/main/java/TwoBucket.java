public class TwoBucket {
    private int moves = 1;
    private int bucketSizeA;
    private int bucketSizeB;
    private int amountInBucketA = 0;
    private int amountInBucketB = 0;
    private int targetVolume;

    public TwoBucket(int bucketSizeA, int bucketSizeB, int targetVolume, String startWith) {
        this.bucketSizeA = bucketSizeA;
        this.bucketSizeB = bucketSizeB;
        this.targetVolume = targetVolume;
        makeMoves(targetVolume, startWith);
    }

    public String getFinalBucket() {
        return amountInBucketA == targetVolume ? "one" : "two";
    }

    public int getOtherBucket() {
        return amountInBucketA == targetVolume ? amountInBucketB : amountInBucketA;
    }

    public int getTotalMoves() {
        return moves;
    }

    private void makeMoves(int targetVolume, String startWith) {
        int fillBucketSize;
        int amountInFillBucket;
        int emptyBucketSize;
        int amountInEmptyBucket = 0;

        if (startWith.equals("one")) {
            fillBucketSize = bucketSizeA;
            emptyBucketSize = bucketSizeB;
        } else {
            fillBucketSize = bucketSizeB;
            emptyBucketSize = bucketSizeA;
        }

        amountInFillBucket = fillBucketSize;

        if (emptyBucketSize == targetVolume) {
            amountInEmptyBucket = emptyBucketSize;
            moves++;
        } else {

            while (amountInFillBucket != targetVolume && amountInEmptyBucket != targetVolume) {
                if (amountInEmptyBucket == emptyBucketSize) {
                    amountInEmptyBucket = 0;
                    moves++;
                }

                if (amountInFillBucket == 0) {
                    amountInFillBucket = fillBucketSize;
                    moves++;
                }

                int transferAmount = Math.min(emptyBucketSize - amountInEmptyBucket, amountInFillBucket);
                amountInFillBucket -= transferAmount;
                amountInEmptyBucket += transferAmount;
                moves++;
            }
        }

        if (startWith.equals("one")) {
            amountInBucketA = amountInFillBucket;
            amountInBucketB = amountInEmptyBucket;
        } else {
            amountInBucketA = amountInEmptyBucket;
            amountInBucketB = amountInFillBucket;
        }
    }
}

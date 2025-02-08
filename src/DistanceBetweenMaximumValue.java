public class DistanceBetweenMaximumValue {
    public static void main(String[] args) {
        System.out.println(distanceBetweenMaxAndMin(new int[]{4, 100, 3, 4}));
        System.out.println(distanceBetweenMaxAndMin(new int[]{5, 50, 50, 4, 5}));
        System.out.println(distanceBetweenMaxAndMin(new int[]{5, 350, 350, 4, 350}));
        System.out.println(distanceBetweenMaxAndMin(new int[]{10, 10, 10, 10, 10}));
        System.out.println(distanceBetweenMaxAndMin(new int[]{}));
        System.out.println(distanceBetweenMaxAndMin(null));
    }

    private static int distanceBetweenMaxAndMin(int[] array) {
        if (array == null || array.length <= 1) return 0;
        if (array.length == 2) {
            if (array[0] == array[1]) return 1;
            return 0;
        }
        int max = Integer.MIN_VALUE, index1 = 0, index2 = 0;
        for (int i : array) max = Math.max(max, i);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                index1 = i;
                i = array.length;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == max) {
                index2 = i;
                i = 0;
            }
        }
        return index2 - index1;
    }
}
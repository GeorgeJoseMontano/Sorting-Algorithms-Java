import java.util.Random;

public class merge_sort {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] temp = new int[array.length];
        merge_sort(array, temp, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void merge_sort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            merge_sort(array, temp, left, center);
            merge_sort(array, temp, center + 1, right);
            merge(array, temp, left, center + 1, right);
        }
    }

    public static void merge(int[] array, int[] temp, int left, int right, int right_end) {
        int left_end = right - 1;
        int temp_pos = left;
        int num_elements = right_end - left + 1;
        while (left <= left_end && right <= right_end) {
            if (array[left] <= array[right]) {
                temp[temp_pos++] = array[left++];
            } else {
                temp[temp_pos++] = array[right++];
            }
        }
        while (left <= left_end) {
            temp[temp_pos++] = array[left++];
        }
        while (right <= right_end) {
            temp[temp_pos++] = array[right++];
        }
        for (int i = 0; i < num_elements; i++, right_end--) {
            array[right_end] = temp[right_end];
        }
    }
}
import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix()));
    }

    public static int[][] generateMatrix() {
        int n;
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.println("Введите количество массивов от 1 до 100: ");
            n = in.nextInt();
            if (n < 1) {
                System.out.println("Вы ввели число меньше 1, попробуйте еще раз.");
            } else if (n > 100) {
                System.out.println("Вы ввели число больше 100, попробуйте еще раз.");
            }
        } while (n < 1 || n > 100);

        int[][] matrix = new int[n][];
        List<Integer> lengths =  new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrLength;
            do {                                                    //проверим была ли уже эта длина получена ранее
                arrLength = (random.nextInt(1,101));
            } while (lengths.contains(arrLength));

            lengths.add(arrLength);


            int[] arr = new int[arrLength];

            for (int j = 0; j < arrLength; j++) {
                arr[j] = random.nextInt();
            }

            Arrays.sort(arr);
            if (i % 2 > 0) {                                            //для нечетного массива сделаем реверс
                for (int k = 0, j = arr.length - 1; k < j; k++, j--) {
                    int t = arr[k];
                    arr[k] = arr[j];
                    arr[j] = t;
                }
            }
            matrix[i] = Arrays.copyOf(arr, arrLength);
        }

        return matrix;
    }
}
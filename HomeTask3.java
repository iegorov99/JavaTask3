import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeTask3 {
    public static void main(String[] args) {
        // task1(10, 10);
        planets(10);
    }

    // 1.Пусть дан произвольный список целых чисел.

    // 1) Нужно удалить из него чётные числа
    // 2) Найти минимальное значение
    // 3) Найти максимальное значение
    // 4) Найти среднее значение

    static void task1(int size, int maxValue) {
        ArrayList<Integer> nums = arrayOddNums(arrayNums(size, maxValue));
        System.out.println();
        getMinMaxAvg(nums);
    }

    static ArrayList<Integer> arrayNums(int size, int maxValue) {
        Random rnd = new Random();
        ArrayList<Integer> nums = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            nums.add(rnd.nextInt(1, maxValue));
            System.out.print(nums.get(i) + " ");
        }

        return nums;
    }

    static ArrayList<Integer> arrayOddNums(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                nums.remove(i);
                i--;
            }
        }
        return nums;
    }

    static void getMinMaxAvg (ArrayList<Integer> nums) {
        int sum = 0;
        int min = nums.get(0);
        int max = nums.get(0);
        double avg;

        for (Integer num : nums) {
            if (num < min) min = num;
            else if (num >max) max = num;
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println();

        avg = (double) sum / (double) nums.size();

        System.out.printf("Minimal value: %d\n", min);
        System.out.printf("Maximal value: %d\n", max);
        System.out.printf("Average value: %f", avg);
    }

    // 2.Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.
    static void planets(int n) {
        List<String> listPlanets = List.of("Earth", "Mars", "Jupiter", "Venus", "Mercury", "Pluto", "Saturn" );
        List<String> randPlanets= new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];
        Random rnd = new Random();

        // for (int i = 0; i < n; i++) {
        //     randPlanets.add(listPlanets.get(rnd.nextInt(listPlanets.size())));
        //     System.out.print(randPlanets.get(i) + " ");
        //     counts[listPlanets.indexOf(randPlanets.get(i))]++;
        // }

        for (int i = 0; i < n; i++) {
            String planet = listPlanets.get(rnd.nextInt(listPlanets.size()));
            for (int j = 1; j < randPlanets.size(); j++) {
                if (randPlanets.contains(planet)) {
                    randPlanets.remove(planet);
                    j--;
                }
            }
            randPlanets.add(planet);
        }

        for (int i = 0; i < randPlanets.size(); i++) {
            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }


        System.out.println();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            else System.out.printf("%s : %s\n", listPlanets.get(i), counts[i] );
        }
    }

}
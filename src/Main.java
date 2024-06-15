import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = List.of(5, 2, 7, 9, 10, 4, 3, 24, 80, 15, 19);
            System.out.println(sortNumbers(numbers));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> numbersSort = new ArrayList<>();
        if (numbers.isEmpty() || !numbers.stream().allMatch(n -> n >= 0)){
            throw new IllegalArgumentException("La lista de números no puede estar vacía y todos los números deben ser positivos");
        }else {
            List<Integer> peers = numbers.stream().filter(n -> n % 2 == 0).sorted().toList();
            List<Integer> odd = numbers.stream().filter(n -> n % 2 != 0).sorted().toList();
            numbersSort.addAll(peers);
            numbersSort.addAll(odd);
            return numbersSort;
        }
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MiscMain {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findFirst();
        System.out.println(result.get());

    }
}

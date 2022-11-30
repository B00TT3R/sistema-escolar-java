import java.util.Scanner;
public class Prompter {
    public static  String prompt(String message){
        System.out.println(message);
        try (Scanner scanner = new Scanner(System.in)) {
            String value = scanner.nextLine();
            if(value.equals("")){
                System.out.println("Por favor, digite uma opção válida");
                prompt(message);
            }
            return value;
        }
        
        
    }
    public static String listGen(String[] list){
        String result = "\n";
        for(int i = 0; i < list.length; i++){
            result += list[i];
            if(i < list.length - 1){
                result += "\n";
            }
        }
        return result;
    }
}

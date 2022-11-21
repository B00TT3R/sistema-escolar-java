import java.sql.Connection;

public class Main {
    
    public static void main(String[] args) {
        String[] opcoes = {
            "[1]-Deletar Banco",
            "[2]-Migrar Banco",
            "[3]-Conectar ao Banco",
            "[4]-Criar Banco",
        };
        
        String prompt = Prompter.prompt("Olá, usuário, o que deseja fazer nesse momento?"+ Prompter.listGen(opcoes));
        if(prompt.equals("1")){
            MySQLORM mysql = new MySQLORM();
            mysql.dropDB();
        }
        else if(prompt.equals("2")){
            MySQLORM mysql = new MySQLORM();
            mysql.migrate();
        }
        else if(prompt.equals("3")){
            MySQLORM mysql = new MySQLORM();
            Connection conn = mysql.conectar();
            System.out.println(conn);
        }
        else if(prompt.equals("4")){
            MySQLORM mysql = new MySQLORM();
            mysql.createDB();
            String prompt2 = Prompter.prompt("Deseja criar as tabelas? [s/n]");
            if(prompt2.equals("s")){
                mysql.migrate();
            }
        }
        else{
            System.out.println("Opção inválida");
        }
    }
}

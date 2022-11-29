import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class MySQLORM extends Main{
    protected String id_field = "id int NOT NULL AUTO_INCREMENT";

    String nomeTabela = "sistema_escolar";
    String usuario = "root";
    String senha = "";
    String baseUrl = "jdbc:mysql://localhost:3306/";

    public Connection conectar(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/"+ nomeTabela +"?user="+usuario+"&password=" + senha;
        try{
            conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(SQLException e){
            String msgErro = e.getMessage();
            System.out.println(msgErro);
            System.out.println("Ocorrreu um erro ao tentar conectar ao banco de dados");
           
            return null;
        }
    public void createDB(){
        System.out.println("Criando banco...");
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user="+usuario+"&password=" + senha);
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE "+ this.nomeTabela);
            System.out.println("Banco criada com sucesso!");
        } catch(SQLException e){
            System.out.println("Ocorreu um erro ao tentar criar o banco de dados");
            System.out.println(e.getMessage());
        }
    }        
    private String implode(String[] array){
        String result = "";
        for(int i = 0; i < array.length; i++){
            result += array[i];
            if(i < array.length - 1){
                result += ", ";
            }
        }
        return result;
    }
    protected void tableGenerator(String tableName, String[] fields){
        try{
            Connection conn = this.conectar();
            if(conn == null){
                System.out.println("Não foi possível conectar ao banco de dados");
                return;
            }
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE "+ tableName +" (" + id_field +", " + this.implode(fields) + ", PRIMARY KEY (id))");
            System.out.println("Tabela " + tableName + " criada com sucesso!");

            
        } catch(SQLException e){
            System.out.println("Ocorreu um erro ao tentar criar a tabela: " + tableName);
            System.out.println(e.getMessage());
            
        }
    }
    protected void migrate(){
        Tables tables = new Tables();
        tables.all();
    }
    public void dropDB(){
        try{
            Connection conn = this.conectar();
            if(conn != null){
                java.sql.Statement stmt = conn.createStatement();
                stmt.executeUpdate("DROP DATABASE "+ this.nomeTabela);
                System.out.println("Banco deletado com sucesso!");
            }
        } catch(SQLException e){
            System.out.println("Ocorreu um erro ao tentar deletar o banco de dados");
            System.out.println(e.getMessage());
        }
    }
    
}
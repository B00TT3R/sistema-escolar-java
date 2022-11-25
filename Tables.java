public class Tables extends MySQLORM{
    private void turno(){
        String[] fields = {
            "nome varchar(255) NOT NULL"
        };
        this.tableGenerator("turno", fields);
    }
    private void serie(){
        String[] fields = {
            "nome varchar(255) NOT NULL"
        };
        this.tableGenerator("serie", fields);
    }
    private void anoLetivo(){
        String[] fields = {
            "nome varchar(255) NOT NULL",
            "dataInicial date NOT NULL",
            "dataFinal date NOT NULL"
        };
        this.tableGenerator("ano_letivo", fields);
    }
    private void matrizTurno(){
        String[] fields = {
            "matriz int NOT NULL",
            "turno int NOT NULL"
        };
        this.tableGenerator("matriz_turno", fields);
    }
    private void endereco(){
        String[] fields = {
            "rua varchar(255) NOT NULL",
            "bairro varchar(255) NOT NULL",
            "cidade int NOT NULL",
            "tipo_logradouro varchar(255) NOT NULL",
            "cep varchar(255) NOT NULL"
        };
        this.tableGenerator("endereco", fields);
    }
    private void login() {
        String[] fields = {
            "nome varchar(255) NOT NULL",
            "email varchar(255) NOT NULL",
            "senha varchar(255) NOT NULL",
            "status varchar(255) NOT NULL",
        };
        this.tableGenerator("login", fields);
    }
    private void pessoa(){
        String[] fields = {
            "nome varchar(255) NOT NULL",
            "cpf varchar(255) NOT NULL",
            "rg varchar(255) NOT NULL",
            "dataNascimento date NOT NULL",
            "pai varchar(255) NOT NULL",
            "mae varchar(255) NOT NULL",
            "ativo boolean NOT NULL",
            "endereco int NOT NULL"
        };
        this.tableGenerator("pessoa", fields);
    }
    private void professor(){
        String[] fields = {
            "pessoa int NOT NULL",
            "licensa int NOT NULL",
            "formacao varchar(255) NOT NULL",
        };
        this.tableGenerator("professor", fields);
    }
    private void matriz(){
        String[] fields = {
            "nome varchar(255) NOT NULL",
            "curso int NOT NULL",
            "unidade_ensino int NOT NULL",
            "periodo_letivo int NOT NULL",
            "forma_avaliacao int NOT NULL",
            "minuto_aula int NOT NULL",
            "semanas int NOT NULL",
        };
        this.tableGenerator("matriz", fields);
        
    }
    private void unidadeEnsino(){
        String[] fields = {
            "nome text NOT NULL",
            "nome_fantasia varchar(255) NOT NULL",
            "nis varchar(255) NOT NULL",
            "endereco int NOT NULL",
            "telefone varchar(255) NOT NULL",
            "email text NOT NULL",

        };
        this.tableGenerator("unidade_ensino", fields);
    }
    private void aluno(){
        String[] fields = {
            "pessoa int NOT NULL",
            "unidade_ensino int NOT NULL",
        };
        this.tableGenerator("aluno", fields);
    }
    private void nota(){
        String[] fields={
            "bimestre text NOT NULL",
            "nota float NOT NULL",
            "falta int NOT NULL",
        };
        this.tableGenerator("nota", fields);
    }
    private void matricula(){
        String[] fields = {
            "aluno int NOT NULL",
            "classe int NOT NULL",
            "situacao_matricula int NOT NULL",
        };
        this.tableGenerator("matricula", fields);
    }
    private void disciplina(){
        String[] fields= {
            "carga_horaria text NOT NULL",
            "nome text NOT NULL",
        };
        this.tableGenerator("disciplina", fields);
    }
    private void turma(){
        String[] fields = {
            "nome text NOT NULL",
            "curso int NOT NULL",
            "serie int NOT NULL",
            "ano_leitivo int NOT NULL",
            "unidade_ensino int NOT NULL",
            "turno int NOT NULL",
            "vagas int NOT NULL",
        };
        this.tableGenerator("turma", fields);
    }
    private void curso(){
        String[] fields = {
            "nome text NOT NULL",
        };
        this.tableGenerator("curso", fields);
    }
    private void matrizSerie(){
        String[] fields = {
            "matriz int NOT NULL",
            "serie int NOT NULL",
        };
        this.tableGenerator("matriz_serie", fields);
    }
    private void matrizSerieDisciplina(){
        String[] fields = {
            "matriz_serie int NOT NULL",
            "disciplina int NOT NULL",
        };
        this.tableGenerator("matriz_serie_disciplina", fields);
    }
    //public function to call ALL the above functions
    public void all(){
        this.turno();
        this.serie();
        this.anoLetivo();
        this.matrizTurno();
        this.endereco();
        this.pessoa();
        this.professor();
        this.matriz();
        this.unidadeEnsino();
        this.aluno();
        this.nota();
        this.matricula();
        this.disciplina();
        this.turma();
        this.curso();
        this.matrizSerie();
        this.matrizSerieDisciplina();
        this.login();
    }

}

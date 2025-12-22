package cadastrodefuncionario;


public class FuncionarioDAO {

    private Funcionario[] funcionariosCadastrados;
    private int proximaPosicao;
    
    public FuncionarioDAO() {
        this.funcionariosCadastrados = new Funcionario[100];
        this.proximaPosicao = 0;
    }
    
    public String cadastrarFuncionario(String nome, String idadeStr, String cargo, String salarioStr){
        
        int idade;
        
        try{
            idade = Integer.parseInt(idadeStr);
            if(idade <=0){
                return "Erro. A idade deve ser positiva";
            }
        } catch(NumberFormatException e){
            return "Erro. Idade invalida";
        }
        double salario;
        
        try{
           salario = Double.parseDouble(salarioStr.replace(',', '.'));
           if(salario < 0){
               return "Erro. Salario nao pode ser menor que zero";
           }
        } catch(NumberFormatException e){
            return "Salario invalida";
        }
        
        if(nome.trim().isEmpty() || cargo.trim().isEmpty()){
            return "Erro. Nome e cargo nao podem estar vazios";
        }
        
        if(proximaPosicao < funcionariosCadastrados.length){
            
            Funcionario novoFuncionario = new Funcionario(nome.trim(),cargo.trim(), idade, salario);
           
            this.funcionariosCadastrados[proximaPosicao] = novoFuncionario;
            proximaPosicao++;
            
            return "Sucesso!";
        } else{
            return "Nao foi possivel o limite foi atingido";
        }
        
    }
    
    public String listarFuncionario(){
        
        String resultado = "";
        
        if(proximaPosicao == 0){
            
            resultado += "Nenhum funcionario cadastrado";
        }
        
        else{
            resultado += "Lista de funcionarios cadastrados";
            for(int i = 0; i < proximaPosicao; i++){
                
                resultado += funcionariosCadastrados[i].toString() + "\n";
            }
           
        }
        return resultado;
    }
    
    public String filtrarCargo(String cargo){
        
        boolean encontrouFuncionario = false;
        String funcionariosEncontrados = "";
        
        String cargoTratado = cargo.trim(); //caso o usuario digite espaços a mais
        
        for(int i = 0; i < proximaPosicao; i++){
            Funcionario funcionarioAtual = funcionariosCadastrados[i];
            
            if(funcionarioAtual.getCargo().trim().equalsIgnoreCase(cargoTratado)){
                funcionariosEncontrados += funcionarioAtual.toString();
                encontrouFuncionario = true;
            }
        }
        
        if(!encontrouFuncionario){
            funcionariosEncontrados = "Nenhum aluno encontrado";
        }
        
        return funcionariosEncontrados;
        
    }
    
    public String filtrarSalario(String salarioDesejadoStr){
       
        
        boolean encontrouFuncionario = false;
        String funcionariosEncontrados = "";
        
        double salarioDesejado;
        
        try{
            salarioDesejado = Double.parseDouble(salarioDesejadoStr);
            if(salarioDesejado < 0){
                return "Erro. O salario nao pode ser nulo";
            }
        } catch (NumberFormatException e){
                    return "Erro salario invalido";
          }
        
        
        funcionariosEncontrados += "---Funcionarios com salario igual a R$" + salarioDesejado;
        
        
        for(int i = 0; i < proximaPosicao; i++){
            Funcionario funcionarioAtual = funcionariosCadastrados[i];
            
            if(funcionarioAtual.getSalario() == salarioDesejado){
                funcionariosEncontrados += funcionarioAtual.toString() + "\n";
                encontrouFuncionario = true;
            }
        }
        
        if(!encontrouFuncionario){
            funcionariosEncontrados += "Nenhum aluno encontrado";
        }
        
        return funcionariosEncontrados;
        
    }
    
    public String removerFuncionario(String nomeFuncionario){
        
        String nomeFuncionarioTratado = nomeFuncionario.trim();
        int indiceParaRemover = -1;
        
        for(int i = 0; i < proximaPosicao; i++){
            
            if(funcionariosCadastrados[i].getNome().trim().equalsIgnoreCase(nomeFuncionarioTratado)){
                indiceParaRemover = i;
                break;
            }
        }
        
        if(indiceParaRemover != -1){
            for(int i = indiceParaRemover; i < proximaPosicao - 1; i++){
                funcionariosCadastrados[i] = funcionariosCadastrados[i + 1];                
                
            }
            
            funcionariosCadastrados[proximaPosicao - 1] = null;
            
            proximaPosicao--;
            
            return "Sucesso!";
        } else{
            return "Erro. O funcionario nao foi encontrado";
        }
        
    }
    
    public String atualizarSalario(String novoSalarioStr, String nomeFuncionario){
        
        String nomeFuncionarioTratado = nomeFuncionario.trim();
        double novoSalario;
        
        try{
            novoSalario = Double.parseDouble(novoSalarioStr);
        } catch(NumberFormatException e){
            return "Erro ao atualizar salario invalido";
        }
        
        int indiceParaAtualizar = -1;
        
        for(int i = 0; i < proximaPosicao; i++){
            
            if(funcionariosCadastrados[i].getNome().trim().equalsIgnoreCase(nomeFuncionarioTratado)){
                indiceParaAtualizar = i;
                break;
            }
        }
        
        if(indiceParaAtualizar != -1){
            funcionariosCadastrados[indiceParaAtualizar].setSalario(novoSalario);
            return "Sucesso! Salário do funcionário atualizado";
        } else{
            return "Erro! Funcionario nao encontrado";
        }
    }

    @Override
    public String toString() {
        return "";
    }
    
    
    
    
}

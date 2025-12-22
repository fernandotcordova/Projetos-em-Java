package cadastrodefuncionario;

import java.util.Scanner;

public class CadastroDeFuncionario {

    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       
       FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
       
       funcionarioDAO.cadastrarFuncionario("Ana", "28", "Analista", "4000.00");
       funcionarioDAO.cadastrarFuncionario("Bruno", "35", "Gerente", "10000.00");
       funcionarioDAO.cadastrarFuncionario("Carla", "22", "Estagiaria", "1200.00");
       funcionarioDAO.cadastrarFuncionario("Daniel", "40", "Desenvolvedor", "6000.00");
       funcionarioDAO.cadastrarFuncionario("Julia", "24", "Analista", "3800.00");
       String op;
       
       do{
           System.out.println(""" 
                              ---MENU---
                              0. Sair                   
                              1. Cadastrar funcionário
                              2. Listar funcionários
                              3. Buscar funcionário por cargo
                              4. Atualizar salário do funcionário
                              5. Remover funcionário
                              """);
           System.out.println("\nEscolha uma opcao:");
           op = teclado.nextLine();
           
           switch(op){
               case "0":
                   System.out.println("Voce escolheu sair do sistema. Ate mais");
                   break;
                   
               case "1": 
                   System.out.println("Voce escolheu cadastrar um funcionario:");
                   
                   System.out.println("Digite o nome do funcionario:");
                   String nome = teclado.nextLine();
                   
                   System.out.println("Digite a idade do funcionario:");
                   String idade = teclado.nextLine();
                   
                   System.out.println("Digite o cargo do funcionario:");
                   String cargo = teclado.nextLine();
                   
                   System.out.println("Digite o salario do funcionario:");
                   String salario = teclado.nextLine();
                   
                   System.out.println(funcionarioDAO.cadastrarFuncionario(nome, idade, cargo, salario));
                   break;
                   
               case "2":
                   System.out.println("Voce escolheu listar os funcionarios:");
                   System.out.println(funcionarioDAO.listarFuncionario());
                   break;
                   
               case "3": 
                   System.out.println("Voce escolheu buscar o funcionario pelo cargo:");
                   
                   System.out.println("Digite o cargo para buscar:");
                   String cargoBusca = teclado.nextLine();
                   
                   System.out.println(funcionarioDAO.filtrarCargo(cargoBusca));
                   break;
                   
               case "4":
                   System.out.println("Voce escolheu atualizar o funcionario:");
                   
                   System.out.println("Digite o nome do funcionario:");
                   String nomeBusca = teclado.nextLine();
                   
                   System.out.println("Digite o novo salario:");
                   String novoSalario = teclado.nextLine();
                   
                   System.out.println(funcionarioDAO.atualizarSalario(nomeBusca, novoSalario));
                   break;
                   
               case "5":
                   System.out.println("Voce escolheu remover um funcionario:");
                   
                   System.out.println("Digite o nome do funcionario para ser removido:");
                   String nomeParaRemover = teclado.nextLine();
                   
                   System.out.println(funcionarioDAO.removerFuncionario(nomeParaRemover));
                   break;
           }
           
           System.out.println("Pressione Enter para continuar");
           teclado.nextLine();
           System.out.println("\n");
       } while(!op.equals("0"));
       
    }
    
}

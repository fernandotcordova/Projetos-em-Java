package sistemadegestaodetarefas;

import java.util.Scanner;

public class SistemaDeGestaoDeTarefas {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO();
        
        dao.adicionarTarefa(new Tarefa("Estudar para prova", "Estudar para avaliacao", 25));
        dao.adicionarTarefa(new Tarefa("Limpar a casa para receber visita", "Limpar a casa", 18));
        dao.adicionarTarefa(new Tarefa("Limpar o carro", "Limpar o carro", 23));
        dao.adicionarTarefa(new Tarefa("Comprar pao e leite", "Compras", 13));
        
        String op;
        
        do{
            
            System.out.println("Bem vindo aos nossos sistemas");
            
            System.out.println("""
                               ---MENU---
                               0-Sair
                               1-Adicionar tarefa
                               2-Listar tarefas
                               3-Marcar tarefa como concluida
                               4-Atualizar tarefa
                               5-Remover tarefa
                               6-Buscar tarefa
                               7-Listar tarefa concluida
                               8-Listar tarefas pendentes
                               """);
            
            System.out.println("Escolha uma opção");
            op = teclado.nextLine();
            
            switch(op){
                case "0":
                    System.out.println("Voce escolheu sair dos nossos sistemas. Ate mais!");
                    break;
                    
                case "1":
                    System.out.println("Voce escolheu adicionar uma tarefa:");
                    
                    System.out.println("Digite o nome da tarefa:");
                    String nomeTarefa = teclado.nextLine();
                    
                    System.out.println("Digite a descricao da tarefa:");
                    String descricaoTarefa = teclado.nextLine();
                    
                    int dataVencimento = 0;
                    boolean dataValida = false;
                    
                    while(!dataValida){
                        System.out.println("Digite o dia de vencimento da tarefa:");
                        String dataStr = teclado.nextLine();
                        
                        try{
                            dataVencimento = Integer.parseInt(dataStr.trim());
                            dataValida = true;
                        } catch(NumberFormatException e){
                            System.out.println("Data invalida. Por favor, digite uma data valida");
                        }
                    }
                    
                    Tarefa novaTarefa = new Tarefa(nomeTarefa, descricaoTarefa, dataVencimento);
                    dao.adicionarTarefa(novaTarefa);
                    
                    System.out.println("Tarefa adicionada com sucesso!");
                    
                    break;
                    
                case "2":
                    System.out.println("Voce escolheu listar todas as tarefas:");
                    System.out.println(dao.listarTarefas());
                    break;
                    
                case "3":
                    System.out.println("Voce escolheu marcar uma tarefa como concluida:");
                    
                    System.out.println("Digite o nome da tarefa a ser marcada:");
                    String nomeTarefaMarcada = teclado.nextLine();
                    
                    if(dao.marcarComoConcluida(nomeTarefaMarcada)){
                        System.out.println("Tarefa: " + nomeTarefaMarcada + "marcada como concluida");
                    } else{
                        System.out.println("Erro: Tarefa" + nomeTarefaMarcada + "nao encontrada ou ja estava concluida" );
                    }
                    
                    break;
                    
                case "4":
                    System.out.println("Voce escolheu atualizar uma tarefa:");
                    
                    System.out.println("Digite o nome da tarefa que voce que atualizar:");
                    String nomeAntigo = teclado.nextLine();
                    
                    System.out.println("Digite o novo nome: (deixe em branco para nao mudar)");
                    String novoNome = teclado.nextLine();
                    
                    System.out.println("Digite a nova descricao: (deixe em branco para nao mudar)");
                    String novaDescricao = teclado.nextLine();
                    
                    System.out.println("Digite a nova data de nascimento: (apenas o dia, deixe em branco para nao mudar)");
                    String novaDataVencimento = teclado.nextLine();
                    
                    if(dao.atualizarTarefa(nomeAntigo, novoNome, novaDescricao, novaDataVencimento)){
                        System.out.println("Tarefa " + nomeAntigo + "atualizado com sucesso");
                    } else{
                        System.out.println("Erro: Tarefa " + nomeAntigo +"nao encontrado");
                    }
                    
                    break;
                    
                case "5":
                    System.out.println("Voce escolheu remover uma tarefa:");
                    
                    System.out.println("Digite o nome da tarefa para ser removido");
                    String nomeParaRemover = teclado.nextLine();
                    
                    String resultadoRemocao = dao.removerTarefa(nomeParaRemover);
                    System.out.println(resultadoRemocao);
                    
                    break;
                    
                case "6":
                    System.out.println("Voce escolheu buscar uma tarefa:");
                    
                    System.out.println("Digite o nome da tarefa para ser removido:");
                    String nomeBuscado = teclado.nextLine();
                    
                    System.out.println(dao.buscarTarefa(nomeBuscado));
                    break;
                    
                case "7":
                    System.out.println("Voce escolheu listar as tarefas concluidas:");
                    System.out.println(dao.listarTarefasConcluidas());
                    break;
                    
                case "8":
                    System.out.println("Voce escolheu listar as tarefas pendentes:");
                    System.out.println(dao.listarTarefasPendentes());
                    break;
                            
                default:
                    System.out.println("Voce nao escolheu uma opcao valida. Ate mais");
                    break;
            }
            
            System.out.println("Pressione Enter para continuar:");
            teclado.nextLine();
            
            
        } while(!op.equals("0"));
        
        teclado.close();
    }
    
}

package farmácia;

import java.util.Scanner;

public class Farmácia {
     
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int op = 1;
        
       
        MedicamentoDAO gerenciadorDeMedicamento = new MedicamentoDAO("", 0, 0);
        Caixa caixaDoDia = new Caixa(1000.0, 500.0, 40, 50);
        
        MedicamentoDAO paracetamol = new MedicamentoDAO("Paracetamol", 15, 20.0);
        paracetamol.setReceita(false);
        paracetamol.setDesconto(2.50);
        paracetamol.setCusto(10.0);
        
        if(!gerenciadorDeMedicamento.adicionarMedicamento(paracetamol)){
            System.out.println("Falha em adicionar. Medicamento cheio");
        }
        
        MedicamentoDAO amoxilina = new MedicamentoDAO("Amoxilina", 20, 25.0);
        amoxilina.setReceita(true);
        amoxilina.setDesconto(4.00);
        amoxilina.setCusto(15.0);
        
        if(!gerenciadorDeMedicamento.adicionarMedicamento(amoxilina)){
            System.out.println("Falha em adicionar. Medicamento cheio");
        }
        
        MedicamentoDAO ibuprofeno = new MedicamentoDAO("ibuprofeno", 20, 75.0);
        ibuprofeno.setReceita(true);
        ibuprofeno.setDesconto(0.00);
        ibuprofeno.setCusto(12.0);
        
        if(!gerenciadorDeMedicamento.adicionarMedicamento(ibuprofeno)){
            System.out.println("Falha em adicionar. Medicamento cheio");
        }
        
        MedicamentoDAO dorflex = new MedicamentoDAO("dorflex", 20, 25.0);
        amoxilina.setReceita(false);
        amoxilina.setDesconto(2.00);
        amoxilina.setCusto(20.0);
        
        if(!gerenciadorDeMedicamento.adicionarMedicamento(dorflex)){
            System.out.println("Falha em adicionar. Medicamento cheio");
        }
        
        do{
            System.out.println("----MENU----");
            System.out.println("""
                               0-Sair
                               1-Lucro total
                               2-Faturamento total
                               3-Quantidade de vendas
                               4-Quantidade de produtos vendidos desde a abertura do caixa
                               """);
            
            
            System.out.println("\nEscolha um opçao:");
            op = Integer.parseInt(teclado.nextLine());
            
            switch(op){
                 
                case 1: 
                    System.out.println("Você escolheu fazer uma nova venda");
                    System.out.println("Medicamentos disponíveis: " + gerenciadorDeMedicamento.toString());
                    
                    System.out.println("Digite o nome do medicamento para vender:");
                    String nomeMedicamento = teclado.nextLine();
                    
                    System.out.println("Digite o nome para remover:");
                    String remover = teclado.nextLine();
                    
                    MedicamentoDAO medicamentoVendido = gerenciadorDeMedicamento.buscarMedicamento(nomeMedicamento);
                    
                    if(nomeMedicamento == null){
                        System.out.println("Medicamento nao encontrado");
                        break;
                    }
                    
                    System.out.println("Digite a quantidade que voce deseja:");
                    int quantidade = Integer.parseInt(teclado.nextLine());
                    
                    if(quantidade <= 0){
                        System.out.println("Quantidade incorreta");
                    }
                    
                    if(medicamentoVendido.getQntEstoque() < quantidade){
                        System.out.println("Nao temos a quantidade desejada em estoque");
                        break;
                    }
                    
                    if(medicamentoVendido.isReceita()){
                        System.out.println("Cuidado! Esse medicamento requer receita");
                    }
                    
                    double valorComDesconto = medicamentoVendido.calcularPreco();
                    double valorTotalVenda = valorComDesconto * quantidade;
                    double custoTotal = medicamentoVendido.getCusto() * quantidade;
                    
                    System.out.println("Venda realizada com sucesso!");
                    System.out.println("Valor total a ser pago pelo cliente: " + valorTotalVenda);
                    System.out.println("Estoque de "+ medicamentoVendido.getNome() + "com quantidade de: " + medicamentoVendido.getQntEstoque());
                    
                    break;
                
                case 2:
                    System.out.println("Você escolheu apresentar o faturamento do dia");
                    System.out.println("Faturamento: " + caixaDoDia.getFaturamento());
                    
                    break;
                
                case 3:
                    System.out.println("Você escolheu apresentar o lucro do dia");
                    System.out.println("Lucro do dia: " + caixaDoDia.getLucro());
                    break;
                
                case 4:
                    System.out.println("Você escolheu apresentar a quantidade de clientes atendidos");
                    System.out.println("Quantidade de clientes: " + caixaDoDia.getQntVendas());
                    break;
                    
                case 5:
                    System.out.println("Voce escolheu apresentar total de produtos vendidos");
                    System.out.println("Quantidade total de produtos vendidos: " + caixaDoDia.getQntProdVendidos());
                    break;
                  
                case 6: 
                    System.out.println("Voce escolheu apresentar o lucro medio por dia");
                    double lucroMedio = caixaDoDia.lucroMedio(0, 0);
                    
                    if(caixaDoDia.getQntProdVendidos() > 0){
                        System.out.println("O lucro medio e igual a: " + lucroMedio);
                    }
                    
                    else{
                        System.out.println("Nao ha produtos vendidos");
                    }
                    
                case 7:
                    System.out.println("Saindo do sistema. Ótimo dia!");
                    break;
                    
                default:
                    System.out.println("Você não escolheu nenhuma opção válida");
                    break;
            
        }
            
        } while(op!=0);
        
        
        teclado.close();
    }
    
}

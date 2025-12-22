package farmácia;

public class Caixa {
    
    private String nome;
    private double lucro;
    private double faturamento;
    private double qntVendas;
    private int qntProdVendidos;

    public Caixa(double lucro, double faturamento, int qntVendas, int qntProdVendidos) {
        this.lucro = 0;
        this.faturamento = 0;
        this.qntVendas = 0;
        this.qntProdVendidos = 0;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public double getQntVendas() {
        return qntVendas;
    }

    public void setQntVendas(double qntVendas) {
        this.qntVendas = qntVendas;
    }

    public int getQntProdVendidos() {
        return qntProdVendidos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQntProdVendidos(int qntProdVendidos) {
        this.qntProdVendidos = qntProdVendidos;
    }
    
    public void regitrarVenda(double valorTotalVenda, double custoTotalProduto, int qntItensVendidos){
        
        this.faturamento = this.faturamento + valorTotalVenda;
        
        double lucroVenda = valorTotalVenda - custoTotalProduto;
        this.lucro = this.lucro + lucroVenda;
        
        this.qntVendas++;
        
        this.qntProdVendidos = this.qntProdVendidos + qntItensVendidos;
        
        
    }
    
    public double lucroMedio(double c, double vlrMedicamento){
        if(this.qntProdVendidos > 0){
            return this.lucro / this.qntProdVendidos;
        } 
        else{
            return 0.0;
        }
    }
    
    public void calcularLucro(double custo, double valorMedicamento){
        
        double total = valorMedicamento - custo;
       
        this.lucro = total;
    }

    @Override
    public String toString() {
        return "------RESUMO DO CAIXA------" + 
               "Faturamento total: " + this.getFaturamento() +
               "Lucro total" + this.getLucro() +
               "Quantidade de vendas" + this.getQntVendas() + 
               "Quantidade de produtos vendidos" + this.getQntProdVendidos();
                
    }
    
    

    
    
    
    
}

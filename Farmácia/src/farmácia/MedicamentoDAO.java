package farmácia;

public class MedicamentoDAO {
    
    private MedicamentoDAO[] medicamentos;
    private int contador; 
    private String nome;
    private double preco;
    private boolean receita;
    private double desconto;
    private double custo;
    private int qntEstoque;
    
    public MedicamentoDAO(String nome, int estoque, double preco) {
        
        this.medicamentos = new MedicamentoDAO[10];
        this.contador = 0;
        this.nome = nome;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.receita = false;
        this.desconto = 0.0;
        this.custo = 0.0;
           
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isReceita() {
        return receita;
    }

    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    public boolean adicionarMedicamento(MedicamentoDAO medicamento){
        if(medicamento != null){
            if(contador < medicamentos.length){
                this.medicamentos[contador] = medicamento;
                this.contador++;
                return true;
            } else{
                return false; //array cheio
            } 
            
        } else{
            return false; //medicamento nulo
        }
    }
    
    public MedicamentoDAO buscarMedicamento(String nome){
        if(nome == null || nome.trim().isEmpty()){
            return null;
        }
        
        for(int i=0; i<contador; i++){
            if(this.medicamentos[i].getNome().equalsIgnoreCase(nome.trim())){
                return this.medicamentos[i];
            }
        }
            return null;
        
    }
    
    public boolean removerMedicamento(String nome){
        if(nome == null || nome.trim().isEmpty()){
            return false;
        }
        
        int paraRemover = -1;
        
        for(int i = 0; i <contador; i++){
            if(this.medicamentos[i].getNome().equalsIgnoreCase(nome.trim())){
                paraRemover = i;
                break;
            }
        }
        
        if(paraRemover != 1){
            for(int i = paraRemover; i < contador; i++){
                this.medicamentos[i] =this.medicamentos[i+1];
            }
            this.medicamentos[contador - 1] = null;
            
            this.contador--;
            return true;
        } else{
            return false;
        }
    }
    
    public double calcularPreco(){
        return this.preco * (1 - this.desconto);
    }

    @Override
    public String toString() {
        String resultado = "--RESULTADO---";
        if(contador == 0){
            resultado += "Nenhum medicamento cadastrado";
        } else{
            for(int i = 0; i< contador; i++){
                resultado += medicamentos[i].toString();
            }
        }
        
        return resultado;
    }
    
    
  
}

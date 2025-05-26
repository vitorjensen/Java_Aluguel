/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel;

/**
 *
 * @author vitor
 */
//Inicio da Classe auxiliar para chamar os clientes cadastrados no campo
public class ClienteComboBox {
    private int codigo;
    private String nome;
    
    
    public ClienteComboBox(int codigo, String nome)
    {
        this.codigo = codigo;
        this.nome = nome;
                
    }
   public int getCodigo()
    {
        return codigo;
    }
    public String getNome()
    {
        return nome;
    }

    @Override
    public String toString() {
       return nome; // Vai aparecer no combobox
//     return "ClienteComboBox{" + "nome=" + nome + '}';
    }
    
}

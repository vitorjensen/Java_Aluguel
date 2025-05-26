/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel;

/**
 *
 * @author vitor
 */
public class ProdutoComboBox {
    private int codigo;
    private String descricao;
    
    public ProdutoComboBox(int codigo, String descricao)
    {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo()
    {
        return codigo;
    }
    public String getDescricao()
    {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
        //return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}

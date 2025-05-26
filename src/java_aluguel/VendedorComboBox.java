/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel;

/**
 *
 * @author vitor
 */
public class VendedorComboBox {
    private String nome;
    
    public VendedorComboBox(String nome)
    {
        this.nome = nome;
    }
    public String getNome()
    {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
        //return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}

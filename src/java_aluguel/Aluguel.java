/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_aluguel;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.List;
import java_aluguel.controllers.TbAluguelJpaController;
import java_aluguel.controllers.TbClienteJpaController;
import java_aluguel.controllers.TbProdutoJpaController;
import java_aluguel.entities.TbAluguel;
import java_aluguel.entities.TbCliente;
import java_aluguel.entities.TbProduto;
import java_aluguel.entities.TbVendedor;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Date;
import java.text.ParseException;
import java_aluguel.controllers.TbVendedorJpaController;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;



/**
 *
 * @author vitor
 */


public class Aluguel extends javax.swing.JFrame {
//Fazendo a conexão com o banco via JPA
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Java_AluguelPU2");
    TbAluguelJpaController controller = new TbAluguelJpaController(factory);
    private EntityManagerFactory emf;
    private TbProdutoJpaController produtoController;
    /**
     * Creates new form Aluguel
     */
     
    public Aluguel() {
        initComponents();
         emf = Persistence.createEntityManagerFactory("Java_AluguelPU2"); // Substitua "SeuPU" pelo nome correto do persistence.xml
        produtoController = new TbProdutoJpaController(emf);
        abrirConexao();
        atualizarTabela();
        limpar();
       
    }

   
/*#################################################################################################################### */
    
//Abrindo a conexão e fazendo o tratamento de erro caso não ocorra a conexão
private void abrirConexao()
{
    try{
        controller = new TbAluguelJpaController(factory);
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
}
}

/*#################################################################################################################### */

//Função limpar
   private void limpar()
    {
        jTextField1.setText("");
        jTextField19.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField13.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        JComboBox1.setSelectedItem(null);
        jComboBox3.setSelectedItem(null);
        jComboBox2.setSelectedItem(null);
        jComboBox6.setSelectedItem(null);
        jComboBox5.setSelectedItem(null);
        jComboBox4.setSelectedItem(null);
        atualizarTabela();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        JComboBox1.requestFocus();
    }
   
/*#################################################################################################################### */
   
 //novo código de atualizarTabela() para puxar os dados do banco utilizando o JPA
public void atualizarTabela()
{
     ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
     try{
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
         
         TbClienteJpaController clienteController = new TbClienteJpaController(Persistence.createEntityManagerFactory("Java_AluguelPU2"));
         TbProdutoJpaController produtoController = new TbProdutoJpaController(Persistence.createEntityManagerFactory("Java_AluguelPU2"));
         
         List<TbAluguel> alugueis = controller.findTbAluguelEntities();
       
         for(TbAluguel aluguel : alugueis)
         {
         TbCliente cliente = clienteController.findTbCliente(aluguel.getCliCodigo());
         TbProduto produto = produtoController.findTbProduto(aluguel.getProCodigo());
             String linha[] = {
             String.valueOf(aluguel.getAluCodigo()),
             cliente.getCliNome(),//Relacionamento entre Aluguel e Produto
             cliente.getCliTelefone(),//Relacionamento entre Aluguel e Cliente
             cliente.getCliCpf(),//Relacionamento entre Aluguel e Cliente
             sdf.format(aluguel.getAluDataInicial()), //Corrije a formatação de data para: dd/mm/aaaa
             sdf.format(aluguel.getAluDataFinal()), //Corrije a formatação de data para: dd/mm/aaaa
             String.valueOf(produto.getProCodigo()),//Relacionamento entre Aluguel e produto
             produto.getProDescricao(), //Relacionamento entre Aluguel e Produto 
             String.valueOf(aluguel.getAluQtde()),
             nf.format(aluguel.getAluValor()),
             nf.format(aluguel.getAluValorSinal()),
             nf.format(aluguel.getAluRestaPagar()),
             String.valueOf(aluguel.getAluPagoTotal()),
             aluguel.getAluTipoPagamento(),
             aluguel.getVenNome(),
             aluguel.getAluObservacao(),
             aluguel.getAluStatus()
         };
          ((DefaultTableModel) jTable1.getModel()).addRow(linha);
         }
     }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField19 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        JComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "CPF", "Data inicial", "Data final", "ProdutoID", "Descrição", "Quantidade", "Valor", "Valor sinal", "Resta pagar", "Pago total", "Tipo pgto", "Vendedor(a)", "Observação", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jTextField1.setEnabled(false);

        jLabel3.setText("Data inicial:");

        jLabel4.setText("Data final:");

        jLabel5.setText("Produto ID:");

        jTextField6.setEnabled(false);

        jLabel6.setText("Valor do produto:");

        jLabel7.setText("Valor sinal:");

        jTextField8.setEnabled(false);

        jLabel8.setText("Resta pagar:");

        jLabel10.setText("Pago total:");

        jLabel11.setText("Tipo pgto:");

        jLabel12.setText("Observação:");

        jLabel13.setText("Vendedor(a):");

        jLabel14.setText("Status:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Clique duas vezes no cadastro do alugel para editar suas informações");

        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel18.setText("Novo aluguel:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Selecione uma Data Inicial e uma Data final para verificar os produtos locados:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID do produto:", "Foto", "Descrição do produto:", "Quantidade em estoque:", "Quantidade locados:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel20.setText("Data inicial:");

        jLabel21.setText("Data final:");

        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel22.setText("Quantidade:");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOCADO", "RESERVADO" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DÉBITO", "CRÉDITO 1X", "CRÉDITO 2X", "CRÉDITO 3X", "CRÉDITO 4X", "CRÉDITO 5X", "CRÉDITO 6X", "PIX", "LINK" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        jButton8.setText("Novo contrato");
        jButton8.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(jComboBox3, 0, 140, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addComponent(jLabel21)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(174, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel22)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6)
                                .addComponent(jButton8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*#################################################################################################################### */
    
//Função para realizar o INSERT de informações
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       try{
           //Obtendo o CLIENTE selecionado
           ClienteComboBox clienteItem = (ClienteComboBox) JComboBox1.getSelectedItem();
           int clienteID = clienteItem.getCodigo();
           
           //Obtendo o PRODUTO selecionado
           ProdutoComboBox produtoItem = (ProdutoComboBox) jComboBox3.getSelectedItem();
           int produtoID = produtoItem.getCodigo();
           
           //Obtendo o VENDEDOR selecionado
           String vendedorNome = jComboBox2.getSelectedItem().toString();
           
           //Obtendo as DATAS selecionadas
           Date dataInicio = jDateChooser1.getDate();
           Date dataFinal = jDateChooser2.getDate();
           
           //Obtendo os campos de valores NUMÉRICOS
           int quantidade = Integer.parseInt(jTextField19.getText());
           BigDecimal valor = new BigDecimal(jTextField6.getText().replace(",", "."));
           BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
           BigDecimal valorSinal = new BigDecimal(jTextField7.getText().replace(",", "."));
           BigDecimal restaPagar = valorTotal.subtract(valorSinal);
           String pagoTotal = jComboBox6.getSelectedItem().toString();
           String tipoPagamento = jComboBox5.getSelectedItem().toString();
           String observacao = jTextField13.getText();
           String status = jComboBox4.getSelectedItem().toString();
          /*if(clienteItem.equals("") || dataInicio.equals("") || dataFinal.equals("") || produtoItem.equals("") || quantidade.equals("") ||
                  valor.equals("") || valorSinal.equals("") || restaPagar.equals("") || pagoTotal.equals("") || tipoPagamento.equals("") || observacao.equals("") ||
                  vendedoNome.equals("") || status.equals("")){
              throw new Exception("Preeencha todos os campos!");
          }*/
           //Construindo Aluguel
           TbAluguel aluguel = new TbAluguel();
           aluguel.setCliCodigo(clienteItem.getCodigo());
           aluguel.setProCodigo(produtoItem.getCodigo());
           aluguel.setAluDataInicial(dataInicio);
           aluguel.setAluDataFinal(dataFinal);
           aluguel.setAluQtde(quantidade);
           aluguel.setAluValor(valorTotal);
           aluguel.setAluValorSinal(valorSinal);
           aluguel.setAluRestaPagar(restaPagar);
           aluguel.setAluPagoTotal(pagoTotal);
           aluguel.setAluTipoPagamento(tipoPagamento);
           aluguel.setAluObservacao(observacao);
           aluguel.setVenNome(vendedorNome);
           aluguel.setAluStatus(status);
          
           //Salvar os dados no banco
          controller.create(aluguel);
          limpar();
          JOptionPane.showMessageDialog(this, "Aluguel salvo com sucesso!");
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

/*#################################################################################################################### */
    
    //Função para declarar a tela Inicial para o botão "Voltar"
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       Inicial inicial = new Inicial();
       inicial.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


/*#################################################################################################################### */
    //Função para carregar os clientes cadastrados na base de dados no forms
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     carregarCliente();
     carregarVendedor();
     carregarProduto();
    }//GEN-LAST:event_formWindowOpened

/*#################################################################################################################### */
    //Função específica do botão para retornar o limpar();
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpar();
    }//GEN-LAST:event_jButton4ActionPerformed
    
/*#################################################################################################################### */
    
    //Função para pegar as informações de uma ROW da jTable através do duplo clique
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount() == 2)
        {
            try{
            int i = jTable1.getSelectedRow();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = formato.parse(jTable1.getValueAt(i, 4).toString());
            jDateChooser1.setDate(dataInicio);
            Date dataFinal = formato.parse(jTable1.getValueAt(i, 5).toString());
            jDateChooser2.setDate(dataFinal);
            jTextField1.setText(jTable1.getValueAt(i, 0).toString());
            jTextField19.setText(jTable1.getValueAt(i, 8).toString());
            jTextField6.setText(jTable1.getValueAt(i, 9).toString());
            jTextField7.setText(jTable1.getValueAt(i, 10).toString());
            jTextField8.setText(jTable1.getValueAt(i, 11).toString());
            jTextField13.setText(jTable1.getValueAt(i, 15).toString());
            
            //Pegar o texto do select de nome através do duplo clique na Jtable
            String clienteNome = jTable1.getValueAt(i, 1).toString();
            for(int j = 0; j < JComboBox1.getItemCount(); j++)
            {
                ClienteComboBox item = JComboBox1.getItemAt(j);
                if(item.getNome().equals(clienteNome))
                {
                    JComboBox1.setSelectedIndex(j);
                    break;
                }
            }
            
            //Pegar o texto do select de produto atraves do duplo clique na jTable
            String produtoDescricao = jTable1.getValueAt(i, 7).toString();
            for(int j = 0; j < jComboBox3.getItemCount(); j++)
            {
            ProdutoComboBox item = jComboBox3.getItemAt(j);
             if(item.getDescricao().equals(produtoDescricao))
                {
                    jComboBox3.setSelectedIndex(j);
                    break;
                }
            }
            
            //Pega o texto do select de Vendedor através do duplo clique na jTable
            String vendedorNome = jTable1.getValueAt(i, 14).toString();
            for(int j = 0; j < jComboBox2.getItemCount(); j++)
            {
            VendedorComboBox item = jComboBox2.getItemAt(j);
             if(item.getNome().equals(vendedorNome))
                {
                   jComboBox2.setSelectedIndex(j);
                    break;
                }
            }
            //Pega o texto do select de Pago Total através do duplo clique na jTable
            String pagoTotal = jTable1.getValueAt(i, 12).toString();
            jComboBox6.setSelectedItem(pagoTotal);
            //Pega o texto do select de tipo de pagamento através do duplo clique na jTable
            String tipoPgto = jTable1.getValueAt(i, 13).toString();
            jComboBox5.setSelectedItem(tipoPgto);
            //Pega o texto do select de status através do duplo clique na jTable
            String status = jTable1.getValueAt(i, 16).toString();
            jComboBox4.setSelectedItem(status);
            
            
            //Carregando a foto do produto com o duplo clique  na jTable
            ProdutoComboBox produtoItem = (ProdutoComboBox) jComboBox3.getSelectedItem();
            int produtoID = produtoItem.getCodigo();
            
            TbProduto produto = produtoController.findProduto(produtoID);
            
            if(produto != null && produto.getProFoto() != null)
            {
                
                String imagemNome = produto.getProFoto();
                if(imagemNome.startsWith("fotos/"))
                {
                    imagemNome = imagemNome.substring(6);
                }
                 String caminhoImagem = "fotos/" + imagemNome;
                 
                 File imagemArquivo = new File(caminhoImagem);
                 
                 if(imagemArquivo.exists()){
                     ImageIcon icon = new ImageIcon(caminhoImagem);
                         Image imagem = icon.getImage().getScaledInstance(
            jLabel17.getWidth(),
            jLabel17.getHeight(),
            Image.SCALE_SMOOTH
           );
            jLabel17.setIcon(new ImageIcon(imagem));
                 }else{
                     jLabel17.setIcon(null);
                     System.err.println("Imagem não encontrada: " + imagemArquivo.getAbsolutePath());
                 }
            }else{
               jLabel17.setIcon(null);
               System.err.println("Produto ou imagem não encontrados");
            }
            
            jButton1.setEnabled(false);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            
             }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
       }
    }//GEN-LAST:event_jTable1MouseClicked
    
/*#################################################################################################################### */

    //Botão de Buscar na JTable1
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
       String cliNome = jTextField16.getText();
       boolean encontrou = false;
       try{
           if(cliNome.equals(""))
           {
                throw new Exception("Preencha o campo antes de realizar a pesquisa!");
           }
           int n = ((DefaultTableModel) jTable1.getModel()).getRowCount(); //Pega a contagem de linhas da JTable e aramzena em N
           for(int i = 0; i < n; i++)
           {
               String celula = ((DefaultTableModel) jTable1.getModel()).getValueAt(i, 1).toString();
               if(celula.toLowerCase().contains(cliNome.toLowerCase())) //Método (indexOf()) que mostrará o indice da primeira ocorrência (Substring) da palavra a ser buscada dentro de Celula
               {
                   
                   //Se o index corresponder a algum valor (>=0) preencher os campos do formulário com as informações
                    jTable1.setRowSelectionInterval(i, i);
                    jTextField1.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 0).toString());
                    String clienteNome = jTable1.getValueAt(i, 1).toString();
                    for(int j = 0; j < JComboBox1.getItemCount(); j++)
                    {
                          ClienteComboBox item = JComboBox1.getItemAt(j);
                          if(item.getNome().equals(clienteNome))
                           {
                                JComboBox1.setSelectedIndex(j);
                                break;
                     }
                  }
                    
                    //Pega o texto dos campos de Data inicial e data final
                     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                     Date dataInicio = formato.parse(jTable1.getValueAt(i, 4).toString());
                     jDateChooser1.setDate(dataInicio);
                     Date dataFinal = formato.parse(jTable1.getValueAt(i, 5).toString());
                     jDateChooser2.setDate(dataFinal);
                     
                     //Pega o texto do select de Produto
                     String produtoDescricao = jTable1.getValueAt(i, 7).toString();
                    for(int j = 0; j < jComboBox3.getItemCount(); j++)
                    {
                          ProdutoComboBox item = jComboBox3.getItemAt(j);
                          if(item.getDescricao().equals(produtoDescricao))
                           {
                                 jComboBox3.setSelectedIndex(j);
                                 break;
                            }
                         }
                     jTextField19.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 8).toString());
                     jTextField6.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 9).toString());
                     jTextField7.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 10).toString());
                     jTextField8.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 11).toString());
                     //Pega o texto do select de Pago Total através do duplo clique na jTable
                     String pagoTotal = jTable1.getValueAt(i, 12).toString();
                     jComboBox6.setSelectedItem(pagoTotal);
                     //Pega o texto do select de tipo de pagamento através do duplo clique na jTable
                     String tipoPgto = jTable1.getValueAt(i, 13).toString();
                     jComboBox5.setSelectedItem(tipoPgto);
                      //Pega o texto do select de Vendedor
                     String vendedorNome = jTable1.getValueAt(i, 14).toString();
                     for(int j = 0; j < jComboBox2.getItemCount(); j++)
                     {
                         VendedorComboBox item = jComboBox2.getItemAt(j);
                         if(item.getNome().equals(vendedorNome))
                     {
                          jComboBox2.setSelectedIndex(j);
                          break;
                     }
                   }
                     jTextField13.setText(((DefaultTableModel) jTable1.getModel()).getValueAt(i, 15).toString());
                    //Pega o texto do select de status
                    String status = jTable1.getValueAt(i, 16).toString();
                    jComboBox4.setSelectedItem(status);
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(true);
                    jButton1.setEnabled(false);
                    encontrou = true;
                  break;
               }
           }
            if(!encontrou){
               limpar();
               throw new Exception("Nome do cliente não encontrado!");
           }
       }catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton6ActionPerformed
/*#################################################################################################################### */  
    
    //Função para deletar um registro
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      String aluCodigo = jTextField1.getText();  //Instanciar um novo objeto ID do tipo String para realizar a exclusão diretamente pelo código
       try{
           if(JOptionPane.showConfirmDialog(this, "Deseja realmente remover o aluguel de ID: " + aluCodigo + " ?") == JOptionPane.OK_OPTION)
           {
               controller.destroy(Integer.parseInt(aluCodigo));
               JOptionPane.showMessageDialog(this, "Aluguel de ID: " + aluCodigo + " removido com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
           }
           limpar();        
       }catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

/*#################################################################################################################### */
    
    //Função para EDITAR as informações
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try{
            int aluguelID = Integer.parseInt(jTextField1.getText());
            
            // Buscar o aluguel existente
             TbAluguel aluguel = controller.findAluguel(aluguelID);
             if(aluguel == null){
                 throw new Exception("Aluguel com ID: " + aluguelID + " não encontrado.");
             }
           //Obtendo o CLIENTE selecionado
           ClienteComboBox clienteItem = (ClienteComboBox) JComboBox1.getSelectedItem();
           int clienteID = clienteItem.getCodigo();
           
           //Obtendo o PRODUTO selecionado
           ProdutoComboBox produtoItem = (ProdutoComboBox) jComboBox3.getSelectedItem();
           int produtoID = produtoItem.getCodigo();
           
           //Obtendo o VENDEDOR selecionado
           String vendedorNome = jComboBox2.getSelectedItem().toString();
           
           //Obtendo as DATAS selecionadas
           Date dataInicio = jDateChooser1.getDate();
           Date dataFinal = jDateChooser2.getDate();
           
           
           //Obtendo os campos de valores NUMÉRICOS
           int quantidade = Integer.parseInt(jTextField19.getText());
           BigDecimal valor = new BigDecimal(jTextField6.getText().replace(",", "."));
           BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
           BigDecimal valorSinal = new BigDecimal(jTextField7.getText().replace(",", "."));
           BigDecimal restaPagar = valorTotal.subtract(valorSinal);
           String pagoTotal = jComboBox6.getSelectedItem().toString();
           String tipoPagamento = jComboBox5.getSelectedItem().toString();
           String observacao = jTextField13.getText();
           String status = jComboBox4.getSelectedItem().toString();
          /*if(clienteItem.equals("") || dataInicio.equals("") || dataFinal.equals("") || produtoItem.equals("") || quantidade.equals("") ||
                  valor.equals("") || valorSinal.equals("") || restaPagar.equals("") || pagoTotal.equals("") || tipoPagamento.equals("") || observacao.equals("") ||
                  vendedoNome.equals("") || status.equals("")){
              throw new Exception("Preeencha todos os campos!");
          }*/
           //Construindo Aluguel
          
           aluguel.setCliCodigo(clienteItem.getCodigo());
           aluguel.setProCodigo(produtoItem.getCodigo());
           aluguel.setAluDataInicial(dataInicio);
           aluguel.setAluDataFinal(dataFinal);
           aluguel.setAluQtde(quantidade);
           aluguel.setAluValor(valorTotal);
           aluguel.setAluValorSinal(valorSinal);
           aluguel.setAluRestaPagar(restaPagar);
           aluguel.setAluPagoTotal(pagoTotal);
           aluguel.setAluTipoPagamento(tipoPagamento);
           aluguel.setAluObservacao(observacao);
           aluguel.setVenNome(vendedorNome);
           aluguel.setAluStatus(status);
          
           //Salvar os dados no banco
          controller.edit(aluguel);
          limpar();
          JOptionPane.showMessageDialog(this, "Aluguel salvo com sucesso!");
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(this, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
       }
       
    }//GEN-LAST:event_jButton2ActionPerformed
/*#################################################################################################################### */  
    
    //Função para mostrar o valor real do produto ao ser selecionando pela combobox
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        try {
        ProdutoComboBox produtoSelecionado = (ProdutoComboBox) jComboBox3.getSelectedItem();
        if (produtoSelecionado != null) {
            TbProduto produto = produtoController.findProduto(produtoSelecionado.getCodigo());
            if (produto != null) {
                jTextField6.setText(produto.getProValor().toString());
                // Se quiser formatar para R$:
                // jTextField6.setText("R$ " + String.format("%.2f", produto.getProValor()));
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao buscar produto: " + e.getMessage());
    }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void atualizarTabelaEntreDatas(List<Object[]> resultados)
    {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        for(Object[] row : resultados)
        {
            Integer proCodigo = (Integer) row[0];
            String proFoto = (String) row[1];
            String proDescricao = (String) row[2];
            Integer proQtde = (Integer) row[3];
            BigDecimal qtdeLocado = (BigDecimal) row[4];
            
            //Convertendo o camino relativo da foto para imagem
            ImageIcon imagem = new ImageIcon(proFoto);
            Image img = imagem.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon imagemRedimensionada = new ImageIcon(img);
            
            model.addRow(new Object[]{
               proCodigo,
                imagemRedimensionada,
                proDescricao,
                proQtde,
                qtdeLocado
            });
        }
    }
    
 /*#################################################################################################################### */ 
    
    //Função para realizar a busca por duas datas INICIAL E FINAL
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
            Date dataInicio = jDateChooser3.getDate();
            Date dataFinal = jDateChooser4.getDate();
            //System.out.println("Data Início: " + dataInicio);
            //System.out.println("Data Final: " + dataFinal);
            //Chamada do método na controller
            List<Object[]> resultados = produtoController.buscarEntreDatas(dataInicio, dataFinal);
            //System.out.println("Total de linhas retornadas: " + resultados.size());
            atualizarTabelaEntreDatas(resultados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
/*#################################################################################################################### */  
    
//Função para carregar os clientes no input de Nome usando a classe auxiliar
    private void carregarCliente()
    {
        TbClienteJpaController clienteController = new TbClienteJpaController(Persistence.createEntityManagerFactory("Java_AluguelPU2"));
        List<TbCliente> listaClientes = clienteController.findTbClienteEntities();
        JComboBox1.removeAllItems();
        JComboBox1.addItem(new ClienteComboBox(0, "Selecione..."));
        for(TbCliente cliente : listaClientes)
        {
            JComboBox1.addItem(new ClienteComboBox(cliente.getCliCodigo(), cliente.getCliNome()));
        }
    }
    
/*#################################################################################################################### */
    
    //Função para carregar os Vendedores no input de Nome usando a classe auxiliar
    public void carregarVendedor()
    {
        TbVendedorJpaController vendedorController = new TbVendedorJpaController(Persistence.createEntityManagerFactory("Java_AluguelPU2"));
        List<TbVendedor> listaVendedor = vendedorController.findTbVendedorEntities();
        jComboBox2.removeAllItems();
        jComboBox2.addItem(new VendedorComboBox("Selecione..."));
        for(TbVendedor vendedor : listaVendedor)
        {
            jComboBox2.addItem(new VendedorComboBox(vendedor.getVenNome()));
        }
    }
    
/*#################################################################################################################### */
    
    //Função para carregar as Descrições dos produtos no ComboBox usando a classe auxiliar
    public void carregarProduto()
    {
            TbProdutoJpaController produtoController = new TbProdutoJpaController(Persistence.createEntityManagerFactory("Java_AluguelPU2"));
            List<TbProduto> listaProduto = produtoController.findTbProdutoEntities();
            jComboBox3.removeAllItems();
            jComboBox3.addItem(new ProdutoComboBox(0, "Selecione..."));
            for(TbProduto produto : listaProduto)
            {
                jComboBox3.addItem(new ProdutoComboBox(produto.getProCodigo(), produto.getProDescricao()));
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aluguel().setVisible(true);
            }
        });
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ClienteComboBox> JComboBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<VendedorComboBox> jComboBox2;
    private javax.swing.JComboBox<ProdutoComboBox> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}

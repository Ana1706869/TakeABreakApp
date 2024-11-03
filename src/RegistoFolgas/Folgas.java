/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegistoFolgas;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author anasi
 */
public class Folgas extends javax.swing.JFrame {
     private static Connection con;
     private static final String driver="org.sqlite.JDBC";
     private static final String url="jdbc:sqlite:data/AgendamentoFolgas.db";
     private static  PreparedStatement statement=null;
    private static   ResultSet resultSet;
     private final int pageSize = 30;
    private int currentPage = 1;
    private int totalRows = 20;
     private String nomeUsuario=null;
    private static final double[] ESPECIALISTAS = {
        1807.04, 2023.89, 2240.74, 2457.57, 2674.43, 2893.81, 3114.98, 3336.16, 3557.35, 3723.24, 3889.10
    };
    private static final double[] TECNICOS = {
        1070.19, 1280.72, 1438.62, 1596.52, 1754.41, 1915.46, 2078.11, 2240.74, 2403.37, 2566.01, 2674.43
    };
    private static final String GESTOR="Rui Vilaça";
    
    
     
     public void connector() {
    con=null;
    try{
        
       
        Class.forName(driver);
        con=(Connection)DriverManager.getConnection(url);
        if(con!=null){
            
        }
    }
    catch (ClassNotFoundException |SQLException e){

        JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
     

  
   
   
    
    
    public Folgas(JLabel jLabelNome, JLabel jLabelFuncionario) {
        
       this.jLabelNome=jLabelNome;
       this.jLabelFuncionario=jLabelFuncionario;
       initComponents();
       
       jPanelPedidoFolgas.setVisible(true);
       jPanelFolgasAprovadasGestorRH.setVisible(true);
       listarFolgasGestor(currentPage);
       listarFolgasFuncionarios(currentPage); 
       
       connector();
       //String nome=jLabelNome.getText().trim();
       //System.out.println("Quem está a aceder à aplicação é"+nome);
       //aplicarPrivilegios(nome);
       
       
       
       
       
       
    
       
       
        
    

    
}
    
    /*public void atualizarLabels2(){
        
    Login login=new Login(new javax.swing.JFrame(), true);
       String email = login.getJFormattedTextFieldUtilizador().getText().trim();
    String senha = String.valueOf(login.getJPasswordField().getPassword());

    // Consulta SQL para buscar o usuário com base no email e na senha
    String sql = "SELECT Nome FROM Funcionário WHERE Email = ? AND Password = ?";

    try {
        // Preparar a consulta
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);

        // Executar a consulta
        ResultSet resultSet = statement.executeQuery();

        // Verificar se o usuário foi encontrado
        if (resultSet.next()){ 
            String nomeUsuario=resultSet.getString("Nome");
            atualizarLabels(nomeUsuario);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao autenticar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }finally{
        try{
            resultSet.close();
            statement.close();
            con.close();
        }catch(Exception e){
            
        }
    }
    }*/
   public void aplicarPrivilegios(String nome){
       
       if(isGestor(nome)){
           jTabPedidoFolgas.setVisible(false);
           jTabFolgasAprovadas.setVisible(false);
           jTabFolgasAprovadasGestorRH.setVisible(false);
           jPanelFolgasAprovadasGestorRH.setVisible(true);
           jPanelPedidoFolgas.setVisible(false);
    
       }else{
           jTabFolgasAprovadasGestorRH.setVisible(false);
            
       }
   }
   
    private boolean isGestor(String nome){
        return GESTOR.equals(nome);
    }
    
    
       
       
       
       
        
         
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanelPedidoFolgas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxMotivos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButtonSubmeter = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jDateChooserDataInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFim = new com.toedter.calendar.JDateChooser();
        jLabelFuncionario = new javax.swing.JLabel();
        jPanelFolgasAprovadasGestorRH = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanelPaginacao = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        jButtonÚltimo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonSeguinte = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFolgasAprovadasGestor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFuncionario = new javax.swing.JTextField();
        jButtonPesquisarDepartamento = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxDepartamento = new javax.swing.JComboBox<>();
        jButtonPesquisarFuncionario = new javax.swing.JButton();
        jPanelFolgasAprovadasFuncionario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFolgasAprovadasFuncionario = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonPesquisarDataInicio = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButtonPesquisarDataFim = new javax.swing.JButton();
        jLabelFuncionario2 = new javax.swing.JLabel();
        jPanelPaginacao1 = new javax.swing.JPanel();
        jButtonAnterior1 = new javax.swing.JButton();
        jButtonÚltimo1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonSeguinte1 = new javax.swing.JButton();
        jDateChooserDataInicioPesquisar = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFimPesquisar = new com.toedter.calendar.JDateChooser();
        jTabPedidoFolgas = new javax.swing.JPanel();
        jLabelPedidoFolgas = new javax.swing.JLabel();
        jTabFolgasAprovadasGestorRH = new javax.swing.JPanel();
        jLabelFolgasAprovadasGestorRH = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabLogout = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jTabFolgasAprovadas = new javax.swing.JPanel();
        jLabelFolgasAprovadas = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Take a Break!");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setText("Funcionário:");

        jLabel5.setText("Data de Início:");

        jLabel6.setText("Data de Fim:");

        jLabel7.setText("Motivo:");

        jComboBoxMotivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doença", "Doença com regime de proteção pela Segurança Social", "Férias", "Falecimento de cônjuge", "Falecimento de avós", "Falecimento de pais", "Falecimento de filhos", "Falecimento de irmãos", "Licença de casamento", "Licença de maternidade", "Licença de paternidade", "Assistência à família", "Assistência a filho", "Assistência a filho deficiente ou com doença crónica", " ", " ", " " }));
        jComboBoxMotivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMotivosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Pedido de Ausências");

        jButtonSubmeter.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSubmeter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSubmeter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSubmeter.setText("Submeter");
        jButtonSubmeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmeterActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("* Campos de preenchimento obrigatório ");

        javax.swing.GroupLayout jPanelPedidoFolgasLayout = new javax.swing.GroupLayout(jPanelPedidoFolgas);
        jPanelPedidoFolgas.setLayout(jPanelPedidoFolgasLayout);
        jPanelPedidoFolgasLayout.setHorizontalGroup(
            jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBoxMotivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButtonSubmeter))
                            .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPedidoFolgasLayout.createSequentialGroup()
                                    .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooserDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(6876, Short.MAX_VALUE))
        );
        jPanelPedidoFolgasLayout.setVerticalGroup(
            jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel17))
                    .addComponent(jDateChooserDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxMotivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanelPedidoFolgasLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButtonSubmeter)))
                .addGap(89, 89, 89)
                .addComponent(jLabel22)
                .addContainerGap(1550, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Ausências Aprovadas");

        jButtonAnterior.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAnterior.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAnterior.setText("Anterior");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonÚltimo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonÚltimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonÚltimo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonÚltimo.setText("Último");
        jButtonÚltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonÚltimoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonSeguinte.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSeguinte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSeguinte.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeguinte.setText("Seguinte");
        jButtonSeguinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeguinteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPaginacaoLayout = new javax.swing.GroupLayout(jPanelPaginacao);
        jPanelPaginacao.setLayout(jPanelPaginacaoLayout);
        jPanelPaginacaoLayout.setHorizontalGroup(
            jPanelPaginacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginacaoLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSeguinte)
                .addGap(18, 18, 18)
                .addComponent(jButtonÚltimo)
                .addGap(228, 228, 228))
        );
        jPanelPaginacaoLayout.setVerticalGroup(
            jPanelPaginacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginacaoLayout.createSequentialGroup()
                .addGroup(jPanelPaginacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPaginacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnterior)
                        .addComponent(jButtonÚltimo)
                        .addComponent(jButtonSeguinte))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 56, Short.MAX_VALUE))
        );

        jTableFolgasAprovadasGestor.setAutoCreateRowSorter(true);
        jTableFolgasAprovadasGestor.setBackground(new java.awt.Color(153, 153, 153));
        jTableFolgasAprovadasGestor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableFolgasAprovadasGestor.setForeground(new java.awt.Color(255, 255, 255));
        jTableFolgasAprovadasGestor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableFolgasAprovadasGestor.setCellSelectionEnabled(true);
        jTableFolgasAprovadasGestor.setShowHorizontalLines(true);
        jTableFolgasAprovadasGestor.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTableFolgasAprovadasGestor);

        jLabel3.setText("Funcionário");

        jTextFieldFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFuncionarioActionPerformed(evt);
            }
        });
        jTextFieldFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFuncionarioKeyTyped(evt);
            }
        });

        jButtonPesquisarDepartamento.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPesquisarDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPesquisarDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPesquisarDepartamento.setText("Pesquisar");
        jButtonPesquisarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDepartamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Departamento:");

        jComboBoxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Todos)", "Administração de Sistemas", "Administração de Infra-estrutura de Rede", "Manutenção de Equipamento e Serviços", "Suporte aos Utilizadores", "Desenvolvimento e Implementação de Novos Projetos" }));
        jComboBoxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoActionPerformed(evt);
            }
        });

        jButtonPesquisarFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPesquisarFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPesquisarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPesquisarFuncionario.setText("Pesquisar");
        jButtonPesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFolgasAprovadasGestorRHLayout = new javax.swing.GroupLayout(jPanelFolgasAprovadasGestorRH);
        jPanelFolgasAprovadasGestorRH.setLayout(jPanelFolgasAprovadasGestorRHLayout);
        jPanelFolgasAprovadasGestorRHLayout.setHorizontalGroup(
            jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolgasAprovadasGestorRHLayout.createSequentialGroup()
                .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFolgasAprovadasGestorRHLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFolgasAprovadasGestorRHLayout.createSequentialGroup()
                                .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelFolgasAprovadasGestorRHLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPesquisarDepartamento)
                            .addComponent(jButtonPesquisarFuncionario)))
                    .addComponent(jPanelPaginacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2133, Short.MAX_VALUE))
        );
        jPanelFolgasAprovadasGestorRHLayout.setVerticalGroup(
            jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolgasAprovadasGestorRHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarFuncionario))
                .addGap(34, 34, 34)
                .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanelFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPesquisarDepartamento)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPaginacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2317, Short.MAX_VALUE))
        );

        jTableFolgasAprovadasFuncionario.setAutoCreateRowSorter(true);
        jTableFolgasAprovadasFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        jTableFolgasAprovadasFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableFolgasAprovadasFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        jTableFolgasAprovadasFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableFolgasAprovadasFuncionario.setCellSelectionEnabled(true);
        jTableFolgasAprovadasFuncionario.setShowHorizontalLines(true);
        jTableFolgasAprovadasFuncionario.setShowVerticalLines(true);
        jScrollPane3.setViewportView(jTableFolgasAprovadasFuncionario);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Ausências Aprovadas ");

        jLabel11.setText("Data de Início");

        jButtonPesquisarDataInicio.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPesquisarDataInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPesquisarDataInicio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPesquisarDataInicio.setText("Pesquisar");
        jButtonPesquisarDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDataInicioActionPerformed(evt);
            }
        });

        jLabel12.setText("Data de Pedido");

        jButtonPesquisarDataFim.setBackground(new java.awt.Color(153, 153, 153));
        jButtonPesquisarDataFim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPesquisarDataFim.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPesquisarDataFim.setText("Pesquisar");
        jButtonPesquisarDataFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDataFimActionPerformed(evt);
            }
        });

        jLabelFuncionario2.setText("jLabel20");

        jButtonAnterior1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAnterior1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAnterior1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAnterior1.setText("Anterior");
        jButtonAnterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnterior1ActionPerformed(evt);
            }
        });

        jButtonÚltimo1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonÚltimo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonÚltimo1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonÚltimo1.setText("Último");
        jButtonÚltimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonÚltimo1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonSeguinte1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSeguinte1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSeguinte1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeguinte1.setText("Seguinte");
        jButtonSeguinte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeguinte1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPaginacao1Layout = new javax.swing.GroupLayout(jPanelPaginacao1);
        jPanelPaginacao1.setLayout(jPanelPaginacao1Layout);
        jPanelPaginacao1Layout.setHorizontalGroup(
            jPanelPaginacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginacao1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAnterior1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSeguinte1)
                .addGap(18, 18, 18)
                .addComponent(jButtonÚltimo1)
                .addGap(228, 228, 228))
        );
        jPanelPaginacao1Layout.setVerticalGroup(
            jPanelPaginacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaginacao1Layout.createSequentialGroup()
                .addGroup(jPanelPaginacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPaginacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnterior1)
                        .addComponent(jButtonÚltimo1)
                        .addComponent(jButtonSeguinte1))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFolgasAprovadasFuncionarioLayout = new javax.swing.GroupLayout(jPanelFolgasAprovadasFuncionario);
        jPanelFolgasAprovadasFuncionario.setLayout(jPanelFolgasAprovadasFuncionarioLayout);
        jPanelFolgasAprovadasFuncionarioLayout.setHorizontalGroup(
            jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabelFuncionario2))
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserDataInicioPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jDateChooserDataFimPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonPesquisarDataInicio)
                            .addComponent(jButtonPesquisarDataFim)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanelPaginacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15291, Short.MAX_VALUE))
        );
        jPanelFolgasAprovadasFuncionarioLayout.setVerticalGroup(
            jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabelFuncionario2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jButtonPesquisarDataInicio)))
                    .addComponent(jDateChooserDataInicioPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFolgasAprovadasFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jButtonPesquisarDataFim))
                    .addComponent(jDateChooserDataFimPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelPaginacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2850, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPedidoFolgas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFolgasAprovadasGestorRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelFolgasAprovadasFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5146, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFolgasAprovadasGestorRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFolgasAprovadasFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanelPedidoFolgas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(635, Short.MAX_VALUE))
        );

        jTabPedidoFolgas.setBackground(new java.awt.Color(153, 153, 153));
        jTabPedidoFolgas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabPedidoFolgasMouseClicked(evt);
            }
        });

        jLabelPedidoFolgas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelPedidoFolgas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPedidoFolgas.setText("Pedido de Ausências");

        javax.swing.GroupLayout jTabPedidoFolgasLayout = new javax.swing.GroupLayout(jTabPedidoFolgas);
        jTabPedidoFolgas.setLayout(jTabPedidoFolgasLayout);
        jTabPedidoFolgasLayout.setHorizontalGroup(
            jTabPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabPedidoFolgasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelPedidoFolgas, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabPedidoFolgasLayout.setVerticalGroup(
            jTabPedidoFolgasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTabPedidoFolgasLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabelPedidoFolgas)
                .addContainerGap())
        );

        jTabFolgasAprovadasGestorRH.setBackground(new java.awt.Color(153, 153, 153));
        jTabFolgasAprovadasGestorRH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabFolgasAprovadasGestorRHMouseClicked(evt);
            }
        });

        jLabelFolgasAprovadasGestorRH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFolgasAprovadasGestorRH.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFolgasAprovadasGestorRH.setText("Ausências Aprovadas ");

        javax.swing.GroupLayout jTabFolgasAprovadasGestorRHLayout = new javax.swing.GroupLayout(jTabFolgasAprovadasGestorRH);
        jTabFolgasAprovadasGestorRH.setLayout(jTabFolgasAprovadasGestorRHLayout);
        jTabFolgasAprovadasGestorRHLayout.setHorizontalGroup(
            jTabFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabFolgasAprovadasGestorRHLayout.createSequentialGroup()
                .addComponent(jLabelFolgasAprovadasGestorRH, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jTabFolgasAprovadasGestorRHLayout.setVerticalGroup(
            jTabFolgasAprovadasGestorRHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabFolgasAprovadasGestorRHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelFolgasAprovadasGestorRH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Take a Break!");

        jTabLogout.setBackground(new java.awt.Color(153, 153, 153));
        jTabLogout.setForeground(new java.awt.Color(255, 255, 255));
        jTabLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTabLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabLogoutMouseClicked(evt);
            }
        });

        jLabelLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setText("Logout");

        javax.swing.GroupLayout jTabLogoutLayout = new javax.swing.GroupLayout(jTabLogout);
        jTabLogout.setLayout(jTabLogoutLayout);
        jTabLogoutLayout.setHorizontalGroup(
            jTabLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabLogoutLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabelLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );
        jTabLogoutLayout.setVerticalGroup(
            jTabLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabFolgasAprovadas.setBackground(new java.awt.Color(153, 153, 153));
        jTabFolgasAprovadas.setForeground(new java.awt.Color(255, 255, 255));
        jTabFolgasAprovadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTabFolgasAprovadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabFolgasAprovadasMouseClicked(evt);
            }
        });

        jLabelFolgasAprovadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFolgasAprovadas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFolgasAprovadas.setText("Ausências Aprovadas ");
        jLabelFolgasAprovadas.setToolTipText("");

        javax.swing.GroupLayout jTabFolgasAprovadasLayout = new javax.swing.GroupLayout(jTabFolgasAprovadas);
        jTabFolgasAprovadas.setLayout(jTabFolgasAprovadasLayout);
        jTabFolgasAprovadasLayout.setHorizontalGroup(
            jTabFolgasAprovadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabFolgasAprovadasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelFolgasAprovadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jTabFolgasAprovadasLayout.setVerticalGroup(
            jTabFolgasAprovadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTabFolgasAprovadasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelFolgasAprovadas)
                .addContainerGap())
        );

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabPedidoFolgas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTabLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabFolgasAprovadas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabFolgasAprovadasGestorRH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jTabPedidoFolgas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jTabFolgasAprovadasGestorRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jTabFolgasAprovadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jTabLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void jTabPedidoFolgasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabPedidoFolgasMouseClicked

        jPanelPedidoFolgas.setVisible(true);
        jPanelFolgasAprovadasGestorRH.setVisible(false);
        jPanelFolgasAprovadasFuncionario.setVisible(false);
        
        
        
    }//GEN-LAST:event_jTabPedidoFolgasMouseClicked

    private void jTabFolgasAprovadasGestorRHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabFolgasAprovadasGestorRHMouseClicked
        
        jPanelPedidoFolgas.setVisible(false);
        jPanelFolgasAprovadasGestorRH.setVisible(true);
        jPanelFolgasAprovadasFuncionario.setVisible(false);
        //listarFolgasGestor(currentPage);
    }//GEN-LAST:event_jTabFolgasAprovadasGestorRHMouseClicked

    private void jComboBoxMotivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMotivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMotivosActionPerformed

    private void jComboBoxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDepartamentoActionPerformed

    private void jButtonSubmeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmeterActionPerformed
     
    
    
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
    
    
    
    
    
   
    
    
    Date dataInicio=jDateChooserDataInicio.getDate();
    String dataInicioString=sdf.format(dataInicio);
    
    
    Date dataFim=jDateChooserDataFim.getDate();
    String dataFimString=sdf.format(dataFim);
    System.out.println("Data de fim"+dataFimString);
    
    int row=jTableFolgasAprovadasFuncionario.getSelectedRow();
    int folgaId=-1;
    if(row !=-1){
                    String nome=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,0);
                    String dataPedido=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,1);
                    String estado=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 2);
                     dataInicioString=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,3);
                     dataFimString=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 4);
                    String motivo=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 5);
                    Double remuneracao=(Double)jTableFolgasAprovadasFuncionario.getValueAt(row, 6);
                    
                    System.out.println("Nome"+nome);
                    System.out.println("Data do Pedido"+dataPedido);
                    System.out.println("Estado"+estado);
                    System.out.println("DataInicio"+dataInicioString);
                    System.out.println("DataFim"+dataFimString);
                    System.out.println("Motivo"+motivo);
                    System.out.println("Remuneração"+remuneracao);
                    
                     folgaId=obterFolgaId(nome,dataPedido,estado,dataInicioString,dataFimString,motivo,remuneracao);
    }       
                    
    
    
    System.out.println("FolgaId"+folgaId);
       
 
    Date dataAtual=new Date();
    
        System.out.println("Data inicio: "+dataInicio.toString());
        System.out.println("Data fim: "+dataFim.toString());
        System.out.println("Data atual: "+dataAtual.toString());
    
    if(dataInicio==null||dataFim==null){
        JOptionPane.showMessageDialog(this,"Por favor, insira as datas de Início e Fim","Erro",JOptionPane.ERROR_MESSAGE);
        
    }
    else if(dataFim.compareTo(dataInicio)<0){
        JOptionPane.showMessageDialog(this,"A Data de Fim deve ser maior ou igual à Data de Início","Erro",JOptionPane.ERROR_MESSAGE);
    }
//    else if(dataInicio.compareTo(dataAtual)<0){
    else if(dataInicio.compareTo(dataInicio)<0){
        JOptionPane.showMessageDialog(this, "A data de início introduzida tem de ser superior ou igual à data atual","Erro",JOptionPane.ERROR_MESSAGE);
    }
    else if(dataFim.compareTo(dataAtual)<0){
        JOptionPane.showMessageDialog(this, "A data de fim introduzida tem de ser superior ou igual à data atual","Erro",JOptionPane.ERROR_MESSAGE);
    }
    else
        //Decide se deve criar ou atualizar com base no folgaId)
        if (folgaId==-1){
        
                InserirDadosBaseDados();
                
        } else{
            
            atualizarFolga(folgaId);
        }
    
           limparCampos();             
        
    }//GEN-LAST:event_jButtonSubmeterActionPerformed

    private void jTabFolgasAprovadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabFolgasAprovadasMouseClicked
        jPanelPedidoFolgas.setVisible(false);
        jPanelFolgasAprovadasGestorRH.setVisible(false);
        jPanelFolgasAprovadasFuncionario.setVisible(true);
        listarFolgasFuncionarios(currentPage);
    }//GEN-LAST:event_jTabFolgasAprovadasMouseClicked

    private void jButtonPesquisarDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDataInicioActionPerformed
        Date dataInicio=jDateChooserDataInicioPesquisar.getDate();
        
        if (dataInicio!=null){
            int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
            System.out.println("FuncionárioId"+funcionarioId);
            System.out.println("Texto da jLabelNome"+jLabelNome.getText());
            listarFolgasFuncionarioDataInicio(currentPage,dataInicio,funcionarioId);
        }else{
            listarFolgasFuncionarios(currentPage);
        }
    }//GEN-LAST:event_jButtonPesquisarDataInicioActionPerformed

    private void jButtonPesquisarDataFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDataFimActionPerformed
       Date dataPedido=jDateChooserDataFimPesquisar.getDate();
        
        if (dataPedido!=null){
            int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
            System.out.println("FuncionárioId"+funcionarioId);
            System.out.println("Texto da jLabelNome"+jLabelNome.getText());
            listarFolgasFuncionarioDataPedido(currentPage,dataPedido,funcionarioId);
        }else{
            listarFolgasFuncionarios(currentPage);
        }
    }//GEN-LAST:event_jButtonPesquisarDataFimActionPerformed

    private void jButtonPesquisarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDepartamentoActionPerformed
       String departamento=jComboBoxDepartamento.getSelectedItem().toString();
            if(departamento.equals("(Todos)"))
            {
            listarFolgasGestor(currentPage);
        }
            else{
                listarFolgasGestorDepartamento(departamento,currentPage);
            }
    }//GEN-LAST:event_jButtonPesquisarDepartamentoActionPerformed

    private void jButtonPesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarFuncionarioActionPerformed
   String funcionario=jTextFieldFuncionario.getText().trim();
            if(funcionario.isEmpty())
            {
            listarFolgasGestor(currentPage);
        }
            else{
                listarFolgasGestorFuncionarios(funcionario,currentPage);
            }
    }//GEN-LAST:event_jButtonPesquisarFuncionarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
       
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFuncionarioActionPerformed

    private void jTextFieldFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioKeyTyped
       char c = evt.getKeyChar();
                // Verificar se o caractere digitado é uma letra ou espaço
                if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)) {
                    // Se não for uma letra ou espaço, impedir que seja digitado
                    evt.consume();
                }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFuncionarioKeyTyped

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
         if (currentPage > 1) {
            currentPage--;
            String departamento=jComboBoxDepartamento.getSelectedItem().toString();
            if(departamento.equals("(Todos)"))
            {
            listarFolgasGestor(currentPage);
        }
            else{
                listarFolgasGestorDepartamento(departamento,currentPage);
            }
            String funcionario=jTextFieldFuncionario.getText().trim();
            if(funcionario.isEmpty()){
                listarFolgasGestor(currentPage);
            }else{
                listarFolgasGestorFuncionarios(funcionario,currentPage);
            }
            }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonÚltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonÚltimoActionPerformed
        int totalPages = (int) Math.ceil((double) totalRows / pageSize);
            listarFolgasGestor(totalPages);
            String departamento=jComboBoxDepartamento.getSelectedItem().toString();
            if(departamento.equals("(Nenhum)"))
            {
            listarFolgasGestor(totalPages);
        }
            else{
                listarFolgasGestorDepartamento(departamento,totalPages);
            }
            String funcionario=jTextFieldFuncionario.getText().trim();
            if(funcionario.isEmpty()){
                listarFolgasGestor(totalPages);
            }else{
                listarFolgasGestorFuncionarios(funcionario,totalPages);
            }
        
        
    }//GEN-LAST:event_jButtonÚltimoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            String departamento=jComboBoxDepartamento.getSelectedItem().toString();
            if(departamento.equals("(Nenhum)"))
            {
            listarFolgasGestor(1);
        }
            else{
                listarFolgasGestorDepartamento(departamento,1);
            }
            String funcionario=jTextFieldFuncionario.getText().trim();
            if(funcionario.isEmpty()){
                listarFolgasGestor(1);
            }else{
                listarFolgasGestorFuncionarios(funcionario,1);
            }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonSeguinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeguinteActionPerformed
         int totalPages = (int) Math.ceil((double) totalRows / pageSize);
        if (currentPage < totalPages) {
            currentPage++;
            String departamento=jComboBoxDepartamento.getSelectedItem().toString();
            if(departamento.equals("(Nenhum)"))
            {
            listarFolgasGestor(currentPage);
        }
            else{
                listarFolgasGestorDepartamento(departamento,currentPage);
            }
            String funcionario=jTextFieldFuncionario.getText().trim();
            if(funcionario.isEmpty()){
                listarFolgasGestor(currentPage);
            }else{
                listarFolgasGestorFuncionarios(funcionario,currentPage);
            }
            }
        
    }//GEN-LAST:event_jButtonSeguinteActionPerformed

    private void jButtonAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnterior1ActionPerformed
if (currentPage > 1) {
            currentPage--;
            Date dataInicio=jDateChooserDataInicioPesquisar.getDate();
            Date dataPedido=jDateChooserDataFimPesquisar.getDate();
            int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
            if(dataInicio==null)
            {
            listarFolgasFuncionarios(currentPage);
        }
            else{
                listarFolgasFuncionarioDataInicio(currentPage,dataInicio,funcionarioId);
            }
            
            if(dataPedido==null){
                listarFolgasFuncionarios(currentPage);
            }else{
                listarFolgasFuncionarioDataPedido(currentPage,dataPedido,funcionarioId);
            }
            }
      
    }//GEN-LAST:event_jButtonAnterior1ActionPerformed

    private void jButtonÚltimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonÚltimo1ActionPerformed
        int totalPages = (int) Math.ceil((double) totalRows / pageSize);
        Date dataInicio=jDateChooserDataInicio.getDate();
        Date dataPedido=jDateChooserDataFim.getDate();
        int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
        
            if(dataInicio==null)
            {
            listarFolgasFuncionarios(totalPages);
        }
            else{
                listarFolgasFuncionarioDataInicio(totalPages,dataInicio,funcionarioId);
            }
           
            if(dataPedido==null){
                listarFolgasFuncionarios(totalPages);
            }else{
                listarFolgasFuncionarioDataPedido(totalPages,dataPedido,funcionarioId);
            }
        
        
    }//GEN-LAST:event_jButtonÚltimo1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date dataInicio=jDateChooserDataInicio.getDate();
        Date dataPedido=jDateChooserDataFim.getDate();
        int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
            if(dataInicio==null)
            {
            listarFolgasFuncionarios(1);
        }
            else{
                listarFolgasFuncionarioDataInicio(1, dataInicio,funcionarioId);
            }
            
            if(dataPedido==null){
                listarFolgasFuncionarios(1);
            }else{
                listarFolgasFuncionarioDataPedido(1,dataPedido,funcionarioId);
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSeguinte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeguinte1ActionPerformed
        int totalPages = (int) Math.ceil((double) totalRows / pageSize);
        Date dataInicio=jDateChooserDataInicio.getDate();
        Date dataPedido=jDateChooserDataFim.getDate();
        int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
        
        if (currentPage < totalPages) {
            currentPage++;
      
            if(dataInicio==null)
            {
            listarFolgasFuncionarios(currentPage);
        }
            else{
                listarFolgasFuncionarioDataInicio(currentPage,dataInicio,funcionarioId);
            }
            
            if(dataPedido==null){
                listarFolgasFuncionarios(currentPage);
            }else{
                listarFolgasFuncionarioDataPedido(currentPage,dataPedido, funcionarioId);
            }
            }
        
                                                  

    }//GEN-LAST:event_jButtonSeguinte1ActionPerformed

    private void jTabLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabLogoutMouseClicked
        dispose();
        Login login = new Login(new javax.swing.JFrame(), true);
        login.setVisible(true);
    }//GEN-LAST:event_jTabLogoutMouseClicked

    
    private void listarFolgasGestor(int page) {
        String departamento=jComboBoxDepartamento.getSelectedItem().toString();
        if(!departamento.equals("(Todos)")){
            return;
        }
        
        
        String colunas[] = { "Nome", "Data de Pedido","Estado", "Data de Início", "Data de Fim", "Motivo", "Remuneração (euros)"};
         
        try {
            this.connector();
            String sql = "SELECT COUNT(*) FROM Folgas WHERE Estado = 'Aprovada'";
            PreparedStatement countStatement = con.prepareStatement(sql);
            ResultSet resultSetCount = countStatement.executeQuery();
            if (resultSetCount.next()) {
                totalRows = resultSetCount.getInt(1);
            }
            int totalPages=(int)Math.ceil((double)totalRows/pageSize);
            int offset = (page - 1) * pageSize;
            sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao " +
                    "FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId = Func.FuncionarioId " +
                    "WHERE F.Estado = 'Aprovada' LIMIT ? OFFSET ?";
            PreparedStatement statementAprovada = con.prepareStatement(sql);
            statementAprovada.setInt(1, pageSize);
            statementAprovada.setInt(2, offset);
            ResultSet resultSetAprovada = statementAprovada.executeQuery();
            
            DefaultTableModel model=new DefaultTableModel(colunas,0){
                public Class<?>getColumnClass(int columnIndex){
                    switch (columnIndex){
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                     return String.class;
                        case 6:
                     return Double.class;
                        default:return Object.class;
                    }
                }
            };


            while (resultSetAprovada.next()) {
                String nomeFuncionario = resultSetAprovada.getString("Nome");
                String dataPedido = resultSetAprovada.getString("DataPedido");
                String estado = resultSetAprovada.getString("Estado");
                String dataInicio = resultSetAprovada.getString("DataInicio");
                String dataFim = resultSetAprovada.getString("DataFim");
                String motivo = resultSetAprovada.getString("Motivo");
                double remuneracao = resultSetAprovada.getDouble("Remuneracao");
                model.addRow(new Object[]{nomeFuncionario, dataPedido, estado, dataInicio, dataFim, motivo, remuneracao});
            }
            jTableFolgasAprovadasGestor.setModel(model);

            resultSetAprovada.close();
            statementAprovada.close();
            resultSetCount.close();
            countStatement.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void listarFolgasGestorDepartamento(String departamento,int page){
    
    try {
    // Conectar ao banco de dados
    this.connector();

    // Consulta para obter as folgas aprovadas com detalhes do funcionário do departamento selecionado
    String sql="SELECT COUNT(*)FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"            WHERE F.Estado='Aprovada' AND Func.Departamento=?";
    
    PreparedStatement countStatement=con.prepareStatement(sql);
    
    countStatement.setString(1, departamento);
    ResultSet resultSetCount=countStatement.executeQuery();
    if(resultSetCount.next()){
        totalRows=resultSetCount.getInt(1);
    }
    int totalPages=(int)Math.ceil((double)totalRows/pageSize);
    int offset=(page-1)*pageSize;
    
    
     sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao" +
"                 FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"                 WHERE F.Estado ='Aprovada' AND Func.Departamento=? LIMIT ? OFFSET ?";
    
    PreparedStatement statementAprovada = con.prepareStatement(sql);
    statementAprovada.setString(1, departamento);
    statementAprovada.setInt(2, pageSize);
    statementAprovada.setInt(3, offset);
    ResultSet resultSetAprovada = statementAprovada.executeQuery();

    // Limpar as linhas existentes no modelo de tabela
    DefaultTableModel model = (DefaultTableModel) jTableFolgasAprovadasGestor.getModel();
    model.setRowCount(0);

    // Adicionar as linhas retornadas ao modelo de tabela
    while (resultSetAprovada.next()) {
        String nomeFuncionario = resultSetAprovada.getString("Nome");
        String dataPedido = resultSetAprovada.getString("DataPedido");
        String estado = resultSetAprovada.getString("Estado");
        String dataInicio = resultSetAprovada.getString("DataInicio");
        String dataFim = resultSetAprovada.getString("DataFim");
        String motivo = resultSetAprovada.getString("Motivo");
        double remuneracao = resultSetAprovada.getDouble("Remuneracao");

        model.addRow(new Object[]{ nomeFuncionario, dataPedido, estado, dataInicio, dataFim, motivo, remuneracao });
    }

    // Fechar recursos
    resultSetAprovada.close();
    statementAprovada.close();
    con.close();

    // Atualizar a tabela para exibir as alterações
    model.fireTableDataChanged();

} catch (SQLException e) {
    e.printStackTrace();
}

    }
    
    
    
    private void listarFolgasGestorFuncionarios(String funcionario,int page){
        try {
    // Conectar ao banco de dados
    this.connector();

    // Consulta para obter as folgas aprovadas com detalhes do funcionário do departamento selecionado
    String sql="SELECT COUNT(*)FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"            WHERE F.Estado='Aprovada' AND Func.Nome=?";
    
    PreparedStatement countStatement=con.prepareStatement(sql);
    
    countStatement.setString(1, funcionario);
    ResultSet resultSetCount=countStatement.executeQuery();
    if(resultSetCount.next()){
        totalRows=resultSetCount.getInt(1);
    }
    int totalPages=(int)Math.ceil((double)totalRows/pageSize);
    int offset=(page-1)*pageSize;
    
    
     sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao" +
"                 FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"                 WHERE F.Estado ='Aprovada' AND Func.Nome=? LIMIT ? OFFSET ?";
    
    PreparedStatement statementAprovada = con.prepareStatement(sql);
    statementAprovada.setString(1, funcionario);
    statementAprovada.setInt(2, pageSize);
    statementAprovada.setInt(3, offset);
    ResultSet resultSetAprovada = statementAprovada.executeQuery();

    // Limpar as linhas existentes no modelo de tabela
    DefaultTableModel model = (DefaultTableModel) jTableFolgasAprovadasGestor.getModel();
    model.setRowCount(0);

    // Adicionar as linhas retornadas ao modelo de tabela
    while (resultSetAprovada.next()) {
        String nomeFuncionario = resultSetAprovada.getString("Nome");
        String dataPedido = resultSetAprovada.getString("DataPedido");
        String estado = resultSetAprovada.getString("Estado");
        String dataInicio = resultSetAprovada.getString("DataInicio");
        String dataFim = resultSetAprovada.getString("DataFim");
        String motivo = resultSetAprovada.getString("Motivo");
        double remuneracao = resultSetAprovada.getDouble("Remuneracao");

        model.addRow(new Object[]{ nomeFuncionario, dataPedido, estado, dataInicio, dataFim, motivo, remuneracao });
    }

    // Fechar recursos
    resultSetAprovada.close();
    statementAprovada.close();
    //con.close();

    // Atualizar a tabela para exibir as alterações
    model.fireTableDataChanged();

} catch (SQLException e) {
    e.printStackTrace();
}

        
    }
    
    
    
    public void listarFolgasFuncionarios(int page) {
    String colunas1[] = { "Nome", "Data de Pedido", "Estado", "Data de Início", "Data de Fim", "Motivo", "Remuneração (euros)", "Alterar", "Eliminar" };
    ArrayList<Object[]> linhas1 = new ArrayList<>();

    String nomeFuncionario = jLabelNome.getText().trim(); // Obtém o nome do funcionário da label
    int idFuncionario = obterFuncionarioId(nomeFuncionario);

    if (idFuncionario != -1) {
        try {
            this.connector();
            System.out.println("Nome:" + nomeFuncionario);
            System.out.println("FuncionárioId encontrado:" + idFuncionario);
            System.out.println("Texto da jLabelNome:" + jLabelNome.getText());

            // Contar o número total de folgas
            String sql = "SELECT COUNT(*) FROM Folgas WHERE Estado = 'Aprovada' AND FuncionarioId = ?";
            PreparedStatement countFuncionariosStatement = con.prepareStatement(sql);
            countFuncionariosStatement.setInt(1, idFuncionario);
            ResultSet resultSetCountFuncionarios = countFuncionariosStatement.executeQuery();
            int totalRows = 0;
            if (resultSetCountFuncionarios.next()) {
                totalRows = resultSetCountFuncionarios.getInt(1);
            }
            resultSetCountFuncionarios.close();
            countFuncionariosStatement.close();

            int totalPages = (int) Math.ceil((double) totalRows / pageSize);
            int offset = (page - 1) * pageSize;

            // Selecionar as folgas com base na página
            sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao " +
                    "FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId = Func.FuncionarioId " +
                    "WHERE F.Estado = 'Aprovada' AND Func.FuncionarioId = ? LIMIT ? OFFSET ?";
            PreparedStatement statementFuncionario = con.prepareStatement(sql);
            statementFuncionario.setInt(1, idFuncionario);
            statementFuncionario.setInt(2, pageSize);
            statementFuncionario.setInt(3, offset);
            ResultSet resultSetFuncionario = statementFuncionario.executeQuery();

            DefaultTableModel model1 = new DefaultTableModel(colunas1, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch (columnIndex) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            return String.class;
                        case 6:
                            return Double.class;
                        default:
                            return JButton.class;
                    }
                }
            };

            // Adicionar linhas ao modelo
            while (resultSetFuncionario.next()) {
                String nome = resultSetFuncionario.getString("Nome");
                String dataPedido = resultSetFuncionario.getString("DataPedido");
                String estado = resultSetFuncionario.getString("Estado");
                String dataInicio = resultSetFuncionario.getString("DataInicio");
                String dataFim = resultSetFuncionario.getString("DataFim");
                String motivo = resultSetFuncionario.getString("Motivo");
                double remuneracao = resultSetFuncionario.getDouble("Remuneracao");
                model1.addRow(new Object[]{nome, dataPedido, estado, dataInicio, dataFim, motivo, remuneracao});
            }

            jTableFolgasAprovadasFuncionario.setModel(model1);

            // Configurar a coluna de botões
            jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(8).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
                JButton button = new JButton("Eliminar");
                button.setOpaque(true);
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
                button.setFont(button.getFont().deriveFont(Font.BOLD));
                return button;
            });

            jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(7).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
                JButton button = new JButton("Alterar");
                button.setOpaque(true);
                button.setBackground(new Color(0, 128, 0));
                button.setForeground(Color.WHITE);
                button.setFont(button.getFont().deriveFont(Font.BOLD));
                button.addActionListener(e -> {
                
                    
                    //AprovacaoRejeicao aprovacaoRejeicao = new AprovacaoRejeicao(new javax.swing.JFrame(), true);
                    //aprovacaoRejeicao.setVisible(true);
                    
                });
                return button;
            });

            // Configurar ações dos botões
            jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new JCheckBox()));
            jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(new JCheckBox()));

            ((JCheckBox) jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(7).getCellEditor().getTableCellEditorComponent(jTableFolgasAprovadasFuncionario, "Alterar", true, 0, 0))
                    .addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row=jTableFolgasAprovadasFuncionario.getSelectedRow();
                    String nome=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,0);
                    String dataPedido=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,1);
                    String estado=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 2);
                    String dataInicio=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,3);
                    String dataFim=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 4);
                    String motivo=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 5);
                    Double remuneracao=(Double)jTableFolgasAprovadasFuncionario.getValueAt(row, 6);
                    
                    int folgaId=obterFolgaId(nome,dataPedido,estado,dataInicio,dataFim,motivo,remuneracao);
                            
                    preencherCampos(folgaId );
                    
                }
            });

            ((JCheckBox) jTableFolgasAprovadasFuncionario.getColumnModel().getColumn(8).getCellEditor().getTableCellEditorComponent(jTableFolgasAprovadasFuncionario, "Eliminar", true, 0, 0))
                    .addActionListener(e -> {
                     int row=jTableFolgasAprovadasFuncionario.getSelectedRow();
                    String nome=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,0);
                    String dataPedido=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,1);
                    String estado=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 2);
                    String dataInicio=(String)jTableFolgasAprovadasFuncionario.getValueAt(row,3);
                    String dataFim=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 4);
                    String motivo=(String)jTableFolgasAprovadasFuncionario.getValueAt(row, 5);
                    Double remuneracao=(Double)jTableFolgasAprovadasFuncionario.getValueAt(row, 6);
                    
                    int folgaId=obterFolgaId(nome,dataPedido,estado,dataInicio,dataFim,motivo,remuneracao);
                    
                    preencherCampos(folgaId);
                    
                    //Configurar o texto dos botões do jOptionPane
                    UIManager.put("OptionPane.yesButtonText","Sim");
                    UIManager.put("OptionPane.noButtonText","Não");
                    
                    
                    int confirmar=JOptionPane.showConfirmDialog(this,"Tem a certeza que quer eliminar o pedido de ausência?","Confirmação",JOptionPane.YES_NO_OPTION);
                    if(confirmar==JOptionPane.YES_OPTION){
                        eliminarFolga(folgaId);
                        
                    }
                        limparCampos();
                    });

            resultSetFuncionario.close();
            statementFuncionario.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("FuncionárioId não encontrado");
    }
}
    
    private int obterFolgaId(String nome, String dataPedido, String estado, String dataInicio, String dataFim, String motivo, Double remuneracao){
        int folgaId=-1;
        try{
        this.connector();
        String sql="SELECT F.FolgaId FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId "+
        "WHERE Func.Nome=? AND F.DataPedido=? AND F.Estado=? AND F.DataInicio=?"+
       " AND F.DataFim=? AND F.Motivo=?"+
        "AND Remuneracao=?";
                
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2=new SimpleDateFormat ("dd-MM-yyyy");
        
    PreparedStatement folgaIdStatement=con.prepareStatement(sql);
    
    folgaIdStatement.setString(1, nome);
    folgaIdStatement.setString(2, dataPedido);
    folgaIdStatement.setString(3, estado);
    folgaIdStatement.setString(4, dataInicio);
    folgaIdStatement.setString(5, dataFim);
    folgaIdStatement.setString(6, motivo);
    folgaIdStatement.setDouble(7,remuneracao);
    
    ResultSet resultSetFolgaId=folgaIdStatement.executeQuery();
    if(resultSetFolgaId.next()){
        folgaId=resultSetFolgaId.getInt("FolgaId");
        System.out.println("FolgaId encontrada"+folgaId);
        abrirInterfacePedidoFolga(nome, dataPedido, estado, dataInicio, dataFim, motivo,remuneracao);
    } else{
        System.out.println("FolgaId não encontrada");
    }
    

    // Fechar recursos
    resultSetFolgaId.close();
    folgaIdStatement.close();
    
    

    

} catch (SQLException e) {
    e.printStackTrace();
    
    System.out.println("Erro ao encontrar folgaId");
}
        return folgaId;
}     
    
    private void abrirInterfacePedidoFolga(String nome, String dataPedido, String estado,String dataInicio, String dataFim, String motivo, Double remuneracao){
        jPanelPedidoFolgas.setVisible(true);
       
    }
    
    private void preencherCampos(int folgaId) {
    
    
    if (folgaId != -1) { // Corrigido para verificar -1, que indica "não encontrado"
        try {
           this.connector(); // Assegure-se de que este método inicializa a conexão corretamente
            String sql = "SELECT DataInicio, DataFim, Motivo FROM Folgas WHERE FolgaId=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, folgaId);
            
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Certifique-se de que o formato está correto
               try {
                   jDateChooserDataInicio.setDate(sdf.parse(rs.getString("DataInicio")));
               } catch (ParseException ex) {
                   Logger.getLogger(Folgas.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   jDateChooserDataFim.setDate(sdf.parse(rs.getString("DataFim")));
               } catch (ParseException ex) {
                   Logger.getLogger(Folgas.class.getName()).log(Level.SEVERE, null, ex);
               }
                jComboBoxMotivos.setSelectedItem(rs.getString("Motivo"));
            } else {
                System.out.println("Folga não encontrada com os critérios fornecidos");
            }
            rs.close();
            pstm.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao preencher campos: " + e.getMessage());
        
        }
    }
    }
    
    private void atualizarFolga(int folgaId) {
       
        
        if(folgaId!=-1){
        try {
            this.connector();
            String sql = "UPDATE Folgas SET DataPedido=?, DataInicio = ?, DataFim = ?, Motivo = ?,Remuneracao=? WHERE FolgaId = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
           
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
            
            pstmt.setString(1, sdf2.format(new Date()));
            pstmt.setString(2, sdf.format(jDateChooserDataInicio.getDate()));
            pstmt.setString(3, sdf.format(jDateChooserDataFim.getDate()));
            pstmt.setString(4, (String) jComboBoxMotivos.getSelectedItem());
            pstmt.setDouble(5, 0.00);
            pstmt.setInt(6,folgaId);
            
           

            pstmt.executeUpdate();
           
          JOptionPane.showMessageDialog(this,"Ausência alterada com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
         JOptionPane.showMessageDialog(this, "Erro ao alterar folga!","Erro",JOptionPane.ERROR_MESSAGE);   
        }
    }else{
    JOptionPane.showMessageDialog(this, "Folga não encontrada com os critérios fornecidos", "Erro",JOptionPane.ERROR_MESSAGE);
    }
        agendamento();
    }
                
        private void eliminarFolga (int folgaId){
        try{
            this.connector();
        String sql="DELETE FROM Folgas WHERE FolgaId=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, folgaId);
        
        int rowsAffected=pstmt.executeUpdate();
        if (rowsAffected >0){
    JOptionPane.showMessageDialog(this,"Ausência eliminada com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Nenhuma ausência encontrada para eliminar","Erro",JOptionPane.ERROR_MESSAGE);
        }
            pstmt.close();
            atualizarTabelaFolgas();
        }catch (SQLException e){
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(this,"Erro ao eliminar ausência!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        }
        
        private void atualizarTabelaFolgas(){
            
                
           DefaultTableModel model=(DefaultTableModel)jTableFolgasAprovadasFuncionario.getModel();
           
           //Limpar os dados atuais da tabela
           
           model.setRowCount(0);
           
           //Consulta para buscar todas as folgas
           try{
                this.connector();
           String sql="SELECT Func.Nome,F.DataPedido,F.Estado,F.DataInicio,F.DataFim,F.Motivo,F.Remuneracao FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId";
           PreparedStatement pstmt=con.prepareStatement(sql);
           ResultSet rs=pstmt.executeQuery();
           
           //Preencher o modelo com os dados da consulta
           while(rs.next()){
       
               String nome=rs.getString("Nome");
               String dataPedido=rs.getString("DataPedido");
               String estado=rs.getString("Estado");
               String dataInicio=rs.getString("DataInicio");
               String dataFim=rs.getString("DataFim");
               String motivo=rs.getString("Motivo");
               double remuneracao=rs.getDouble("Remuneracao");
               
               model.addRow(new Object[]{nome, dataPedido, estado, dataInicio, dataFim, motivo,remuneracao});
           }
             rs.close();
             pstmt.close();
             
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela","Erro",JOptionPane.ERROR_MESSAGE);
            }
            
            
            
        }
          
        private void listarFolgasFuncionarioDataInicio(int page,Date dataInicio, int funcionarioId){
        try {
    // Conectar ao banco de dados
    this.connector();

    // Consulta para obter as folgas aprovadas com detalhes do funcionário do departamento selecionado
    String sql="SELECT COUNT(*)FROM Folgas WHERE Estado ='Aprovada' AND FuncionarioId=? AND DataInicio=?";
    PreparedStatement countStatement=con.prepareStatement(sql);
    
    countStatement.setInt(1, funcionarioId);
    
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    String dataInicioString=sdf.format(dataInicio);
    
    
    countStatement.setString(2, dataInicioString);
    
    ResultSet resultSetCount=countStatement.executeQuery();
    if(resultSetCount.next()){
        totalRows=resultSetCount.getInt(1);
    }
    int totalPages=(int)Math.ceil((double)totalRows/pageSize);
    int offset=(page-1)*pageSize;
    
    
     sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao" +
"                 FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"                 WHERE F.Estado ='Aprovada' AND F.FuncionarioId=? AND F.DataInicio=? LIMIT ? OFFSET ?";
    
    PreparedStatement statementAprovada = con.prepareStatement(sql);
    statementAprovada.setInt(1, funcionarioId);
    statementAprovada.setString(2,dataInicioString);
    statementAprovada.setInt(3, pageSize);
    statementAprovada.setInt(4, offset);
    ResultSet resultSetAprovada = statementAprovada.executeQuery();

    // Limpar as linhas existentes no modelo de tabela
    DefaultTableModel model = (DefaultTableModel) jTableFolgasAprovadasFuncionario.getModel();
    model.setRowCount(0);

    // Adicionar as linhas retornadas ao modelo de tabela
    while (resultSetAprovada.next()) {
        String nomeFuncionario = resultSetAprovada.getString("Nome");
        String dataPedido = resultSetAprovada.getString("DataPedido");
        String estado = resultSetAprovada.getString("Estado");
        String dataInicioStr = resultSetAprovada.getString("DataInicio");
        String dataFim = resultSetAprovada.getString("DataFim");
        String motivo = resultSetAprovada.getString("Motivo");
        double remuneracao = resultSetAprovada.getDouble("Remuneracao");

        model.addRow(new Object[]{ nomeFuncionario, dataPedido, estado, dataInicioStr, dataFim, motivo, remuneracao });
    }

    // Fechar recursos
    resultSetAprovada.close();
    statementAprovada.close();
    //con.close();

    // Atualizar a tabela para exibir as alterações
    model.fireTableDataChanged();

} catch (SQLException e) {
    e.printStackTrace();
}
        }
        
        private void listarFolgasFuncionarioDataPedido(int page,Date dataPedido, int funcionarioId){
        try {
    // Conectar ao banco de dados
    this.connector();

    // Consulta para obter as folgas aprovadas com detalhes do funcionário do departamento selecionado
    String sql="SELECT COUNT(*)FROM Folgas WHERE Estado ='Aprovada' AND FuncionarioId=? AND DataPedido=?";
    PreparedStatement countStatement=con.prepareStatement(sql);
    
    countStatement.setInt(1, funcionarioId);
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String dataPedidoString=sdf.format(dataPedido);
    
    
    countStatement.setString(2, dataPedidoString);
    
    ResultSet resultSetCount=countStatement.executeQuery();
    if(resultSetCount.next()){
        totalRows=resultSetCount.getInt(1);
    }
    int totalPages=(int)Math.ceil((double)totalRows/pageSize);
    int offset=(page-1)*pageSize;
    
    
     sql = "SELECT Func.Nome, F.DataPedido, F.Estado, F.DataInicio, F.DataFim, F.Motivo, F.Remuneracao" +
"                 FROM Folgas F INNER JOIN Funcionário Func ON F.FuncionarioId=Func.FuncionarioId" +
"                 WHERE F.Estado ='Aprovada' AND F.FuncionarioId=? AND F.DataPedido=? LIMIT ? OFFSET ?";
    
    PreparedStatement statementAprovada = con.prepareStatement(sql);
    statementAprovada.setInt(1, funcionarioId);
    statementAprovada.setString(2,dataPedidoString);
    statementAprovada.setInt(3, pageSize);
    statementAprovada.setInt(4, offset);
    ResultSet resultSetAprovada = statementAprovada.executeQuery();

    // Limpar as linhas existentes no modelo de tabela
    DefaultTableModel model = (DefaultTableModel) jTableFolgasAprovadasFuncionario.getModel();
    model.setRowCount(0);

    // Adicionar as linhas retornadas ao modelo de tabela
    while (resultSetAprovada.next()) {
        String nomeFuncionario = resultSetAprovada.getString("Nome");
        String dataPedidoStr = resultSetAprovada.getString("DataPedido");
        String estado = resultSetAprovada.getString("Estado");
        String dataInicio = resultSetAprovada.getString("DataInicio");
        String dataFim = resultSetAprovada.getString("DataFim");
        String motivo = resultSetAprovada.getString("Motivo");
        double remuneracao = resultSetAprovada.getDouble("Remuneracao");

        model.addRow(new Object[]{ nomeFuncionario, dataPedidoStr, estado, dataInicio, dataFim, motivo, remuneracao });
    }

    // Fechar recursos
    resultSetAprovada.close();
    statementAprovada.close();
    //con.close();

    // Atualizar a tabela para exibir as alterações
    model.fireTableDataChanged();

} catch (SQLException e) {
    e.printStackTrace();
}
        }
            
        public JLabel getJLabelNome(){
            return jLabelNome;
        } 
 
    
    public void atualizarLabels(String nomeUsuario){
        jLabelNome.setText(nomeUsuario);
        jLabelFuncionario.setText(nomeUsuario);
        jLabelFuncionario2.setText(nomeUsuario);
        String nomeFuncionario = jLabelFuncionario2.getText().trim(); // Obtém o nome do funcionário da label
        int idFuncionario = obterFuncionarioId(nomeFuncionario);
        System.out.println("Nome:"+nomeFuncionario);   
        System.out.println("FuncionárioIdencontrado:"+idFuncionario);
        System.out.println("Texto da jLabelFuncionario2:"+jLabelFuncionario2.getText());
        
    }
    
    
    
    
    
    
    
    public int obterFuncionarioId(String nome) {
    // Consulta SQL para obter o FuncionarioId com base no nome inserido nas labels do Pedido de Folgas
    String sql = "SELECT FuncionarioId FROM Funcionário WHERE Nome = ?";
    try {
        // Preparar a consulta
        this.connector();
        PreparedStatement funcionarioIdStatement = con.prepareStatement(sql);
        funcionarioIdStatement.setString(1, nome);
       
        // Executar a consulta
         ResultSet funcionarioIdResultSet = funcionarioIdStatement.executeQuery();
       
        // Verificar se o FuncionarioId foi encontrado
        if (funcionarioIdResultSet.next()) {
           int funcionarioId=funcionarioIdResultSet.getInt("FuncionarioId");
           System.out.println("Funcionário Id Encontrado"+funcionarioId);
           funcionarioIdResultSet.close();
           funcionarioIdStatement.close();
            return funcionarioId;
        }
         
    } catch (SQLException e) {
        
    
    }
    // Se não encontrar o FuncionarioId, retorna -1
    return -1;
}
    
    
    
    
    private void InserirDadosBaseDados() {
        
                
        int funcionarioId = obterFuncionarioId(jLabelNome.getText().trim());
   
    // Verificar se o FuncionarioId foi recuperado com sucesso
    if (funcionarioId != -1) {
        try {
//            con.setAutoCommit(false);
            this.connector();
            // Obter a data atual
            Date dataAtual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataPedido = sdf.format(dataAtual);
           
           
           
           
           
            // Preparar a instrução SQL para inserir na tabela Folga
            String sql = "INSERT INTO Folgas (FuncionarioId, "
                    + "DataPedido, Estado, DataInicio, DataFim, Motivo, Remuneracao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(sql);
            
           
            // Preencher os parâmetros da consulta com os valores dos campos
            insertStatement.setInt(1, funcionarioId);
            insertStatement.setString(2, dataPedido);
            insertStatement.setString(3, "Pendente"); // Estado inicial
            
             sdf=new SimpleDateFormat("dd-MM-yyyy");
            String dataInicio=sdf.format(jDateChooserDataInicio.getDate());
            
            
             insertStatement.setString(4, dataInicio);
             
             sdf=new SimpleDateFormat("dd-MM-yyyy");
            String dataFim=sdf.format(jDateChooserDataFim.getDate());
            
            insertStatement.setString(5, dataFim);
            insertStatement.setString(6, jComboBoxMotivos.getSelectedItem().toString());
            insertStatement.setDouble(7,0000.00);
           
           
            // Executar a consulta de inserção
            insertStatement.executeUpdate();
            
            insertStatement.close();
            
            //con.commit();
            
           
            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Ausência submetida com sucesso.", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
    
            
            
        } catch (SQLException e) {
//          try{
//                con.rollback();
//            }catch(SQLException rollbackException){
//                rollbackException.printStackTrace();
//            }
            JOptionPane.showMessageDialog(this, "Erro ao inserir folga na base de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } 
    }else {
        // Se não foi possível obter o FuncionarioId, exibir mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao recuperar o ID do funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
        agendamento();
   
}
    private void limparCampos(){
        jDateChooserDataInicio.setDate(null);
        jDateChooserDataFim.setDate(null);
        jComboBoxMotivos.setSelectedItem("Doença");
    }
    
    
    
    
    
    
    private int contarFolgas( Date dataInicio, Date dataFim) {
    int totalFolgas = 0;
   
    try {
        // Conectar ao banco de dados e executar a consulta
        this.connector();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String dataInicioSQLite=sdf.format(dataInicio);
        String dataFimSQLite=sdf.format(dataFim);
        String sql = "SELECT COUNT(*) FROM Folgas WHERE Estado= 'Aprovada' AND DataInicio<=? AND DataFim>=?";
        PreparedStatement countStatement = con.prepareStatement(sql);
        
        
        
        countStatement.setString(1, dataInicioSQLite);
        countStatement.setString(2, dataFimSQLite);
        ResultSet resultSetFolgas=countStatement.executeQuery();
        
       
        // Obter o número de folgas retornadas pela consulta
        if (resultSetFolgas.next()) {
            totalFolgas = resultSetFolgas.getInt(1);
        }
        System.out.println("Data de início"+dataInicio);
        System.out.println("Data de Fim"+dataFim);
        System.out.println("Número de folgas aprovadas"+totalFolgas);
        
         resultSetFolgas.close();
        countStatement.close();
        
       
        
    } catch (SQLException e) {
        // Lidar com exceções
        e.printStackTrace();
    }
   
    return totalFolgas;
    
    }
    
   
     // Calcula a data da Páscoa para um ano
    private Date calcularPascoa(int ano) {
        int a = ano % 19;
        int b = ano / 100;
        int c = ano % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (19 * a + b - d - f + 15) % 30;
        int h = c / 4;
        int i = c % 4;
        int k = (32 + 2 * e + 2 * h - g - i) % 7;
        int l = (a + 11 * g + 22 * k) / 451;
        int m = g + k - 7 * l + 114;
        int dia = m % 31;
        int mes = m / 31;

        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes - 1, dia, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    // Verifica se a data é um feriado fixo
    private boolean isFeriado(Date data, List<Date> feriados) {
        Calendar calData = Calendar.getInstance();
        calData.setTime(data);
        calData.set(Calendar.HOUR_OF_DAY, 0);
        calData.set(Calendar.MINUTE, 0);
        calData.set(Calendar.SECOND, 0);
        calData.set(Calendar.MILLISECOND, 0);

        Calendar calDataSemHora = Calendar.getInstance();
        calDataSemHora.set(calData.get(Calendar.YEAR), calData.get(Calendar.MONTH), calData.get(Calendar.DAY_OF_MONTH));

        return feriados.stream()
                .anyMatch(feriado -> {
                    Calendar calFeriado = Calendar.getInstance();
                    calFeriado.setTime(feriado);
                    calFeriado.set(Calendar.HOUR_OF_DAY, 0);
                    calFeriado.set(Calendar.MINUTE, 0);
                    calFeriado.set(Calendar.SECOND, 0);
                    calFeriado.set(Calendar.MILLISECOND, 0);
                    Calendar calFeriadoSemHora = Calendar.getInstance();
                    calFeriadoSemHora.set(calFeriado.get(Calendar.YEAR), calFeriado.get(Calendar.MONTH), calFeriado.get(Calendar.DAY_OF_MONTH));
                    return calDataSemHora.getTime().equals(calFeriadoSemHora.getTime());
                });
    }

         
    
    // Método para calcular a diferença de dias entre duas datas
private long calcularDiferencaDias(Date dataInicio, Date dataFim) {
    long diferencaMillis = dataFim.getTime() - dataInicio.getTime();
    
    return TimeUnit.DAYS.convert(diferencaMillis, TimeUnit.MILLISECONDS);
}




// Método para calcular a diferença de dias úteis entre duas datas
private long calcularDiferencaDiasUteis(Date dataInicio, Date dataFim) {
    long diasUteis = 0;
    Calendar cal = Calendar.getInstance();
    cal.setTime(dataInicio);
   
    while (cal.getTime().before(dataFim) || cal.getTime().equals(dataFim)) {
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        if (diaSemana != Calendar.SATURDAY && diaSemana != Calendar.SUNDAY) {
            diasUteis++;
        }
        cal.add(Calendar.DAY_OF_MONTH, 1);
    }
   
    return diasUteis;
}

//Contar o número de dias úteis de folgas aprovadas num ano
private int contarDiasUteisFeriasAno(int ano, int funcionarioId, Date dataInicioFiltro, Date dataFimFiltro) {
     int totalDiasUteisFerias = 0;

    try {
        this.connector();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       
        Calendar startOfYear = Calendar.getInstance();
        startOfYear.set(ano, Calendar.JANUARY, 1);
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.set(ano, Calendar.DECEMBER, 31);
        
        int diferencaDias=(int)calcularDiferencaDias(dataInicioFiltro,dataFimFiltro);

        // Ajuste a consulta SQL para filtrar por FuncionarioId e usar o intervalo de datas fornecido
        String sql = "SELECT DataInicio, DataFim FROM Folgas WHERE Estado = 'Aprovada' " +
                     "AND Motivo='Férias'"+
                     "AND FuncionarioId = ? " ;
                     

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, funcionarioId);
        

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Date dataInicio = sdf.parse(rs.getString("DataInicio"));
            Date dataFim = sdf.parse(rs.getString("DataFim"));

            // Calcular a interseção entre a folga e o intervalo de datas fornecido
            Date start = dataInicio.before(dataInicioFiltro) ? dataInicioFiltro : dataInicio;
            Date end = dataFim.after(dataFimFiltro) ? dataFimFiltro : dataFim;

            if (start.before(end)||(start.equals(end))){
                totalDiasUteisFerias += calcularDiferencaDiasUteis(start, end)+diferencaDias;
            System.out.println("Total de dias assistência filho na interseção"+totalDiasUteisFerias);
        
            }else{
                totalDiasUteisFerias=(int)diferencaDias;
                System.out.println("Total de dias assistencia filho"+totalDiasUteisFerias);
            }
            
        }

        rs.close();
        pstmt.close();
    } catch (SQLException | ParseException e) {
        e.printStackTrace();
    }

    return totalDiasUteisFerias;
}


private Date obterDataPedido(int funcionarioId) {
     Date dataPedido = null;
    // Definir o formato da data de acordo com o formato na sua base de dados
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Ajuste o formato conforme necessário

    try {
        this.connector();

        // Definir a consulta SQL
        String sql = "SELECT DataPedido FROM Folgas WHERE FuncionarioId = ? ORDER BY DataPedido DESC LIMIT 1";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, funcionarioId);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String dataPedidoStr = rs.getString("DataPedido");
            if (dataPedidoStr != null) {
                try {
                    dataPedido = sdf.parse(dataPedidoStr);
                } catch (ParseException e) {
                    System.err.println("Erro ao analisar a data do pedido: " + e.getMessage());
                }
            }
        }

        rs.close();
        pstmt.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dataPedido;
}

    
    private Date obterDataAdmissao(int funcionarioId) {
     Date dataAdmissao = null;
    // Definir o formato da data de acordo com o formato na sua base de dados
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Ajuste o formato conforme necessário

    try {
        this.connector();

        // Definir a consulta SQL
        String sql = "SELECT DataAdmissão FROM Funcionário WHERE FuncionarioId = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, funcionarioId);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String dataAdmissaoStr = rs.getString("DataAdmissão");
            if (dataAdmissaoStr != null) {
                try {
                    dataAdmissao = sdf.parse(dataAdmissaoStr);
                } catch (ParseException e) {
                    System.err.println("Erro ao analisar a data de admissão: " + e.getMessage());
                }
            }
        }

        rs.close();
        pstmt.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dataAdmissao;
}

    // Método para calcular o número de dias de férias a que o funcionário tem direito
private int calcularDireitoFerias(Date dataAdmissao, Date dataAtual) {
    Calendar calAdmissao = Calendar.getInstance();
    calAdmissao.setTime(dataAdmissao);
    
    Calendar calAtual = Calendar.getInstance();
    calAtual.setTime(dataAtual);
    
    int meses = (calAtual.get(Calendar.YEAR) - calAdmissao.get(Calendar.YEAR)) * 12 +
                calAtual.get(Calendar.MONTH) - calAdmissao.get(Calendar.MONTH);
    
    return Math.min(20, 2 * meses); // 2 dias por mês, com um máximo de 20 dias
}

    // Verificar se o pedido de férias pode ser aprovado (6 meses após a admissão)
private boolean podeAprovarFerias(Date dataAdmissao, Date dataPedido) {
    Calendar calAdmissao = Calendar.getInstance();
    calAdmissao.setTime(dataAdmissao);
    
    Calendar calPedido = Calendar.getInstance();
    calPedido.setTime(dataPedido);
    
    calAdmissao.add(Calendar.MONTH, 6);
    
    return !calPedido.before(calAdmissao.getTime());
}
    
    private int contarDiasAnoAssistenciaFamilia(int ano, int funcionarioId, Date dataInicioFiltro, Date dataFimFiltro) {
     int totalDiasAssistenciaFamilia = 0;

    try {
        this.connector();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       
        Calendar startOfYear = Calendar.getInstance();
        startOfYear.set(ano, Calendar.JANUARY, 1);
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.set(ano, Calendar.DECEMBER, 31);
        
        int diferencaDias=(int)calcularDiferencaDias(dataInicioFiltro,dataFimFiltro);

        // Ajuste a consulta SQL para filtrar por FuncionarioId e usar o intervalo de datas fornecido
        String sql = "SELECT DataInicio, DataFim FROM Folgas WHERE Estado = 'Aprovada' " +
                     "AND Motivo='Assistência à família'"+
                     "AND FuncionarioId = ? " ;
                     

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, funcionarioId);
        

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Date dataInicio = sdf.parse(rs.getString("DataInicio"));
            Date dataFim = sdf.parse(rs.getString("DataFim"));

            // Calcular a interseção entre a folga e o intervalo de datas fornecido
            Date start = dataInicio.before(dataInicioFiltro) ? dataInicioFiltro : dataInicio;
            Date end = dataFim.after(dataFimFiltro) ? dataFimFiltro : dataFim;

            if (start.before(end)||(start.equals(end))){
                totalDiasAssistenciaFamilia += calcularDiferencaDias(start, end)+diferencaDias;
            System.out.println("Total de dias assistência família na interseção"+totalDiasAssistenciaFamilia);
        
            }else{
                totalDiasAssistenciaFamilia=(int)diferencaDias;
                System.out.println("Total de dias assistencia família"+totalDiasAssistenciaFamilia);
            }
            
        }

        rs.close();
        pstmt.close();
    } catch (SQLException | ParseException e) {
        e.printStackTrace();
    }

    return totalDiasAssistenciaFamilia;
}
   
    
    
    private int contarDiasAnoAssistenciaFilho(int ano, int funcionarioId, Date dataInicioFiltro, Date dataFimFiltro) {
     int totalDiasAssistenciaFilho = 0;

    try {
        this.connector();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       
        Calendar startOfYear = Calendar.getInstance();
        startOfYear.set(ano, Calendar.JANUARY, 1);
        Calendar endOfYear = Calendar.getInstance();
        endOfYear.set(ano, Calendar.DECEMBER, 31);
        
        int diferencaDias=(int)calcularDiferencaDias(dataInicioFiltro,dataFimFiltro);

        // Ajuste a consulta SQL para filtrar por FuncionarioId e usar o intervalo de datas fornecido
        String sql = "SELECT DataInicio, DataFim FROM Folgas WHERE Estado = 'Aprovada' " +
                     "AND Motivo='Assistência a filho'"+
                     "AND FuncionarioId = ? " ;
                     

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, funcionarioId);
        

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Date dataInicio = sdf.parse(rs.getString("DataInicio"));
            Date dataFim = sdf.parse(rs.getString("DataFim"));

            // Calcular a interseção entre a folga e o intervalo de datas fornecido
            Date start = dataInicio.before(dataInicioFiltro) ? dataInicioFiltro : dataInicio;
            Date end = dataFim.after(dataFimFiltro) ? dataFimFiltro : dataFim;

            if (start.before(end)||(start.equals(end))){
                totalDiasAssistenciaFilho += calcularDiferencaDias(start, end)+diferencaDias;
            System.out.println("Total de dias assistência filho na interseção"+totalDiasAssistenciaFilho);
        
            }else{
                totalDiasAssistenciaFilho=(int)diferencaDias;
                System.out.println("Total de dias assistencia filho"+totalDiasAssistenciaFilho);
            }
            
        }

        rs.close();
        pstmt.close();
    } catch (SQLException | ParseException e) {
        e.printStackTrace();
    }

    return totalDiasAssistenciaFilho;
}
    //As faltas para assistência a filho deficiente ou com doença crónica são até 6 meses
    //Este método tem em conta a variação dos dias dos meses
    private LocalDate toLocalDate(Date date){
        return new java.sql.Date(date.getTime()).toLocalDate();
    }
    
    //Calcula a diferença de dias entre duas datas no caso de assistência a filho deficiente ou com doença crónica
    

    // Obter departamento do funcionário
    private String obterDepartamento(int funcionarioId) {
        String departamento = "";
        try {
            this.connector();
            String query = "SELECT Departamento FROM Funcionário WHERE FuncionarioId = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, funcionarioId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                departamento = resultSet.getString("Departamento");
                System.out.println("Departamento="+departamento);
            }else{
                System.out.println("Departamento não encontrado");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }
    
    
    // Obter escalão do funcionário
    private int obterEscalao(int funcionarioId) {
        int escalao = 0;
        try {
            this.connector();
            String query = "SELECT Escalao FROM Funcionário WHERE FuncionarioId = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, funcionarioId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                escalao = resultSet.getInt("Escalao");
                System.out.println("Escalão"+escalao);
            }
            else{
                System.out.println("Escalão não encontrado");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return escalao;
    }
    
    // Obter salário mensal do funcionário
    private double obterSalarioMensal(int funcionarioId) {
        int escalao = obterEscalao(funcionarioId);
        String departamento = obterDepartamento(funcionarioId);

        double[] salarios = null;
        if (departamento.equals("Administração de Sistemas") ||
            departamento.equals("Administração de Infra-estrutura de Rede") ||
            departamento.equals("Desenvolvimento e Implementação de Novos Projetos")) {
            salarios = ESPECIALISTAS;
        } else if (departamento.equals("Manutenção de Equipamentos e Serviços") ||
                   departamento.equals("Suporte aos Utilizadores")) {
            salarios = TECNICOS;
        }

        if (salarios != null && escalao > 0 && escalao <= salarios.length) {
            System.out.println("Salário mensal:"+salarios[escalao-1]);
            return salarios[escalao - 1];
            
        }

        return 0; // Valor padrão em caso de erro
    }
    
    // Calcular a diferença de dias incluindo Data Início
    private long calcularDiferencaDiasDataInicio(Date dataInicio, Date dataFim) {
        long diffInMillies = dataFim.getTime() - dataInicio.getTime();
        System.out.println("Diferença de dias="+(diffInMillies/(1000*60*60*24))+1);
        return (diffInMillies / (1000 * 60 * 60 * 24)) + 1; // +1 para incluir o dia de início
    }
    
    //Calcular o número de dias de um mês para uma data de ausência
    private int obterDiasMes(Calendar calendar){
        
        System.out.println("Número de dias"+calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        
    }
    
    private double calcularSalarioDiario(double salarioMensal, Calendar calendario){
        int diasMes=obterDiasMes(calendario);
        return salarioMensal/diasMes;
    }
    
    //Calcular a remuneração da ausência
    private double calcularRemuneracaoFolga(double salarioMensal, Date dataInicio, Date dataFim){
        Calendar calDataInicio=Calendar.getInstance();
        Calendar calDataFim=Calendar.getInstance();
        calDataInicio.setTime(dataInicio);
        calDataFim.setTime(dataFim);
        
        double remuneracaoTotal=0.00;
        while(calDataInicio.before(calDataFim)|| calDataInicio.equals(calDataFim)){
            double salarioDiario=calcularSalarioDiario(salarioMensal,calDataInicio);
            int diasMes=obterDiasMes(calDataInicio);
            int restantesDiasMes=diasMes-calDataInicio.get(Calendar.DAY_OF_MONTH)+1;
            int diasPeriodoAtual=(int) Math.min(restantesDiasMes, calcularDiferencaDiasDataInicio(calDataInicio.getTime(),calDataFim.getTime()));
            remuneracaoTotal+=salarioDiario*diasPeriodoAtual;
            
            //Avançar para o próximo mês
            calDataInicio.add(Calendar.MONTH,1);
            calDataInicio.set(Calendar.DAY_OF_MONTH,1);
        }
        return remuneracaoTotal;
    
            
            
   
    }
    
    // Atualizar a remuneração da folga na base de dados
    private void atualizarRemuneracaoFolga(int funcionarioId, double remuneracaoFolga, Date dataInicio, Date dataFim) {
        funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
        try {
            this.connector();
            String updateSqlRemuneracao = "UPDATE Folgas SET Remuneracao = ? WHERE FolgaId=(SELECT MAX (FolgaId) FROM Folgas WHERE FuncionarioId = ? AND DataInicio = ? AND DataFim = ?)" ;
            PreparedStatement updateStatementRemuneracao = con.prepareStatement(updateSqlRemuneracao);
            updateStatementRemuneracao.setDouble(1, Math.round(remuneracaoFolga *100.0)/100.0);
            updateStatementRemuneracao.setInt(2, funcionarioId);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String dataInicioString=sdf.format(dataInicio);
            updateStatementRemuneracao.setString(3,dataInicioString);
            
            String dataFimString=sdf.format(dataFim);
            updateStatementRemuneracao.setString(4,dataFimString);
            
            
            int rowsAffected=updateStatementRemuneracao.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Remuneração atualizada com sucesso");
            }
            else{
                System.out.println("Nenhuma remuneração foi atualizada");
            }
            updateStatementRemuneracao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         // Exibir a remuneração da folga para todos os escalões
    private void exibirRemuneracaoFolgaPorEscalao(String departamento, double salarioMensal, Date dataInicio, Date dataFim, String remuneracaoFormatada) {
        double remuneracaoFolga = calcularRemuneracaoFolga(salarioMensal,dataInicio,dataFim);
        
        System.out.println("A sua folga por escalão é"+remuneracaoFolga);
        // Definir mensagem de remuneração
        String mensagem = "A sua ausência será remunerada em " + remuneracaoFormatada + " euros.";

        // Exibir mensagem na jLabelRemuneracao
        ConfirmacaoRemuneracao confirmacao = new ConfirmacaoRemuneracao(new javax.swing.JFrame(), true);
        confirmacao.getJLabelRemuneracao().setText(mensagem);
        confirmacao.setVisible(true);
    }
    
    private boolean atravessarMes (Date dataInicio,Date dataFim){
        Calendar inicioCal=Calendar.getInstance();
        inicioCal.setTime(dataInicio);
        
        Calendar fimCal=Calendar.getInstance();
        fimCal.setTime(dataFim);
        
       boolean atravessaMes= inicioCal.get(Calendar.MONTH)!=fimCal.get(Calendar.MONTH)||inicioCal.get(Calendar.YEAR)!=fimCal.get(Calendar.YEAR);
        System.out.println("Atravessa mês"+atravessaMes);
        return atravessaMes ;
        
    }

    

//Algoritmo para aprovação e rejeição de ausências e cálculo da remuneração
    private void agendamento(){
         
            String motivoSelecionado = jComboBoxMotivos.getSelectedItem().toString();
            Date dataInicio=jDateChooserDataInicio.getDate();
            Date dataFim=jDateChooserDataFim.getDate();
            int funcionarioId=obterFuncionarioId(jLabelNome.getText().trim());
            Date dataPedido=obterDataPedido(funcionarioId);
            String departamento=obterDepartamento(funcionarioId);
            double salarioMensal=obterSalarioMensal(funcionarioId);
            long diasFolga=calcularDiferencaDiasDataInicio(dataInicio,dataFim);
            System.out.println("Dias de folga calculados"+diasFolga);
            double remuneracaoFolga=calcularRemuneracaoFolga(salarioMensal, dataInicio,dataFim);
            long diferencaDiasPedidoInicio=calcularDiferencaDias(dataPedido,dataInicio);
            System.out.println("Diferença de dias entre data de pedido e data de início"+diferencaDiasPedidoInicio);
            int totalDiasUteisFerias =contarDiasUteisFeriasAno (Calendar.getInstance().get(Calendar.YEAR), funcionarioId, dataInicio, dataFim);
            int totalDiasAnoAssistenciaFamilia = contarDiasAnoAssistenciaFamilia(Calendar.getInstance().get(Calendar.YEAR), funcionarioId, dataInicio, dataFim);
            int totalDiasAnoAssistenciaFilho = contarDiasAnoAssistenciaFilho(Calendar.getInstance().get(Calendar.YEAR), funcionarioId, dataInicio, dataFim);
            String estado="Pendente";
            String mensagem="";
            String mensagemRemuneracao="";
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            ConfirmacaoRemuneracao confirmacaoRemuneracao = new ConfirmacaoRemuneracao(new javax.swing.JFrame(), true);
            long diasAssistenciaFilhoDeficiencia=calcularDiferencaDias(dataInicio,dataFim);
            AprovacaoRejeicao aprovacaoRejeicao=new AprovacaoRejeicao(new javax.swing.JFrame(),true);    

            //Em caso de férias
            long diasUteis=calcularDiferencaDiasUteis(dataInicio,dataFim);
            
            //Obter a data de admissão e calcular o direito a férias
            Date dataAdmissao=obterDataAdmissao(funcionarioId);
            int direitoFerias=calcularDireitoFerias(dataAdmissao,new Date());
            
            //Verificar a data de fim para o caso de férias (30 de Abril do ano seguinte)
            Calendar calDataFimEsperada=Calendar.getInstance();
            calDataFimEsperada.setTime(dataInicio);
            calDataFimEsperada.add(Calendar.YEAR,1);
            calDataFimEsperada.set(Calendar.MONTH,Calendar.APRIL);
            calDataFimEsperada.set(Calendar.DAY_OF_MONTH,30);
            Date dataFimEsperada=calDataFimEsperada.getTime();
            boolean dataFimCorreta=dataFim.before(dataFimEsperada)||dataFim.equals(dataFimEsperada);
            
            //Verificar a data do pedido de férias (entre 1 de Maio e 31 de Outubro)
            Calendar calDataPedido=Calendar.getInstance();
            calDataPedido.setTime(dataPedido);
            Calendar calInicioIntervalo=Calendar.getInstance();
            calInicioIntervalo.set(calDataPedido.get(Calendar.YEAR),Calendar.MAY,1);
            Calendar calFimIntervalo=Calendar.getInstance();
            calFimIntervalo.set(calDataPedido.get(Calendar.YEAR),Calendar.OCTOBER,31);
            boolean dataPedidoCorreta=!calDataPedido.before(calInicioIntervalo)&&! calDataPedido.after(calFimIntervalo);
            
            
            
            
            
            // Determinar se a ausência foi aprovada ou rejeitada
            if (motivoSelecionado.equals("Doença")&&calcularDiferencaDias(dataInicio, dataFim) <= 3) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                
            } else if (motivoSelecionado.equals("Doença com regime de proteção pela Segurança Social")&& calcularDiferencaDias(dataInicio, dataFim) >= 4){
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                mensagemRemuneracao="A sua ausência não será remunerada";
             
                
            }else if (motivoSelecionado.equals("Férias") && diasUteis <=direitoFerias && dataFimCorreta && dataPedidoCorreta){
                if(contarFolgas( dataInicio, dataFim) <=1 && podeAprovarFerias(dataAdmissao,dataPedido) && totalDiasUteisFerias <= 30){
                    estado = "Aprovada";
                    mensagem = "A sua ausência foi aprovada!";       
                }else{
                    estado="Rejeitada";
                    mensagem = "A sua ausência foi rejeitada!";
                }
                
                     
                
            }else if ((motivoSelecionado.equals("Falecimento de cônjuge") || motivoSelecionado.equals("Falecimento de pais")) && calcularDiferencaDias(dataInicio, dataFim) <= 20) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                
            } else if ((motivoSelecionado.equals("Falecimento de avós") || motivoSelecionado.equals("Falecimento de irmãos") ) && calcularDiferencaDias(dataInicio, dataFim) <= 2) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                
            } else if (motivoSelecionado.equals("Falecimento de filhos") && calcularDiferencaDias(dataInicio, dataFim) <= 20) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                
            } else if (motivoSelecionado.equals("Licença de casamento") ){
                if(calcularDiferencaDias(dataInicio,dataFim)<=15 && diferencaDiasPedidoInicio>=5){
                   estado = "Aprovada";
                   mensagem = "A sua ausência foi aprovada!";
                }else{
                    estado="Rejeitada";
                    mensagem = "A sua ausência foi rejeitada!";
                }
                
                
            
            } else if (motivoSelecionado.equals("Licença de maternidade") && calcularDiferencaDias(dataInicio, dataFim) >= 42 && calcularDiferencaDias(dataInicio, dataFim) <= 92) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
            } 
            
            
            else if (motivoSelecionado.equals("Licença de paternidade")){
                if(calcularDiferencaDias(dataInicio,dataFim)>=7 && calcularDiferencaDias(dataInicio,dataFim)<=28 && diferencaDiasPedidoInicio>=5){
                   estado = "Aprovada";
                   mensagem = "A sua ausência foi aprovada!";     
                }else{
                    estado="Rejeitada";
                    mensagem = "A sua ausência foi rejeitada!";
                }
                
                
            } else if (motivoSelecionado.equals("Assistência à família") && totalDiasAnoAssistenciaFamilia<=15) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                mensagemRemuneracao="A sua ausência não será remunerada";
                
                
            } else if (motivoSelecionado.equals("Assistência a filho") && totalDiasAnoAssistenciaFilho<=30) {
                estado = "Aprovada";
                mensagem = "A sua ausência foi aprovada!";
                
                
            }else if (motivoSelecionado.equals("Assistência a filho deficiente ou com doença crónica") ) {
                if (diasAssistenciaFilhoDeficiencia<=180){
                    estado = "Aprovada";
                    mensagem = "A sua ausência foi aprovada!";
                }else{
                    estado="Rejeitada";
                    mensagem = "A sua ausência foi rejeitada!";
                }
            } else {
                estado = "Rejeitada";
                mensagem = "A sua ausência foi rejeitada!";
                }
            
            
            
            
            // Verificar se a folga já existe 
        boolean folgaRepetida = false;
        boolean folgaAtravessaMes=atravessarMes(dataInicio,dataFim);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
                
    
    try {
        String checkSql = "SELECT COUNT(*) FROM Folgas WHERE FuncionarioId =? AND Estado='Aprovada' AND DataInicio<=? AND DataFim>=? ";
        PreparedStatement checkStatement = con.prepareStatement(checkSql);
        checkStatement.setInt(1, funcionarioId);
        checkStatement.setString(2, sdf.format(dataInicio));
        checkStatement.setString(3, sdf.format(dataFim));
        //checkStatement.setString(4, sdf.format(dataFim));
        //checkStatement.setString(5, sdf.format(dataInicio));
       
        
        ResultSet rs = checkStatement.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            System.out.println("Count"+count);
            if (count > 0) {
                folgaRepetida = true;
                System.out.println("Folga repetida"+folgaRepetida);
            }else{
                System.out.println("Não existem folgas repetidas");
            }
         
        }
        checkStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    //Verifica se a nova folga atravessa o mês
    if (folgaRepetida){
        if(folgaAtravessaMes){
            estado="Rejeitada";
            mensagem="A sua ausência foi rejeitada! ";   
    }else{
        estado="Rejeitada";
        mensagem="A sua ausência foi rejeitada!"; 
        }
    }
    
    else if (folgaAtravessaMes){
            estado="Aprovada";
            mensagem="A sua ausência foi aprovada!"; 
    }
    
            
           
            // Atualizar o estado na base de dados
        try{
            String updateSql = "UPDATE Folgas SET Estado = ? WHERE FolgaId=(SELECT MAX (FolgaId) FROM Folgas WHERE FuncionarioId = ? AND DataInicio = ? AND DataFim = ? );";
            String dataInicioString=sdf.format(jDateChooserDataInicio.getDate());
            String dataFimString=sdf.format(jDateChooserDataFim.getDate());
            
            PreparedStatement updateStatement = con.prepareStatement(updateSql);
            updateStatement.setString(1, estado);
            updateStatement.setInt(2, funcionarioId);
            updateStatement.setString(3, dataInicioString);
            updateStatement.setString(4,dataFimString);
            updateStatement.executeUpdate();
            
            System.out.println("Estado"+ estado);
            System.out.println("Mensagem"+mensagem);
            updateStatement.close();
           
        }catch (SQLException e){
                    e.printStackTrace();
                    
        }
            
            // Exibir mensagem na jLabelAprovacaoRejeicao
            
            Font fonteNegrito=new Font("Arial",Font.BOLD,12);//Colocar mensagem a negrito
            DecimalFormat df=new DecimalFormat("#.00");//Colocar remuneração com 2 casas decimais
            String remuneracaoFormatada=df.format(remuneracaoFolga);
            
            // Definir a cor do texto com base no estado da folga
            Color cor;
        if (estado.equals("Aprovada")) {
                cor=new Color(0,128,0);
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setFont(fonteNegrito);
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setText(mensagem);
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setForeground(cor);
                aprovacaoRejeicao.setVisible(true);
            
        if(motivoSelecionado.equals("Doença com regime de proteção pela Segurança Social")||motivoSelecionado.equals("Assistência à família")){
                confirmacaoRemuneracao.getJLabelRemuneracao().setText(mensagemRemuneracao);
                confirmacaoRemuneracao.setVisible(true);
            }else{
                atualizarRemuneracaoFolga(funcionarioId,remuneracaoFolga,dataInicio,dataFim);
                exibirRemuneracaoFolgaPorEscalao(departamento,salarioMensal,dataInicio,dataFim,remuneracaoFormatada);
                    
                }
        }else {
                cor=Color.RED;
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setFont(fonteNegrito);
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setText(mensagem);
                aprovacaoRejeicao.getJLabelAprovacaoRejeicao().setForeground(cor);
                aprovacaoRejeicao.setVisible(true);
                confirmacaoRemuneracao.setVisible(false);    
            }
    }
            
            

            
            
            
            
            
            
            
            
    
        
     
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAnterior1;
    private javax.swing.JButton jButtonPesquisarDataFim;
    private javax.swing.JButton jButtonPesquisarDataInicio;
    private javax.swing.JButton jButtonPesquisarDepartamento;
    private javax.swing.JButton jButtonPesquisarFuncionario;
    private javax.swing.JButton jButtonSeguinte;
    private javax.swing.JButton jButtonSeguinte1;
    private javax.swing.JButton jButtonSubmeter;
    private javax.swing.JButton jButtonÚltimo;
    private javax.swing.JButton jButtonÚltimo1;
    private javax.swing.JComboBox<String> jComboBoxDepartamento;
    private javax.swing.JComboBox<String> jComboBoxMotivos;
    private com.toedter.calendar.JDateChooser jDateChooserDataFim;
    private com.toedter.calendar.JDateChooser jDateChooserDataFimPesquisar;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicio;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicioPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFolgasAprovadas;
    private javax.swing.JLabel jLabelFolgasAprovadasGestorRH;
    private javax.swing.JLabel jLabelFuncionario;
    private javax.swing.JLabel jLabelFuncionario2;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPedidoFolgas;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelFolgasAprovadasFuncionario;
    private javax.swing.JPanel jPanelFolgasAprovadasGestorRH;
    private javax.swing.JPanel jPanelPaginacao;
    private javax.swing.JPanel jPanelPaginacao1;
    private javax.swing.JPanel jPanelPedidoFolgas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jTabFolgasAprovadas;
    private javax.swing.JPanel jTabFolgasAprovadasGestorRH;
    private javax.swing.JPanel jTabLogout;
    private javax.swing.JPanel jTabPedidoFolgas;
    private javax.swing.JTable jTableFolgasAprovadasFuncionario;
    private javax.swing.JTable jTableFolgasAprovadasGestor;
    private javax.swing.JTextField jTextFieldFuncionario;
    // End of variables declaration//GEN-END:variables

    
}

package visao;

import controle.ControleMain;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Tela extends javax.swing.JFrame {

    private ControleMain controle;


    public Tela() {
        initComponents();
        this.setEstiloComponentes();
        this.initController();
    }

    private void initController() {
        this.controle = new ControleMain();
        this.controle.setView(this);
    }

    private void setEstiloComponentes() {
        this.jTextAreaMalha.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.jTextAreaMalha.setEditable(false);
        this.jTextFieldArquivoMalha.setEditable(false);
        this.jTextFieldIntervaloInsercao.setText("500");
    }

    public JTextArea getTextArea() {
        return this.jTextAreaMalha;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMalha = new javax.swing.JButton();
        jTextFieldArquivoMalha = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQtdCarros = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIntervaloInsercao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnMonitor = new javax.swing.JButton();
        btnAguardar = new javax.swing.JButton();
        btnEncerrar = new javax.swing.JButton();
        btnSemaforo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMalha = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.setVerifyInputWhenFocusTarget(false);


        btnMalha.setText("Malha");
        btnMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonSelecionarMalhaActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jTextFieldArquivoMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldArquivoMalhaActionPerformed(evt);
            }
        });

        jLabel3.setText("Carros");

        jLabel2.setText("Intervalo (ms)");

        btnMonitor.setText("Monitor");
        btnMonitor.setEnabled(false);
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarMonitorActionPerformed(evt);
            }
        });

        btnAguardar.setText("Aguardar");
        btnAguardar.setEnabled(false);
        btnAguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAguardarActionPerformed(evt);
            }
        });

        btnEncerrar.setText("Encerrar");
        btnEncerrar.setActionCommand("Tudo");
        btnEncerrar.setEnabled(false);
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncerrarActionPerformed(evt);
            }
        });

        btnSemaforo.setText("Semáforo");
        btnSemaforo.setEnabled(false);
        btnSemaforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSemaforoActionPerformed(evt);
            }
        });

        jTextAreaMalha.setColumns(20);
        jTextAreaMalha.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMalha);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(38, 38, 38)
                                                                .addComponent(jLabel3))
                                                        .addComponent(jLabel2)
                                                        .addComponent(btnMalha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextFieldIntervaloInsercao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldQtdCarros, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnAguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnSemaforo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addComponent(jTextFieldArquivoMalha)))
                                        .addComponent(jSeparator1)
                                        .addComponent(jSeparator2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMalha)
                                        .addComponent(jTextFieldArquivoMalha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldQtdCarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldIntervaloInsercao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnMonitor)
                                                        .addComponent(btnAguardar))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSemaforo)
                                                        .addComponent(btnEncerrar))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void jTextFieldArquivoMalhaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonSelecionarMalhaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int Select = fileChoser.showSaveDialog(null);
        if (Select == JFileChooser.CANCEL_OPTION) {
            this.jTextFieldArquivoMalha.setText("");
        }
        else {
            File arquivo = fileChoser.getSelectedFile();
            this.jTextFieldArquivoMalha.setText(arquivo.getPath());
            this.controle.criarMalhaViaria(arquivo.getPath());
        }
        this.btnSemaforo.setEnabled(Select != JFileChooser.CANCEL_OPTION);
        this.btnMonitor.setEnabled(Select != JFileChooser.CANCEL_OPTION);
    }

    private void jButtonIniciarMonitorActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.jTextFieldIntervaloInsercao.getText().equals("") || this.jTextFieldQtdCarros.getText().equals("") ) {
            JOptionPane.showMessageDialog(null,"Aconteceu um erro! Na próxima preencha o tempo e a quantidade de carros antes de iniciar!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
        this.controle.iniciarMonitor(Integer.parseInt(this.jTextFieldIntervaloInsercao.getText()), Integer.parseInt(this.jTextFieldQtdCarros.getText()));
        this.btnMonitor.setEnabled(false);
        this.btnMalha.setEnabled(false);
        this.jTextFieldArquivoMalha.setEnabled(false);
        this.jTextFieldQtdCarros.setEnabled(false);
        this.jTextFieldIntervaloInsercao.setEnabled(false);
        this.btnSemaforo.setEnabled(false);
        this.btnEncerrar.setEnabled(true);
        this.btnAguardar.setEnabled(true);
        }

    }

    private void jButtonIniciarSemaforoActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.jTextFieldIntervaloInsercao.getText().equals("") || this.jTextFieldQtdCarros.getText().equals("") ) {
            JOptionPane.showMessageDialog(null,"Aconteceu um erro! Na próxima preencha o tempo e a quantidade de carros antes de iniciar!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
            this.controle.iniciarSemaforo(Integer.parseInt(this.jTextFieldIntervaloInsercao.getText()), Integer.parseInt(this.jTextFieldQtdCarros.getText()));
            this.btnMonitor.setEnabled(false);
            this.btnMalha.setEnabled(false);
            this.jTextFieldArquivoMalha.setEnabled(false);
            this.jTextFieldQtdCarros.setEnabled(false);
            this.jTextFieldIntervaloInsercao.setEnabled(false);
            this.btnSemaforo.setEnabled(false);
            this.btnEncerrar.setEnabled(true);
            this.btnAguardar.setEnabled(true);
        }
    }
    
    private void jButtonEncerrarActionPerformed(java.awt.event.ActionEvent evt) {
        this.controle.encerrar();
        this.btnAguardar.setEnabled(false);
        this.btnEncerrar.setEnabled(false);
        this.btnMonitor.setEnabled(false);
        this.btnMalha.setEnabled(true);
        this.jTextFieldArquivoMalha.setEnabled(true);
        this.jTextFieldQtdCarros.setEnabled(true);
        this.jTextFieldIntervaloInsercao.setEnabled(true);
        this.btnSemaforo.setEnabled(false);
        this.jTextFieldArquivoMalha.setText("");
        this.jTextAreaMalha.setText("");
    }
    
    private void jButtonAguardarActionPerformed(java.awt.event.ActionEvent evt) {
        this.controle.aguardar();
        this.btnAguardar.setEnabled(false);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }


    private javax.swing.JButton btnAguardar;
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JButton btnSemaforo;
    private javax.swing.JButton btnMalha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaMalha;
    private javax.swing.JTextField jTextFieldArquivoMalha;
    private javax.swing.JTextField jTextFieldIntervaloInsercao;
    private javax.swing.JTextField jTextFieldQtdCarros;

}


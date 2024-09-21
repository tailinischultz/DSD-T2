package visao;


//import com.project.transito.controller.ControllerMain;
import java.awt.Font;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Tela extends javax.swing.JFrame {

    //private ControllerMain controller;


    public Tela() {
        initComponents();
        this.setEstiloComponentes();
        this.initController();
    }

    private void initController() {
        //this.controller = new ControllerMain();
        //this.controller.setView(this);
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
        jButtonSelecionarMalha = new javax.swing.JButton();
        jTextFieldArquivoMalha = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQtdCarros = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIntervaloInsercao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonIniciarMonitor = new javax.swing.JButton();
        jButtonAguardar = new javax.swing.JButton();
        jButtonEncerrar = new javax.swing.JButton();
        jButtonIniciarSemaforo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMalha = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jButtonSelecionarMalha.setText("Malha");
        jButtonSelecionarMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarMalhaActionPerformed(evt);
            }
        });

        jTextFieldArquivoMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldArquivoMalhaActionPerformed(evt);
            }
        });

        jLabel3.setText("Carros");

        jLabel2.setText("Intervalo (ms)");

        jButtonIniciarMonitor.setText("Monitor");
        jButtonIniciarMonitor.setEnabled(false);
        jButtonIniciarMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarMonitorActionPerformed(evt);
            }
        });

        jButtonAguardar.setText("Aguardar");
        jButtonAguardar.setEnabled(false);
        jButtonAguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAguardarActionPerformed(evt);
            }
        });

        jButtonEncerrar.setText("Encerrar");
        jButtonEncerrar.setActionCommand("Tudo");
        jButtonEncerrar.setEnabled(false);
        jButtonEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncerrarActionPerformed(evt);
            }
        });

        jButtonIniciarSemaforo.setText("Semáforo");
        jButtonIniciarSemaforo.setEnabled(false);
        jButtonIniciarSemaforo.addActionListener(new java.awt.event.ActionListener() {
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
                                                        .addComponent(jButtonSelecionarMalha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextFieldIntervaloInsercao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldQtdCarros, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jButtonIniciarMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonAguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jButtonIniciarSemaforo)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                        .addComponent(jButtonSelecionarMalha)
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
                                                        .addComponent(jButtonIniciarMonitor)
                                                        .addComponent(jButtonAguardar))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonIniciarSemaforo)
                                                        .addComponent(jButtonEncerrar))))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAguardarActionPerformed(java.awt.event.ActionEvent evt) {
        //this.controller.pararSimulacao();
        this.jButtonAguardar.setEnabled(false);

    }

    private void jTextFieldArquivoMalhaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonSelecionarMalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarMalhaActionPerformed
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int Select = fileChoser.showSaveDialog(null);
        if (Select == JFileChooser.CANCEL_OPTION) {
            this.jTextFieldArquivoMalha.setText("");
        }
        else {
            File arquivo = fileChoser.getSelectedFile();
            this.jTextFieldArquivoMalha.setText(arquivo.getPath());
            //this.controller.CriaMalhaViaria(arquivo.getPath());
        }
        this.jButtonIniciarSemaforo.setEnabled(Select != JFileChooser.CANCEL_OPTION);
        this.jButtonIniciarMonitor.setEnabled(Select != JFileChooser.CANCEL_OPTION);
    }

    private void jButtonIniciarMonitorActionPerformed(java.awt.event.ActionEvent evt) {
        int qtdTempo = 0;
        int qtdCarros = 0;
        if (!this.jTextFieldIntervaloInsercao.getText().equals("")) {
            qtdTempo = Integer.parseInt(this.jTextFieldIntervaloInsercao.getText());
        }
        if (!this.jTextFieldQtdCarros.getText().equals("")) {
            qtdCarros = Integer.parseInt(this.jTextFieldQtdCarros.getText());
        }

        //this.controller.inciarSimulacaoMonitor(qtdTempo, qtdCarros);
        this.jButtonIniciarMonitor.setEnabled(false);
        this.jButtonSelecionarMalha.setEnabled(false);
        this.jTextFieldArquivoMalha.setEnabled(false);
        this.jTextFieldQtdCarros.setEnabled(false);
        this.jTextFieldIntervaloInsercao.setEnabled(false);
        this.jButtonIniciarSemaforo.setEnabled(false);
        this.jButtonEncerrar.setEnabled(true);
        this.jButtonAguardar.setEnabled(true);

    }

    private void jButtonEncerrarActionPerformed(java.awt.event.ActionEvent evt) {
        //this.controller.pararSimulacaoAgora();
        this.jButtonAguardar.setEnabled(false);
        this.jButtonEncerrar.setEnabled(false);
        this.jButtonIniciarMonitor.setEnabled(false);
        this.jButtonSelecionarMalha.setEnabled(true);
        this.jTextFieldArquivoMalha.setEnabled(true);
        this.jTextFieldQtdCarros.setEnabled(true);
        this.jTextFieldIntervaloInsercao.setEnabled(true);
        this.jButtonIniciarSemaforo.setEnabled(false);
        this.jTextFieldArquivoMalha.setText("");
        this.jTextAreaMalha.setText("");
    }

    private void jButtonIniciarSemaforoActionPerformed(java.awt.event.ActionEvent evt) {
        int qtdTempo = 0;
        int qtdCarros = 0;
        if (!this.jTextFieldIntervaloInsercao.getText().equals("")) {
            qtdTempo = Integer.parseInt(this.jTextFieldIntervaloInsercao.getText());
        }
        if (!this.jTextFieldQtdCarros.getText().equals("")) {
            qtdCarros = Integer.parseInt(this.jTextFieldQtdCarros.getText());
        }

        //this.controller.inciarSimulacaoSemaforo(qtdTempo, qtdCarros);
        this.jButtonIniciarMonitor.setEnabled(false);
        this.jButtonSelecionarMalha.setEnabled(false);
        this.jTextFieldArquivoMalha.setEnabled(false);
        this.jTextFieldQtdCarros.setEnabled(false);
        this.jTextFieldIntervaloInsercao.setEnabled(false);
        this.jButtonIniciarSemaforo.setEnabled(false);
        this.jButtonEncerrar.setEnabled(true);
        this.jButtonAguardar.setEnabled(true);
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButtonAguardar;
    private javax.swing.JButton jButtonEncerrar;
    private javax.swing.JButton jButtonIniciarMonitor;
    private javax.swing.JButton jButtonIniciarSemaforo;
    private javax.swing.JButton jButtonSelecionarMalha;
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


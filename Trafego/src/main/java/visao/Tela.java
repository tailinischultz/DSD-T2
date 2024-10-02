package visao;

import controle.ControleMain;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Tela extends javax.swing.JFrame {

    private ControleMain controleMain;

    public Tela() {
        initComponents();
        this.setEstiloComponentes();
        this.initController();
    }

    private void initController() {
        this.controleMain = new ControleMain();
        this.controleMain.setView(this);
    }

    private void setEstiloComponentes() {
        this.jTextAreaMalha.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.jTextAreaMalha.setEditable(false);
        this.jTextFieldIntervaloInsercao.setText("500");
    }

    public JTextArea getTextArea() {
        return this.jTextAreaMalha;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonSelecionarMalha1 = new javax.swing.JButton();
        jButtonSelecionarMalha2 = new javax.swing.JButton();
        jButtonSelecionarMalha3 = new javax.swing.JButton();
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

        jButtonSelecionarMalha1.setText("Malha 1");
        jButtonSelecionarMalha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonSelecionarMalhaActionPerformed(evt, "C:\\Users\\11835692974\\Documents\\DSD-T2\\Trafego\\src\\resources\\malhas\\malha-exemplo-1.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButtonSelecionarMalha2.setText("Malha 2");
        jButtonSelecionarMalha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonSelecionarMalhaActionPerformed(evt, "C:\\Users\\11835692974\\Documents\\DSD-T2\\Trafego\\src\\resources\\malhas\\malha-exemplo-2.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButtonSelecionarMalha3.setText("Malha 3");
        jButtonSelecionarMalha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonSelecionarMalhaActionPerformed(evt, "C:\\Users\\11835692974\\Documents\\DSD-T2\\Trafego\\src\\resources\\malhas\\malha-exemplo-3.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(38, 38, 38)
                                                                                .addComponent(jLabel3))
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextFieldIntervaloInsercao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldQtdCarros, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jButtonIniciarMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonAguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jButtonIniciarSemaforo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jSeparator2)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(jButtonSelecionarMalha1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(jButtonSelecionarMalha2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jButtonSelecionarMalha3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSelecionarMalha1)
                                        .addComponent(jButtonSelecionarMalha2)
                                        .addComponent(jButtonSelecionarMalha3)
                                )
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
    }

    private void jButtonAguardarActionPerformed(java.awt.event.ActionEvent evt) {
        //this.controller.pararSimulacao();
        this.jButtonAguardar.setEnabled(false);

    }

    private void jTextFieldArquivoMalhaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonSelecionarMalhaActionPerformed(java.awt.event.ActionEvent evt, String path) throws IOException {
        this.controleMain.criarMalhaViaria(path);

        this.jButtonIniciarSemaforo.setEnabled(true);
        this.jButtonIniciarMonitor.setEnabled(true);
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
        this.jButtonSelecionarMalha1.setEnabled(false);
        this.jButtonSelecionarMalha2.setEnabled(false);
        this.jButtonSelecionarMalha3.setEnabled(false);
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
        this.jButtonSelecionarMalha1.setEnabled(true);
        this.jButtonSelecionarMalha2.setEnabled(true);
        this.jButtonSelecionarMalha3.setEnabled(true);
        this.jTextFieldQtdCarros.setEnabled(true);
        this.jTextFieldIntervaloInsercao.setEnabled(true);
        this.jButtonIniciarSemaforo.setEnabled(false);
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
        this.jButtonSelecionarMalha1.setEnabled(false);
        this.jButtonSelecionarMalha2.setEnabled(false);
        this.jButtonSelecionarMalha3.setEnabled(false);
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
    private javax.swing.JButton jButtonSelecionarMalha1;
    private javax.swing.JButton jButtonSelecionarMalha2;
    private javax.swing.JButton jButtonSelecionarMalha3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaMalha;
    private javax.swing.JTextField jTextFieldIntervaloInsercao;
    private javax.swing.JTextField jTextFieldQtdCarros;

}

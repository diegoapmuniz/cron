package cron;

import entidades.Parameter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

/**
 *
 * @author Diego Muniz
 */
public class Cron extends javax.swing.JFrame {
    final SimpleDateFormat formato = new SimpleDateFormat("mm:ss");
    boolean rodando;
    Thread th = null;
    boolean pausado;
    int contadorAzul;
    int contadorVermelho;
    int faltaAzul;
    int faltaVermelho;
    int contadorRound;
    int quantidadeRounds;
    boolean intervalo;
    Funcoes funcoes = new Funcoes();
    
    private List<Parameter> listaParametros;

    /**
     * Creates new form NewJFrame
     */
    public Cron() {
        List<Parameter> listaParametros = new ArrayList<>();
        listaParametros = funcoes.carregaParametros();
        
        setListaParametros(listaParametros);
        System.out.println(getListaParametros().get(0).getValue());
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(218, 230, 205));
        inicializa();
        //popularCombo();

        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "f1");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "f2");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "f3");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "f4");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "f5");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "f6");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "f7");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "f8");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "f9");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "f10");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "f11");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "f12");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "sp");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        Object key = new Object();

        this.getRootPane().getActionMap().put("f1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnRedMaisUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnRedMenosUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f3", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnBlueMaisUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f4", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnBlueMenosUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f5", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnRedFaltaMais.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f6", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnRedFaltaMenos.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f7", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnBlueFaltaMais.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f8", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnBlueFaltaMenos.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f9", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //btnBlueMaisUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f10", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //btnBlueMaisUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f10", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //btnBlueMaisUm.doClick();
            }
        });
        this.getRootPane().getActionMap().put("f12", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //btnBlueMaisUm.doClick();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMin = new javax.swing.JLabel();
        lblSeg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        redPontuacao = new javax.swing.JLabel();
        bluePontuacao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        redFaltaContador = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        blueFaltaContador = new javax.swing.JLabel();
        lblTituloRound = new javax.swing.JLabel();
        lblRound = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnRedMaisUm = new javax.swing.JButton();
        btnBlueMaisUm = new javax.swing.JButton();
        btnRedMenosUm = new javax.swing.JButton();
        btnBlueMenosUm = new javax.swing.JButton();
        btnRedFaltaMais = new javax.swing.JButton();
        btnBlueFaltaMais = new javax.swing.JButton();
        btnRedFaltaMenos = new javax.swing.JButton();
        btnBlueFaltaMenos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConfiguracoes = new javax.swing.JMenu();
        MenuConfigurar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 226, 203));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        lblMin.setBackground(new java.awt.Color(0, 0, 0));
        lblMin.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblMin.setForeground(new java.awt.Color(255, 153, 153));
        lblMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMin.setText("01");
        lblMin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMin.setOpaque(true);

        lblSeg.setBackground(new java.awt.Color(0, 0, 0));
        lblSeg.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblSeg.setForeground(new java.awt.Color(255, 153, 153));
        lblSeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeg.setText("30");
        lblSeg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSeg.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText(":");

        redPontuacao.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        redPontuacao.setForeground(new java.awt.Color(204, 0, 0));
        redPontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        redPontuacao.setText("RED");

        bluePontuacao.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        bluePontuacao.setForeground(new java.awt.Color(0, 0, 204));
        bluePontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bluePontuacao.setText("BLUE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Faltas:");

        redFaltaContador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        redFaltaContador.setForeground(new java.awt.Color(204, 0, 0));
        redFaltaContador.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Faltas:");

        blueFaltaContador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        blueFaltaContador.setForeground(new java.awt.Color(0, 0, 204));
        blueFaltaContador.setText("0");

        lblTituloRound.setBackground(new java.awt.Color(0, 0, 0));
        lblTituloRound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTituloRound.setForeground(new java.awt.Color(255, 153, 153));
        lblTituloRound.setText("Round");
        lblTituloRound.setToolTipText("");

        lblRound.setBackground(new java.awt.Color(0, 0, 0));
        lblRound.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblRound.setForeground(new java.awt.Color(255, 153, 153));
        lblRound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRound.setText("1");

        lblStatus.setBackground(new java.awt.Color(255, 255, 102));
        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Parado");
        lblStatus.setToolTipText("");
        lblStatus.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redFaltaContador, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTituloRound, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueFaltaContador, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bluePontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMin, lblSeg});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(redFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blueFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblRound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTituloRound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bluePontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(redPontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        btnRedMaisUm.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMaisUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMaisUm.setText("Vermelho +1 (F1)");
        btnRedMaisUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMaisUmActionPerformed(evt);
            }
        });

        btnBlueMaisUm.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueMaisUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueMaisUm.setText("Azul +1 (F3)");
        btnBlueMaisUm.setMaximumSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.setMinimumSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.setPreferredSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueMaisUmActionPerformed(evt);
            }
        });

        btnRedMenosUm.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMenosUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMenosUm.setText("Vermelho -1 (F2)");
        btnRedMenosUm.setPreferredSize(new java.awt.Dimension(113, 40));
        btnRedMenosUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMenosUmActionPerformed(evt);
            }
        });

        btnBlueMenosUm.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueMenosUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueMenosUm.setText("Azul -1 (F4)");
        btnBlueMenosUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueMenosUmActionPerformed(evt);
            }
        });

        btnRedFaltaMais.setBackground(new java.awt.Color(255, 255, 255));
        btnRedFaltaMais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedFaltaMais.setText("Vermelho Falta + (F5)");
        btnRedFaltaMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedFaltaMaisActionPerformed(evt);
            }
        });

        btnBlueFaltaMais.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueFaltaMais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueFaltaMais.setText("Azul Falta + (F7)");
        btnBlueFaltaMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueFaltaMaisActionPerformed(evt);
            }
        });

        btnRedFaltaMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnRedFaltaMenos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedFaltaMenos.setText("Vermelho Falta - (F6)");
        btnRedFaltaMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedFaltaMenosActionPerformed(evt);
            }
        });

        btnBlueFaltaMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueFaltaMenos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueFaltaMenos.setText("Azul Falta - (F8)");
        btnBlueFaltaMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueFaltaMenosActionPerformed(evt);
            }
        });

        menuConfiguracoes.setText("Configurações");

        MenuConfigurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        MenuConfigurar.setText("Configurar");
        MenuConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConfigurarActionPerformed(evt);
            }
        });
        menuConfiguracoes.add(MenuConfigurar);

        jMenuBar1.add(menuConfiguracoes);

        menuAjuda.setText("Ajuda");
        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRedMenosUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRedMaisUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBlueMaisUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBlueMenosUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRedFaltaMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlueFaltaMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRedFaltaMenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlueFaltaMenos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMaisUm, btnBlueMenosUm, btnRedFaltaMais, btnRedFaltaMenos, btnRedMaisUm, btnRedMenosUm});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRedMaisUm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnBlueMaisUm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedFaltaMais)
                    .addComponent(btnBlueFaltaMais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRedMenosUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBlueMenosUm)
                        .addComponent(btnRedFaltaMenos))
                    .addComponent(btnBlueFaltaMenos))
                .addGap(37, 37, 37))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMenosUm, btnRedFaltaMenos, btnRedMaisUm, btnRedMenosUm});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueMaisUm, btnRedFaltaMais});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //iniciaCronometro();
        if (rodando) {
            jButton1.setText("Pausar");
        }
        try {
            cronometrar("01", "31");
        } catch (InterruptedException ex) {
            Logger.getLogger(Cron.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Parameter> listaParametros = new ArrayList<>();
            
            listaParametros = funcoes.carregaParametros();
        } catch (Exception e) {
            Logger.getLogger(Cron.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRedMaisUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMaisUmActionPerformed
        contadorVermelho = contadorVermelho + 1;
        redPontuacao.setText(Integer.toString(contadorVermelho));

    }//GEN-LAST:event_btnRedMaisUmActionPerformed

    private void btnBlueMaisUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueMaisUmActionPerformed
        contadorAzul = contadorAzul + 1;
        bluePontuacao.setText(Integer.toString(contadorAzul));
    }//GEN-LAST:event_btnBlueMaisUmActionPerformed

    private void btnRedMenosUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMenosUmActionPerformed
        contadorVermelho = contadorVermelho - 1;
        redPontuacao.setText(Integer.toString(contadorVermelho));
    }//GEN-LAST:event_btnRedMenosUmActionPerformed

    private void btnBlueMenosUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueMenosUmActionPerformed
        contadorAzul = contadorAzul - 1;
        bluePontuacao.setText(Integer.toString(contadorAzul));
    }//GEN-LAST:event_btnBlueMenosUmActionPerformed

    private void btnRedFaltaMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedFaltaMaisActionPerformed
        faltaVermelho = faltaVermelho + 1;
        redFaltaContador.setText(Integer.toString(faltaVermelho));
    }//GEN-LAST:event_btnRedFaltaMaisActionPerformed

    private void btnBlueFaltaMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueFaltaMaisActionPerformed
        faltaAzul = faltaAzul + 1;
        blueFaltaContador.setText(Integer.toString(faltaAzul));
    }//GEN-LAST:event_btnBlueFaltaMaisActionPerformed

    private void MenuConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConfigurarActionPerformed
        if (th != null) {
            if (th.isAlive()) {
                th.stop();
            }
        }
        lblMin.setText("0");
        lblSeg.setText("0");
        rodando = false;
        jButton1.setText("Iniciar");

        showDialog();

    }//GEN-LAST:event_MenuConfigurarActionPerformed

    private void btnRedFaltaMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedFaltaMenosActionPerformed
        faltaVermelho = faltaVermelho - 1;
        redFaltaContador.setText(Integer.toString(faltaVermelho));
    }//GEN-LAST:event_btnRedFaltaMenosActionPerformed

    private void btnBlueFaltaMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueFaltaMenosActionPerformed
        faltaAzul = faltaAzul - 1;
        blueFaltaContador.setText(Integer.toString(faltaAzul));
    }//GEN-LAST:event_btnBlueFaltaMenosActionPerformed

    private void showDialog() {
        Parametros param = new Parametros();
        param.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        param.setModal(true);
        int valor = param.getTeste();
        param.setVisible(true);
        System.out.println("valor: " + valor);
    }

    public void inicializa() {

        redFaltaContador.setText("0");
        blueFaltaContador.setText("0");
        redPontuacao.setText("0");
        bluePontuacao.setText("0");
        
    }

    /**
     * @param args the command line arguments
     */
    /* public void popularCombo() {
     DefaultComboBoxModel comboModel = (DefaultComboBoxModel) selectCom.getModel();
     selectCom.removeAllItems();
     Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
     while (portList.hasMoreElements()) {
     CommPortIdentifier cpi = (CommPortIdentifier) portList.nextElement();
     if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
     selectCom.addItem(cpi.getName());

     }
     }
     redFaltaContador.setText("0");
     blueFaltaContador.setText("0");
     redPontuacao.setText("0");
     bluePontuacao.setText("0");
        
     }*/
 

    public void cronometrar(String m, String s) throws InterruptedException {

        if (!pausado) {
            if (!rodando) {
                jButton1.setText("Pausar");
                th = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                Funcoes func = new Funcoes();
                                //func.fechaBanco();
                            }
                        });
                        int totalSegundos = Integer.parseInt(s);
                        int min = Integer.parseInt(m);
                        min = min * 60;  //
                        totalSegundos = min + totalSegundos;

                        for (int i = totalSegundos; i > 0; i--) { //tempo recebido em segundos 

                            totalSegundos--;

                            int horas = totalSegundos / 3600; //Para descobrir o total de horas. 
                            int minutos = (totalSegundos - (horas * 3600)) / 60; //Para descobrir o total de minutos. 
                            int segundos = (totalSegundos - (horas * 3600)) - (minutos * 60); //Para descobrir o total de segundos. 
                            String minString = Integer.toString(minutos);
                            String segString = Integer.toString(segundos);

                            if (minString.length() == 1) {
                                minString = "0" + minString;
                            }
                            if (segString.length() == 1) {
                                segString = "0" + segString;
                            }
                            lblMin.setText(minString);
                            lblSeg.setText(segString);

                            try {
                                th.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Cron.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (horas == 0 && minutos == 0 && segundos == 0) {
                                rodando = false;
                                if(contadorRound <= quantidadeRounds){
                                    contadorRound = contadorRound+1;
                                }
                                jButton1.setText("Iniciar");
                                break;
                            }

                        }
                    }
                });

                th.start();
                rodando = true;
                pausado = false;
                //th.sleep(1000);
            } else {
                th.suspend();
                rodando = false;
                pausado = true;
                jButton1.setText("Resumir");
            }
        } else {
            th.resume();
            jButton1.setText("Pausar");
            pausado = false;
            rodando = true;
        }

    }

    public List<Parameter> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(List<Parameter> listaParametros) {
        this.listaParametros = listaParametros;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuConfigurar;
    private javax.swing.JLabel blueFaltaContador;
    private javax.swing.JLabel bluePontuacao;
    private javax.swing.JButton btnBlueFaltaMais;
    private javax.swing.JButton btnBlueFaltaMenos;
    private javax.swing.JButton btnBlueMaisUm;
    private javax.swing.JButton btnBlueMenosUm;
    private javax.swing.JButton btnRedFaltaMais;
    private javax.swing.JButton btnRedFaltaMenos;
    private javax.swing.JButton btnRedMaisUm;
    private javax.swing.JButton btnRedMenosUm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblRound;
    private javax.swing.JLabel lblSeg;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTituloRound;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JLabel redFaltaContador;
    private javax.swing.JLabel redPontuacao;
    // End of variables declaration//GEN-END:variables
}

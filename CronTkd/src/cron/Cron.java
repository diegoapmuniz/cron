package cron;

import entidades.Parameter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
//import java.util.Timer;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import util.Constantes;


/**
 *
 * @author Diego Muniz
 */
public class Cron extends javax.swing.JFrame {
    final SimpleDateFormat formato = new SimpleDateFormat("mm:ss");
    public int contadorAzul;
    public int contadorVermelho;
    public int faltaAzul;
    public int faltaVermelho;
    public int contadorRound =1;
    public int quantidadeRounds;
    boolean isIntervalo;
    boolean isFimRound;
    Funcoes funcoes = new Funcoes();
    public Timer timerRound;
    public Timer timerMorteSubita;
    public Timer timerIntervalo;
    private int currentSegundoRound ;
    private int currentMinutoRound;
    private int currentSegundoIntervalo ;
    private int currentMinutoIntervalo;
    private int currentSegundoMorteSubita ;
    private int currentMinutoMorteSubita;
    private int velocidade = 1000;
    private String minutosRound ;
    private String segundosRound ;
    private String minutosMorteSubita ;
    private String segundosMorteSubita ;
    private String minutosIntervalo ;
    private String segundosIntervalo ;
    
    
    
    private List<Parameter> listaParametros;

    /**
     * Creates new form NewJFrame
     */
    public Cron() {
        List<Parameter> listaParametros = new ArrayList<>();
        listaParametros = funcoes.carregaParametros();
        setListaParametros(listaParametros);
        initComponents();
        carregaConfiguracoesTimer();
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
        lblSegundoTimer = new javax.swing.JLabel();
        lblMinutoTimer = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        btnRedMaisUm = new javax.swing.JButton();
        btnBlueMaisUm = new javax.swing.JButton();
        btnRedMenosUm = new javax.swing.JButton();
        btnBlueMenosUm = new javax.swing.JButton();
        btnRedFaltaMais = new javax.swing.JButton();
        btnBlueFaltaMais = new javax.swing.JButton();
        btnRedFaltaMenos = new javax.swing.JButton();
        btnBlueFaltaMenos = new javax.swing.JButton();
        btnTimer = new javax.swing.JButton();
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        lblSegundoTimer.setBackground(new java.awt.Color(0, 0, 0));
        lblSegundoTimer.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblSegundoTimer.setForeground(new java.awt.Color(255, 153, 153));
        lblSegundoTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSegundoTimer.setText("01");
        lblSegundoTimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSegundoTimer.setOpaque(true);

        lblMinutoTimer.setBackground(new java.awt.Color(0, 0, 0));
        lblMinutoTimer.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblMinutoTimer.setForeground(new java.awt.Color(255, 153, 153));
        lblMinutoTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinutoTimer.setText("01");
        lblMinutoTimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMinutoTimer.setOpaque(true);

        lblStatus1.setBackground(new java.awt.Color(255, 255, 102));
        lblStatus1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus1.setToolTipText("");
        lblStatus1.setOpaque(true);

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
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTituloRound, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMinutoTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRound, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSegundoTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(lblStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueFaltaContador, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bluePontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMinutoTimer, lblSegundoTimer});

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
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSegundoTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMinutoTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bluePontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(redPontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblMinutoTimer, lblSegundoTimer});

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

        btnTimer.setText("Timer");
        btnTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerActionPerformed(evt);
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
                        .addComponent(btnBlueFaltaMais))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRedFaltaMenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlueFaltaMenos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMaisUm, btnBlueMenosUm, btnRedFaltaMais, btnRedFaltaMenos, btnRedMaisUm, btnRedMenosUm});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBlueMaisUm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRedFaltaMais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRedMenosUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBlueMenosUm)
                                .addComponent(btnRedFaltaMenos))
                            .addComponent(btnBlueFaltaMenos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRedMaisUm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btnBlueFaltaMais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimer)))
                .addGap(37, 37, 37))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMenosUm, btnRedFaltaMenos, btnRedMaisUm, btnRedMenosUm});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueMaisUm, btnRedFaltaMais});

        btnTimer.getAccessibleContext().setAccessibleName("Timer");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void carregaConfiguracoesTimer(){
        listaParametros = getListaParametros();
               
        for(int i=0;i<listaParametros.size();i++){
            if (Constantes.VAR_MINUTOS_ROUND.equals(listaParametros.get(i).getName())) {
                    minutosRound = listaParametros.get(i).getValue();
                    currentMinutoRound = Integer.parseInt(minutosRound);
                }
              if (Constantes.VAR_SEGUNDOS_ROUND.equals(listaParametros.get(i).getName())) {
                    segundosRound = listaParametros.get(i).getValue();
                    currentSegundoRound = Integer.parseInt(segundosRound);
                }
              if (Constantes.VAR_MINUTOS_MORTE_SUBITA.equals(listaParametros.get(i).getName())) {
                    minutosMorteSubita = listaParametros.get(i).getValue();
                    currentMinutoMorteSubita = Integer.parseInt(minutosMorteSubita);
                }
              if (Constantes.VAR_SEGUNDOS_MORTE_SUBITA.equals(listaParametros.get(i).getName())) {
                    segundosMorteSubita = listaParametros.get(i).getValue();
                    currentSegundoMorteSubita = Integer.parseInt(segundosMorteSubita);
                }
             if (Constantes.VAR_MINUTOS_INTERVALO.equals(listaParametros.get(i).getName())) {
                    minutosIntervalo = listaParametros.get(i).getValue();
                    currentMinutoIntervalo = Integer.parseInt(minutosIntervalo);
                }
             if (Constantes.VAR_SEGUNDOS_INTERVALO.equals(listaParametros.get(i).getName())) {
                    segundosIntervalo = listaParametros.get(i).getValue();
                    currentSegundoIntervalo = Integer.parseInt(segundosIntervalo);
                }
              
        }
    
    
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
        jButton1.setText("Iniciar");
        showDialogConfiguracoes();

    }//GEN-LAST:event_MenuConfigurarActionPerformed

    private void btnRedFaltaMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedFaltaMenosActionPerformed
        faltaVermelho = faltaVermelho - 1;
        redFaltaContador.setText(Integer.toString(faltaVermelho));
    }//GEN-LAST:event_btnRedFaltaMenosActionPerformed

    private void btnBlueFaltaMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueFaltaMenosActionPerformed
        faltaAzul = faltaAzul - 1;
        blueFaltaContador.setText(Integer.toString(faltaAzul));
    }//GEN-LAST:event_btnBlueFaltaMenosActionPerformed
    int contador = 75;
    private void btnTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerActionPerformed
         iniciarCronometro();
   
    }//GEN-LAST:event_btnTimerActionPerformed

    private void iniciarCronometro(){
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                
                lblRound.setText(String.valueOf(contadorRound));
                currentSegundoRound--;
                if(currentSegundoRound<00){
                    currentMinutoRound--;
                    currentSegundoRound = 59;
                }
                if(currentMinutoRound==0 && currentSegundoRound ==0){
                    
                    contadorRound++;
                    lblRound.setText(String.valueOf(contadorRound));
                    timerRound.stop();
                    carregaConfiguracoesTimer();
                }              
                String min = currentMinutoRound <= 9? "0"+currentMinutoRound:currentMinutoRound+"";
                String seg = currentSegundoRound <= 9? "0"+currentSegundoRound:currentSegundoRound+"";
                
                lblMinutoTimer.setText(min);
                lblSegundoTimer.setText(seg);
            }  
        };  
        if(currentMinutoRound>=0 && currentSegundoRound>=0 ){
        this.timerRound = new Timer(velocidade, action);  
        this.timerRound.start();  
        }
        else{
            this.timerRound.stop();
            
        }
        

}
    
    private void showDialogConfiguracoes() {
        Parametros param = new Parametros();
        param.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        param.setModal(true);
        //int valor = param.getTeste();
        param.setVisible(true);
        //System.out.println("valor: " + valor);
    }

    public void inicializa() {

        redFaltaContador.setText("0");
        blueFaltaContador.setText("0");
        redPontuacao.setText("0");
        bluePontuacao.setText("0");
        int minutosInt = Integer.parseInt(minutosRound);
        int segundosInt = Integer.parseInt(segundosRound);
        String min = minutosInt <= 9? "0"+minutosInt:minutosInt+"";
        String seg = segundosInt <= 9? "0"+segundosInt:segundosInt+"";
        lblMinutoTimer.setText(min);
        lblSegundoTimer.setText(seg);
        
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
    private javax.swing.JButton btnTimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMinutoTimer;
    private javax.swing.JLabel lblRound;
    private javax.swing.JLabel lblSegundoTimer;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblTituloRound;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JLabel redFaltaContador;
    private javax.swing.JLabel redPontuacao;
    // End of variables declaration//GEN-END:variables
}

package cron;

import entidades.Parameter;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
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
 * @author Diego Muniz <diego2605@gmail.com>
 */
public class Cron extends javax.swing.JFrame  {

    final SimpleDateFormat formato = new SimpleDateFormat("mm:ss");
    public int contadorAzul;

    public int getContadorAzul() {
        return contadorAzul;
    }

    public void setContadorAzul(int contadorAzul) {
        this.contadorAzul = contadorAzul;
    }
    public int contadorVermelho;
    public int faltaAzul;
    public int faltaVermelho;
    public int contadorRound = 1;
    public int quantidadeRounds;
    Funcoes funcoes = new Funcoes();
    public Timer timerRound;
    public Timer timerMorteSubita;
    public Timer timerIntervalo;
    private int currentSegundoRound;
    private int currentMinutoRound;
    private int currentSegundoIntervalo;
    private int currentMinutoIntervalo;
    private int currentSegundoMorteSubita;
    private int currentMinutoMorteSubita;
    private int velocidade = 1000;
    private String minutosRound;
    private String segundosRound;
    private String minutosMorteSubita;
    private String segundosMorteSubita;
    private String minutosIntervalo;
    private String segundosIntervalo;
    public boolean roundRodando= false;
    public boolean roundParado = true;
    public boolean intervaloRodando= false;
    public boolean intervaloParado = true;
    public boolean fimRound = false;
    public boolean fimIntervalo = false;
    private List<Parameter> listaParametros;
     private InputStream entrada;
    /**
     * Creates new form NewJFrame
     */
    public Cron()  {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        List<Parameter> listaParametros = new ArrayList<>();    
        listaParametros = funcoes.carregaParametros();
        setListaParametros(listaParametros);
        initComponents();
        carregaConfiguracoesTimer();
        
        inicializa();
        
        
        
        
        this.setLayout(new GridBagLayout());
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
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        Object key = new Object();

        this.getRootPane().getActionMap().put("f1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnRedMaisDois.doClick();
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
        this.getRootPane().getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnTimer.doClick();
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

        panelTimer = new javax.swing.JPanel();
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
        lblIntervaloTimer = new javax.swing.JLabel();
        panelButtons = new javax.swing.JPanel();
        btnTimer = new javax.swing.JButton();
        btnBlueFaltaMenos = new javax.swing.JButton();
        btnBlueFaltaMais = new javax.swing.JButton();
        btnRedFaltaMais = new javax.swing.JButton();
        btnRedFaltaMenos = new javax.swing.JButton();
        btnBlueMenosUm = new javax.swing.JButton();
        btnBlueMaisUm = new javax.swing.JButton();
        btnRedMaisUm1 = new javax.swing.JButton();
        btnRedMaisDois = new javax.swing.JButton();
        btnRedMaisTres = new javax.swing.JButton();
        btnRedMenosUm = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConfiguracoes = new javax.swing.JMenu();
        MenuConfigurar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 226, 203));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelTimer.setOpaque(false);
        panelTimer.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                panelTimerVetoableChange(evt);
            }
        });

        redPontuacao.setBackground(new java.awt.Color(0, 0, 0));
        redPontuacao.setFont(new java.awt.Font("Tahoma", 1, 190)); // NOI18N
        redPontuacao.setForeground(new java.awt.Color(204, 0, 0));
        redPontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        redPontuacao.setText("V");
        redPontuacao.setMaximumSize(null);
        redPontuacao.setOpaque(true);

        bluePontuacao.setBackground(new java.awt.Color(0, 0, 0));
        bluePontuacao.setFont(new java.awt.Font("Tahoma", 1, 190)); // NOI18N
        bluePontuacao.setForeground(new java.awt.Color(0, 0, 204));
        bluePontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bluePontuacao.setText("A");
        bluePontuacao.setMaximumSize(null);
        bluePontuacao.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Faltas:");

        redFaltaContador.setBackground(new java.awt.Color(0, 255, 153));
        redFaltaContador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        redFaltaContador.setForeground(new java.awt.Color(204, 0, 0));
        redFaltaContador.setText("0");
        redFaltaContador.setMaximumSize(new java.awt.Dimension(0, 0));
        redFaltaContador.setMinimumSize(new java.awt.Dimension(0, 0));

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
        lblStatus.setMaximumSize(new java.awt.Dimension(0, 0));
        lblStatus.setMinimumSize(new java.awt.Dimension(0, 0));
        lblStatus.setOpaque(true);

        lblSegundoTimer.setBackground(new java.awt.Color(0, 0, 0));
        lblSegundoTimer.setFont(new java.awt.Font("Tahoma", 1, 76)); // NOI18N
        lblSegundoTimer.setForeground(new java.awt.Color(255, 153, 153));
        lblSegundoTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSegundoTimer.setText("01");
        lblSegundoTimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSegundoTimer.setOpaque(true);

        lblMinutoTimer.setBackground(new java.awt.Color(0, 0, 0));
        lblMinutoTimer.setFont(new java.awt.Font("Tahoma", 1, 76)); // NOI18N
        lblMinutoTimer.setForeground(new java.awt.Color(255, 153, 153));
        lblMinutoTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinutoTimer.setText("01");
        lblMinutoTimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMinutoTimer.setOpaque(true);

        lblIntervaloTimer.setBackground(new java.awt.Color(255, 255, 102));
        lblIntervaloTimer.setFont(new java.awt.Font("Tahoma", 1, 120)); // NOI18N
        lblIntervaloTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIntervaloTimer.setToolTipText("");
        lblIntervaloTimer.setOpaque(true);

        panelButtons.setOpaque(false);

        btnTimer.setBackground(new java.awt.Color(255, 255, 255));
        btnTimer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTimer.setText("Botão");
        btnTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerActionPerformed(evt);
            }
        });

        btnBlueFaltaMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueFaltaMenos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueFaltaMenos.setText("<html>Azul Falta - <br><center><font color=\"#E88C2C\">(F8)</html>");
        btnBlueFaltaMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueFaltaMenosActionPerformed(evt);
            }
        });

        btnBlueFaltaMais.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueFaltaMais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueFaltaMais.setLabel("<html>Azul Falta + <br><center><font color=\"#E88C2C\">(F7)</html>");
        btnBlueFaltaMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueFaltaMaisActionPerformed(evt);
            }
        });

        btnRedFaltaMais.setBackground(new java.awt.Color(255, 255, 255));
        btnRedFaltaMais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedFaltaMais.setText("<html>Vermelho Falta + <br><center><font color=\"#E88C2C\">(F5)</html>");
        btnRedFaltaMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedFaltaMaisActionPerformed(evt);
            }
        });

        btnRedFaltaMenos.setBackground(new java.awt.Color(255, 255, 255));
        btnRedFaltaMenos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedFaltaMenos.setText("<html>Vermelho Falta - <br><center><font color=\"#E88C2C\">(F6)</html>");
        btnRedFaltaMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedFaltaMenosActionPerformed(evt);
            }
        });

        btnBlueMenosUm.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueMenosUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueMenosUm.setText("<html>Azul - 1<br><center><font color=\"#E88C2C\">(F4)</html>");
        btnBlueMenosUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueMenosUmActionPerformed(evt);
            }
        });

        btnBlueMaisUm.setBackground(new java.awt.Color(255, 255, 255));
        btnBlueMaisUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBlueMaisUm.setText("<html>Azul + 1<br><center><font color=\"#E88C2C\">(F3)</html>");
        btnBlueMaisUm.setMaximumSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.setMinimumSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.setPreferredSize(new java.awt.Dimension(117, 23));
        btnBlueMaisUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueMaisUmActionPerformed(evt);
            }
        });

        btnRedMaisUm1.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMaisUm1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMaisUm1.setText("<html>Vermelho + 1<br><center><font color=\"#E88C2C\">(F1)</html>");
        btnRedMaisUm1.setMaximumSize(new java.awt.Dimension(116, 39));
        btnRedMaisUm1.setMinimumSize(new java.awt.Dimension(116, 39));
        btnRedMaisUm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMaisUm1ActionPerformed(evt);
            }
        });

        btnRedMaisDois.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMaisDois.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMaisDois.setText("<html>Vermelho + 2<br><center><font color=\"#E88C2C\">(F1)</html>");
        btnRedMaisDois.setMaximumSize(new java.awt.Dimension(116, 39));
        btnRedMaisDois.setMinimumSize(new java.awt.Dimension(116, 39));
        btnRedMaisDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMaisDoisActionPerformed(evt);
            }
        });

        btnRedMaisTres.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMaisTres.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMaisTres.setText("<html>Vermelho + 3<br><center><font color=\"#E88C2C\">(F1)</html>");
        btnRedMaisTres.setMaximumSize(new java.awt.Dimension(116, 39));
        btnRedMaisTres.setMinimumSize(new java.awt.Dimension(116, 39));
        btnRedMaisTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMaisTresActionPerformed(evt);
            }
        });

        btnRedMenosUm.setBackground(new java.awt.Color(255, 255, 255));
        btnRedMenosUm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRedMenosUm.setText("<html>Vermelho - 1<br><center><font color=\"#E88C2C\">(F2)</html>");
        btnRedMenosUm.setMaximumSize(new java.awt.Dimension(116, 39));
        btnRedMenosUm.setMinimumSize(new java.awt.Dimension(116, 39));
        btnRedMenosUm.setPreferredSize(new java.awt.Dimension(113, 40));
        btnRedMenosUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMenosUmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRedMaisUm1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedMaisDois, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedMaisTres, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedMenosUm, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBlueMaisUm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnBlueMenosUm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelButtonsLayout.createSequentialGroup()
                        .addComponent(btnRedFaltaMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlueFaltaMais))
                    .addGroup(panelButtonsLayout.createSequentialGroup()
                        .addComponent(btnRedFaltaMenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlueFaltaMenos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 512, Short.MAX_VALUE)
                .addComponent(btnTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMaisUm, btnBlueMenosUm, btnRedFaltaMais, btnRedFaltaMenos});

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRedMaisDois, btnRedMaisTres, btnRedMenosUm});

        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addComponent(btnRedMaisUm1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRedMaisDois, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelButtonsLayout.createSequentialGroup()
                        .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBlueMaisUm, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addComponent(btnRedMaisTres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnRedFaltaMais)
                            .addComponent(btnBlueFaltaMais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBlueMenosUm)
                                .addComponent(btnRedFaltaMenos)
                                .addComponent(btnRedMenosUm, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                            .addComponent(btnBlueFaltaMenos)))
                    .addComponent(btnTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueFaltaMais, btnBlueFaltaMenos, btnBlueMenosUm, btnRedFaltaMenos, btnRedMaisDois, btnRedMenosUm});

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBlueMaisUm, btnRedFaltaMais});

        javax.swing.GroupLayout panelTimerLayout = new javax.swing.GroupLayout(panelTimer);
        panelTimer.setLayout(panelTimerLayout);
        panelTimerLayout.setHorizontalGroup(
            panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTimerLayout.createSequentialGroup()
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimerLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(91, 91, 91))
                            .addGroup(panelTimerLayout.createSequentialGroup()
                                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(redPontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                    .addGroup(panelTimerLayout.createSequentialGroup()
                                        .addGap(277, 277, 277)
                                        .addComponent(redFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimerLayout.createSequentialGroup()
                                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMinutoTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTituloRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRound, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(lblSegundoTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblIntervaloTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTimerLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blueFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bluePontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))))
        );

        panelTimerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        panelTimerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMinutoTimer, lblSegundoTimer});

        panelTimerLayout.setVerticalGroup(
            panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTimerLayout.createSequentialGroup()
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(redPontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                    .addGroup(panelTimerLayout.createSequentialGroup()
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTituloRound, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(lblRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(blueFaltaContador, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimerLayout.createSequentialGroup()
                                .addGroup(panelTimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSegundoTimer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMinutoTimer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIntervaloTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bluePontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        panelTimerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {blueFaltaContador, jLabel4, jLabel5, lblRound, lblTituloRound, redFaltaContador});

        panelTimerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bluePontuacao, redPontuacao});

        panelTimerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblMinutoTimer, lblSegundoTimer});

        getContentPane().add(panelTimer, new java.awt.GridBagConstraints());

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

        setSize(new java.awt.Dimension(1198, 774));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carregaConfiguracoesTimer() {
        listaParametros = getListaParametros();

        for (int i = 0; i < listaParametros.size(); i++) {
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


    private void btnRedMaisDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMaisDoisActionPerformed
        contadorVermelho = contadorVermelho + 1;
        redPontuacao.setText(Integer.toString(contadorVermelho));

    }//GEN-LAST:event_btnRedMaisDoisActionPerformed

    private void btnBlueMaisUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueMaisUmActionPerformed
        setContadorAzul(getContadorAzul() + 1);
        //setContadorAzul(contadorAzul);
        bluePontuacao.setText(Integer.toString(getContadorAzul()));
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
    private void btnTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerActionPerformed
        iniciarCronometro();
        iniciarIntervalo();

    }//GEN-LAST:event_btnTimerActionPerformed

    private void panelTimerVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_panelTimerVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_panelTimerVetoableChange

    private void btnRedMaisUm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMaisUm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedMaisUm1ActionPerformed

    private void btnRedMaisTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMaisTresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedMaisTresActionPerformed

    private void iniciarCronometro() {
        
                if(roundParado && intervaloParado && !intervaloRodando){
//                    <html>Vermelho + 1<br><center><font color="#E88C2C">(F1)</html>
                    
                    btnTimer.setText("<html><center>Pausar<br><font color=\"#E88C2C\">(Enter)</html>");
                roundParado= false;
                lblStatus.setVisible(false);
                ActionListener action = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    lblRound.setText(String.valueOf(contadorRound));
                    currentSegundoRound--;
                    if (currentSegundoRound < 00) {
                        currentMinutoRound--;
                        currentSegundoRound = 59;
                    }
                    if (currentMinutoRound == 0 && currentSegundoRound == 0) {
                        contadorRound++;
                        lblRound.setText(String.valueOf(contadorRound));
                        timerRound.stop();
                        carregaConfiguracoesTimer();
                        roundParado= true;
                        intervaloParado = true;
                        intervaloRodando= false;
                        fimRound= true;
                        iniciarIntervalo();
                        

                    }
                    String min = currentMinutoRound <= 9 ? "0" + currentMinutoRound : currentMinutoRound + "";
                    String seg = currentSegundoRound <= 9 ? "0" + currentSegundoRound : currentSegundoRound + "";
                    
                    lblMinutoTimer.setText(min);
                    lblSegundoTimer.setText(seg);
                }
            };

            if (currentMinutoRound >= 0 && currentSegundoRound >= 0) {
                this.timerRound = new Timer(velocidade, action);
                this.timerRound.start();
            } 
                }else{
                    roundParado= true;
                    this.timerRound.stop();
                     btnTimer.setText("<html><center>Resumir<br><font color=\"#E88C2C\">(Enter)</html>");
                }
         
    }

    private void iniciarIntervalo() {
        if(!intervaloRodando && roundParado&& intervaloParado && fimRound){
            btnTimer.setText("<html><center>Pausar<br><font color=\"#E88C2C\">(Enter)</html>");
            intervaloRodando= true;
            intervaloParado= false;
        lblStatus.setText("Intervalo");
        lblStatus.setVisible(true);
        lblIntervaloTimer.setVisible(true);
       
            ActionListener action2 = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    currentSegundoIntervalo--;
                    if (currentSegundoIntervalo < 00) {
                        currentMinutoIntervalo--;
                        currentSegundoIntervalo = 59;
                    }
                    if (currentMinutoIntervalo == 0 && currentSegundoIntervalo == 0) {
                        intervaloRodando = false;
                        intervaloParado = true;
                        
                        timerIntervalo.stop();
                        lblStatus.setText("Parado");
                        lblIntervaloTimer.setVisible(false);
                        fimRound = false;
                        roundParado= true;
                        if(contadorRound <= quantidadeRounds){
                        btnTimer.setText("Iniciar Round "+String.valueOf(contadorRound));
                        }
                        else{
                        btnTimer.setText("<html><center>Finalizar<br><font color=\"#E88C2C\">(Enter)</html>");
                        }

                    }
                    String minIntervalo = currentMinutoIntervalo <= 9 ? "0" + currentMinutoIntervalo : currentMinutoIntervalo + "";
                    String segIntervalo = currentSegundoIntervalo <= 9 ? "0" + currentSegundoIntervalo : currentSegundoIntervalo + "";

                    lblIntervaloTimer.setText(minIntervalo + " : " + segIntervalo);

                }
            };
            if (currentMinutoIntervalo >= 0 && currentSegundoIntervalo >= 0) {
                System.out.println("mi: " + currentMinutoIntervalo);
                System.out.println("si: " + currentSegundoIntervalo);
                this.timerIntervalo = new Timer(velocidade, action2);
                this.timerIntervalo.start();
            } 
        
        }
        else{   
                if(intervaloRodando && fimRound && !intervaloParado){
                this.timerIntervalo.stop();
                intervaloRodando = false;
                intervaloParado = true;
                roundParado= false;
                btnTimer.setText("<html><center>Resumir<br><font color=\"#E88C2C\">(Enter)</html>");
                }
        }

    }

    private void showDialogConfiguracoes() {
        Parametros param = new Parametros();
        Cron cronometro = this;
        param.setCronometro(cronometro);
        System.out.println("Contador Tela Atual: "+ cronometro.contadorAzul);
        System.out.println("Contador Tela Config: "+ param.getCronometro().contadorAzul);
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
        int minutosInt = 0;
        int segundosInt = 0;
        if(minutosRound != null && !minutosRound.isEmpty()){
            minutosInt = Integer.parseInt(minutosRound);
        } 
        if(segundosRound!= null && !segundosRound.isEmpty()){
            segundosInt = Integer.parseInt(segundosRound);
        }
                
         
        String min = minutosInt <= 9 ? "0" + minutosInt : minutosInt + "";
        String seg = segundosInt <= 9 ? "0" + segundosInt : segundosInt + "";
        lblMinutoTimer.setText(min);
        lblSegundoTimer.setText(seg);
        lblIntervaloTimer.setVisible(false);
        btnTimer.setText("<html><center>Iniciar Luta<br><font color=\"#E88C2C\">(Enter)</html>");

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
    public javax.swing.JLabel bluePontuacao;
    private javax.swing.JButton btnBlueFaltaMais;
    private javax.swing.JButton btnBlueFaltaMenos;
    public javax.swing.JButton btnBlueMaisUm;
    private javax.swing.JButton btnBlueMenosUm;
    private javax.swing.JButton btnRedFaltaMais;
    private javax.swing.JButton btnRedFaltaMenos;
    public javax.swing.JButton btnRedMaisDois;
    public javax.swing.JButton btnRedMaisTres;
    public javax.swing.JButton btnRedMaisUm1;
    private javax.swing.JButton btnRedMenosUm;
    private javax.swing.JButton btnTimer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblIntervaloTimer;
    private javax.swing.JLabel lblMinutoTimer;
    private javax.swing.JLabel lblRound;
    private javax.swing.JLabel lblSegundoTimer;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTituloRound;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelTimer;
    private javax.swing.JLabel redFaltaContador;
    private javax.swing.JLabel redPontuacao;
    // End of variables declaration//GEN-END:variables
}

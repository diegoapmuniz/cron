/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cron;

import entidades.Parameter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import util.Constantes;

/**
 *
 * @author p062964
 */
public final class Parametros extends JDialog{
    public int teste = 10;
    public String minutosRound ;
    public String segundosRound;
    public String portaCom;
    public String minutosIntervalo;
    public String segundosIntervalo;
    public String logo;
    public String nomeEntidade;
    public String serialEquipamento;
    public String quantidadeRound;
    public List<Parameter> listaParametros;
    //private CommPortIdentifier com;
    private CommPortIdentifier com;
   

    
    
    
    

    public int getTeste() {
        return teste;
    }

    public void setTeste(int teste) {
        this.teste = teste;
    }
    /**
     * Creates new form Parametros
     */
    public Parametros() {
         
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Funcoes funcoes = new Funcoes();
        setListaParametros(funcoes.carregaParametros());
        initComponents();
        popularPortas();
        List<Parameter> lista ;
        
        lista = getListaParametros();
        if(lista.size()>0){
            for(int i=0;i<lista.size();i++){
                if(Constantes.VAR_MINUTOS_ROUND.equals(lista.get(i).getName())){
                    setMinutosRound(lista.get(i).getValue());
                }
                if(Constantes.VAR_SEGUNDOS_ROUND.equals(lista.get(i).getName())){
                    setSegundosRound(lista.get(i).getValue());
                }
                if(Constantes.VAR_PORTA_COMUNICACAO.equals(lista.get(i).getName())){
                    setPortaCom(lista.get(i).getValue());
                }
                if(Constantes.VAR_MINUTOS_INTERVALO.equals(lista.get(i).getName())){
                    setMinutosIntervalo(lista.get(i).getValue());
                }
                if(Constantes.VAR_SEGUNDOS_INTERVALO.equals(lista.get(i).getName())){
                    setSegundosIntervalo(lista.get(i).getValue());
                }
                if(Constantes.VAR_LOGO.equals(lista.get(i).getName())){
                    setLogo(lista.get(i).getValue());
                }
                if(Constantes.VAR_NOME_ENTIDADE.equals(lista.get(i).getName())){
                     setNomeEntidade(lista.get(i).getValue());
                }
                if(Constantes.VAR_SERIAL_EQUIP.equals(lista.get(i).getName())){
                     setSerialEquipamento(lista.get(i).getValue());
                }
                if(Constantes.VAR_QTD_ROUNDS.equals(lista.get(i).getName())){
                     setQuantidadeRound(lista.get(i).getValue());
                }         
                
            }
        }
        else{
        //TODO Salvar lista com parãmetros padrão 
        }
        fldMinutosIntervalo.setText(getMinutosIntervalo());
        fldSegundosIntervalo.setText(getSegundosIntervalo());
        fldMinutosRound.setText(getMinutosRound());
        fldSegundosRound.setText(getSegundosRound());
        fldNomeEntidade.setText(getNomeEntidade());
        fldNumeroSerie.setText(getSerialEquipamento());
        fldQuantidadeRounds.setText(getQuantidadeRound());
        
        
        addWindowListener(new WindowAdapter() {
                @Override public void windowClosing(WindowEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int resultadoDlg = JOptionPane.showConfirmDialog (null, "Os Dados Não foram Salvos, deseja continuar","Warning",dialogButton);
                if(resultadoDlg == JOptionPane.YES_OPTION){
                   dispose();
                }else{
                   
                }
                }
            });
    }
    
  public void popularPortas() {
         DefaultComboBoxModel comboModel = (DefaultComboBoxModel) selectCom.getModel();
        selectCom.removeAllItems();
        Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            CommPortIdentifier cpi = (CommPortIdentifier) portList.nextElement();
            if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                selectCom.addItem(cpi.getName());

            }
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        lblMinR = new javax.swing.JLabel();
        lblSegR = new javax.swing.JLabel();
        lblPortaCom = new javax.swing.JLabel();
        lblMinIntervalo = new javax.swing.JLabel();
        lblSegIntervalo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNomEntidade = new javax.swing.JLabel();
        lblSerialEquipamento = new javax.swing.JLabel();
        lblQtdRounds = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        selectCom = new javax.swing.JComboBox();
        fldNumeroSerie = new javax.swing.JTextField();
        fldNomeEntidade = new javax.swing.JTextField();
        fldQuantidadeRounds = new javax.swing.JTextField();
        fldSegundosIntervalo = new javax.swing.JTextField();
        fldMinutosIntervalo = new javax.swing.JTextField();
        fldSegundosRound = new javax.swing.JTextField();
        fldMinutosRound = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");
        setResizable(false);

        lblMinR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMinR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinR.setText("Minutos Round:");
        lblMinR.setToolTipText("");

        lblSegR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSegR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSegR.setText("Segundos Round:");
        lblSegR.setToolTipText("");

        lblPortaCom.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPortaCom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPortaCom.setText("Porta Comunicação:");

        lblMinIntervalo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMinIntervalo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinIntervalo.setText("Minutos Intervalo:");

        lblSegIntervalo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSegIntervalo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSegIntervalo.setText("Segundos Intervalo:");

        lblLogo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogo.setText("Logo:");

        lblNomEntidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomEntidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNomEntidade.setText("Nome Entidade:");

        lblSerialEquipamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSerialEquipamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSerialEquipamento.setText("Número Serial:");

        lblQtdRounds.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblQtdRounds.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQtdRounds.setText("Quantidade Rounds:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnSalvar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        selectCom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectComActionPerformed(evt);
            }
        });

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(599, 599, 599)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblMinR, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSegR, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMinIntervalo, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSegIntervalo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblQtdRounds, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNomEntidade, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSerialEquipamento, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPortaCom, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldQuantidadeRounds)
                    .addComponent(fldSegundosIntervalo)
                    .addComponent(fldMinutosIntervalo)
                    .addComponent(fldSegundosRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldMinutosRound, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectCom, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConectar))
                    .addComponent(fldNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblLogo, lblMinIntervalo, lblMinR, lblNomEntidade, lblPortaCom, lblQtdRounds, lblSegIntervalo, lblSegR, lblSerialEquipamento});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fldMinutosIntervalo, fldMinutosRound, fldQuantidadeRounds, fldSegundosIntervalo, fldSegundosRound});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinR, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(fldMinutosRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegR, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(fldSegundosRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMinIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fldMinutosIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSegIntervalo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(fldSegundosIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQtdRounds, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldQuantidadeRounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomEntidade, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(fldNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSerialEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPortaCom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnConectar)
                                .addGap(16, 16, 16)))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblPortaCom, selectCom});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fldMinutosIntervalo, fldMinutosRound, fldNomeEntidade, fldNumeroSerie, fldQuantidadeRounds, fldSegundosIntervalo, fldSegundosRound, lblSerialEquipamento});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblLogo, lblQtdRounds});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectComActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectComActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
           this.setVisible(false);
           this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Funcoes func = new Funcoes();
        List<Parameter> listaSalvar = new ArrayList<>();
        List<Parameter> listaParametros = getListaParametros() ;
        
        for(int i=0;i<listaParametros.size();i++){
            
                if(Constantes.VAR_MINUTOS_ROUND.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fldMinutosRound.getText());
                    
                }
                if(Constantes.VAR_SEGUNDOS_ROUND.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fldSegundosRound.getText());
                }
                /*if(Constantes.VAR_PORTA_COMUNICACAO.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fld.getText());
                }*/
                if(Constantes.VAR_MINUTOS_INTERVALO.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fldMinutosIntervalo.getText());
                }
                if(Constantes.VAR_SEGUNDOS_INTERVALO.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fldSegundosIntervalo.getText());
                }
                /*if(Constantes.VAR_LOGO.equals(listaParametros.get(i).getName())){
                    listaParametros.get(i).setValue(fld.getText());
                }*/
                if(Constantes.VAR_NOME_ENTIDADE.equals(listaParametros.get(i).getName())){
                     listaParametros.get(i).setValue(fldNomeEntidade.getText());
                }
                if(Constantes.VAR_SERIAL_EQUIP.equals(listaParametros.get(i).getName())){
                     listaParametros.get(i).setValue(fldNumeroSerie.getText());
                }
                if(Constantes.VAR_QTD_ROUNDS.equals(listaParametros.get(i).getName())){
                     listaParametros.get(i).setValue(fldQuantidadeRounds.getText());
                } 
            
            listaSalvar.add(listaParametros.get(i));
            
        }
        
        func.salvaParametros(listaSalvar);
        this.dispose();
        
    }//GEN-LAST:event_btnSalvarActionPerformed
public void abrePortaCom() throws NoSuchPortException {
/*
* Para a porta ser aberta precisa ter um identificador do tipo da porta, para isso usa-se o método getPortIdentifier("Qual é a porta? COM1, LPT1 ...") da classe CommPortIdentifier.
* 
* Tendo feito isso há a necessidade, agora, de instanciar o tipo da porta que foi escolhida, nesse caso a porta serial a qual recebe o identificador juntamente com o método open() que recebe como parâmetro um nome identificador (um título) e o tempo de espera de alguma resposta (timeout).
* 
* Estando a porta aberta, configura-se os parâmetros de comunicação serial. 
*/String porta = selectCom.getSelectedItem().toString();

    com = CommPortIdentifier.getPortIdentifier(porta);
    
try{
    
   
       
   int timeout = 6000;
   int baudrate = 9600;
   SerialPort portaSerial = null;
        try {
            portaSerial = (SerialPort)com.open("PlacaSensoriamento",timeout);
        } catch (PortInUseException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, null, ex);
        }
   JOptionPane.showMessageDialog(null, "Configurando Porta Serial");
   portaSerial.setSerialPortParams(baudrate, portaSerial.DATABITS_8, portaSerial.STOPBITS_1, portaSerial.PARITY_NONE);
}

catch (UnsupportedCommOperationException uscoe){
   System.err.println("Configuração dos parametros da porta não suportada!");
}
}
    
    
    
    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        try {
            abrePortaCom();
        } catch (NoSuchPortException ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    
    
    
    /**
     * 
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
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                      new Parametros().setVisible(true);
                
            }
        });
    }

    public String getMinutosRound() {
        return minutosRound;
    }

    public void setMinutosRound(String minutosRound) {
        this.minutosRound = minutosRound;
    }

    public String getSegundosRound() {
        return segundosRound;
    }

    public void setSegundosRound(String segundosRound) {
        this.segundosRound = segundosRound;
    }

    public String getPortaCom() {
        return portaCom;
    }

    public void setPortaCom(String portaCom) {
        this.portaCom = portaCom;
    }

    public String getMinutosIntervalo() {
        return minutosIntervalo;
    }

    public void setMinutosIntervalo(String minutosIntervalo) {
        this.minutosIntervalo = minutosIntervalo;
    }

    public String getSegundosIntervalo() {
        return segundosIntervalo;
    }

    public void setSegundosIntervalo(String segundosIntervalo) {
        this.segundosIntervalo = segundosIntervalo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public String getSerialEquipamento() {
        return serialEquipamento;
    }

    public void setSerialEquipamento(String serialEquipamento) {
        this.serialEquipamento = serialEquipamento;
    }

    public String getQuantidadeRound() {
        return quantidadeRound;
    }

    public void setQuantidadeRound(String quantidadeRound) {
        this.quantidadeRound = quantidadeRound;
    }

    public List<Parameter> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(List<Parameter> listaParametros) {
        this.listaParametros = listaParametros;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField fldMinutosIntervalo;
    private javax.swing.JTextField fldMinutosRound;
    private javax.swing.JTextField fldNomeEntidade;
    private javax.swing.JTextField fldNumeroSerie;
    private javax.swing.JTextField fldQuantidadeRounds;
    private javax.swing.JTextField fldSegundosIntervalo;
    private javax.swing.JTextField fldSegundosRound;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMinIntervalo;
    private javax.swing.JLabel lblMinR;
    private javax.swing.JLabel lblNomEntidade;
    private javax.swing.JLabel lblPortaCom;
    private javax.swing.JLabel lblQtdRounds;
    private javax.swing.JLabel lblSegIntervalo;
    private javax.swing.JLabel lblSegR;
    private javax.swing.JLabel lblSerialEquipamento;
    private javax.swing.JComboBox selectCom;
    // End of variables declaration//GEN-END:variables
}

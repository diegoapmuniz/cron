package util;

/**
 *
 * @author Diego Muniz <diego2605@gmail.com>
 */


 
import cron.Parametros;
import java.awt.Component;
import java.awt.HeadlessException;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import javax.comm.PortInUseException;
import javax.comm.UnsupportedCommOperationException;
import javax.swing.JOptionPane;
 
public class ControlePorta {
  private OutputStream serialOut;
  private int taxa;
  private String portaCOM;
  private SerialPort port;
  public SerialPort portHist;
  private Component Parametros;

    public SerialPort getPortHist() {
        return portHist;
    }

    public void setPortHist(SerialPort portHist) {
        this.portHist = portHist;
    }
  public String nomeConexao = Constantes.VAR_NOME_COMUNICACAO_SERIAL;

  /**
   * Construtor da classe ControlePorta
   * @param portaCOM - Porta COM que será utilizada para enviar os dados para o arduino
   * @param taxa - Taxa de transferência da porta serial geralmente é 9600
   */
  public ControlePorta(String portaCOM, int taxa) {
    this.portaCOM = portaCOM;
    this.taxa = taxa;
    this.initialize();
  }     
 
  /**
   * Médoto que verifica se a comunicação com a porta serial está ok
   */
  private void initialize() {
    try {
      //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
      CommPortIdentifier portId = null;
      try {
        //Tenta verificar se a porta COM informada existe
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
      }catch (NoSuchPortException npe) {
        //Caso a porta COM não exista será exibido um erro 
        JOptionPane.showMessageDialog(Parametros, Mensagens.msgFalhaEncontrarSerial,Mensagens.lblTituloFalhaEncontrarSerial, JOptionPane.ERROR_MESSAGE); 

      }
      SerialPort teste = this.getPortHist();
    //Abre a porta COM 
      if(port != null){
         portId = null;
      }
      boolean portaAberta = portId.isCurrentlyOwned();
      String owner = portId.getCurrentOwner();
      if((portaAberta)&&(!nomeConexao.equals(owner))){
       
       port.close();
       portId = null;
      }
      if(portaAberta){
          port.close();
       // port(portId);
      }else{
      port = (SerialPort) portId.open(nomeConexao, this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
          setPortHist(port);
          JOptionPane.showMessageDialog(Parametros, Mensagens.msgConexaoPortaSucesso,"", JOptionPane.INFORMATION_MESSAGE); 
          
     
      }
    }catch (HeadlessException | IOException | PortInUseException | UnsupportedCommOperationException e) {
      e.printStackTrace();
    }
}
 
  /**
   * Método que fecha a comunicação com a porta serial
   */
  public void close() {
    try {
        serialOut.close();
    }catch (IOException e) {
      JOptionPane.showMessageDialog(null, Mensagens.msgFalhaDesconectarSerial,
                Mensagens.lblTituloFecharSerial, JOptionPane.PLAIN_MESSAGE);
    }
  }
 
  /**
   * @param opcao - Valor a ser enviado pela porta serial
   */
  public void enviaDados(int opcao){
    try {
      serialOut.write(opcao);//escreve o valor na porta serial para ser enviado
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
    }
  } 

}
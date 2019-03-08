package util;

/**
 *
 * @author Diego Muniz <diego2605@gmail.com>
 */

 
import cron.Cron;
import cron.Parametros;
import java.awt.Component;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

 
public class ControlePorta implements Runnable,SerialPortEventListener {
  private OutputStream serialOut;
  private InputStream serialIn;
  private int taxa = Constantes.VAR_TAXA_SERIAL;
  private String portaCOM;
  private SerialPort port;
  public SerialPort portHist;
  private Component Parametros;
  protected String peso;
  private InputStream entrada;

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

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
      }catch (Exception npe) {
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
      taxa = Constantes.VAR_TAXA_SERIAL;
      port = (SerialPort) portId.open(nomeConexao, this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
          setPortHist(port);
          JOptionPane.showMessageDialog(Parametros, Mensagens.msgConexaoPortaSucesso,"", JOptionPane.INFORMATION_MESSAGE); 
          
          //Diego 04/03/2019
          LerDados(port);
     
      }
    }catch (HeadlessException | IOException | PortInUseException | UnsupportedCommOperationException e) {
      e.printStackTrace();
    }
}
 
  /**
   * Método que fecha a comunicação com a porta serial
   */
  public void close() {
      FecharCom();
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
  
  
  //Diego 04/03/2019
  

  private Thread threadLeitura;
  
  public void LerDados(SerialPort porta){
        boolean Escrita = false;
        
        
        if (Escrita == false){

            try {

                entrada = porta.getInputStream();

            } catch (Exception e) {

                System.out.println("Erro de stream: " + e);

                System.exit(1);

            }

            try {

                porta.addEventListener(this);

            } catch (Exception e) {

                System.out.println("Erro de listener: " + e);

                System.exit(1);

            }

            porta.notifyOnDataAvailable(true);

            try {

                threadLeitura = new Thread( this);

                threadLeitura.start();
                
               run();

            } catch (Exception e) {

                System.out.println("Erro de Thred: " + e);

            }

        }
        
        

}
 
  public void FecharCom(){

            try {

                port.close();
                stop();

            } catch (Exception e) {

                System.out.println("Erro fechando porta: " + e);

                System.exit(0);

            }

}
  
  @Override
  public void serialEvent(SerialPortEvent ev){       

        StringBuffer bufferLeitura = new StringBuffer();

        int novoDado = 0;

       

        switch (ev.getEventType()) {

            case SerialPortEvent.BI:

            case SerialPortEvent.OE:

            case SerialPortEvent.FE:

            case SerialPortEvent.PE:

            case SerialPortEvent.CD:

            case SerialPortEvent.CTS:

            case SerialPortEvent.DSR:

            case SerialPortEvent.RI:

            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:

            break;

            case SerialPortEvent.DATA_AVAILABLE:

                //Novo algoritmo de leitura.

                while(novoDado != -1){

                    try{

                        novoDado = entrada.read();

                        if(novoDado == -1){

                            break;

                        }

                        if('\r' == (char)novoDado){

                            bufferLeitura.append('\n');

                        }else{

                            bufferLeitura.append((char)novoDado);

                        }

                    }catch(IOException ioe){

                        System.out.println("Erro de leitura serial: " + ioe);

                    }

                }

         
                
                       
                        
                        System.out.println("Teste: "+(new String(bufferLeitura)));

               
              
            
                   

            break;

        }

} 
  
  
  public void run(){

        try {

            Thread.sleep(5);

        } catch (Exception e) {

            System.out.println("Erro de Thred: " + e);

        }

}

  
  public void stop(){

        try {

            threadLeitura.interrupt();
  

        } catch (Exception e) {

            System.out.println("Erro de Thred: " + e);

        }

}
  
  

}
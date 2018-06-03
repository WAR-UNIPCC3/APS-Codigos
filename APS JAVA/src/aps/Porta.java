package aps;

import static aps.absPropriedades.porta;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Porta extends absPropriedades implements Runnable, SerialPortEventListener
{

    public Porta(int baudrate, int timeout, String Porta)
    {
        super(baudrate, timeout, Porta);
        Executar();
    }
    
    public Porta(BufferedReader input)
    {
        super(input);
    }
    
    @Override
    public void run()
    {}

    @Override
    public void serialEvent(SerialPortEvent ev)
    {}
    
    @Override
    public void Executar()
    {
        try
        {
            this.cp = CommPortIdentifier.getPortIdentifier(Porta);
            porta = (SerialPort)cp.open("SerialComLeitura", timeout);
            
            //Parametros
            porta.setSerialPortParams(baudrate, porta.DATABITS_8, porta.STOPBITS_1, porta.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            
            input = new BufferedReader(new InputStreamReader(porta.getInputStream()));
            
            
        }
        catch (Exception e)
        {}
            SerialComunicacao.Main men = new SerialComunicacao.Main(this.porta);
        {}
    }
            
}

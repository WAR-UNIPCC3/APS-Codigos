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
    public Porta(String p, int b, int t)
    {
        super(p, b, t);
        Executar();
    }

    public Porta(BufferedReader input)
    {
        super(input);
    }
    
    @Override
    public void run()
    {
    }

    @Override
    public void serialEvent(SerialPortEvent ev)
    {
    }
    
    @Override
    public void Executar()
    {
        this.baudrate = b;
        this.timeout = t;
        this.Porta = p;
        
        try
        {
            this.cp = CommPortIdentifier.getPortIdentifier(Porta);
            porta = (SerialPort)cp.open("SerialComLeitura", timeout);
            this.PortaOk = true;
            
            //Parametros
            porta.setSerialPortParams(baudrate, porta.DATABITS_8, porta.STOPBITS_1, porta.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            
            input = new BufferedReader(new InputStreamReader(porta.getInputStream()));
            
            this.IDPortaOk = true;
            
        }
        catch (Exception e)
        {
            this.PortaOk = false;
            this.IDPortaOk = false;
        }
            SerialComunicacao.Main men = new SerialComunicacao.Main(this.porta);
        {
        }
    }
            
}

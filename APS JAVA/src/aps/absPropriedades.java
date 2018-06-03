package aps;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStream;

public abstract class absPropriedades implements Interface, Runnable, SerialPortEventListener
{
    public String Dadoslidos;
    public int nodeBytes;
    public int baudrate;
    public int timeout;
    public CommPortIdentifier cp;
    public static SerialPort porta;
    public InputStream entrada;
    public Thread threadLeitura;
    public String Porta;
    protected String temperatura;
    public BufferedReader input;
    public StringBuffer bufferLeitura;

    public absPropriedades(String Dadoslidos)
    {
        this.Dadoslidos = Dadoslidos;
    }
    
    public String getTemperatura()
        {
            return temperatura;
        }

    public void setTemperatura(String temperatura)
        {
            this.temperatura = temperatura;
        }

    public absPropriedades(BufferedReader input)
        {
            this.input = input;
        }
    
    public absPropriedades(SerialPort porta)
        {
            this.porta = porta;
        }

    public absPropriedades(int baudrate, int timeout, String Porta)
        {
            this.baudrate = baudrate;
            this.timeout = timeout;
            this.Porta = Porta;
        }

    public absPropriedades()
    {}
    
    public void run()
    {}
    
    public void serialEvent(SerialPortEvent ev)
    {

    }
}

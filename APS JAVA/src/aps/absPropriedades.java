package aps;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;

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
    public boolean IDPortaOk;
    public boolean PortaOk;
    public String Porta;
    public String temperatura;
    public String p;
    public int b;
    public int t;
    public String Dados;
    public BufferedReader input;

    public String getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(String temperatura)
    {
        this.temperatura = temperatura;
    }

    public absPropriedades(String p, int b, int t)
    {
        this.b = b;
        this.t = t;
        this.p = p;
    }

    public absPropriedades(BufferedReader input)
    {
        this.input = input;
    }
    
    public absPropriedades(boolean IDPortaOk, boolean PortaOk, SerialPort porta)
    {
        this.IDPortaOk = IDPortaOk;
        this.PortaOk = PortaOk;
        this.porta = porta;
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

    public absPropriedades(String Dados)
    {
        this.Dados = Dados;
    }

    public absPropriedades()
    {
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(5);
        }
        catch(Exception e)
        {
        }
    }
    
    public void serialEvent(SerialPortEvent ev)
    {       
    }
}

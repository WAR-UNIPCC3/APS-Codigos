package aps;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LerDados extends absPropriedades implements Runnable,SerialPortEventListener
{

    public LerDados(String Porta, int baudrate, int timeout)
    {
        super(Porta, baudrate, timeout);
    }

    
    public LerDados(SerialPort porta)
    {
        super(porta);
        Executar();
    }

    public LerDados(String Dados)
    {
        super(Dados);
    }

    public LerDados(BufferedReader input)
    {
        super(input);
    }
    
    @Override
    public void Executar()
    {
        try
        {
            this.entrada = porta.getInputStream();
            porta.addEventListener(this);
        }
        catch (Exception e)
        {
        }
                
    porta.notifyOnDataAvailable(true);
    
        try
        {
            threadLeitura = new Thread(this);
            threadLeitura.start();
            run();
        }
        catch (Exception e)
        {
        }
    }   

    @Override
    public void serialEvent(SerialPortEvent ev)
    {
        StringBuffer bufferLeitura = new StringBuffer();
        int novoDado = 0;
       
        switch (ev.getEventType()) 
        {
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
                while(novoDado != -1)
                {
                    try
                    {
                        novoDado = entrada.read();
                        if(novoDado == -1)
                        {
                            break;
                        }
                        if('\r' == (char)novoDado)
                        {
                            bufferLeitura.append('\n');
                        }
                        else
                        {
                            bufferLeitura.append((char)novoDado);
                        }
                    }
                    catch(IOException ioe)
                    {
                        System.out.println("Erro de leitura serial: " + ioe);
                    }
                }
                
                StringWriter sw = new StringWriter();
                PrintWriter out = new PrintWriter(sw);
                setTemperatura(new String(bufferLeitura));
                System.out.println(getTemperatura());
                
            break;
        }
    }
   
    
    @Override
    public void run()
    {
    }
    @Override
    public String toString()
    {
              return this.temperatura;
    }
}

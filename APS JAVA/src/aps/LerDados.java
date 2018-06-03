package aps;

import Apresentacao.frmPrincipal;
import SerialComunicacao.Main;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;

public class LerDados extends absPropriedades implements Runnable,SerialPortEventListener
{

    public LerDados()
    {}

    public LerDados(SerialPort porta, SerialPortEvent ev)
    {
        super(porta);
        Executar();
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
        {}
                
    porta.notifyOnDataAvailable(true);
    
        try
        {
            threadLeitura = new Thread(this);
            threadLeitura.start();
            run();
        }
        catch (Exception e)
        {}
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
                        Dadoslidos = new String(bufferLeitura);  
                        Main dado = new Main(this.Dadoslidos);
                        {
                        }
            break;
        } 
    }
    @Override
    public void run()
    {
                try
        {
            Thread.sleep(5);
        }
        catch(Exception e)
        {}
    }
}

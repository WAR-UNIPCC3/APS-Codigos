package Modelo;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class GerenciadorLeitura extends absPropriedades implements SerialPortEventListener, Runnable
{
    public String mensagem;
    StringBuffer bufferLeitura = new StringBuffer();
    public GerenciadorLeitura(SerialPort serialPort)
    {
        super(serialPort);
        Executar();
    }    

    @Override
    public void Executar()
    {
        this.mensagem = "";
        try
        {
            this.entradaDados = serialPort.getInputStream();
            serialPort.addEventListener(this);
        }
        catch (Exception e)
        {
            this.mensagem = "Erro ao receber dados";
        }
        serialPort.notifyOnDataAvailable(true);
            try
            {
                threadLeitura = new Thread(this);
                threadLeitura.start();
                run();
            }
            catch (Exception e)
            {
                        
            }
            this.setTexto(new String(bufferLeitura));
    }
    
    @Override
    public void serialEvent (SerialPortEvent ev)
    {
        
        int novoDado = 0;
        
        switch(ev.getEventType())
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
                
                while(novoDado != -1)
                {
                    try
                    {
                        novoDado = entradaDados.read();
                    
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
                    catch(Exception e)
                    {
                        this.mensagem += "Erro na leitura dos dados";
                    }
                }
            break;
        }
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            this.mensagem = "Parou Thread";
        }
    }
}

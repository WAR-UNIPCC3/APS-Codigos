package Modelo;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.InputStream;

public abstract class absPropriedades implements Interface
{
    public static SerialPort serialPort;
    public BufferedReader input;
    public int timeout;
    public static String portaSerial;
    public CommPortIdentifier identPorta;
    public InputStream entradaDados;
    public Thread threadLeitura;
    public StringBuffer leitorDados;
    private String texto;
    public int baudrate;
    public String porta;
    public boolean status;

    public absPropriedades(int baudrate, int timeout, String porta)
    {
        this.baudrate = baudrate;
        this.timeout = timeout;
        this.porta = porta;
    }
    
    public absPropriedades(SerialPort serialPort)
    {
        this.serialPort = serialPort;
    }

    public absPropriedades(boolean status)
    {
        this.status = status;
    }

    public absPropriedades()
    {
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }
    
}

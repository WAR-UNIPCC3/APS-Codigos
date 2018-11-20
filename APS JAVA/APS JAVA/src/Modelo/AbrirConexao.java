package Modelo;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class AbrirConexao extends absPropriedades
{
    public String mensagem;
    
    public AbrirConexao(int baudrate, int timeout, String porta)
    {
        super(baudrate, timeout, porta);
        Executar();
    }

    public boolean iniciaSerial()
    {
        this.mensagem = "";
        status = false;
        try
        {
            this.identPorta = CommPortIdentifier.getPortIdentifier("COM3");
            serialPort = (SerialPort) identPorta.open("Comunicacao", timeout);
            serialPort.setSerialPortParams(baudrate, serialPort.DATABITS_8, serialPort.STOPBITS_1, serialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            this.status = true;
        }
        catch (Exception e)
        {
            this.mensagem = "Erro ao conectar serial";
        }
        return status;
    }
    
    @Override
    public void Executar()
    {
        iniciaSerial();
    }
}

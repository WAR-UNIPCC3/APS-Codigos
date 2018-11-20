package Modelo;

import static Modelo.absPropriedades.serialPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class FecharPorta extends absPropriedades
{
    public String mensagem;

    public FecharPorta(int baudrate, int timeout, String porta)
    {
        super(baudrate, timeout, porta);
        Executar();
    }

    @Override
    public void Executar()
    {
        this.mensagem = "";
        try
        {
            this.identPorta = CommPortIdentifier.getPortIdentifier("COM3");
            serialPort.setSerialPortParams(baudrate, serialPort.DATABITS_8, serialPort.STOPBITS_1, serialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.close();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro ao fechar serial";
        }
        System.exit(0);
    }
}

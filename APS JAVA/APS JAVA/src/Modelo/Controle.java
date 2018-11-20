package Modelo;

public class Controle extends absPropriedades implements Runnable
{
    public String mensagem;

    public Controle(boolean status)
    {
        super(status);
        Executar();
    }
    public Controle(String texto)
    {
    }
    
    @Override
    public void Executar()
    {
        this.mensagem = "";
        AbrirConexao conexao = new AbrirConexao(9600, 0, "COM3");
        if(conexao.mensagem.equals(""))
        {
            GerenciadorLeitura gerenciador = new GerenciadorLeitura(conexao.serialPort);
            if(gerenciador.mensagem.equals(""))
            {
                setTexto(gerenciador.getTexto());
                GravacaoJson gravacao = new GravacaoJson();
                if(gravacao.mensagem.equals(""))
                    {
                    }
                    else
                    {
                        this.mensagem = gravacao.mensagem;
                    }  
            }
            else
            {
                this.mensagem = gerenciador.mensagem;
            }
        }
        else
        {
            this.mensagem = conexao.mensagem;
        }
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5001);
        }
        catch (Exception e)
        {
        }
    }
}

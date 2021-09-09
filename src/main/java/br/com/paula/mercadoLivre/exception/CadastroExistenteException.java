package br.com.paula.mercadoLivre.exception;

public class CadastroExistenteException extends  RuntimeException{

    public  CadastroExistenteException(){
        super("Já existe um cadastrado com estes dados");
    }
}

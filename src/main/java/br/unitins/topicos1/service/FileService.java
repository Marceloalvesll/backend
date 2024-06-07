package br.unitins.topicos1.service;

import java.io.File;

public interface FileService {

    // String salvar(String nomeArquivo, byte[] arquivo) throws IOException;

    // File obter(String nomeArquivo); 

    void salvar(Long id, String nomeImagem, byte[] imagem);

    File download(String nomeArquivo);


    
} 
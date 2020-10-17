package com.fatec.spring.boot.repository;

import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Papel;
import com.fatec.spring.boot.model.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Sham e Lucas
 */

@Disabled("Teste antigo não passando em 17-10-2020")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ImagemRepositoryTest {

    private static final String nome = "img";
    private static final String tipo = "tipo";
    private static final String tamanho = "1x1";
    private static final byte[] blob = {1, 2};

    private static final String nomeU = "Usuario X";
    private static final String emailU = "user@user.com";
    private static final String userU = "user";
    private static final String senhaU = "123";

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;


    public void setImagemRepository(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void setPapelRepository(PapelRepository papelRepository) {
        this.papelRepository = papelRepository;
    }

    @Test
    public void insercaoImagemTest() {
        Usuario usuario = new Usuario();
        usuario.setNome(nomeU);
        usuario.setEmail(emailU);
        ;
        usuario.setSenha(senhaU);
        usuario.setUsuario(userU);

        Papel papel = papelRepository.findById(1L).get();
        usuario.setPapel(papel);
        usuarioRepository.save(usuario);

        Imagem imagem = new Imagem();
        imagem.setNome(nome);
        imagem.setTamanho(tamanho);
        imagem.setTipo(tipo);
        imagem.setImagemBlob(blob);
        imagem.setUsuario(usuario);

        imagemRepository.save(imagem);

        assertNotNull(imagem.getId());

    }

    @Test
    public void buscaTest() {

        Usuario usuario = new Usuario();
        usuario.setNome(nomeU);
        usuario.setEmail(emailU);
        ;
        usuario.setSenha(senhaU);
        usuario.setUsuario(userU);

        Papel papel = papelRepository.findById(1L).get();
        usuario.setPapel(papel);
        usuarioRepository.save(usuario);

        Imagem expected = new Imagem();
        expected.setNome(nome);
        expected.setTamanho(tamanho);
        expected.setTipo(tipo);
        expected.setImagemBlob(blob);
        expected.setUsuario(usuario);

        imagemRepository.save(expected);

        Imagem actual = imagemRepository.findById(expected.getId()).get();

        assertEquals(expected, actual);

    }

}

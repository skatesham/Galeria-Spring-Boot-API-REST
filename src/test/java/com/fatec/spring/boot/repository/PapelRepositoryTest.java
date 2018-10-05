package com.fatec.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.spring.boot.model.Papel;


/**
 * @author Sham e Lucas
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PapelRepositoryTest {

    private static final String descricao = "Papel Teste";

    @Autowired
    private PapelRepository papelRepository;

    public void setPapelRepository(PapelRepository papelRepository) {
        this.papelRepository = papelRepository;
    }

    @Test
    public void insercaoPapelTest() {
        Papel papel = new Papel();
        papel.setDescricao(descricao);
        papelRepository.save(papel);
        assertNotNull(papel.getId());
    }

    @Test
    public void buscaPapelTest() {
        Papel papel = new Papel();
        papel.setDescricao(descricao);
        papelRepository.save(papel);
        Papel expected = papelRepository.findById(papel.getId()).get();
        assertEquals(expected, papel);

    }

}

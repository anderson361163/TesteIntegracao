package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	void deveriaEncontrarUsuarioLocazalido() {
		Usuario usuario = criarUsuario();
		
		
		Usuario localizado = this.dao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(localizado);
	}
	
	@Test
	void naoDeveriaEncontrarUsuarioNaoCadastrado() {
		criarUsuario();
		EntityManager em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		Assert.assertThrows(NoResultException.class, ()->this.dao.buscarPorUsername("Anderson"));
	}
	
	void deveriaRemoverUmUsuario() {
		Usuario usuario = criarUsuario();
		dao.deletar(usuario);
		Assert.assertThrows(NoResultException.class, ()->this.dao.buscarPorUsername(usuario.getNome()));		
	}
	
	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "1234567");
		em.persist(usuario);
		return usuario;
	}
	
	

}

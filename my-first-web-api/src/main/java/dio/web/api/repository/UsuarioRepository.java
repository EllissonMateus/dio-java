package dio.web.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;


@Repository
public class UsuarioRepository{
	
	private Usuario usuario;

	
	public void save(Usuario usuario) {
		if(usuario.getLogin() == null) {
			throw new CampoObrigatorioException("Login");
		}
		
		if(usuario.getPassword() == null) {
			throw new CampoObrigatorioException("Password");
		}
		
		if(usuario.getId() == null) {
			System.out.println("SAVE - Recebendo o usuário na camada de repsitório");
		}else {
			System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
		}
		
		System.out.println(usuario);
	}
	
	
	public void deteteById(Integer id) {
		System.out.println(String.format("DELETE/id - Recebendo o id : %d para excluir um usuário" + id));
		System.out.println(id);
	}
	
	
	public List<Usuario> findAll(){
		System.out.println("LIST - Listando os usuarios do sistema");
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ellisson","password"));
		usuarios.add(new Usuario("Mateus", "password"));
		return usuarios;
	}
	
	
	public Usuario findById(Integer id){
		System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
		return new Usuario("Ellisson", "123456");
	}
	
	public Usuario findByUsername(String username) {
		System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", username));
		return new Usuario("Ellisson", "123456");
	}
	
	
}

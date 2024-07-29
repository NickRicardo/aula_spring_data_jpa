package dio_aula.repository;

import dio_aula.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //Query Method - Retorna a lista de usuários contendo a parte do name
    List<User> findByNameContaining(String name);


    //Query Override - Retorna a lista de usuários contendo a parte do name
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);


    //Query Method - Retorna um usuário pelo campo username
    User findByUsername(String username);
}

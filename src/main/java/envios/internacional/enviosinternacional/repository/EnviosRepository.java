package envios.internacional.enviosinternacional.repository;
import envios.internacional.enviosinternacional.model.Envios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnviosRepository extends JpaRepository<Envios, Long> {
}

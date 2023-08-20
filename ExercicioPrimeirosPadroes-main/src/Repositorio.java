import java.util.List;

public interface Repositorio {

    void carregaArquivo();
    
    // RegistroDoTempo findById(Date data);

    List<RegistroDoTempo> findAll();



}

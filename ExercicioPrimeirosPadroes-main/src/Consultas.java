import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class Consultas<T> {
    private List<RegistroDoTempo> registros;
    private String nArq;
    private Predicate<RegistroDoTempo> consulta;

    public Consultas(){
        registros = new LinkedList<>();
        this.nArq = "poa_temps.txt";
        RepositorioArquivoTempo rep = new RepositorioArquivoTempo(nArq);
        registros = rep.findAll();
        consulta = r->r.getTempMaxima() > 20.0;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }

    public List<String> diasEmQue(){

        List<Data> aux = new LinkedList<>();

        List<String> datas = new LinkedList<>();
                    
            datas = registros.stream()
            .filter(consulta)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno() + ";")
            .toList();

            return datas;

    }

    private void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta){
        this.consulta = consulta;
    }
}

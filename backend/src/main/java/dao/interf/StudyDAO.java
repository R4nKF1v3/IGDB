package dao.interf;

import model.Game;
import model.Study;

import java.util.List;

public interface StudyDAO {
    void guardar(Study study);
    Study recuperarJuegoPorNombre(String name);
    void actualizar(Study Study);
    Study recuperar(Long id);
    List<Game>gameOfStudy(String name);
}

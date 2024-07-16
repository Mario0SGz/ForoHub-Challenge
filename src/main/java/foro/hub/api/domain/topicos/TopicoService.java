package foro.hub.api.domain.topicos;

import foro.hub.api.domain.cursos.Curso;
import foro.hub.api.domain.cursos.CursoRepository;
import foro.hub.api.domain.usuarios.Usuario;
import foro.hub.api.domain.usuarios.UsuarioRepository;
import foro.hub.api.infra.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public TopicoDTO createTopico(DatosRegistroTopico registroTopico) {
        Usuario usuario = usuarioRepository.findById(registroTopico.autorId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Curso curso = cursoRepository.findById(registroTopico.cursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        Topico topico = new Topico(registroTopico, usuario, curso);
        topicoRepository.save(topico);
        return convertirTopico(topico);
    }

    private TopicoDTO convertirTopico(Topico topico) {
        return new TopicoDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getId(),
                topico.getAutor().getNombre(),
                topico.getCurso().getId(),
                topico.getCurso().getNombre()
        );
    }
}

package foro.hub.api.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long autorId,
        String autorNombre,
        Long cursoId,
        String cursoNombre
) {
}

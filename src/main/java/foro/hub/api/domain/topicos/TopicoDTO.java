package foro.hub.api.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id, @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        //@NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        Long autorId,
        String nombre, @NotNull
        Long cursoId,
        String s) {
}

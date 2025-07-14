package org.oab.catracaoab.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponseDTO {
    int eventosTotal;
    int usuariosTotal;
    long usuariosPendenteTotal;
    long usuariosAprovadoTotal;

}

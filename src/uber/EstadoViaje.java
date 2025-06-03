package uber;

public enum EstadoViaje {
    SIN_ASIGNAR,    // No hay chofer asignado
    PENDIENTE_ACEPTAR_CHOFER,   // Asignado un chofer, esperando conformación o buscar otro chofer
    ACEPTADO,   // NOTE: Un pendiente debería estar en curso inmediatamente, considerar si este estado es necesario
    EN_CURSO,
    FINALIZADO,
    CANCELADO_PASAJERO,
    CANCELADO_CHOFER,
    CANCELADO_SISTEMA   // NOTE: La cancelación por sistema es un comodín en caso de fallos o errores.
}
package cl.bicevida.Documento.utils;

import static cl.bicevida.Utils.Constants.DEBE_POSEER_MAXIMO;
import static cl.bicevida.Utils.Constants.DEBE_POSEER_MINIMO;

public class Documento_Constants {

    public static final String descripcionJson = "descripcion";
    public static final int minLongitudDescripcion = 10;
    public static final int maxLongitudDescripcion = 250;
    public static final String descripcionSize = descripcionJson + DEBE_POSEER_MINIMO + minLongitudDescripcion + DEBE_POSEER_MAXIMO + maxLongitudDescripcion;

    public static final String pathJson = "path";
    public static final int minLongitudPath = 5;
    public static final int maxLongitudPath = 500;
    public static final String pathSize = pathJson + DEBE_POSEER_MINIMO + minLongitudPath + DEBE_POSEER_MAXIMO + maxLongitudPath;

    public static  final String usuarioActualizacionJson = "usuarioActualizacion";
    public static  final int usuarioActualizacionJsonMin = 3;
    public static  final int usuarioActualizacionJsonMax = 250;
    public static  final String usuarioActualizacionJsonMsg = usuarioActualizacionJson + DEBE_POSEER_MINIMO + usuarioActualizacionJsonMin + DEBE_POSEER_MAXIMO + usuarioActualizacionJsonMax;

    public static final String usuarioCreacionJson = "usuarioCreacion";
    public static final int usuarioCreacionMin = 3;
    public static final int usuarioCreacionMax = 250;
    public static final String usuarioCreacionSize = usuarioCreacionJson + DEBE_POSEER_MINIMO + usuarioCreacionMin + DEBE_POSEER_MAXIMO + usuarioCreacionMax;

}

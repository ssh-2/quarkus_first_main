package cl.bicevida.Utils;

public class Constants {


    public static final String ERROR_SOLO_LETRAS_NUMEROS_GUION = "solo acepta letras, numeros y el guion (-)";
    public static String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static String NOT_FOUND_BY_ID = "No se encontro data con el ID: ";

    public static String ERROR_CLASS = "ErrorClass: ";

    public static String ERROR_MSG = "ErrorMsg: ";

    public static String CONSULTANDO_ID_RUTA = "[RUTA] [GET] consultando el ID: ";

    public static String CONSULTANDO_ID_CONTROLLER = "[CONTROLLER] [GET] consultando el ID: ";

    public static String CONSULTANDO_ID_INFRAESTRUCTURE = "[INFRAESTRUCTURE] [GET] consultando el ID: ";

    public static String REGISTRO_ELIMINADO = "Se ha eliminado con éxito el registro con el ID: ";

    public final static String REGEX_SOLO_LETRAS_TRIM = "^(?!\\s)^[a-zA-Z ]{1,250}[^\\s]";

    public final static String REGEX_LETRAS_Y_NUMEROS_Y_GUION = "^(?!\\s)^[a-zA-Z0-9\\- ]{1,250}[^\\s]";

    public final static String REGEX_SOLO_NUMEROS = "^(?!\\s)^[0-9]+$";

    public final static String REGEX_SOLO_NUMEROS_K = "^(?!\\s)^[0-9K]+$";

    public final static String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public final static String REGEX_FECHA_YEAR_MES_DIA = "^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$";

    public final static String ERROR_FORMATO_SOLO_NUMEROS = " solo acepta números";

    public final static String ERROR_FORMATO_SOLO_NUMEROS_K = " solo acepta números y la K mayúscula";

    public final static String ERROR_FORMATO_EMAIL = " no tiene un formato válido";

    public final static String ERROR_FORMATO_FECHA = " debe ser en formato Año-mes-dia Ejm:(2023-01-31)";

    public final static String DEBE_POSEER_MINIMO = " debe contar con caracteres mínimos: ";

    public final static String DEBE_POSEER_MAXIMO = " y máximos: ";

    public final static String ES_REQUERIDO = " es requerido";

    public final static String RUT_INVALIDO = " El Rut y el DV no corresponden";

    public final static String ERROR_FORMATO_SOLO_LETRAS = " solo acepta letras y no acepta espacios al comienzo o al final";
}

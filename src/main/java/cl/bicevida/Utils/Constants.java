package cl.bicevida.Utils;

public class Constants {

    public static String INTERNAL_SERVER_ERROR = "Servicio no disponible";
    public static String NOT_FOUND_BY_ID = "No se encontro data con el ID: ";

    public static String ERROR_CLASS = "ErrorClass: ";

    public static String ERROR_MSG = "ErrorMsg: ";

    public static String CONSULTANDO_ID_RUTA = "[RUTA] [GET] consultando el ID: ";

    public static String CONSULTANDO_ID_CONTROLLER = "[CONTROLLER] [GET] consultando el ID: ";

    public static String CONSULTANDO_ID_INFRAESTRUCTURE = "[INFRAESTRUCTURE] [GET] consultando el ID: ";

    public static String REGISTRO_ELIMINADO = "Se ha eliminado con exito el registro con el ID: ";

    public final static String REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO = "^(?!\\s)^[a-zA-Z ]+$";

    public final static String DEBE_POSEER_MINIMO = " debe contar con caracteres minimos: ";

    public final static String DEBE_POSEER_MAXIMO = " y maximos: ";

    public final static String ES_REQUERIDO = " es requerido";
    public final static String ERROR_FORMATO_SOLO_LETRAS = " solo acepta letras y no acepta espacio en blanco al comienzo";
}

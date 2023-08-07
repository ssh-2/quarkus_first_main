package cl.bicevida.Parentesco.utils;

import static cl.bicevida.Utils.Constants.*;

public class Constants_Parentesco {

    //ID PERSONA
    public static final  String idParienteParentescoJson = "idPersona";
    public static final int idParienteParentescoJson_MIN = 1;
    public static final int idParienteParentescoJson_MAX = 250;
    public static final  String idParienteParentescoJson_MSG_SIZE = idParienteParentescoJson + DEBE_POSEER_MINIMO + idParienteParentescoJson_MIN + DEBE_POSEER_MAXIMO + idParienteParentescoJson_MAX;
    public static final String idParienteParentescoJson_MSG_REQUIRED = idParienteParentescoJson + ES_REQUERIDO;
    public static final String idParienteParentescoJson_MSG_PATTERN = idParienteParentescoJson + ERROR_FORMATO_SOLO_NUMEROS;


    //ID DEL PARIENTE
    public static final  String idParienteRelacionParentescoJson = "idPariente";
    public static final int idParienteRelacionParentescoJson_MIN = 1;
    public static final int idParienteRelacionParentescoJson_MAX = 250;
    public static final  String idParienteRelacionParentescoJsonMSG_SIZE = idParienteRelacionParentescoJson + DEBE_POSEER_MINIMO + idParienteRelacionParentescoJson_MIN + DEBE_POSEER_MAXIMO + idParienteRelacionParentescoJson_MAX;
    public static final String idParienteRelacionParentescoJsonMSG_REQUIRED = idParienteRelacionParentescoJson + ES_REQUERIDO;
    public static final String idParienteRelacionParentescoJsonMSG_PATTERN = idParienteRelacionParentescoJson + ERROR_FORMATO_SOLO_NUMEROS;



    //ID Del Parentesco entre ambos
    public static  final String idTipoParentescoParentescoJson = "idParentesco";
    public static final int idTipoParentescoParentescoJson_MIN = 1;
    public static final int idTipoParentescoParentescoJson_MAX = 250;
    public static final  String idTipoParentescoParentescoJsonMSG_SIZE = idTipoParentescoParentescoJson + DEBE_POSEER_MINIMO + idTipoParentescoParentescoJson_MIN + DEBE_POSEER_MAXIMO + idTipoParentescoParentescoJson_MAX;
    public static final String idTipoParentescoParentescoJsonMSG_REQUIRED = idTipoParentescoParentescoJson + ES_REQUERIDO;
    public static final String idTipoParentescoParentescoJsonMSG_PATTERN = idTipoParentescoParentescoJson + ERROR_FORMATO_SOLO_NUMEROS;




    //Esta vigente la relacion entre los dos?
    public static final  String vigenteParentescoJson = "vigente";


    //Participacion
    public static final  String participacionParentescoJson = "participacion";
    public static final int participacionParentescoJson_MIN = 1;
    public static final int participacionParentescoJson_MAX = 250;
    public static final  String participacionParentescoJsonMSG_SIZE = participacionParentescoJson + DEBE_POSEER_MINIMO + participacionParentescoJson_MIN + DEBE_POSEER_MAXIMO + participacionParentescoJson_MAX;
    public static final String participacionParentescoJsonMSG_PATTERN = participacionParentescoJson + ERROR_FORMATO_SOLO_NUMEROS;


    //Comentario
    public static final  String comentarioParentescoJson = "comentario";
    public static final int comentarioParentescoJson_MIN = 1;
    public static final int comentarioParentescoJson_MAX = 250;
    public static final  String comentarioParentescoJsonMSG_SIZE = comentarioParentescoJson + DEBE_POSEER_MINIMO + comentarioParentescoJson_MIN + DEBE_POSEER_MAXIMO + comentarioParentescoJson_MAX;


    //Usuario Actualizacion
    public static  final String usuarioActualizacionParentescoJson = "usuarioActualizacion";
    public static  final int usuarioActualizacionParentescoJsonMin = 3;
    public static  final int usuarioActualizacionParentescoJsonMax = 250;
    public static  final String usuarioActualizacionParentescoJsonMsg = usuarioActualizacionParentescoJson + DEBE_POSEER_MINIMO + usuarioActualizacionParentescoJsonMin + DEBE_POSEER_MAXIMO + usuarioActualizacionParentescoJsonMax;
    public static final String usuarioActualizacionParentescoJsonMSG_REQUIRED = usuarioActualizacionParentescoJson + ES_REQUERIDO;


    //Usuario Creacion
    public static final String usuarioCreacionParentescoJson = "usuarioCreacion";
    public static final int usuarioCreacionParentescoMin = 3;
    public static final int usuarioCreacionParentescoMax = 250;
    public static final String usuarioCreacionParentescoSize = usuarioCreacionParentescoJson + DEBE_POSEER_MINIMO + usuarioCreacionParentescoMin + DEBE_POSEER_MAXIMO + usuarioCreacionParentescoMax;
    public static final String usuarioCreacionParentescoJsonMSG_REQUIRED = usuarioCreacionParentescoJson + ES_REQUERIDO;


    public static final String idPersona_Relacion_Json = "idPersona";
    public static final int idPersona_Relacion_Min = 1;
    public static final int idPersona_Relacion_Max = 250;
    public static final String idPersona_Relacion_Size = idPersona_Relacion_Json + DEBE_POSEER_MINIMO + idPersona_Relacion_Min + DEBE_POSEER_MAXIMO + idPersona_Relacion_Max;


    public static final String idPariente_Relacion_Json = "idPariente";
    public static final int idPariente_Relacion_Min = 1;
    public static final int idPariente_Relacion_Max = 250;
    public static final String idPariente_Relacion_Size = idPariente_Relacion_Json + DEBE_POSEER_MINIMO + idPariente_Relacion_Min + DEBE_POSEER_MAXIMO + idPariente_Relacion_Max;


}

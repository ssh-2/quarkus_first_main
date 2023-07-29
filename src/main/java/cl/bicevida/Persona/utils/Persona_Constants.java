package cl.bicevida.Persona.utils;

import static cl.bicevida.Utils.Constants.DEBE_POSEER_MAXIMO;
import static cl.bicevida.Utils.Constants.DEBE_POSEER_MINIMO;

public class Persona_Constants {

    public static final String rutJson = "rut";
    public static final int rutMin = 6;
    public static final int rutMax = 8;
    public static final String rutSize = rutJson + DEBE_POSEER_MINIMO + rutMin + DEBE_POSEER_MAXIMO + rutMax;

    public static final String dvJson = "dv";
    public static final int dvMax = 1;
    public static final String dvSize = dvJson + " requiere solo: " + dvMax + " caracter; desde el 0 al 9 o la K mayúscula, sin el guion";

    public static final String nombresRazonSocialJson = "nombresRazonSocial";
    public static final int nombresRazonSocialMin = 3;
    public static final int nombresRazonSocialMax = 250;
    public static final String nombresRazonSocialSize = nombresRazonSocialJson + DEBE_POSEER_MINIMO + nombresRazonSocialMin + DEBE_POSEER_MAXIMO + nombresRazonSocialMax;

    public static final String apellido1Json = "apellido1";
    public static final int apellido1Min = 3;
    public static final int apellido1Max = 250;
    public static final String apellido1Size = apellido1Json + DEBE_POSEER_MINIMO + apellido1Min + DEBE_POSEER_MAXIMO + apellido1Max;

    public static final String apellido2Json = "apellido2";
    public static final int apellido2Min = 3;
    public static final int apellido2Max = 250;
    public static final String apellido2Size = apellido2Json + DEBE_POSEER_MINIMO + apellido2Min + DEBE_POSEER_MAXIMO + apellido2Max;

    public static final String sexoJson = "sexo";
    public static final int sexoMin = 3;
    public static final int sexoMax = 250;
    public static final String sexoSize = sexoJson + DEBE_POSEER_MINIMO + sexoMin + DEBE_POSEER_MAXIMO + sexoMax;

    public static final String emailJson = "email";
    public static final int emailMin = 3;
    public static final int emailMax = 250;
    public static final String emailSize = emailJson + DEBE_POSEER_MINIMO + emailMin + DEBE_POSEER_MAXIMO + emailMax;

    public static final String tipo_personaJson = "idTipoPersona";
    public static final int tipo_personaMin = 1;
    public static final int tipo_personaMax = 2;
    public static final String tipo_personaSize = tipo_personaJson + DEBE_POSEER_MINIMO + tipo_personaMin + DEBE_POSEER_MAXIMO + tipo_personaMax;

    public static final String usuarioCreacionJson = "usuarioCreacion";
    public static final int usuarioCreacionMin = 3;
    public static final int usuarioCreacionMax = 250;
    public static final String usuarioCreacionSize = usuarioCreacionJson + DEBE_POSEER_MINIMO + usuarioCreacionMin + DEBE_POSEER_MAXIMO + usuarioCreacionMax;


    public static final String fechaNacimientoJson = "fechaNacimiento";

    public static final String idPersonaLegacyJson = "idPersonaLegacy";
    public static  final int idPersonaLegacyJsonMin = 1;
    public static  final int idPersonaLegacyJsonMax = 250;
    public static  final String idPersonaLegacyJsonSizeMsg = idPersonaLegacyJson + DEBE_POSEER_MINIMO + idPersonaLegacyJsonMin + DEBE_POSEER_MAXIMO + idPersonaLegacyJsonMax;


    public static  final String usuarioActualizacionJson = "usuarioActualizacion";
    public static  final int usuarioActualizacionJsonMin = 3;
    public static  final int usuarioActualizacionJsonMax = 250;
    public static  final String usuarioActualizacionJsonMsg = usuarioActualizacionJson + DEBE_POSEER_MINIMO + usuarioActualizacionJsonMin + DEBE_POSEER_MAXIMO + usuarioActualizacionJsonMax;



    public static  final String direccionJson = "direccion";
    public static  final int direccionJsonMin = 3;
    public static  final int direccionJsonMax = 250;
    public static  final String direccionJsonSizeMsg = direccionJson + DEBE_POSEER_MINIMO + direccionJsonMin + DEBE_POSEER_MAXIMO + direccionJsonMax;


    public static final String emailODireccionRequeridos = "Debes enviar el email o la direccion para poder contactar a la persona";
}

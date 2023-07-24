package cl.bicevida.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class RutValidation {

    public boolean isAValidRut(String rutIn, String dvIn) {

        boolean validacion = false;

        int rutAux = Integer.parseInt(rutIn);
        char dv = dvIn.charAt(0);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

        return validacion;

    }
}

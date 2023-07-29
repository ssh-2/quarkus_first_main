package cl.bicevida.Utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.spi.InternalServerErrorException;

import static cl.bicevida.Utils.Constants.RUT_INVALIDO;

@ApplicationScoped
@Slf4j
public class RutValidation {

    public void isAValidRut(String rutIn, String dvIn) {
        try {
            log.info("Validando rut [" + rutIn + "] DV [" + dvIn + "]");
            boolean isValid = false;

            int rutAux = Integer.parseInt(rutIn);
            char dv = dvIn.charAt(0);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                isValid = true;
            }

            if (!isValid) {
                throw new BadRequestException(RUT_INVALIDO + "  [" + rutIn + "-" + dvIn + "]");
            }
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al validar el rut: " + e.getMessage());
        }
    }
}

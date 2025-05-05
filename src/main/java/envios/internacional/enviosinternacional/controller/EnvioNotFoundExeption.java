package envios.internacional.enviosinternacional.controller;

public class EnvioNotFoundExeption extends RuntimeException {
    public EnvioNotFoundExeption(String message) {
        super(message);
    }
    public EnvioNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
}

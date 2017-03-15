package ch09.ex03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mary-mogreen.
 */
public class MultipleExceptions {
    public void process() throws FileNotFoundException, UnknownHostException {
        Logger logger = Logger.getGlobal();
        try {
            if (logger.isLoggable(Level.FINEST))
                throw new FileNotFoundException();
            throw new UnknownHostException();
        } catch (FileNotFoundException | UnknownHostException ex) {
            logger.log(Level.SEVERE, "...", ex);
            throw ex;
        }
    }
}

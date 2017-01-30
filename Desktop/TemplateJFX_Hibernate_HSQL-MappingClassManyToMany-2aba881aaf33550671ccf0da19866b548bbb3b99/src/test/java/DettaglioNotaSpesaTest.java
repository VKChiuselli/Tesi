import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.service.NotaSpesaService;
import com.nsi.rsni.service.TipoSpesaService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by acerioni on 06/09/2016.
 */
public class DettaglioNotaSpesaTest {

    @Test
    public void inserisciNoteSpese() {

        NotaSpesaService notaSpesaService = new NotaSpesaService();

        //@TODO
        String id = notaSpesaService.inserisciNotaSpesa("ciccio", "1111111", "bello", "partenza1", "ritorno1", "ritopar1");

        assertTrue(id != null);


    }












}

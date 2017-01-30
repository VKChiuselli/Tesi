import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.service.NotaSpesaService;
import com.nsi.rsni.service.TipoSpesaService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by acerioni on 13/12/2016.
 */
public class DettaglioTipoSpesaTest {

    @Test
    public void inserisciTipiSpeseNoteSpese()

    {
        TipoSpesaService tipoSpesaService = new TipoSpesaService();
        String id_tipo_spesa = null;
        try {
            id_tipo_spesa = tipoSpesaService.insertTipoSpesa("benza", "1222", "22");
        } catch (Exception e) {
            e.printStackTrace();
        }

        NotaSpesa notaSpesa = new NotaSpesa();
        TipoSpesa tipoSpesa = tipoSpesaService.getById(id_tipo_spesa);
        NotaSpesaService notaSpesaService = new NotaSpesaService();
        String id_nota_spesa = notaSpesaService.inserisciNotaSpesa("ciccio", "1111111", "bello", "partenza1", "ritorno1", "ritopar1");
        notaSpesa = notaSpesaService.getById(id_nota_spesa);



    }
}

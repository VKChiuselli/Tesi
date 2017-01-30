import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.TipoSpesaFx;
import com.nsi.rsni.service.NotaSpesaService;
import com.nsi.rsni.service.NotaSpesaTipoSpesaService;
import com.nsi.rsni.service.TipoSpesaService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by acerioni on 13/12/2016.
 */
public class NotaSpesaTipoSpesaTest {

    @Test
    public void inserisciNotaSpesaTipoSpesa(){

        NotaSpesaTipoSpesaService notaSpesaTipoSpesaService = new NotaSpesaTipoSpesaService();
        NotaSpesaService notaSpesaService = new NotaSpesaService();
        TipoSpesaService tipoSpesaService = new TipoSpesaService();

        String id_nota_spesa = notaSpesaService.inserisciNotaSpesa("Alessandra","4537","Ufficio 2 Torri","Serra","Roma","Lungo");
        NotaSpesa notaSpesa = notaSpesaService.getById(id_nota_spesa);

        String id_tipo_spesa = tipoSpesaService.insertTipoSpesa("Gas","14.5","22%");
        TipoSpesa tipoSpesa = tipoSpesaService.getById(id_tipo_spesa);

        String id_nota_spesa_tipo_spesa = notaSpesaTipoSpesaService.inserisciNotaSpesaTipoSpesa(notaSpesa,tipoSpesa,"34000","1%");

        assertNotNull(id_nota_spesa_tipo_spesa);

    }
}

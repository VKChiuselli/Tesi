import com.nsi.rsni.dao.impl.NotaSpesaDaoImpl;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import com.nsi.rsni.service.NotaSpesaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public class ListaNotaSpesaTest {


    //metodo che ritorna tutte le istanze caricate nel db delle nota spesa

    @Test
    public void getListaNotaSpesa() throws Exception {

        NotaSpesaFx notaSpesaFx1 = new NotaSpesaFx();

        notaSpesaFx1.set_agente("ciccio");
        notaSpesaFx1.set_matricola("1111111");
        notaSpesaFx1.set_ufficio("bello");
        notaSpesaFx1.set_partenza("partenza1");
        notaSpesaFx1.set_ritorno("ritorno1");
        notaSpesaFx1.set_viaggio("ritopar1");

        NotaSpesaFx notaSpesaFx2 = new NotaSpesaFx();


        notaSpesaFx2.set_agente("ciccia2");
        notaSpesaFx2.set_matricola("222222");
        notaSpesaFx2.set_ufficio("bella2");
        notaSpesaFx2.set_partenza("partenza2");
        notaSpesaFx2.set_ritorno("ritorno2");
        notaSpesaFx2.set_viaggio("ritapara2");



        NotaSpesaService notaSpesaService = new NotaSpesaService();




        String id1=   notaSpesaService.inserisciNotaSpesa("ciccio", "1111111", "bello", "partenza1","ritorno1", "ritopar1");
        String id2=  notaSpesaService.inserisciNotaSpesa("ciccia2", "222222", "bella2", "partenza2","ritorno2", "ritapara2");


        System.out.println("id1 e id2  \n" + id1 + " \nMAROOOOOOOOOOOOOOOOOOOOOOO \n"+ id2);

        ObservableList<NotaSpesaFx> list = FXCollections.observableArrayList();
        list.add(notaSpesaFx1);
        list.add(notaSpesaFx2);
        ObservableList<NotaSpesaFx> list2   =  notaSpesaService.getListNotaSpesaFx();


        if(list.equals(list2)){
            System.out.println("ci arrivo ed è vero");
        }
        else
        {
            System.out.println("arrivo ma nnon è vero");
        }


        assertNotNull(list);


    }


}

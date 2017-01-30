/**
 * <b> UserDAO.java
 *
 * <br>
 *
 * Classe dao per la gestione delle operazioni sul modulo utente.
 *
 */
package it.clever.testapp.tomcat.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.model.ClientiVO;
import it.clever.testapp.tomcat.business.model.UserVO;
import it.clever.testapp.tomcat.business.services.impl.ServiceFactory;
import it.clever.testapp.tomcat.business.utils.IApplicationConstants;

public class ClientiDAO {

    public ClientiDAO() {
    }

    /**
     * Metodo per l'autorizzaizone dell'utente nella sessione di login.
     */
    public boolean authorization(String username, String password) throws BusinessException {

        boolean authorized = false;

        //Ricerca della presenza dei dati di login inseriti.
        PreparedStatement pstmt = ServiceFactory.getInstance().getCurrentServiceLocal()
                .prepareStatement(IApplicationConstants.QUERY_FIND_USER_BY_USERNAME_PASSWORD);
        try {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                //Riga trovata, quindi l'utente ha accesso all'applicazione.
                authorized = true;
            } else {
                //Riga non trovata, quindi l'utente non � ancora registrato o i dati inseriti non sono validi.
                authorized = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BusinessException("Errore grave", e);
        }
        return authorized;
    }

    public List<ClientiVO> findAll() throws BusinessException {
        try {
            List<ClientiVO> retuserList = null;
            Statement stmt = ServiceFactory.getInstance().getCurrentServiceLocal()
                    .createStatement();
            ResultSet rs = stmt.executeQuery(IApplicationConstants.QUERY_FIND_All_CLIENTI);
            if (rs != null) {
                retuserList = new ArrayList<ClientiVO>();
                while (rs.next()) {
                    ClientiVO retuser = new ClientiVO();
                    retuser.setId_cliente(rs.getLong("id_cliente"));
                    retuser.setCodice(rs.getString("codice"));
                    retuser.setRag_soc(rs.getString("rag_soc"));
                    retuser.setPiva(rs.getString("piva"));
                    retuser.setVersion(rs.getInt("version"));
                    retuserList.add(retuser);
                }
            }
            return retuserList;
        } catch (Exception e) {
            throw new BusinessException("[ClientiDAO.findAll]", e);
        }
    }
}

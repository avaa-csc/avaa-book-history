package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.tools.logging.AvaaLogger;

public class VanhatkirjatFinderImpl extends BasePersistenceImpl<Vanhatkirjat> implements VanhatkirjatFinder {
	
	private static AvaaLogger log = new AvaaLogger(VanhatkirjatFinderImpl.class.getName());
	public static final String DELETE_ALL_VANHATKIRJAT =
			VanhatkirjatFinder.class.getName() +
		        ".deleteAllVanhatkirjat";
	
	public boolean deleteAllVanhatkirjat() {
		Session session = null;
		int deletedAmt = 0;
	    try {
	        session = openSession();
	        String sql = CustomSQLUtil.get(DELETE_ALL_VANHATKIRJAT);
	        
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(true);
	        
	        deletedAmt = q.executeUpdate();
	        return true;
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	            return false;
	        }
	    } finally {
	        closeSession(session);
	        log.info("Deleted " + deletedAmt + " entries from database table vanhatkirjat");
	    }
	}

}

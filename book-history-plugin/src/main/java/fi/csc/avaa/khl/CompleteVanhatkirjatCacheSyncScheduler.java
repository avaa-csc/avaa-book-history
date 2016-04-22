/**
 * 
 */
package fi.csc.avaa.khl;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import fi.csc.avaa.tools.cache.CacheSyncScheduler;

/**
 * @author jmlehtin
 *
 */
public class CompleteVanhatkirjatCacheSyncScheduler extends CacheSyncScheduler {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(Message message) throws MessageListenerException {
		if(CompleteVanhatkirjatCache.syncAllBooksInDatabaseToCaches()) {
			log.info("Complete database to cache sync completed successfully!");
		} else {
			log.error("Complete database to cache sync failed!");
		}
	}

}

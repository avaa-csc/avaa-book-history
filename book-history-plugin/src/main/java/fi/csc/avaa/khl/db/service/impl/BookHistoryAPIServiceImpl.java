package fi.csc.avaa.khl.db.service.impl;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.security.ac.AccessControlled;
import fi.csc.avaa.khl.db.service.base.BookHistoryAPIServiceBaseImpl;

/**
 * The implementation of the book history a p i remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.csc.avaa.khl.db.service.BookHistoryAPIService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.BookHistoryAPIServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.BookHistoryAPIServiceUtil
 */
@JSONWebService("bookHistoryAPI")
public class BookHistoryAPIServiceImpl extends BookHistoryAPIServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link fi.csc.avaa.khl.db.service.BookHistoryAPIServiceUtil} to access the book history a p i remote service.
     */

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getHelloWorld")
	public String getHelloWorld() {
		return "Hello world!";
	}
}
